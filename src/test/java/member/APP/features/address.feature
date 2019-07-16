@smoke @address
Feature: Daraz Address Management

  @21298974 @edit_the_address_details
  Scenario: change the address details
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on edit address button
    And I edit the address details
    And I save the changes
    Then I verify the address details

  @21298974 @add_new_address
  Scenario: add new address
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on new address button
    And I add the address details
    And I save the changes
    Then I verify the address details

  @21298974 @delete_the_addresses
  Scenario: delete_the_addresses
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on new address button
    And I add the address details
    And I save the changes
    And I delete all the deletable addresses
    Then I verify that all deletable address removed successfully





