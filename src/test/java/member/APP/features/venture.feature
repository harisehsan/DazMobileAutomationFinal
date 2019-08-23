@smoke @venture
  Feature: Daraz Venture Management

  @21969750 @select_venture @no_mm
  Scenario: I select a venture
    Given I select the venture
    And I navigate to the country menu
    Then I check for the selected venture

  @21969750 @change_venture @no_mm
  Scenario: I change a venture
    Given I select the venture
    And I navigate to the country menu
    And I change the venture
    And I navigate to the country menu
    Then I verify for the changed venture