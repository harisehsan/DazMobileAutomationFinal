package member.APP.pages;

import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.getProperty.FacebookGetProperty;
import member.APP.pageObjects.FacebookSignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/** Developed By: Muhammad Haris Ehsan
 * Date: 28/05/2019
 */

public class FacebookSignUp extends Base {

    FacebookSignUpObjects facebookSignUpObjects = new FacebookSignUpObjects();
    FacebookGetProperty facebookGetProperty = new FacebookGetProperty();

    public FacebookSignUp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), facebookSignUpObjects);
    }

    public void signUpUsingFacebook() // This Method is used to open the facebook signup option and fill the email and password
    {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(facebookSignUpObjects.facebook_btn_By);
           clickMultipleTries(facebookSignUpObjects.facebook_btn,1);
        }
        else {
            waitUntilPresentOfElementBy(facebookSignUpObjects.facebook_btn_MM_By);
            clickMultipleTries(facebookSignUpObjects.facebook_btn_MM,1);
        }
    }

    public void policyAgreement()
    {
        waitUntilPresentOfElementBy(facebookSignUpObjects.policy_Agree_btn_By);
        facebookSignUpObjects.policy_Agree_btn.click();
    }

    public String emailAndPassword() throws IOException {
       if (isExist(facebookSignUpObjects.facebook_Email_txt)) {
           facebookSignUpObjects.facebook_Email_txt.get(0).sendKeys(facebookGetProperty.emailGetProperty());
           if (isExist(facebookSignUpObjects.facebook_Password_txt)) {
               facebookSignUpObjects.facebook_Password_txt.get(0).sendKeys(facebookGetProperty.passwordGetProperty());
               clickMultipleTries(facebookSignUpObjects.facebook_login_btn, 1);
           } else {
               clickMultipleTries(facebookSignUpObjects.facebook_login_btn, 1);
               facebookSignUpObjects.facebook_Password_txt.get(0).sendKeys(facebookGetProperty.passwordGetProperty());
               clickMultipleTries(facebookSignUpObjects.facebook_login_btn, 1);
           }
             if (isExist(facebookSignUpObjects.continue_Facebook_Accout))
                 clickMultipleTries(facebookSignUpObjects.continue_Facebook_Accout,1);
       }

        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live"))
            return facebookGetProperty.nameGetProperty();
        else
            return facebookGetProperty.nameMMGetProperty();
    }
    public String facebookSignupVerififcation() // This Method is used to verify either you have been signed up successfully with the name as provided above or not
    {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
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