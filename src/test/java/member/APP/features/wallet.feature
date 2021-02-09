@smoke @wallet
Feature: Daraz Wallet Management

  @32135879 @verify_the_components_of_daraz_wallet_screen
  Scenario: verify the components of wallet screen
    Given I select the venture
    And I click on wallet icon
    Then I verify the components of wallet screen before login
    When I select Login button on "wallet" screen
    When I login with old buyer account
    Then I should be on the wallet activation page
    And I navigate back
    Then I should see the activate button on wallet screen
    And I navigate back to the main screen
    And I navigate to the account menu
    And I log out
    And I navigate back to the main screen
    And I click on wallet icon
    When I select Login button on "wallet" screen
    And I select switch to another account
    And I select first login button
    And I enter the email "daraz_qa200@test.com" and password "Test123" for the activated wallet account
    And I select login button
    Then I verify the components of wallet for the activated account

  @32135879 @verify_the_navigation_from_wallet_screen
  Scenario: verify the navigation from the wallet screen
    Given I select the venture
    And I click on wallet icon
    When I select Login button on "wallet" screen
    And I select first login button
    And I enter the email "daraz_qa200@test.com" and password "Test123" for the activated wallet account
    And I select login button
    And I select the top up button
    Then I should be on deposit screen
    And I navigate back
    And I select balance details
    Then I should be on the balance details screen
    And I navigate back
    When I select mobile reload
    Then I should be on the mobile reload page

  @32135879 @verify_the_transaction_part_wallet_section
  Scenario: verify the transaction section of wallet section
    Given I select the venture
    And I click on wallet icon
    When I select Login button on "wallet" screen
    And I select first login button
    And I enter the email "daraz_qa200@test.com" and password "Test123" for the activated wallet account
    And I select login button
    Then I verify the components of all transaction section
    When I goto the purchase section of the wallet
    Then I verify the purchase section of wallet
    When I goto the refund section of wallet
    Then I verify the components of refund section of wallet
    When I select the topups section of the wallet
    Then I verify the top up section of the wallet section
    When I goto the coupon section of the wallet
    Then I should be on the coupon section
    When I goto the withdrawals section of wallet
    Then I should be on withdrawals section of wallet