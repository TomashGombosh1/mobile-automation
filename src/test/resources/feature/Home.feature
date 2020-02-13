Feature: Home screen navigation

  Background:
    Given I logged in as valid user
    Then The "Home" screen is opened

  Scenario: User can access Workforce screen from Home screen
    Given The "Home" screen is opened
    When I tap the "Workforce" button
    Then The "Workforce" screen is opened

  Scenario: User can access Chat screen from Home screen
    Given The "Home" screen is opened
    When I tap the "Chat" button
    Then The "Chat" screen is opened