package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SearchPageObject {
    @AndroidFindBy (id= "com.daraz.android:id/laz_homepage_search_view") public WebElement searchBeforeClick_txtfield;
    @AndroidFindBy (id = "com.daraz.android:id/search_input_box") public WebElement searchAfterClick_txtfield;
    @AndroidFindBy (id="com.daraz.android:id/search_button") public WebElement search_btn;
    @AndroidFindBy (id="com.daraz.android:id/product_name_text_view") public List <WebElement> searchResult_lbl;


    public By searchResult_lbl_By = By.id("com.daraz.android:id/product_name_text_view");
    public By searchBeforeClick_txtfield_By = By.id("com.daraz.android:id/laz_homepage_search_view");
    public By searchAfterClick_txtfield_By = By.id("com.daraz.android:id/search_input_box");
}
