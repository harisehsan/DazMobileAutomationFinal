package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends Base {
    SearchPageObject searchPageObj = new SearchPageObject();
    private String productName;

    public SearchProduct(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
    }

    public void searchProduct(String productName) {
        this.productName = productName;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By);
            searchPageObj.searchBeforeClick_txtfield.click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            searchPageObj.searchAfterClick_txtfield.sendKeys(productName);
            searchPageObj.search_btn.click();
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
            searchPageObj.searchBeforeClick_txtfield_MM.click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            searchPageObj.searchAfterClick_txtfield_MM.sendKeys(productName);
            searchPageObj.search_btn_MM.click();
        }
    }

    public boolean verifySearchResult() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            return searchPageObj.searchResult_lbl.get(0).getText().contains(productName);
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            return searchPageObj.searchResult_lbl_MM.get(0).getText().contains(productName);
        }
    }
}