@smoke @justforyou @23047870
Feature: Just For You Management for Daraz Homepage

  @23047870 @scroll_to_just_for_you_and_verify_the_product_details @28811867 @28811871 @28811872 @28811869 @28811870 @28811873
  Scenario: Scroll to just for you and verify the product details
    Given I select the venture
    And I skip the shake shake popup
    And I scroll down to Just For You Section on Homepage and check its existence
    And I Check for the product title, current price and star
    And I Check for the discount rate and original price
    And I goto the PDP page from just for you catalog
    Then I should see the consistent information on PDP page

  @23047870 @verify_the_existence_of_just_for_you_in_local_language @28811868
  Scenario: Verify the existence of just for you in local language
    Given I select the venture
    And I navigate to the account settings menu
    And I change the language other then english
    And I skip the shake shake popup
    And I scroll down to Just For You Section on Homepage and check its existence in local language





