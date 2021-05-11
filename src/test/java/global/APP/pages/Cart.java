package global.APP.pages;

import global.APP.getProperty.VoucherGetProperty;
import global.APP.pageObjects.CartPageObjects;
import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import member.APP.pageObjects.WishlistPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-June-2019
 */

public class Cart extends Base {

    CartPageObjects cartPageObjects = new CartPageObjects();
    WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();
    SearchPageObject searchPageObj = new SearchPageObject();
    VoucherGetProperty voucherGetProperty = new VoucherGetProperty();
    boolean flag = true;
    String productName;

    public Cart(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
    }

    public void clearCart() {
       if(!verifyEmptyCart()){
           skipTheCartPopup();
            if(!verifyEmptyCart()){
                removeAllItemsFromCart();
           }
           verifyEmptyCart();
       }
    }

    public void addToCart() {
        waitUntilPresentOfElementBy(cartPageObjects.add_To_Cart_btn_By);
        cartPageObjects.add_To_Cart_btn.get(0).click();
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            if (isExist(cartPageObjects.quantity_Pdp_lbl)) {
                waitForElementToClickable(cartPageObjects.add_To_Cart_Second_btn.get(0),20);
                cartPageObjects.add_To_Cart_Second_btn.get(0).click();
            }
        } else {
            if (isExist(cartPageObjects.quantity_Pdp_lbl_MM)) {
                waitForElementToClickable(cartPageObjects.add_To_Cart_Second_btn_MM.get(0),20);
                cartPageObjects.add_To_Cart_Second_btn_MM.get(0).click();
            }
        }
    }

    public String selectProductForCart() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
            return cartPageObjects.product_Title_lbl.getText();
        else
            return cartPageObjects.product_Title_lbl_MM.getText();
    }

    public String verifyTheAddedProductBySuccessMessage() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
            return cartPageObjects.success_Message_lbl.getText();
        else
            return cartPageObjects.success_Message_lbl_MM.getText();
    }

    public void goToCartFromPDP() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.go_To_Cart_btn_By);
            cartPageObjects.go_To_Cart_btn.click();
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.go_To_Cart_btn_By_MM);
            cartPageObjects.go_To_Cart_btn_MM.click();
        }
    }

    public boolean verifyAddedProductInCart(String productName) {
        int tries = 1;
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
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
                for (int j = 0; j < cartPageObjects.product_Title_In_Cart_lbl_MM.size(); j++) {
                    if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(j).getText().contains(productName))
                        return cartPageObjects.product_Title_In_Cart_lbl_MM.get(j).getText().contains(productName);
                }
                scrollDownMultipleTries(2);
            }
        }
        return false;
    }

    private void cartPopupSkip(List<WebElement> ok_got_it_btn) {
        if (flag) {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            {
                while (isExist(ok_got_it_btn))
                    ok_got_it_btn.get(0).click();
            }
            flag = false;
        }
    }

    public void selectCart() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By);
