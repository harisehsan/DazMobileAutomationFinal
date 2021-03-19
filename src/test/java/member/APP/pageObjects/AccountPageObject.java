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

    @AndroidFindBy(xpath = "//*[contains(@text,'History')]")
    public WebElement review_history_ele;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'txt_down') and contains(@text,'To Review')]")
    public WebElement to_review_ele;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'txt_down') and contains(@text,'My Review')]")
    public WebElement my_review_ele;
    @AndroidFindBy(id = "com.daraz.android" + dev + ":id/img_up")
    public List<WebElement> my_Account_widget;
    @AndroidFindBy(id = "com.shop.android:id/img_up")
    public List<WebElement> my_Account_widget_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='More options']"), @AndroidBy(xpath = "//*[@content-desc='More options']")})
    public WebElement more_Options_click;
    @AndroidFindBy(id = "com.daraz.android:id/tv_wallet_topup")
    public WebElement wallet_Activate_Now_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_wallet_topup")
    public WebElement wallet_Activate_Now_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_wallet_action")
    public WebElement wallet_New_Activate_Now_lbl;
    @AndroidFindBy(id = "ccom.shop.android:id/tv_wallet_action")
    public WebElement wallet_New_Activate_Now_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/quantity")
    public List<WebElement> red_Dot_lbl;
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
    @AndroidFindBy(xpath = "//*[@text='Cart']")
    public WebElement account_Cart_lbl;
    @AndroidFindBy(xpath = "//*[@text='Account Information']")
    public WebElement account_Information_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/iv_cart")
    public WebElement cart_icon;
    @AndroidFindBy(id = "com.shop.android:id/iv_cart")
    public WebElement cart_icon_MM;
    @AndroidFindBy(id = "com.daraz.android:id/iv_search")
    public WebElement serach_icon;
    @AndroidFindBy(id = "com.shop.android:id/iv_search")
    public WebElement serach_icon_MM;
    @AndroidFindBy(id = "com.daraz.android:id/search_input_box")
    public List<WebElement> search_Bar_txtbox;
    @AndroidFindBy(id = "com.shop.android:id/search_input_box")
    public List<WebElement> search_Bar_txtbox_MM;
    @AndroidFindBy(id = "com.daraz.android:id/checkbox")
    public List<WebElement> message_Settings_chkBox;
    @AndroidFindBy(id = "com.shop.android:id/checkbox")
    public List<WebElement> message_Settings_chkBox_MM;
    @AndroidFindAll({@AndroidBy(id = "com.daraz.android:id/tv_setting"),
            @AndroidBy(id = "com.shop.android:id/tv_setting")})
    public WebElement message_Settings_Gear;


    @AndroidFindBy(xpath = "//*[@resource-id='com.daraz.android:id/title' and @text='Home']")
    public WebElement hamburger_Menu_Home;
    @AndroidFindBy(id = "com.daraz.android:id/setting_account_information_container")
    public List<WebElement> account_Information_tab;
    @AndroidFindBy(id = "com.shop.android:id/setting_account_information_container")
    public List<WebElement> account_Information_tab_MM;
    @AndroidFindBy(id = "com.daraz.android:id/orders_title")
    public WebElement account_Order_Title;
    @AndroidFindBy(id = "com.shop.android:id/orders_title")
    public WebElement account_Order_Title_MM;

    public By message_Settings_Gear_By = By.xpath("//*[contains(@resource-id,'tv_setting')]");
    public By to_review_By = By.xpath("//*[contains(@resource-id,'txt_down') and contains(@text,'To Review')]");
    public By My_review_By = By.xpath("//*[contains(@resource-id,'txt_down') and contains(@text,'My Review')]");
    public By my_Account_widget_By = By.id("com.daraz.android" + dev + ":id/img_up");
    public By my_Account_widget_By_MM = By.id("com.shop.android:id/img_up");
    public By red_Dot_lbl_By = By.id("com.daraz.android:id/quantity");
    public By red_Dot_lbl_MM_By = By.id("com.daraz.android:id/quantity");
    public By down_lbl = By.id("com.daraz.android:id/txt_down");
    public By down_lbl_MM = By.id("com.shop.android:id/txt_down");
    public By track_Package_lbl_By = By.id("com.daraz.android:id/txt_logistic");
    public By track_Package_lbl_By_MM = By.id("com.shop.android:id/txt_logistic");
    public By account_Information = By.id("com.daraz.android:id/setting_account_information_container");
    public By account_Information_title = By.xpath("//*[contains(@text,'Account Information')]");
    public By account_Change_Pwd_By = By.xpath("//*[contains(@content-desc,'Change Password')]");
    public By help_Page_Text_By = By.xpath(("//*[contains(@text,'Search for question')]"));
    public By hamburger_Menu_Home_by = By.xpath("//*[@resource-id='com.daraz.android:id/title' and @text='Home']");
    public By account_Cart_lbl_By = By.xpath("//*[@text='Cart']");
    public By account_Information_lbl_By = By.xpath("//*[@text='Account Information']");


    public By myReview_By = By.xpath("//*[@text='My Reviews' and @class='android.widget.TextView']");
}
