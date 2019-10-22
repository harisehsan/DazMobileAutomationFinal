package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.JustForYou;
import global.Drivers;
import org.testng.Assert;
import java.io.IOException;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-October-2019
 */

public class JustForYouSteps {
    Drivers drivers = new Drivers();
    JustForYou justForYou = new JustForYou(drivers.getDriver());

    @And("I scroll down to Just For You Section on Homepage and check its existence")
    public void iScrollDownToJustForYouSectionOnHomepageAndCheckItsExistence() {
        Assert.assertTrue(justForYou.checkTheExistenceofJustForYou(),"Just For You is not available on Homepage!");
    }


    @And("I Check for the product title, current price and star")
    public void iCheckForTheProductTitlePriceAndStar() throws IOException {
        Assert.assertTrue(justForYou.verifyProductTitleAndPrice(),"Product title or price is not displayed or existed on Homepage!");

    }

    @And("I Check for the discount rate and original price")
    public void iCheckForTheCurrentPriceDiscountRateAndOriginalPrice() throws IOException {
      Assert.assertTrue(justForYou.verifyTheOriginalAndDiscountRate(),"Product discount rate is not existed!");
    }


    @Then("I should see the consistent information on PDP page")
    public void iShouldSeeTheConsistentInformationOnPDPPage() throws IOException {
        Assert.assertTrue(justForYou.verifyPDPPageItems(), "One or more PDP items is/are not same as shown in the catalog!");
    }

    @And("I scroll down to Just For You Section on Homepage and check its existence in local language")
    public void iScrollDownToJustForYouSectionOnHomepageAndCheckItsExistenceInLocalLanguage() throws IOException {
        Assert.assertTrue(justForYou.verifyJustForYouInLocalLanguage(),"Just for you is not displayed in local language!");

    }

    @And("I goto the PDP page from just for you catalog")
    public void iGotoThePDPPageFromJustForYouCatalog() {
        justForYou.navigateToPDPPage();
    }
}