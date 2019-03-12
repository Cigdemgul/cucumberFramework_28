
Feature: The application should run alert functionalities

  Scenario: check all buttons
    Given I am on the lunch page as a manager
    When I go to alert page
    Then the total number of alerts should be same as database records


  @db @wirr
  Scenario: check alert message
    Given I am on the lunch page as a manager
    When I go to alert page
    Then message 1  should be same as database records

