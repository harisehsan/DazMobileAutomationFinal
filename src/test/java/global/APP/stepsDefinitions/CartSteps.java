package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.APP.getProperty.VoucherGetProperty;
import global.APP.pages.Cart;
import global.Drivers;
import member.APP.pages.Wishlist;
import org.testng.Assert;

import java.io.IOException;

public class CartSteps {
    Drivers driver = new Drivers();
    Cart cart = new Cart(driver.getDriver());
    Wishlist wishlist = new Wishlist(driver.getDriver());
    VoucherGetProperty voucherGetProperty = new VoucherGetProperty();

    String productName = "";
    String productTitle = "";

    @And("I add a product to cart")
    public void iAddAProductToCart() {
        cart.addToCart();
    }

    @Then("I verify item has been added to cart by success message")
    public void iVerifyItemHasBeenAddedToCartBySuccessMessage() {
      Assert.assertEquals(cart.verifyTheAddedProductBySuccessMessage(),"Added to cart successfully!","Item is not successfully added to cart!");
    }

    @And("I select the product for cart")
    public void iSelectTheTestProductForCart() {
      productName =  cart.selectProductForCart();
    }

    @And("I goto cart menu from PDP screen")
    public void iGotoCartMenuFromPDPScreen() {
     cart.goToCartFromPDP();
    }

    @Then("I verify item has been added item in cart")
    public void iVerifyItemHasBeenAddedItemInCart() {
     Assert.assertTrue(cart.verifyAddedProductInCart(productName),"Required item is not added to cart!");
    }

    @And("I select cart")
    public void iSelectCart() {
        cart.selectCart();
    }

    @And("I remove a single item from cart")
    public void iRemoveASingleItemFromCart() {
    productName = cart.removeSingleItemFromCart();
    }

    @Then("I verify that removed item should not present in cart")
    public void iVerifyThatRemovedItemShouldNotPresentInCart() {
        Assert.assertNotEquals(productName,cart.verifyForRemovedItemInCart(),"Item Deletion is unsuccessful");
    }

    @And("I remove all items from cart")
    public void iRemoveAllItemsFromCart() {
      cart.removeAllItemsFromCart();
    }

    @Then("I verify that all items in cart are successfully removed")
    public void iVerifyThatAllItemsInCartAreSuccessfullyRemoved() {
      Assert.assertTrue(cart.verifyEmptyCart(),"All items in cart are not removed!");
    }

    @And("I add a product from cart to wishlist")
    public void iAddAProductFromCartToWishlist() {
      cart.addProductFromCartToWishlist();
    }

    @Then("I verify for added item in wishlist")
    public void iVerifyForAddedItemInWishlist() {
        Assert.assertTrue(cart.verifyaddedItemInWishList(),"Item is not successfully added from cart to wishlist!");
    }

    @And("I goto the wishlist to select the added product")
    public void iGotoTheWishlistToSelectTheAddedProduct() throws InterruptedException {
        productTitle = wishlist.verifyAddedItemInWishlist(productName);
    }

    @And("I check for the count in header and in tooltip")
    public void iCheckForTheCountInHeaderAndInTooltip() {
       Assert.assertFalse(cart.verifyTheToolTipAndCountBar(),"Count Bar is not properly shown for the empty cart");
    }

    @Then("I should remain on the cart screen")
    public void iShouldRemainOnTheCartScreen() {
        Assert.assertTrue(cart.checkforTheCartPage(),"Navigation is made from cart to checkout without product select!");
    }

    @Then("I check shop checkbox for product")
    public void iCheckShopCheckboxForProduct() {
      Assert.assertTrue(cart.checkTheShopBox(),"Shop checkbox is not same as the product checkbox!");
    }

    @Then("I check for shop name for product")
    public void iCheckForShopNameForProduct() {
      Assert.assertTrue(cart.checkForTheShopName(),"Shop Name is not properly displayed on the cart screen!");
    }

    @Then("I check for Current Price and Original Price and promotion ratio")
    public void iCheckForCurrentPriceAndOriginalPrice() {
        Assert.assertTrue(cart.checkForCurrentPriceAndOriginalPrice(),"Current price and original price are not correctly displayed!");
    }

    @Then("I check for the product title")
    public void iCheckForTheProductTitle() {
        cart.selectProductForCart();
    }

    @Then("I check for delivery Information")
    public void iCheckForDeliveryInformation() {
        cart.cartDeliveryInfoCheck();
    }

    @And("I skip the cart popup")
    public void iSkipTheCartPopup() {
        cart.skipTheCartPopup();
    }

    @And("I get the product Name")
    public void iGetTheProductName() {
     productName = cart.getProductName();
    }

    @And("I slide the item in the cart to view the delete button and delete the item")
    public void iSlideTheItemInTheCartToViewTheDeleteButton() {
      cart.slideTheItemInCartToViewOptions(productName);
    }

    @And("I scroll down to view product in cart")
    public void iScrollDownToViewProductTheProductInCart() {
        cart.scrollToProduct(productName);
    }

    @And("I add a combo product to cart")
    public void iAddAComboProductToCart() {
       cart.addToCartforCombo();
    }

    @And("I select the added product in cart")
    public void iSelectTheAddedProductInCart() {
    cart.selectTheAddedProduct(productName);
    }

    @And("I select all items in cart")
    public void iSelectAllItemsInCart() {
        cart.selectAllItemsInCart();
    }

    @When("I click on product in cart")
    public void iClickOnProduct() {
        cart.clickOnProduct(productName);
    }

