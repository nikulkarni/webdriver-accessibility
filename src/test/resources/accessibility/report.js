$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/accessibility_audit.feature");
formatter.feature({
  "id": "runs-accessibility-report-and-provides-meaningful-report",
  "description": "",
  "name": "Runs accessibility report and provides meaningful report",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 8954387000,
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
  "name": "I navigate to url \"http://www.latlong.net/lat-long-dms.html\"",
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
      "val": "http://www.latlong.net/lat-long-dms.html",
      "offset": 19
    }
  ],
  "location": "AccessibilityStepDefs.I_navigate_to_url(String)"
});
formatter.result({
  "duration": 3115884000,
  "status": "passed"
});
formatter.match({
  "location": "AccessibilityStepDefs.I_run_accessibility_audit()"
});
formatter.write("*** Begin accessibility audit results ***\nAn accessibility audit found \nWarnings:\nWarning: AX_FOCUS_01 (These elements are focusable but either invisible or obscured by another element) failed on the following element:\n#oauth2relay706404869\nSee https://github.com/GoogleChrome/accessibility-developer-tools/wiki/Audit-Rules#-ax_focus_01--these-elements-are-focusable-but-either-invisible-or-obscured-by-another-element for more information.\n\nWarning: AX_TEXT_02 (Images should have an alt attribute) failed on the following elements (1 - 5 of 32):\n#mapdiv \u003e .gm-style \u003e DIV \u003e DIV \u003e DIV:nth-of-type(5) \u003e DIV \u003e IMG\n#mapdiv \u003e .gm-style \u003e DIV \u003e DIV \u003e DIV:nth-of-type(6) \u003e DIV \u003e DIV \u003e IMG\n#mapdiv \u003e .gm-style \u003e DIV \u003e DIV \u003e DIV:nth-of-type(6) \u003e DIV \u003e DIV \u003e IMG:nth-of-type(2)\n#mapdiv \u003e .gm-style \u003e DIV \u003e DIV \u003e DIV:nth-of-type(6) \u003e DIV \u003e DIV:nth-of-type(2) \u003e IMG\n#mapdiv \u003e .gm-style \u003e DIV \u003e DIV \u003e DIV:nth-of-type(6) \u003e DIV \u003e DIV:nth-of-type(2) \u003e IMG:nth-of-type(2)\nSee https://github.com/GoogleChrome/accessibility-developer-tools/wiki/Audit-Rules#-ax_text_02--images-should-have-an-alt-attribute-unless-they-have-an-aria-role-of-presentation for more information.\n\nWarning: AX_COLOR_01 (Text elements should have a reasonable contrast ratio) failed on the following elements (1 - 4 of 4):\nHEADER \u003e .container \u003e .eleven.columns \u003e .nav \u003e UL \u003e LI \u003e A\nHEADER \u003e .container \u003e .eleven.columns \u003e .nav \u003e UL \u003e LI:nth-of-type(2) \u003e A\nHEADER \u003e .container \u003e .eleven.columns \u003e .nav \u003e UL \u003e LI:nth-of-type(3) \u003e A\nHEADER \u003e .container \u003e .eleven.columns \u003e .nav \u003e UL \u003e LI:nth-of-type(4) \u003e A\nSee https://github.com/GoogleChrome/accessibility-developer-tools/wiki/Audit-Rules#-ax_color_01--text-elements-should-have-a-reasonable-contrast-ratio for more information.\n\n\n*** End accessibility audit results ***");
formatter.result({
  "duration": 2883243000,
  "status": "passed"
});
formatter.match({
  "location": "AccessibilityStepDefs.I_am_able_to_run_the_scanner_successfully()"
});
formatter.result({
  "duration": 2289000,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1235074000,
  "status": "passed"
});
});