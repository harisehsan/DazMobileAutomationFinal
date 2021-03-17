@smoke @freeshipping
Feature: Verification of daraz free shipping

  @verify_the_free_shipping_no_condition
  Scenario: verify the free shipping for no condition
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search a Product using SKU for "Cart"
    And I select the product for cart
    And I get the product Name for checkout
    And I get the product Name
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select that product from cart for checkout
    Then I verify the enjoy free shipping text
    Then I verify the components of free shipping in cart
#    Then I compare the product price of product with the total price
    And I click on checkout button in cart menu
    Then I look for the shipping fee discount
#    Then I compare the product price of product with the total price

  @verify_the_free_shipping_free_shipping_quantity_condition
  Scenario: verify the free shipping for quantity condition
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search product using sku for "Save more"
    And I goto the PDP page
    And I get the product Name for checkout
    And I get the product Name
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    Then I should not see the the free shipping option
    And I select that product from cart for checkout
    And I change the quantity to 2
    Then I verify the enjoy free shipping text
    Then I verify the components of free shipping in cart
    And I click on checkout button in cart menu
    Then I look for the shipping fee discount

  @verify_the_free_shipping_for_amount_condition
  Scenario: verify the free shipping for amount condition
    Given I select the venture
    And I select cart
    And I login with old buyer account
    And I remove all items from cart
    Then I verify that all items in cart are successfully removed
    And I navigate back to the main screen
    And I search product using sku for "Combo"
    And I goto the PDP page
    And I get the product Name for checkout
    And I get the product Name
    And I add a product to cart
    And I goto cart menu from PDP screen
    And I skip the cart popup
    And I select that product from cart for checkout
    Then I should not see the the free shipping option
    And I add the products in cart to meet the amount requirement for free-shipping
    Then I verify the components of free shipping in cart
    And I click on checkout button in cart menu
    Then I look for the shipping fee discount