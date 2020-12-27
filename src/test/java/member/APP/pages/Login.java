package member.APP.pages;

import global.APP.pageObjects.SearchBarPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.getProperty.LoginGetProperty;
import member.APP.pageObjects.LoginPageObject;
import member.APP.pageObjects.WishlistPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.Password;

import java.io.IOException;

public class Login extends Base {

    LoginPageObject loginPageObject = new LoginPageObject();
    WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();
    SearchBarPageObject searchBarPageObject = new SearchBarPageObject();
    LoginGetProperty loginGetProperty = new LoginGetProperty();


    public Login(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchBarPageObject);
    }

    public void selectMessage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.tray_icon_By);
            findElementByTextUsingExactString("Messages").click();

        } else {
            waitUntilPresentOfElementBy(loginPageObject.tray_icon_By_MM);
            findElementByTextUsingExactString("Messages").click();
        }
    }

    public void selectLogin(String screen) {
        if (screen.equalsIgnoreCase("message")) {
            if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
                do {
                    waitUntilPresentOfElementBy(loginPageObject.message_Login_btn_By);
                    loginPageObject.message_Login_btn.get(0).click();
                } while (!isExist(loginPageObject.first_login_btn));
            } else {
                do {
                    waitUntilPresentOfElementBy(loginPageObject.message_Login_btn_By_MM);
                    loginPageObject.message_Login_btn_MM.get(0).click();
                } while (!isExist(loginPageObject.first_login_btn_MM));
            }
        } else if (screen.equalsIgnoreCase("facebook")) {
            if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
               waitUntilPresentOfElementBy(loginPageObject.facebook_Login_btn_By);
                loginPageObject.facebook_Login_btn.click();
                waitUntilPresentOfElementBy(loginPageObject.facebook_Agree_btn_By);
                loginPageObject.facebook_Agree_btn.click();
            }
            else
            {
                waitUntilPresentOfElementBy(loginPageObject.facebook_Login_btn_By_MM);
                loginPageObject.facebook_Login_btn_MM.click();
                waitUntilPresentOfElementBy(loginPageObject.facebook_Agree_btn_By_MM);
                loginPageObject.facebook_Agree_btn_MM.click();
            }

        } else {
            waitUntilPresentOfElementByString("Login");
            findElementByExactString("Login").click();
        }
    }

    public boolean verifyTheLoginPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return isExist(wishlistPageObjects.email_Login_btn);
        } else {
            return isExist(wishlistPageObjects.email_Login_btn_MM);
        }
    }

    public boolean verifyTheLogin() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.loginID_lbl_By);
            return (!loginPageObject.loginID_lbl.getText().equalsIgnoreCase(""));
        } else {
            waitUntilPresentOfElementBy(loginPageObject.loginID_lbl_By_MM);
            return (!loginPageObject.loginID_lbl_MM.getText().equalsIgnoreCase(""));
        }
    }

    public void selectForgetPasswordLink() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.login_Email_btn_By);
            loginPageObject.login_Email_btn.click();
            waitUntilPresentOfElementBy(loginPageObject.forget_password_New_lbl_By);
            loginPageObject.forget_password_New_lbl.click();

        } else {
            waitUntilPresentOfElementBy(loginPageObject.login_Email_btn_By_MM);
            loginPageObject.login_Email_btn_MM.click();
            waitUntilPresentOfElementBy(loginPageObject.forget_password_New_lbl_By_MM);
            loginPageObject.forget_password_New_lbl_MM.click();
        }
    }

    public boolean verifyTheResetPassword() {
        return waitWithoutExceptionByTextContains("Reset Password");
    }

    public void enterLoginEmail() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.final_Email_Login_btn_By);
            switch (System.getProperty("env")) {
                case "pk.live":
                    loginPageObject.login_Email_Final_txt.get(0).sendKeys(loginGetProperty.loginEmail().get(0));
                    break;
                case "bd.live":
                    loginPageObject.login_Email_Final_txt.get(0).sendKeys(loginGetProperty.loginEmail().get(1));
                    break;
                case "lk.live":
                    loginPageObject.login_Email_Final_txt.get(0).sendKeys(loginGetProperty.loginEmail().get(2));
                    break;
                case "np.live":
                    loginPageObject.login_Email_Final_txt.get(0).sendKeys(loginGetProperty.loginEmail().get(3));
                    break;
            }
        } else {
            waitUntilPresentOfElementBy(loginPageObject.final_Email_Login_btn_By_MM);
            loginPageObject.login_Email_Final_txt_MM.get(0).sendKeys(loginGetProperty.loginEmail().get(4));
        }
    }

    public void enterLoginPassword() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            loginPageObject.login_Email_Final_txt.get(1).sendKeys(loginGetProperty.loginPassword());
        } else {
            loginPageObject.login_Email_Final_txt_MM.get(1).sendKeys(loginGetProperty.loginPassword());
        }
    }

    public void clickLoginButton() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            loginPageObject.final_Email_Login_btn.click();
        } else {
            loginPageObject.final_Email_Login_btn_MM.click();
        }
    }

    public void selectCreateAccountPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.login_btn_By);
            loginPageObject.create_Account_lbl.click();
        } else {
            waitUntilPresentOfElementBy(loginPageObject.login_btn_By_MM);
            loginPageObject.create_Account_lbl_MM.click();
        }
    }

    public boolean verifyTheCreateAccountPage()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.register_page_txt_By);
            return (isExist(loginPageObject.register_page_txt));
        }
        else
        {
            waitUntilPresentOfElementBy(loginPageObject.register_page_txt_By_MM);
            return (isExist(loginPageObject.register_page_txt_MM));
        }
    }

    public void selectFacebookAgreeButton()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (waitWithoutExceptionForElements(wishlistPageObjects.login_Policy_Agree_btn))
                wishlistPageObjects.login_Policy_Agree_btn.get(0).click();
        } else {
            if (waitWithoutExceptionForElements(wishlistPageObjects.login_Policy_Agree_btn_MM))
                wishlistPageObjects.login_Policy_Agree_btn_MM.get(0).click();
        }
    }

    public void selectFirstLoginButton()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitForElementByWithoutExceptionUntillTimeReach(loginPageObject.login_Email_btn_By, 3);
            loginPageObject.login_Email_btn.click();
        }
        else
        {
            waitForElementByWithoutExceptionUntillTimeReach(loginPageObject.login_Email_btn_By_MM, 3);
            loginPageObject.login_Email_btn_MM.click();
        }
    }
}