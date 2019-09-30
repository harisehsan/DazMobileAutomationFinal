package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.SearchBar;
import global.Drivers;
import org.testng.Assert;

public class SearchBarSteps {
    Drivers driver = new Drivers();
    SearchBar searchBar = new SearchBar(driver.getDriver());

    @Then("I check the existence of scan icon and text on Homepage")
    public void iCheckTheExistenceOfScanIconAndTextOnHomepage() {
      searchBar.verifyTheScanIconAndText();
    }

    @And("I click on scan icon to navigate to scan page")
    public void iClickOnScanIconToNavigateToScanPage() {
        searchBar.clickOnScanIcon();
    }

    @Then("I should be on scan page")
    public void iShouldBeOnScanPage() {
        Assert.assertTrue(searchBar.verifyScanPage(),"Scan Page is not working properly!");
    }

    @Then("I check for the existence of the searchbar on Homepage")
    public void iCheckForTheExistenceOfTheSearchbarOnHomepage() {
        Assert.assertTrue(searchBar.verifyTheExistenceofSearchBar(), "Search bar is not existed on Homepage!");
    }

    @Then("I check for the existence of daraz wallet icon and text")
    public void iCheckForTheExistenceOfDarazWalletIconAndText() {
        Assert.assertTrue(searchBar.verifyTheExistenceOfDarazWalletIconAndText(), "Either a Daraz Wallet is not existed on homepage or not showing properly!");

    }

    @And("I click on wallet icon to navigate to scan page")
    public void iClickOnWalletIconToNavigateToScanPage() {
        searchBar.clickOnWallet();
    }

    @Then("I should be on the Daraz Wallet page")
    public void iShouldBeOnTheDarazWalletPage() {
      searchBar.checkTheDarazWalletPage();

    }
}
