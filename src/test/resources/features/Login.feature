@login
Feature: Login

 Background:
    Given manager is on the main page
    #When manager clicks on BriteErpDemo Button
    #Then the title should be Login | Website localhost
    #And the database should be "BriteErpDemo"

  @manager
  Scenario: Positive login test - Manager

    When the manager login with "email" and "password"
    And the title should be Odoo
  Then manager clicks the Lunch Button

@user
  Scenario: Positive login test - User
    When the user login with "email" and "password"
    And the title should be Odoo
  Then user clicks the Lunch Button


