@smoke @flashsale
Feature: Daraz Flash Sale Management

  @22204261 @check_flash_sale_countdown
  Scenario: Flashsale count down timer check
    Given I select the venture
    And I check for the existence of the flash sale
    Then I check the existence of flash sale remaining time

  @22204261 @navigate_to_pdp_from_flashsale
  Scenario: Navigate to the PDP page from flashsale
    Given I select the venture
    And I goto the flashsale
    And I goto the PDP screen from flashsale
    Then I should see the number of sales, discount rate, product price


