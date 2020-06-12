@smoke @search
Feature: Daraz Search Product Management

  @21842974 @search_a_product_by_sku
  Scenario: Search a product by sku
    Given I select the venture
    And I search a Product using SKU for "Result"
    Then I should see search results

  @21842974 @search_a_product_by_name
  Scenario: Search a product by name
    Given I select the venture
    And I search for "hand sanitizer"
    Then I should see search products

  @21842974 @search_a_product_by_search_history @28809419
  Scenario: Search a product by search history and then delete search history
    Given I select the venture
    And I search for "hand sanitizer"
    And I navigate back to the main screen
    And I search a product using search history
    Then I should see search products
    And I delete the search history
    Then I should not see the search history

  @21842974 @search_by_suggestion_result @28809421
  Scenario: Search a product by using suggestion result
    Given I select the venture
    And I use "jacket" keyword to verify the search suggestion results
    And I select a suggestion result for search
    Then I should see search results

  @21842974 @search_by_incorrect_keyword @28809420
  Scenario: Search a product by incorrect keyword
    Given I select the venture
    And I search for "watet"
    Then I look for the did you mean option

#  @23184571 @search_on_category_page @28809432
#  Scenario: Search on categories page
#    Given I select the venture
#    And I skip the shake shake popup
#    And I scroll down to categories section on homepage
#    And I select shop more for categories
#    And I should be on the categories page
#    And I search for "hand sanitizer" in the categories section
#    Then I should see search products

    @23184571 @search_on_store_page @28809430
    Scenario: Search on store page
      Given I select the venture
      And I goto the store page from Homepage
      And I search a product in store page
      Then I should see search products
      Then I goto the PDP page from store page