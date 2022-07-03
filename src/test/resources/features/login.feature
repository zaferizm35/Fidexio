@FIDE-983 @smoke
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

  @FIDE-977
  Scenario Outline: Positive Login
    When user enters valid username "<Username>"
    And user enters valid password "<Password>"
    And user clicks to login button
    Then user sees "<UserID>" in the title


    Examples: Search values we are going to be using in this scenario is as below table
      | Username                | Password     | UserID         |
      | salesmanager35@info.com | salesmanager | salesmanager35 |
      | salesmanager25@info.com | salesmanager | salesmanager25 |
      | salesmanager55@info.com | salesmanager | salesmanager55 |
      | posmanager35@info.com   | posmanager   | posmanager35   |
      | posmanager75@info.com   | posmanager   | posmanager75   |
      | posmanager101@info.com  | posmanager   | posmanager101  |

  @FIDE-978
  Scenario Outline: Negative Login Scenario with wrong email credentials
    When user enters username "<Username>"
    And user enters password "<Password>"
    And user clicks to login button
    Then user sees "<AlertMessage>" above Login Button


    Examples: Search values we are going to be using in this scenario is as below table
      | Username                 | Password     | AlertMessage         |
      | salesmanagerx35@info.com | salesmanager | Wrong login/password |
      | xsalesmanager25@info.com | salesmanager | Wrong login/password |
      | Salesmanager55@info.com  | salesmanager | Wrong login/password |
      | posmanager35x@info.com   | posmanager   | Wrong login/password |
      | Posmanager75@info.com    | posmanager   | Wrong login/password |
      | posmanager101x@info.com  | posmanager   | Wrong login/password |

  @FIDE-979
  Scenario Outline: Negative Login Scenario with wrong password credentials
    When user enters username "<Username>"
    And user enters password "<Password>"
    And user clicks to login button
    Then user sees "<AlertMessage>" above Login Button


    Examples: Search values we are going to be using in this scenario is as below table
      | Username                | Password      | AlertMessage         |
      | salesmanager35@info.com | salesmanagerx | Wrong login/password |
      | salesmanager25@info.com | Salesmanager  | Wrong login/password |
      | salesmanager55@info.com | sallesmanager | Wrong login/password |
      | posmanager35@info.com   | posmanagerx   | Wrong login/password |
      | posmanager75@info.com   | posmanager75  | Wrong login/password |
      | posmanager101@info.com  | Posmanager    | Wrong login/password |

  @FIDE-980
  Scenario Outline: Negative Login Scenario with empty username credentials
    When user enters username "<Username>"
    And user enters password "<Password>"
    And user clicks to login button
    Then user stays in same page and sees "Login | Best solution for startups" as title


    Examples: Search values we are going to be using in this scenario is as below table
      | Username | Password     | URL                              |
      |          | salesmanager | https://qa.fidexio.com/web/login |
      |          | posmanager   | https://qa.fidexio.com/web/login |

  @FIDE-981
  Scenario Outline: Negative Login Scenario with empty password credentials
    When user enters username "<Username>"
    And user enters password "<Password>"
    And user clicks to login button
    Then user stays in same page and sees "Login | Best solution for startups" as title


    Examples: Search values we are going to be using in this scenario is as below table
      | Username                | Password |
      | salesmanager35@info.com |          |
      | posmanager35@info.com   |          |

  @FIDE-982
  Scenario Outline: Negative Login Scenario with empty credentials
    When user enters username "<Username>"
    And user enters password "<Password>"
    And user clicks to login button
    Then user stays in same page and sees "Login | Best solution for startups" as title

    Examples: Search values we are going to be using in this scenario is as below table
      | Username | Password |
      |          |          |