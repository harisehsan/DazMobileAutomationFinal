@smoke @bannerandchannel
Feature: Daraz Banner Slider and Channel Management for Homepage

  @22791240 @check_the_existence_and_total_number_of_banner
  Scenario: Check the existence of banner and display the total number of banners
    Given I select the venture
    And I skip the shake shake popup
    Then I check the existence of banner on homepage

  @22791240 @check_the_existence_of_channel_on_homepage
  Scenario: Check the existence of channel on Homepage
    Given I select the venture
    And I skip the shake shake popup
    Then I check the existence of channel on homepage

  @22791240 @navigate_to_channel_and_return
  Scenario: Navigate to channel and return back
    Given I select the venture
    And I skip the shake shake popup
    And I navigate to channel and I check for the title of channel
