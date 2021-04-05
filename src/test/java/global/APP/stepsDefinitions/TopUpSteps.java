package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import member.APP.pages.TopUp;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TopUpSteps {
    Drivers drivers = new Drivers();
    TopUp topUp = new TopUp((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @And("I should be redirected to TopUP screen")
    public void iShouldBeRedirectedToTopUPScreen() throws IOException {
        topUp.iShouldBeOnTopUpScreen();
    }

    @And("I should get validation on wrong number format")
    public void iShouldGetValidationOnWrongNumberFormat() {
        topUp.getValidation();
    }

    @And("I assert country code should be removed")
    public void iAssertCountryCodeShouldBeRemoved() throws IOException {
        topUp.countryCodeShouldBeRemoved();
    }

    @And("I select Operator from the List and select Product")
    public void iSelectOperatorFromTheListAndSelectProduct() {
        topUp.selectOperator();
    }

    @And("I should be redirected to M-site checkout")
    public void iShouldBeRedirectedToMSiteCheckout() {
        topUp.mSiteCheckOutBtn();
    }

    @And("I click {string} on Reloads page")
    public void iClickOnReloadsPage(String arg0) {
        topUp.clickReloadIconOnLK();
    }

    @And("I click on First Banner on Recharge and EStore page")
    public void iClickOnFirstBannerOnRechargeAndEStorePage() {
        topUp.clickFirstBannerNp();
    }

    @And("I click on reload banner on search page")
    public void iClickOnReloadBannerOnSearchPage() {
        topUp.topUpBannerOnSearchPage();
    }
}
