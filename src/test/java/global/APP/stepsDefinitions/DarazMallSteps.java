package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.DarazMall;
import global.Drivers;
import org.testng.Assert;

public class DarazMallSteps {
    Drivers driver = new Drivers();
    DarazMall darazMall = new DarazMall(driver.getDriver());

    @And("I check the existence of the Daraz Mall on Homepage")
    public void iCheckForTheExistenceOfTheDarazMall() {
        Assert.assertTrue(darazMall.checkExistenceofDarazMall(),"Daraz Mall/Official Store is not existed on Daraz Home page!");
    }

    @And("I click on Daraz Mall icon to navigate to Daraz Mall")
    public void clickOnDarazMallChannel() {
       darazMall.clickOnDarazMallChannel();
    }

    @Then("I should be on the Daraz Mall page")
    public void iShouldBeInTheDarazMall() {
       Assert.assertTrue(darazMall.verifyTheDarazMall(), "Daraz Mall/Official Store is not working or showing correctly!");
    }


    @And("I navigate back to the Home Page from {string}")
    public void iNavigateBackToTheMainScreenFromDarazMall(String page) {
        darazMall.navigatebackToHomePage(page);
    }

    @And("I click on shop more button to navigate to Daraz Mall")
    public void iClickOnShopMoreButtonToNavigateToDarazMall() {
        Assert.assertTrue(darazMall.clickOnShopMoreButtonForDarazMall(), "Shop More option for Daraz Mall/Official Store is not available yet!");
    }
}
