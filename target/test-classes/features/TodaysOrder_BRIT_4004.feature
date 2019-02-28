@today'sOrder

Feature:Today's Order Page Smoke test

  Scenario: Today option button is displayed.
    When manager clicks the Today's Orders Button on Lunch Home Page
    Then manager should be able to see Today option button is selected
    And the title should be New Order - Odoo