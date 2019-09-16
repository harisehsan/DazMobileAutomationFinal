@smoke @darazmall
Feature: Daraz Mall Management

  @22519011 @select_daraz_mall
  Scenario: Select daraz mall and navigate back
    Given I select the venture
    And I check for the existence of the daraz mall on Homepage
    And I select DarazMall
    Then I should be in the daraz mall
    And I navigate back to the main screen from Daraz Mall
    And I check for the existence of the daraz mall on Homepage