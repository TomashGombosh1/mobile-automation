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
