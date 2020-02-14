Feature: Sign In feature

  Scenario: Sign In with valid credentials
    Given I am on the "Login" screen
    When I fill the form with valid data
    And I tap the "Log in" button
    Then The "Home" screen is opened

  Scenario: Sign in with invalid credentials
    Given I am on the "Login" screen
    When I fill the form with invalid data
    And I tap the "Log in" button
    Then The "Home" screen is not opened

  Scenario: Remember me checkbox
    Given I am on the "Login" screen
    When I fill the form with valid data
    And I set the "Remember me" checkbox
    And I tap the "Log in" button
    Then The "Home" screen is opened
    When I restart the app
    Then The "ID" field is pre-populated