package global.APP.stepsDefinitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import member.APP.getProperty.ProductsGetProperty;
import member.APP.pages.SearchProduct;
import org.testng.Assert;
import java.io.IOException;


public class SearchProductSteps {
    Drivers driver = new Drivers();
    SearchProduct searchProduct = new SearchProduct(driver.getDriver());
    ProductsGetProperty productsGetProperty = new ProductsGetProperty();
    String searchKeyword;
    String searchSuggestionKeyword;

    @Then("^I should see search results$")
    public void iShouldSearchResult() {
        Assert.assertTrue(searchProduct.verifySearchResult(),"Search product not found!");
    }

    @And("I search a Product using SKU for {string}")
    public void iSearchAProductFor(String searchType) throws IOException {
        searchProduct.searchProduct(searchType,productsGetProperty.pkProducts(),productsGetProperty.bdProducts(),productsGetProperty.lkProducts(),productsGetProperty.npProducts(),productsGetProperty.mmProducts());
    }

    @And("I search for {string}")
    public void iSearchFor(String searchKeyword) {
        this.searchKeyword = searchProduct.searchProductByName(searchKeyword);
    }

    @Then("I should see search products")
    public void iShouldSeeSearchProducts() {
      Assert.assertTrue(searchProduct.verifyTheSearchProduct(this.searchKeyword),"The search result(s) is/are not shown!");
    }

    @And("I navigate back to the main screen")
    public void iNavigateBackToTheMainScreen() {
       searchProduct.navigateBackToTheHomeScreen();
    }

    @And("I search a product using search history")
    public void iSearchAProductUsingSearchHistory() {
        searchProduct.searchUsingHistory(searchKeyword);
    }

    @And("I use {string} keyword to verify the search suggestion results")
    public void iSearchForAsASearchSuggestionKeyword(String searchSuggestionKeyword) {
        this.searchSuggestionKeyword = searchSuggestionKeyword;
     Assert.assertTrue(searchProduct.searchForSuggestionKeyword(searchSuggestionKeyword));
    }

    @And("I select a suggestion result for search")
    public void iSearchAProduct() {
        searchProduct.selectSuggestionResult();
    }

    @Then("I should see the search suggestion keyword in the product name")
    public void iShouldSeeTheSerachSuggestionKeywordInTheProductName() {
     Assert.assertTrue(searchProduct.checkForSuggestionKeywordInProduct(this.searchSuggestionKeyword),"The search result(s) is/are not shown!");
    }

    @Then("I look for the did you mean option")
    public void iLookForTheDidYouMeanOption() throws InterruptedException {
        Assert.assertTrue(searchProduct.clickOnDidYouMeanOption(), "Did you mean option is not available for this search keyword!");
    }
}
