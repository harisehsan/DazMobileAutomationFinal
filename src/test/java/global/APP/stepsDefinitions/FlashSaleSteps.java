package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.FlashSale;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FlashSaleSteps {

    Drivers driver = new Drivers();
    FlashSale flashSale = new FlashSale((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @And("I check for the existence of the Flash Sale on Homepage")
    public void iCheckForTheExistenceOfTheFlashSale() {
        Assert.assertTrue(flashSale.checkForFlashSaleExistence(),"Flash Sale is not available yet!");
    }

    @Then("I check the existence of Flash Sale remaining time on Homepage")
    public void iCheckTheExistenceOfFlashSaleRemainingTime() {
        Assert.assertTrue(flashSale.verifyTheSaleTime(), "Flash Sale Timer is not available yet!");
    }

    @And("I click Shop More button to navigate to the Flash Sale page")
    public void iGotoTheFlashsale() {
       flashSale.gotoFlashsale();
    }

    @And("I goto the PDP page from Flash Sale page")
    public void iGotoThePDPScreenFromFlashsale() {
        flashSale.goToPdpPage();
    }

    @Then("I should see the number of sales, discount rate and product price on PDP page")
    public void iShouldSeeTheNumberOfSalesDiscountRateProductPrice() {
        Assert.assertTrue(flashSale.verifyTheSalesAndPrice(),"Flashsale is not available for this product");
    }
}
