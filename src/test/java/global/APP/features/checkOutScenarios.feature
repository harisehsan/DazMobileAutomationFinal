@smoke @checkoutScenarios
Feature: Verify Checkout Related Scenarios

  @21298974 @edit_addresses_to_verify_same_ship_and_bill_address_on_checkout @28810291 @28810294 @28810285
  Scenario: Edit addresses to verify same ship and bill address on checkout
    Given I select the venture
    And I navigate to the signin screen
    And I login with old buyer account
    And I navigate to address menu
    And I click on edit address button
    And I store the default address details
    And I make the address default billing and shipping address
    And I save the changes
    And I navigate back to the Home Page from "Address"
    And I search a Product using SKU for "Checkout"
    And I select the product for checkout
    And I select Buy Now button
    Then I verify the "same" shipping and billing addresses
    Then I verify the bottom line divider on checkout page


  @verify_PDP_page_price_and_Checkout_page_Price_should_be_same_for_single_product_free_shipping
  Scenario: I verify PDP page price and Checkout page Price should be same for single product Shipping not included
#      Given I select the "bd.live" venture
#    Given I select the "<Ventures>"
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I select the default address on pdp
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select all items in cart
    And I calculate the the price parameter in cart and store the price
    Then I verify the calculated price with total price in the cart
    And I click on checkout button in cart menu
    And I scroll down to the voucher
    When I calculate the prices parameters on checkout and store the resultant price value
    Then I compare the calculated price with the total price on checkout
    Then I compare the cart total price with checkout total price

#
#    Examples:
#      | Ventures |
#      | pk.live  |
#      | bd.live  |

  @validate_the_order_price_in_cart_and_match_with_PDP_use_multiple_products
  Scenario: validate the order price in cart and match with PDP use multiple products
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I skip the cart popup
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I select the default address on pdp
    And I add a product to cart
    And I navigate back to the main screen
    And I search product using sku for "Save more"
    And I goto the PDP page
    And I select the default address on pdp
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select all items in cart
    And I calculate the the price parameter in cart and store the price
    Then I verify the calculated price with total price in the cart
    And I click on checkout button in cart menu
    And I scroll down to the voucher
    When I calculate the prices parameters on checkout and store the resultant price value
    Then I compare the calculated price with the total price on checkout
    Then I compare the cart total price with checkout total price

  @validate_the_order_price_in_cart_and_match_with_PDP_use_multiple_quantity_free_shipping
  Scenario: validate the order price in cart and match with PDP use multiple quantity products free shipping
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I skip the cart popup
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I select the default address on pdp
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I change the quantity to 2
    And I select all items in cart
    And I calculate the the price parameter in cart and store the price
    Then I verify the calculated price with total price in the cart
    And I click on checkout button in cart menu
    And I scroll down to the voucher
    When I calculate the prices parameters on checkout and store the resultant price value
    Then I compare the calculated price with the total price on checkout
    Then I compare the cart total price with checkout total price

  @validate_the_order_price_in_cart_and_match_with_PDP_use_multiple_products_with_different_sellers
  Scenario: validate the order price in cart and match with PDP use multiple products with different sellers
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I skip the cart popup
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I select the default address on pdp
    And I add a product to cart
    And I navigate back to the main screen
    And I search for "samsung"
    And I goto the PDP page
    And I select the default address on pdp
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select all items in cart
    And I calculate the the price parameter in cart and store the price
    Then I verify the calculated price with total price in the cart
    And I click on checkout button in cart menu
    And I scroll down to the voucher
    When I calculate the prices parameters on checkout and store the resultant price value
    Then I compare the calculated price with the total price on checkout
    Then I compare the cart total price with checkout total price

  @validate_the_order_price_in_cart_and_match_with_PDP_use_multiple_products_with_different_sellers_voucher
  Scenario: validate the order price in cart and match with PDP use multiple products with different sellers with voucher
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I skip the cart popup
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search product using sku for "Voucher Collect"
    And I goto the PDP page
    And I select the default address on pdp
    And I check the existence of Voucher on PDP
    And I open voucher section
    And I click on collect button
    Then The voucher should be collected
    And I navigate back
    And I add a product to cart
    And I navigate back to the main screen
    And I search for "water"
    And I goto the PDP page
    And I select the default address on pdp
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select all items in cart
    When I scroll down to the voucher code section
    And I calculate the the price parameter in cart and store the price
    Then I verify the calculated price with total price in the cart
    And I click on checkout button in cart menu
    And I scroll down to the voucher
    When I calculate the prices parameters on checkout and store the resultant price value
    Then I compare the calculated price with the total price on checkout
    Then I compare the cart total price with checkout total price

  @validate_the_order_price_in_cart_and_match_with_PDP_use_single_product
  Scenario: validate the order price in cart and match with PDP use single product with voucher
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I skip the cart popup
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search product using sku for "Voucher Collect"
    And I goto the PDP page
    And I select the default address on pdp
    And I check the existence of Voucher on PDP
    And I open voucher section
    And I click on collect button
    Then The voucher should be collected
    And I navigate back
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select all items in cart
    When I scroll down to the voucher code section
    And I calculate the the price parameter in cart and store the price
    Then I verify the calculated price with total price in the cart
    And I click on checkout button in cart menu
    And I scroll down to the voucher
    When I calculate the prices parameters on checkout and store the resultant price value
    Then I compare the calculated price with the total price on checkout
    Then I compare the cart total price with checkout total price

  @validate_the_order_price_in_cart_and_match_with_PDP_use_multiple_quantity
  Scenario: validate the order price in cart and match with PDP use multiple quantity products
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I skip the cart popup
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search product using sku for "B1G1"
    And I select the product for cart
    And I select the default address on pdp
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I change the quantity to 2
    And I select all items in cart
    And I calculate the the price parameter in cart and store the price
    Then I verify the calculated price with total price in the cart
    And I click on checkout button in cart menu
    And I scroll down to the voucher
    When I calculate the prices parameters on checkout and store the resultant price value
    Then I compare the calculated price with the total price on checkout
    Then I compare the cart total price with checkout total price