package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-April-2019
 */

public class SearchPageObject {
    @AndroidFindBy (id= "com.daraz.android:id/laz_homepage_search_view") public List <WebElement> searchBeforeClick_txtfield;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_search_view") public List <WebElement> searchBeforeClick_txtfield_MM;
    @AndroidFindBy (id = "com.daraz.android:id/search_input_box") public WebElement searchAfterClick_txtfield;
    @AndroidFindBy (id = "com.shop.android:id/search_input_box") public WebElement searchAfterClick_txtfield_MM;
    @AndroidFindBy (id="com.daraz.android:id/search_button") public WebElement search_btn;
    @AndroidFindBy (id="com.shop.android:id/search_button") public WebElement search_btn_MM;
    @AndroidFindBy (id="com.daraz.android:id/product_name_text_view") public List <WebElement> searchResult_lbl;
    @AndroidFindBy (id="com.shop.android:id/product_name_text_view") public List <WebElement> searchResult_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android:id/srp_search_input_box") public WebElement searchBox_Final_txtfield;
    @AndroidFindBy (id = "com.shop.android:id/srp_search_input_box") public WebElement searchBox_Final_txtfield_MM;
    @AndroidFindBy (id = "com.daraz.android:id/item_title_text") public List <WebElement> search_Suggestion_lstItem;
    @AndroidFindBy (id = "com.shop.android:id/item_title_text") public List <WebElement> search_Suggestion_lstItem_MM;
    @AndroidFindBy (id = "com.daraz.android:id/text") public List <WebElement> did_You_Mean_lbl;
    @AndroidFindBy (id = "com.shop.android:id/text") public List <WebElement> did_You_Mean_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/got_it") public List <WebElement> ok_Got_It_btn;
    @AndroidFindBy(id = "com.shop.android:id/got_it") public List <WebElement> ok_Got_It_btn_MM;


    public By searchResult_lbl_By = By.id("com.daraz.android:id/product_name_text_view");
    public By searchResult_lbl_By_MM = By.id("com.shop.android:id/product_name_text_view");
    public By searchBeforeClick_txtfield_By = By.id("com.daraz.android:id/laz_homepage_search_view");
    public By searchBeforeClick_txtfield_By_MM = By.id("com.shop.android:id/laz_homepage_search_view");
    public By searchAfterClick_txtfield_By = By.id("com.daraz.android:id/search_input_box");
    public By searchAfterClick_txtfield_By_MM = By.id("com.shop.android:id/search_input_box");
    public By searchBox_Final_txtfield_By = By.id("com.daraz.android:id/srp_search_input_box");
    public By searchBox_Final_txtfield_By_MM = By.id("com.shop.android:id/srp_search_input_box");
}