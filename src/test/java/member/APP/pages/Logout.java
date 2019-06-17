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

public class Logout extends Base {
    SignUpObjects signUpObjects = new SignUpObjects();

    public Logout(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
    }

    public void logout() //This Method is used to logout the current user from Daraz or Shop application after signup/siginin operation
    {
     if (!System.getProperty("env").equalsIgnoreCase("mm.live")) { // Code for all Daraz ventures except MM
         waitUntilPresentOfElementBy(signUpObjects.settings_icon_By);
         signUpObjects.settings_icon.click();
        }
     else // Code for Shop (MM) app only
        {
        waitUntilPresentOfElementBy(signUpObjects.settings_icon_By_MM);
        signUpObjects.settings_icon_MM.click();
        }
       waitUntilPresentOfElementBy(signUpObjects.logout_btn_By);
       signUpObjects.logout_btn.click();
       waitUntilPresentOfElementBy(signUpObjects.final_Logout_btn_By);
       signUpObjects.final_Logout_btn.click();



    }
}
