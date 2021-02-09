package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Drivers;
import member.APP.pages.Voucher;
import org.testng.Assert;

import java.io.IOException;

public class VoucherSteps {

    Drivers drivers = new Drivers();
    Voucher voucher = new Voucher(drivers.getDriver());

    @And("I goto vouchers screen from wallet screen")
    public void iGotoVouchersScreenFromWalletScreen() {
        voucher.gotoVoucherfromWallet();
    }

    @Then("I should be on the my voucher page")
    public void iShouldBeOnTheMyVoucherPage() {
        Assert.assertTrue(voucher.shouldBeOnTheMyVoucherPage(),"Not successfully navigated to the voucher page!");
    }

    @And("I select details button on my voucher")
    public void iSelectDetailsButtonInMyVoucher() {
        voucher.selectDetailsOfVoucher();
    }

    @Then("I should be on the voucher details page")
    public void iShouldBeOnTheVoucherDetailsPage() {
        Assert.assertTrue(voucher.verifyTheVoucherDetailsPage(),"The voucher details page is not correctly displayed!");
    }

    @And("I scroll down to the voucher")
    public void iScrollDownToTheVoucher() {
      voucher.scrollToVoucherCode();
    }

    @And("I save the total price on checkout screen for voucher")
    public void iSaveTheTotalPriceOnCheckoutScreenForVoucher() throws IOException {
        voucher.storeTheTotalPrice();
    }

    @When("I select voucher apply button")
    public void iSelectVoucherApplyButton() throws IOException {
        voucher.voucherApplybtn();
    }

    @Then("I should see the voucher applied message")
    public void iShouldSeeTheVoucherAppliedMessage() throws IOException {
      Assert.assertTrue(voucher.iShouldSeeTheVoucherSuccessMessage(), "Voucher is not successfully applied!");
    }

    @Then("I should see the impact of voucher on total price")
    public void iShouldSeeTheImapctOfVoucherOnTotalPrice() throws IOException {
        Assert.assertTrue(voucher.iShouldSeeTheImapctOfVoucherOnTotalPrice(), "Impact of voucher on price is not correctly displayed!");
    }

    @And("I enter the voucher code on checkout for discount")
    public void iEnterTheVoucherCodeOnCheckoutForDiscount() throws IOException {
        voucher.enterVoucherCode();
    }

    @And("I select the voucher in the local language")
    public void iSelectTheVoucherInTheLocalLanguage() {
        voucher.gotToVoucherInLocalLanguage();
    }

    @Then("I should see voucher in local language")
    public void iShouldVoucherInLocalLanguage() {
     Assert.assertTrue(voucher.verifyTheLanguageChangeforVoucher(),"Voucher language change is not displayed!");
    }

    @And("I select non usable voucher")
    public void iSelectNonUsableVoucher() {
      voucher.gotoNonUsableVoucher();
    }

    @And("I wait for non usable voucher screen")
    public void iWaitForNonUsableVoucherScreen() {
      voucher.waitforTheNonUsableVoucherUsed();
    }

    @Then("I should verify the used section of non-usable voucher")
    public void iShouldVerifyTheUsedSectionOfNonUsableVoucher() {
     Assert.assertTrue(voucher.iShouldbeOnTheUsedPageOfMyVoucher(), "Not successfully navigated voucher page!");
    }

    @And("I select the expired voucher")
    public void iSelectTheExpiredVoucher() {
      voucher.selectExpiredVoucher();
    }

    @Then("I should be on the expired page")
    public void iShouldBeOnTheExpiredPage() {
        Assert.assertTrue(voucher.iShouldbeOnTheExpiredPageOfMyVoucher(),"Not successfully navigated to the Expired screen!");
    }

    @When("I select the deactivated")
    public void iSelectTheDeactivated() {
        voucher.selectDeactivatedVoucher();
    }

    @Then("I should be on deactivated screen")
    public void iShouldBeOnDeactivatedScreen() {
        Assert.assertTrue(voucher.iShouldBeOnTheDeactivatedPage(), "Not successfully navigated to the deactivated screen!");
    }

    @When("I select terms and conditions")
    public void iSelectTermsAndConditions() {
       voucher.selectTermsAndConditions();
    }

    @Then("I should see the terms and conditions")
    public void iShouldSeeTheTermsAndConditions() {
        Assert.assertTrue(voucher.verifyTheTermsAndCondition(),"Terms & Conditions are not properly displayed");
    }

    @And("I select Store tab in my voucher")
    public void iSelectStoreTabInMyVoucher() {
     voucher.selectStoreTab();
    }

    @Then("I should be on the store page")
    public void iShouldBeOnTheStorePage() {
        Assert.assertTrue(voucher.shouldBeOnStorePage(),"Not successfully navigated to store tab!");
    }

    @When("I select the daraz tab")
    public void iSelectTheDarazTab() {
        voucher.selectDaraztab();
    }

    @Then("I should be on the daraz tab")
    public void iShouldBeOnTheDarazTab() {
        Assert.assertTrue(voucher.shouldBeOnStorePage(),"Not successfully navigated to daraz tab!");
    }

    @And("I select the store credit tab")
    public void iSelectTheStoreCreditTab() {
        voucher.selectStoreCreditTab();
    }

    @Then("I should be on store credit")
    public void iShouldBeOnStoreCredit() {
        Assert.assertTrue(voucher.shouldBeOnStorePage(),"Then I should be on the store credit tab!");
    }

    @When("I click on the collect more button")
    public void iClickOnTheCollectMoreButton() {
       voucher.clickOnTheCollectMoreButton();
    }

    @Then("I should be on the collectable voucher screen")
    public void iShouldBeOnTheCollectableVoucherScreen() {
        Assert.assertTrue(voucher.iShouldBeOnTheCollectibleVoucherPage(),"Not successfully navigated voucher collect page!");
    }

    @When("I select get more vouchers button")
    public void iSelectGetMoreVouchersButton() {
        voucher.getMoreVouchers();
    }

//
//    }
}
