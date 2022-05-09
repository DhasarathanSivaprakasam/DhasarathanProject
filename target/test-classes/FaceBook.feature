 Feature: To validate the login functionality of facebook application

Scenario: To validate login with valid username and invalid password

      Given User has to launch the browser
      When User has to pass the valid username to the email field
      And User has to pass the Invalid Password to the Password field
      And User has to click the login button
      And User has to navigate to the Invalid credentials page
      Then User has to close the browser
      