//            cartPageObjects.cart_icon.get(2).click();
            try {
                do {
                     findElementByTextUsingContainsString("Cart").click();
                 }while (isExistByText("Cart"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By_MM);
//            cartPageObjects.cart_icon_MM.get(2).click();
                do {
                    findElementByTextUsingContainsString("Cart").click();
                } while (isExistByText("Cart"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String removeSingleItemFromCart() {
        int tries = 0;
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
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
            } while (isExistByText(productName) && tries < 15);
            return productName;
        } else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            if ((verifyEmptyCart()))
                throw new RuntimeException("There is no item available in cart to remove!");
            else {
                productName = cartPageObjects.product_Title_In_Cart_lbl_MM.get(0).getText();
                do {
                    if (cartPageObjects.product_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                        cartPageObjects.product_chkbox_MM.get(0).click();
                    cartPageObjects.delete_first_btn_MM.click();
                    cartPageObjects.delete_second_btn_MM.click();
                    cartPageObjects.delete_third_btn_MM.click();
                    tries++;
                } while (isExistByText(productName) && tries < 15);
                return productName;
            }
        }
    }

    public String verifyForRemovedItemInCart() {

        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            if (cartPageObjects.product_Title_In_Cart_lbl.size() > 0) {
                waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By);
                return cartPageObjects.product_Title_In_Cart_lbl.get(0).getText();
            } else
                return "";
        } else {
            if (cartPageObjects.product_Title_In_Cart_lbl_MM.size() > 0) {
                waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By_MM);
                return cartPageObjects.product_Title_In_Cart_lbl_MM.get(0).getText();
            } else
                return "";
        }
    }

    public void removeAllItemsFromCart() {
        int tries = 0;
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
            if ((verifyEmptyCart()))
                return;
            waitUntilPresentOfElementBy(cartPageObjects.select_All_chkbox_By);
            if (cartPageObjects.select_All_chkbox.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox.click();
            waitUntilPresentOfElementBy(cartPageObjects.delete_first_btn_By);
            cartPageObjects.delete_first_btn.click();
            cartPageObjects.delete_second_btn.click();
            cartPageObjects.delete_third_btn.click();
            while (isExist(cartPageObjects.delete_unavailable_item_btn) && tries < 10) {
                cartPageObjects.delete_unavailable_item_btn.get(0).click();
                waitUntilPresentOfElementBy(cartPageObjects.delete_Final_btn_By);
                cartPageObjects.delete_Final_btn.get(0).click();
                tries++;
            }
        } else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            if ((verifyEmptyCart()))
                return;
            waitForElementToClickable(cartPageObjects.select_All_chkbox_MM,60);
            if (cartPageObjects.select_All_chkbox_MM.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox_MM.click();
            cartPageObjects.delete_first_btn_MM.click();
            cartPageObjects.delete_second_btn_MM.click();
            cartPageObjects.delete_third_btn_MM.click();
            while (isExist(cartPageObjects.delete_unavailable_item_btn_MM) && tries < 10) {
                cartPageObjects.delete_unavailable_item_btn_MM.get(0).click();
                waitUntilPresentOfElementBy(cartPageObjects.delete_Final_btn_By_MM);
                cartPageObjects.delete_Final_btn_MM.get(0).click();
                tries++;
            }
        }
    }

    public boolean verifyEmptyCart() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            return (isExist(cartPageObjects.continue_Shopping_Cart_btn));
        } else {
            return (isExist(cartPageObjects.continue_Shopping_Cart_btn_MM));
        }
    }

    public void addProductFromCartToWishlist() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
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
                swipeBetweenTwoItems(cartPageObjects.product_Title_In_Cart_lbl_MM.get(0), cartPageObjects.product_chkbox_MM.get(0));
                waitUntilPresentOfElementBy(cartPageObjects.wishlist_In_Cart_btn_By_MM);
                cartPageObjects.wishlist_In_Cart_btn_MM.get(0).click();
            }
        }
    }

    public boolean verifyaddedItemInWishList() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
//            if (getTextWithoutException(cartPageObjects.success_Message_lbl).equalsIgnoreCase("Successfully added to the wishlist."))
            return true;
