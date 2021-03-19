package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Drivers;
import member.APP.pages.Utilities;
import org.testng.Assert;

import java.io.IOException;

public class UtilitiesSteps {

    Drivers driver = new Drivers();
    Utilities utilities = new Utilities(driver.getDriver());

    @When("I select dbill channnel")
    public void iSelectDbillChannnel() {
        utilities.selectDBills();
    }

    @Then("I should be on the utility checkout screen")
    public void iShouldBeOnTheUtilityCheckoutScreen() {
        Assert.assertTrue(utilities.iShouldBeOnTheUtilityCheckoutPage(),"Not successfully naviagted to dbills Screen!");
        utilities.waitforBillPageToLoad();
    }

    @When("I select the pay bill button")
    public void iSelectThePayBillButton() {
        utilities.selectPayNowButton();
    }

    @Then("I verify the banner of the utility checkout")
    public void iVerifyTheBannerOfTheUtilityCheckout() {
        Assert.assertTrue(utilities.verifyTheBannerScreen(), "The ad banner is not existed!");
    }

    @Then("I verify the components of utility")
    public void iVerifyTheComponentsOfUtility() {
        Assert.assertTrue(utilities.verifyTheComponentsOfTheExistingBill(),"The components of bills are displayed properly!");
    }

    @Then("I should see bill type\\(s)")
    public void iShouldSeeBillTypeS() {
        Assert.assertTrue(utilities.iLookForTheSavedConsumerBills(),"One or more bill type is not properly displayed!");
    }


    @And("I scroll to view the banner")
    public void iScrollToViewTheBanner() {
        utilities.scrollToBanner();
    }

    @When("I select proceed to pay button")
    public void iSelectProceedToPayButton() {
        utilities.selectProceedToPayButton();
    }

    @Then("I should be on the select payment screen")
    public void iShouldBeOnTheSelectPaymentScreen() {
        Assert.assertTrue(utilities.iShouldBeOnTheSelectPaymentMethodScreen(),"Not successfully navigated to payment selection screen!");
    }

    @When("I select the banner")
    public void iSelectTheBanner() {
        utilities.selectBanner();
    }

    @Then("I should be on the banner screen")
    public void iShouldBeOnTheBannerScreen() {
        Assert.assertTrue(utilities.iShouldBeOnThePayUtilityPage(),"Not successfully navigated to banner page!");
    }


    @When("I select add new account")
    public void iSelectAddNewAccount() {
        utilities.selectAddNewAccount();
    }

    @And("I select {string}")
    public void iSelect(String type) {
        utilities.selectTheBillType(type);
    }

    @And("I enter the details for the {string} bill")
    public void iEnterTheDetailsForTheBill(String type) throws IOException {
        utilities.iEnterTheAccountNumber(type);
    }

    @And("I select check the bill {string}")
    public void iSelectCheckTheBill(String type) {
        utilities.checkTheBill(type);
    }

    @Then("I verify the data of the bill for {string} bill")
    public void iVerifyTheDataOfTheBillForBill(String type) throws IOException {
        Assert.assertTrue(utilities.verifyTheDataOfBill(type), "The bill data is not same as ");
    }

    @And("I navigate back to add new account")
    public void iNavigateBackToAddNewAccount() {
        utilities.returnToTheUtilityCheckoutScreen();
    }

    @Then("I verify the form details for {string}")
    public void iVerifyTheFormDetailsFor(String type) {
        Assert.assertTrue(utilities.verifyTheComponentsOfTheNewBillForm(type),"The elements of bill are not displayed properly!");
    }

    @When("I select the Reload & pay bills")
    public void iSelectTheReloadPayBills() {
        utilities.selectReloadAndPayBills();
    }


    @Then("I should be on the reload & pay bill page")
    public void iShouldBeOnTheReloadPayBillPage() {
        Assert.assertTrue(utilities.iShouldBeOnTheReloadAndPayBills(),"Not successfully navigated to the Reloads and Bills Page!");
    }

    @When("I select reloads")
    public void iSelectReloads() {
        utilities.selectTheReload();
    }

    @Then("I should be on the reload screen")
    public void iShouldBeOnTheReloadScreen() {
        Assert.assertTrue(utilities.quickTopUp(),"Not successfully navigated to the topup Page!");
    }

    @Then("I verify some extra information")
    public void iVerifySomeExtraInformation() {
        Assert.assertTrue(utilities.verifyTheExtraDeatilsOfTheBillPage(),"Extra information related to bill are not properly displayed!");
    }

    @And("I goto dbills from Homepage")
    public void iGotoDbillsFromHomepage() {
        utilities.selectDBill();
    }

    @And("I select CEB")
    public void iSelectCEB() {
        utilities.gotoTheCEB();
    }

    @And("I enter the bill details for {string}")
    public void iEnterTheBillDetailsForCEB(String billType) throws InterruptedException, IOException{
        utilities.enterTheBillData(billType);
    }

    @And("I select checkout on dbill")
    public void iSelectCheckoutOnDbill() {
        utilities.selectTheCheckoutButton();
    }
}