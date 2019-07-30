@smoke @signup
Feature: Signup new Daraz Account

 @20580001 @signup_google
  Scenario: Signup with Google Account
    Given I select the venture
    And I navigate to the signup screen
    And I select signup using google account
    And I provide name for google account
    And I select date of birth and gender for google account
    And I provide the email address for google account
    And I provide password for google account
    And I accept privacy terms and conditions for google account
    And I should be signed up using google account
    Then I log out

  @20580001 @signup_facebook
  Scenario: Signup with Facebook Account
    Given I select the venture
    And I navigate to the signup screen
    And I select signup using facebook option
    And I agree the policy agreement for facebook account
    And I provide name email and password for facebook account
    And I should be signed up using facebook account
    Then I log out