@regression
Feature: Testing Login Functionality of WebRorder Page

  Background: User navigates to page (this is just the description)
    Given User navigates to Weborder Page

  @smoke
  Scenario: Testing Positive Login(correct username and correct password)

   # Given User navigates to Weborder Page
    When user provides username 'guest1@microworks.com' and password 'Guest1!' for Weborder
    Then User validates the title 'ORDER DETAILS - Weborder' from homepage

  Scenario: Testing negative Login(Correct username and wrong password)
    #Given User navigates to Weborder Page
    When user provides username 'guest1@microworks.com' and password 'Ahmet' for Weborder
    Then User validates the error message 'Sign in Failed'

    @ahmet
  Scenario: Testing negative Login(wrong username and wrong password)
    #Given User navigates to Weborder Page
    When user provides username 'guest134@microworks.com' and password 'Ahmet' for Weborder
    Then User validates the error message 'Sign in Failed'
