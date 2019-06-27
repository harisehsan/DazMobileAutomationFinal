package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.CheckOut;
import global.Drivers;
import org.testng.Assert;

public class CheckOutSteps {
    Drivers driver = new Drivers();
    CheckOut checkout = new CheckOut(driver.getDriver());

    String PRODUCT_NAME;
    int INDEX;
    int QUANTITY;

    @And("I select the product for checkout")
    public void iSelectTheProductForCheckout() {
       PRODUCT_NAME =  checkout.selectProductForCheckout();
    }

    @And("I select Buy Now")
    public void iSelectBuyNow() {
        checkout.selectbuyNow();
    }

    @And("I proceed to pay")
    public void iProceedToPay() {
        checkout.proceedToPay();
    }

    @And("I proceed to checkout using Cash on Delivery payment method")
    public void iSelectCashOnDeliveryPaymentMethod() {
      checkout.checkoutUsingCODPaymentMethod();
    }

    @Then("I verify that order has been placed")
    public void iVerifyThatOrderHasBeenPlaced() {
        Assert.assertTrue(checkout.verifyCheckOutItem(PRODUCT_NAME),"Checkout is not successful!");
    }

    @And("I select that product from cart for checkout")
    public void iSelectThatProductFromCartForCheckout() {
     INDEX =  checkout.selectProductFromCart(PRODUCT_NAME);
    }

    @And("I change the quantity to {int}")
    public void iSelectThatProductFromCartAndChangeTheQuantityTo(int quantity) {
        QUANTITY = checkout.changeProductQuantity(quantity,INDEX);
    }

    @And("I select checkout in cart menu")
    public void iSelectCheckoutInCartMenu() {
        checkout.selectCheckoutFromCart();
    }

    @Then("I verify that order has been placed with that quantity")
    public void iVerifyThatOrderHasBeenPlacedWithThatQuantity() {
        Assert.assertTrue(checkout.verifyCheckOutItem(PRODUCT_NAME),"Checkout is not successful!");
        Assert.assertEquals(checkout.verifyTheQuantity(QUANTITY),Integer.toString(QUANTITY),"Specified Quantity is not matched!");

    }
}