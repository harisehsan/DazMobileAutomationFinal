package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.APP.getProperty.OrderGetProperty;
import global.APP.pages.Order;
import global.Drivers;
import member.APP.getProperty.AccountGetProperty;
import member.APP.pages.Account;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AccountSteps {
    Drivers drivers = new Drivers();
    Account account =  new Account(drivers.getDriver());
    AccountGetProperty accountGetProperty = new AccountGetProperty();
    OrderGetProperty orderGetProperty = new OrderGetProperty();
    Order order = new Order(drivers.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @Then("I verify that I have been logged in using google Account")
    public void iVerifyThatIHaveBeenLoggedInUsingGoogleAccount() throws IOException {
        Assert.assertTrue(account.verifySignin(),"User Login is not successfull!");
    }

    @And("I navigate to my account from payment screen")
    public void iNavigateBackToTheAccountFromCheckoutScreen() {
        account.navigateToAccountFromPaymentScreen();
    }

    @And("I select the pay now widget")
    public void iSelectThePayNowWidget() {
      account.selectPayNowWidigt();
    }

    @Then("I should see that product in the pay now menu")
    public void iShouldSeeThatProductInThePayNowMenu() throws IOException {
        Assert.assertTrue(account.verifyProductOnPayNowScreen(orderGetProperty.productName()),"Required Product is not found on Pay Now screen!");
    }

    @And("I select my cancellation widget")
    public void iSelectMyCancellationWidget() {
    account.selectMyCancellationWidget();
    }

    @And("I navigate to my account from cancellation screen")
    public void iNavigateToMyAccountFromCancellationScreen() {
        account.navigateToMyAccountFromCancellation();
    }

    @Then("I verify the order in the cancellation screen")
    public void iVerifyTheOrderInTheCancellationScreen() throws IOException {
        Assert.assertTrue(order.verifyProductNameOnCancellationScreen(orderGetProperty.productName()),"Required Product is not found on cancellation screen!");
    }

    @And("I navigate to the account menu")
    public void iNavigateToTheAccountMenu() {
        account.naviagteToAccounts();
    }

    @And("I select message in account section")
    public void iSelectMessageInAccountSection() {
     account.navigateToTheMessages();
    }

    @Then("I should be on the message page")
    public void iShouldBeOnTheMessagePage() {
       Assert.assertTrue(account.iShouldBeOnMessagePage(),"Not successfully navigated to the message page!");
    }

    @When("I navigate to the policies section from settings menu")
    public void iNavigateToThePoliciesSectionFromSettingsMenu() {
       account.navigateToPoliciesFromSettings();
    }

    @Then("I should be on the policies section")
    public void iShouldBeOnThePoliciesSection() {
        Assert.assertTrue(account.iShouldBeOnThePoliciesPage(),"Not successfully navigated to policies page!");
    }

    @And("I navigate back")
    public void iNavigateBackToSettingsMenu() {
        account.navigateBack();
    }

    @When("I navigate to the help section from accounts")
    public void iNavigateToTheHelpSectionFromAccounts() {
        account.navigateToHelpFromSettingsMenu();
    }

    @Then("I should be on the help section")
    public void iShouldBeOnTheHelpSection() {
      Assert.assertTrue(account.iShouldBeOnTheHelpMenu(),"Not successfully navigated to Help page!");
    }

    @Then("I should see the settings menu in local language")
    public void iShouldSeeTheSettingsMenuInLocalLanguage() {
        Assert.assertTrue(account.verifySettingsHeaderInLocalLanguage(),"Language change is not properly performed!");
    }

    @When("I navigate to messages settings from settings")
    public void iNavigateToMessagesSettingsFromSettings() {
       account.navigateToMessageSettings();
    }

    @Then("I should be on the message settings")
    public void iShouldBeOnTheMessageSettings() {
     Assert.assertTrue(account.iShouldBeOnTheMessageSettingsPage(),"Not successfully navigated to message settings!");
    }

    @Then("I should see visit store, my wishlist and voucher as per wallet availability")
    public void iShouldSeeVisitStoreMyWishlistAndVoucherAsPerWalletAvailability() {
    }
}
