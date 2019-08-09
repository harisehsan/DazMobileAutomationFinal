@smoke @search
Feature: Daraz Search Product Management

  @21842974 @search_a_product_by_sku
  Scenario: Search a product by name
    Given I select the venture
    And I search a Product using SKU for "Result"
    Then I should see search results

  @21842974 @search_a_product_by_name
  Scenario: Search a product by name
    Given I select the venture
    And I search for "PS4"
    Then I should see search products

  @21842974 @search_a_product_by_search_history
  Scenario: Search a product by search history
    Given I select the venture
    And I search for "PS4"
    And I navigate back to the main screen
    And I search a product using search history
    Then I should see search products

  @21842974 @search_by_suggestion_result
  Scenario: Search a product by using suggestion result
    Given I select the venture
    And I use "jacket" keyword to verify the search suggestion results
    And I select a suggestion result for search
    Then I should see search results

  @21842974 @search_by_incorrect_keyword
  Scenario: Search a product by incorrect keyword
    Given I select the venture
    And I search for "watet"
    Then I look for the did you mean option
