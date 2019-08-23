package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Venture;
import global.Drivers;
import org.testng.Assert;
import java.io.IOException;

public class VentureSteps {

    int country_Index;

    Drivers drivers = new Drivers();
    Venture venture = new Venture(drivers.getDriver());

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