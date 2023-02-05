#navigate to the amazon
  #Search for iphone 14 pro max case
  #Validate the result contains 20000
  #Validate the all headers contain "iphone 14"

Feature: Testing the Amazon Search Functionality
  Scenario: Happy Path Amazon Search Functionality
    Given User navigates to the Amazon
    When  User searches for iphone "14 pro max case" on Amazon
    Then user validates the result is contain 20000
    And user validates all headers contain "iphone 14"

