Feature: Runs accessibility report and provides meaningful report

  Scenario: To test accessibility scanner
    Given I navigate to url "http://www.latlong.net/lat-long-dms.html"
    When I run accessibility audit
    Then I am able to run the scanner successfully
