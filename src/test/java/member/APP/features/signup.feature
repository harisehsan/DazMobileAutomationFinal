#@smoke @signup
#Feature: Signup new Daraz Account
#
# @20580001 @signup_google @30524871 @30524876 @30524878 @30524877 @30524879 @30524874 @30524875 @30526017 @30526019 @30526020 @30526021 @30526023 @30526025 @30526044
#  Scenario: Signup with Google Account
#    Given I select the venture
#    And I navigate to the signup screen
#    And I select signup using google account
#    And I provide name for google account
#    And I select date of birth and gender for google account
#    And I provide the email address for google account
#    And I provide password for google account
#    And I accept privacy terms and conditions for google account
#    And I should be signed up using google account
#    Then I log out
#
#  @20580001 @signup_facebook @30524871 @30524876 @30524878 @30524877 @30524879 @30524874 @30524875 @30526017 @30526019 @30526020 @30526021 @30526023 @30526025 @30526044
#  Scenario: Signup with Facebook Account
#    Given I select the venture
#    And I navigate to the signup screen
#    And I select signup using facebook option
#    And I agree the policy agreement for facebook account
#    And I provide name email and password for facebook account
#    And I should be signed up using facebook account
#    Then I log out