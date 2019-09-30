@smoke @searchbar
Feature: Daraz Search Bar Management

  @22702821 @check_scan_icon_and_text
  Scenario: Check the scan icon and text
    Given I select the venture
    Then I check the existence of scan icon and text on Homepage

  @22702821 @navigate_to_scan_and_return_back_to_homepage
  Scenario: Navigate to scan page and back to homepage
    Given I select the venture
    And I click on scan icon to navigate to scan page
    Then I should be on scan page
    And I navigate back to the Home Page from "Scan Page"
    Then I check the existence of scan icon and text on Homepage

    @22702821 @search_item_and_return_back_to_homepage
    Scenario: Search the item and return back to homepage
      Given I select the venture
      And I search for "PS4"
      Then I should see search results
      And I navigate back to the Home Page from "Catalog Page"
      Then I check for the existence of the searchbar on Homepage

   @22702821 @check_for_existence_of_wallet_icon_and_text
   Scenario: Click on searchbar and return back to homepage
     Given I select the venture
     Then I check for the existence of daraz wallet icon and text

  @22702821 @navigate_to_wallet_and_return_back_to_homepage
  Scenario: Navigate to daraz wallet and back to homepage
    Given I select the venture
    And I click on wallet icon to navigate to scan page
    Then I should be on the Daraz Wallet page
    And I navigate back to the Home Page from "Daraz Wallet"
    Then I check for the existence of daraz wallet icon and text


