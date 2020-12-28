@smoke @sort
Feature: Daraz Sorting Management

  @22204261 @price_low_to_high_sort @28809422 @28809422
  Scenario: price low to high sorting
    Given I select the venture
    And I search for "water"
    And I apply for the sort filter "Price low to high"
    Then I verify that product catalog is sorted according to the "Price low to high"

  @22204261 @price_high_to_low_sort @28809422 @28809422
  Scenario: price high to low sorting
    Given I select the venture
    And I search for "water"
    And I apply for the sort filter "Price high to low"
    Then I verify that product catalog is sorted according to the "Price high to low"

#  @22204261 @price_low_to_high_sort_daraz_mall @28809422 @28809422
#  Scenario: price low to high sorting in Daraz mall
#    Given I select the venture
#    And I search for "water"
#    And I goto the Daraz Mall
#    And I apply for the sort filter "Price low to high"
#    Then I verify that product catalog is sorted according to the "Price low to high"

#  @22204261 @price_high_to_low_sort_daraz_mall @28809422 @28809422
#  Scenario: price high to low sorting in Daraz mall
#    Given I select the venture
#    And I search for "water"
#    And I goto the Daraz Mall
#    And I apply for the sort filter "Price high to low"
#    Then I verify that product catalog is sorted according to the "Price high to low"

  @22204261 @apply_brand_filter_on_search @28809423
  Scenario: Apply brand filer
    Given I select the venture
    And I search for "Samsung mobile"
    And I select filter
    And I apply filter for "Samsung" Brand
    And I verify for the applied brand filter

#  @22204261 @apply_brand_filter_on_search_daraz_mall @28809423
#  Scenario: Apply brand filer in Daraz mall
#    Given I select the venture
#    And I search for "Samsung"
#    And I goto the Daraz Mall
#    And I select filter
#    And I apply filter for "Samsung" Brand
#    And I verify for the applied brand filter

  @23184571 @price_high_to_low_filter_in_store @28809426 @28809427 @28809428 @28809429 @28809424 @37058345
  Scenario: Select all product in search hint of store, shown catalog in list view and Price high to low filter
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on store button
    And I select all-products in the search hint option
    And I apply for the sort filter "Price high to low"
    And I change the catalog view to "listview"
    Then I verify that product catalog is sorted according to the "Price high to low" on store page

  @23184571 @price_low_to_high_filter_in_store @28809426 @28809427 @28809428 @28809429 @28809424 @37058345
  Scenario: Select all product in search hint of store, shown catalog in list view and Price low to High filter
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on store button
    And I select all-products in the search hint option
    And I apply for the sort filter "Price low to high"
    And I change the catalog view to "listview"
    Then I verify that product catalog is sorted according to the "Price low to high" on store page
