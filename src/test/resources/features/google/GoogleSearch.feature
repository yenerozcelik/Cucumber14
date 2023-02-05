Feature: Testing the Google Search Functionality
  #feature is giving you general information of what you are testing
Scenario: Happy Path Google Search Functionality
  # Scenario is test case that subFeature of Feature
  Given User navigates to the Google
  When  User searches for Techtorial
  Then User gets more than ten links on the google page.

Scenario: Happy Path Google Search Result Validation
  Given User navigates to the Google
  When user searches for 'Kyrgyz food in Chicago'
  Then user validates the result is more than 5000000

Scenario: Happy Path Google Search Result Time
  Given User navigates to the Google
  When user searches for 'Kyrgyz food in Japan'
  Then user validates the loading time is less than 1.0 sec

