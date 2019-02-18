Feature: User should delete/export previous orders and see order prices

  Scenario: delete previous order
    Given I am on the lunch page as a manager
    Then I go to Previous Orders page as a manager
    Then I go to previous order details
    Then I go to Action details
    Then I should be able to see "Delete"


@wip
  Scenario: export files
    Given I am on the lunch page as a manager
#    Then I go to Control Accounts page as a manager
    Then I go to invoicing manager
    When I select an order
    Then I click on action button
    Then I should see "Export"


  Scenario: look to previous orders prices
    Given I am on the lunch page as a manager
    Then I go to Previous Orders page as a manager
    Then I select order
    When I get the price from invoice print document
    Then invoice total price and total price should be same