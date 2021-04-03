@smoke @checkoutScenarios
Feature: Verify Checkout Related Scenarios

  @singleProductCheckout
  Scenario: I verify PDP page price and Checkout page Price should be same for single product Shipping not included
#      Given I select the "bd.live" venture
#      Given I select the "<Ventures>"
    Given I select the venture
    And I search for "Ac"
    And I should see search products
    And I click on Free Shipping Icon on search results
    And I should see search products
    And I goto the PDP page
    And I save the product title, product price
    And I select Buy Now button
    And I login with old buyer account
    And I scroll to view the product on checkout screen
    And I save the total price on checkout screen
    Then I compare the product price of product with the total price

#        Examples:
#            | Ventures|
#            | mm.live |
