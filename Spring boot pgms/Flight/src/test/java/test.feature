#Features
Feature: feature description
  In order to add flight details
  As flight manager
  I want some conditions to be true

  Scenario: Successful Creation
    Given I have chosen to insert new flight detail
    When I insert valid flight details
    Then Map should be updated with new values
    
  Scenario: Successful Fetching
    Given I have chosen to get existing flight details
    When To get flight details
    Then I should get all the flight details
    
  Scenario: Successful Fetching for Id
    Given I want flight detail for a Id
    When To get flight details for Id
    Then I should get the flight details for Id
    
    	