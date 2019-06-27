@smoke @wishlist
Feature: Daraz Wishlist Management

  @21001151 @add_and_remove_item_without_open_wishlist_menu
  Scenario: Add and remove a product from wishlist without opening a wishlist
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the test product
    And I add a product to wishlist
    And I should signin if require
    Then I verify item has been added to wishlist by success message
    And I remove the already added product from wishlist
    Then I verify item has been removed to wishlist by success message

  @21001151 @add_item_into_wishlist
  Scenario: Add item into wishlist
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the test product
    And I add a product to wishlist
    And I should signin if require
    Then I goto the wishlist to verify the added item

  @21001151 @remove_single_item_from_wishlist
  Scenario: Remove single item from wishlist
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the test product
    And I add a product to wishlist
    And I should signin if require
    And I goto wishlist from PDP screen
    And I delete a single item form wishlist
    Then I verify that deleted item should not present in wishlist

  @21001151 @remove_all_items_from_wishlist
  Scenario: Remove all items from wishlist
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the test product
    And I add a product to wishlist
    And I should signin if require
    And I goto wishlist from PDP screen
    And I delete all items form wishlist
    Then I verify that no item left in the wishlist

#  @21001151 @remove_all_items_from_wishlist_without_add_item
#  Scenario: Remove all items from wishlist without add item
#    Given I select the venture
#    And I should login
#    And I open a wishlist
#    And I delete all items form wishlist
#    Then I verify that no item left in the wishlist


