@smoke @usergrowth
Feature: Daraz User Growth

  @30475159 @verify_the_user_growth_popup_in_local_language @38229341 @38229343 @38229350 @38229354 @38229809 @38229397 @38229809 @38229817 @38229832
  Scenario: Verify the user growth popup in local langugae and collect voucher on new user zone
    Given I select the venture
    Then I verify the existence of user growth popup on Home Screen
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
    And I scroll to user growth popup on PDP
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
    And I scroll to user growth popup on PDP
    Then I should not see the voucher collect button

  @30475159 @verify_for_the_collected_voucher_in_my_voucher_section @38229376 @38229384 @38229395
  Scenario: Verify for the collected voucher in the my account section
    Given I select the venture
    And I close the first order voucher popup
    And I navigate to the signin screen
    And I signin with "2nd" new account
    And I navigate to the account menu
    Then I verify the existence of user growth module on my account
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

  @31422642 @Old_User_should_not_see_Voucher_In_My_Account @031325544
  Scenario: Verify Old user should not see free voucher in my account section
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    Then I verify the non existence of user growth module in my account


  @31422641 @old_User_should_not_see_Voucher_On_Home_Screen @031325544
  Scenario: Verify Old user should not see free voucher on Home Screen
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate back to the main screen
#    And I navigate to the account menu
#    And I navigate back to the Home Page from "My Account"
    And I verify the non existence of user growth popup on Home Screen
    Then I verify the non existence of user growth module on Home Screen

  @31422640 @new_User_voucher_Should_not_be_Display_on_PDP_to_an_Old_Customer @031325544
  Scenario: Collect voucher should not be displayed on PDP screen to an old customer
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    And I navigate back to the Home Page from "My Account"
    And I search a Product using SKU for "Usergrowth"
    And I select the product for checkout
    Then I verify the non existence of user growth on PDP
