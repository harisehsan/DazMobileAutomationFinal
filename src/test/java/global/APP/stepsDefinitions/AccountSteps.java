package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.APP.getProperty.OrderGetProperty;
import global.APP.pages.Order;
import global.APP.pages.SearchBar;
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
    SearchBar searchBar = new SearchBar(drivers.getDriver());
    boolean walletExistence = false;

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

    @Then("I check for the existence of daraz wallet")
    public void iCheckForTheExistenceOfDarazWalletIconAndText() {
      walletExistence = searchBar.verifyTheExistenceOfDarazWalletIconAndText();

    }

    @Then("I verify the existence of the My Wishlist, Followed Store and Voucher as per daraz wallet")
    public void iVerifyTheExistenceOfTheMyWishlistFollowedStoreAndVoucherAsPerDarazWallet() {
        Assert.assertTrue(account.verifyTheExistenceOfWishlistFollowedStoreAndVoucher(walletExistence),"Widgets are not shown properly in the my account");

    }

    @When("I jump to daraz wallet otherwise vouchers if daraz wallet is not existed")
    public void iJumpToDarazWalletOtherwiseVouchersIfDarazWalletIsNotExisted() {
      account.navigateToDarazWalletORVoucherFromAccounts(walletExistence);
    }

    @Then("I should be on the Daraz Wallet screen or voucher screen")
    public void iShouldBeOnTheDarazWalletScreenOrVoucherScreen() {
      Assert.assertTrue(account.iShouldBeOnTheDarazWalletOrVoucherPage(walletExistence),"Not successfully navigated to wallet or voucher screen!");

    }

    @Then("I verify the existence of red dot on message")
    public void iVerifyTheExistenceOfRedDotOnMessage() {
        Assert.assertTrue(account.verifyTheExistenceOfRedDotOnMessage(),"The red dot is not properly shown on message!");
    }

    @Then("I navigate to the account settings menu in local language")
    public void iNavigateToTheAccountSettingsMenuInLocalLanguage() {
      account.navigateToAccountSettingsInLocalLanguage();
    }

    @Then("I verify the components of my services")
    public void iVerifyTheComponentsOfMyServices() {
        Assert.assertTrue(account.verifyTheComponentsOfMyServices(),"The Components of My Service are not properly displayed!");
    }

    @When("I select avatar")
    public void iSelectAvatar() {
        account.selectAvatar();
    }

    @Then("Then I should see take photo and select from album options")
    public void thenIShouldSeeTakePhotoAndSelectFromAlbumOptions() {
      Assert.assertTrue(account.verifyTheExistenceOfTakePhotoAndSelectFromAlbum(),"Photo options for avatar are not properly displayed!");
    }

    @Then("I verify the existence of the track package section")
    public void iVerifyTheExistenceOfTheTrackPackageSection() {
        Assert.assertTrue(account.verifyTheExistenceOfTheTrackPackage(),"The track package is not displayed in my account section!");
    }

    @Then("I goto the consolidated delivery screen to verify the same order status")
    public void iGotoTheConsolidatedDeliveryScreenToVerifyTheSameOrderStatus() {
        Assert.assertTrue(account.verifyTheSameOrderStatusOnConsolidatedDeliveryScreen(),"The package name is not same as on consolidated screen!");
    }

    @And("I scroll to messages in my account menu")
    public void iScrollToMessagesInMyAccountMenu() {
        account.scrollToMessage();
    }

    @Then("I verify status order status in my account")
    public void iVerifyStatusOrderStatusInMyAccount() throws IOException {
   Assert.assertTrue(account.verifyTheOrderStatusOnAccountPage(accountGetProperty.getOrderStatus1(),accountGetProperty.getOrderStatus2(),accountGetProperty.getOrderID()),"Order status is not displayed on the account page!");
    }

    @And("I goto cart from account menu")
    public void iGotoCartFromAccountMenu() {
       account.navigateToCartFromAccount();

    }

    @Then("I verify that I should be on the cart page")
    public void iVerifyThatIShouldBeOnTheCartPage() {
        Assert.assertTrue(account.verifyForTheCartPage(),"Not successfully navigated to the cart page!");
    }


    @And("I goto cart from account information page")
    public void iGotoCartFromAccountInformationPage() {
     account.gotoCartfromAccountInformationPage();
    }

    @And("I goto account information menu")
    public void iGotoAccountInformationMenu() {
        account.gotoaccountInformationMenu();
    }

    @And("I select search button on account information page")
    public void iSelectSearchButtonOnAccountInformationPage() {
      account.selectSearchbuttonOnAccountInformationPage();
    }

    @Then("I verify the existence of search bar")
    public void iVerifyTheExistenceOfSearchBar() {
        Assert.assertTrue(account.verifyTheSearchField(),"Not successfully navigated to the search field!");
    }
}
