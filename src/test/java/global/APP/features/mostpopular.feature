#@smoke @mostpopular
#  Feature: Daraz Most Popular Management for Homepage
#
#  @22953678 @verify_the_existence_of_most_popular_and_month @28811827
#  Scenario: Verify the existence of most popular and month
#    Given I select the venture
#    And I skip the shake shake popup
#    And I check the existence of the most popular on Homepage
#    Then I verify for the existence of month for most popular
#
#
#  @22953678 @verify_the_existence_of_most_popular_in_local_language @28811826 @30526041
#  Scenario: verify the existence of most popular in local language
#    Given I select the venture
#    And I skip the shake shake popup
#    Then I navigate to the account settings menu
#    And I change the language other then english
#    Then I check the existence of most popular in the local language
#
#    @22953678 @select_the_most_popular_classification @28811825 @28811825
#    Scenario: Select the most popular classification
#      Given I select the venture
#      And I skip the shake shake popup
#      And I check the existence of the most popular on Homepage
#      And I select the most popular classification
#      Then I should be on most popular classification page
