Feature: Sign Up feature

  Background:
    Given I install application
    And I enable all network activity
    Then I am on Sign Page

  Scenario: Create new account with valid data
    Given Tap on 'Create Account' button
    When Enter valid information in 'First Name', 'Email' and 'Password' fields
    And Check the box for Terms and Conditions
    Then 'Register' button is active
    When Tap 'Register' button
    Then Profile form is opened

  Scenario: Create new account with invalid data
    Given Tap on 'Create Account' button
    When Enter invalid information in 'First Name', 'Email' and 'Password' fields
    And Check the box for Terms and Conditions
    Then 'Register' button is not active