package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Categories;
import global.Drivers;
import org.testng.Assert;

import java.io.IOException;

public class CategoriesSteps {
    Drivers driver = new Drivers();
    Categories categories = new Categories(driver.getDriver());

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