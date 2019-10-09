package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/** Developed By: Muhammad Haris Ehsan
 * Date: 28/05/2019
 */

public class NavigateToSignUp extends Base {
    SignUpObjects signUpObjects = new SignUpObjects();

    public NavigateToSignUp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
    }

    public void navigateToSignUpScreen() { //This method is used to navigate the control to the sigup screen to make it able to choose Facebook or gmail signup option
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) { // code for all Daraz ventures except MM
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By);
            signUpObjects.account_lbl.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.signup_And_Login_btn_By);
            clickMultipleTries(signUpObjects.signup_And_Login_btn,2);
            waitUntilPresentOfElementBy(signUpObjects.signup_btn_By);
            signUpObjects.signup_btn.click();
        }
        else  // code for Shop (MM) app only
        {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By_MM);
            signUpObjects.account_lbl_MM.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.signup_And_Login_btn_By_MM);
            clickMultipleTries(signUpObjects.signup_And_Login_btn_MM,2);
            waitUntilPresentOfElementBy(signUpObjects.signup_btn_By_MM);
            signUpObjects.signup_btn_MM.click();
        }
    }

    public void navigateToSigninScreen() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By);
            signUpObjects.account_lbl.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.signup_And_Login_btn_By);
            clickMultipleTries(signUpObjects.signup_And_Login_btn,2);
        }
        else
        {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By_MM);
            signUpObjects.account_lbl_MM.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.signup_And_Login_btn_By_MM);
            clickMultipleTries(signUpObjects.signup_And_Login_btn_MM,2);
        }
    }
}