package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Pdp;
import global.Drivers;
import org.testng.Assert;

import java.io.IOException;

public class PdpSteps {

    Drivers drivers = new Drivers();
    Pdp pdp = new Pdp(drivers.getDriver());
    int cartIndex;

    @And("I search product using sku for {string}")
    public void iSearchUsingSkuForPdp(String searchType) throws IOException {
        pdp.serchProductForPDP(searchType);
    }

    @And("I goto the PDP page")
    public void  iGotoThePDPPage() {
        pdp.gotoPdpPage();
    }

    @And("I click on the video play button and close the video")
    public void iClickOnTheVideoPlayButtonAndCloseTheVideo() {
         pdp.pdpVideo();
    }

    @And("I swipe to view all the product images on PDP page")
    public void iSwipeToViewAllTheProductImages() {
        Assert.assertTrue(pdp.viewImagesOnPDP(),"Picture count is not available yet!");
    }

    @And("I click on the product image to enter big picture mode")
    public void iClickOnTheProductImageToOpenItsImage() {
      pdp.bigPictureMode();
    }

    @And("I check for all available images")
    public void iCheckAllAvailableImages() {
    Assert.assertTrue(pdp.checkforAllImages(),"Big picture mode is not working fine!");
    }

    @Then("I return back to PDP page")
    public void iReturnBackToPDPPage() {
        Assert.assertTrue(pdp.backToPDPFromBigPicture(),"PDP page is not displaying properly!");
    }

    @And("I check for product title, displayed price, original price and discount rate")
    public void iCheckForProductTitleDisplayedPriceOriginalPrice() {
      Assert.assertTrue(pdp.verifyTitleAndPrice(), "Product Title, price or discount rate is not displayed properly!");
    }

    @And("I check for rating, wishlist and share icon")
    public void iCheckForRatingWishlistAndShareIcon() {
        Assert.assertTrue(pdp.verifyRatingWishlistAndShareIcon(),"Product rating, wishlist or share icon is not existed on PDP!");

    }

    @Then("I click on share icon to view its details")
    public void iClickOnShareIconToViewItsDetails() {
        Assert.assertTrue(pdp.verifyTheShareDetails(),"Share details are not displayed!");
    }

    @And("I verify the existence of specification")
    public void iVerifyTheExistenceOfSpecification() {
        Assert.assertTrue(pdp.verifyTheExistenceOfSpecification(),"Specification of this product are not existed!");
    }

    @Then("I verify the contents of specifications on Poppage")
    public void iVerifyTheContentsOfSpecifications() {
        Assert.assertTrue(pdp.verifyTheContentsOfSpecifications(), "The contents of specifications are displayed correctly on poppage!");
    }

    @And("I verify the existence of delivery options")
    public void iVerifyTheExistenceOfDelivery() {
    Assert.assertTrue(pdp.verifyTheExistenceOfDeliveryOptions(), "Delivery Options is not existed on PDP!");
    }

    @And("I verify the contents of specifications on PDP")
    public void iVerifyTheContentsOfSpecificationsOnPDP() {
      Assert.assertTrue(pdp.verifyTheSpecificationInformationOnPDP(),"The Specification content is not properly displayed on PDP!");
    }

    @And("I click on specifications to open its poppage")
    public void iClickOnSpecificationsToOpenItsOptions() {
      pdp.clickToEnterSpecificationPopPage();
    }

    @And("I verify the contents of delivery options on PDP")
    public void iVerifyTheContentsOfDeliveryOnPDP() {
       Assert.assertTrue(pdp.verifyTheExistenceOfDeliveryOptionsContentOnPdp(), "Delivery Option Content is not properly displayed on PDP!");
    }

    @And("I click on delivery options to open its poppage")
    public void iClickOnDeliveryToOpenItsPoppage() {
       pdp.clickOnDeliveryOptionToOpenPopPage();
    }

    @Then("I verify the delivery options content on poppage")
    public void iVerifyTheDeliveryContentOnPoppage() {
      Assert.assertTrue(pdp.verifyTheContentOfDeliverOptionsOnPopPage(),"Delivery option information on Pop page is not properly displayed!");
    }

    @And("I verify the existence of services")
    public void iVerifyTheExistenceOfServices() {
        Assert.assertTrue(pdp.verifyTheExistenceOfServices(), "Services is not properly displayed on PDP!");
    }

    @And("I click on services to open its poppage")
    public void iClickOnServicesToOpenItsPoppage() {
        pdp.clickOnServices();
    }

