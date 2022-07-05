Feature: Fidexio LogOut Feature
 AC-2:
 1- User can log out and ends up in login page.
 2- The user can not go to the home page again by clicking
  the step back button after successfully logged out.

#  Background: User  see the login page
#    Given user is on the login page

@FIDE-1019
 Scenario: User click the logout button and see the logInpage
   When user is at login page
  And user enters username
  And user enters password
  And user clicks to login button
#   And user is at the home page
   And user click the logOut button
   Then user is at login page
@FIDE-1020
  Scenario: The user can not go to the home page again by clicking the step back button
  When user is at login page
  And user enters username
  And user enters password
  And user clicks to login button
  And user click the logOut button
#  Then user is at login page
  Then user click the step back button
  Then user should see alert message
