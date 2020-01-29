package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Cart;
import global.Drivers;
import member.APP.pages.Wishlist;
import org.testng.Assert;

public class CartSteps {
    Drivers driver = new Drivers();
    Cart cart = new Cart(driver.getDriver());
    Wishlist wishlist = new Wishlist(driver.getDriver());

    String productName;
    String productTitle;

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

    @Then("I check for Current Price and Original Price")
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
}