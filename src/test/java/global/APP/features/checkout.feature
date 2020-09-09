@smoke @checkout
Feature: Daraz Checkout Management

#  @21001814 @proceed_to_checkout_from_cart @28810162 @28810395 @28810439 @30564196 @30564196 @30564632 @30564633 @30564635 @30564636
#  Scenario: Make a checkout from cart product
#    Given I select the venture
#    And I search a Product using SKU for "Checkout"
#    And I select the product for checkout
#    And I add a product to cart
#    And I signin with google account
#    And I goto cart menu from PDP screen
#    And I select that product from cart for checkout
#    And I click on checkout button in cart menu
#    And I click on proceed to pay button
#    And I select Cash on Delivery payment method
#    And I should reach to order successful page
#    And I click on Track Order button
#    Then I verify that order has been placed

#  @21001814 @proceed_to_checkout_from_cart_by_changing_quantity @28810394 @28810395 @28810439 @30564196 @30564196 @30564632 @30564633 @30564635 @30564636 @28810286
#  Scenario: Make a checkout from cart product by changing product quantity
#    Given I select the venture
#    And I search a Product using SKU for "Checkout"
#    And I select the product for checkout
#    And I add a product to cart
#    And I signin with google account
#    And I goto cart menu from PDP screen
#    And I select that product from cart for checkout
#    And I change the quantity to 5
#    And I click on checkout button in cart menu
#    And I slide the product to view the delete button
#    And I click on delete button checkout
#    Then I should see the snackbar error message
#    And I click on proceed to pay button
#    And I select Cash on Delivery payment method
#    And I should reach to order successful page
#    And I click on Track Order button
#    Then I verify that order has been placed with that quantity

    @21001814 @make_cart_empty_without_item_add
  Scenario: Remove all products from cart without add product
    Given I select the venture
    And I select cart
    And I signin with google account
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed

  @21001814 @delete_combo_product_on_checkout @28810302 @28810287
  Scenario: delete the combo product on checkout
    Given I select the venture
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I add a product to cart
    And I signin with google account
    And I should be on the PDP page
    And I navigate back to the Home Page from "PDP"
    And I search product using sku for "Combo"
    And I goto the PDP page
    And I get the product Name for checkout
    And I add a combo product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select all items in cart
    And I click on checkout button in cart menu
    And I swipe the main "Combo" product on checkout screen to view delete button
    And I click on delete button checkout
    Then I verify that entire "Combo" promotion should be deleted on checkout screen

  @21001814 @check_buy_one_get_one_logo_on_checkout @28810303
  Scenario: check buy one get logo on checkout
    Given I select the venture
    And I search product using sku for "B1G1"
    And I goto the PDP page
    And I get the product Name for checkout
    And I select Buy Now button
    And I signin with google account
    Then I verify the existence of "Buy 1 Get 1 Free" promotion on checkout
    Then I verify "1 Item(s)" is not displayed on checkout

  @21001814 @check_buy_more_save_more_logo_on_checkout @28810304
  Scenario: check buy more and save more logo on checkout
    Given I select the venture
    And I search product using sku for "Save more"
    And I goto the PDP page
    And I get the product Name for checkout
    And I select Buy Now button
    And I signin with google account
    Then I verify the existence of "Buy More & Save Up" promotion on checkout

  @21001814 @free_gift_logo_and_items_on_checkout @28810305
  Scenario: free gift logo and items on checkout
    Given I select the venture
    And I search product using sku for "Free Gift"
    And I goto the PDP page
    And I get the product Name for checkout
    And I select Buy Now button
    And I signin with google account
    Then I verify the existence of "Free Gift" promotion on checkout
    Then I verify "1 Item(s)" is not displayed on checkout

  @21298974 @edit_address_on_checkout @28810290
  Scenario: Edit address on checkout
      Given I select the venture
      And I search a Product using SKU for "Checkout"
      And I select the product for checkout
      And I select Buy Now button
      And I signin with google account
      And I click on edit address button on checkout
      And I click on edit address button
      And I edit the address details
      And I save the changes
     Then I verify the address details

  @21298974 @edit_addresses_to_verify_different_ship_and_bill_address_on_checkout @28810291 @30523164
  Scenario: Edit addresses to verify different ship and bill address on checkout
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on edit address button
    And I make the address default billing and shipping address
    And I save the changes
    And I click on new address button
    And I add the address details
    And I make the address default "shipping" address only
    And I save the changes
    And I navigate back to the Home Page from "Address"
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    Then I verify the "different" shipping and billing addresses

  @21298974 @edit_addresses_to_verify_same_ship_and_bill_address_on_checkout @28810291 @28810294 @28810285
  Scenario: Edit addresses to verify same ship and bill address on checkout
    Given I select the venture
    And I navigate to the signin screen
    And I signin with google account
    And I navigate to address menu
    And I click on edit address button
    And I make the address default billing and shipping address
    And I save the changes
    And I navigate back to the Home Page from "Address"
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    Then I verify the "same" shipping and billing addresses
    Then I verify the bottom line divider on checkout page

  @21001151 @verify_the_attributes_of_digital_goods @28810296 @28810306
  Scenario: Add digital item into cart
    Given I select the venture
    And I search product using sku for "Digital"
    And I goto the PDP page
    And I get the product Name
    And I select Buy Now button
    And I signin with google account
    Then I verify the existence of delivery time and email address on checkout
    Then I verify the main product map, product title, product attributes, product price, line price, quantity of goods