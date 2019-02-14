Feature: Entering the Lunch Page

  @managerLunchOkError
  Scenario: Manager is on Lunch Page
      When manager should be able to click the ok button
      Then the title should be New Order - Odoo

      @userLunchOkError
      Scenario: User is on Lunch Page
        When user should be able to click the ok button
        Then the title should be New Order - Odoo