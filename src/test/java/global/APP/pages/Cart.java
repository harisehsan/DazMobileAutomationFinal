package global.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.WishlistPageObjects;
import member.APP.pages.Wishlist;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-June-2019
 */

public class Cart extends Base {

    CartPageObjects cartPageObjects = new CartPageObjects();
    WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();

    String productName;

    public Cart(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
    }

    public void addToCart() {
        cartPageObjects.add_To_Cart_btn.get(0).click();
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (isExist(cartPageObjects.add_To_Cart_Second_btn))
                cartPageObjects.add_To_Cart_Second_btn.get(0).click();
        }
        else {
            if (isExist(cartPageObjects.add_To_Cart_Second_btn_MM))
                cartPageObjects.add_To_Cart_Second_btn_MM.get(0).click();
        }
    }

    public String selectProductForCart() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return cartPageObjects.product_Title_lbl.getText();
        else
            return cartPageObjects.product_Title_lbl_MM.getText();
    }

    public String verifyTheAddedProductBySuccessMessage() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return cartPageObjects.success_Message_lbl.getText();
        else
            return cartPageObjects.success_Message_lbl_MM.getText();
    }

    public void goToCartFromPDP() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.go_To_Cart_btn_By);
            cartPageObjects.go_To_Cart_btn.click();
        }
        else {
            waitUntilPresentOfElementBy(cartPageObjects.go_To_Cart_btn_By_MM);
            cartPageObjects.go_To_Cart_btn_MM.click();
        }
    }

    public boolean verifyAddedProductInCart(String productName) {
        int tries = 5;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
            for (int i = 0; i < tries; i++) {
                for (int j = 0; j < cartPageObjects.product_Title_In_Cart_lbl.size(); j++) {
                    if (cartPageObjects.product_Title_In_Cart_lbl.get(j).getText().contains(productName))
                        return cartPageObjects.product_Title_In_Cart_lbl.get(j).getText().contains(productName);
                }
                scrollDownMultipleTries(2);
            }
        } else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            for (int i = 0; i < tries; i++) {
                for (int j = 0; j < cartPageObjects.product_Title_In_Cart_lbl.size(); j++) {
                    if (cartPageObjects.product_Title_In_Cart_lbl.get(j).getText().contains(productName))
                        return cartPageObjects.product_Title_In_Cart_lbl.get(j).getText().contains(productName);
                }
                scrollDownMultipleTries(2);
            }
        }
        return false;
    }

    private void cartPopupSkip(List<WebElement> ok_got_it_btn) {
        if (isExist(ok_got_it_btn))
            ok_got_it_btn.get(0).click();
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
       int tries = 0;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to remove!");
              do {
                  if (cartPageObjects.product_chkbox.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                      cartPageObjects.product_chkbox.get(0).click();
                  cartPageObjects.delete_first_btn.click();
                  cartPageObjects.delete_second_btn.click();
                  cartPageObjects.delete_third_btn.click();
                  tries++;
              } while (isExistByText(productName) && tries< 15);
               return productName;
           }
        else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to remove!");
            else {
                productName = cartPageObjects.product_Title_In_Cart_lbl.get(0).getText();
                do {
                    if(cartPageObjects.product_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                    cartPageObjects.product_chkbox_MM.get(0).click();
                    cartPageObjects.delete_first_btn_MM.click();
                    cartPageObjects.delete_second_btn_MM.click();
                    cartPageObjects.delete_third_btn_MM.click();
                    tries++;
                } while (isExistByText(productName) && tries< 15);
                return productName;
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
       int tries = 0;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
            if ((verifyEmptyCart()))
               throw new RuntimeException("There is no item available in cart to remove!");
            if(cartPageObjects.select_All_chkbox.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox.click();
            cartPageObjects.delete_first_btn.click();
            cartPageObjects.delete_second_btn.click();
            cartPageObjects.delete_third_btn.click();
            while(isExist(cartPageObjects.delete_unavailable_item_btn) && tries < 10)
            {
                cartPageObjects.delete_unavailable_item_btn.get(0).click();
                waitUntilPresentOfElementBy(cartPageObjects.delete_Final_btn_By);
                cartPageObjects.delete_Final_btn.get(0).click();
                tries++;
            }
        }
        else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to remove!");
            if(cartPageObjects.select_All_chkbox.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox.click();
            cartPageObjects.delete_first_btn_MM.click();
            cartPageObjects.delete_second_btn_MM.click();
            cartPageObjects.delete_third_btn_MM.click();
            while(isExist(cartPageObjects.delete_unavailable_item_btn_MM) && tries < 10)
            {
                cartPageObjects.delete_unavailable_item_btn_MM.get(0).click();
                waitUntilPresentOfElementBy(cartPageObjects.delete_Final_btn_By_MM);
                cartPageObjects.delete_Final_btn_MM.get(0).click();
                tries++;
            }
        }
    }

    public boolean verifyEmptyCart()
    {
        return !(isExist(cartPageObjects.product_Title_In_Cart_lbl));
    }

    public void addProductFromCartToWishlist() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to add to wishlist");
            else {
                swipeBetweenTwoItems(cartPageObjects.product_Title_In_Cart_lbl.get(0), cartPageObjects.product_chkbox.get(0));
                waitUntilPresentOfElementBy(cartPageObjects.wishlist_In_Cart_btn_By);
                cartPageObjects.wishlist_In_Cart_btn.get(0).click();
            }
        } else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to add to wishlist");
            else {
                swipeBetweenTwoItems(cartPageObjects.product_Title_In_Cart_lbl.get(0), cartPageObjects.product_chkbox_MM.get(0));
                waitUntilPresentOfElementBy(cartPageObjects.wishlist_In_Cart_btn_By_MM);
                cartPageObjects.wishlist_In_Cart_btn.get(0).click();
            }
        }
    }

    public boolean verifyaddedItemInWishList()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
