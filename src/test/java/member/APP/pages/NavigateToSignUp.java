package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
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
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.account_lbl_By, 3);
            signUpObjects.account_lbl_ele.click();
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.signup_And_Login_btn_By, 3);
            signUpObjects.signup_And_Login_btn_ele.click();
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.signup_btn_By, 3);
            signUpObjects.signup_btn.click();
        } else  // code for Shop (MM) app only
        {
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.account_lbl_By_MM, 3);
            signUpObjects.account_lbl_MM.click();
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.signup_And_Login_btn_By_MM, 3);
            clickMultipleTries(signUpObjects.signup_And_Login_btn_MM, 2);
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.signup_btn_By_MM, 3);
            signUpObjects.signup_btn_MM.click();
        }
    }

    public void navigateToSigninScreen() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.account_lbl_By, 3);
            signUpObjects.account_lbl_ele.click();
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.signup_And_Login_btn_By, 3);
            signUpObjects.signup_And_Login_btn_ele.click();
        } else {
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.account_lbl_By_MM, 3);
            signUpObjects.account_lbl_MM.click();
            waitForElementByWithoutExceptionUntillTimeReach(signUpObjects.signup_And_Login_btn_By_MM, 3);
            signUpObjects.signup_And_Login_btn_MM.get(0).click();
        }
    }
}