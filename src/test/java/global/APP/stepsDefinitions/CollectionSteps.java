package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Collection;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CollectionSteps {
    Drivers driver = new Drivers();
    Collection collection = new Collection((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @Then("I check the existence of the Collections on Homepage")
    public void iCheckTheExistenceOfTheCollectionOnHomepage() {
       Assert.assertTrue(collection.verifyTheExistenceOfCollectionOnHomePage(),"Collection does not exist on Homepage!");
    }

    @And("I click on Shop more button to enter to collections page")
    public void iClickOnShopMoreButtonToEnterToCollectionPage() {
        Assert.assertTrue(collection.selectShopMoreForCollections(), "Shop More for collection is not available yet!");
    }

    @Then("I should be on collection page")
    public void iShouldBeOnCollectionPage() {
       Assert.assertTrue(collection.verifyTheCollectionPage(), "Collection Page is not working correctly");
    }

    @Then("I check again the existence of the Collections on Homepage")
    public void iCheckAgainTheExistenceOfTheCollectionsOnHomepage() {
        Assert.assertTrue(collection.checkTheExistenceOfCollectionOnHomePage(),"Collection does not exist on Homepage!");
    }

    @Then("I navigate to the account settings menu")
    public void iNavigateToTheAccountSettingsMenu() {
       collection.naviagteToSettings();
    }

    @And("I change the language other then english")
    public void iChangeTheLanguageOtherThenEnglish() {
        collection.changeLanguage();
    }

    @Then("I check for the existence of the Collections on Homepage in the local language of the venture")
    public void iCheckForTheExistenceOfTheCollectionsOnHomepageInTheLocalLanguageOfTheVenture() {
        Assert.assertTrue(collection.checkForCollectionOnHomePageInLocalLanguage(),"Text is not properly localized!");
    }
}