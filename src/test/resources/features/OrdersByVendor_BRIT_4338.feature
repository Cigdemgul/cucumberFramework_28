Feature: Orders by Vendor page, print,export, delete, order, receive, cancel the selected option.
Scenario: Verifying data on Lunch Order option.
Given manager user is on the Orders By Vendor Page
When manager user clicks on the Print button
Then manager user should be able to click to Lunch Order option
And manager user should be able to verify the date, name and price is same with the Orders by Vendor Page