#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: Login Page for SouceDemo Domain
  
  
  Background:
   Given User is on Login page    
   When User enter valid username and password
   And click on login button  
   And User is on product page
   And user select two items
   And user select price from low to high  
  
   
    
  @Product 
  Scenario: Select two different product    
    Then number of products added 
    
  @CartandCheckouts
  Scenario: verify cart product list and check checkouts
    
    And User is on cart page and checkouts product    
    When user enter all valid information detais
    And click on continue button
    
    Then user is on detailed information page 
    And check all information is correct click on finish
    And verify order is placed successfully and logout. 
    
    
    
    
    

  

    
