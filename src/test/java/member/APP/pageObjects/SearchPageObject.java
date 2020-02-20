package member.APP.pageObjects;

import com.codeborne.selenide.impl.WebElementsCollection;
import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-April-2019
 */

public class SearchPageObject extends BuildIDPicker {
    @AndroidFindBy (id= "com.daraz.android"+dev+":id/laz_homepage_search_view") public List <WebElement> searchBeforeClick_txtfield;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_search_view") public List <WebElement> searchBeforeClick_txtfield_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/search_input_box") public WebElement searchAfterClick_txtfield;
    @AndroidFindBy (id = "com.shop.android:id/search_input_box") public WebElement searchAfterClick_txtfield_MM;
    @AndroidFindBy (id="com.daraz.android"+dev+":id/search_button") public WebElement search_btn;
    @AndroidFindBy (id="com.shop.android:id/search_button") public WebElement search_btn_MM;
    @AndroidFindBy (id="com.daraz.android"+dev+":id/product_name_text_view") public List <WebElement> searchResult_lbl;
    @AndroidFindBy (id="com.shop.android:id/product_name_text_view") public List <WebElement> searchResult_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/srp_search_input_box") public WebElement searchBox_Final_txtfield;
    @AndroidFindBy (id = "com.shop.android:id/srp_search_input_box") public WebElement searchBox_Final_txtfield_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/item_title_text") public List <WebElement> search_Suggestion_lstItem;
    @AndroidFindBy (id = "com.shop.android:id/item_title_text") public List <WebElement> search_Suggestion_lstItem_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/text") public List <WebElement> did_You_Mean_lbl;
    @AndroidFindBy (id = "com.shop.android:id/text") public List <WebElement> did_You_Mean_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/got_it") public List <WebElement> ok_Got_It_btn;
    @AndroidFindBy(id = "com.shop.android:id/got_it") public List <WebElement> ok_Got_It_btn_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/iv_search")  public WebElement search_In_Categories_btn;
    @AndroidFindBy(id = "com.shop.android:id/iv_search")  public WebElement search_In_Categories_btn_MM;
    @AndroidFindBy(xpath = "//*[@text='All Products']") public WebElement all_Product_tab;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/search_text") public WebElement search_tab;
    @AndroidFindBy(id="com.shop.android:id/search_text") public WebElement search_tab_MM;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/got_it_btn") public List <WebElement> got_It_Store_btn;
    @AndroidFindBy(id="com.shop.android:id/got_it_btn") public List <WebElement> got_It_Store_btn_MM;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/clean_image_view") public WebElement delete_Search_History_icon;
    @AndroidFindBy(id="com.shop.android:id/clean_image_view") public WebElement delete_Search_History_icon_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/try_again_empty_srp") public List <WebElement> different_Keyword_btn;
    @AndroidFindBy(id = "com.shop.android:id/try_again_empty_srp") public List <WebElement> different_Keyword_btn_MM;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/srp_search_input_box") public List <WebElement> searchBar_Third_txtBox;
    @AndroidFindBy(id="com.shop.android:id/srp_search_input_box") public List <WebElement> searchBar_Third_txtBox_MM;


    public By searchResult_lbl_By = By.id("com.daraz.android"+dev+":id/product_name_text_view");
    public By searchResult_lbl_By_MM = By.id("com.shop.android:id/product_name_text_view");
    public By searchBeforeClick_txtfield_By = By.id("com.daraz.android"+dev+":id/laz_homepage_search_view");
    public By searchBeforeClick_txtfield_By_MM = By.id("com.shop.android:id/laz_homepage_search_view");
    public By searchAfterClick_txtfield_By = By.id("com.daraz.android"+dev+":id/search_input_box");
    public By searchAfterClick_txtfield_By_MM = By.id("com.shop.android:id/search_input_box");
    public By searchBox_Final_txtfield_By = By.id("com.daraz.android"+dev+":id/srp_search_input_box");
    public By searchBox_Final_txtfield_By_MM = By.id("com.shop.android:id/srp_search_input_box");
    public By delete_Search_History_icon_By = By.id("com.daraz.android"+dev+":id/clean_image_view");
    public By delete_Search_History_icon_By_MM = By.id("com.shop.android:id/clean_image_view");



}