@smoke @order
Feature: Daraz Order Details & Order Cancellation Management

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
  @21001814 @order_cancellation_by_changing_quantity @28810439 @28810397 @28810383 @28810448 @@30564196 @30564196 @30564632 @30564633 @30564634 @30564636 @28810162 @28810395 @28810439 @30564196 @30564196 @30564632 @30564633 @30564635 @30564636 @28810394 @28810395 @28810439 @30564196 @30564196 @30564632 @30564633 @30564635 @30564636 @28810286 @37058542 @37058543
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
    And I save the total price on checkout screen
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed with that quantity
    Then I verify the existence of total price on order detail page
    Then I verify the existence COD payment method on order detail page
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
#    And I verify the quantity amount on cancellation page
    And I click on submit button
    Then I verify that order has been cancelled

  @21001814 @place_order_and_verify_order_details @28810395 @28810439 @30564196 @30564196 @30564632 @30564633 @30564635 @30564636 @28810295 @28810308 @28810309 @28810301 @28810298 @28810312 @37058522 @37058523 @37058531 @37058528 @37058520 @37058518 @37058569 @37058521 @37058567
  Scenario: Place order and verify order details
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I save the shipping address
    Then I verify the main product map, product title, product attributes, product price, line price, quantity of goods
    And I check for the total price on checkout screen
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I navigate back
    Then I verify the order number, order creation time, order status
    When I long press on order
    Then I should copied snackbar message
    When I select pay now button
    And I wait for the select payment screen
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed
    Then I verify the logistics type, estimated delivery date, postage on Order details page
    When I click on seller name
    Then I should be on the seller store
    And I navigate back
    Then I verify the shipping and billing adresses titles
    Then I verify the shipping address on order details page
    And I navigate back
    Then I should be on the order received page

  @21001814 @place_order_and_cancellation_on_buy_more_save_more @37058571 @37058557 @37058559
  Scenario: place order and cancellation on buy more save more
    Given I select the venture
    And I search product using sku for "Save more"
    And I goto the PDP page
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed
    Then I verify for the "Buy more save more" promotion label
    Then I verify the logistics type, estimated delivery date, postage on Order details page
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
    And I click on submit button
    Then I verify that order has been cancelled
    Then I verify for the "Buy more save more" promotion label

  @21001814 @place_order_and_cancellation_on_buy_one_get_one @37058570 @37058557 @37058560
  Scenario: place order and cancellation on buy one get one
    Given I select the venture
    And I search product using sku for "B1G1"
    And I goto the PDP page
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed
    Then I verify for the "Buy 1 get 1" promotion label
    Then I verify the logistics type, estimated delivery date, postage on Order details page
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
    And I click on submit button
    Then I verify that order has been cancelled
    Then I verify for the "Buy 1 get 1" promotion label

  @21001814 @place_order_and_cancellation_on_free_gift @37058573 @37058557 @37058562
  Scenario: place order and cancellation on free gift
    Given I select the venture
    And I search product using sku for "Free Gift"
    And I goto the PDP page
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed
   Then I verify for the "Free Gift" promotion label
    Then I verify the logistics type, estimated delivery date, postage on Order details page
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
    And I click on submit button
    Then I verify that order has been cancelled
    Then I verify for the "Free Gift" promotion label

  @21001814 @place_order_and_cancellation_on_combo @37058572 @37058557 @37058561
  Scenario: place order and cancellation on combo
    Given I select the venture
    And I search product using sku for "Combo"
    And I goto the PDP page
    And I get the product Name
    And I get the product Name for checkout
    And I add a combo product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product in cart
    And I mark the checkbox for that product in cart
    And I click on checkout button in cart menu
    And I click on proceed to pay button
    And I wait for the select payment screen
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed

    Then I verify for the "Combo" promotion label
    Then I verify the logistics type, estimated delivery date, postage on Order details page
    And I click on cancel order button
    And I Select the reason for cancellation
    And I provide comments for cancellation
    And I click on submit button
    Then I verify that order has been cancelled
    Then I verify for the "Combo" promotion label