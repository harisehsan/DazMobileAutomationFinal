package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.DarazMall;
import global.Drivers;
import org.testng.Assert;

public class DarazMallSteps {
    Drivers driver = new Drivers();
    DarazMall darazMall = new DarazMall(driver.getDriver());

    @And("I check for the existence of the daraz mall on Homepage")
    public void iCheckForTheExistenceOfTheDarazMall() {
        Assert.assertTrue(darazMall.checkExistenceofDarazMall(),"Daraz mall is not existed on Daraz Home page!");
    }

    @And("I select DarazMall")
    public void iSelectShopMore() {
       darazMall.selectShopMoreForDarazMall();
    }

    @Then("I should be in the daraz mall")
    public void iShouldBeInTheDarazMall() {
       Assert.assertTrue(darazMall.verifyTheDarazMall(), "Daraz Mall is not working correctly!");
    }

    @And("I navigate back to the main screen from Daraz Mall")
    public void iNavigateBackToTheMainScreenFromDarazMall() {
        darazMall.navigatebackToHomePage();
    }
}
