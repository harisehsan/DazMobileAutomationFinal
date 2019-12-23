package member.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import member.APP.pageObjects.WishlistPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 14-June-2019
 */

public class Wishlist extends Base {

    WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();
    CartPageObjects cartPageObjects = new CartPageObjects();
    SearchPageObject searchPageObj = new SearchPageObject();
    private int tries=25;

    public Wishlist(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
    }

    public String selectProduct() {
        String productName;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(wishlistPageObjects.product_Name_lbl_By);
            productName = wishlistPageObjects.product_Name_lbl.getText();
            if (productName.startsWith("0 "))
                productName = productName.replace("0 ","");
            return productName;
        } else {
            waitUntilPresentOfElementBy(wishlistPageObjects.product_Name_lbl_MM_By);
            productName = wishlistPageObjects.product_Name_lbl_MM.getText();
            if (productName.startsWith("0 "))
                productName = productName.replace("0 ","");
            return productName;
        }
    }

    public void addToWishlist() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_icon_By);
            wishlistPageObjects.wishlist_icon.click();
        } else {
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
                if (isExist(wishlistPageObjects.use_Another_Account_btn))
                    wishlistPageObjects.accout_ID_lbl.get(0).click();
            }
        } else {
            if (wishlistPageObjects.login_btn_MM.size() > 0) {
                wishlistPageObjects.login_btn_MM.get(0).click();
                waitUntilPresentOfElementBy(wishlistPageObjects.google_btn_By_MM);
                wishlistPageObjects.google_btn_MM.click();
                waitUntilPresentOfElementBy(wishlistPageObjects.agree_btn_by);
                wishlistPageObjects.agree_btn.click();
                if (isExist(wishlistPageObjects.use_Another_Account_btn))
                    wishlistPageObjects.accout_ID_lbl.get(0).click();
            }
        }
    }

    public String wishlistAddSuccessMessage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
//            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By);
            return wishlistPageObjects.wishlist_Success_Message_lbl.getText();
        } else {
//            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By_MM);
            return wishlistPageObjects.wishlist_Success_Message_lbl_MM.getText();
        }
    }

    public String wishlistRemoveSuccessMessage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
