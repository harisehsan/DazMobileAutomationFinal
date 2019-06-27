package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.WishlistPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 14-June-2019
 */

public class Wishlist extends Base {

    WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();
    public Wishlist(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
    }

    public String selectProduct() {
        String productName;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(wishlistPageObjects.searchProduct_lbl_By);
            productName = wishlistPageObjects.searchProduct_lbl.get(0).getText();
            wishlistPageObjects.searchProduct_lbl.get(0).click();
            return productName;
        } else {
            waitUntilPresentOfElementBy(wishlistPageObjects.searchProduct_lbl_MM_By);
            productName = wishlistPageObjects.searchProduct_lbl_MM.get(0).getText();
            wishlistPageObjects.searchProduct_lbl_MM.get(0).click();
            return productName;
        }
    }

    public void addToWishlist() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (wishlistPageObjects.overseas_Confirm_btn.size() > 0)
                wishlistPageObjects.overseas_Confirm_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_icon_By);
            wishlistPageObjects.wishlist_icon.click();
        } else {
            if (wishlistPageObjects.overseas_Confirm_btn_MM.size() > 0)
                wishlistPageObjects.overseas_Confirm_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_icon_By_MM);
            wishlistPageObjects.wishlist_icon_MM.click();
        }
    }

    public void signin() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (wishlistPageObjects.login_btn.size() > 0) {
                wishlistPageObjects.login_btn.get(0).click();
                waitUntilPresentOfElementBy(wishlistPageObjects.google_btn_By);
                wishlistPageObjects.google_btn.click();
                waitUntilPresentOfElementBy(wishlistPageObjects.agree_btn_by);
                wishlistPageObjects.agree_btn.click();
                if (waitWithoutException(wishlistPageObjects.use_Another_Account_btn))
                    wishlistPageObjects.accout_ID_lbl.get(0).click();
            }
        } else {
            if (wishlistPageObjects.login_btn_MM.size() > 0) {
                wishlistPageObjects.login_btn_MM.get(0).click();
                waitUntilPresentOfElementBy(wishlistPageObjects.google_btn_By_MM);
                wishlistPageObjects.google_btn_MM.click();
                waitUntilPresentOfElementBy(wishlistPageObjects.agree_btn_by);
                wishlistPageObjects.agree_btn.click();
                if (waitWithoutException(wishlistPageObjects.use_Another_Account_btn))
                    wishlistPageObjects.accout_ID_lbl.get(0).click();
            }
        }
    }

    public String wishlistAddSuccessMessage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By);
            return wishlistPageObjects.wishlist_Success_Message_lbl.getText();
        } else {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By_MM);
            return wishlistPageObjects.wishlist_Success_Message_lbl_MM.getText();
        }
    }

    public String wishlistRemoveSuccessMessage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By);
            return wishlistPageObjects.wishlist_Success_Message_lbl.getText();
        } else {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By_MM);
            return wishlistPageObjects.wishlist_Success_Message_lbl_MM.getText();
        }
    }

    public String verifyAddedItemInWishlist(String PRODUCT_NAME) throws InterruptedException {
        String productTitle;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            wishlistPageObjects.go_To_Wishlist_btn.click();
            waitUntilPresentOfElementByString(PRODUCT_NAME);
            findElementByString(PRODUCT_NAME).click();
            if (wishlistPageObjects.product_Name_lbl.getText().startsWith("0")) {
                productTitle = wishlistPageObjects.product_Name_lbl.getText().replaceFirst("0 ", "");
                return productTitle;
            } else
                return wishlistPageObjects.product_Name_lbl.getText();
        } else {
            wishlistPageObjects.go_To_Wishlist_btn_MM.click();
            waitUntilPresentOfElementByString(PRODUCT_NAME);
            findElementByString(PRODUCT_NAME).click();
            if (wishlistPageObjects.product_Name_lbl_MM.getText().startsWith("0")) {
                productTitle = wishlistPageObjects.product_Name_lbl_MM.getText().replaceFirst("0 ", "");
                return productTitle;
            } else
                return wishlistPageObjects.product_Name_lbl_MM.getText();
        }

    }

    public void navigate_To_Login_Screen() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(wishlistPageObjects.account_lbl_By);
            wishlistPageObjects.account_lbl.get(3).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.login_Signup_btn_By);
            wishlistPageObjects.login_Signup_btn.click();
        } else {
            waitUntilPresentOfElementBy(wishlistPageObjects.account_lbl_By_MM);
            wishlistPageObjects.account_lbl_MM.get(3).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.login_Signup_btn_By_MM);
            wishlistPageObjects.login_Signup_btn_MM.click();
        }
    }

    public void openWishlist() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_lbl_By);
            if (Integer.parseInt(wishlistPageObjects.wishlist_lbl.get(0).getText()) == 0)
                throw new RuntimeException("Wishlist has no item!");
            else
                wishlistPageObjects.wishlist_lbl.get(0).click();

        } else {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_lbl_By_MM);
            if (Integer.parseInt(wishlistPageObjects.wishlist_lbl_MM.get(0).getText()) == 0)
                throw new RuntimeException("Wishlist has no item!");
            else
                wishlistPageObjects.wishlist_lbl_MM.get(0).click();
        }
    }

    public void deleteSingleItem()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
            wishlistPageObjects.wishlist_Delete_icon.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.remove_btn_By);
            wishlistPageObjects.remove_btn.click();
        }
        else
        {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
            wishlistPageObjects.wishlist_Delete_icon.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.remove_btn_By);
            wishlistPageObjects.remove_btn.click();
        }
    }

    public void deleteAllItems()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            while(wishlistPageObjects.wishlist_Delete_icon.size() > 0) {
                waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
                wishlistPageObjects.wishlist_Delete_icon.get(0).click();
                waitUntilPresentOfElementBy(wishlistPageObjects.remove_btn_By);
                wishlistPageObjects.remove_btn.click();
            }
        }
        else
        {
            while(wishlistPageObjects.wishlist_Delete_icon.size() > 0) {
                waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
                wishlistPageObjects.wishlist_Delete_icon.get(0).click();
                waitUntilPresentOfElementBy(wishlistPageObjects.remove_btn_By);
                wishlistPageObjects.remove_btn.click();
            }

            }
    }

    public boolean verifyEmptyWishlist()
    {
        return (wishlistPageObjects.wishlist_Delete_icon.size() <= 0);
    }

    public void goToWishlistFromPDPScreen()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            wishlistPageObjects.go_To_Wishlist_btn.click();
        else
            wishlistPageObjects.go_To_Wishlist_btn_MM.click();
    }

    public boolean verifyThePresenceOfDeletedItem(String productName)
    {
        waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
        return (isExistByString(productName));
    }


}

