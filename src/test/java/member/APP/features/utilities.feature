@smoke @utilities
Feature: Daraz Utilities Management

  @32135879 @verify_the_components_of_dbills_pk
  Scenario: verify The components of dbills pk
    Given I select the venture
    And I close the first order voucher popup
    And I navigate to the signin screen
    And I select first login button
    And I enter the email "daraz_qa200@test.com" and password "Test123"
    And I select login button
    And I navigate back to the main screen
    When I select dbill channnel
    Then I should be on the utility checkout screen
    Then I should see bill type(s)
    When I select the banner
    Then I should be on the banner screen
    And I navigate back
    When I select the pay bill button
    Then I verify the components of utility
    Then I should see bill type(s)
    And I scroll to view the banner
    Then I verify the banner of the utility checkout
    When I select proceed to pay button
    Then I should be on the select payment screen

  @32135879 @Enter_the_bill_details_and_verify_pk
  Scenario: Enter the bill details and verify pk
    Given I select the venture
    And I close the first order voucher popup
    And I navigate to the signin screen
    And I login with old buyer account
    And I navigate back to the main screen
    When I select dbill channnel
    Then I should be on the utility checkout screen
    When I select add new account
    And I select "Water"
    Then I verify the form details for "Water"
    And I enter the details for the "Water" bill
    And I select check the bill "Water"
    Then I verify the data of the bill for "Water" bill
    And I navigate back to add new account
    When I select add new account
    And I select "Electricity"
    Then I verify the form details for "Electricity"
    And I enter the details for the "Electricity" bill
    And I select check the bill "Electricity"
    Then I verify the data of the bill for "Electricity" bill
    And I navigate back to add new account
    When I select add new account
    And I select "Gas"
    Then I verify the form details for "Gas"
    And I enter the details for the "Gas" bill
    And I select check the bill "Gas"
    Then I verify the data of the bill for "Gas" bill
    And I navigate back to add new account
    When I select add new account
    And I select "Telephone & Internet"
    Then I verify the form details for "Telephone & Internet"
    And I enter the details for the "Telephone & Internet" bill
    And I select check the bill "Telephone & Internet"
    Then I verify the data of the bill for "Telephone & Internet" bill

#  @32135879 @verify_the_components_of_dbills_lk
#  Scenario: verify The components of dbills lk
#    Given I select the venture
#    And I close the first order voucher popup
#    And I navigate to the signin screen
#    And I login with old buyer account
#    And I navigate back to the main screen
#    And I goto dbills from Homepage
#    And I select CEB
#    And I enter the bill details for "CEB"
#    And I select checkout on dbill
#    Then I should be on the select payment screen
