package com.accessibility.unit.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.accessibility.AccessibilityScanner;
import com.accessibility.Result;

public class AccessibilityTest {

	@Test
	public void parseCorrectReport() throws IOException {
		File file = new File("src/test/resources/results.txt");
		String content = FileUtils.readFileToString(file);
		AccessibilityScanner scanner = new AccessibilityScanner(null);

		List<Result> errors = scanner.parseReport(content, "Error:");
		List<Result> warnings = scanner.parseReport(content, "Warning:");
		assertThat(errors.size(), equalTo(1));
		assertThat(warnings.size(), equalTo(4));
	}

	@Test
	public void passInvalidFilterArgument() throws IOException {
		AccessibilityScanner scanner = new AccessibilityScanner(null);
		boolean isExceptionThrown = false;
		try {
			scanner.parseReport(null, "hello");
		} catch (IllegalArgumentException e) {
			isExceptionThrown = true;
		}
		assertThat("Illegal argument exception excepted", isExceptionThrown,
				equalTo(true));
	}

	@Test
	public void passnullReportContent() throws IOException {
		AccessibilityScanner scanner = new AccessibilityScanner(null);
		boolean isExceptionThrown = false;
		try {
			scanner.parseReport(null, "Error:");
		} catch (NullPointerException e) {
			isExceptionThrown = true;
		}
		assertThat("NullPointerException excepted", isExceptionThrown,
				equalTo(true));
	}
}
