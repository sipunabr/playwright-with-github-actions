Feature: Playwright with Cucumber and TestNG

  Scenario: Verify Google Title
    Given I navigate to "https://www.google.com"
    Then the page title should be "Google"