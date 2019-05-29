package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignUpObjects {
    @AndroidFindBy(id="com.daraz.android:id/title") public List<WebElement> account_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/txt_login_signup") public WebElement signup_And_Login_btn;
    @AndroidFindBy(id="com.daraz.android:id/btn_login_fresh_welcome_sign_up") public WebElement signup_btn;
    @AndroidFindBy (id="com.daraz.android:id/img_settings") public WebElement settings_icon;
    @AndroidFindBy (xpath="//*[@text='Logout']") public WebElement logout_btn;
    @AndroidFindBy (id="android:id/button1") public WebElement final_Logout_btn;

    @AndroidFindBy(id="com.shop.android:id/title") public List<WebElement> account_lbl_MM;
    @AndroidFindBy(id = "com.shop.android:id/txt_login_signup") public WebElement signup_And_Login_btn_MM;
    @AndroidFindBy(id="com.shop.android:id/btn_login_fresh_welcome_sign_up") public WebElement signup_btn_MM;
    @AndroidFindBy (id="com.shop.android:id/img_settings") public WebElement settings_icon_MM;


    public By account_lbl_By = By.id("com.daraz.android:id/title");
    public By signup_And_Login_btn_By = By.id("com.daraz.android:id/txt_login_signup");
    public By signup_btn_By = By.id("com.daraz.android:id/btn_login_fresh_welcome_sign_up");
    public By settings_icon_By = By.id("com.daraz.android:id/img_settings");
    public By logout_btn_By = By.xpath("//*[@text='Logout']");
    public By final_Logout_btn_By = By.id("android:id/button1");

    public By account_lbl_By_MM = By.id("com.shop.android:id/title");
    public By signup_And_Login_btn_By_MM = By.id("com.shop.android:id/txt_login_signup");
    public By signup_btn_By_MM = By.id("com.shop.android:id/btn_login_fresh_welcome_sign_up");
    public By settings_icon_By_MM = By.id("com.shop.android:id/img_settings");
}