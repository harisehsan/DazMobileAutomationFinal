@smoke @cart
Feature: Daraz Cart Management

  @21001814 @add_item_without_open_cart_menu
  Scenario: Add a product to cart without opening a cart menu
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    Then I verify item has been added to cart by success message

  @21001814 @remove_single_item_from_cart @28811375 @28810239 @28810241 @28810183
  Scenario: Remove a single product from cart
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I remove a single item from cart
    Then I verify that removed item should not present in cart

  @21001814 @add_item_to_cart @28810277 @28810165
  Scenario: Add a product to cart
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart

  @21001814 @remove_all_items_from_cart @28810161 @28810273 @28810166 @28810160 @28810167
  Scenario: Remove all products from cart
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I check for the count in header and in tooltip

  @21001814 @add_product_from_wishlist_to_cart @28810240 @28810273
  Scenario: Add a product from Wishlist to Cart
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to wishlist
    And I signin with google account
    And I goto the wishlist to select the added product
    And I add a product to cart
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart


#  @21001814 @make_cart_empty_without_item_add
#  Scenario: Remove all products from cart without add product
#    Given I select the venture
#    And I select cart
#    And I signin with google account
#    And I remove all items from cart
#    Then I verify that all items in cart are successfully removed

  @21001814 @make_checkout_without_product_select @28810235 @28810175 @28810245 @28810245 @28810248 @28810247 @28810243 @28810272
  Scenario: Make checkout without product select and verify shop checkbox, check the shop name for product, check the current price and original price
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I click on checkout button in cart menu
    Then I should remain on the cart screen
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price

  @21001151 @add_combo_item_into_cart @28810191 @28810220 @28810190 @28810189
  Scenario: Add combo item into wishlist
    Given I select the venture
    And I search product using sku for "combo"
    And I goto the PDP page
    And I select the product
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price
    And I remove a single item from cart
    Then I verify that removed item should not present in cart

  @21001151 @add_combo_item_into_cart @28810188 @28810219 @28810187 @28810186
  Scenario: Add free gift item into cart
    Given I select the venture
    And I search product using sku for "Free Gift"
    And I goto the PDP page
    And I select the product
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price
    And I remove a single item from cart
    Then I verify that removed item should not present in cart

  @21001151 @add_combo_item_into_cart @28810195 @28810222 @28810196 @28810197
  Scenario: Add buy one get one item into cart
    Given I select the venture
    And I search product using sku for "B1G1"
    And I goto the PDP page
    And I select the product
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price
    And I remove a single item from cart
    Then I verify that removed item should not present in cart

  @21001151 @add_digital_item_into_cart @28810198 @28810199 @28810200
  Scenario: Add digital item into cart
    Given I select the venture
    And I search product using sku for "Digital"
    And I goto the PDP page
    And I select the product
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    Then I verify item has been added item in cart
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price
    And I remove a single item from cart
    Then I verify that removed item should not present in cart

  @21001814 @make_checkout_without_product_select @28810180
  Scenario: check the current price and original price
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I click on checkout button in cart menu
    Then I should remain on the cart screen
    Then I check for the product title
    Then I check for delivery Information
    Then I check for Current Price and Original Price









