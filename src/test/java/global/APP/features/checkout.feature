@smoke @checkout
Feature: Daraz Checkout Management

  @21001814 @proceed_to_checkout_without_add_to_cart
  Scenario: Make a checkout without using cart
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for checkout
    And I select Buy Now
    And I should signin if require
    And I proceed to pay
    And I proceed to checkout using Cash on Delivery payment method
    Then I verify that order has been placed

  @21001814 @proceed_to_checkout_from_cart
  Scenario: Make a checkout from cart product
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for checkout
    And I add a product to cart
    And I should signin if require
    And I goto cart menu from PDP screen
    And I select that product from cart for checkout
    And I select checkout in cart menu
    And I proceed to pay
    And I proceed to checkout using Cash on Delivery payment method
    Then I verify that order has been placed

  @21001814 @proceed_to_checkout_from_cart_by_changing_quantity
  Scenario: Make a checkout from cart product by changing product quantity
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for checkout
    And I add a product to cart
    And I should signin if require
    And I goto cart menu from PDP screen
    And I select that product from cart for checkout
    And I change the quantity to 5
    And I select checkout in cart menu
    And I proceed to pay
    And I proceed to checkout using Cash on Delivery payment method
    Then I verify that order has been placed with that quantity