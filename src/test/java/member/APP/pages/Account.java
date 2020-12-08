package member.APP.pages;

import member.APP.pageObjects.*;
import global.APP.pageObjects.CheckOutPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-July-2019
 */

public class Account extends Base {
    public Object clickAccountInformation;
    private AccountPageObject accountPageObect = new AccountPageObject();
    private GmailSignUpObjects gmailSignUpObjects = new GmailSignUpObjects();
    private CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();
    private WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();
    SignUpObjects signUpObjects = new SignUpObjects();
    LoginPageObject loginPageObject = new LoginPageObject();
    String trackPackage = "Track Package";
    String ConsolidateDelivery = "Consolidated Delivery";
    String packageStatus = "";

    public Account(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountPageObect);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gmailSignUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountPageObect);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObject);
    }

    public boolean verifySignin() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(gmailSignUpObjects.account_Holder_Name_lbl_By);
            return (!(gmailSignUpObjects.account_Holder_Name_lbl.getText().equalsIgnoreCase("")));
        } else {
            waitUntilPresentOfElementBy(gmailSignUpObjects.account_Holder_Name_lbl_By_MM);
            return (!(gmailSignUpObjects.account_Holder_Name_lbl_MM.getText().equalsIgnoreCase("")));
        }
    }

    public void navigateToAccountFromPaymentScreen() {
        if (System.getProperty("env").equalsIgnoreCase("np.live")) {
//            try {
//                waitUntilPresentOfElementBy(checkOutPageObjects.cod_lbl_MM_By);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            do {
                driver.navigate().back();
            } while (!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        } else if (System.getProperty("env").equalsIgnoreCase("mm.live")) {
//            try {
//                waitUntilPresentOfElementBy(checkOutPageObjects.cod_lbl_MM_By);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            do {
                driver.navigate().back();
            } while (!(isExist(wishlistPageObjects.dots_btn_MM)));
            wishlistPageObjects.dots_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        } else {
//            try {
//                waitUntilPresentOfElementBy(checkOutPageObjects.cod_lbl_MM_By);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            do {
                driver.navigate().back();
            } while (!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        }
    }

    public boolean verifyProductOnPayNowScreen(String productName) {
//        waitUntilPresentOfElementByString(productName);
//        return productName.contains(findElementByString(productName).getAttribute("contentDescription"));
        return waitWithoutExceptionByString(productName);
    }

    public void selectPayNowWidigt() {
//        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
//            waitUntilPresentOfElementBy(accountPageObect.my_Account_widget_By);
//            accountPageObect.my_Account_widget.get(0).click();
//        } else {
//            waitUntilPresentOfElementBy(accountPageObect.my_Account_widget_By_MM);
//            accountPageObect.my_Account_widget_MM.get(0).click();
//        }
        if (waitWithoutExceptionByTextContainsLessTime("To Pay")) {
            waitUntilPresentOfElementByText("To Pay");
            findElementByTextUsingExactString("To Pay").click();
        }
    }

    public void selectMyCancellationWidget() {
        waitUntilPresentOfElementByText("My Cancellations");
        findElementByTextUsingExactString("My Cancellations").click();
    }

    public void navigateToMyAccountFromCancellation() {

        if (System.getProperty("env").equalsIgnoreCase("np.live")) {
            do {
                driver.navigate().back();
            } while (!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        } else if (System.getProperty("env").equalsIgnoreCase("mm.live")) {
            do {
                driver.navigate().back();
            } while (!(isExist(wishlistPageObjects.dots_btn_MM)));
            wishlistPageObjects.dots_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        } else {
            do {
                driver.navigate().back();
            } while (!(isExist(wishlistPageObjects.dots_btn)));
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
        }
    }

    public void navigateToAccounts() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By);
            try {
                signUpObjects.account_lbl.get(3).click();
            } catch (Exception e) {
                e.printStackTrace();
                findElementByTextUsingContainsString("Account").click();
            }
        } else {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By_MM);
            try {
                signUpObjects.account_lbl_MM.get(3).click();
            } catch (Exception e) {
                e.printStackTrace();
                findElementByTextUsingContainsString("Account").click();
            }
        }
    }

    public void navigateToTheMessages() {
        waitUntilPresentOfElementByText("Messages");
        findElementByTextUsingContainsString("Messages").click();
    }

    public boolean iShouldBeOnMessagePage() {
        return isExistByText("Messages");
    }

    public void navigateToPoliciesFromSettings() {
        waitWithoutExceptionByTextContains("Policies");
        findElementByTextUsingContainsString("Policies").click();
    }

    public boolean iShouldBeOnThePoliciesPage() {
        waitWithoutExceptionByTextContains("Terms & Conditions");
        return isExistByText("Policies");
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateToHelpFromSettingsMenu(String arg0) {
        waitWithoutExceptionByTextContains(arg0);
        findElementByTextUsingContainsString(arg0).click();
    }

    public void navigateToBySearchingText(String arg0) {
        waitWithoutExceptionByTextContains(arg0);
        findElementByTextUsingContainsString(arg0).click();
    }

    public boolean iShouldBeOnTheHelpMenu() {
        return waitForElementByWithoutExceptionUntillTimeReach(accountPageObect.help_Page_Text_By, 20);
    }

    public boolean verifySettingsHeaderInLocalLanguage() {
        switch (System.getProperty("env")) {
            case "bd.live": {
                return waitWithoutExceptionByTextContains("সেটিং");
            }

            case "lk.live": {
                return waitWithoutExceptionByTextContains("කට්ටල අංග");
            }

            case "np.live": {
                return waitWithoutExceptionByTextContains("सेटिङ्हरू");
            }

            case "mm.live": {
                return waitWithoutExceptionByTextContains("ျပင္ဆင္မွဳမ်ား");
            }
            default: {
                throw new RuntimeException("Language change is not applicable for this venture");
            }
        }
    }

    public void navigateToMessageSettings() {
        waitWithoutExceptionByTextContains("Messages");
        findElementByTextUsingContainsString("Messages").click();
    }

    public boolean iShouldBeOnTheMessageSettingsPage() {
        return waitWithoutExceptionByTextContains("Promo Messages");
    }

    public boolean verifyTheExistenceOfWishlistFollowedStoreAndVoucher(boolean walletExistence) {
        if (walletExistence) {
            return (isExistByText("My Wishlist") && isExistByText("Followed Stores") && containsTextIsExist("Daraz Wallet"));
        } else {
            return (isExistByText("My Wishlist") && isExistByText("Followed Stores") && containsTextIsExist("Vouchers"));

        }
    }

    public void navigateToDarazWalletORVoucherFromAccounts(boolean walletExistence) {
        if (walletExistence) {
            if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
//                accountPageObect.wallet_Activate_Now_lbl.click();
                accountPageObect.wallet_New_Activate_Now_lbl.click();
            else
//                accountPageObect.wallet_Activate_Now_lbl_MM.click();
                accountPageObect.wallet_New_Activate_Now_lbl_MM.click();
        } else {
            findElementByTextUsingContainsString("Vouchers").click();
        }
    }

    public boolean iShouldBeOnTheDarazWalletOrVoucherPage(boolean walletExistence) {
        if (walletExistence) {
            return waitWithoutExceptionByText("My Wallet");
        } else {
            return waitWithoutExceptionByText("My Voucher");
        }
    }

    public boolean verifyTheExistenceOfRedDotOnMessage() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (isExist(accountPageObect.my_Account_widget.get(4).findElements(accountPageObect.red_Dot_lbl_By))) {
//                 return ((Integer.parseInt(accountPageObect.my_Account_widget.get(4).findElement(accountPageObect.red_Dot_lbl_By).getText().replaceAll("[^\\d.]", "")) > 0 &&(Integer.parseInt(accountPageObect.red_Dot_lbl.get(0).getText().replaceAll("[^\\d.]", ""))== Integer.parseInt(accountPageObect.red_Dot_lbl.get(1).getText().replaceAll("[^\\d.]", "")))));
                return ((Integer.parseInt(accountPageObect.my_Account_widget.get(4).findElement(accountPageObect.red_Dot_lbl_By).getText().replaceAll("[^\\d.]", "")) > 0));
            } else
                return true;
        } else {
            if (isExist(accountPageObect.Account_widget_MM.get(4).findElements(accountPageObect.red_Dot_lbl_MM_By))) {
                return ((Integer.parseInt(accountPageObect.my_Account_widget_MM.get(4).findElement(accountPageObect.red_Dot_lbl_MM_By).getText().replaceAll("[^\\d.]", "")) > 0));
            } else
                return true;
        }
    }

    public void navigateToAccountSettingsInLocalLanguage() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By);
            try {
                signUpObjects.account_lbl.get(3).click();
            } catch (Exception e) {
                e.printStackTrace();
                if ((System.getProperty("env").equalsIgnoreCase("bd.live")))
                    findElementByTextUsingExactString("অ্যাকাউন্ট").click();
                else if ((System.getProperty("env").equalsIgnoreCase("lk.live")))
                    findElementByTextUsingExactString("ගිණුම").click();
                else if ((System.getProperty("env").equalsIgnoreCase("np.live")))
                    findElementByTextUsingExactString("खाता").click();
            }
            waitUntilPresentOfElementBy(signUpObjects.settings_icon_By);
            signUpObjects.settings_icon.click();
        } else {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By_MM);
            try {
                signUpObjects.account_lbl_MM.get(3).click();
            } catch (Exception e) {
                e.printStackTrace();
                findElementByTextUsingExactString("အေကာင့္").click();
            }
            waitUntilPresentOfElementBy(signUpObjects.settings_icon_By_MM);
            signUpObjects.settings_icon_MM.click();
        }
    }

    public boolean verifyTheComponentsOfMyServices() {
        scrollDownMultipleTries(2);
        return (containsTextIsExist("Messages")
                && containsTextIsExist("My Review")
                && containsTextIsExist("Payment")
                && containsTextIsExist("Help"));
    }

    public void selectAvatar() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            accountPageObect.avatar_img.click();
        else
            accountPageObect.avatar_img_MM.click();
    }

    public boolean verifyTheExistenceOfTakePhotoAndSelectFromAlbum() {
        waitWithoutExceptionByTextContains("Take photo");
        return (isExistByText("Take photo") && isExistByText("Select from album") && isExistByText("Cancel"));
    }

    public boolean verifyTheExistenceOfTheTrackPackage() {
        return (waitWithoutExceptionByText(trackPackage));
    }

    public boolean verifyTheSameOrderStatusOnConsolidatedDeliveryScreen() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            for (int i = 0; i < accountPageObect.track_Package_Slider.size() - 2; i++) {
                int j = 0;
                waitUntilPresentOfElementBy(accountPageObect.track_Package_lbl_By);
                while (j < i) {
                    swipeHorizontallyToZeroWithInElement(accountPageObect.package_Date_And_Time_lbl);
                    j++;
                }
//                waitForElementToClickable(accountPageObect.package_Status_lnk);
                packageStatus = accountPageObect.package_Status_lnk.getText().replaceAll(" >", "");
                accountPageObect.package_Status_lnk.click();
                if (!waitWithoutExceptionByText(ConsolidateDelivery))
                    return false;

                if (!findElementsSizeByString(packageStatus))
                    return false;
                driver.navigate().back();

            }
        } else {
            for (int i = 0; i < accountPageObect.track_Package_Slider.size() - 2; i++) {
                int j = 0;
                waitUntilPresentOfElementBy(accountPageObect.track_Package_lbl_By_MM);
                while (j < i) {
                    swipeHorizontallyToZeroWithInElement(accountPageObect.package_Date_And_Time_lbl_MM);
                    j++;
                }
//                waitForElementToClickable(accountPageObect.package_Status_lnk_MM);
                packageStatus = accountPageObect.package_Status_lnk_MM.getText().replaceAll(" >", "");
                accountPageObect.package_Status_lnk_MM.click();
                if (!waitWithoutExceptionByText(ConsolidateDelivery))
                    return false;

                if (!findElementsSizeByString(packageStatus))
                    return false;
                driver.navigate().back();
            }
        }
        return true;
    }

    public void scrollToMessage() {
        int tries = 0;
        while (!containsTextIsExist("My Review") && tries < 5) {
            swiptToBottom();
            tries++;
        }
    }

    public boolean verifyTheOrderStatusOnAccountPage(List<String> orderStatuslst, List<String> orderStatuslst2, List<String> orderID) {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            for (int i = 0; i < 3; i++) {
                if (waitWithoutExceptionByTextContains(orderStatuslst.get(i))) {
                    findElementByTextUsingContainsString(orderStatuslst.get(i)).click();
                    if (!waitWithoutExceptionByString(orderStatuslst.get(i))) {
                        return false;
                    } else
                        driver.navigate().back();
                } else
                    return false;
            }
            for (int i = 0; i < 3; i++) {
                if (waitWithoutExceptionByTextContains(orderStatuslst2.get(i))) {
                    findElementByTextUsingContainsString(orderStatuslst2.get(i)).click();
                    if (!containsTextIsExist(orderStatuslst2.get(i))) {
                        return false;
                    }
                    driver.navigate().back();
                } else
                    return false;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (waitWithoutExceptionByTextContains(orderStatuslst.get(i))) {
                    findElementByTextUsingContainsString(orderStatuslst.get(i)).click();
                    if (!waitWithoutExceptionByString(orderStatuslst.get(i))) {
                        return false;
                    } else
                        driver.navigate().back();
                } else
                    return false;
            }
            for (int i = 0; i < 3; i++) {
                if (waitWithoutExceptionByTextContains(orderStatuslst2.get(i))) {
                    findElementByTextUsingContainsString(orderStatuslst2.get(i)).click();
                    if (!containsTextIsExist(orderStatuslst2.get(i))) {
                        return false;
                    } else
                        driver.navigate().back();
                } else
                    return false;
            }
        }
        return true;
    }

    public boolean verifyTheExistenceofAccountInformation() {
        return (!System.getProperty("env").equalsIgnoreCase("mm.live") ? isExist(accountPageObect.account_Information_tab) : isExist(accountPageObect.account_Information_tab_MM));
    }

    public void iNavigateToAccountInformation() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            accountPageObect.account_Information_tab.get(0).click();
        } else {
            accountPageObect.account_Information_tab_MM.get(0).click();
        }
    }

    public boolean verifyTheExistenceOfAccountInfoTitle() {

        return waitForElementByWithoutExceptionUntillTimeReach(accountPageObect.account_Information_title, 5);
    }

    public void clickMoreOptionsMenu() {
        accountPageObect.more_Options_click.click();
    }

    public WebElement clickHamburgerMenuElements(String arg0) {
        return !(System.getProperty("env").equalsIgnoreCase("mm.live")) ?
                findElementByIdAndText("com.daraz.android:id/title", arg0) :
                findElementByIdAndText("com.shop.android:id/title", arg0);
    }

    public boolean iShouldBeOnMyAccount() {
        return !(System.getProperty("env").equalsIgnoreCase("mm.live")) ?
                accountPageObect.account_Order_Title.isDisplayed() :
                accountPageObect.account_Order_Title_MM.isDisplayed();
    }
}

