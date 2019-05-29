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

    public void navigateToSignUpScreen() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By);
            signUpObjects.account_lbl.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.signup_And_Login_btn_By);
            do signUpObjects.signup_And_Login_btn.click();
            while (isElementPresent(signUpObjects.signup_And_Login_btn_By));
            waitUntilPresentOfElementBy(signUpObjects.signup_btn_By);
            signUpObjects.signup_btn.click();
        }
        else
        {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By_MM);
            signUpObjects.account_lbl_MM.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.signup_And_Login_btn_By_MM);
            do signUpObjects.signup_And_Login_btn_MM.click();
            while (isElementPresent(signUpObjects.signup_And_Login_btn_By_MM));
            waitUntilPresentOfElementBy(signUpObjects.signup_btn_By_MM);
            signUpObjects.signup_btn_MM.click();
        }
    }

}