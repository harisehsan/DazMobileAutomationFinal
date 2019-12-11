@smoke @wishlist
Feature: Daraz Wishlist Management

  @21001151 @add_and_remove_item_without_open_wishlist_menu @28809425
  Scenario: Add and remove a product from wishlist without opening a wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    Then I verify item has been added to wishlist by success message
    And I remove the already added product from wishlist
    Then I verify item has been removed to wishlist by success message

  @21001151 @add_item_into_wishlist @28811386 @28809425
  Scenario: Add item into wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    Then I goto the wishlist to verify the added item

  @21001151 @remove_single_item_from_wishlist
  Scenario: Remove single item from wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    And I goto wishlist from PDP screen
    And I delete a single item form wishlist
    Then I verify that deleted item should not present in wishlist

  @21001151 @remove_all_items_from_wishlist @28810283
  Scenario: Remove all items from wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    And I goto wishlist from PDP screen
    And I delete all items form wishlist
    Then I verify that no item left in the wishlist

  @21001151 @add_product_from_cart_to_wishlist @28810197 @28810163 @28810262 @28810209 @28810212
  Scenario: Add a product from Cart to Wishlist
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I add a product from cart to wishlist
    Then I verify for added item in wishlist


#  @21001151 @remove_all_items_from_wishlist_without_add_item
#  Scenario: Remove all items from wishlist without add item
#    Given I select the venture
#    And I login using google account
#    And I open a wishlist
#    And I delete all items form wishlist
#    Then I verify that no item left in the wishlist


