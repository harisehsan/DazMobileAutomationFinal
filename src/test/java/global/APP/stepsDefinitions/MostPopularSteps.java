package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.MostPopular;
import global.Drivers;
import org.testng.Assert;

public class MostPopularSteps {

    Drivers drivers = new Drivers();
    MostPopular orderGetProperty = new MostPopular(drivers.getDriver());

    @And("I check the existence of the most popular on Homepage")
    public void iCheckTheExistenceOfTheMostPopularOnHomepage() {
        Assert.assertTrue(orderGetProperty.verifyTheExistenceOfMostPopular(),"Either a Most Popular is not existed or not displayed properly!");
    }

    @Then("I verify for the existence of month for most popular")
    public void iVerifyForTheExistenceOfMonthForMostPopular() {
        Assert.assertTrue(orderGetProperty.verifyTheExistenceOfMonth(),"Month of Most Popular is not displayed properly!");
    }

    @Then("I check the existence of most popular in the local language")
    public void iCheckTheExistenceOfMostPopularInTheLocalLanguage() {
       Assert.assertTrue(orderGetProperty.verifyTheExistenceOfMostPopularInLocalLanguage(), "Most Popular is not displayed properly!");
    }

    @And("I select the most popular classification")
    public void iSelectTheMostPopularClassification() {
        orderGetProperty.selectMostPopularClassification();

    }

    @Then("I should be on most popular classification page")
    public void iShouldBeOnMostPopularClassificationPage() {
        Assert.assertTrue(orderGetProperty.verifyTheMostPopularPage(),"Classifications of Most popular is not working correctly");
    }
}
