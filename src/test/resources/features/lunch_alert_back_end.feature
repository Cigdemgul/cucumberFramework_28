
Feature: The application should run alert functionalities
  @db
  Scenario: check all buttons
    Given I am on the lunch page as a manager
    When I go to alert page
    Then the total number of alerts should be same as database records


  @db
  Scenario: check alert message
    Given I am on the lunch page as a manager
    When I go to alert page
    Then message 1  should be same as database records

  @db
  Scenario: check alert message
    Given I am on the lunch page as a manager
    When I go to alert page
    Then recurrence of 1. alert  should be same as database records

