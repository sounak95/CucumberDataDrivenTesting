@datadriven
Feature: Data Driven Tests

Scenario Outline: Perform a successful single transfer
	Given Login to applivcation as "<row_index>" customer
	When user provides account transfer data as in "<row_index>" for account type "col5" for sheet "Sheet1"
	And Submits the transfer
	Then The transfer should be successful
Examples:
	|row_index|
	|3|
	|2|