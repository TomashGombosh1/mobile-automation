Feature: Sign In feature

  Background:
    Given I install application
    And I enable all network activity
    Then I am on Sign Page

  Scenario: Sign In scenario
    Given I am go to the Login Page
    And I fill valid user data using properties file
    And I click sign in button

    Then I am login in the application

  Scenario: Login with non existing account
    Given I am go to the Login Page
    When I fill non existing user data
    And I tap sign in button
    Then "Sign in" button is not active

  Scenario: Login with invalid data
    Given I am go to the Login Page
    When I fill invalid user data
    And I tap sign in button
    Then "Sign in" button is not active

  Scenario: Verify forgot password (happy path)
    Given I am go to the Login Page
    When Tap on the 'Forgot password?' link
    And Enter existing email into 'Email' field from 'Reset password' screen
    And Tap on the 'Reset password' button
    Then 'We have sent you an email to reset your password' text is displayed
    And I am redirected to Sign Page