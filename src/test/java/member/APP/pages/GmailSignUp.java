package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.GmailSignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.RandomStringUtils;

/** Developed By: Muhammad Haris Ehsan
 * Date: 28/05/2019
 */

public class GmailSignUp extends Base {

    String FIRST_NAME = "Daraz";
    String FIRST_NAME_MM = "Shop";
    String LAST_NAME = "QA";
    String PASSWORD = "Daraz@123";
    String PASSWORD_MM = "Shop@123";
    String DEVICE_CODE = "0000";

    GmailSignUpObjects gmailsignUpObjects = new GmailSignUpObjects();

    public GmailSignUp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gmailsignUpObjects);
    }

    public void signupUsingGmail() {  // This Method is used to open the google signup option and fill the general authentication if needed by gmail
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_btn_By);
            gmailsignUpObjects.gmail_btn.click();
        } else {
            waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_btn_By_MM);
            gmailsignUpObjects.gmail_btn_MM.click();
        }
        waitUntilPresentOfElementBy(gmailsignUpObjects.policy_Agree_btn_By);
        gmailsignUpObjects.policy_Agree_btn.click();
        if (waitWithoutException(gmailsignUpObjects.new_User_link))
            gmailsignUpObjects.new_User_link.click();
        if (waitWithoutException(gmailsignUpObjects.pin_txt))
            gmailsignUpObjects.pin_txt.sendKeys(DEVICE_CODE);
        if (waitWithoutException(gmailsignUpObjects.next_btn))
            gmailsignUpObjects.next_btn.click();
        waitUntilPresentOfElementBy(gmailsignUpObjects.create_Account_btn_By);
        clickMultipleTries(gmailsignUpObjects.create_Account_btn,5);
    }

    public String gmailName() { // This Method is used Fill the First and Last Name for gmail signup
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) { // code for all Daraz ventures except MM
            waitUntilPresentOfElementBy(gmailsignUpObjects.name_txt_By);
            gmailsignUpObjects.first_name_txt.sendKeys(FIRST_NAME);
            gmailsignUpObjects.last_name_txt.click();
            gmailsignUpObjects.last_name_txt.sendKeys(LAST_NAME);
            hideKeyboard();
            clickMultipleTries(gmailsignUpObjects.next_Second_btn, 5);
            return (FIRST_NAME + " " + LAST_NAME);
        } else { // code for Shop (MM) app only
            waitUntilPresentOfElementBy(gmailsignUpObjects.name_txt_By);
            gmailsignUpObjects.first_name_txt.sendKeys(FIRST_NAME_MM);
            gmailsignUpObjects.last_name_txt.click();
            gmailsignUpObjects.last_name_txt.sendKeys(LAST_NAME);
            hideKeyboard();
            clickMultipleTries(gmailsignUpObjects.next_Second_btn, 5);
            return (FIRST_NAME_MM+" "+LAST_NAME);
        }
    }

    public void gmailDOBAndGender() { // This Method is used to choose the random Date of Birth and gender for gmail signup
        waitUntilPresentOfElementBy(gmailsignUpObjects.dob_txt_By);
        gmailsignUpObjects.dob_txt.get(8).sendKeys(Integer.toString(randomNumberGenerator(27)+1));
        gmailsignUpObjects.dob_txt.get(15).click();
        gmailsignUpObjects.month_Selector_rdobtn.get(randomNumberGenerator(gmailsignUpObjects.month_Selector_rdobtn.size())).click();
        gmailsignUpObjects.dob_txt.get(22).sendKeys("19" + Integer.toString(50 + randomNumberGenerator(50)));
        gmailsignUpObjects.dob_txt.get(29).click();
        gmailsignUpObjects.month_Selector_rdobtn.get(randomNumberGenerator(gmailsignUpObjects.month_Selector_rdobtn.size())).click();
        gmailsignUpObjects.next_Third_btn.click();
    }

    public void gmailAddress() { // This Method is used to choose an email address with random 5 digits for gmail signup
        waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_Address_lbl_By);
        gmailsignUpObjects.gmail_Address_lbl.click();
        waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_Address_txt_By);
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            gmailsignUpObjects.gmail_Address_txt.sendKeys(FIRST_NAME+LAST_NAME+"."+ RandomStringUtils.randomNumeric(5));
        else
            gmailsignUpObjects.gmail_Address_txt.sendKeys(FIRST_NAME_MM+LAST_NAME+"."+ RandomStringUtils.randomNumeric(5));
        hideKeyboard();
        gmailsignUpObjects.next_Fourth_btn.click();
    }

    public void gmailPassword()  { // This Method is used to set the strong password for gmail signup
        waitUntilPresentOfElementBy(gmailsignUpObjects.create_Password_txt_By);
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            gmailsignUpObjects.create_Password_txt.sendKeys(PASSWORD);
            gmailsignUpObjects.dob_txt.get(20).sendKeys(PASSWORD);
        }
        else
        {
         gmailsignUpObjects.create_Password_txt.sendKeys(PASSWORD_MM);
         gmailsignUpObjects.dob_txt.get(20).sendKeys(PASSWORD_MM);
        }
        hideKeyboard();
        gmailsignUpObjects.Element_btn.get(0).click();
        gmailsignUpObjects.Element_btn.get(1).click();
    }

    public void gmailPhoneAndPrivacy()  { // This Method is used skip the phone number options and accept the privacy policy for gmail signup
       waitUntilPresentOfElementBy(gmailsignUpObjects.skip_btn_By);
       scrollDownMultipleTries(2);
       clickMultipleTries(gmailsignUpObjects.skip_btn,8);
       waitUntilPresentOfElementBy(gmailsignUpObjects.i_Agree_btn_By);
       scrollDownMultipleTries(3);
       clickMultipleTries(gmailsignUpObjects.i_Agree_btn,8);
       waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_Final_Next_btn_By);
       clickMultipleTries(gmailsignUpObjects.gmail_Final_Next_btn,3);
          }

     public String gmailSignupVerification() // This Method is used to verify either you have been signed up successfully with the name as provided above or not
     {
         if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
             if (waitWithoutException(gmailsignUpObjects.gmail_btn))
                 gmailsignUpObjects.gmail_btn.click();
             waitUntilPresentOfElementBy(gmailsignUpObjects.account_Holder_Name_lbl_By);
             return gmailsignUpObjects.account_Holder_Name_lbl.getText();
         }
         else
         {
             if (waitWithoutException(gmailsignUpObjects.gmail_btn_MM))
                 gmailsignUpObjects.gmail_btn_MM.click();
             waitUntilPresentOfElementBy(gmailsignUpObjects.account_Holder_Name_lbl_By_MM);
             return gmailsignUpObjects.account_Holder_Name_lbl_MM.getText();
         }
     }
}