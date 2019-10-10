package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GmailSignUpObjects {

    @AndroidFindBy(id="com.daraz.android:id/view_login_social_google") public List <WebElement> gmail_btn;
    @AndroidFindBy(xpath="//*[@resource-id='android:id/button1']") public WebElement policy_Agree_btn;
    @AndroidFindBy(id="com.google.android.gms:id/add_account_chip_title") public List <WebElement> new_User_link;
    @AndroidFindBy(id="com.android.settings:id/password_entry") public WebElement pin_txt;
    @AndroidFindBy(id="com.android.settings:id/next_button") public List <WebElement> next_btn;
    @AndroidFindBy(xpath="//*[@text='Create account']") public List <WebElement>  create_Account_btn;
    @AndroidFindAll({@AndroidBy(id = "firstName"), @AndroidBy(xpath = "//*[@resource-id='firstName']")}) public WebElement first_name_txt;
//    @AndroidFindBy(xpath="//*[@class='android.view.View']") public WebElement First_name_txt;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@id='collectNameNext']"), @AndroidBy(xpath = "//*[@text='Next']")}) public List <WebElement> next_Second_btn;
    @AndroidFindAll({@AndroidBy(id = "lastName"), @AndroidBy(xpath = "//*[@resource-id='lastName']")}) public WebElement last_name_txt;
    @AndroidFindBy(className = "android.widget.EditText") public List <WebElement> dob_txt;
    @AndroidFindBy(xpath = "//*[@text='Create a different Gmail address']") public WebElement gmail_Address_lbl;
    @AndroidFindAll({@AndroidBy(id = "identifierId"), @AndroidBy(xpath = "//*[@resource-id='identifierId']")}) public WebElement gmail_Address_txt;
    @AndroidFindBy(id = "android:id/text1") public List <WebElement> month_Selector_rdobtn;
    @AndroidFindBy(xpath = "//*[@text='Next']") public WebElement next_Third_btn;
    @AndroidFindAll({@AndroidBy(id = "next"), @AndroidBy(xpath = "//*[@text='Next']")})  public List <WebElement> next_Fourth_btn;
    @AndroidFindBy(className = "android.widget.EditText") public List <WebElement> create_Password_txt;
    @AndroidFindBy(className="android.widget.Button") public List <WebElement> Element_btn;
    @AndroidFindBy(xpath = "//*[@text='Skip']") public List <WebElement> skip_btn;
    @AndroidFindBy(xpath="//*[@id='termsofserviceNext']") public WebElement term_Of_Service_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@text='Next']"), @AndroidBy(xpath = "//*[@id='next']")}) public List <WebElement> gmail_Final_Next_btn;
    @AndroidFindAll({@AndroidBy(id = "termsofserviceNext"), @AndroidBy(xpath = "//*[@text='I agree']")}) public List <WebElement> i_Agree_btn;
    @AndroidFindBy (id="com.daraz.android:id/txt_name") public WebElement account_Holder_Name_lbl;
    @AndroidFindBy (id  = "com.google.android.inputmethod.latin:id/icon") public List <WebElement> enter_btn;
    @AndroidFindBy(id="com.shop.android:id/view_login_social_google") public List <WebElement> gmail_btn_MM;
    @AndroidFindBy (id="com.shop.android:id/txt_name") public WebElement account_Holder_Name_lbl_MM;
    @AndroidFindBy(xpath = "//*[@resource-id='month-label']") public WebElement month_lbl;
    @AndroidFindBy(xpath = "//*[@resource-id='gender-label']") public WebElement gender_lbl;
    @AndroidFindAll({@AndroidBy(id = "createpasswordNext"), @AndroidBy(xpath = "//*[@text='Next']")}) public List <WebElement> password_btn;
    @AndroidFindBy(xpath = "//*[@text='For myself']") public List <WebElement> my_Self_lstItem;
    @AndroidFindBy (id = "com.android.settings:id/password1") public List <WebElement> passcode_Entry_imgView;
    @AndroidFindBy(id = "com.android.settings:id/key0") public WebElement zero_Key_btn;
    @AndroidFindBy (id = "com.vivo.secime.service:id/hide_btn") public List <WebElement> vivo_Hide_Key_Board_btn;
    @AndroidFindBy (id = "com.google.android.gms:id/main_title") public List <WebElement> choose_Google_Account_lbl;
    @AndroidFindBy (id = "com.google.android.gms:id/account_display_name") public List <WebElement> account_google_lbl;


    public By policy_Agree_btn_By = By.xpath("//*[@resource-id='android:id/button1']");
    public By new_User_link_By = By.id("com.google.android.gms:id/add_account_chip_title");
    public By pin_txt_By = By.id("com.android.settings:id/password_entry");
    public By next_btn_By = By.id("com.android.settings:id/next_button");
    public By create_Account_btn_By = By.xpath("//*[@text='Create account']");
    public By name_txt_By = By.xpath("//*[@class='android.view.View']");
    public By next_Second_btn_By = By.id("collectNameNext");
    public By dob_txt_By = By.className("android.view.View");
    public By gmail_Address_lbl_By = By.xpath("//*[@text='Create a different Gmail address']");
    public By gmail_Address_txt_By = By.xpath("//*[@id='identifierId'] | //*[@resource-id='identifierId']");
    public By create_Password_txt_By = By.className("android.widget.EditText");
    public By skip_btn_By = By.xpath("//*[@text='Skip']");
    public By term_Of_Service_btn_By = By.xpath("//*[@id='termsofserviceNext']");
    public By i_Agree_btn_By = By.xpath("//*[@id='termsofserviceNext'] | //*[@text='I agree']");
    public By gmail_Final_Next_btn_By = By.xpath("//*[@text='Next'] | //*[@resource-id='next']");
    public By gmail_btn_By = By.id("com.daraz.android:id/view_login_social_google");
    public By account_Holder_Name_lbl_By = By.id("com.daraz.android:id/txt_name");
    public By gmail_btn_By_MM = By.id("com.shop.android:id/view_login_social_google");
    public By account_Holder_Name_lbl_By_MM = By.id("com.shop.android:id/txt_name");
}