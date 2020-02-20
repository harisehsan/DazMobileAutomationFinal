package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 12-September-2019
 */

public class FlashSalePageObject extends BuildIDPicker {
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_hp_flash_sale_v2_logo_imageview") public List <WebElement> flash_Sale_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/timer_hours") public List <WebElement> flash_Sale_Hour_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/timer_minutes") public List <WebElement> flash_Sale_minutes_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/timer_seconds") public List <WebElement> flash_Sale_seconds_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_homepage_flash_sale_v2_shopmore_textview") public WebElement flash_Shop_More_link;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='BUY NOW']"),@AndroidBy(xpath = "//*[@content-desc='BUY NOW']")}) public WebElement buy_Now_btn;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/description") public WebElement items_Sold_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/tv_discount") public WebElement discount_Percentage_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/tv_price") public WebElement discount_Price_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/got_it") public List <WebElement> chat_Ok_btn;

    @AndroidFindBy (id = "com.shop.android:id/laz_hp_flash_sale_v2_logo_imageview") public List <WebElement> flash_Sale_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/timer_hours") public List <WebElement> flash_Sale_Hour_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/timer_minutes") public List <WebElement> flash_Sale_minutes_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/timer_seconds") public List <WebElement> flash_Sale_seconds_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_flash_sale_v2_shopmore_textview") public WebElement flash_Shop_More_link_MM;
    @AndroidFindBy (id = "com.shop.android:id/description") public WebElement items_Sold_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/tv_discount") public WebElement discount_Percentage_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/tv_price") public WebElement discount_Price_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/got_it") public List <WebElement> chat_Ok_btn_MM;
    @AndroidFindBy (xpath = "//*[@text='BUY NOW']") public WebElement buy_Now_btn_MM;


    public By flash_Sale_lbl_By = By.id("com.daraz.android"+dev+":id/laz_hp_flash_sale_v2_logo_imageview");

    public By flash_Sale_lbl_By_MM = By.id("com.shop.android:id/laz_hp_flash_sale_v2_logo_imageview");

}
