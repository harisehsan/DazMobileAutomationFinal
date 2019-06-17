package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FacebookSignUpObjects  {
    @AndroidFindBy(id = "com.daraz.android:id/view_login_social_facebook") public WebElement facebook_btn;
    @AndroidFindBy(xpath="//*[@resource-id='android:id/button1']") public WebElement policy_Agree_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@content-desc='Username']"),@AndroidBy (id ="m_login_email") ,@AndroidBy(xpath = "//*[@text='Phone number or email address']")}) public WebElement facebook_Email_txt;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@content-desc='Password']"),@AndroidBy(id = "m_login_password"),@AndroidBy(xpath = "//*[@text='Password']")}) public WebElement facebook_Password_txt;
    @AndroidFindBy(id = "com.shop.android:id/view_login_social_facebook") public WebElement facebook_btn_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@content-desc='Login click']"),@AndroidBy(xpath = "//*[@text='Log In']"),@AndroidBy(xpath = "//*[@contentDescription='Login click']")}) public List <WebElement> facebook_login_btn;
    @AndroidFindBy (id="com.daraz.android:id/txt_name") public WebElement account_Holder_Name_lbl;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@text='Continue']"),@AndroidBy(xpath = "//*[starts-with(@text,'CONTINUE')]")}) public WebElement continue_Facebook_Accout;

    @AndroidFindBy (id="com.shop.android:id/txt_name") public WebElement account_Holder_Name_lbl_MM;

    public By facebook_btn_By = By.id("com.daraz.android:id/view_login_social_facebook");
    public By policy_Agree_btn_By = By.xpath("//*[@resource-id='android:id/button1']");
    public By facebook_btn_MM_By = By.id("com.shop.android:id/view_login_social_facebook");
    public By facebook_Email_txt_By = By.xpath("//*[@content-desc='Username']");
    public By account_Holder_Name_lbl_By = By.id("com.daraz.android:id/txt_name");
    public By account_Holder_Name_lbl_By_MM = By.id("com.shop.android:id/txt_name");
}