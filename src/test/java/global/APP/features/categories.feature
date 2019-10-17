@smoke @categories @229800967
Feature: Categories for Daraz Homepage

  @229800967 @jump_to_categories_and_switch_between_tabs @28811857 @28811858 @28811860 @28811862
  Scenario: Select shop more for categories and switch between categories tab
    Given I select the venture
    And I skip the shake shake popup
    And I scroll down to categories section on homepage
    And I select shop more for categories
    And I should be on the categories page
    Then I switch between the categories tabs
    Then I switch between the goods tab


