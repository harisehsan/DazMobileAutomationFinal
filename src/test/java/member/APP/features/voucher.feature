@smoke @voucher
Feature: Daraz Voucher Management

  @32135879 @goto_wallet_page_from_account
  Scenario: Goto wallet page on my account
    Given I select the venture
    And I click on wallet icon
    When I select Login button on "wallet" screen
    Then I should be on the login page
    And I select first login button
    When I enter email
    And I enter password
    And I select login button
    And I goto vouchers screen from wallet screen
    Then I should be on the my voucher page

  @32135879 @verify_the_coupon_details
  Scenario: verify the coupon details
    Given I select the venture
    And I search product using sku for "Voucher Collect"
    And I goto the PDP page
    And I check the existence of Voucher on PDP
    And I open voucher section
    And I click on collect button
    And I login with old buyer account
    And I navigate back to the Home Page from "pdp"
    And I navigate to the account menu
    And I select voucher in my accounts
    And I select details button on my voucher
    Then I should be on the voucher details page
    When I select terms and conditions
    Then I should see the terms and conditions
    And I navigate back
    When I select the daraz tab
    Then I should be on the daraz tab
    And I select Store tab in my voucher
    Then I should be on the store page
    And I select the store credit tab
    Then I should be on store credit
    When I select get more vouchers button
    Then I should be on the collectable voucher screen

  @21001814 @apply_platform_code_voucher_on_checkout
  Scenario: Apply platform code voucher on checkout
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I login with old buyer account
    And I scroll down to the voucher
    And I save the total price on checkout screen for voucher
    And I enter the voucher code on checkout for discount
    When I select voucher apply button
    Then I should see the voucher applied message
    Then I should see the impact of voucher on total price

  @21001814 @verify_the_language_change_for_voucher
  Scenario: Verify the language change for voucher
    Given I select the venture
    And I navigate to the account menu
    And I change the language other then english
    And I navigate to the account menu
    And I select the voucher in the local language
    Then I should see voucher in local language

  @21001814 @verify_the_non_usable_voucher_section
  Scenario: verify the non usable voucher section
    Given I select the venture
    And I navigate to the signin screen
    And I select first login button
    And I enter the email "daraz_qa200@test.com" and password "Test123" for the activated wallet account
    And I select login button
    And I navigate to the account menu
    And I select voucher in my accounts
    And I select non usable voucher
    And I wait for non usable voucher screen
    Then I should verify the used section of non-usable voucher
    And I select the expired voucher
    Then I should be on the expired page
    When I select the deactivated
    Then I should be on deactivated screen