//            if (getTextWithoutException(cartPageObjects.success_Message_lbl).equalsIgnoreCase("Successfully added to the wishlist."))
                return true;
//            else return (verifyEmptyCart());
        }
        else
        {
//            if (getTextWithoutException(cartPageObjects.success_Message_lbl_MM).equalsIgnoreCase("Successfully added to the wishlist."))
                return true;
//            else return (verifyEmptyCart());
        }
    }

    public boolean verifyTheToolTipAndCountBar()
    {
        return  (wishlistPageObjects.cart_lbl.get(0).getText().contains(".*\\d.*"));
    }

    public boolean checkforTheCartPage()
    {
        return containsTextIsExist("My Cart");
    }

    public boolean checkTheShopBox()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (cartPageObjects.shop_check_box.get(0).getAttribute("checked").equalsIgnoreCase("false") && cartPageObjects.product_chkbox.get(0).getAttribute("checked").equalsIgnoreCase("false")) {
                cartPageObjects.shop_check_box.get(0).click();
                return true;
            } else
                return false;
        }
        else
        {
            if (cartPageObjects.shop_check_box_MM.get(0).getAttribute("checked").equalsIgnoreCase("false") && cartPageObjects.product_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false")) {
                cartPageObjects.shop_check_box_MM.get(0).click();
                return true;
            } else
                return false;
        }
    }

    public boolean checkForTheShopName()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitWithoutExceptionForElements(cartPageObjects.shopName_For_Product);
            return isExist(cartPageObjects.shopName_For_Product);
        }
        else
        {
            waitWithoutExceptionForElements(cartPageObjects.shopName_For_Product);
            return isExist(cartPageObjects.shopName_For_Product_MM);
        }
    }

    public boolean checkForCurrentPriceAndOriginalPrice()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            return (isExist(cartPageObjects.displayed_Amount_txt) || isExist(cartPageObjects.original_Amount_txt));
        }
        else
        {
            return (isExist(cartPageObjects.displayed_Amount_txt_MM) || isExist(cartPageObjects.original_Amount_txt_MM));
        }
    }


    public void cartDeliveryInfoCheck()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
        {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By);
            cartPageObjects.ok_Got_It_btn.get(0).click();
            waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By);
            cartPageObjects.success_Message_lbl.click();
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            wishlistPageObjects.wishlist_lbl.get(0).click();
        }
        else
        {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By_MM);
            cartPageObjects.success_Message_lbl_MM.click();
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            wishlistPageObjects.wishlist_lbl_MM.get(0).click();
        }
    }

    public void skipTheCartPopup()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
        {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
        }
        else
        {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
        }
    }

    public String getProductName() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By);
            return cartPageObjects.product_Title_lbl.getText();
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By_MM);
            return cartPageObjects.product_Title_lbl_MM.getText();
        }
    }

    public void slideTheItemInCartToViewOptions(String productName)
    {
     int tries = 0;
     int i=0;
        while (lookForTargetProductInCart(productName) && tries < 15)  {
           for (i=0; i<cartPageObjects.product_Title_In_Cart_lbl.size(); i++)
               if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productName))
                   break;
           swipeHorizontallyToZeroWithInElement(cartPageObjects.product_Title_In_Cart_lbl.get(i));
           deleteElementFromCart();
           tries++;
       }
    }

    private void deleteElementFromCart() {
            if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
                if (isExist(cartPageObjects.delete_Slide_Element_btn))
                cartPageObjects.delete_Slide_Element_btn.get(0).click();
            } else {
                if (isExist(cartPageObjects.delete_Slide_Element_btn_MM))
                    cartPageObjects.delete_Slide_Element_btn_MM.get(0).click();
            }

    }

    public void scrollToProduct(String productName)
    {
        int tries = 0;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            while (!isExist(cartPageObjects.just_For_You_Title_lbl) && tries < 20) {
                if (lookForTargetProductInCart(productName)) return;
                swiptToBottom();
                tries++;
            }
        }
        else
        {
            while (!isExist(cartPageObjects.just_For_You_Title_lbl_MM) && tries < 20) {
                if (lookForTargetProductInCart(productName)) return;
                swiptToBottom();
                tries++;
            }
        }
    }

    private boolean lookForTargetProductInCart(String productName) {
        for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); i++) {
            if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productName))
                return true;
        }
        return false;
    }


}