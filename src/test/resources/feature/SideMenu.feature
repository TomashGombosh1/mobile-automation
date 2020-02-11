Feature: Side menu feature

  Background:
    Given I logged in as valid user
    When I tap the "Menu" button

  Scenario: Driver name is present in side menu
    Given The "Side menu" is opened
    Then Driver name is present in side menu
#    And I scroll down and exit

