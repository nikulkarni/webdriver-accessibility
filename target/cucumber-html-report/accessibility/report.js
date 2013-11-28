$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/accessibility_audit.feature");
formatter.feature({
  "id": "runs-accessibility-report-and-provides-meaningful-report",
  "description": "",
  "name": "Runs accessibility report and provides meaningful report",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 8656517000,
  "status": "passed"
});
formatter.scenario({
  "id": "runs-accessibility-report-and-provides-meaningful-report;to-test-accessibility-scanner",
  "description": "",
  "name": "To test accessibility scanner",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "I navigate to url \"file://localhost/Users/nikulkarni/Downloads/mypizza.html\"",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "I run accessibility audit",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "I am able to run the scanner successfully",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "arguments": [
    {
      "val": "file://localhost/Users/nikulkarni/Downloads/mypizza.html",
      "offset": 19
    }
  ],
  "location": "AccessibilityStepDefs.I_navigate_to_url(String)"
});
formatter.result({
  "duration": 339101000,
  "status": "passed"
});
formatter.match({
  "location": "AccessibilityStepDefs.I_run_accessibility_audit()"
});
formatter.write("*** Begin accessibility audit results ***\nAn accessibility audit found \nErrors:\nError: AX_TEXT_01 (Controls and media elements should have labels) failed on the following elements (1 - 5 of 27):\n#myForm \u003e P \u003e INPUT\n#myForm \u003e P \u003e INPUT:nth-of-type(2)\n#myForm \u003e P \u003e INPUT:nth-of-type(3)\n#myForm \u003e P \u003e INPUT:nth-of-type(4)\n#myForm \u003e P \u003e INPUT:nth-of-type(5)\nSee https://github.com/GoogleChrome/accessibility-developer-tools/wiki/Audit-Rules#-ax_text_01--controls-and-media-elements-should-have-labels for more information.\n\n\n*** End accessibility audit results ***");
formatter.result({
  "duration": 2000779000,
  "status": "passed"
});
formatter.match({
  "location": "AccessibilityStepDefs.I_am_able_to_run_the_scanner_successfully()"
});
formatter.result({
  "duration": 3832000,
  "status": "failed",
  "error_message": "java.lang.AssertionError: No accessibility errors expected\nExpected: \u003c0\u003e\n     but: was \u003c1\u003e\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\n\tat org.junit.Assert.assertThat(Assert.java:865)\n\tat com.accessibility.integration.test.AccessibilityStepDefs.I_am_able_to_run_the_scanner_successfully(AccessibilityStepDefs.java:68)\n\tat ✽.Then I am able to run the scanner successfully(features/accessibility_audit.feature:6)\n"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 3172971000,
  "status": "passed"
});
});