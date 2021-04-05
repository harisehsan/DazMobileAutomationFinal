package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import member.APP.getProperty.UserGrowthGetProperty;
import member.APP.pages.UserGrowth;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class UserGrowthSteps {

    Drivers driver = new Drivers();
    UserGrowth userGrowth = new UserGrowth((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());
    UserGrowthGetProperty userGrowthGetProperty = new UserGrowthGetProperty();

    @Then("I verify the existence of user growth popup on Home Screen")
    public void iVerifyTheExistenceOfUserGrowthPopupOnHomeScreen() {
        Assert.assertTrue(userGrowth.verifyTheExistenceOfUserGrowthPopupOnHomeScreen());
    }

    @And("I close the first order voucher popup")
    public void iCloseTheFirstOrderVoucherPopup() {
        userGrowth.closeTheFirstVoucherPopup();
    }

    @Then("I verify the first voucher popup in local language")
    public void iVerifyTheFirstVoucherPopupInLocalLanguage() {
      Assert.assertTrue(userGrowth.verifyUserGrowthInlocalLanguage(), "User growth in local language is not shown properly");
    }

    @And("I select the avail now button")
    public void iSelectTheAvailNowButton() {
      userGrowth.selectTheAvailNowbutton();
    }

    @Then("I should be on the New User Zone Screen")
    public void iShouldBeOnTheNewUserZoneScreen() {
     Assert.assertTrue(userGrowth.verifyTheNewUserZoneScreen(),"Not successfully navigated to the New User Zone or New User screen is not successfully displayed!");
    }

    @And("I signin with {string} new account")
    public void iSigninWithNewAccount(String accountCount) throws IOException {
        userGrowth.signInWithNewAccount(userGrowthGetProperty.pkEmail(), userGrowthGetProperty.pkPassword(),
                userGrowthGetProperty.bdEmail(), userGrowthGetProperty.bdPassword(),
                userGrowthGetProperty.lkEmail(), userGrowthGetProperty.lkPassword(),
                userGrowthGetProperty.npEmail(), userGrowthGetProperty.npPassword(),
                userGrowthGetProperty.mmEmail(), userGrowthGetProperty.mmPassword(), accountCount);
    }

    @Then("I should see the voucher collection message")
    public void iShouldSeeTheVoucherCollectionMessage() {
        Assert.assertTrue(userGrowth.iShouldSeeTheCollectSucceassful(), "Voucher is collection is not successful!");
    }

    @And("I select collect button for user growth voucher")
    public void iSelectCollectButtonForUserGrowthVoucher() {
        userGrowth.iSelectCollectNowButton();
    }

    @Then("I should not see the voucher collect button")
    public void iShouldNotSeeTheVoucherCollectButton() {
        Assert.assertTrue(userGrowth.iShouldNotSeeTheCollectButton(),"Collect button is still visible!");
    }

    @And("I select add new address on checkout")
    public void iSelectAddNewAddressOnCheckout() {
       userGrowth.addNewAddressOnCheckout();
    }

    @And("I verify the money value discount")
    public void iVerifyTheMoneyValueDiscount() {
       Assert.assertTrue(userGrowth.verifyTheImpactOfVoucher(),"Voucher Impact is not shown correctly on price!");
    }

    @Then("I verify the non existence of user growth popup on Home Screen")
    public void iVerifyTheNonExistenceOfUserGrowthPopupOnHomeScreen() {
        Assert.assertFalse(userGrowth.verifyTheExistenceOfUserGrowthPopupOnHomeScreen(),"First Order Voucher should not appear");
    }

    @Then("I verify the existence of user growth module on my account")
    public void iVerifyTheExistenceOfUserGrowthmoduleOnMyAccount() {
        Assert.assertTrue(userGrowth.verifyTheExistencOfUserGrowthPopup(),"User growth popup is not existed!");
    }

    @And("I select go button user growth")
    public void iSelectGoButtonUserGrowth() {
        userGrowth.iSelectTheGoButtonforUserGrowthPopup();
    }

    @Then("I verify the non existence of user growth module in my account")
    public void iVerifyTheNonExistenceOfUserGrowthmoduleInMyAccount() {
        Assert.assertFalse(userGrowth.verifyTheExistencOfUserGrowthPopup(),"User growth popup is still existed!");
    }

    @And("I select voucher in my accounts")
    public void iSelectVoucherInMyAccounts() {
        userGrowth.selectVoucherInMyAccountSection();
    }

    @Then("I should see the collected user growth voucher in my voucher section")
    public void iShouldSeeTheCollected() {
        Assert.assertTrue(userGrowth.veryTheCollectedTheUserGrowthVoucherinMyVoucher(),"The Collected Voucher is not in user growth");
    }

    @Then("I verify The existence of the main user growth popup")
    public void iVerifyTheExistenceOfTheMainUserGrowthPopup() {

    }

    @And("I scroll to user growth popup on PDP")
    public void iScrollToUserGrowthPopupOnPDP() {
        userGrowth.scrollToUserGrowthPopup();
    }

    @And("I close the first order voucher popup if appeared")
    public void iCloseTheFirstOrderVoucherPopupIfAppeared() {
        userGrowth.closeTheFirstVoucherPopup();
    }

    @And("I verify the non existence of user growth module on Home Screen")
    public void iVerifyTheNonExistenceOfUserGrowthModuleOnHomeScreen() {

    Assert.assertFalse(userGrowth.verifyTheExistenceOfUserGrowthModuleOnHomeScreen(),"User growth Module is still exist On Home Screen");
    }

    @And("I verify the non existence of user growth on PDP")
    public void iVerifyTheNonExistenceOfUserGrowthOnPDP() {
        Assert.assertFalse(userGrowth.verifytheExistanceOfUserGrowthonPDP(),"The user growth is still existed!");
    }
}
