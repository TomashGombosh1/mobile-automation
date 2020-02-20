@smoke @all
Feature: Check all main functions
  ""
  The main goal of those tests is :
  To check that app was well installed.
  To ascertain that the critical functionalities of the program are working fine
  ""

  Background:
  "============================================="
  The following step is common to all scenarios
  "============================================="

    Given i am on travelcar home Screen

  Scenario: check homepage screen
    Then i see button "car" identified by "button_rent" with attribute "enabled" set to "true"
    And i see button "parking" identified by "button_park" with attribute "enabled" set to "true"
#    And i see button "ride" identified by "button_ride" with attribute "enabled" set to "true"

  Scenario: check serach car screen
    When i click on button "car" identified by "button_rent"
    Then i see textfield "pick-up" identified by "edit" with attribute "clickable" set to "true"
    And i see switch-button "modify drop-off location" identified by "arrival_switch" with attribute "checked" set to "false"
    And i see textfield "start date" identified by "start_day" with attribute "enabled" set to "true"
    And i see button "validate" identified by "button_search" with attribute "enabled" set to "false"

  Scenario: check serach parking screen
    When i click on button "parking" identified by "button_park"
    Then i see textfield "pick-up" identified by "edit" with attribute "clickable" set to "true"
    And i see textfield "start date" identified by "start_day" with attribute "enabled" set to "true"
    And i see button "validate" identified by "button_search" with attribute "enabled" set to "false"

#  Scenario: check serach ride screen
#    When i click on button "ride" identified by "button_ride"
#    Then i see textfield "pick-up" identified by "edit" with attribute "clickable" set to "true"
#    And i see textfield "passenger number" identified by "input_passenger" with attribute "clickable" set to "false"
#    And i see button "validate" identified by "button_search" with attribute "enabled" set to "false"
#
  Scenario: check booking screen
    When i click on baritem "reservations" identified by "menu_item_reservations"
    Then i see button "sign-in" identified by "button_signin" with attribute "enabled" set to "true"
    And i see button "qrcode" identified by "button_qrcode" with attribute "enabled" set to "true"
#
  Scenario: check assistance screen
    When i click on baritem "assistance" identified by "menu_item_help"
    Then i see menuitem "faq/aide" identified by "button_faq" with attribute "enabled" set to "true"
    When i click on menuitem "faq/aide" identified by "button_faq"
    Then i see button "back" identified by "back_button" with attribute "clickable" set to "true"
    When i click on button "Back" identified by "back_button"
    Then i see menuitem "faq" identified by "button_faq" with attribute "enabled" set to "true"
#
  Scenario: check sign-in screen
    When i click on baritem "profile" identified by "menu_item_account"
    Then i see button "login" identified by "button_signin" with attribute "enabled" set to "true"
    When i click on button "login" identified by "button_signin"
    Then i see textfield "email" identified by "input_email" with attribute "clickable" set to "true"
    And i see textfield "password" identified by "input_password" with attribute "clickable" set to "true"
    And i see link "forgotten password" identified by "button_forgot_password" with attribute "clickable" set to "true"
    And i see image "Show password" identified by "Show password" with attribute "checked" set to "false"
    When i click on button "close" identified by "button_close"
    Then i see button "login" identified by "button_signin" with attribute "enabled" set to "true"
#
  Scenario: check sign-up screen
    When i click on baritem "profile" identified by "menu_item_account"
    Then i see button "sign-up" identified by "button_signup" with attribute "enabled" set to "true"
    When i click on button "signup" identified by "button_signup"
    Then i see button "first name" identified by "input_firstname" with attribute "clickable" set to "true"
    And i see button "last name" identified by "input_lastname" with attribute "clickable" set to "true"
    And i see button "email" identified by "input_email" with attribute "clickable" set to "true"
    And i see button "password" identified by "input_password" with attribute "clickable" set to "true"
    And i see button "phone number" identified by "input_phone_number" with attribute "clickable" set to "true"
    And i see image "Show password" identified by "Show password" with attribute "checked" set to "false"
    When i click on button "close" identified by "button_close"
    Then i see button "sign-up" identified by "button_signup" with attribute "enabled" set to "true"
