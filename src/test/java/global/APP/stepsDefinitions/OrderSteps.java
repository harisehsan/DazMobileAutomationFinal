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
    public void iVerifyThatOrderHasBeenCancelled() {
        Assert.assertTrue(order.verifyCancellation());
    }

    @And("I change the quantity in the cancellation screen")
    public void iChangeTheQuantityInTheCancellationScreen() {

    }
}