@smoke @wishlist # Temproary Not Available for Sri Lanka (LK)
Feature: Daraz Wishlist Management

  @21001151 @check_for_watchlist_out_of_stock_back_in_stock_in_wishlist @28810149 @28810157 @28810134
  Scenario: Check for Watchlist, Out of Stock, Back in stock sections in wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    And I goto wishlist from PDP screen
    Then I check for the watchlist, Out of Stock or Back In Stock sections in wishlist

  @21001151 @check_just_for_you_in_wishlist @28810139 @28810144 @28810143 @28810138
  Scenario: check for just for you section in wishlist
    Given I select the venture
    And I login using google account
    And I open a wishlist
    Then I scroll down to just for you section

  @21001151 @remove_all_items_from_wishlist @28810283 @28810140 @28810143 @28810138
  Scenario: Remove all items from wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    And I goto wishlist from PDP screen
    And I delete all items form wishlist
    Then I verify that no item left in the wishlist
    And I check for no favourite item message
    And I click on Continue shopping button
    Then I should be on the homepage

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

  @21001151 @add_item_into_wishlist @28811386 @28809425 @28810157 @28810142 @28810158
  Scenario: Add item into wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    Then I goto the wishlist to verify the added item

  @21001151 @remove_single_item_from_wishlist @28810148
  Scenario: Remove single item from wishlist
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    And I goto wishlist from PDP screen
    And I delete a single item form wishlist
    Then I verify that deleted item should not present in wishlist

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

  @21001151 @add_all_items_from_wishlist_to_cart @28810133
  Scenario: Add all wishlist items into cart
    Given I select the venture
    And I search a Product using SKU for "Wishlist"
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    And I goto wishlist from PDP screen
    And I click on the add all to cart button
    And I navigate to cart from wishlist
    Then I should see the added products in the cart

  @21001151 @add_combo_item_into_wishlist @28810158
  Scenario: Add combo item into wishlist
    Given I select the venture
    And I search product using sku for "Combo"
    And I goto the PDP page
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    Then I goto the wishlist to verify the added item

  @21001151 @add_free_gift_item_into_wishlist @28810158
  Scenario: Add free gift item into wishlist
    Given I select the venture
    And I search product using sku for "Free Gift"
    And I goto the PDP page
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    Then I goto the wishlist to verify the added item

  @21001151 @add_buy_one_get_one_into_wishlist @28810158
  Scenario: Add buy one get one item into wishlist
    Given I select the venture
    And I search product using sku for "B1G1"
    And I goto the PDP page
    And I select the product
    And I add a product to wishlist
    And I signin with google account
    Then I goto the wishlist to verify the added item
