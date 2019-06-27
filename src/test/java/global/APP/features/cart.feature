@smoke @cart
Feature: Daraz Cart Management

  @21001814 @add_item_without_open_cart_menu
  Scenario: Add a product to cart without opening a cart menu
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for cart
    And I add a product to cart
    And I should signin if require
    Then I verify item has been added to cart by success message

  @21001814 @remove_single_item_from_cart
  Scenario: Remove a single product from cart
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for cart
    And I add a product to cart
    And I should signin if require
    And I goto cart menu from PDP screen
    And I remove a single item from cart
    Then I verify that removed item should not present in cart

  @21001814 @add_item_to_cart
  Scenario: Add a product to cart
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for cart
    And I add a product to cart
    And I should signin if require
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart

  @21001814 @remove_all_items_from_cart
  Scenario: Remove all products from cart
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for cart
    And I add a product to cart
    And I should signin if require
    And I goto cart menu from PDP screen
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed

  @21001814 @add_product_from_wishlist_to_cart
  Scenario: Add a product from Wishlist to Cart
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for cart
    And I add a product to wishlist
    And I should signin if require
    And I goto the wishlist to select the added product
    And I add a product to cart
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart

 @21001814 @add_product_from_cart_to_wishlist
  Scenario: Add a product from Cart to Wishlist
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the product for cart
    And I add a product to cart
    And I should signin if require
    And I goto cart menu from PDP screen
    And I add a product from cart to wishlist
    Then I verify for added item in wishlist

  @21001814 @make_cart_empty_without_item_add
  Scenario: Remove all products from cart without add product
    Given I select the venture
    And I select cart
    And I should signin if require
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed