@smoke @privatezone
Feature: Daraz Private Zone Management

  @21298974 @verify_the_elements_of_store @37058342
  Scenario: verify the elements of the store
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on store button
    And I wait for store page to load
    Then I verify the components of the store page
    And I select the options button on the store page
    Then I should see the share this store button

  @21298974 @navigate_to_the_categories_page_and_profile_page_from_store @37056860 @37058348 @37058349
  Scenario: verify the elements of the store
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on store button
    And I wait for store page to load
    And I navigate to categories from store
    Then I should see the "All Products" on the categories page
    And I navigate back
    And I wait for store page to load
    And I navigate to Profile from store
    Then I should be on the profile page

  @21298974 @follow_and_unfollow_the_store @37058343 @37058350
  Scenario: I follow and unfollow the store
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on store button
    And I wait for store page to load
    And I click on Follow button
    And I select first login button
    When I enter email
    And I enter password
    And I select login button
    And I skip the got it popup
    Then I should be followed that store
    And I select following button to unfollow the store
    And I skip the got it popup
    Then I should follow button again

