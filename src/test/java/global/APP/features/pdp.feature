@smoke @pdp @22702821
Feature: PDP page Management

  @22702821 @verify_pdp_gallery @30180363 @28809899 @28811301 @28809900 @28811302 @28811368
  Scenario: Verify the PDP gallery
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on the video play button and close the video
    And I swipe to view all the product images on PDP page
    And I click on the product image to enter big picture mode
    And I check for all available images
    Then I return back to PDP page

  @22702821 @verify_basic_information @28811313 @28811312 @28811368
  Scenario: Verify basic information on PDP page
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I check for product title, displayed price, original price and discount rate
    And I check for rating, wishlist and share icon
    Then I click on share icon to view its details

  @22702821 @verify_product_specifications @28811345
  Scenario: Verify the product specifications content
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I verify the existence of specification
    And I verify the contents of specifications on PDP
    And I click on specifications to open its poppage
    Then I verify the contents of specifications on Poppage

  @22702821 @verify_product_delivery_options @28811348 @28811350
  Scenario: Verify the product delivery option content
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I verify the existence of delivery options
    And I verify the contents of delivery options on PDP
    And I click on delivery options to open its poppage
    Then I verify the delivery options content on poppage

  @22702821 @verify_product_services @28811351
  Scenario: Verify the product services content
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I verify the existence of services
    And I click on services to open its poppage
    Then I verify the services content on poppage

  @22702821 @verify_product_rating_and_review @28811357
  Scenario: Verify the product rating and review
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I check the existence Rating & Review section
    And I check the existence of view all button and click on it

  @22702821 @verify_product_qa  @28811361 @28811358
  Scenario: Verify the product Question and Answer
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I check the existence Question & Answer section
    And I click on view all button for Q&A
    And I look for the Ask Question button and click on it
    Then I should be on the ask question page

  @22702821 @visit_store @28811363 @28811365 @28811366 @28811426
  Scenario: Visit the seller store
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on store button
    And I click on Follow button
    And I signin with google account
    Then I should be followed that store

  @22702821 @verify_recommended_by_seller @28811373
  Scenario: Verify recommended by seller section
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I check the existence of Recommended by seller section
    And I select the product in the recommended list
    Then I should be on the PDP page

  @22702821 @pdp_page_navigation @28811376 @28811377 @28811380 @28811380 @28811383 @28811381 @28811387 @28811387 @28811384 @28811388 @28811384
  Scenario: Navigation from PDP page
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I navigate to login page from PDP
    And I navigate back to pdp page
    And I navigate to the Home page from PDP
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I navigate to the search from PDP
    And I search the available product
    And I goto the PDP page
    And I navigate to messages from PDP
    And I navigate back to pdp page
    And I navigate to Need Help from PDP
    And I navigate back to pdp page
    And I check for the elevator menu
    Then I navigate to corresponding elevator menu item

  @28811393 @verify_daraz_mall_pdp @28811393
  Scenario: Verify daraz mall product PDP
    Given I select the venture
    And I search for "water"
    And I goto the Daraz Mall
    And I goto the PDP page
#    And I check existence of daraz mall in the product title
    And I verify the existence of services
    And I click on services to open its poppage
    Then I should see the services of daraz mall on poppage

  @28811393 @verify_sku_panel_variations @28811409 @28811407 @28811408 @28811343
  Scenario: Verify SKU Panel & variations for PDP
    Given I select the venture
    And I search product using sku for "SKU Panel"
    And I goto the PDP page
    And I click on variation to display its SKU panel
    And I perform switching between different SKUs
    Then I change the product quantity

  @28811393 @verify_pdp_chat @28811427
  Scenario: Verify PDP chat feature
    Given I select the venture
    And I search product using sku for "PDP"
    And I goto the PDP page
    And I click on chat icon
    And I signin with google account
    Then I should be on the chat page

  @28811393 @verify_pdp_voucher_collect @28811315 @28811317
  Scenario: Verify PDP voucher collect feature
    Given I select the venture
    And I search product using sku for "Voucher Collect"
    And I goto the PDP page
    And I check the existence of Voucher on PDP
    And I open voucher section
    And I click on collect button
    And I signin with google account
    Then The voucher should be collected

  @28811393 @verify_pdp_voucher_copy @28811316
  Scenario: Verify PDP voucher copy feature
    Given I select the venture
    And I search product using sku for "Voucher Code"
    And I goto the PDP page
    And I check the existence of Voucher on PDP
    And I open voucher section
    And I click on copy button
    Then The voucher code should be copied

  @28811393 @verify_free_gift_promotion @28811327 @28811333
  Scenario: Verify free gift promotion on PDP
    Given I select the venture
    And I search product using sku for "Free Gift"
    And I goto the PDP page
    And I check the existence of "Free Gift" promotion
    Then I open the "Free Gift" promotion popup and verify it

  @28811393 @verify_combo_promotion @28811335 @28811340
  Scenario: Verify combo promotion on PDP
    Given I select the venture
    And I search product using sku for "Combo"
    And I goto the PDP page
    And I check the existence of "Frequently Bought Together" promotion
    Then I open the "Frequently Bought Together" promotion popup and verify it

  @28811393 @verify_buy_more_save_promotion @28811330 @28811331 @28811321 @28810210
  Scenario: Verify buy more save promotion on PDP and cart
    Given I select the venture
    And I search product using sku for "Save more"
    And I goto the PDP page
    And I check the existence of "Buy More & Save More" promotion on Popup
    And I navigate back to pdp page
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I select that product in cart
    Then I should see the promo saved price

  @28811393 @verify_buy_one_get_one_promotion @28811330 @28811331 @28811321 @28810195 @28810268
  Scenario: Verify buy one get one promotion on PDP, cart and checkout
    Given I select the venture
    And I search product using sku for "B1G1"
    And I goto the PDP page
    And I check the existence of "Buy One Get One Free" promotion on Popup
    And I navigate back to pdp page
    And I add a product to cart
    And I signin with google account
    And I goto cart menu from PDP screen
    And I select that product in cart
    Then I should see its quantity "2" in cart
    And I navigate back to pdp page
    And I select Buy Now button
    Then I should see the B1G1 quantity on checkout page