@smoke @voucher
Feature: Daraz Voucher Management

#  @32135879 @goto_wallet_page_from_account
#  Scenario: Goto wallet page on my account
#    Given I select the venture
#    And I click on wallet icon
#    When I select Login button on "wallet" screen
#    Then I should be on the login page
#    And I select first login button
#    When I enter email
#    And I enter password
#    And I select login button
#    And I goto vouchers screen from wallet screen
#    Then I should be on the my voucher page

  @32135879 @verify_the_coupon_details
  Scenario: verify the coupon details
    Given I select the venture
    And I search product using sku for "Voucher Collect"
    And I goto the PDP page
    And I check the existence of Voucher on PDP
    And I open voucher section
    And I click on collect button
    And I select first login button
    When I enter email
    And I enter password
    And I select login button
    And I navigate back to the Home Page from "pdp"
    And I navigate to the account menu
    And I select voucher in my accounts
    And I select details button on my voucher
    Then I should be on the voucher details page

  @21001814 @apply_platform_code_voucher_on_checkout
  Scenario: Apply platform code voucher on checkout
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I select first login button
    When I enter email
    And I enter password
    And I select login button
    And I scroll down to the voucher
    And I save the total price on checkout screen for voucher
    And I enter the voucher code on checkout for discount
    When I select voucher apply button
    Then I should see the voucher applied message
    Then I should see the impact of voucher on total price