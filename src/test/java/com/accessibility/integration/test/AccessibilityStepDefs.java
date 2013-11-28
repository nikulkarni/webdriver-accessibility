package com.accessibility.integration.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.accessibility.AccessibilityScanner;
import com.accessibility.Result;
import com.google.inject.Inject;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccessibilityStepDefs {
	private WebDriver driver;
	private AccessibilityScanner scanner;
	private Map<String, Object> audit_report;
	private Scenario scenario;
	private Logger log = Logger.getLogger(AccessibilityStepDefs.class);

	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;
	}

	@Inject
	public AccessibilityStepDefs(WebDriver driver, AccessibilityScanner scanner) {
		this.driver = driver;
		this.scanner = scanner;
	}

	@Given("^I navigate to url \"([^\"]*)\"$")
	public void I_navigate_to_url(String url) throws Throwable {
		driver.navigate().to(url);
	}

	@When("^I run accessibility audit$")
	public void I_run_accessibility_audit() throws Throwable {
		audit_report = scanner.runAccessibilityAudit();
		assertNotNull(audit_report);

		if (audit_report.containsKey("plain_report"))
			scenario.write(audit_report.get("plain_report").toString());
	}

	@SuppressWarnings("unchecked")
	@Then("^I am able to run the scanner successfully$")
	public void I_am_able_to_run_the_scanner_successfully() throws Throwable {
		if (audit_report.containsKey("error")) {
			List<Result> errors = (List<Result>) audit_report.get("error");

			for (Result error : errors) {
				log.info(error.getRule());//e.g. AX_TEXT_01 (Controls and media ....
				log.info(error.getUrl());//e.g. See https://github.com/GoogleChrome/accessibility-developer-tools/wiki....
				for (String element : error.getElements())
					log.info(element);//e.g. #myForm > P > INPUT
			}
			assertThat("No accessibility errors expected", errors.size(),
					equalTo(0));
		}
	}

	@After
	public void teaeDown(Scenario scenario) {
		try {
			if (audit_report != null && audit_report.containsKey("screenshot")) {
				final byte[] screenshot = (byte[]) audit_report
						.get("screenshot");
				scenario.embed(screenshot, "image/png");
			}
		} finally {
			driver.quit();
		}
	}
}
