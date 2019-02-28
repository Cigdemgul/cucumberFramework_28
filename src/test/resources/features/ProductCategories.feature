Feature: Add and delete and reorder product categories


  Scenario: Create new product category
    Given I am on the lunch page as a manager
    Then I navigate to the product categories page
    When I create a new product category
    Then I save the new product category and verify it is created


  Scenario: Create then delete new product category
    Given I am on the lunch page as a manager
    Then I navigate to the product categories page
    When I create a new product category
    Then I save the new product category and verify it is created
    Then I delete the newly created product category

  Scenario: Reorder product categories columns
    Given I am on the lunch page as a manager
    Then I navigate to the product categories page
    When I reorder the page
    Then I verify it is reordered





