package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Categories;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class CategoriesSteps {
    Categories categories = new Categories((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @And("I scroll down to categories section on homepage")
    public void iScrollDownToCategoriesSectionOnHomepage() {
        categories.scrollDownToCategoriesSection();
    }

    @And("I select shop more for categories")
    public void iSelectShopMoreForCategories() {
     categories.clickOnShopMoreButton();
    }

    @And("I should be on the categories page")
    public void iShouldBeOnTheCategoriesPage() {
        Assert.assertTrue(categories.checkTheExistenceOfJustForYou(),"Categories Page is not working or showing properly!");
    }

    @Then("I switch between the categories tabs")
    public void iSwitchTheTabsBetweenTheCategoriesTabs() throws IOException {
       Assert.assertTrue(categories.switchBetweenCategoryTabs(),"Categories tabs are not working or showing properly!");
    }

    @Then("I switch between the goods tab")
    public void iSwitchBetweenTheGoodsTab() throws IOException {
      Assert.assertTrue(categories.switchBetweenGoodsTab(),"Goods tabs are not working or showing properly!");
    }
}