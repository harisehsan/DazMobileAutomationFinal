@smoke @account
Feature: Daraz Account Management

  @21598886 @signin_using_google_account @30524871 @30524876 @30524878 @30524877 @30524879 @30524874 @30524875 @30526017 @30526019 @37058643
  Scenario: I signin using google account, I verfy visit store, my wishlist, voucher
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I verify that I have been logged in using google Account
    Then I should see visit store, my wishlist and voucher as per wallet availability

  @21598886 @view_product_in_pay_now_menu @28810410 @28810411 @30526026
  Scenario: I view the product in pay now menu
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I navigate to my account from payment screen
    And I select the pay now widget
    Then I should see that product in the pay now menu
#
#  @21001814 @view_cancelled_orders_in_my_cancellation_menu @28810383 @30526026
#  Scenario: I view the cancelled products in my cancellation menu
#    Given I select the venture
#    And I search a Product using SKU for "Checkout"
#    And I select the product for checkout
#    And I select Buy Now button
#    And I signin with google account
#    And I click on proceed to pay button
#    And I select Cash on Delivery payment method
#    And I should reach to order successful page
#    And I click on Track Order button
#    And I click on cancel order button
#    And I Select the reason for cancellation
#    And I provide comments for cancellation
#    And I click on submit button
#    And I navigate to my account from cancellation screen
#    And I select my cancellation widget
#    Then I verify the order in the cancellation screen


  @21598886 @navigate_to_message_from_account @37058638 @28810410 @28810411 @30526026
  Scenario: I navigate to message from account
    Given I select the venture
    And I navigate to the account menu
    And I select message in account section
    Then I should be on the message page

  @21598886 @navigate_to_policies_and_help_and_message_settings_from_accounts @37058639 @37058658 @37058659 @37058639
  Scenario: I navigate to policies and help from account
    Given I select the venture
    Then I navigate to the account settings menu
    When I navigate to the policies section from settings menu
    Then I should be on the policies section
    And I navigate back
    When I navigate to messages settings from settings
    Then I should be on the message settings
    And I navigate back
    When I navigate to the help section from accounts
    Then I should be on the help section

  @21598886 @verify_language_change @37058639
  Scenario: I verify the language change
    Given I select the venture
    Then I navigate to the account settings menu
    And I change the language other then english
    Then I navigate to the account settings menu
    Then I should see the settings menu in local language
