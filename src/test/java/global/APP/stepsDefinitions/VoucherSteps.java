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
}
