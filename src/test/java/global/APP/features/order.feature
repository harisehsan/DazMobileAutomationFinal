@smoke @order
Feature: Daraz Order Cancellation Management

  @21001814 @order_cancellation
  Scenario: Cancel the order
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
    Then I verify that order has been cancelled

  @21001814 @order_cancellation_by_changing_quantity
  Scenario: Cancel the order by changing quantity
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I select that product from cart for checkout
    And I change the quantity to 5
    And I click on checkout button in cart menu
    And I click on proceed to pay button
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
    And I verify the quantity amount on cancellation page
    And I click on submit button
    Then I verify that order has been cancelled