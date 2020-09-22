@smoke @return&refund @30447331
Feature: Daraz Return & Refund Management

  @21001814 @verify_return_on_normal_product @37058581 @37058582
  Scenario: Verify return on normal product
    Given I select the venture
    And I navigate to the account menu
    And I select the pay now widget
    And I signin with google account
    And I select the pay now widget
    When I select all in my order
    And I skip the delivered popup
    Then I look for the delivered ordered for "Normal" product in my orders
    And I select return
    And I select reason for return
    And I provide comments for return
    And I select return shipping method
    And I click on submit button
    And I select continue button for delivery conformation
    Then I verify the information on return details screen

  @21001814 @verify_return_on_b1g1_product
  Scenario: Verify return on buy one get one product
    Given I select the venture
    And I navigate to the account menu
    And I select the pay now widget
    And I signin with google account
    And I select the pay now widget
    When I select all in my order
    And I skip the delivered popup
    Then I look for the delivered ordered for "B1G1" product in my orders
    And I select return
    And I select return bundle option
    And I select reason for return
    And I provide comments for return
    And I select return shipping method
    And I click on submit button
    And I select continue button for delivery conformation
    Then I verify the information on return details screen

  @21001814 @verify_return_on_free_gift_product
  Scenario: Verify return on free gift product
    Given I select the venture
    And I navigate to the account menu
    And I select the pay now widget
    And I signin with google account
    And I select the pay now widget
    When I select all in my order
    And I skip the delivered popup
    Then I look for the delivered ordered for "Free Gift" product in my orders
    And I select return
    And I select return bundle option
    And I select reason for return
    And I provide comments for return
    And I select return shipping method
    And I click on submit button
    And I select continue button for delivery conformation
    Then I verify the information on return details screen

  @21001814 @verify_return_on_buy_more_save_more_product
  Scenario: Verify return on buy more and save more product
    Given I select the venture
    And I navigate to the account menu
    And I select the pay now widget
    And I signin with google account
    And I select the pay now widget
    When I select all in my order
    And I skip the delivered popup
    Then I look for the delivered ordered for "Save more" product in my orders
    And I select return
    And I select return bundle option
    And I select reason for return
    And I provide comments for return
    And I select return shipping method
    And I click on submit button
    And I select continue button for delivery conformation
    Then I verify the information on return details screen

  @21001814 @verify_return_on_combo_product
  Scenario: Verify return on combo product
    Given I select the venture
    And I navigate to the account menu
    And I select the pay now widget
    And I signin with google account
    And I select the pay now widget
    When I select all in my order
    And I skip the delivered popup
    Then I look for the delivered ordered for "Combo" product in my orders
    And I select return
    And I select return bundle option
    And I select reason for return
    And I provide comments for return
    And I select return shipping method
    And I click on submit button
    And I select continue button for delivery conformation
    Then I verify the information on return details screen