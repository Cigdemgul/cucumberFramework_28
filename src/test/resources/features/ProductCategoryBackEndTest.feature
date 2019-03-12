Feature: Product Category back end testing

	
	@BRIT-4485 @db
	Scenario: Product Category db testing
		Feature:Product Category db test
		Given I am on the lunch page as a manager
		Then I navigate to the product categories page
		Then Product Categories should match database record