    @Then("I verify the services content on poppage")
    public void iVerifyTheServicesContentOnPoppage() {
        Assert.assertTrue(pdp.verifyTheContentOfDeliverOptionsOnPopPage(),"Services information on Pop page is not properly displayed!");
    }

    @And("I check the existence Rating & Review section")
    public void iCheckTheExistenceRatingReviewSection() {
       Assert.assertTrue(pdp.verifyTheExistenceOfRatingAndReview(),"Rating and review is not existed for this product!");
    }

    @And("I check the existence of view all button and click on it")
    public void iCheckTheExistenceOfViewAllButtonAndClickOnIt() {
       Assert.assertTrue(pdp.verifyTheExistenceAndClickOnViewAll(),"View all button for rating and review is not existed!");
    }

    @And("I check the existence Question & Answer section")
    public void iCheckTheExistenceQuestionAnswerSection() {
     Assert.assertTrue(pdp.checkTheExistenceofQaSection(),"Question & Answer section is not existed on PDP!");

    }

    @And("I click on view all button for Q&A")
    public void iClickOnViewAllButtonForQA() {
        pdp.clickOnViewAllButton();
    }

    @And("I look for the Ask Question button and click on it")
    public void iLookForTheAskQuestionButtonAndClickOnIt() {
        Assert.assertTrue(pdp.verifyTheExistenceAndClickOnAskQuestion(), "Ask Question button is not displayed on PDP!");
    }

    @Then("I should be on the ask question page")
    public void iShouldBeOnTheAskQuestionPage() {
       Assert.assertTrue(pdp.iShouldBeOnAskQuestionPage(),"Question & Answer page is not properly displayed!");
    }

    @And("I click on store button")
    public void iClickOnStoreButton() {
        pdp.iclickOnStore();
    }


    @And("I click on Follow button")
    public void iClickOnFollowButton() {
        pdp.clickOnFollowStoreButton();
    }

    @Then("I should be followed that store")
    public void iShouldFollowThatStore() {
        Assert.assertTrue(pdp.iShouldFollowedThatStore(),"Store is not successfully followed!");
    }

    @And("I check the existence of Recommended by seller section")
    public void iCheckTheExistenceOfRecommendedBySellerSection() {
      Assert.assertTrue(pdp.verifyTheExistenceOfRecommendedBySellerSection(),"Recommended by Seller section is not available ");
    }

    @And("I select the product in the recommended list")
    public void iSelectTheProductInTheRecommendedList() {
      Assert.assertTrue(pdp.iClickOnTheRecommendedProduct(),"Seller recommended products are not available on the provided PDP!");
    }

    @Then("I should be on the PDP page")
    public void iShouldBeOnThePDPPage() {
        Assert.assertTrue(pdp.iShouldBeOnThePDPPage(),"PDP page is not displaying properly!");
    }

    @And("I navigate to login page from PDP")
    public void iNavigateToLoginPageFromPDP() {
        Assert.assertTrue(pdp.navigateToLoginFromPDP(),"Navigation to Login from PDP is not successful!");
    }

    @And("I navigate back to pdp page")
    public void iNavigateBackToPdpPage() {
        pdp.navigateBackToPDP();
    }

    @And("I navigate to the Home page from PDP")
    public void iNavigateToTheHomePageFromPDP() {
        Assert.assertTrue(pdp.navigateToHomePageFromPDP(),"Navigation to homepage from PDP is not successful!");
    }

    @And("I navigate to the search from PDP")
    public void iNavigateToTheSearchFromPDP() {
        Assert.assertTrue(pdp.navigateToSearchFromPDP(),"Navigation to search from PDP is not successful!");
    }

    @And("I search the available product")
    public void iSearchTheAvailableProduct() {
      pdp.searchTheAvailableProduct();
    }

    @And("I navigate to messages from PDP")
    public void iNavigateToMessagesFromPDP() {
        Assert.assertTrue(pdp.navigateToMessagesFromPDP(),"Navigation to messages from PDP is not successful!");
    }

    @And("I navigate to Need Help from PDP")
    public void iNavigateToNeedHelpFromPDP() {
      Assert.assertTrue(pdp.navigateToNeedHelpFromPDP(),"Navigation to need help from PDP is not successful!");
    }

    @And("I check for the elevator menu")
    public void iCheckForTheElevatorMenu() {
        Assert.assertTrue(pdp.scrollToElevatorMenu(),"Elevator menu is not existed on PDP!");
    }

    @Then("I navigate to corresponding elevator menu item")
    public void iNavigateToCorrespondingElevatorMenuItem() {
         pdp.navigateToEachElevatorMenu();
    }

