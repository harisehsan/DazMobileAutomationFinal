package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.APP.pages.TotalPrice;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class TotalPriceSteps {
    TotalPrice totalPrice = new TotalPrice((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @When("I calculate the prices parameters on checkout and store the resultant price value")
    public void iCalculateThePricesParametersOnCheckoutAndStoreTheResultantPriceValue() throws IOException {
        totalPrice.priceCalculationOnCheckout();
    }

    @Then("I compare the calculated price with the total price on checkout")
    public void iCompareTheCalculatedPriceWithTheTotalPriceOnCheckout() throws IOException {
        Assert.assertTrue(totalPrice.verifyTheCalculatedPriceWithTotalPriceCart(),"Calculated Price on Checkout is not same as total price");
    }

    @And("I calculate the the price parameter in cart and store the price")
    public void iCalculateTheThePriceParameterInCartAndStoreThePrice() throws IOException {
        totalPrice.priceCalculationOnCart();
    }

    @Then("I verify the calculated price with total price in the cart")
    public void iVerifyTheCalculatedPriceWithTotalPriceInTheCart() throws IOException {
        Assert.assertTrue(totalPrice.compareTheCartCalculatedPriceWithTotalPrice(), "The total price and calculated price in cart are not same!");
    }

    @Then("I compare the cart total price with checkout total price")
    public void iCompareTheCartTotalPriceWithCheckoutTotalPrice() throws IOException {
        Assert.assertTrue(totalPrice.compareTheTotalPriceofCartAndCheckout(), "The total price of cart and checkout are not same!");
    }

    @And("I store the default address details")
    public void iStoreTheDefaultAddressDetails() throws IOException {
        totalPrice.saveTheAddressDetails();
    }

    @And("I select the default address on pdp")
    public void iSelectTheDefaultAddressOnPdp() throws IOException {
      totalPrice.selectDefaultAddressOnPDP();
    }
}
