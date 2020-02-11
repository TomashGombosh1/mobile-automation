Feature: Sign In feature

  Scenario: Sign In with valid credentials scenario
    Given I am on the "Login" screen
    When I fill the form with valid data
    And I tap the "Log in" button
    Then The "Home" screen is opened

