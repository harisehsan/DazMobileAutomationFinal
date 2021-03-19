@smoke @userchat
Feature: Verification of IM-Chat feature on all ventures

  @chatscreen @37057316 @37057317 @37057318
  Scenario: Verification of Chat Screen elements product price,title,StoreIcon,StoreName,Input bar,emoticon when redirect from PDP screen
    Given I select the venture
    And I search product using sku for "Combo"
    And I goto the PDP page
    And I get the product Name
    And I save the product title, product price
    And I click on chat icon
    And I login with old buyer account
    And I should be on the chat screen
    And I verify product title and price on chat screen
    And I click on Send Product button
    And I must see unread message on screen
    And I verify store name existence in header
    And I verify store icon existence in header
    And I click on store icon in header should be redirected to store page
    And I navigate back by clicking "back" button
    And I should be on the chat screen
    And I should see text input box
    And I verify the existence of emoticon
#    And I verify the existence of quick reply button on chat screen
    And I verify the existence and click More Options on chat screen
    And I verify the existence Camera,Photos,Products,Orders channel icon under more option screen
    And I click on "Products" icon under more option screen
    And I should be redirected to select products page
    And I should see "Wishlist" tabs on select products screen
    And I should see "Cart" tabs on select products screen
    And I should see "Orders" tabs on select products screen
    And I should see "Wishlist" tabs on select products screen
    And I select a "product" from wishlist and sent it to chat screen
    Then I should be on the chat screen

  @chat_screen_from_Order_details_Page @37057327 @37057319
  Scenario: Verification of chat Button and redirection to chat screen from Order Detail Page
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I login with old buyer account
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I navigate back by clicking "back" button
    And I wait for the order details page
    And I click on Chat Now Button on Order detail page
    And I should be on the chat screen
    And I click on Send Product button
    Then I must see unread message on screen

  @Draft_Verification_in_Chats_module @37057320
  Scenario: Verification of DRAFT test on chats screen
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Messages" in the footer
    And I should be on the message page
    And I click on "Chats" tab in message center
    And I click on top first "Chat" in the list
    And I should be on the chat screen
    And I should see text input box
    Then I verify Draft function using text Box

    @Verification_of_Chat_redirection_from_store_page
    Scenario: I navigate to chat screen from Store Page
      Given I select the venture
      And I search a Product using SKU for "Checkout"
      And I select the product for checkout
      And I click on store button
      And I wait for store page to load
      And I click on "Chat Now" icon on Store Page
      And I login with old buyer account
      And I click on "Chat Now" icon on Store Page
      Then I should be on the chat screen
