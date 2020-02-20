package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-October-2019
 */

public class JustForYouPageObject extends BuildIDPicker {
    @AndroidFindBy(xpath = "//*[@text='Just For You']") public List<WebElement> just_For_You_title_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/discount") public List<WebElement> discount_lbl;
    @AndroidFindBy(id ="com.daraz.android"+dev+":id/product_title") public List<WebElement> product_Title_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/product_display_price") public List <WebElement> display_Price_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/product_original_price") public List <WebElement> original_Price_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/rating_bar") public List <WebElement> rating_bar;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_price") public WebElement display_Price_On_Pdp_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_origin_price") public WebElement original_Price_On_Pdp_lbl;
    @AndroidFindBy(id= "com.daraz.android"+dev+":id/tv_discount") public List <WebElement> discount_Pdp_lbl;
    @AndroidFindBy(id= "com.daraz.android"+dev+":id/rating_layout") public List <WebElement> rating_Pdp_bar;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/title") public WebElement product_Title_pdp;

    @AndroidFindBy(xpath = "//*[@text='Just For You']") public List<WebElement> just_For_You_title_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/discount") public List<WebElement> discount_lbl_MM;
    @AndroidFindBy(id ="com.shop.android:id/product_title") public List<WebElement> product_Title_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/product_display_price") public List <WebElement> display_Price_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/product_original_price") public List <WebElement> original_Price_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/rating_bar") public List <WebElement> rating_bar_MM;
    @AndroidFindBy(id = "com.shop.android:id/tv_price") public WebElement display_Price_On_Pdp_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/tv_origin_price") public WebElement original_Price_On_Pdp_lbl_MM;
    @AndroidFindBy(id= "com.shop.android:id/tv_discount") public List <WebElement> discount_Pdp_lbl_MM;
    @AndroidFindBy(id= "com.shop.android:id/rating_layout") public List <WebElement> rating_Pdp_bar_MM;
    @AndroidFindBy(id = "com.shop.android:id/title") public WebElement product_Title_pdp_MM;
}
