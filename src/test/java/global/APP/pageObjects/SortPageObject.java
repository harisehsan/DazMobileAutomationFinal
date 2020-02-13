package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 30-August-2019
 */

public class SortPageObject {

    @AndroidFindBy (id = "com.daraz.android:id/sort_text") public WebElement sort_drpDown;
    @AndroidFindBy (id = "com.daraz.android:id/sortbar_item_text") public List <WebElement> filter_lstItem;
    @AndroidFindBy (id = "com.daraz.android:id/price_text_view") public List <WebElement> product_Price_lbl;
    @AndroidFindBy (id = "com.daraz.android:id/product_name_text_view") public List <WebElement> product_Name_lbl;
    @AndroidFindBy (id = "com.daraz.android:id/product_image_view") public List <WebElement> product_img;
    @AndroidFindBy (id = "com.daraz.android:id/libsf_tab_text") public List <WebElement> search_tab;
    @AndroidFindBy (id = "com.daraz.android:id/filter_image") public WebElement filter_btn;
    @AndroidFindBy (id = "com.daraz.android:id/done_button") public WebElement done_btn;
    @AndroidFindBy (xpath = "//*[@text='All-Products']") public WebElement all_Products_btn;
    @AndroidFindBy (id = "com.daraz.android:id/liststyle_icon") public WebElement catalog_View_icon;

    @AndroidFindBy (id = "com.shop.android:id/sort_text") public WebElement sort_drpDown_MM;
    @AndroidFindBy (id = "com.shop.android:id/sortbar_item_text") public List <WebElement> filter_lstItem_MM;
    @AndroidFindBy (id = "com.shop.android:id/price_text_view") public List <WebElement> product_Price_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/product_name_text_view") public List <WebElement> product_Name_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/product_image_view") public List <WebElement> product_img_MM;
    @AndroidFindBy (id = "com.shop.android:id/libsf_tab_text") public List <WebElement> search_tab_MM;
    @AndroidFindBy (id = "com.shop.android:id/filter_image") public WebElement filter_btn_MM;
    @AndroidFindBy (id = "com.shop.android:id/done_button") public WebElement done_btn_MM;
    @AndroidFindBy (id = "com.shop.android:id/liststyle_icon") public WebElement catalog_View_icon_MM;


    public By sort_drpDown_By = By.id("com.daraz.android:id/sort_text");
    public By product_Name_lbl_By = By.id ("com.daraz.android:id/product_name_text_view");
    public By search_tab_By = By.id("com.daraz.android:id/libsf_tab_text");
    public By filter_btn_By = By.id("com.daraz.android:id/filter_image");
    public By done_btn_By = By.id("com.daraz.android:id/done_button");
    public By all_Products_btn_By = By.xpath("//*[@text='All-Products']");

    public By sort_drpDown_By_MM = By.id("com.shop.android:id/sort_text");
    public By product_Name_lbl_By_MM = By.id("com.shop.android:id/product_name_text_view");
    public By search_tab_By_MM = By.id("com.shop.android:id/libsf_tab_text");
    public By filter_btn_By_MM = By.id("com.shop.android:id/filter_image");
    public By done_btn_By_MM = By.id("com.shop.android:id/done_button");
}