@smoke @wishlist
Feature: Wishlist Management

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
  Scenario: Add and remove a product from wishlist without opening a wishlist
    Given I select the venture
    And I Search for "Test Product" Product
    And I select the test product
    And I add a product to wishlist
    And I should signin if require
    Then I goto the wishlist to verify the added item

  @21001151 @remove_single_item_from_wishlist
  Scenario: Add and remove a product from wishlist without opening a wishlist
    Given I select the venture
    And I should login
    And I open a wishlist
    Then I delete a single item form wishlist

  @21001151 @remove_all_items_from_wishlist
  Scenario: Add and remove a product from wishlist without opening a wishlist
    Given I select the venture
    And I should login
    And I open a wishlist
    And I delete all items form wishlist
    Then I verify that no item left in the wishlist


