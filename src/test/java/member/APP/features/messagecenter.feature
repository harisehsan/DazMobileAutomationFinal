@smoke @messagecenter
Feature: Daraz Message Center Verification
#NOTE: Before executing these scenario don't forget to push notification through Ali tool.

  @Verify_Message 
  Scenario: I mark all notifications as readed
    Given I select the venture
    And I close the first order voucher popup
    And I navigate to the signin screen
    And I login with old buyer account
    And I clear Shopping Cart
    And I find unread message count in footer
    And I select "Messages" in the footer
    And I should be on the message page
    And I find unread message count in message center
    And I select "Home" in the footer
    And I search for "hand sanitizer"
    And I should see search products
    And I goto the PDP page
    And I verify message count on pdp header
    And I open upper right corner menu on PDP
    And I verify message count should be visible in dropdown menu on pdp
    And I click on "Home" in PDP header Menu
    And I select "Messages" in the footer
    When I click on Mark all as read button
    And I delete the first notification
    And I assert all unread message count should disappear from message center
    And I select "Home" in the footer
    And I search for "hand sanitizer"
    And I should see search products
    And I goto the PDP page
    Then I assert message count should not display on pdp header

  @Verify_MessageTabs_in_Message_center
  Scenario: I Navigate to Message center and verify Chat Order Notification Promos tabs
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I select "Messages" in the footer
    And I should be on the message page
    And I click on "Chats" tab in message center
    And I navigate back by clicking "back" button
    And I should be on the message page
    And I click on "Order" tab in message center
    And I navigate back by clicking "back" button
    And I should be on the message page
    And I click on "Notifications" tab in message center
    And I navigate back by clicking "back" button
    And I should be on the message page
    And I click on "Promos" tab in message center
    And I navigate back by clicking "back" button
    Then I should be on the message page

  @verify_order_tab
  Scenario: I Navigate message center and click on order tab and view order details page
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I login with old buyer account
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I navigate back by clicking "back" button
    And I wait for the order details page
    And I navigate back by clicking "back" button
    And I open upper right corner menu on PDP
    And I click on "Messages" in PDP header Menu
    And I should be on the message page
    And I click on "Order" tab in message center
    And I click on top first "order" in the list
    Then I wait for the order details page

     # This scenario is blocked because of ticket "32878682"
#      @Read_msg
#      Scenario: Read click and delete notification
#        Given I select the venture
#        And I close the first order voucher popup
#        And I navigate to the signin screen
#      And I select first login button
##        And I login with old buyer account
#      And I enter the email "darazqa@gmail.com" and password "Test@123"
#      Then I select login button
#        And I select "Messages" in the footer
#        And I Read first notification in message center
#        And I navigate back by clicking "back" button
#        Then I delete the first notification
