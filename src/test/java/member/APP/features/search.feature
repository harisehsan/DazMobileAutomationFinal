@Test1
Feature: Search Product

  @SearchProduct
  Scenario: Search a product
    Given I select the venture
    And I Search for "DSLR" Product
    Then I should see search results

#  @SearchTest2
#  Scenario: Search a product
#    And I Search for "PS4" Product
##    And I tap on search button
##    Then I should Search result