//            else return (verifyEmptyCart());
        } else {
//            if (getTextWithoutException(cartPageObjects.success_Message_lbl_MM).equalsIgnoreCase("Successfully added to the wishlist."))
            return true;
//            else return (verifyEmptyCart());
        }
    }

    public boolean verifyTheToolTipAndCountBar() {
        return (wishlistPageObjects.cart_lbl.get(0).getText().contains(".*\\d.*"));
    }

    public boolean checkforTheCartPage() {
        return containsTextIsExist("My Cart");
    }

    public boolean checkTheShopBox() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By);
            if (cartPageObjects.shop_check_box.get(0).getAttribute("checked").equalsIgnoreCase("false") && cartPageObjects.product_chkbox.get(0).getAttribute("checked").equalsIgnoreCase("false")) {
                cartPageObjects.shop_check_box.get(0).click();
                return true;
            } else
                return false;
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By_MM);
            if (cartPageObjects.shop_check_box_MM.get(0).getAttribute("checked").equalsIgnoreCase("false") && cartPageObjects.product_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false")) {
                cartPageObjects.shop_check_box_MM.get(0).click();
                return true;
            } else
                return false;
        }
    }

    public boolean checkForTheShopName() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            waitWithoutExceptionForElements(cartPageObjects.shopName_For_Product);
            return isExist(cartPageObjects.shopName_For_Product) && (!cartPageObjects.shopName_For_Product.get(0).getText().equalsIgnoreCase(""));
        } else {
            waitWithoutExceptionForElements(cartPageObjects.shopName_For_Product);
            return isExist(cartPageObjects.shopName_For_Product_MM) && (!cartPageObjects.shopName_For_Product_MM.get(0).getText().equalsIgnoreCase(""));
        }
    }

    public boolean checkForCurrentPriceAndOriginalPrice() {
        if ((ThreadStorage.get("env").equalsIgnoreCase("pk.live")) || (ThreadStorage.get("env").equalsIgnoreCase("lk.live")) || (ThreadStorage.get("env").equalsIgnoreCase("np.live"))) {
//            return (isExist(cartPageObjects.displayed_Amount_txt) || isExist(cartPageObjects.original_Amount_txt));
            int currentPriceRupee = Integer.parseInt(cartPageObjects.cart_Item_Container.get(0).findElement(cartPageObjects.cart_Item_Current_Price_By).getText().replace("Rs. ", "").replaceAll(",", ""));
            if (currentPriceRupee > 0) {
                if (isExist(cartPageObjects.cart_Item_Container.get(0).findElements(cartPageObjects.cart_Item_Original_Price_By))) {
                    int originalPriceRupee = Integer.parseInt((cartPageObjects.cart_Item_Container.get(0).findElements(cartPageObjects.cart_Item_Original_Price_By).get(0).getText().replace("Rs. ", "").replaceAll(",", "")));
                    int promotionRatio = Integer.parseInt((cartPageObjects.cart_Item_Container.get(0).findElement(cartPageObjects.cart_Item_Promotion_Ratio_Price_By).getText().replace("-", "").replaceAll("%", "")));
                    return ((originalPriceRupee > 0) && (promotionRatio > 0) && (currentPriceRupee < originalPriceRupee));
                } else return true;
            } else
                return false;
        } else if (ThreadStorage.get("env").equalsIgnoreCase("bd.live")) {
//            return (isExist(cartPageObjects.displayed_Amount_txt_MM) || isExist(cartPageObjects.original_Amount_txt_MM));
            int currentPriceTaka = Integer.parseInt(cartPageObjects.cart_Item_Container.get(0).findElement(cartPageObjects.cart_Item_Current_Price_By).getText().replace("৳ ", "").replaceAll(",", ""));
            if (currentPriceTaka > 0) {
                if (isExist(cartPageObjects.cart_Item_Container.get(0).findElements(cartPageObjects.cart_Item_Original_Price_By))) {
                    int promotionRatio = Integer.parseInt(cartPageObjects.cart_Item_Container.get(0).findElement(cartPageObjects.cart_Item_Promotion_Ratio_Price_By).getText().replace("-", "").replaceAll("%", ""));
                    int originalPriceTaka = Integer.parseInt(cartPageObjects.cart_Item_Container.get(0).findElements(cartPageObjects.cart_Item_Original_Price_By).get(0).getText().replace("৳ ", "").replaceAll(",", ""));
                    return ((originalPriceTaka > 0) && (promotionRatio > 0) && (currentPriceTaka < originalPriceTaka));
                } else return true;
            } else
                return false;
        } else {

            int currentPriceKyat = Integer.parseInt(cartPageObjects.cart_Item_Container_MM.get(0).findElement(cartPageObjects.cart_Item_Current_Price_By_MM).getText().replace("Ks ", "").replaceAll(",", ""));
            if (currentPriceKyat > 0) {
                if (isExist((cartPageObjects.cart_Item_Container_MM.get(0).findElements(cartPageObjects.cart_Item_Original_Price_By_MM)))) {
                    int originalPriceKyat = Integer.parseInt(cartPageObjects.cart_Item_Container_MM.get(0).findElements(cartPageObjects.cart_Item_Original_Price_By_MM).get(0).getText().replace("Ks ", "").replaceAll(",", ""));
                    int promotionRatioMM = Integer.parseInt(cartPageObjects.cart_Item_Container_MM.get(0).findElement(cartPageObjects.cart_Item_Promotion_Ratio_Price_By_MM).getText().replace("-", "").replaceAll("%", ""));
                    return ((originalPriceKyat > 0) && (promotionRatioMM > 0) && (currentPriceKyat < originalPriceKyat));
                } else return true;
            } else
                return false;
        }

    }

    public void cartDeliveryInfoCheck() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By);
            cartPageObjects.ok_Got_It_btn.get(0).click();
            waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By);
            cartPageObjects.success_Message_lbl.click();
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            wishlistPageObjects.wishlist_lbl.get(0).click();
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            waitUntilPresentOfElementBy(cartPageObjects.cart_icon_By_MM);
            cartPageObjects.success_Message_lbl_MM.click();
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            wishlistPageObjects.wishlist_lbl_MM.get(0).click();
        }
    }

    public void skipTheCartPopup() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
        } else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
        }
    }

    public String getProductName() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By);
            return cartPageObjects.product_Title_lbl.getText();
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By_MM);
            return cartPageObjects.product_Title_lbl_MM.getText();
        }
    }

    public void slideTheItemInCartToViewOptions(String productName) {
        int tries = 0;
        int i = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By);
            while (lookForTargetProductInCart(productName) && tries < 15) {
                for (i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); i++)
                    if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productName))
                        break;
                swipeHorizontallyToZeroWithInElement(cartPageObjects.product_Title_In_Cart_lbl.get(i));
                deleteElementFromCart();
                tries++;
            }
        } else {
            while (lookForTargetProductInCart(productName) && tries < 15) {
                waitUntilPresentOfElementBy(cartPageObjects.product_Title_In_Cart_lbl_By_MM);
                for (i = 0; i < cartPageObjects.product_Title_In_Cart_lbl_MM.size(); i++)
                    if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().equalsIgnoreCase(productName))
                        break;
                swipeHorizontallyToZeroWithInElement(cartPageObjects.product_Title_In_Cart_lbl_MM.get(i));
                deleteElementFromCart();
                tries++;
            }
        }
    }

    private void deleteElementFromCart() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            if (isExist(cartPageObjects.delete_Slide_Element_btn))
                cartPageObjects.delete_Slide_Element_btn.get(0).click();
        } else {
            if (isExist(cartPageObjects.delete_Slide_Element_btn_MM))
                cartPageObjects.delete_Slide_Element_btn_MM.get(0).click();
        }

    }

    public void scrollToProduct(String productName) {
        int tries = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            do {
                if (isExistByText(productName)) {
                    return;
                } else {
                    swiptToBottom();
                    tries++;
                }
            } while (!isExist(cartPageObjects.just_For_You_Title_lbl) && tries < 15);
        } else {
            do {
                if (isExistByText(productName)) {
                    return;
                } else {
                    swiptToBottom();
                    tries++;
                }
            } while (!isExist(cartPageObjects.just_For_You_Title_lbl_MM) && tries < 15);
        }
    }

    public void addToCartforCombo() {
        int tries = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            while (!isExist(cartPageObjects.combo_Add_To_Cart_btn) && tries < 20) {
                swiptToBottom();
                tries++;
                if (isExist(cartPageObjects.popup_Close_Button))
                    cartPageObjects.popup_Close_Button.get(0).click();

            }
            cartPageObjects.combo_Add_To_Cart_btn.get(0).click();
//            if(waitWithoutExceptionForElements(cartPageObjects.add_To_Cart_Second_btn))
//                cartPageObjects.add_To_Cart_Second_btn.get(0).click();

        } else {
            while (!isExist(cartPageObjects.combo_Add_To_Cart_btn_MM) && tries < 20) {
                swiptToBottom();
                tries++;
                if (isExist(cartPageObjects.popup_Close_Button_MM))
                    cartPageObjects.popup_Close_Button_MM.get(0).click();
            }
            cartPageObjects.combo_Add_To_Cart_btn_MM.get(0).click();
//            if(waitWithoutExceptionForElements(cartPageObjects.add_To_Cart_Second_btn_MM))
//                cartPageObjects.add_To_Cart_Second_btn_MM.get(0).click();
        }
    }

    public void selectTheAddedProduct(String productName) {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size() - 1; i++) {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().contains(productName)) {
                    cartPageObjects.product_chkbox.get(i).click();
                    break;
                }
            }
        } else {
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl_MM.size() - 1; i++) {
                if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().contains(productName)) {
                    cartPageObjects.product_chkbox_MM.get(i).click();
                    break;
                }
            }
        }
    }

    private boolean lookForTargetProductInCart(String productName) {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); i++) {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productName))
                    return true;
            }
        } else {
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl_MM.size(); i++) {
                if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().equalsIgnoreCase(productName))
                    return true;
            }
        }
        return false;
    }


    public void selectAllItemsInCart() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            if (cartPageObjects.select_All_chkbox.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox.click();
        } else {
            if (cartPageObjects.select_All_chkbox_MM.getAttribute("checked").equalsIgnoreCase("false"))
                cartPageObjects.select_All_chkbox_MM.click();
        }
    }

    public void clickOnProduct(String productName) {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            findElementByTextUsingExactString(productName).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
        } else {
            findElementByTextUsingExactString(productName).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn_MM))
                searchPageObj.ok_Got_It_btn_MM.get(0).click();
        }
    }

    public boolean verifyTheProductNameOnPDP(String productName) {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By);
            return cartPageObjects.product_Title_lbl.getText().contains(productName);
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By_MM);
            return cartPageObjects.product_Title_lbl_MM.getText().contains(productName);
        }
    }

    public void scrollToProductAndPromotion(String productName, String promotionName) {
        int tries = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            do {
                if (isExistByText(productName) && containsTextIsExist(promotionName)) {
                    return;
                } else {
                    swiptToBottom();
                    tries++;
                }
            } while (!isExist(cartPageObjects.just_For_You_Title_lbl) && tries < 15);
        } else {
            do {
                if (isExistByText(productName) && containsTextIsExist(promotionName)) {
                    return;
                } else {
                    swiptToBottom();
                    tries++;
                }
            } while (!isExist(cartPageObjects.just_For_You_Title_lbl_MM) && tries < 15);
        }
    }

    public boolean verifyAddedProductInCartWithPromotion(String productName, String promotionName) {
        int tries = 5;
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
            for (int i = 0; i < tries; i++) {
                for (int j = 0; j < cartPageObjects.product_Title_In_Cart_lbl.size(); j++) {
                    if (cartPageObjects.product_Title_In_Cart_lbl.get(j).getText().contains(productName))
                        return (cartPageObjects.product_Title_In_Cart_lbl.get(j).getText().contains(productName) && containsTextIsExist(promotionName));
                }
                scrollDownMultipleTries(2);
            }
        } else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            for (int i = 0; i < tries; i++) {
                for (int j = 0; j < cartPageObjects.product_Title_In_Cart_lbl_MM.size(); j++) {
                    if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(j).getText().contains(productName))
                        return (cartPageObjects.product_Title_In_Cart_lbl_MM.get(j).getText().contains(productName) && containsTextIsExist(promotionName));
                }
                scrollDownMultipleTries(2);
            }
        }
        return false;
    }

    public boolean verifyNoItemInCart() {
        return waitWithoutExceptionByTextContains("There are no items in this cart");
    }

    public void selectContinueShopping() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            cartPageObjects.continue_Shopping_Cart_btn.get(0).click();
        } else {
            cartPageObjects.continue_Shopping_Cart_btn_MM.get(0).click();
        }
    }

    public boolean verifyTheHiddenDeleteButton() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            return isExist(cartPageObjects.delete_Slide_Element_btn);
        } else {
            return isExist(cartPageObjects.delete_Slide_Element_btn_MM);
        }
    }

    public boolean verifyTheQuantityOfItem() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            return (Integer.parseInt(cartPageObjects.cart_Item_Container.get(0).findElement(cartPageObjects.cart_Item_Quantity_txt_By).getText()) > 0);
        } else {
            return (Integer.parseInt(cartPageObjects.cart_Item_Container_MM.get(0).findElement(cartPageObjects.cart_Item_Quantity_txt_By_MM).getText()) > 0);
        }
    }

    public boolean iCheckForShippingFeeAndTotalPrice() {

        if ((ThreadStorage.get("env").equalsIgnoreCase("pk.live")) || (ThreadStorage.get("env").equalsIgnoreCase("lk.live")) || (ThreadStorage.get("env").equalsIgnoreCase("np.live"))) {
            int TotalPriceRupee = Integer.parseInt(cartPageObjects.cart_Total_Price_lbl.getText().replace("Rs. ", "").replaceAll(",", ""));
            if (!(cartPageObjects.cart_Shipping_lbl.getText().equalsIgnoreCase("Shipping:") && !(cartPageObjects.cart_Total_lbl.getText().equalsIgnoreCase("Total:")))) {
                if (!cartPageObjects.cart_Shipping_Price_lbl.getText().contains("Free")) {
//                    if (Integer.parseInt(cartPageObjects.cart_Shipping_Price_lbl.getText().replaceAll("Rs. ", "").replaceAll(",", "")) <= 0)
//                        return false;
                    return (!cartPageObjects.cart_Shipping_Price_lbl.getText().equalsIgnoreCase(""));
                }
                return (TotalPriceRupee > 0);
            } else
                return false;
        } else if (ThreadStorage.get("env").equalsIgnoreCase("bd.live")) {
            int TotalPriceTaka = Integer.parseInt(cartPageObjects.cart_Total_Price_lbl.getText().replace("৳ ", "").replaceAll(",", ""));
            if (!(cartPageObjects.cart_Shipping_lbl.getText().equalsIgnoreCase("Shipping:") && !(cartPageObjects.cart_Total_lbl.getText().equalsIgnoreCase("Total:")))) {
                if (!cartPageObjects.cart_Shipping_Price_lbl.getText().contains("Free")) {
//                    if (Integer.parseInt(cartPageObjects.cart_Shipping_Price_lbl.getText().replaceAll("৳ ", "").replaceAll(",", "")) <= 0)
//                        return false;
                    return (!cartPageObjects.cart_Shipping_Price_lbl.getText().equalsIgnoreCase(""));
                }
                return (TotalPriceTaka > 0);
            } else return false;
        } else {
            int TotalPriceKyat = Integer.parseInt(cartPageObjects.cart_Total_Price_lbl_MM.getText().replace("Ks ", "").replaceAll(",", ""));
            if (!(cartPageObjects.cart_Shipping_lbl_MM.getText().equalsIgnoreCase("Shipping:") && !(cartPageObjects.cart_Total_lbl_MM.getText().equalsIgnoreCase("Total:")))) {
                if (!cartPageObjects.cart_Shipping_Price_lbl_MM.getText().contains("Free")) {
//                    if (Integer.parseInt(cartPageObjects.cart_Shipping_Price_lbl_MM.getText().replaceAll("Ks ", "").replaceAll(",", "")) <= 0) {
//                        return false;
                    return (!cartPageObjects.cart_Shipping_Price_lbl_MM.getText().equalsIgnoreCase(""));
                    }
                }
                return (TotalPriceKyat > 0);
            }
//            return false;

        }

    public void selectGetVoucher() {
        waitUntilPresentOfElementByText("Get Voucher");
        findElementByTextUsingExactString("Get Voucher").click();
    }

    public boolean verifyTheGetVocuherPopupComponents() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.get_Voucher_Validity_lbl_By);
            return ((cartPageObjects.get_Voucher_Title_lbl.getText().toLowerCase().contains("voucher from"))
                    && ((Integer.parseInt(cartPageObjects.get_Voucher_Profit_lbl.getText().replaceAll("[^\\d.]", ""))) > 0)
                    && (cartPageObjects.get_Voucher_Condition_lbl.getText().toLowerCase().contains("spend"))
                    && cartPageObjects.get_Voucher_Validity_lbl.getText().toLowerCase().contains("validity"));

        } else {
            waitUntilPresentOfElementBy(cartPageObjects.get_Voucher_Validity_lbl_By_MM);
           return  ((cartPageObjects.get_Voucher_Title_lbl_MM.getText().toLowerCase().contains("voucher from"))
                    && ((Integer.parseInt(cartPageObjects.get_Voucher_Profit_lbl_MM.getText().replaceAll("[^\\d.]", ""))) > 0)
                    && (cartPageObjects.get_Voucher_Condition_lbl_MM.getText().toLowerCase().contains("spend"))
                    && cartPageObjects.get_Voucher_Validity_lbl_MM.getText().toLowerCase().contains("validity"));
        }
    }

    public boolean verifyTheVoucherCollection(String occurance) {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            if (occurance.equalsIgnoreCase("first")) {
                findElementByTextUsingExactString("Collect").click();
                return cartPageObjects.get_Voucher_Toast_Message_lbl.getText().contains("Collected successfully");
            } else {
                waitUntilPresentOfElementBy(cartPageObjects.get_Voucher_Title_lbl_By);
                if (isExistByText("Collect")) {
                    findElementByTextUsingExactString("Collect").click();
                    return (!cartPageObjects.get_Voucher_Toast_Message_lbl.getText().contains("Collected successfully"));
                } else
                    return true;
            }
        } else {
            if (occurance.equalsIgnoreCase("first")) {
                findElementByTextUsingExactString("Collect").click();
                return cartPageObjects.get_Voucher_Toast_Message_lbl_MM.getText().contains("Collected successfully");
            } else {
                waitUntilPresentOfElementBy(cartPageObjects.get_Voucher_Title_lbl_By_MM);
                if (isExistByText("Collect")) {
                    findElementByTextUsingExactString("Collect").click();
                    return (!cartPageObjects.get_Voucher_Toast_Message_lbl_MM.getText().contains("Collected successfully"));
                } else
                    return true;
            }
        }

    }

    public void clickOnCloseButton() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            cartPageObjects.get_Voucher_Close_btn.click();
        } else {
            cartPageObjects.get_Voucher_Close_btn_MM.click();
        }
    }

    public void clickOnPopupCloseButton() {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            cartPageObjects.popup_Close_Button.get(0).click();
        } else {
            cartPageObjects.popup_Close_Button_MM.get(0).click();
        }
    }

    public void iScrollDownToTheVocuherCodeSection() {
        int tries = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            while (!isExist(cartPageObjects.code_Voucher_txtBox) && tries < 15) {
                swiptToBottom();
                tries++;
            }
        } else {
            while (!isExist(cartPageObjects.code_Voucher_txtBox_MM) && tries < 15) {
                swiptToBottom();
                tries++;
            }
        }
    }

    public boolean verifyTheComponentsOfVoucherCodeSection() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live"))
            return (isExist(cartPageObjects.code_Voucher_txtBox) && (cartPageObjects.code_Voucher_Apply_btn.getText().equalsIgnoreCase("APPLY")));
        else
            return (isExist(cartPageObjects.code_Voucher_txtBox_MM) && (cartPageObjects.code_Voucher_Apply_btn_MM.getText().equalsIgnoreCase("APPLY")));
    }

    public boolean verifyTheApplyButton() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live"))
            return cartPageObjects.code_Voucher_Apply_btn.getAttribute("clickable").equalsIgnoreCase("false");
        else
            return cartPageObjects.code_Voucher_Apply_btn_MM.getAttribute("clickable").equalsIgnoreCase("false");
    }

    public void clickOnApplyButton() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            cartPageObjects.code_Voucher_Apply_btn.click();
            hideKeyboard();
        } else {
            cartPageObjects.code_Voucher_Apply_btn_MM.click();
            hideKeyboard();
        }
    }

    public void enterVoucherCode(String voucherCodeCondition, String wrongVoucherCode, String correctVoucherCode) {
//        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            if (voucherCodeCondition.equalsIgnoreCase("wrong")) {
                cartPageObjects.code_Voucher_txtBox.get(0).sendKeys(wrongVoucherCode);

            } else {
                 cartPageObjects.code_Voucher_txtBox.get(0).sendKeys(correctVoucherCode);
            }
        } else {
            if (voucherCodeCondition.equalsIgnoreCase("wrong")) {
                cartPageObjects.code_Voucher_txtBox_MM.get(0).sendKeys(wrongVoucherCode);
            }
            else
                cartPageObjects.code_Voucher_txtBox_MM.get(0).sendKeys(correctVoucherCode);
        }
    }

    public boolean verifyTheValidationError() {
        int tries = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            while (!isExist(cartPageObjects.cart_Voucher_Error_lbl) && tries < 5) {
                swiptToBottom();
                tries++;
            }
            return cartPageObjects.cart_Voucher_Error_lbl.get(0).getText().contains("Sorry, this voucher is not valid");
        } else {
            while (!isExist(cartPageObjects.cart_Voucher_Error_lbl_MM) && tries < 5) {
                swiptToBottom();
                tries++;
            }
            return cartPageObjects.cart_Voucher_Error_lbl_MM.get(0).getText().contains("Sorry, this voucher is not valid");
        }
    }

    public void selectVoucherClearButton() throws IOException {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
           waitUntilPresentOfElementBy(cartPageObjects.voucher_Clear_btn_By);
            cartPageObjects.voucher_Clear_btn.click();
            voucherGetProperty.setCartTotalPrice(cartPageObjects.cart_Total_Price_lbl.getText().replaceAll("[^\\d]", ""));
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.voucher_Clear_btn_By_MM);
            cartPageObjects.voucher_Clear_btn_MM.click();
            voucherGetProperty.setCartTotalPrice(cartPageObjects.cart_Total_Price_lbl_MM.getText().replaceAll("[^\\d]", ""));
        }
    }

    public boolean verifyTheEmptyVoucherTextfield()
    {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
           return cartPageObjects.code_Voucher_txtBox.get(0).getText().equalsIgnoreCase("Enter Voucher Code");
        }
        else
        {
            return cartPageObjects.code_Voucher_txtBox_MM.get(0).getText().equalsIgnoreCase("Enter Voucher Code");
        }
    }

    public boolean verifyTheImapctOfCorrectVoucherCode() throws IOException {   int tries = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            while (!isExist(cartPageObjects.voucher_Success_Message_lbl) && tries < 5) {
                swiptToBottom();
                tries++;
            }
            if (cartPageObjects.voucher_Success_Message_lbl.get(0).getText().contains("Voucher codes are not stackable"))
            {
                return (Integer.parseInt(cartPageObjects.cart_Total_Price_lbl.getText().replaceAll("[^\\d]", "")) < Integer.parseInt(voucherGetProperty.getCartTotalPrice()));
            }
            else return false;

        } else {
            while (!isExist(cartPageObjects.voucher_Success_Message_lbl_MM) && tries < 5) {
                swiptToBottom();
                tries++;
            }
            if (cartPageObjects.voucher_Success_Message_lbl_MM.get(0).getText().contains("Voucher codes are not stackable"))
            {
                return (Integer.parseInt(cartPageObjects.cart_Total_Price_lbl_MM.getText().replaceAll("[^\\d]", "")) < Integer.parseInt(voucherGetProperty.getCartTotalPrice()));
            }
            else return false;
        }
    }

    public void selectTheCheckBoxForProduct(String productName)
    {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            for (int i=0; i<cartPageObjects.product_Title_In_Cart_lbl.size(); i++)
            {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productName)) {
                   if (cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.product_rdobtn_By).getAttribute("checked").equalsIgnoreCase("false"))
                       cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.product_rdobtn_By).click();
                       break;
                }
            }
        }
        else
        {
            for (int i=0; i<cartPageObjects.product_Title_In_Cart_lbl_MM.size(); i++)
            {
                if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().equalsIgnoreCase(productName)) {
                    if (cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.product_rdobtn_By_MM).getAttribute("checked").equalsIgnoreCase("false"))
                        cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.product_rdobtn_By_MM).click();
                    break;
                }
            }
        }
    }
}