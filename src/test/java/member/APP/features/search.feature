@Test1
Feature: Search Product

  @SearchProduct
  Scenario: Search a product
    Given I select the venture
    And I Search a Product for "Result"
    Then I should see search results

