@smoke @order
Feature: Daraz Order Cancellation Management

  @21001814 @make_cart_empty_without_item_add_for_orders
  Scenario: Remove all products from cart without add product
    Given I select the venture
    And I skip first order voucher popup
    And I select cart
    And I signin with google account
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed

#  @21001814 @order_cancellation @28810439 @28810397 @28810383 @28810448 @@30564196 @30564196 @30564632 @30564633 @30564634 @30564636
#  Scenario: Cancel the order
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
#    Then I verify that order has been cancelled
#
  @21001814 @order_cancellation_by_changing_quantity @28810439 @28810397 @28810383 @28810448 @@30564196 @30564196 @30564632 @30564633 @30564634 @30564636 @28810162 @28810395 @28810439 @30564196 @30564196 @30564632 @30564633 @30564635 @30564636 @28810394 @28810395 @28810439 @30564196 @30564196 @30564632 @30564633 @30564635 @30564636 @28810286
  Scenario: Cancel the order by changing quantity
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select that product from cart for checkout
    And I change the quantity to 2
    And I click on checkout button in cart menu
    And I slide the product to view the delete button
    And I click on delete button checkout
    Then I should see the snackbar error message
    And I click on proceed to pay button
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed with that quantity
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
#    And I verify the quantity amount on cancellation page
    And I click on submit button
    Then I verify that order has been cancelled