Feature: Create, delete and reorder employee payments page

  Scenario: Create new employee payment
    Given I am on the lunch page as a manager
    Then I navigate to the employee payments page
    When I create a new register cash move
    Then I verify a new cash move has been created

    @wip
    Scenario: Delete last register cash move
      Given I am on the lunch page as a manager
      Then I navigate to the employee payments page
      When I click the register cash move that was created last
      Then I delete that register cash move and verify it was deleted
