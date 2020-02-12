Feature: Side menu feature

  Background:
    Given I logged in as valid user
    When I tap the "Menu" button

  Scenario: Driver name is present in side menu
    Given The "Side menu" is opened
    Then Driver name is present in side menu
    When I scroll down and exit
    Then The "Logout" screen is opened

  Scenario: User can access Home screen
    Given The "Side menu" is opened
    When I tap the "Vehicle" menu button
    And I tap the "Menu" button
    And I tap the "Home" menu button
    Then The "Home" screen is opened

  Scenario: User redirected to the Pre-drive checklist screen if vehicle is not selected
    Given The "Side menu" is opened
    When I tap the "HOS" menu button
    Then The "Pre-drive checklist" screen is opened

