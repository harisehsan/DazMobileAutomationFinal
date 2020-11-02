package global.APP.stepsDefinitions;

import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.APP.getProperty.OrderGetProperty;
import global.APP.pages.Order;
import global.Drivers;
import org.testng.Assert;

import java.io.IOException;

public class OrderSteps  {
    Drivers drivers = new Drivers();
    OrderGetProperty orderGetProperty = new OrderGetProperty();
    Order order = new Order(drivers.getDriver());


    @And("I click on cancel order button")
    public void iClickOnCancelOrderButton() {
        order.clickOnCancelOrder();
    }

    @And("I Select the reason for cancellation")
    public void iSelectTheReasonForCancellation() throws IOException {
        order.selectReasonForCancellation(orderGetProperty.cancellationReason());
    }

    @And("I provide comments for cancellation")
    public void iProvideCommentsForCancellation() throws IOException {
     order.cancellationComment(orderGetProperty.cancellationComment());
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
      order.submitCancellation();
    }

    @Then("I verify that order has been cancelled")
    public void iVerifyThatOrderHasBeenCancelled() throws IOException {
        Assert.assertTrue(order.verifyProductNameOnCancellationScreen(orderGetProperty.productName()),"Required Product is not found on cancellation screen!");
        Assert.assertTrue(order.verifyCancellationStatus(),"Order is not successfully canceled!");
    }

    @And("I verify the quantity amount on cancellation page")
    public void iVerifyTheQuantityAmountOnCancellationPage() throws IOException {
        Assert.assertEquals(orderGetProperty.cancellationOrderAmount(),order.verifyCancelAmount(orderGetProperty.cancellationOrderAmount()),"Order Cancel amount is not same as specified!");
    }

    @And("I skip first order voucher popup")
    public void iSkipFirstOrderVoucherPopup() {
     order.skipFirstOrderVoucherPopup();
    }

    @When("I click on seller name")
    public void iClickOnSellerName() {
        order.clickOnSellerName();
    }

    @Then("I should be on the seller store")
    public void iShouldBeOnTheSellerStore() {
        Assert.assertTrue(order.iShouldBeOnTheSellerShop(),"Not successfully navigated to seller shop!");
    }

    @Then("I verify the shipping and billing adresses titles")
    public void iVerifyTheShippingAndBillingAdressesTitles() {
      Assert.assertTrue(order.verifyTheTitleOfAddresses(),"Address details are not displayed on order details page!");
    }

    @When("I select pay now button")
    public void iSelectPayNowButton() {
        order.clickOnPayNowButton();
    }

    @Then("I verify the existence of total price on order detail page")
    public void iVerifyTheTotalPriceOfOrder() throws IOException {
        Assert.assertTrue(order.verifyTheOrderTotalPrice(orderGetProperty.totalPrice()),"Order total price is not displayed on order details page!");
    }

    @Then("I verify the existence COD payment method on order detail page")
    public void iVerifyTheExistenceCODPaymentMethodOnOrderDetailPage() {
        Assert.assertTrue(order.verifyTheOrderPaymentMethod(),"Payment method is not displayed on order details page!");
    }

    @And("I wait for the select payment screen")
    public void iWaitForTheSelectPaymentScreen() {
     order.waitForThePaymentScreen();
    }

    @And("I save the shipping address")
    public void iSaveTheShippingAddress() throws IOException {
      order.iSaveTheShippingAddress();
    }

    @Then("I verify the shipping address on order details page")
    public void iVerifyTheShippingAddressOnOrderDetailsPage() throws IOException {
        Assert.assertTrue(order.verifyTheShippingAddressOnOrderDetailsPage(orderGetProperty.shippingAddress()),"Shipping Address is not correctly displayed on order details page!");
    }

    @And("I save the total price on checkout screen")
    public void iSaveTheTotalPriceOnCheckoutScreen() throws IOException {
        order.saveTheTotalPriceOnCheckout();
    }

    @Then("I verify the order number, order creation time, order status")
    public void iVerifyTheOrderNumberOrderCreationTimeOrderStatus() {
        Assert.assertTrue(order.verifyTheOrderStatusOrderNumberAndOrderDate(),"Order status or order date is not correctly displayed!");
    }

    @When("I long press on order")
    public void iLongPressOnOrder() {
       order.pressOrderNumber();
    }

    @Then("I should copied snackbar message")
    public void iShouldCopiedSnackbarMessage() {
        Assert.assertTrue(order.verifyTheCopiedText(),"Order number is not copied successfully!");
    }

    @Then("I should be on the order received page")
    public void iShouldBeOnTheOrderReceivedPage() {
      Assert.assertTrue(order.verifyTheOrderRecievedPage(),"Order received page is not properly displayed!");
    }

    @Then("I verify for the {string} promotion label")
    public void iVerifyForThePromotionLabel(String promotionName) {
    Assert.assertTrue(order.verifyThePromotionlabel(promotionName),"The promotion label is not displayed");
    }
}