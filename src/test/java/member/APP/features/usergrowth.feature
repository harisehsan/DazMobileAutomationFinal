@smoke @usergrowth
Feature: Daraz User Growth

  @30475159 @verify_the_user_growth_popup_in_local_language @38229341 @38229343 @38229350 @38229354 @38229809 @38229397 @38229809 @38229817 @38229832
  Scenario: Verify the user growth popup in local langugae and collect voucher on new user zone
    Given I select the venture
    Then I verify the existence of user growth popup on HP
    And I close the first order voucher popup
    And I select the avail now button
    Then I should be on the New User Zone Screen
    And I navigate back
    Then I navigate to the account settings menu
    And I change the language other then english
    And I navigate back to the Home Page from "settings menu"
    Then I verify the first voucher popup in local language

  @30475159 @collect_voucher_for_new_user_on_PDP @38229370 @38229371 @38229372 @38229373 @38229379 @38229381
  Scenario: Collect voucher for new user
    Given I select the venture
    And I search a Product using SKU for "Usergrowth"
    And I select the product for checkout
    And I select collect button for user growth voucher
    And I signin with "1st" new account
    Then I should see the voucher collection message
    Then I should not see the voucher collect button
    And I select Buy Now button
    And I wait for checkout screen
#    And I verify the money value discount
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
    And I click on submit button
    Then I verify that order has been cancelled
    And I navigate back to the main screen
    And I search a Product using SKU for "Usergrowth"
    And I select the product for checkout
    Then I should not see the voucher collect button

  @30475159 @verify_for_the_collected_voucher_in_my_voucher_section @38229376 @38229384 @38229395
  Scenario: Verify for the collected voucher in the my account section
    Given I select the venture
    And I close the first order voucher popup
    And I navigate to the signin screen
    And I signin with "2nd" new account
    And I navigate to the account menu
    Then I verify the existence of user growth wigit on my account
    And I select go button user growth
    Then I should be on the New User Zone Screen
    And I select collect button for user growth voucher
    Then I should see the voucher collection message
    Then I should not see the voucher collect button
    And I navigate back
    And I select voucher in my accounts
    Then I should see the collected user growth voucher in my voucher section
#    And I navigate back
#    Then I log out
#    And I navigate back to the main screen
#    Then I verify The existence of the main user growth popup





