@smoke @signup
Feature: Login Management for Daraz
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

  @2058001 @goto_login_page_from_message @30524878
  Scenario: Navigate to login page from message page
    Given I select the venture
    And I select message
#    When I select Login button on "message" screen
    Then I should be on the login page

  @2058001 @goto_login_page_from_wallet @30524878
  Scenario: Navigate to login page from wallet
    Given I select the venture
    And I click on wallet icon
    When I select Login button on "wallet" screen
    Then I should be on the login page

  @2058001 @facebook_login @30524875 @30524887
  Scenario: Navigate to login page from facebook
    Given I select the venture
    And I navigate to the signin screen
    When I select Login button on "facebook" screen
#    And I select agree button
    Then I should be login successfully
    Then I log out

  @2058001 @verify_forget_password_interface @30524889 @30524888
  Scenario: verify foreget password Interface
    Given I select the venture
    And I navigate to the signin screen
#    And I select first login button
    When I select forget password link
    Then I should be on the reset password page

  @2058001 @email_password_login @30524876
  Scenario: Login through email and password
    Given I select the venture
    And I navigate to the signin screen
    And I select first login button
    When I enter email
    And I enter password
    And I select login button
    Then I should be login successfully

#  @2058001 @verify_mailbox_registration_interface @30524882 @37058636
#  Scenario: verify the mail box interface
#    Given I select the venture
#    And I navigate to the signin screen
#    And I select first login button
#    When I select create an account
#    Then I should be on the create account page