package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailSignUpObjects {

    @AndroidFindBy(id="com.daraz.android:id/view_login_social_google") public WebElement gmail_btn;
    @AndroidFindBy(xpath="//*[@resource-id='android:id/button1']") public WebElement policy_Agree_btn;
    @AndroidFindBy(id="com.google.android.gms:id/add_account_chip_title") public WebElement new_User_link;
    @AndroidFindBy(id="com.android.settings:id/password_entry") public WebElement pin_txt;
    @AndroidFindBy(id="com.android.settings:id/next_button") public List <WebElement> next_btn;
    @AndroidFindBy(xpath="//*[@text='Create account']") public List <WebElement>  create_Account_btn;
    @AndroidFindBy(id="firstName") public WebElement first_name_txt;
//    @AndroidFindBy(xpath="//*[@class='android.view.View']") public WebElement First_name_txt;
    @AndroidFindBy(id="collectNameNext") public List <WebElement> next_Second_btn;
    @AndroidFindBy(id="lastName") public WebElement last_name_txt;
    @AndroidFindBy(className = "android.widget.EditText") public List <WebElement> dob_txt;
    @AndroidFindBy(xpath = "//*[@text='Create a different Gmail address']") public WebElement gmail_Address_lbl;
    @AndroidFindBy (id = "identifierId") public WebElement gmail_Address_txt;
    @AndroidFindBy(id = "android:id/text1") public List <WebElement> month_Selector_rdobtn;
    @AndroidFindBy(xpath = "//*[@text='Next']") public WebElement next_Third_btn;
    @AndroidFindBy(id = "next") public WebElement next_Fourth_btn;
    @AndroidFindBy(className = "android.widget.EditText") public List <WebElement> create_Password_txt;
    @AndroidFindBy(className="android.widget.Button") public List <WebElement> Element_btn;
    @AndroidFindBy(xpath = "//*[@text='Skip']") public List <WebElement> skip_btn;
    @AndroidFindBy(xpath="//*[@id='termsofserviceNext']") public WebElement term_Of_Service_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@text='Next']"), @AndroidBy(xpath = "//*[@id='next']")}) public List <WebElement> gmail_Final_Next_btn;
    @AndroidFindBy(id= "termsofserviceNext") public List <WebElement> i_Agree_btn;
    @AndroidFindBy (id="com.daraz.android:id/txt_name") public WebElement account_Holder_Name_lbl;
    @AndroidFindBy (id  = "com.google.android.inputmethod.latin:id/icon") public List <WebElement> enter_btn;
    @AndroidFindBy(id="com.shop.android:id/view_login_social_google") public WebElement gmail_btn_MM;
    @AndroidFindBy (id="com.shop.android:id/txt_name") public WebElement account_Holder_Name_lbl_MM;
    @AndroidFindBy(xpath = "//*[@resource-id='month-label']") public WebElement month_lbl;
    @AndroidFindBy(xpath = "//*[@resource-id='gender-label']") public WebElement gender_lbl;
    @AndroidFindBy (id = "createpasswordNext") public WebElement password_btn;


    public By policy_Agree_btn_By = By.xpath("//*[@resource-id='android:id/button1']");
    public By new_User_link_By = By.id("com.google.android.gms:id/add_account_chip_title");
    public By pin_txt_By = By.id("com.android.settings:id/password_entry");
    public By next_btn_By = By.id("com.android.settings:id/next_button");
    public By create_Account_btn_By = By.xpath("//*[@text='Create account']");
    public By name_txt_By = By.xpath("//*[@class='android.view.View']");
    public By next_Second_btn_By = By.id("collectNameNext");
    public By dob_txt_By = By.className("android.view.View");
    public By gmail_Address_lbl_By = By.xpath("//*[@text='Create a different Gmail address']");
    public By gmail_Address_txt_By = By.id("identifierId");
    public By create_Password_txt_By = By.className("android.widget.EditText");
    public By skip_btn_By = By.xpath("//*[@text='Skip']");
    public By term_Of_Service_btn_By = By.xpath("//*[@id='termsofserviceNext']");
    public By i_Agree_btn_By = By.id("termsofserviceNext");
    public By gmail_Final_Next_btn_By = By.xpath("//*[@text='Next']");
    public By gmail_btn_By = By.id("com.daraz.android:id/view_login_social_google");
    public By account_Holder_Name_lbl_By = By.id("com.daraz.android:id/txt_name");

    public By gmail_btn_By_MM = By.id("com.shop.android:id/view_login_social_google");
    public By account_Holder_Name_lbl_By_MM = By.id("com.shop.android:id/txt_name");
}