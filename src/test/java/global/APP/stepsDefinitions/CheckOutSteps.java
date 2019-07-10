package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.CheckOut;
import global.Drivers;
import org.testng.Assert;

import java.io.IOException;

public class CheckOutSteps {
    Drivers driver = new Drivers();
    CheckOut checkout = new CheckOut(driver.getDriver());


    String productName;
    int index;
   public int quantity;

    @And("I select the product for checkout")
    public void iSelectTheProductForCheckout() {
       productName =  checkout.selectProductForCheckout();
    }

    @And("I select Buy Now")
    public void iSelectBuyNow() {
        checkout.selectbuyNow();
    }

    @And("I click on proceed to pay")
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

    @And("I click on Track Order")
    public void iClickOnTrackOrder() {
        checkout.clickTrackOrder();
    }
}