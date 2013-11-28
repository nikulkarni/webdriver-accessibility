package com.accessibility.integration.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "json:target/accessibility.json", "pretty",
		"html:target/cucumber-html-report/accessibility" }, features = { "classpath:features/accessibility_audit.feature" }, monochrome = true, strict = true)
public class Run_AuditAccessibility_Test {

}
