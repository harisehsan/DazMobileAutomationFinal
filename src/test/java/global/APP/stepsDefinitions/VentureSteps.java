package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Venture;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.IOException;

public class VentureSteps {

    int country_Index;

    //Drivers drivers = new Drivers();
    Venture venture = new Venture((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @And("I navigate to the country menu")
        public void iNavigateToCountryMenu() throws IOException {
        venture.navigateToVenture();
    }

    @And("I check for the selected venture")
    public void iNavigateToTheSettings() {
        Assert.assertTrue(venture.verifyTheSelectedCountry());
    }

    @And("I change the venture")
    public void iChangeTheVenture() {
        country_Index = venture.changeVenture();
    }

    @Then("I verify for the changed venture")
    public void iVerifyForTheChangedVenture() {
        Assert.assertTrue(venture.verifyForTheChangedCountry(country_Index));
    }
}