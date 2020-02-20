package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 17-October-2019
 */

public class CategoriesPageObject extends BuildIDPicker {

    @AndroidFindBy(id = "com.daraz.android"+dev+":id/laz_homepage_component_v2_title_textview") public List <WebElement> categories_lbl;
    @AndroidFindBy(id = "com.shop.android:id/laz_homepage_component_v2_title_textview") public List <WebElement> categories_lbl_MM;
    @AndroidFindBy (xpath = "//*[@text='SHOP MORE >' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Categories']]]") public List <WebElement> shop_More_for_Categories_btn;
    @AndroidFindBy (xpath = "//*[@text='Just for you']") public List <WebElement> just_For_you_title_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/srp_search_input_box") public WebElement search_box;
    @AndroidFindBy(id = "com.shop.android:id/srp_search_input_box") public WebElement search_box_MM;

    public By product_Name_By = By.id("com.daraz.android"+dev+":id/product_name_text_view");
    public By product_Name_By_MM = By.id("com.shop.android:id/product_name_text_view");
}