    @Then("I should be on its PDP page")
    public void iShouldBeOnItsPDPPage() {
       Assert.assertTrue(cart.verifyTheProductNameOnPDP(productName),"Not successfully navigated from cart to PDP!");
    }


    @Then("I verify item has been added item in cart with promotion")
    public void iVerifyItemHasBeenAddedItemInCartWithPromotion() {
    }

    @And("I scroll down to view product name and promotion {string} in cart")
    public void iScrollDownToViewProductNameAndPromotionInCart(String promotionName) {
        cart.scrollToProductAndPromotion(productName,promotionName);
    }

    @Then("I verify item has been added item in cart with promotion {string}")
    public void iVerifyItemHasBeenAddedItemInCartWithPromotion(String promotionName) {
        Assert.assertTrue(cart.verifyAddedProductInCartWithPromotion(productName,promotionName),"Product with promotion is not found in cart!");
    }

    @Then("I should see the empty cart")
    public void iShouldSeeTheEmptyCart() {
      Assert.assertTrue(cart.verifyEmptyCart(),"The Empty cart message is not properly displayed!");
    }

    @When("I select continue shopping")
    public void iSelectContinueShopping() {
        cart.selectContinueShopping();
    }

    @Then("I verify for non-empty cart")
    public void iVerifyForNonEmptyCart() {
        Assert.assertFalse(cart.verifyEmptyCart(),"The cart is still empty!");
    }

    @Then("I verify that delete button is hidden by default")
    public void iVerifyThatDeleteButtonIsHiddenByDefault() {
       Assert.assertFalse(cart.verifyTheHiddenDeleteButton(),"The delete button is not hidden properly!");
    }

    @Then("I check the existence of quantity")
    public void iCheckTheExistenceOfQuantity() {
      Assert.assertTrue(cart.verifyTheQuantityOfItem(),"Quantity of item is not properly displayed!");
    }

    @Then("I check for the shipping fee and grand total price")
    public void iCheckForTheShippingFeeAndGrandTotalPrice() {
      Assert.assertTrue(cart.iCheckForShippingFeeAndTotalPrice(),"The Shipping fee or total price are not properly displayed!");
    }

    @And("I select get voucher in cart")
    public void iSelectGetVoucherInCart() {
       cart.selectGetVoucher();

    }

    @Then("I verify the components of get voucher popup in cart")
    public void iVerifyTheComponentsOfGetVoucherPopupInCart() {
    Assert.assertTrue(cart.verifyTheGetVocuherPopupComponents(),"One or More component of get voucher is/are not displayed properly!");
    }

    @Then("I verify the voucher collection for the {string} time")
    public void iVerifyTheVoucherCollectionForTheTime(String occurrance) {
        Assert.assertTrue(cart.verifyTheVoucherCollection(occurrance),"Either a voucher is not collectable for the first time or it is collectable for second time!");
    }

    @And("I close the get voucher popup")
    public void iCloseTheGetVoucherPopup() {
        cart.clickOnCloseButton();
    }

    @And("I close the get voucher popup on PDP")
    public void iCloseTheGetVoucherPopupOnPDP() {
      cart.clickOnPopupCloseButton();
    }

    @When("I scroll down to the voucher code section")
    public void iScrollDownToTheVoucherCodeSection() {
       cart.iScrollDownToTheVocuherCodeSection();
    }

    @Then("I verify the components of voucher code section")
    public void iVerifyTheComponentsOfVoucherCodeSection() {
        Assert.assertTrue(cart.verifyTheComponentsOfVoucherCodeSection(),"One or more components of voucher code section is/are not displayed properly");
    }

    @Then("I verify the apply button is not clickable if the voucher text box is empty")
    public void iVerifyTheApplyButtonIsNotClickableIfTheVoucherTextBoxIsEmpty() {
       Assert.assertTrue(cart.verifyTheApplyButton(),"The apply button of voucher code is still clickable even the text field is empty");
    }

    @And("I click on apply button")
    public void iClickOnApplyButton() {
      cart.clickOnApplyButton();
    }

    @When("I enter the {string} voucher code")
    public void iEnterTheVoucherCode(String voucherCodeCondition) throws IOException {
      cart.enterVoucherCode(voucherCodeCondition,voucherGetProperty.getWrongVoucherCode(),voucherGetProperty.getCorrectVoucherCode());
    }

    @Then("I should see the validation error")
    public void iShouldSeeTheValidationError() {
        Assert.assertTrue(cart.verifyTheValidationError(),"Validation Error message for voucher code is not displayed!");
    }

    @And("I select voucher code clear button")
    public void iSelectVoucherCodeClearButton() throws IOException {
     cart.selectVoucherClearButton();
    }

    @Then("voucher code should be removed from the text field")
    public void voucherCodeShouldBeRemovedFromTheTextField() {
        Assert.assertTrue(cart.verifyTheEmptyVoucherTextfield(),"Voucher text field is not cleared successfully!");
    }

    @Then("I should see the impact of voucher code on total price")
    public void iShouldSeeTheImpactOfVoucherCodeOnTotalPrice() throws IOException {
      Assert.assertTrue(cart.verifyTheImapctOfCorrectVoucherCode(),"Correct Voucher code is not applied successfully or voucher discount is not impacted!");
    }

    @And("I select checkbox for that product")
    public void iSelectCheckboxForThatProduct() {
      cart.selectTheCheckBoxForProduct(productName);
    }
}