@smoke @address
Feature: Daraz Address Management

  @21298974 @edit_the_address_details
  Scenario: change the address details
    Given I select the venture
    And I navigate to the signin screen
    And I should signin if require
    And I navigate to edit address screen
    And I edit the address details
    And I save the changes
    Then I verify the address details