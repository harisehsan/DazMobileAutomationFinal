package global.APP.stepsDefinitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import member.APP.pages.SearchProduct;
import org.testng.Assert;


public class SearchProductSteps {
    Drivers driver = new Drivers();
    SearchProduct searchProduct = new SearchProduct(driver.getDriver());

    @And("^I Search for \"([^\"]*)\" Product$")
    public void iSearchForDSLRProduct(String productName) throws InterruptedException {
        searchProduct.searchProduct(productName);
    }

    @Then("^I should see search results$")
    public void iShouldSearchResult() {
        Assert.assertTrue(searchProduct.verifySearchProduct(),"Search product not found!");
    }

}
