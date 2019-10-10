package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import member.APP.pages.Wishlist;
import org.testng.Assert;

public class WishlistSteps {
    Drivers driver = new Drivers();
    Wishlist wishlist = new Wishlist(driver.getDriver());
    String productName;

    @And("I select the product")
    public void iSelectForTheTestProduct() {
      productName =  wishlist.selectProduct();
    }

    @And("I add a product to wishlist")
    public void iAddAProductToWishlist()  {
        wishlist.addToWishlist();
    }

    @And("I signin with google account")
    public void iShouldSigninIfRequire()  {
        wishlist.signin();
    }

    @Then("I verify item has been added to wishlist by success message")
    public void iVerifyItemHasBeenAddedToWishlistBySuccessMessage() {
        Assert.assertEquals(wishlist.wishlistAddSuccessMessage(),"Add item to wishlist Successfully!","Add item to wishlist is not Successful!");
    }

    @And("I remove the already added product from wishlist")
    public void iRemoveTheAlreadyAddedProductFromWishlist() {
        wishlist.addToWishlist();
    }

    @Then("I verify item has been removed to wishlist by success message")
    public void iVerifyItemHasBeenRemovedToWishlistBySuccessMessage() {
        Assert.assertEquals(wishlist.wishlistRemoveSuccessMessage(),"Deleted item from wishlist Successfully!","Remove item from wishlist is not Successful!");
    }

    @Then("I goto the wishlist to verify the added item")
    public void iGotoTheWishlistToVerifyTheAddedItem() throws InterruptedException {
       Assert.assertEquals(wishlist.verifyAddedItemInWishlist(productName), productName,"Add item to wishlist is not Successful!");
    }

    @And("I login using google account")
    public void iShouldLogin() {
       wishlist.navigate_To_Login_Screen();
       wishlist.signin();
    }

    @And("I open a wishlist")
    public void iOpenAWishlist() {
     wishlist.openWishlist();
    }

    @And("I delete a single item form wishlist")
    public void iDeleteASingleItemFormWishlist() {
    wishlist.deleteSingleItem();
    }


    @And("I delete all items form wishlist")
    public void iDeleteAllItemsFormWishlist() {
        wishlist.deleteAllItems();
    }

    @Then("I verify that no item left in the wishlist")
    public void iVerifyThatNoItemLeftInTheWishlist() {
        Assert.assertTrue(wishlist.verifyEmptyWishlist(),"Items are not successfully deleted!");
    }

    @And("I goto wishlist from PDP screen")
    public void iGotoWishlistFromPDPScreen() {
        wishlist.goToWishlistFromPDPScreen();
    }

    @Then("I verify that deleted item should not present in wishlist")
    public void iVerifyThatDeletedItemShouldNotPresentInWishlist() {
        Assert.assertFalse(wishlist.verifyThePresenceOfDeletedItem(productName),"Item is not deleted from wishlist!");
    }
}
