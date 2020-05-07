package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.getProperty.OrderSetProperty;
import global.APP.pages.Cart;
import global.APP.pages.CheckOut;
import global.Drivers;
import org.testng.Assert;

import java.io.IOException;

public class CheckOutSteps {
    Drivers driver = new Drivers();
    CheckOut checkout = new CheckOut(driver.getDriver());
    Cart cart = new Cart(driver.getDriver());
    OrderSetProperty orderSetProperty = new OrderSetProperty();

    String productName;
    int index;
   public int quantity;

    @And("I select the product for checkout")
    public void iSelectTheProductForCheckout() throws IOException {
       productName =  checkout.selectProductForCheckout();
       orderSetProperty.productName(productName);
    }

    @And("I select Buy Now button")
    public void iSelectBuyNow() {
        checkout.selectBuyNow();
    }

    @And("I click on proceed to pay button")
    public void iProceedToPay() {
        checkout.proceedToPay();
    }

    @Then("I verify that order has been placed")
    public void iVerifyThatOrderHasBeenPlaced() {
        Assert.assertTrue(checkout.verifyCheckOutItem(productName),"Checkout is not successful!");
    }

    @And("I select that product from cart for checkout")
    public void iSelectThatProductFromCartForCheckout() {
     index =  checkout.selectProductFromCart(productName);
    }

    @And("I change the quantity to {int}")
    public void iSelectThatProductFromCartAndChangeTheQuantityTo(int quantity) throws IOException {
        this.quantity = checkout.changeProductQuantity(quantity, index);
        orderSetProperty.orderAmount(Integer.toString(this.quantity));
    }

    @And("I click on checkout button in cart menu")
    public void iSelectCheckoutInCartMenu() {
        checkout.selectCheckoutFromCart();
    }

    @Then("I verify that order has been placed with that quantity")
    public void iVerifyThatOrderHasBeenPlacedWithThatQuantity() {
        Assert.assertTrue(checkout.verifyCheckOutItem(productName),"Checkout is not successful!");
        Assert.assertEquals(checkout.verifyTheQuantity(quantity),Integer.toString(quantity),"Specified Quantity is not matched!");
    }

    @And("I select Cash on Delivery payment method")
    public void iSelectCashOnDeliveryPaymentMethod() {
        checkout.checkoutUsingCODPaymentMethod();
    }

    @And("I should reach to order successful page")
    public void iShouldReachToOrderSuccessfulPage() {
        checkout.reachToOrderSuccessPage();
    }

    @And("I click on Track Order button")
    public void iClickOnTrackOrder() {
        checkout.clickTrackOrder();
    }

    @And("I swipe the main {string} product on checkout screen to view delete button")
    public void iSwipeTheMainProductOnCheckoutScreenToViewDeleteButton(String promotionName) {
        checkout.slideToViewDeleteButtonForPromotionProducts(productName,promotionName);
    }

    @And("I click on delete button checkout")
    public void iClickOnDeleteButtonCheckout() {
        checkout.clickOnDeleteButton();
    }

    @Then("I verify that entire {string} promotion should be deleted on checkout screen")
    public void iVerifyThatEntireShouldBeDeletedOn(String promotionType) {
        Assert.assertTrue(checkout.checkForDeletedProduct(promotionType),"There is product on checkout is not deleted successfully!");
    }

    @And("I get the product Name for checkout")
    public void iGetTheProductNameForCheckout() {
        productName = cart.getProductName();
    }

    @Then("I verify the existence of {string} promotion on checkout")
    public void iVerifyTheExistenceOfPromotionOnCheckout(String promotionType) {
        Assert.assertTrue(checkout.checkForPromotionOnCheckout(promotionType),"The required promotion is not displayed on checkout");
    }

    @Then("I verify {string} is not displayed on checkout")
    public void iVerifyOnCheckout(String numberOfItems) {
      Assert.assertTrue(checkout.verifyTheNumberOfItems(numberOfItems),"The promotion item is not contain proper number of item(s)");
    }

    @And("I click on edit address button on checkout")
    public void iClickOnEditAddressButtonOnCheckout() {
        checkout.clickOnEditAddressButton();
    }

    @Then("I verify the {string} shipping and billing addresses")
    public void iVerifyTheDifferentShippingAndBillingAddresses(String addressType) {
     Assert.assertTrue(checkout.verifyTheDifferentBillingAndShippingAddress(addressType),"The billing and shipping address are not shown as it should!");
    }

    @Then("I verify the bottom line divider on checkout page")
    public void iVerifyTheBottomLineDividerOnCheckoutPage() {
        Assert.assertTrue(checkout.verifyTheBottomLineDivider(),"Bottom Line divider is not existed on checkout page!");
    }

    @And("I slide the product to view the delete button")
    public void iSlideTheProductToViewTheDeleteButton() {
        checkout.slideToViewDeleteButton(productName);
    }

    @Then("I should see the snackbar error message")
    public void iShouldSeeTheSnackbarErrorMessage() {
     Assert.assertTrue(checkout.verifyTheSnackbarErrorMessage(),"Snack bar message is not displayed!");
    }

    @Then("I verify the existence of delivery time and email address on checkout")
    public void iVerifyTheExistenceOfDeliveryTimeAndEmailAddressOnCheckout() {
        Assert.assertTrue(checkout.verifyTheEmailAndDeliveryTimeForDigitalGoods(),"The Email address and/or delivery time for digial item is not properly displayed!");
    }

    @Then("I verify the main product map, product title, product attributes, product price, line price, quantity of goods")
    public void iVerifyTheMainProductMapProductTitleProductAttributesProductPriceLinePriceQuantityOfGoods() {
        Assert.assertTrue(checkout.verifyTheAttributesOfItem(),"The attributes of items are not displayed!");
    }

    @And("I check for the total price on checkout screen")
    public void iCheckForTheTotalPriceOnCheckoutScreen() {
      Assert.assertTrue(checkout.verifyTheExistenceOfTotalPriceOnCheckout(),"The total price is not displayed on checkout screen");
    }

    @Then("I verify the logistics type, estimated delivery date, postage on Order details page")
    public void iVerifyTheLogisticsTypeEstimatedDeliveryDatePostageOnOrderDetailsPage() {
      Assert.assertTrue(checkout.verifyTheLogisticsTypeAndDeliveryDateAndPostage(),"The Logistics information are not properly displayed on Order Details Page!");
    }
}