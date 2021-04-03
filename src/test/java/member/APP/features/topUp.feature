@smoke @topup
Feature: Verification of TOP-UP feature on all ventures

  @searchForTopUp @pk
  Scenario: Search for Topup
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Home" in the footer
    And I search for "topup"
    And I should be redirected to TopUP screen
    And I should get validation on wrong number format
    And I assert country code should be removed
    And I select Operator from the List and select Product
    And I should be redirected to M-site checkout
    Then I should be on the select payment screen

  @searchForTopUp @bd
  Scenario: Search for Topup
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Home" in the footer
    And I search for "topup"
    And I should be redirected to TopUP screen
    And I should get validation on wrong number format
    And I assert country code should be removed
    And I select Operator from the List and select Product
    And I should be redirected to M-site checkout
    Then I should be on the select payment screen

  @searchForTopUpChannelIcon @lk
  Scenario: Search for Topup
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Home" in the footer
    And I close the first order voucher popup
    And I select "Reload" channel on Home screen
    And I click "Reloads" on Reloads page
    And I should be redirected to TopUP screen
    And I should get validation on wrong number format
    And I assert country code should be removed
    And I select Operator from the List and select Product
    And I should be redirected to M-site checkout
    Then I should be on the select payment screen

  @TopupNavigationBanner @lk
  Scenario: Search for Reload keyword I should be redirect to Search page and I click on First Banner Should be redirected to Topup screen
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Home" in the footer
    And I search for "topup"
    And I click on reload banner on search page
    And I should be redirected to TopUP screen
    And I should get validation on wrong number format
    And I assert country code should be removed
    And I select Operator from the List and select Product
    And I should be redirected to M-site checkout
    Then I should be on the select payment screen

  @searchForTopUpNp @np
  Scenario: Search for Topup
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Home" in the footer
    And I search for "NCell"
    And I click on First Banner on Recharge and EStore page
    And I should be redirected to TopUP screen
    And I should get validation on wrong number format
    And I assert country code should be removed
    And I select Operator from the List and select Product
    And I should be redirected to M-site checkout
    Then I should be on the select payment screen

  @searchForTopMM @mm
  Scenario: Search for Topup
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Home" in the footer
    And I search for "Telenor"
    And I should be redirected to TopUP screen
    And I should get validation on wrong number format
    And I assert country code should be removed
    And I select Operator from the List and select Product
    And I should be redirected to M-site checkout
    Then I should be on the select payment screen

