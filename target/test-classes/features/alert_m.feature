
Feature: The application should run alert functionalities
#  @wip
  Scenario: check all buttons
    Given I am on the lunch page as a manager
    Then I go to alert page
    When I check all the buttons
    Then all buttons should be selected
#  @wip
  Scenario: check all buttons
    Given I am on the lunch page as a manager
    Then I go to alert page
    When I check all the buttons
    Then I click on Action button
    Then it should export the file