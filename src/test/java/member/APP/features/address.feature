@smoke @address
Feature: Daraz Address Management

  @21298974 @add_new_address @30523167 @28810289 @30523164 @30523147 @30523151 @30523152 @30523153 @30523155 @30523156 @30523157 @30523158 @30523159 @30523162 @30523165 @30526038 @30523170 @30523147
  Scenario: Add new address
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I navigate to address menu
    And I click on new address button
    And I add the address details
    And I make the address default billing and shipping address
    And I save the changes
    Then I verify the address details

  @21298974 @edit_the_address_details @28810289 @28810291 @28810292 @30523147 @30523152 @30523155 @30523156 @30523157 @30523158 @30523159 @30523160 @30526038 @30523169 @30523147
  Scenario: Change the address details
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I navigate to address menu
    And I click on edit address button
    And I edit the address details
    And I save the changes
    Then I verify the address details

  @21298974 @delete_all_the_deletable_addresses @30523163 @30523147 @30523163 @30523164 @30526038 @30523165 @30523147
  Scenario: Delete all the deletable addresses
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
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

  @21298974 @delete_the_different_shipping_billing_addresses @30523166 @30523149
  Scenario: delete the different shipping and billing addresses
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I navigate to address menu
    And I click on new address button
    And I add the address details
    And I make the address default "shipping" address only
    And I save the changes
    And I select the edit button of the "first" address
    When I select the delete button
    Then I should see the delete restriction message
    And I navigate back to the Home Page from "edit address"
    And I select the edit button of the "second" address
    When I select the delete button
    Then I should see the delete restriction message

  @21298974 @set_the_address_as_home_and_office
  Scenario: set the address as a home and office
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I navigate to address menu
    When I scroll to the "HOME" button
    And I select the "HOME" button
    Then I should see the address set as "HOME"
    When I scroll to the "OFFICE" button
    And I select the "OFFICE" button
    Then I should see the address set as "OFFICE"

  @21298974 @verify_the_collection_point_on_address
  Scenario: verify the collection point on address
    Given I select the venture
    And I search for "samsung"
    And I goto the PDP page
    And I select the product for checkout
    And I select Buy Now button
    And I login with old buyer account
    And I click on edit address button on checkout
    And I click on edit address button
    And I edit the address details
    And I change the address details for collection point
    And I save the changes
    And I navigate back
    And I select the pick-up point from the collection point
    Then I should see the collection point on checkout page in address

