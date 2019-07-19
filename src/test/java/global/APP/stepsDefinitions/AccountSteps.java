package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.getProperty.OrderGetProperty;
import global.APP.pages.Order;
import global.Drivers;
import member.APP.getProperty.AccountGetProperty;
import member.APP.pages.Account;
import org.testng.Assert;

import java.io.IOException;

public class AccountSteps {
    Drivers drivers = new Drivers();
    Account account =  new Account(drivers.getDriver());
    AccountGetProperty accountGetProperty = new AccountGetProperty();
    OrderGetProperty orderGetProperty = new OrderGetProperty();
    Order order = new Order(drivers.getDriver());

    @Then("I verify that I have been logged in using google Account")
    public void iVerifyThatIHaveBeenLoggedInUsingGoogleAccount() throws IOException {
        Assert.assertEquals(accountGetProperty.userName(),account.verifySignin(),"Required User is not Logged In");
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
}
