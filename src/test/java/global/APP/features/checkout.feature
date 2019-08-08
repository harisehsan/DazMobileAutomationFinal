@smoke @checkout
Feature: Daraz Checkout Management

  @21001814 @proceed_to_checkout_without_add_to_cart
  Scenario: Make a checkout without using cart
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    And I signin with google account
    And I click on proceed to pay button
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed

  @21001814 @proceed_to_checkout_from_cart
  Scenario: Make a checkout from cart product
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I select that product from cart for checkout
    And I click on checkout button in cart menu
    And I click on proceed to pay button
    And I select Cash on Delivery payment method
    And I should reach to order successful page
    And I click on Track Order button
    Then I verify that order has been placed

  @21001814 @proceed_to_checkout_from_cart_by_changing_quantity
  Scenario: Make a checkout from cart product by changing product quantity
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
    Then I verify that order has been placed with that quantity