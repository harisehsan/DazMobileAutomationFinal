package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.FacebookSignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/** Developed By: Muhammad Haris Ehsan
 * Date: 28/05/2019
 */

public class FacebookSignUp extends Base {

    FacebookSignUpObjects facebookSignUpObjects = new FacebookSignUpObjects();

    String EMAIL= "darazqa@gmail.com";
    String PASSWORD = "Test@123";
    String NAME = "Syed Waleed Ali";
    String NAME_MM = "Test Test";

    public FacebookSignUp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), facebookSignUpObjects);
    }

    public String signUpUsingFacebook() // This Method is used to open the facebook signup option and fill the email and password
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(facebookSignUpObjects.facebook_btn_By);
            facebookSignUpObjects.facebook_btn.click();
        }
        else {
            waitUntilPresentOfElementBy(facebookSignUpObjects.facebook_btn_MM_By);
            facebookSignUpObjects.facebook_btn_MM.click();
        }
           waitUntilPresentOfElementBy(facebookSignUpObjects.policy_Agree_btn_By);
           facebookSignUpObjects.policy_Agree_btn.click();
           waitWithoutException(facebookSignUpObjects.facebook_Email_txt);
           facebookSignUpObjects.facebook_Email_txt.click();
           facebookSignUpObjects.facebook_Email_txt.sendKeys(EMAIL);
           facebookSignUpObjects.facebook_Password_txt.click();
           facebookSignUpObjects.facebook_Password_txt.sendKeys(PASSWORD);
           clickMultipleTries(facebookSignUpObjects.facebook_login_btn,5);
          if (waitWithoutException(facebookSignUpObjects.continue_Facebook_Accout))
              facebookSignUpObjects.continue_Facebook_Accout.click();
           if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
                return NAME;
           else
               return NAME_MM;
    }

    public String facebookSignupVerififcation() // This Method is used to verify either you have been signed up successfully with the name as provided above or not
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(facebookSignUpObjects.account_Holder_Name_lbl_By);
            return facebookSignUpObjects.account_Holder_Name_lbl.getText();
        }
        else
        {
            waitUntilPresentOfElementBy(facebookSignUpObjects.account_Holder_Name_lbl_By_MM);
            return facebookSignUpObjects.account_Holder_Name_lbl_MM.getText();
        }
    }
    }