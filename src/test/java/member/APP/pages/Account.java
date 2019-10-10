package member.APP.pages;

import member.APP.pageObjects.AccountPageObject;
import global.APP.pageObjects.CheckOutPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.GmailSignUpObjects;
import member.APP.pageObjects.WishlistPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-July-2019
 */

public class Account extends Base
{
    private AccountPageObject accountPageObect = new  AccountPageObject();
    private GmailSignUpObjects gmailSignUpObjects = new GmailSignUpObjects();
    private CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();
    private WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();

    public Account(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountPageObect);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gmailSignUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
    }

    public boolean verifySignin()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(gmailSignUpObjects.account_Holder_Name_lbl_By);
            return (!(gmailSignUpObjects.account_Holder_Name_lbl.getText().equalsIgnoreCase("")));
        }
        else
        {
            waitUntilPresentOfElementBy(gmailSignUpObjects.account_Holder_Name_lbl_By_MM);
            return (!(gmailSignUpObjects.account_Holder_Name_lbl_MM.getText().equalsIgnoreCase("")));
        }
    }

    public void navigateToAccountFromPaymentScreen()
    {
        if (System.getProperty("env").equalsIgnoreCase("np.live")) {
            waitWithoutException(checkOutPageObjects.cod_lbl_MM);
            do {
                driver.navigate().back();
            } while(!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        }
        else if(System.getProperty("env").equalsIgnoreCase("mm.live"))
            {
                waitWithoutException(checkOutPageObjects.cod_lbl_MM);
                do {
                    driver.navigate().back();
                } while(!(isExist(wishlistPageObjects.dots_btn_MM)));
                wishlistPageObjects.dots_btn_MM.get(0).click();
                waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
                wishlistPageObjects.my_Account_menuItem.click();
            }
         else {
            waitWithoutException(checkOutPageObjects.cod_lbl);
            do {
                driver.navigate().back();
            } while(!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        }
    }

    public boolean verifyProductOnPayNowScreen(String productName)
    {
        waitUntilPresentOfElementByString(productName);
        return productName.contains(findElementByString(productName).getAttribute("contentDescription"));
    }

    public void selectPayNowWidigt()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(accountPageObect.my_Account_widget_By);
            accountPageObect.my_Account_widget.get(0).click();
        }
        else
        {
            waitUntilPresentOfElementBy(accountPageObect.my_Account_widget_By_MM);
            accountPageObect.my_Account_widget_MM.get(0).click();
        }
    }

    public void selectMyCancellationWidget()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(accountPageObect.my_Account_widget_By);
            accountPageObect.my_Account_widget.get(3).click();
        }
        else
        {
            waitUntilPresentOfElementBy(accountPageObect.my_Account_widget_By_MM);
            accountPageObect.my_Account_widget_MM.get(3).click();
        }
    }

    public void navigateToMyAccountFromCancellation()
    {

        if (System.getProperty("env").equalsIgnoreCase("np.live")) {
            do {
                driver.navigate().back();
            } while(!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        }
        else if(System.getProperty("env").equalsIgnoreCase("mm.live"))
        {
            do {
                driver.navigate().back();
            } while(!(isExist(wishlistPageObjects.dots_btn_MM)));
            wishlistPageObjects.dots_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        }
        else {
            do {
                driver.navigate().back();
            } while(!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        }
    }
    }


