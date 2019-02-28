
Feature: The user should open new account

  Scenario: open new account
    Given I am on the lunch page as a manager
    Then I go to Control Accounts page as a manager
    When I go to Create New Account Section
    Then I enter information
    Then I save
    And the amounts should be the same



  Scenario: verify new account
    Given I am on the lunch page as a manager
    Then I go to Control Accounts page as a manager
    When I go to Create New Account Section
    Then I enter information
    Then I save
    When I get the number of accounts then the number of accounts should be increased by one



  Scenario: verify new account amount
    Given I am on the lunch page as a manager
    Then I go to Control Accounts page as a manager
    When I go to Create New Account Section
    Then I enter information
    Then I save
