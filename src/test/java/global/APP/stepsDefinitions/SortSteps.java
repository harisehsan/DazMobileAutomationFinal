package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.Sort;
import global.Drivers;
import member.APP.pages.SearchProduct;
import org.testng.Assert;

public class SortSteps {
    Drivers driver = new Drivers();
    Sort sort = new Sort(driver.getDriver());
    SearchProduct searchProduct = new SearchProduct(driver.getDriver());

    String filterKeyword;

    @And("I apply for the sort filter {string}")
    public void iApplyForTheSortFilter(String sortType) {
        sort.sortCatalog(sortType);
    }

    @Then("I verify that product catalog is sorted according to the {string}")
    public void iVerifyThatProductCatalogIsSortedAccordingToThe(String sortType) {
       Assert.assertTrue(sort.verifyTheSortedCatalog(sortType),"Catalog is not properly sorted!");
    }

    @And("I goto the Daraz Mall")
    public void iGotoTheDarazMall() {
        sort.goToDarazMall();
    }

    @And("I select filter")
    public void iSelectFilter() {
      sort.selectFilter();
    }

    @And("I apply filter for {string} Brand")
    public void iApplyFilterForBrand(String filterKeyword) {
       this.filterKeyword = sort.applyBrandFilter(filterKeyword);
    }

    @Then("I verify for the applied brand filter")
    public void iVerifyForTheAppliedFilter() {
      Assert.assertTrue(searchProduct.verifyTheSearchProduct(filterKeyword));
    }

    @And("I select all-products in the search hint option")
    public void iSelectAllProductsInTheSearchHintOption() {
        sort.selectAllProductInSearchHint();
    }

    @And("I change the catalog view to {string}")
    public void iChangeTheCatalogViewTo(String sortMode) {
        sort.applyListViewOnCatalog(sortMode);
    }

    @Then("I verify that product catalog is sorted according to the {string} on store page")
    public void iVerifyThatProductCatalogIsSortedAccordingToTheOnStorePage(String sortType) {
        Assert.assertTrue(sort.verifyTheSortedCatalogOnStore(sortType),"catalog is not properly sorted on store page!");

    }
}