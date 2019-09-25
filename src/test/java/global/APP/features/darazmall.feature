@smoke @darazmall
Feature: Daraz Mall Management

  @22519011 @select_daraz_mall_by_icon
  Scenario: Select Daraz Mall by icon and navigate back to home page
    Given I select the venture
    And I check the existence of the Daraz Mall on Homepage
    And I click on Daraz Mall icon to navigate to Daraz Mall
    Then I should be on the Daraz Mall page
    And I navigate back to the Home Page from "Daraz Mall"
    And I check the existence of the Daraz Mall on Homepage

  @22519011 @select_daraz_mall_by_shop_more_button
  Scenario: Select Daraz Mall by shop more button
    Given I select the venture
    And I click on shop more button to navigate to Daraz Mall
    Then I should be on the Daraz Mall page