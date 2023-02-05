# Navigate to the website and login successfully
#Validate the title the 'ORDER DETAILS' from order page
#Click Group Order box and Click Next button
#Send the word for Note to Invitees part
#send two gmail for Invite List
  #Choose my location is My House
#Validate the adress contains 3137 Laguna Street
#Click Create Group Order
#Validate View Group Order header


  @regression
Feature: WebOrder page food Order Functionality

  Background:
    Given User navigates to Weborder  and login succesfully
    And User validate the title 'ORDER DETAILS - Weborder' ORDER DETAILS from orderpage
    When User Clicks Group Order box and Click Next button
    And User Send the word 'I love cucumber' for note to Invitees section
    And  User sends e-mail address which are 'ahmet@gmail.com' and 'berkay@gmail.com' to invite list

    @smoke @ahmet
    Scenario:Testing the happy path food order for My house



      And User chooses the  delivery adress 'My House' and validates the adress '3137 Laguna Street'
      And user clicks the create Group Order button
      Then  User validates the header of page is 'View Group Order'

      @ahmet
  Scenario:Testing the happy path food order for Office


    And User chooses the  delivery adress 'Office' and validates the adress '2012 EMPIRE BLVD'
    And user clicks the create Group Order button
    Then  User validates the header of page is 'View Group Order'

