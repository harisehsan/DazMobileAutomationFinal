@smoke @collections
Feature: Daraz Collections Management

  @22614390 @view_collections_module_on_homepage
  Scenario: View the collections module existence on home page
    Given I select the venture
    Then I check the existence of the Collections on Homepage

  @22614390 @select_collections_and_back_to_homepage
  Scenario: Select collections and navigate back to homepage
    Given I select the venture
    And I click on Shop more button to enter to collections page
    Then I should be on collection page
    And I navigate back to the Home Page from "Collections"
    Then I check again the existence of the Collections on Homepage

  @22614390 @change_language_and_check_the_existence_of_collections
  Scenario: Change the language and check the existence of collections on homepage
    Given I select the venture
    Then I navigate to the account settings menu
    And I change the language other then english
    Then I check for the existence of the Collections on Homepage in the local language of the venture