
Feature: Fidexio Login feature
   User Story:

   1-Users can log in with valid credentials (We have 5 types of users but will test only 2 user: PosManager, SalesManager)

   2-"Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials

   3- "Please fill out this field" message should be displayed if the password or username is empty

   4-User land on the ‘reset password’ page after clicking on the "Reset password" link

   5-User should see the password in bullet signs by default

   6- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.

  Background: User  see the login page
    Given user is on the login page


  Scenario Outline: Positive Login
    When user enters  username "<Username>"
    And user enters  password "<Password>"
    And user clicks to login button
    Then user sees "<UserID>" in the title


    Examples: Search values
      | Username                | Password     | UserID         |
      | salesmanager35@info.com | salesmanager | Salesmanager35 |
      | salesmanager25@info.com | salesmanager | Salesmanager25 |
      | salesmanager55@info.com | salesmanager | Salesmanager55 |
      | posmanager35@info.com   | posmanager   | Posmanager35   |
      | posmanager75@info.com   | posmanager   | Posmanager75   |
      | posmanager101@info.com  | posmanager   | Posmanager101  |


  Scenario Outline: Negative Login Scenario with wrong email , true password
    When user enters username "<Username>"
    And user enters password "<Password>"
    And user clicks to login button
    Then user sees Wrong login/password  message


    Examples: Search values
      | Username                 | Password     |
      | salesmanagerx35@info.com | salesmanager |
      | xsalesmanager25@info.com | salesmanager |
      | Salesmanager55@info.com  | salesmanager |
      | posmanager35x@info.com   | posmanager   |
      | Posmanager75@info.com    | posmanager   |
      | posmanager101x@info.com  | posmanager   |


  Scenario Outline: Negative Login Scenario with wrong password
    When user enters username "<Username>"
    And user enters password "<Password>"
    And user clicks to login button
    Then user sees Warning  message


    Examples: Search values
      | Username                | Password      |
      | salesmanager35@info.com | salesmanagerx |
      | salesmanager25@info.com | Salesmanager  |
      | salesmanager55@info.com | sallesmanager |
      | posmanager35@info.com   | posmanagerx   |
      | posmanager75@info.com   | posmanager75  |
      | posmanager101@info.com  | Posmanager    |


Scenario:Empty UsernameInput features and Empty passwordInput features
  When user enters empty username
  And  user enters empty password
  And user clicks to login button
  Then user sees Please fill out this field message



