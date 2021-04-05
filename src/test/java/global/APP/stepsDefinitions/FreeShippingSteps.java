package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import member.APP.pages.FreeShipping;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FreeShippingSteps {

    Drivers driver = new Drivers();
    FreeShipping freeShipping = new FreeShipping((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @Then("I verify the enjoy free shipping text")
    public void iVerifyTheEnjoyFreeShippingText() {
       Assert.assertTrue(freeShipping.verifyTheFreeShippingText(),"The Free Shipping message is not displayed!");
    }


    @Then("I verify the components of free shipping in cart")
    public void iVerifyTheComponentsOfFreeShippingInCart() {
        Assert.assertTrue(freeShipping.verifyTheContentOfTheFreeShippingOnCart(),"The content of free shipping is not properly displayed!");
    }

    @Then("I compare the product price of product with the total price")
    public void iCompareTheProductPriceOfProductWithTheTotalPriceIn() {
        Assert.assertTrue(freeShipping.compareTheProductPriceWithTotalPrice(), "The Product price and total price are not same!");
    }

    @Then("I look for the shipping fee discount")
    public void iLookForTheShippingFeeDiscount() {
       Assert.assertTrue(freeShipping.verifyTheShippingFeeDiscount(),"The Free shipping discount is not dislplayed on checkout!");
    }

    @Then("I should not see the the free shipping option")
    public void iShouldNotSeeTheTheFreeShippingOption() {
       Assert.assertFalse(freeShipping.verifyTheContentOfTheFreeShippingOnCart(),"The free shipping is still displayed even it should not!");
    }

    @And("I add the products in cart to meet the amount requirement for free-shipping")
    public void iAddTheProductsInCartToMeetTheAmountRequirementForFreeShipping() {
        freeShipping.addTheProductsTillFreeShippingIsDisplayed();
    }
}
