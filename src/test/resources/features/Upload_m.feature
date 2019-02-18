Feature: The application should load files

  Scenario: load file
    Given I am on the lunch page as a manager
    Then I go to Control Accounts page as a manager
    When I click on import button
    Then I upload file path
    Then I click on load file button