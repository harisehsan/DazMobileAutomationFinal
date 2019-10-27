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


    @Then("I verify the product title, current price, discount rate, original price and rating")
    public void iCheckForTheProductTitlePriceAndStar() throws IOException {
        Assert.assertTrue(justForYou.verifyProductInformationInJustForYouSection(),"One or more information of product is not same as shown in PDP!");
    }

    @Then("I verify for the discount rate and original price")
    public void iCheckForTheCurrentPriceDiscountRateAndOriginalPrice() throws IOException {
      Assert.assertTrue(justForYou.verifyProductInformationInJustForYouSection(),"Product discount rate is not existed!");
    }

    @And("I scroll down to Just For You Section on Homepage and check its existence in local language")
    public void iScrollDownToJustForYouSectionOnHomepageAndCheckItsExistenceInLocalLanguage() throws IOException {
        Assert.assertTrue(justForYou.verifyJustForYouInLocalLanguage(),"Just for you is not displayed in local language!");

    }

    @And("I goto the PDP page from just for you catalog")
    public void iGotoThePDPPageFromJustForYouCatalog() {
        justForYou.navigateToPDPPage();
    }

    @And("I collect the product title, current price, rating, discount rate and original price from PDP")
    public void iCollectTheProductTitleCurrentPriceRatingDiscountRateAndOriginalPriceFromPDP() throws IOException {
        justForYou.collectProductInformation();
    }

    @And("I navigate back to the just for you section")
    public void iNavigateBackToTheJustForYouSection() {
        justForYou.navigateBackToJustForYou();
    }
}