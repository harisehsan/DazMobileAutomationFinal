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

    @Then("^I should see search results$")
    public void iShouldSearchResult() {
        Assert.assertTrue(searchProduct.verifySearchResult(),"Search product not found!");
    }

    @And("I Search a Product for {string}")
    public void iSearchAProductFor(String searchType) throws IOException {
        searchProduct.searchProduct(searchType,productsGetProperty.pkProducts(),productsGetProperty.bdProducts(),productsGetProperty.lkProducts(),productsGetProperty.npProducts(),productsGetProperty.mmProducts());
    }
}
