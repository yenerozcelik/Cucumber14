Feature: Testing  the registration of New User

  Scenario:Happy Path of Registration

      Given User navigates to AutomationExercise and validates title 'Automation Exercise'
      When User click sign up button and validates the 'New User Signup!' is visible
      And User provides username 'username56' and email adress 'usa70@emailadress.com' and click sign up button
      And User verify 'ENTER ACCOUNT INFORMATION' message is visible
      And User provides name ,email  , password 'password' , Date of birth '1' , month 'January', year '1983'
      And User selects Sign up for  our newsletter! and Receive special offers from our partners!
      And User provides 'First name', 'Last name', 'Company', 'Address', 'Address2', 'Country', 'State', 'City' , 'Zipcode', 'Mobile Number'
      Then User clicks Create Account button and validates 'ACCOUNT CREATED!'
      And User clicks Continue Button and validate Logged in as  username 'username56'
      Then User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
      And User clicks continue button

  Scenario: Positive Login(correct username and correct password)

      Given User navigates to AutomationExercise and validates title 'Automation Exercise'
      When User click sign up button and validates the 'New User Signup!' is visible
      And User provides username 'username64' and email adress 'usa104@emailadress.com' and click sign up button
      And User verify 'ENTER ACCOUNT INFORMATION' message is visible
      And User provides name ,email  , password 'password' , Date of birth '1' , month 'January', year '1983'
      And User selects Sign up for  our newsletter! and Receive special offers from our partners!
      And User provides 'First name', 'Last name', 'Company', 'Address', 'Address2', 'Country', 'State', 'City' , 'Zipcode', 'Mobile Number'
      Then User clicks Create Account button and validates 'ACCOUNT CREATED!'
      Then User navigates to AutomationExercise and validates title 'Automation Exercise'
      And User click logout button
      When User click sign up button and validates the 'Login to your account' is visible
      And User provides username 'usa104@emailadress.com' and email adress 'password' for login
      Then User clicks login button and validates  'Logged in as username' is visible
      Then User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible



