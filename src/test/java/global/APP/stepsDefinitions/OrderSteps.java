package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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
}