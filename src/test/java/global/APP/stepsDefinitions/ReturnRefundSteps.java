package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.APP.getProperty.OrderGetProperty;
import global.APP.pages.ReturnRefund;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class ReturnRefundSteps {
    Drivers drivers = new Drivers();
    ReturnRefund returnRefund = new ReturnRefund((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());
    OrderGetProperty orderGetProperty = new OrderGetProperty();

    @When("I select all in my order")
    public void iSelectAllInMyOrder() {
        returnRefund.selectAllInMyOrders();
    }

    @And("I skip the delivered popup")
    public void iSkipTheDeliveredPopup() {
        returnRefund.skipDeliveredGotItButton();
    }

    @Then("I look for the delivered ordered for {string} product in my orders")
    public void iLookForTheDeliveredOrderedForProductInMyOrders(String productType) throws IOException {
        Assert.assertTrue(returnRefund.lookForTheOrderID(productType), "Either Order ID is existed or Order is not in Delivered state!");
    }

    @And("I select return")
    public void iSelectReturn() {
        returnRefund.selectReturn();
    }

    @And("I select reason for return")
    public void iSelectReasonForReturn() {
        returnRefund.selectReturnReason();
    }

    @And("I select return shipping method")
    public void iSelectReturnShippingMethod() {
        returnRefund.selectReturnShipmentMethod();
    }

    @And("I select continue button for delivery conformation")
    public void iSelectContinueButtonForDeliveryConformation() {
        returnRefund.selectContinueButton();
    }

    @Then("I verify the information on return details screen")
    public void iVerifyTheInformationOnReturnDetailsScreen() {
        Assert.assertTrue(returnRefund.verifyTheInformationOnReturnDeatilsScreen(), "Return request for order is not properly generated!");
    }

    @And("I select return bundle option")
    public void iSelectReturnBundleOption() {
        returnRefund.selectReturnCombo();
    }

    @And("I provide comments for return")
    public void iProvideCommentsForReturn() throws IOException {
        returnRefund.provideCommentsForReturn(orderGetProperty.cancellationComment());
    }
}
