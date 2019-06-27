package global.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-June-2019
 */

public class Cart extends Base {

    CartPageObjects cartPageObjects = new CartPageObjects();

    String PRODUCT_NAME;

    public Cart(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
    }
    public void addToCart()
    {
       cartPageObjects.add_To_Cart_btn.get(0).click();
    }

    public String selectProductForCart() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
            if (cartPageObjects.searchProduct_lbl_MM.size() < 4)
                productNameVisibleScroll();
            for (int i=0; i<=1; ++i) {
                for (int j = 0; j < cartPageObjects.searchProduct_lbl.size(); j++) {
                    waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                    cartPageObjects.searchProduct_lbl.get(j).click();
                    if(waitWithoutException(cartPageObjects.overseas_Confirm_btn))
                        cartPageObjects.overseas_Confirm_btn.click();
                    if (isExist(cartPageObjects.buy_Now_btn))
                        return cartPageObjects.product_Title_lbl.getText();
                    else
                        driver.navigate().back();
                }
                scrollDownMultipleTries(1);
            }

        } else {
            waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_MM_By);
            if (cartPageObjects.searchProduct_lbl_MM.size() < 4)
                 productNameVisibleScroll();
            for (int i=0; i<=1; ++i) {
                for (int j = 0; j < cartPageObjects.searchProduct_lbl_MM.size(); j++) {
                    waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_MM_By);
                    cartPageObjects.searchProduct_lbl_MM.get(j).click();
                    if(waitWithoutException(cartPageObjects.overseas_Confirm_btn_MM))
                        cartPageObjects.overseas_Confirm_btn_MM.click();
                    if (isExist(cartPageObjects.buy_Now_btn_MM))
                        return cartPageObjects.product_Title_lbl_MM.getText();
                    else
                        driver.navigate().back();
                }
                scrollDownMultipleTries(1);
            }
        }
        throw new RuntimeException("There is no product having add to cart option available!");
    }

    public String verifyTheAddedProductBySuccessMessage()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return cartPageObjects.success_Message_lbl.getText();
        else
            return cartPageObjects.success_Message_lbl_MM.getText();
    }

   public void goToCartFromPDP()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
         cartPageObjects.go_To_Cart_btn.click();
        else
          cartPageObjects.go_To_Cart_btn_MM.click();
    }

    public String verifyAddedProductInCart()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            cartPageObjects.ok_Got_It_btn.get(0).click();
            return cartPageObjects.product_Title_In_Cart_lbl.get(0).getText();
        }
        else {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            return cartPageObjects.product_Title_In_Cart_lbl.get(0).getText();
        }
    }

    public void selectCart()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
           waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By);
           cartPageObjects.cart_icon.get(2).click();
        }
        else {
            waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By_MM);
            cartPageObjects.cart_icon_MM.get(2).click();
        }
    }

    public String removeSingleItemFromCart()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
           waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
           cartPageObjects.ok_Got_It_btn.get(0).click();
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to remove!");
               if(cartPageObjects.product_chkbox.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                   cartPageObjects.product_chkbox.get(0).click();
               cartPageObjects.delete_first_btn.click();
               cartPageObjects.delete_second_btn.click();
               cartPageObjects.delete_third_btn.click();
               return PRODUCT_NAME;
           }
        else {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to remove!");
            else {
                PRODUCT_NAME = cartPageObjects.product_Title_In_Cart_lbl.get(0).getText();
                if(cartPageObjects.product_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.product_chkbox_MM.get(0).click();
                cartPageObjects.delete_first_btn_MM.click();
                cartPageObjects.delete_second_btn_MM.click();
                cartPageObjects.delete_third_btn.click();
                return PRODUCT_NAME;
                }
            }
        }

    public String verifyForRemovedItemInCart()
    {
       if (cartPageObjects.product_Title_In_Cart_lbl.size() > 0) {
           if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
               waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By);
           else
               waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By_MM);
           return cartPageObjects.product_Title_In_Cart_lbl.get(0).getText();
       }
       else
          return "";
     }

    public void removeAllItemsFromCart()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            cartPageObjects.ok_Got_It_btn.get(0).click();
            if ((verifyEmptyCart()))
               throw new RuntimeException("There is no item available in cart to remove!");
            if(cartPageObjects.select_All_chkbox.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox.click();
            cartPageObjects.delete_first_btn.click();
            cartPageObjects.delete_second_btn.click();
            cartPageObjects.delete_third_btn.click();
        }
        else {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to remove!");
            if(cartPageObjects.select_All_chkbox.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox.click();
            cartPageObjects.delete_first_btn_MM.click();
            cartPageObjects.delete_second_btn_MM.click();
            cartPageObjects.delete_third_btn.click();
        }
    }

    public boolean verifyEmptyCart()
    {
        return !(isExist(cartPageObjects.product_Title_In_Cart_lbl));
    }

    public void addProductFromCartToWishlist()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            cartPageObjects.ok_Got_It_btn.get(0).click();
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to add to wishlist");
            else
            {
                cartItemSwipeOptions();
                waitUntilPresentOfElementBy(cartPageObjects.wishlist_In_Cart_btn_By);
                cartPageObjects.wishlist_In_Cart_btn.click();

            }
        }
        else {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to add to wishlist");
            else
            {
                cartItemSwipeOptions();
                waitUntilPresentOfElementBy(cartPageObjects.wishlist_In_Cart_btn_By_MM);
                cartPageObjects.wishlist_In_Cart_btn.click();
            }
        }
    }

    public boolean verifyaddedItemInWishList()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (getTextWithoutException(cartPageObjects.success_Message_lbl).equalsIgnoreCase("Successfully added to the wishlist."))
                return true;
            else return (verifyEmptyCart());
        }
        else
        {
            if (getTextWithoutException(cartPageObjects.success_Message_lbl_MM).equalsIgnoreCase("Successfully added to the wishlist."))
                return true;
            else return (verifyEmptyCart());
        }
    }
 }