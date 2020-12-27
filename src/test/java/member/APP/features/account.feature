@smoke @account
Feature: Daraz Account Management

#  @21598886 @signin_using_google_account @30524871 @30524876 @30524878 @30524877 @30524879 @30524874 @30524875 @30526017 @30526019 @37058643
#  Scenario: I signin using google account
#    Given I select the venture
#    And I navigate to the signin screen
#    And I signin with google account
#    And I verify that I have been logged in using google Account
#
  @21598886 @navigate_to_message_from_account_verify_my_services_and_avatar_popup @37058638 @28810410 @28810411 @30526026 @37058634 @37058651 @37058648 @37058650
  Scenario: I navigate to message from account verify my services and avatar popup
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    When I select avatar
    Then Then I should see take photo and select from album options
    And I navigate back
    And I scroll to "messages" in my account menu
    Then I verify the existence of red dot on message
    Then I verify the components of my services
    And I select message in account section
    Then I should be on the message page

  @31437657 @My_Account_Information_Hamburger_icon_To_Messages
  Scenario: I verify the Messages redirection from Account information Hamburger Icon
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    And I navigate to the account settings menu
    And I should see Account Information
    And I click Account Information
    And I should be on Account information Screen
    And I click on more option Hamburger menu
    And I click "Messages" option in HamburgerMenu
    Then I should be on the message page


  @21598886 @navigate_to_policies_and_help_and_message_settings_from_accounts @37058639 @37058658 @37058659 @37058639 @37058637 @37058655
  Scenario: I navigate to policies and help from account and message settings
    Given I select the venture
    Then I navigate to the account settings menu
    When I navigate to the policies section from settings menu
    Then I should be on the policies section
    And I navigate back
    When I navigate to messages settings from settings
    Then I should be on the message settings
    And I navigate back
    When I navigate to the "Help" screen from settings
    Then I should be on the Help screen

  @31437694 @I_Verify_Help_In_Account_And_In_Account_Information_Hamburger_Icon
  Scenario: I verify existence and redirection of HELP icon on Account screen and Account information Hamburger Icon
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    And I scroll to "Help" in my account menu
    And I click on "Help" icon on account screen
    And I should be on the Help screen
    And I navigate back
    And I navigate to the account settings menu
    And I should see Account Information
    And I click Account Information
    And I should be on Account information Screen
    And I click on more option Hamburger menu
    And I click "Need Help" option in HamburgerMenu
    Then I should be on the Help screen

  @21598886 @verify_language_change @37058639
  Scenario: I verify the language change
    Given I select the venture
    Then I navigate to the account settings menu
    And I change the language other then english
    Then I navigate to the account settings menu in local language
    Then I should see the settings menu in local language

  @22702821 @check_for_existence_of_wallet_and_my_wishlist_followed_store_voucher_and_navigate_to_wallet_or_voucher @37058643 @37058646 @37058652 @30524871 @30524876 @30524878 @30524877 @30524879 @30524874 @30524875 @30526017 @30526019
  Scenario: Check the daraz wallet existence and My Wishlist, Followed Store and Voucher in accounts, naviagte to wallet and vouchers
    Given I select the venture
    When I check for the existence of daraz wallet
    And I navigate to the signin screen
    And I signin with google account
    And I verify that I have been logged in using google Account
    And I navigate to the account menu
    And I verify that I have been logged in using google Account
    Then I verify the existence of the My Wishlist, Followed Store and Voucher as per daraz wallet
    When I jump to daraz wallet otherwise vouchers if daraz wallet is not existed
    Then I should be on the Daraz Wallet screen or voucher screen

  @21598886 @view_product_in_pay_now_menu @28810410 @28810411 @30526026
  Scenario: I view the product in pay now menu
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I navigate to my account from payment screen
    And I select the pay now widget
    Then I should see that product in the pay now menu

  @21001814 @view_cancelled_orders_in_my_cancellation_menu @28810383 @30526026
  Scenario: I view the cancelled products in my cancellation menu
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
    And I click on submit button
    And I navigate to my account from cancellation screen
    And I select my cancellation widget
    Then I verify the order in the cancellation screen

  @21001814 @verify_the_functionality_of_track_package_section @31128097
  Scenario: I verify the functionality of track package section
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    Then I verify the existence of the track package section
    Then I goto the consolidated delivery screen to verify the same order status

  @21001814 @my_order_status_validation @31107522
  Scenario: I verify the my order status
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    Then I verify status order status in my account

  @31437631 @My_Account_Information_Hamburger_icon_To_Home_Screen
  Scenario: I verify the Home Screen redirection from Account information Hamburger Icon
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    And I navigate to the account settings menu
    And I should see Account Information
    And I click Account Information
    And I should be on Account information Screen
    And I click on more option Hamburger menu
    And I click "Home" option in HamburgerMenu
    Then I should be on the homepage

  @21001814 @verify_cart_icon_navigation @31107522
  Scenario: I verify the cart icon navigation
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    And I goto cart from account menu
    And I skip the cart popup
    Then I verify that I should be on the cart page
    And I navigate back
    Then I navigate to the account settings menu
    And I goto account information menu
    And I goto cart from account information page
    And I skip the cart popup
    Then I verify that I should be on the cart page

  @21001814 @verify_navigation_from_account_information_to_search @31437469
  Scenario: I verify the account information to search
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    Then I navigate to the account settings menu
    And I goto account information menu
    And I select search button on account information page
    Then I verify the existence of search bar

  @21001814 @verify_the_message_settings
  Scenario: verify the message settings
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to the account menu
    Then I navigate to the account settings menu
    When I navigate to messages settings from settings
    Then I should be on the message settings
    When I check all the message settings options
    And I navigate back to the main screen
    And I navigate to the account menu
    And I scroll to "messages" in my account menu
    And I select message in account section
    Then I should be on the message page
    Then I should not see the notification for best offer and alerts
    And I navigate back to the main screen
    And I navigate to the account menu
    Then I navigate to the account settings menu
    When I navigate to messages settings from settings
    Then I should be on the message settings
    When I uncheck all the message settings options
    And I navigate back to the main screen
    And I navigate to the account menu
    And I scroll to "messages" in my account menu
    And I select message in account section
    Then I should be on the message page
    Then I should see the notification for best offer and alerts

  @31829205 @Edit_a_review_against_old_order
  Scenario: I Edit an old review
    Given I select the venture
    And I navigate to the account menu
    And I navigate to the signin screen
    And I signin with google account
    And I should be on Account screen
    And I verify the existence of "To Review" in My Orders
    And I click "To Review" in My Orders section
    And I should be on My Review Screen
    And I navigate back
    And I should be on Account screen
    And I verify "My Review" in My Services section
    And I click "My Review" in My Services
    And I should be on My Review Screen
    Then I click to History tab
