@smoke @flashsale
Feature: Daraz Flash Sale Management

  @22439570 @check_flash_sale_countdown
  Scenario: Flash Sale countdown timer check
    Given I select the venture
    And I check for the existence of the Flash Sale on Homepage
    Then I check the existence of Flash Sale remaining time on Homepage

  @22439570 @navigate_to_pdp_from_flashsale
  Scenario: Navigate to the PDP page from Flash Sale page
    Given I select the venture
    And I click Shop More button to navigate to the Flash Sale page
    And I goto the PDP page from Flash Sale page
    Then I should see the number of sales, discount rate and product price on PDP page


