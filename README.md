webdriver-accessibility
=======================

webdriver-accessibility is a Java tool that helps you run accessibility audits directly using [selenium webdriver][1]. It relies on [GoogleChrome accessibility-developer-tools][2] to run the audit. 
Once the audit is run, the tool returns a meaningful Java object which can then later used for reporting. The tool also takes a screenshot of your
webpage and marks errors & warnings. Currently errors are bordered with red and warnings with yellow. 
This project is decoupled from Webdriver project in the sense that user would need to pass along
a WebDriver object. It also assumes user is already on a page which he/she intends to run accessibility audits using this tool
All you need to do in your project is

```
   AccessibilityScanner scanner = new AccessibilityScanner(driver);
   Map<String, Object> audit_report = scanner.runAccessibilityAudit();
```
Interpreting audit report
===========================
Once you run ```runAccessibilityAudit()``` method it returns a ```Map<String, Object> audit_report``` and it contains following keys,
```
  /** @type {List<Result>} */
  error, //contains all errors
  /** @type {List<Result>} */
  warning, //contains all warnings
  /** @type {String} */
  plain_report, //contains plain report
  /** @type {byte[]} */
  screenshot, //contains screenshot for reporting
```
```Result``` object is made of following,
```
 /** @type {String} */
  rule, //contains specific rule information
  /** @type {List<String>} */
  elements, //contains all element locators with errors/warnings
  /** @type {String} */
  information_link, //link to [GoogleChrome accessibility-developer-tools audit rules][3] wiki for more details
```
[1]: https://code.google.com/p/selenium/wiki/GettingStarted "selenium webdriver"
[2]: https://github.com/GoogleChrome/accessibility-developer-tools "GoogleChrome accessibility-developer-tools"
[3]: https://github.com/GoogleChrome/accessibility-developer-tools/wiki/Audit-Rules "GoogleChrome accessibility-developer-tools audit rules"

Contributing: Fork the project and submit pull request if you like to add a feature/fix bugs etc.

Contact me directly
=======================
Twitter: @nileshdk 
Email: nilesh.cric@gmail.com

