package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignUpObjects {
    @AndroidFindBy(id ="com.daraz.android:id/tab_layout") public List <WebElement> account_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/txt_login_signup") public List <WebElement> signup_And_Login_btn;
    @AndroidFindBy(id="com.daraz.android:id/btn_login_fresh_welcome_sign_up") public WebElement signup_btn;
    @AndroidFindBy (id="com.daraz.android:id/tv_settings") public WebElement settings_icon;
    @AndroidFindBy (xpath="//*[@text='Logout']") public WebElement logout_btn;
    @AndroidFindAll({@AndroidBy(id = "android:id/button1"), @AndroidBy(xpath = "//*[@text='Logout']")}) public List <WebElement> final_Logout_btn;
    @AndroidFindBy(id="com.shop.android:id/tab_layout") public List<WebElement> account_lbl_MM;
    @AndroidFindAll({@AndroidBy(id = "com.shop.android:id/txt_login_signup"), @AndroidBy(xpath = "//*[@text='Login / Sign up']")}) public List <WebElement> signup_And_Login_btn_MM;
    @AndroidFindBy(id="com.shop.android:id/btn_login_fresh_welcome_sign_up") public WebElement signup_btn_MM;
    @AndroidFindBy (id="com.shop.android:id/img_settings") public WebElement settings_icon_MM;


    public By account_lbl_By = By.id("com.daraz.android:id/tab_layout");
    public By signup_And_Login_btn_By = By.id("com.daraz.android:id/txt_login_signup");
    public By signup_btn_By = By.id("com.daraz.android:id/btn_login_fresh_welcome_sign_up");
    public By settings_icon_By = By.id("com.daraz.android:id/tv_settings");
    public By logout_btn_By = By.xpath("//*[@text='Logout']");
    public By final_Logout_btn_By = By.id("android:id/button1");

    public By account_lbl_By_MM = By.id("com.shop.android:id/tab_layout");
    public By signup_And_Login_btn_By_MM = By.id("com.shop.android:id/txt_login_signup");
    public By signup_btn_By_MM = By.id("com.shop.android:id/btn_login_fresh_welcome_sign_up");
    public By settings_icon_By_MM = By.id("com.shop.android:id/img_settings");
}