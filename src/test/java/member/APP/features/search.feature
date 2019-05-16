@Test1
Feature: Search Product

  @SearchProduct
  Scenario: Search a product
    Given I select the venture
    And I Search for "Camera" Product
    Then I should see search results

