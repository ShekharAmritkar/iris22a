Feature: Parameterization in cucumber


#Scenario: Parameterization of numeric values
#Given Two numbers 82 & 45
#When Addition
#Then Print result
#
#
#Scenario: Parameterization of string
#Given Country is "France"
#Then Display the capital 


#Scenario: Parameterization of list
#Given given <states>
#|Maharashtra					|36|MH|
#|Gujrat											|33|GJ|
#|Goa													|02|GA|
#|Rajsthan									|33|RJ|
#|Madhya Pradesh	|50|MP|
#|Karnataka								|31|KN|
#Then Display state names


#Scenario Outline: Data driven testing
#Given given <num1> & <num2> numbers 
#When Addition
#Then print if their addition is prime
#
#Examples:
#|num1|num2|
#|10|7|
#|9|3|
#|11|12|
#|14|16|
#|21|6|
#|3|4|



Scenario Outline: Data driven testing
Given I have <row_num> 
When Addition
Then print if their addition is prime

Examples:
|row_num|
|1|
|2|
|3|
|4|
|5|
|6|



































