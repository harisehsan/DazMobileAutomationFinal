package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.getProperty.GmailSignUpGetProperty;
import member.APP.pageObjects.GmailSignUpObjects;
import member.APP.pageObjects.WishlistPageObjects;
import member.APP.setProperty.GmailSignupSetProperty;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.IOException;

/** Developed By: Muhammad Haris Ehsan
 * Date: 28/05/2019
 */

public class GmailSignUp extends Base {
    GmailSignUpGetProperty gmailSignUpGetProperty = new GmailSignUpGetProperty();
    GmailSignUpObjects gmailsignUpObjects = new GmailSignUpObjects();
    GmailSignupSetProperty gmailSignupSetProperty = new GmailSignupSetProperty();
    WishlistPageObjects wishlistPageObject = new WishlistPageObjects();
    public GmailSignUp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gmailsignUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObject);
    }

    public void signupUsingGmail() throws IOException {  // This Method is used to open the google signup option and fill the general authentication if needed by gmail
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_btn_By);
           clickMultipleTries(gmailsignUpObjects.gmail_btn,1);
        } else {
            waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_btn_By_MM);
            clickMultipleTries(gmailsignUpObjects.gmail_btn_MM,1);
        }
        waitUntilPresentOfElementBy(gmailsignUpObjects.policy_Agree_btn_By);
        gmailsignUpObjects.policy_Agree_btn.click();
        if (isExist(gmailsignUpObjects.choose_Google_Account_lbl) && (wishlistPageObject.accout_ID_lbl.size() > 2)) {
            while (!(isExist(gmailsignUpObjects.new_User_link)))
            {
              swipeBetweenTwoItems(gmailsignUpObjects.account_google_lbl.get(gmailsignUpObjects.account_google_lbl.size()-1),gmailsignUpObjects.account_google_lbl.get(0));
            }
               gmailsignUpObjects.new_User_link.get(0).click();
        }
        if (waitWithoutException(gmailsignUpObjects.pin_txt)) {
            if (gmailsignUpObjects.next_btn.size() > 0)
            {
                gmailsignUpObjects.pin_txt.sendKeys(gmailSignUpGetProperty.getDeviceCode());
                gmailsignUpObjects.next_btn.get(0).click();
            }
             else if (findElementsSizeByString(gmailSignUpGetProperty.getOppoCodeTextField())) {
                findElementByString(gmailSignUpGetProperty.getOppoCodeTextField()).sendKeys(gmailSignUpGetProperty.getDeviceCodeOppo());
                pressEnterKey();
            }
                 else
             {
               if (isExist(gmailsignUpObjects.passcode_Entry_imgView))
               {
                 for (int i=0;i<4;i++)
                   gmailsignUpObjects.zero_Key_btn.click();
               }
               else {
                   gmailsignUpObjects.pin_txt.sendKeys("0" + "0" + "0" + "0");
                   pressEnterKey();
               }
             }
        }
        waitUntilPresentOfElementBy(gmailsignUpObjects.create_Account_btn_By);
        clickMultipleTries(gmailsignUpObjects.create_Account_btn,1);
        if (isExist(gmailsignUpObjects.my_Self_lstItem))
            gmailsignUpObjects.my_Self_lstItem.get(0).click();

    }

    public String gmailName() throws IOException { // This Method is used Fill the First and Last Name for gmail signup
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) { // code for all Daraz ventures except MM
            waitUntilPresentOfElementBy(gmailsignUpObjects.name_txt_By);
            hideKeyboard();
            gmailsignUpObjects.first_name_txt.sendKeys(gmailSignUpGetProperty.getFirstName());
            scrollDownMultipleTries(1);
            gmailsignUpObjects.last_name_txt.sendKeys(gmailSignUpGetProperty.getLastName());
            hideKeyboard();
            clickMultipleTries(gmailsignUpObjects.next_Second_btn, 2);
            return (gmailSignUpGetProperty.getFirstName() + " " + gmailSignUpGetProperty.getLastName());
        } else { // code for Shop (MM) app only
            waitUntilPresentOfElementBy(gmailsignUpObjects.name_txt_By);
            hideKeyboard();
            gmailsignUpObjects.first_name_txt.sendKeys(gmailSignUpGetProperty.getFirstNameMM());
            scrollDownMultipleTries(1);
            gmailsignUpObjects.last_name_txt.sendKeys(gmailSignUpGetProperty.getLastName());
            hideKeyboard();
            clickMultipleTries(gmailsignUpObjects.next_Second_btn, 2);
            return (gmailSignUpGetProperty.getFirstNameMM()+" "+gmailSignUpGetProperty.getLastName());
        }
    }

    public void gmailDOBAndGender() { // This Method is used to choose the random Date of Birth and gender for gmail signup
        waitUntilPresentOfElementBy(gmailsignUpObjects.dob_txt_By);
        gmailsignUpObjects.month_lbl.click();
        gmailsignUpObjects.month_Selector_rdobtn.get(randomNumberGenerator(gmailsignUpObjects.month_Selector_rdobtn.size())).click();
        gmailsignUpObjects.dob_txt.get(0).sendKeys(Integer.toString(randomNumberGenerator(27)+1));
        gmailsignUpObjects.dob_txt.get(1).sendKeys("19" + Integer.toString(50 + randomNumberGenerator(50)));
        gmailsignUpObjects.gender_lbl.click();
        int index = randomNumberGenerator(gmailsignUpObjects.month_Selector_rdobtn.size()-1);
        if (index < 0) index=0;
        gmailsignUpObjects.month_Selector_rdobtn.get(index).click();
        gmailsignUpObjects.next_Third_btn.click();
    }

    public void gmailAddress() throws IOException { // This Method is used to choose an email address with random 5 digits for gmail signup
        int index = 0;
        String email;
        waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_Address_lbl_By);
        gmailsignUpObjects.gmail_Address_lbl.click();
        hideKeyboard();
        scrollDownMultipleTries(1);
        waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_Address_txt_By);
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            email = (gmailSignUpGetProperty.getFirstName() + gmailSignUpGetProperty.getLastName() + "." + RandomStringUtils.randomNumeric(5));
            gmailsignUpObjects.gmail_Address_txt.sendKeys(email);
         switch(System.getProperty("env"))
         {
             case "pk.live":
             {
                 index = Integer.parseInt(gmailSignUpGetProperty.getIndexPK());
                 index++;
                 gmailSignupSetProperty.setEmail_PK(Integer.toString(index),email);
             }
             break;
             case "bd.live":
             {
                 index = Integer.parseInt(gmailSignUpGetProperty.getIndexBD());
                 index++;
                 gmailSignupSetProperty.setEmail_BD(Integer.toString(index),email);
             }
             break;
             case "lk.live":
             {
                 index = Integer.parseInt(gmailSignUpGetProperty.getIndexLK());
                 index++;
                 gmailSignupSetProperty.setEmail_LK(Integer.toString(index),email);
             }
             break;
             case "np.live":
             {
                 index = Integer.parseInt(gmailSignUpGetProperty.getIndexNP());
                 index++;
                 gmailSignupSetProperty.setEmail_NP(Integer.toString(index),email);
             }
             break;
         }
        }
        else {
            email = (gmailSignUpGetProperty.getFirstNameMM() + gmailSignUpGetProperty.getLastName() + "." + RandomStringUtils.randomNumeric(5));
            gmailsignUpObjects.gmail_Address_txt.sendKeys(email);
            index = Integer.parseInt(gmailSignUpGetProperty.getIndexMM());
            index++;
            gmailSignupSetProperty.setEmail_MM(Integer.toString(index),email);
            }
        hideKeyboard();
        clickMultipleTries(gmailsignUpObjects.next_Fourth_btn,1);
    }

    public void gmailPassword() throws IOException { // This Method is used to set the strong password for gmail signup
        waitUntilPresentOfElementBy(gmailsignUpObjects.create_Password_txt_By);
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            gmailsignUpObjects.create_Password_txt.get(0).click();
//           scrollDownMultipleTries(1);
           hideKeyboard();
           gmailsignUpObjects.create_Password_txt.get(0).sendKeys(gmailSignUpGetProperty.getPassword());
           gmailsignUpObjects.create_Password_txt.get(1).click();
//           scrollDownMultipleTries(1);
           hideKeyboard();
           gmailsignUpObjects.create_Password_txt.get(1).sendKeys(gmailSignUpGetProperty.getPassword());
        }
        else
        {
            gmailsignUpObjects.create_Password_txt.get(0).click();
//            scrollDownMultipleTries(1);
            hideKeyboard();
            gmailsignUpObjects.create_Password_txt.get(0).sendKeys(gmailSignUpGetProperty.getPasswordMM());
            gmailsignUpObjects.create_Password_txt.get(1).click();
//            scrollDownMultipleTries(1);
            hideKeyboard();
            gmailsignUpObjects.create_Password_txt.get(1).sendKeys(gmailSignUpGetProperty.getPasswordMM());
        }
        if (isExist(gmailsignUpObjects.vivo_Hide_Key_Board_btn))
            gmailsignUpObjects.vivo_Hide_Key_Board_btn.get(0).click();
        else
             hideKeyboard();
        clickMultipleTries(gmailsignUpObjects.password_btn,1);
    }

    public void gmailPhoneAndPrivacy()  { // This Method is used skip the phone number options and accept the privacy policy for gmail signup
        do
           scrollDownMultipleTries(5);
        while (!(isExist(gmailsignUpObjects.skip_btn)) && (!(isExist(gmailsignUpObjects.i_Agree_btn))));
        if (isExist(gmailsignUpObjects.skip_btn)) {
           clickMultipleTries(gmailsignUpObjects.skip_btn, 1);
       }
        while(!(isExist(gmailsignUpObjects.i_Agree_btn)))
        scrollDownMultipleTries(5);
       clickMultipleTries(gmailsignUpObjects.i_Agree_btn,1);
       waitUntilPresentOfElementBy(gmailsignUpObjects.gmail_Final_Next_btn_By);
       clickMultipleTries(gmailsignUpObjects.gmail_Final_Next_btn,1);
          }

     public String gmailSignupVerification() // This Method is used to verify either you have been signed up successfully with the name as provided above or not
     {
         if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
             if (isExist(gmailsignUpObjects.gmail_btn))
                 clickMultipleTries(gmailsignUpObjects.gmail_btn,1);
             waitUntilPresentOfElementBy(gmailsignUpObjects.account_Holder_Name_lbl_By);
             return gmailsignUpObjects.account_Holder_Name_lbl.getText();
         }
         else
         {
             if (isExist(gmailsignUpObjects.gmail_btn_MM))
                 clickMultipleTries(gmailsignUpObjects.gmail_btn_MM,1);
             waitUntilPresentOfElementBy(gmailsignUpObjects.account_Holder_Name_lbl_By_MM);
             return gmailsignUpObjects.account_Holder_Name_lbl_MM.getText();
         }
     }


}