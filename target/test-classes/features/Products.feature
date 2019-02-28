Feature: User should be able to add and delete products.

  Scenario: Create new product
    Given I am on the lunch page as a manager
    Then I go to products page
    When I create a new product
    Then I add a product name, category, vendor, and price
    And I click save and verify new product

  Scenario: Delete product
    Given I am on the lunch page as a manager
    Then I go to products page
    When I click the last item on the list
    And I choose delete through the action button
    Then I verify product is deleted

  Scenario: Order columns
    Given I am on the lunch page as a manager
    Then I go to products page
    When I reorder the page
    Then I verify it is reordered