//            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By);
            return wishlistPageObjects.wishlist_Success_Message_lbl.getText();
        } else {
//            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Success_Message_lbl_By_MM);
            return wishlistPageObjects.wishlist_Success_Message_lbl_MM.getText();
        }
    }

    public String verifyAddedItemInWishlist(String PRODUCT_NAME) throws InterruptedException {
        String productTitle;
        int tries = 10;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(wishlistPageObjects.dots_btn_By);
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_lbl_By);
            wishlistPageObjects.wishlist_lbl.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
            for (int i = 0;i<tries;i++)
            {
                if(isExistByString(PRODUCT_NAME))
                    break;
                else
                    swiptToBottom();
            }
            findElementByString(PRODUCT_NAME).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.product_Name_lbl_By);
            productTitle = wishlistPageObjects.product_Name_lbl.getText();
            if (productTitle.startsWith("0"))
                productTitle = productTitle.replaceFirst("0 ", "");
            if (productTitle.length() > 15)
                productTitle = productTitle.substring(0,15);
             return productTitle;

        } else {
            waitUntilPresentOfElementBy(wishlistPageObjects.dots_btn_By_MM);
            wishlistPageObjects.dots_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_lbl_By_MM);
            wishlistPageObjects.wishlist_lbl_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
            for (int i = 0; i < tries; i++) {
                if (isExistByString(PRODUCT_NAME))
                    break;
                else
                    swiptToBottom();
            }
            findElementByString(PRODUCT_NAME).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn_MM))
                searchPageObj.ok_Got_It_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.product_Name_lbl_MM_By);
            productTitle = wishlistPageObjects.product_Name_lbl_MM.getText();
            if (productTitle.startsWith("0"))
                productTitle = productTitle.replaceFirst("0 ", "");
            if (productTitle.length() > 15)
                productTitle = productTitle.substring(0, 15);
            return productTitle;
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

    public void deleteSingleItem(String productName)
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {

            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
            for (int i = 0; i < tries; i++) {
                if (isExistByString(productName)) {
                    break;
                } else
                    swiptToBottom();
            }
            do {
                wishlistPageObjects.wishlist_Delete_icon.get(0).click();
                waitUntilPresentOfElementBy(wishlistPageObjects.remove_btn_By);
                wishlistPageObjects.remove_btn.click();
            } while (isExistByString(productName));
        }
        else
        {
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_Delete_icon_By);
            for (int i=0; i<tries;i++) {
                if (isExistByString(productName)) {
                    break;
                }
                else
                    swiptToBottom();
            }
            do {
            wishlistPageObjects.wishlist_Delete_icon.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.remove_btn_By);
            wishlistPageObjects.remove_btn.click();
            }while (isExistByString(productName));
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
        {
            waitUntilPresentOfElementBy(wishlistPageObjects.dots_btn_By);
            wishlistPageObjects.dots_btn.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_lbl_By);
            wishlistPageObjects.wishlist_lbl.get(0).click();
        }
        else
        {
            waitUntilPresentOfElementBy(wishlistPageObjects.dots_btn_By_MM);
            wishlistPageObjects.dots_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(wishlistPageObjects.my_Account_menuItem_By);
            wishlistPageObjects.my_Account_menuItem.click();
            waitUntilPresentOfElementBy(wishlistPageObjects.wishlist_lbl_By_MM);
            wishlistPageObjects.wishlist_lbl_MM.get(0).click();
        }
    }

    public boolean verifyThePresenceOfDeletedItem(String productName)
    {
        return (isExistByCompleteString(productName));
    }

    public boolean verifyTheExistenceOfJustForYou()
    {
        waitWithoutExceptionByTextContains("My Wishlist");
       for (int i=0; i<tries; i++)
       {
         if (isExistByString("Just For You"))
         {
             return true;
         }
         else
             swiptToBottom();
       }
       return false;
    }

    public void addAllToCartButton()
    {
        waitUntilPresentOfElementByString("ADD ALL TO CART");
        findElementByString("ADD ALL TO CART").click();
    }

    public void navigateToCartFromWishList()
    {
        if ((!System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            wishlistPageObjects.cart_Icon_Wishlist.click();
            if(isExist( cartPageObjects.ok_Got_It_btn))
                cartPageObjects.ok_Got_It_btn.get(0).click();
        }
        else
            wishlistPageObjects.cart_Icon_Wishlist_MM.click();
            if(isExist( cartPageObjects.ok_Got_It_btn_MM))
                cartPageObjects.ok_Got_It_btn_MM.get(0).click();
    }

    public boolean verifyTheAddedItemsInCart()
    {
      if ((!System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
            waitUntilPresentOfElementBy(wishlistPageObjects.items_In_Cart_lbl_By);
            return (isExist(wishlistPageObjects.items_In_Cart_lbl));
        }
        else
        {
            waitUntilPresentOfElementBy(wishlistPageObjects.items_In_Cart_lbl_MM_By);
            return (isExist(wishlistPageObjects.items_In_Cart_lbl_MM));
        }
    }

   public boolean verifyTheExistenceOfBackInStockWatchlistOutOfStock()
   {
       if ((!System.getProperty("env").equalsIgnoreCase("mm.live")))
           waitUntilPresentOfElementBy((wishlistPageObjects.cart_Icon_Wishlist_By));
       else
           waitUntilPresentOfElementBy((wishlistPageObjects.cart_Icon_Wishlist_MM_By));
     for (int i=0; i<tries; i++) {
         if (isExistByString("Watchlist") || isExistByString("Out of stock"))
             return true;
         else
             swiptToBottom();
     }
     return false;
   }

   public boolean checkForNoFavouriteItem()
   {
       return (isExistByString("There are no favorites yet."));
   }

   public void clickOnContinueShoppingButton()
   {
       findElementByString("CONTINUE SHOPPING").click();
   }

   public boolean iShouldBeOnTheHomePage()
   {
       if ((!System.getProperty("env").equalsIgnoreCase("mm.live"))) {
           waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By);
           return (isExist(searchPageObj.searchBeforeClick_txtfield));
       }
       else
       {
           waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
           return (isExist(searchPageObj.searchBeforeClick_txtfield_MM));
       }
   }
}