package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import member.APP.pages.PrivateZone;
import org.testng.Assert;

public class PrivateZoneSteps {
    Drivers drivers = new Drivers();
    PrivateZone privateZone = new PrivateZone(drivers.getDriver());

    @And("I wait for store page to load")
    public void iWaltForStorePageToLoad() {
        Assert.assertTrue(privateZone.waitforTheStorePageToLoad(),"Store Page is not successfully loaded!");
    }


    @Then("I verify the components of the store page")
    public void iVerifyTheComponentsOfTheStorePage() {
      Assert.assertTrue(privateZone.verifyTheExistenceOftheBasicComponents(),"Shop Name or Logo is not existed!");
    }

    @And("I select the options button on the store page")
    public void iSelectTheOptionsButtonOnTheStorePage() {
      privateZone.selectOptionsButton();
    }


    @Then("I should see the share this store button")
    public void iShouldSeeTheShareThisStoreButton() {
      Assert.assertTrue(privateZone.verifyFortheShareThisStoreButton(),"Share this store button is not displayed!");
    }

    @And("I navigate to categories from store")
    public void iNavigateToCategoriesFromStore() {
        privateZone.navigateToCategoriesFromStore();
    }

    @Then("I should see the {string} on the categories page")
    public void iShouldSeeTheOnTheCategoriesPage(String args) {
       Assert.assertTrue(privateZone.iShouldBeOnTheCategoriesPage(args),"Not successfully navigated to the categories!");
    }

    @And("I navigate to Profile from store")
    public void iNavigateToProfileFromStore() {
        privateZone.navigateToProfileFromStore();
    }

    @Then("I should be on the profile page")
    public void iShouldBeOnTheProfilePage() {
     Assert.assertTrue(privateZone.iShouldBeOnTheProfile(),"Not successfully navigated profile page!");
    }

    @And("I skip the got it popup")
    public void iSkipTheGotItPopup() {
      privateZone.skipTheGotItPopup();
    }

    @And("I select following button to unfollow the store")
    public void iSelectFollowingButton() {
     privateZone.selectTheFollowingStore();
    }

    @Then("I should follow button again")
    public void iShouldFollowButtonAgain() {
      Assert.assertTrue(privateZone.iShouldSeeTheFollowbutton(),"The Store is not un-followed successfully!");
    }
}
