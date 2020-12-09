package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-July-2019
 */

public class AccountPageObject extends BuildIDPicker {

    @AndroidFindBy(id = "com.daraz.android" + dev + ":id/img_up")
    public List<WebElement> my_Account_widget;
    @AndroidFindBy(id = "com.shop.android:id/img_up")
    public List<WebElement> my_Account_widget_MM;
    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView' and @contentDescription='More options']")
    public WebElement more_Options_click;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daraz.android:id/title' and @text='Home']")
    public WebElement hamburger_Menu_Home;
    @AndroidFindBy(id = "com.daraz.android:id/tv_wallet_topup")
    public WebElement wallet_Activate_Now_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_wallet_topup")
    public WebElement wallet_Activate_Now_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_wallet_action")
    public WebElement wallet_New_Activate_Now_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_wallet_action")
    public WebElement wallet_New_Activate_Now_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/quantity")
    public List<WebElement> red_Dot_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/setting_account_information_container")
    public List<WebElement> account_Information_tab;
    @AndroidFindBy(id = "com.shop.android:id/setting_account_information_container")
    public List<WebElement> account_Information_tab_MM;
    @AndroidFindBy(id = "com.shop.android:id/quantity")
    public List<WebElement> red_Dot_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/bglayout")
    public List<WebElement> Account_widget;
    @AndroidFindBy(id = "com.shop.android:id/bglayout")
    public List<WebElement> Account_widget_MM;
    @AndroidFindBy(id = "com.daraz.android:id/img_head")
    public WebElement avatar_img;
    @AndroidFindBy(id = "com.shop.android:id/img_head")
    public WebElement avatar_img_MM;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='logisitc_banner' and @class='android.widget.FrameLayout']]/*[@class='android.widget.ImageView'])")
    public List<WebElement> track_Package_Slider;
    @AndroidFindBy(xpath = "//*[@text='Track Package']")
    public List<WebElement> track_Package_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/txt_shipto")
    public WebElement package_Status_lnk;
    @AndroidFindBy(id = "com.shop.android:id/txt_shipto")
    public WebElement package_Status_lnk_MM;
    @AndroidFindBy(id = "com.daraz.android:id/txt_time")
    public WebElement package_Date_And_Time_lbl;
    @AndroidFindBy(id = "com.shop.android:id/txt_time")
    public WebElement package_Date_And_Time_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/orders_title")
    public WebElement account_Order_Title;
    @AndroidFindBy(id = "com.shop.android:id/orders_title")
    public WebElement account_Order_Title_MM;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daraz.android:id/title' and contains(text(), 'Need Help')]")
    public WebElement TestingHELPELEMENT;

    public By my_Account_widget_By = By.id("com.daraz.android" + dev + ":id/img_up");
    public By my_Account_widget_By_MM = By.id("com.shop.android:id/img_up");
    public By red_Dot_lbl_By = By.id("com.daraz.android:id/quantity");
    public By red_Dot_lbl_MM_By = By.id("com.daraz.android:id/quantity");
    public By down_lbl = By.id("com.daraz.android:id/txt_down");
    public By down_lbl_MM = By.id("com.shop.android:id/txt_down");
    public By track_Package_lbl_By = By.id("com.daraz.android:id/txt_logistic");
    public By track_Package_lbl_By_MM = By.id("com.shop.android:id/txt_logistic");
    public By account_Information = By.id("com.daraz.android:id/setting_account_information_container");
    public By account_Information_title = By.xpath("//*[@class='android.widget.TextView' and @text='Account Information']");
    public By help_Page_Text_By = By.xpath("(//*[@text and @class='android.view.View' and contains(text(), 'Hi, how can we help?')])");
    public By help_Page_Text_By_MM = By.xpath("(//*[@text and @class='android.view.View' and contains(text(), 'Hi, how can we help?')])");
    public By hamburger_Menu_Home_by = By.xpath("//*[@resource-id='com.daraz.android:id/title' and @text='Home']");
}
