@smoke @cart
Feature: Daraz Cart Management

  @21001814 @remove_all_items_from_cart @28810161 @28810273 @28810166 @28810160 @28810167 @37058386
  Scenario: Remove all items in Cart
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I check for the count in header and in tooltip
    Then I should see the empty cart
    When I select continue shopping
    Then I should be on the homepage


#  @21001814 @add_item_without_open_cart_menu
#  Scenario: Add a product to cart without opening a cart menu
#    Given I select the venture
#    And I search a Product using SKU for "Cart"
#    And I select the product for cart
#    And I add a product to cart
#    And I signin with google account
#    Then I verify item has been added to cart by success message

#  @21001814 @remove_single_item_from_cart
#  Scenario: Remove a single product from cart
#    Given I select the venture
#    And I search a Product using SKU for "Cart"
#    And I select the product for cart
#    And I add a product to cart
#    And I signin with google account
#    And I goto cart menu from PDP screen
#    And I skip the cart popup
#    And I scroll down to view product in cart
#    And I slide the item in the cart to view the delete button and delete the item
#    Then I verify that removed item should not present in cart

  @21001814 @add_and_remove_item_to_cart @28810277 @28810165 @28811375 @28810239 @28810241 @28810183 @28810286 @37058480 @37058457 @37058386
  Scenario: Add and remove product to cart
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product in cart
    Then I verify item has been added item in cart
    Then I verify for non-empty cart
    When I click on product in cart
    Then I should be on its PDP page
    And I navigate back
    Then I verify that delete button is hidden by default
    And I slide the item in the cart to view the delete button and delete the item
    Then I verify that removed item should not present in cart

  @21001814 @add_product_from_wishlist_to_cart @28810240 @28810273 @28810182
  Scenario: Add a product from Wishlist to Cart
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to wishlist
    And I signin with google account
    And I goto the wishlist to select the added product
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product in cart
    Then I verify item has been added item in cart


#  @21001814 @make_cart_empty_without_item_add
#  Scenario: Remove all products from cart without add product
#    Given I select the venture
#    And I select cart
#    And I signin with google account
#    And I remove all items from cart
#    Then I verify that all items in cart are successfully removed

  @21001814 @make_checkout_without_product_select_and_verify_prices @28810235 @28810175 @28810245 @28810245 @28810248 @28810247 @28810243 @28810272 @28810180 @37058425
  Scenario: Make checkout without product select and verify shop checkbox, check the shop name for product, check the current price, original price, shipping price and total price
    Given I select the venture
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I click on checkout button in cart menu
    Then I should remain on the cart screen
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price and promotion ratio
    Then I check the existence of quantity
    Then I check for the shipping fee and grand total price

  @21001151 @add_and_remove_combo_item_into_cart @28810191 @28810220 @28810190 @28810189
  Scenario: Add combo item into cart and then remove it
    Given I select the venture
    And I search product using sku for "Combo"
    And I goto the PDP page
    And I get the product Name
    And I add a combo product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product name and promotion "Combo" in cart
    Then I verify item has been added item in cart with promotion "Combo"
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price and promotion ratio
    And I slide the item in the cart to view the delete button and delete the item
    Then I verify that removed item should not present in cart

  @21001151 @add_and_remove_free_gift_item_into_cart @28810188 @28810219 @28810187 @28810186
  Scenario: Add free gift item into cart and then remove it
    Given I select the venture
    And I search product using sku for "Free Gift"
    And I goto the PDP page
    And I get the product Name
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product name and promotion "Free Gift" in cart
    Then I verify item has been added item in cart with promotion "Free Gift"
    And I scroll down to view product in cart
    Then I verify item has been added item in cart
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price and promotion ratio
    And I slide the item in the cart to view the delete button and delete the item
    Then I verify that removed item should not present in cart

  @21001151 @add_and_remove_buy_one_get_one_item_into_cart @28810195 @28810222 @28810196 @28810197
  Scenario: Add buy one get one item into cart then remove it
    Given I select the venture
    And I search product using sku for "B1G1"
    And I goto the PDP page
    And I get the product Name
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product name and promotion "Buy 1 Get 1 Free" in cart
    Then I verify item has been added item in cart with promotion "Buy 1 Get 1 Free"
    When I click on product in cart
    Then I should be on its PDP page
    And I navigate back
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price and promotion ratio
    And I slide the item in the cart to view the delete button and delete the item
    Then I verify that removed item should not present in cart

  @21001151 @add_and_remove_buy_more_save_more_item_into_cart @37058422 @37058423 @37058424
  Scenario: Add and remove buy more and save more item into cart then remove it
    Given I select the venture
    And I search product using sku for "Save more"
    And I goto the PDP page
    And I get the product Name
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product name and promotion "Buy More & Save Up" in cart
    Then I verify item has been added item in cart with promotion "Buy More & Save Up"
    When I click on product in cart
    Then I should be on its PDP page
    And I navigate back
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price and promotion ratio
    And I slide the item in the cart to view the delete button and delete the item
    Then I verify that removed item should not present in cart

  @21001151 @add_and_remove_digital_item_into_cart @28810198 @28810199 @28810200 @37058428
  Scenario: Add digital item into cart
    Given I select the venture
    And I search product using sku for "Digital"
    And I goto the PDP page
    And I get the product Name
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product in cart
    Then I verify item has been added item in cart
    When I click on product in cart
    Then I should be on its PDP page
    And I navigate back
    Then I check shop checkbox for product
    Then I check for shop name for product
    Then I check for Current Price and Original Price and promotion ratio
    And I slide the item in the cart to view the delete button and delete the item
    Then I verify that removed item should not present in cart

  @21001151 @verify_voucher_collect_cart @37058392 @37058394
  Scenario: verify the voucher collect in cart
    Given I select the venture
    And I search product using sku for "Voucher Collect"
    And I goto the PDP page
    And I get the product Name
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
#    And I scroll down to view product in cart
    When I select get voucher in cart
    Then I verify voucher From Total Amount Spend and Validity
#    Then I verify the components of get voucher popup in cart
    Then I verify the voucher collection for the "first" time
#    And I close the get voucher popup
#    When I select get voucher in cart
#    Then I verify the voucher collection for the "Second" time

  @28811393 @verify_pdp_and_cart_voucher_code_section @28811316 @37058439 @37058440 @37058441 @37058442
  Scenario: Verify PDP voucher copy feature for PDP & cart
    Given I select the venture
    And I search product using sku for "Voucher Code"
    And I goto the PDP page
    And I get the product Name
    And I check the existence of Voucher on PDP
    And I open voucher section
    And I click on copy button
    Then The voucher code should be copied
    And I close the get voucher popup on PDP
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I scroll down to view product in cart
    And I select checkbox for that product
    When I scroll down to the voucher code section
    Then I verify the components of voucher code section
    Then I verify the apply button is not clickable if the voucher text box is empty
    When I enter the "wrong" voucher code
    And I click on apply button
    Then I should see the validation error
    And I select voucher code clear button
    Then voucher code should be removed from the text field
    When I enter the "correct" voucher code
    And I click on apply button
    Then I should see the impact of voucher code on total price