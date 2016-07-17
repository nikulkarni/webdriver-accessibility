package com.accessibility.examples.junit.webdriver.test;

import com.accessibility.AccessibilityScanner;
import com.accessibility.Result;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by nikulkarni on 7/16/16.
 */
public class WebDriverJunitTest {


    @Test
    public void simpleWebDriverAccessibilityTest() throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.netflix.com");

        AccessibilityScanner scanner = new AccessibilityScanner(driver);
        Map<String, Object> audit_report = scanner.runAccessibilityAudit();
        Logger log = Logger.getLogger(WebDriverJunitTest.class);
        if (audit_report.containsKey("plain_report")) {
            log.warn(audit_report.get("plain_report").toString());
        }

        if (audit_report.containsKey("error")) {
            List<Result> errors = (List<Result>) audit_report.get("error");

            for (Result error : errors) {
                log.info(error.getRule());//e.g. AX_TEXT_01 (Controls and media ....
                log.info(error.getUrl());//e.g. See https://github.com/GoogleChrome/accessibility-developer-tools/wiki....
                for (String element : error.getElements())
                    log.info(element);//e.g. #myForm > P > INPUT
            }

        }

        if (audit_report.containsKey("screenshot")) {
            final byte[] screenshot = (byte[]) audit_report
                    .get("screenshot");
            log.warn("Writing screenshot ");
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(screenshot));
            ImageIO.write(img, "png", new File("src/test/resources/accessibility-screenshot-report.png"));
        }
        driver.quit();
    }

}
