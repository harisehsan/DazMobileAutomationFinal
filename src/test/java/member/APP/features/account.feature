@smoke @account
Feature: Daraz Account Management

  @21598886 @signin_using_google_account
  Scenario: I signin using google account
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I verify that I have been logged in using google Account

  @21598886 @view_product_in_pay_now_menu
  Scenario: I view the product in pay now menu
    Given I select the venture
    And I Search a Product for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I navigate to my account from payment screen
    And I select the pay now widget
    Then I should see that product in the pay now menu

  @21001814 @view_cancelled_orders_in_my_cancellation_menu
  Scenario: I view the cancelled product in the cancellation menu
    Given I select the venture
    And I Search a Product for "Checkout"
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




