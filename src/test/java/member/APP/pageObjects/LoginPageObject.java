package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.WeakHashMap;

public class LoginPageObject extends BuildIDPicker {

    @AndroidFindBy(id = "com.daraz.android:id/icon") public List<WebElement> tray_icon;
    @AndroidFindBy (id = "com.daraz.android:id/laz_msg_banner_ImageView") public List <WebElement> message_Login_btn;
    @AndroidFindBy(id = "com.daraz.android:id/txt_name") public WebElement loginID_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/tv_login_form_forgot_password") public WebElement forget_password_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/btn_laz_form_forget_password_submit") public List <WebElement> reset_Password_btn;
    @AndroidFindBy(id = "com.daraz.android:id/et_laz_form_input_field_edit") public WebElement login_Email_txt;
    @AndroidFindBy(id = "com.daraz.android:id/et_laz_form_password_field_edit") public WebElement login_Password_txt;
    @AndroidFindBy(id = "com.daraz.android:id/btn_login_form_account_login") public WebElement login_btn;
    @AndroidFindBy (id = "com.daraz.android:id/tv_laz_login_sign_up_now") public WebElement create_Account_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/et_laz_form_mobile_field_edit") public List <WebElement> register_page_txt;
    @AndroidFindBy (id  = "com.daraz.android:id/tv_agree") public WebElement facebook_Agree_btn;
    @AndroidFindBy(id = "com.daraz.android:id/btn_login_fresh_welcome_login") public List <WebElement> first_login_btn;
    @AndroidFindBy(id = "com.daraz.android:id/iv_facebook") public WebElement facebook_Login_btn;
    @AndroidFindBy(id = "com.daraz.android:id/tv_signin") public WebElement login_Email_btn;
    @AndroidFindBy(id = "com.daraz.android:id/tv_forget_pwd") public WebElement forget_password_New_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/btn_next") public WebElement final_Email_Login_btn;
    @AndroidFindBy(id = "com.daraz.android:id/et_input_text")  public List <WebElement> login_Email_Final_txt;

    @AndroidFindBy(id = "com.shop.android:id/icon") public List<WebElement> tray_icon_MM;
    @AndroidFindBy (id = "com.shop.android:id/laz_msg_banner_ImageView") public List <WebElement> message_Login_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/txt_name") public WebElement loginID_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/tv_login_form_forgot_password") public WebElement forget_password_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/btn_laz_form_forget_password_submit") public List <WebElement> reset_Password_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/et_laz_form_input_field_edit") public WebElement login_Email_txt_MM;
    @AndroidFindBy(id = "com.shop.android:id/et_laz_form_password_field_edit") public WebElement login_Password_txt_MM;
    @AndroidFindBy(id = "com.shop.android:id/btn_login_form_account_login") public WebElement login_btn_MM;
    @AndroidFindBy (id = "com.shop.android:id/tv_laz_login_sign_up_now") public WebElement create_Account_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/et_laz_form_mobile_field_edit") public List <WebElement> register_page_txt_MM;
    @AndroidFindBy(id = "com.shop.android:id/btn_login_fresh_welcome_login") public List <WebElement> first_login_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/iv_facebook") public WebElement facebook_Login_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/tv_signin") public WebElement login_Email_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/tv_forget_pwd") public WebElement forget_password_New_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/btn_next") public WebElement final_Email_Login_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/et_input_text")  public List <WebElement> login_Email_Final_txt_MM;
    @AndroidFindBy (id  = "com.shop.android:id/tv_agree") public WebElement facebook_Agree_btn_MM;

    public By tray_icon_By = By.id("com.daraz.android:id/icon");
    public By message_Login_btn_By = By.id("com.daraz.android:id/laz_msg_banner_ImageView");
    public By loginID_lbl_By = By.id("com.daraz.android:id/txt_name");
    public By forget_password_lbl_By = By.id("com.daraz.android:id/tv_login_form_forgot_password");
    public By login_btn_By = By.id("com.daraz.android:id/btn_login_form_account_login");
    public By register_page_txt_By  = By.id("com.daraz.android:id/et_laz_form_mobile_field_edit");
    public By facebook_Agree_btn_By = By.id("com.daraz.android:id/tv_agree");
    public By first_login_btn_By = By.id("com.daraz.android:id/btn_login_fresh_welcome_login");
    public By facebook_Login_btn_By = By.id("com.daraz.android:id/iv_facebook");
    public By login_Email_btn_By = By.id("com.daraz.android:id/tv_signin");
    public By forget_password_New_lbl_By = By.id("com.daraz.android:id/tv_forget_pwd");
    public By final_Email_Login_btn_By = By.id("com.daraz.android:id/btn_next");

    public By tray_icon_By_MM = By.id("com.shop.android:id/icon");
    public By message_Login_btn_By_MM = By.id("com.shop.android:id/laz_msg_banner_ImageView");
    public By loginID_lbl_By_MM = By.id("com.shop.android:id/txt_name");
    public By forget_password_lbl_By_MM = By.id("com.shop.android:id/tv_login_form_forgot_password");
    public By login_btn_By_MM = By.id("com.shop.android:id/btn_login_form_account_login");
    public By register_page_txt_By_MM  = By.id("com.shop.android:id/et_laz_form_mobile_field_edit");
    public By first_login_btn_By_MM = By.id("com.shop.android:id/btn_login_fresh_welcome_login");
    public By facebook_Login_btn_By_MM = By.id("com.shop.android:id/iv_facebook");
    public By facebook_Agree_btn_By_MM = By.id("com.shop.android:id/tv_agree");
    public By login_Email_btn_By_MM = By.id("com.shop.android:id/tv_signin");
    public By forget_password_New_lbl_By_MM = By.id("com.shop.android:id/tv_forget_pwd");
    public By final_Email_Login_btn_By_MM = By.id("com.shop.android:id/btn_next");
}

