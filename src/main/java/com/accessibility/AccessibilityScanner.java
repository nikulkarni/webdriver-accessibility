package com.accessibility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class AccessibilityScanner {

	private WebDriver driver;
	private JavascriptExecutor js;
	private Logger log = Logger.getLogger(AccessibilityScanner.class);
	private JsFactory jsFactory;

	public AccessibilityScanner(WebDriver driver) throws IOException {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		jsFactory = JsFactory.getInstance();

	}

	public Map<String, Object> runAccessibilityAudit() throws IOException {
		Map<String, Object> audit_report = new HashMap<String, Object>();
		driver.manage().window().maximize();
		js.executeScript(jsFactory.getAccessibility_content());
		String accessibility_tests = "var auditConfig = new axs.AuditConfiguration(); "
				+ "var results = axs.Audit.run(auditConfig);"
				+ "var auditResults = axs.Audit.auditResults(results);"
				+ "var report = axs.Audit.createReport(results);return report";
		String report = (String) js.executeScript(accessibility_tests);

		log.info(report);

		try {
			log.info(js.executeScript("$.active;"));
		} catch (WebDriverException e) {
			log.info("++++++++Injecting jQuery+++++++++++++");
			js.executeScript(jsFactory.getJquery_content());
		}

		List<Result> errors = parseReport(report, "Error:");
		List<Result> warnings = parseReport(report, "Warning:");

		decorateElements(errors, "red");
		decorateElements(warnings, "yellow");
		final byte[] screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		audit_report.put("error", errors);
		audit_report.put("warning", warnings);
		audit_report.put("screenshot", screenshot);
		audit_report.put("plain_report", report);
		return audit_report;
	}

	private void decorateElements(List<Result> results, String color) {
		for (Result result : results) {
			List<String> locators = result.getElements();
			addBorder(locators, result.getRule(), color);
		}
	}

	public List<Result> parseReport(String report, String filter_on) {
		if (filter_on.toLowerCase().contains("error"))
			filter_on = "Error:";
		else if (filter_on.toLowerCase().contains("warning"))
			filter_on = "Warning:";
		else
			throw new IllegalArgumentException(
					"Currently only support filtering on Error: and Warning:");
		if (report == null)
			throw new NullPointerException("Report to parse cannot be null");
		List<Result> parsed_result = new ArrayList<Result>();
		int start_error = report.indexOf(filter_on);
		while (start_error > 0) {
			Result result = new Result();
			int end = report.indexOf("\n\n", start_error);
			String error = report.substring(start_error + filter_on.length(),
					end).trim();
			result.setRule(error.substring(0, error.indexOf("\n")));
			String link = null;
			String[] locators;
			int element_start = error.indexOf("\n") + 1;
			String element;
			if (error.indexOf("See") > 0) {
				element = error.substring(element_start, error.indexOf("See"));
				link = error.substring(error.indexOf("See"));
			} else {
				element = error.substring(element_start);
			}
			locators = element.split("\n");
			result.setElements(Arrays.asList(locators));
			result.setUrl(link);
			parsed_result.add(result);
			start_error = report.indexOf(filter_on, end);
		}
		return parsed_result;
	}

	private void addBorder(List<String> locators, String rule, String color) {
		for (String locator : locators) {
			rule = "<p>" + rule + "</p>";
			String script = "$(\"" + locator
					+ "\").css(\"border\",\"5px solid " + color + "\")";
			js.executeScript(script);
		}
	}

}
