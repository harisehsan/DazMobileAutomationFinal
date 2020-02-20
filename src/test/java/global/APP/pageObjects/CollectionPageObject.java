package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 24-September-2019
 */

public class CollectionPageObject extends BuildIDPicker {

    @AndroidFindBy(id= "com.daraz.android"+dev+":id/laz_homepage_component_v2_title_textview") public List<WebElement> collection_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/laz_homepage_component_v2_shopmore_textview") public List <WebElement> shop_More_btn;
    @AndroidFindBy(id = "com.shop.android:id/laz_homepage_component_v2_title_textview") public List <WebElement> collection_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_component_v2_title_textview") public List <WebElement> collection_lbl_Local_MM;
    @AndroidFindBy(id = "com.shop.android:id/laz_homepage_component_v2_shopmore_textview") public List <WebElement> shop_More_btn_MM;
    @AndroidFindBy(xpath = "//*[@text='Collections']") public List <WebElement> collection_header_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/change_language_title") public List <WebElement> change_Language_lbl;
    @AndroidFindBy(id = "com.shop.android:id/change_language_title") public List <WebElement> change_Language_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/item_checkbox") public List <WebElement> language_Options_chkbox;
    @AndroidFindBy(id = "com.shop.android:id/item_checkbox") public List <WebElement> language_Options_chkbox_MM;
    @AndroidFindBy(id = "android:id/button1") public WebElement apply_btn;

    public By language_Options_chkbox_By = By.id("com.daraz.android"+dev+":id/item_checkbox");
    public By  language_Options_rdobtn_By_MM = By.id("com.shop.android:id/item_checkbox");
}