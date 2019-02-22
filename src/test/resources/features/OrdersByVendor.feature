
@ordersByVendor1
Feature: Orders by Vendor page, print,export, delete, order, receive, cancel the selected option.
  Scenario: : Displaying print and action buttons
  Given user is at the lunch home page
  When user clicks the Orders by Vendor button
  Then user clicks the firstVendor button
  And user should be able to click the month
  Then user should be able to click the day check box
  And user should be able to see the print and action buttons

