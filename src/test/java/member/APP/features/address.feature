@smoke @address
Feature: Daraz Address Management

  @21298974 @edit_the_address_details
  Scenario: Change the address details
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on edit address button
    And I edit the address details
    And I save the changes
    Then I verify the address details

  @21298974 @add_new_address
  Scenario: Add new address
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on new address button
    And I add the address details
    And I make the address default billing and shipping address
    And I save the changes
    Then I verify the address details

  @21298974 @delete_all_the_deletable_addresses
  Scenario: Delete all the deletable addresses
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on new address button
    And I add the address details
    And I save the changes
    And I delete all the deletable addresses
    Then I verify that all deletable address removed successfully

#  @21298974 @add_address_on_checkout
#  Scenario: Add address on checkout screen
#    Given I select the venture
#    And I navigate to the signup screen
#    And I select signup using google account
#    And I provide name for google account
#    And I select date of birth and gender for google account
#    And I provide the email address for google account
#    And I provide password for google account
#    And I accept privacy terms and conditions for google account
#    And I should be signed up using google account




