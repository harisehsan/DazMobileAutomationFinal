package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Drivers;
import member.APP.pages.Wallet;
import org.testng.Assert;

public class WalletStepDefination {

    Drivers driver = new Drivers();
    Wallet wallet = new Wallet(driver.getDriver());

    @Then("I verify the components of wallet screen before login")
    public void iVerifyTheComponentsOfWalletScreenBeforeLogin() {
        Assert.assertTrue(wallet.verifyTheWalletPage(),"Login message or button is not properly displayed on login button!");
    }

    @Then("I should be on the wallet activation page")
    public void iShouldBeOnTheWalletActivationPage() {
        Assert.assertTrue(wallet.walletActivationPage(),"Wallet activation page is not successfully displayed");
    }

    @Then("I should see the activate button on wallet screen")
    public void iShouldSeeTheActivateButtonOnWalletScreen() {
        Assert.assertTrue(wallet.verifyTheWalletButton(),"The wallet activate button is not properly displayed!");
    }

    @And("I enter the email {string} and password {string}")
    public void iEnterTheEmailAndPassword(String email, String password) {
        wallet.enterCredentailsForActivatedWalletAccount(email, password);
    }

    @Then("I verify the components of wallet for the activated account")
    public void iVerifyTheComponentsOfWalletForTheActivatedAccount() {
     Assert.assertTrue(wallet.verifyThecomponenetsOfActivatedWallet(),"One or more wallet components are not properly displayed!");
    }

    @And("I select the top up button")
    public void iSelectTheTopUpButton() {
      wallet.selectTopupButtonOnWallet();
    }

    @Then("I should be on deposit screen")
    public void iShouldBeOnDepositScreen() {
        Assert.assertTrue(wallet.verifyNavigationToDepositeScreen(),"Not successfully navigated deposit screen!");
    }


    @And("I select balance details")
    public void iSelectBalanceDetails() {
        wallet.selectBalanceDeatils();
    }

    @Then("I should be on the balance details screen")
    public void iShouldBeOnTheBalanceDetailsScreen() {
        Assert.assertTrue(wallet.verifyNavigationTotBalanceDeatils(),"Not properly navigated to balance details screen!");
    }

    @When("I select mobile reload")
    public void iSelectMobileReload() {
        wallet.selectMobileReload();
    }

    @Then("I should be on the mobile reload page")
    public void iShouldBeOnTheMobileReloadPage() {
      Assert.assertTrue(wallet.verifyNavigationToMobileReload(), "Not properly navigated to balance details screen!");
    }

    @Then("I verify the components of all transaction section")
    public void iVerifyTheComponentsOfAllTransactionSection() {
        Assert.assertTrue(wallet.verifyTheAllTransactionSection(),"All transaction are not properly displayed!");
    }

    @When("I goto the purchase section of the wallet")
    public void iGotoThePurchaseSectionOfTheWallet() {
         wallet.goToPurchasesSection();
    }

    @Then("I verify the purchase section of wallet")
    public void iVerifyThePurchaseSectionOfWallet() {
        Assert.assertTrue(wallet.verifyThePaymentSection(),"Payments section of wallet are not properly displayed!");
    }

    @When("I goto the refund section of wallet")
    public void iGotoTheRefundSectionOfWallet() {
        wallet.goToRefundFromPurchases();
    }

    @Then("I verify the components of refund section of wallet")
    public void iVerifyTheComponentsOfRefundSectionOfWallet() {
        Assert.assertTrue(wallet.verifyTheRefundSection(),"The Refund section of wallet is not properly displayed!");
    }

    @When("I select the topups section of the wallet")
    public void iSelectTheTopupsSectionOfTheWallet() {
        wallet.gotoTheTopupSectionOfWallet();
    }

    @Then("I verify the top up section of the wallet section")
    public void iVerifyTheTopUpSectionOfTheWalletSection() {
        Assert.assertTrue(wallet.verifyTheTopUpsSection(),"The top up section is not properly displayed!");
    }

    @When("I goto the coupon section of the wallet")
    public void iGotoTheCouponSectionOfTheWallet() {
        wallet.gotoTheCouponsSection();
    }

    @Then("I should be on the coupon section")
    public void iShouldBeOnTheCouponSection() {
        Assert.assertTrue(wallet.verifyTheCouponSection(),"Not successfully navigated to coupon section!");
    }

    @When("I goto the withdrawals section of wallet")
    public void iGotoTheWithdrawalsSectionOfWallet() {
        wallet.gotoTheWithdrwalsSection();
    }

    @Then("I should be on withdrawals section of wallet")
    public void iShouldBeOnWithdrawalsSectionOfWallet() {
        Assert.assertTrue(wallet.verifyTheWithdrawalsSection(),"Not successfully navigated to withdrawals section!");

    }

    @And("I select switch to another account")
    public void iSelectSwitchToAnotherAccount() {
       wallet.selectSwitchAccount();
    }
}