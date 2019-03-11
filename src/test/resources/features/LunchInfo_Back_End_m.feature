
Feature: New accounts db test

  Scenario: amount verification
    Given I am on the lunch page as a manager
    Then I go to Control Accounts page as a manager
    When I go to Create New Account Section
    Then I enter information of new account
    Then I save
    Then the amount should be the same as database records



  Scenario: count of account verification
    Given I am on the lunch page as a manager
    Then I go to Control Accounts page as a manager
    When I go to Create New Account Section
    Then I enter information of new account
    Then I save
    Then number of accounts should be the same as database records


  @db @wirr
  Scenario: verify new account date
    Given I am on the lunch page as a manager
    Then I go to Control Accounts page as a manager
    When I go to Create New Account Section
    Then I enter information of new account
    Then I save
    Then the account date should be the same as database records