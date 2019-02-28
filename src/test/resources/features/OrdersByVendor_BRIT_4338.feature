@wip
Feature: Orders by Vendor page, print,export, delete, order, receive, cancel the selected option.
Scenario: Verifying data on Lunch Order option.
Given manager user is on the Orders By Vendor Page
Then manager user clicks on the Print button
Then manager user should be able to click to Lunch Order option
And manager user should be able to get the pdf file