    @And("I check existence of daraz mall in the product title")
    public void iCheckExistenceOfDarazMallInTheProductTitle() {
        Assert.assertTrue(pdp.verifyTheExistenceOfDarazMall(), "This product is not belongs to Daraz Mall/Official Store!");
    }

    @Then("I should see the services of daraz mall on poppage")
    public void iShouldSeeTheServicesOfDarazMallOnPDPPage() {
        Assert.assertTrue(pdp.verifyTheDarazMallServices(),"Services for Daraz Mall/Official Store product is not displayed");
    }

    @And("I click on variation to display its SKU panel")
    public void iClickOnVariationToDisplayItsSKUPanel() {
      Assert.assertTrue(pdp.verifyTheExistenceOfVariationAndClickOnIt(),"SKU variation is not existed for this PDP!");
    }

    @And("I perform switching between different SKUs")
    public void iPerformSwitchingBetweenDifferentSKUs() {
        pdp.switchBetweenDifferentSKUs();
    }

    @Then("I change the product quantity")
    public void iChangeTheProductQuantity() {
       Assert.assertTrue(pdp.changeQuantity(),"Quantity is not successfully changed!");
    }

    @Then("I should be on the chat page")
    public void iShouldBeOnTheChatPage() {
        Assert.assertTrue(pdp.verifyTheChatPage(),"Chat page is not displayed properly!");
    }

    @And("I click on chat icon")
    public void iClickOnChatIcon() {
     Assert.assertTrue(pdp.clickOnChat(),"Chat option is not available on the provided PDP!");
    }

    @And("I check the existence of Voucher on PDP")
    public void iCheckTheExistenceOfVoucherOnPDP() {
         Assert.assertTrue(pdp.verifyTheExistenceOfVoucher(),"Seller voucher is not existed for this product!");
    }

    @And("I open voucher section")
    public void iOpenVoucherSection() {
        pdp.clickOnVoucher();
    }

    @Then("The voucher should be collected")
    public void theVoucherShouldBeCollected() {
     Assert.assertTrue(pdp.checkForVoucherSuccessMessage(),"Voucher is not collected successfully!");
    }

    @And("I click on collect button")
    public void iClickOnCollectButton() {
     pdp.clickOnCollectButton();
    }

    @And("I check the existence of {string} promotion")
    public void iCheckTheExistenceOfPromotion(String productType) {
      Assert.assertTrue(pdp.verifyTheExistenceOFPromotion(productType),"The "+productType+" promotion is not available on the provided PDP!");

    }

    @Then("I open the {string} promotion popup and verify it")
    public void iOpenThePromotion(String productType) {
      Assert.assertTrue(pdp.OpenThePromotionPopupAndVerifyThePromotion(productType), "The "+productType+" promotion popup is not displayed correctly!");
    }

    @And("I click on copy button")
    public void iClickOnCopyButton() {
      pdp.clickOnVoucherCodeCopyButton();
    }

    @Then("The voucher code should be copied")
    public void theVoucherCodeShouldBeCopied() {
        Assert.assertTrue(pdp.checkForVoucherSuccessMessage(),"Voucher code is not successfully copied!");
    }

    @And("I check the existence of {string} promotion on Popup")
    public void iCheckTheExistenceOfPromotionOnPopup(String promotionType) {
       Assert.assertTrue(pdp.verifyTheExistenceOfBuyMoreSaveMoreOnPDP(promotionType),"Buy 1 Get 1 promotion is not Existed on PDP!");
    }

    @Then("I should see the promo saved price")
    public void iShouldSeeThePromoSavedPrice() {
     Assert.assertTrue(pdp.verifyThePromoSavedAmount(cartIndex),"The promo saved amount is not properly displayed in cart!");
    }

    @And("I select that product in cart")
    public void iSelectThatProductInCart() {
        cartIndex =  pdp.selectProductInCart();
    }

    @Then("I should see its quantity {string} in cart")
    public void iShouldSeeItsQuantityInCart(String quantity) {
        Assert.assertTrue(pdp.verifyB1G1QuantityInCart(quantity,cartIndex),"The product quantity is not correct for B1G1 in cart!");
    }

    @Then("I should see the B1G1 quantity on checkout page")
    public void iShouldSeeTheB1G1QuantityOnCheckoutPage() {
      Assert.assertTrue(pdp.verifyB1G1QuantityOnCheckOut(),"The product quantity is not displayed or not correct for B1G1 on checkout screen!");
    }
}
