@smoke @Signup
Feature: Search Product

 @20580001 @Signup_gmail
  Scenario: Search a product
    Given I select the venture
    And I navigate to the signup screen
    And I signup using gmail option
    And I should be signed up using gmail account
    Then I log out

  @20580001 @Signup_facebook
  Scenario: Search a product
    Given I select the venture
    And I navigate to the signup screen
    And I signup using facebook option
    And I should be signed up using facebook account
    Then I log out