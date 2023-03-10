Feature: This file contains tests of different products 

Background: 
Given url is launched

Scenario: Verify search result for polo men
When user searches for polo t shirt
Then all results should be related to polo

Scenario:  Verify if search by popularity yields proper results
When user hovers on men menu
And user clicks on men t-shirt
Then user selects popularity filter













































