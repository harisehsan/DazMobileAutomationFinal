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
            loginPageObject.tray_icon.get(1).click();
        } else {
            waitUntilPresentOfElementBy(loginPageObject.tray_icon_By_MM);
            loginPageObject.tray_icon_MM.get(1).click();
        }
    }

    public void selectLogin(String screen) {
        if (screen.equalsIgnoreCase("message")) {
            if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
                waitUntilPresentOfElementBy(loginPageObject.message_Login_btn_By);
                loginPageObject.message_Login_btn.click();
            } else {
                waitUntilPresentOfElementBy(loginPageObject.message_Login_btn_By_MM);
                loginPageObject.message_Login_btn_MM.click();
            }
        } else if (screen.equalsIgnoreCase("facebook")) {
            waitWithoutExceptionByText("Facebook");
            findElementByTextUsingExactString("Facebook").click();

        } else {
            waitUntilPresentOfElementByString("Login");
            findElementByExactString("Login").click();
        }
    }

    public boolean verifyTheLoginPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return isExist(wishlistPageObjects.login_btn);
        } else {
            return isExist(wishlistPageObjects.login_btn_MM);
        }
    }

    public boolean verifyTheLogin() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
//            waitUntilPresentOfElementBy(loginPageObject.loginID_lbl_By);
            return (!loginPageObject.loginID_lbl.getText().equalsIgnoreCase(""));
        } else {
//            waitUntilPresentOfElementBy(loginPageObject.loginID_lbl_By_MM);
            return (!loginPageObject.loginID_lbl_MM.getText().equalsIgnoreCase(""));
        }
    }

    public void selectForgetPasswordLink() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.forget_password_lbl_By);
            loginPageObject.forget_password_lbl.click();
        } else {
            waitUntilPresentOfElementBy(loginPageObject.forget_password_lbl_By_MM);
            loginPageObject.forget_password_lbl_MM.click();
        }
    }

    public boolean verifyTheResetPassword() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return (isExist(loginPageObject.reset_Password_btn));
        } else {
            return (isExist(loginPageObject.reset_Password_btn_MM));
        }
    }

    public void enterLoginEmail() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(loginPageObject.login_btn_By);
            switch (System.getProperty("env")) {
                case "pk.live":
                    loginPageObject.login_Email_txt.sendKeys(loginGetProperty.loginEmail().get(0));
                    break;
                case "bd.live":
                    loginPageObject.login_Email_txt.sendKeys(loginGetProperty.loginEmail().get(1));
                    break;
                case "lk.live":
                    loginPageObject.login_Email_txt.sendKeys(loginGetProperty.loginEmail().get(2));
                    break;
                case "np.live":
                    loginPageObject.login_Email_txt.sendKeys(loginGetProperty.loginEmail().get(3));
                    break;
            }
        } else {
            waitUntilPresentOfElementBy(loginPageObject.login_btn_By_MM);
            loginPageObject.login_Email_txt_MM.sendKeys(loginGetProperty.loginEmail().get(4));
        }
    }

    public void enterLoginPassword() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            loginPageObject.login_Password_txt.sendKeys(loginGetProperty.loginPassword());
        } else {
            loginPageObject.login_Password_txt_MM.sendKeys(loginGetProperty.loginPassword());
        }
    }

    public void clickLoginButton() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            loginPageObject.login_btn.click();
        } else {
            loginPageObject.login_btn_MM.click();
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
       waitUntilPresentOfElementBy(loginPageObject.facebook_Agree_btn_By);
       loginPageObject.facebook_Agree_btn.click();
    }

    public void selectFirstLoginButton()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           waitUntilPresentOfElementBy(loginPageObject.first_login_btn_By);
           loginPageObject.first_login_btn.click();
        }
        else
        {
            waitUntilPresentOfElementBy(loginPageObject.first_login_btn_By_MM);
            loginPageObject.first_login_btn_MM.click();
        }
    }
}
