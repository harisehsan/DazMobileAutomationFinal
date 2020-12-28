package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PrivateZoneObject {

    @AndroidFindBy(xpath = "//*[@resource-id='com.daraz.android:id/shop_name']") public List <WebElement> shop_Name_lbl;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daraz.android:id/shop_logo']") public List <WebElement> shop_Logo_img;

    @AndroidFindBy(xpath = "//*[@resource-id='com.daraz.android:id/title' and contains(@text,'Share This Store')]") public List <WebElement> share_This_Store_btn;

    @AndroidFindBy(xpath = "//*[@resource-id='com.shop.android:id/shop_name']") public List <WebElement> shop_Name_lbl_MM;
    @AndroidFindBy(xpath = "//*[@resource-id='com.shop.android:id/shop_logo']") public List <WebElement> shop_Logo_img_MM;

    @AndroidFindBy(xpath = "//*[@resource-id='com.shop.android:id/title' and contains(@text,'Share This Store')]") public List <WebElement> share_This_Store_btn_MM;

    @AndroidFindBy(xpath ="//*[@resource-id='com.daraz.android:id/text' and contains(@text,'Categories')]") public WebElement categories_tab;

    @AndroidFindBy(xpath ="//*[@resource-id='com.shop.android:id/text' and contains(@text,'Categories')]") public WebElement categories_tab_MM;

    @AndroidFindBy(xpath ="//*[@resource-id='com.daraz.android:id/text' and contains(@text,'Profile')]") public WebElement profile_tab;

    @AndroidFindBy(xpath ="//*[@resource-id='com.shop.android:id/text' and contains(@text,'Profile')]") public WebElement profile_tab_MM;

    @AndroidFindBy(xpath ="//*[@resource-id='com.daraz.android:id/got_it_btn' and contains(@text,'GOT IT')]") public List <WebElement> got_It_btn;

    @AndroidFindBy(xpath ="//*[@resource-id='com.shop.android:id/got_it_btn' and contains(@text,'GOT IT')]") public List <WebElement> got_It_btn_MM;

    @AndroidFindBy (xpath = "//*[@resource-id='com.daraz.android:id/all_product' and contains(@text,'All Products')]") public List <WebElement> all_Products_lbl;

    @AndroidFindBy (xpath = "//*[@resource-id='com.shop.android:id/all_product' and contains(@text,'All Products')]") public List <WebElement> all_Products_lbl_MM;

    @AndroidFindBy (xpath = "//*[@resource-id='com.daraz.android:id/tips_operator' and contains(@text,'Got it')]") public List <WebElement> got_It_Success_btn;

    @AndroidFindBy (xpath = "//*[@resource-id='com.shop.android:id/tips_operator' and contains(@text,'Got it')]") public List <WebElement> got_It_Success_btn_MM;

    @AndroidFindBy (xpath = "//*[@resource-id='com.daraz.android:id/laz_shop_follow_btn' and contains(@text,'Following')]") public WebElement following_btn;

    @AndroidFindBy (xpath = "//*[@resource-id='com.shop.android:id/laz_shop_follow_btn' and contains(@text,'Following')]") public WebElement following_btn_MM;

    @AndroidFindBy (xpath = "//*[@resource-id='android:id/button1' and contains(@text,'UNFOLLOW')]") public WebElement unfollow_btn;

    @AndroidFindBy (xpath = "//*[@resource-id='android:id/button1' and contains(@text,'UNFOLLOW')]") public WebElement unfollow_btn_MM;

    @AndroidFindBy (xpath = "//*[@resource-id='com.daraz.android:id/laz_shop_follow_btn' and contains(@text,'Follow')]") public List <WebElement> follow_btn;

    @AndroidFindBy (xpath = "//*[@resource-id='com.shop.android:id/laz_shop_follow_btn' and contains(@text,'Follow')]") public List <WebElement> follow_btn_MM;

    public By store_Name_lbl_by = By.xpath("//*[@resource-id='com.daraz.android:id/shop_name']");
    public By store_Name_lbl_by_MM = By.xpath("//*[@resource-id='com.shop.android:id/shop_name']");

        }
