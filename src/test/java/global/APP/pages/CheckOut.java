package global.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.CheckOutPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-June-2019
 */

public class CheckOut extends Base {

    CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();
    CartPageObjects cartPageObjects = new CartPageObjects();

    int price;
    int tries = 0;

    public CheckOut(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
    }

    public String selectProductForCheckout() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By);
            return cartPageObjects.product_Title_lbl.getText();
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.product_Title_lbl_By_MM);
            return cartPageObjects.product_Title_lbl_MM.getText();
        }
    }

    public void selectBuyNow() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitWithoutExceptionForElementsResult(cartPageObjects.buy_Now_btn);
            clickMultipleTries(cartPageObjects.buy_Now_btn, 5);
        } else {
            waitWithoutExceptionForElementsResult(cartPageObjects.buy_Now_btn_MM);
            clickMultipleTries(cartPageObjects.buy_Now_btn_MM, 5);
        }
    }

    public void proceedToPay() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(checkOutPageObjects.proceed_To_Pay_btn_By);
            checkOutPageObjects.proceed_To_Pay_btn.click();
        } else {
            waitUntilPresentOfElementBy(checkOutPageObjects.proceed_To_Pay_btn_By_MM);
            checkOutPageObjects.proceed_To_Pay_btn_MM.click();
        }
    }

    public void checkoutUsingCODPaymentMethod() {
//        if ((System.getProperty("env").equalsIgnoreCase("pk.live"))|| (System.getProperty("env").equalsIgnoreCase("np.live")) || (System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(checkOutPageObjects.cod_lbl_MM_By);
            checkOutPageObjects.cod_lbl_MM.click();
//        } else {
//            waitUntilPresentOfElementBy(checkOutPageObjects.cod_lbl_By);
//            checkOutPageObjects.cod_lbl.click();
//        }
    }

    public void reachToOrderSuccessPage() {
        waitUntilPresentOfElementBy(checkOutPageObjects.confirm_Order_btn_By);
        checkOutPageObjects.confirm_Order_btn.click();
    }

    public void clickTrackOrder() {
//        if (waitUntilPresentOfElementByWithoutException(checkOutPageObjects.track_Order_btn_By)) {
//            checkOutPageObjects.track_Order_btn.click();
//        } else {
            if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
                if (waitUntilPresentOfElementByWithoutException(checkOutPageObjects.rating_Later_btn_By))
                    checkOutPageObjects.rating_Later_btn.click();
                findElementByString("View Order").click();
            } else {
                if (waitUntilPresentOfElementByWithoutException(checkOutPageObjects.rating_Later_btn_By_MM))
                    checkOutPageObjects.rating_Later_btn_MM.click();
                findElementByString("View Order").click();
            }
        }
//    }

    public boolean verifyCheckOutItem(String productName) {
        waitUntilPresentOfElementByString(productName);
        String Name = (findElementByString(productName).getAttribute("contentDescription"));
        if (Name.length() > 40)
            Name = Name.substring(0, 40);
        return (productName.contains(Name));
    }

    public int selectProductFromCart(String productName) {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn);
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); ++i) {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().contains(productName)) {
                    if (cartPageObjects.product_chkbox.get(i).getAttribute("checked").equalsIgnoreCase("false"))
                        cartPageObjects.product_chkbox.get(i).click();
                    return i;
                }
            }
            throw new RuntimeException("Required Product is not added to cart!");
        } else {
            cartPopupSkip(cartPageObjects.ok_Got_It_btn_MM);
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl_MM.size(); ++i) {
                if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().contains(productName)) {
                    if (cartPageObjects.product_chkbox_MM.get(i).getAttribute("checked").equalsIgnoreCase("false"))
                        cartPageObjects.product_chkbox_MM.get(i).click();
                    return i;
                }
            }
            throw new RuntimeException("Required Product is not added to cart!");
        }
    }

    public int changeProductQuantity(int quantity, int index) {
        if (quantity < 1 || quantity > 5)
            throw new RuntimeException("Specified quantity is not applicable!");
        int currentItemQuantity;
        int availableQuantity;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (isExist(checkOutPageObjects.cart_item_container.get(index).findElements(checkOutPageObjects.available_quantity_By))) {
                availableQuantity = Integer.parseInt(checkOutPageObjects.cart_item_container.get(index).findElements(checkOutPageObjects.available_quantity_By).get(0).getText().replaceAll("\\D+", ""));
                if (availableQuantity < quantity) {
                    System.out.println("The available quantity for this item is not enough as the specified quantity. So that the specified quantity is changed to " + availableQuantity);
                    quantity = availableQuantity;
                }
            }
            currentItemQuantity = Integer.parseInt(checkOutPageObjects.quantity_lbl.getText());
            if (currentItemQuantity < quantity) {
                if (isExist(checkOutPageObjects.quantity_increase_btn)) {
                    for (int i = currentItemQuantity; i < quantity; i++) {
                        waitForElementToClickable(checkOutPageObjects.quantity_increase_btn.get(0));
                        checkOutPageObjects.quantity_increase_btn.get(0).click();
                    }
                } else {
                    checkOutPageObjects.quantity_drpDown.click();
                    waitUntilPresentOfElementBy(checkOutPageObjects.quantity_Option_By);
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    checkOutPageObjects.quantity_Confirm_btn.click();
                }
            } else if (currentItemQuantity > quantity) {
                if (isExist(checkOutPageObjects.quantity_decrese_btn)) {
                    for (int i = currentItemQuantity; i > quantity; i--) {
                        waitForElementToClickable(checkOutPageObjects.quantity_decrese_btn.get(0));
                        checkOutPageObjects.quantity_decrese_btn.get(0).click();
                    }
                } else {
                    checkOutPageObjects.quantity_drpDown.click();
                    waitUntilPresentOfElementBy(checkOutPageObjects.quantity_Option_By);
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    checkOutPageObjects.quantity_Confirm_btn.click();
                }
            } else {
                System.out.println("Specified quantity is already applied or not applicable yet!");
            }

        } else {
            if (isExist(checkOutPageObjects.cart_item_container_MM.get(index).findElements(checkOutPageObjects.available_quantity_MM_By))) {
                availableQuantity = Integer.parseInt(checkOutPageObjects.cart_item_container_MM.get(index).findElements(checkOutPageObjects.available_quantity_MM_By).get(0).getText().replaceAll("\\D+", ""));
                if (availableQuantity < quantity) {
                    System.out.println("The available quantity for this item is not enough as the specified quantity. So that the specified quantity is changed to " + availableQuantity);
                    quantity = availableQuantity;
                }
            }
            currentItemQuantity = Integer.parseInt(checkOutPageObjects.quantity_lbl_MM.getText());
            if (currentItemQuantity < quantity) {
                if (isExist(checkOutPageObjects.quantity_increase_btn_MM)) {
                    for (int i = currentItemQuantity; i < quantity; i++) {
                        waitForElementToClickable(checkOutPageObjects.quantity_increase_btn_MM.get(0));
                        checkOutPageObjects.quantity_increase_btn_MM.get(0).click();
                    }
                } else {
                    checkOutPageObjects.quantity_drpDown_MM.click();
                    waitUntilPresentOfElementBy(checkOutPageObjects.quantity_Option_By_MM);
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    checkOutPageObjects.quantity_Confirm_btn_MM.click();
                }
            } else if (currentItemQuantity > quantity) {
                if (isExist(checkOutPageObjects.quantity_decrese_btn_MM)) {
                    for (int i = currentItemQuantity; i > quantity; i--) {
                        waitForElementToClickable(checkOutPageObjects.quantity_decrese_btn_MM.get(0));
                        checkOutPageObjects.quantity_decrese_btn_MM.get(0).click();
                    }
                } else {
                    checkOutPageObjects.quantity_drpDown_MM.click();
                    waitUntilPresentOfElementBy(checkOutPageObjects.quantity_Option_By_MM);
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    findElementByTextUsingExactString(Integer.toString(quantity)).click();
                    checkOutPageObjects.quantity_Confirm_btn_MM.click();
                }
            } else {
                System.out.println("Specified quantity is already applied or not applicable yet!");
            }

        }
        return quantity;
    }

    public void selectCheckoutFromCart() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            checkOutPageObjects.checkout_btn.click();
        else
            checkOutPageObjects.checkout_btn_MM.click();
    }

    public String verifyTheQuantity(int quantity) {
        return findElementByExactString(Integer.toString(quantity)).getAttribute("contentDescription");
    }

    public void slideToViewDeleteButtonForPromotionProducts(String productName, String promotionName) {
        if (productName.length() > 25)
            productName = productName.substring(0, 25);
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            while (tries < 15) {
                tries++;
                if (isExist(checkOutPageObjects.item_On_Checkout_lbl)) {
//                    for (int i = checkOutPageObjects.item_On_Checkout_lbl.size() - 1; i >= 0; i--) {
//                        if (checkOutPageObjects.item_On_Checkout_lbl.get(i).getText().contains(productName) && containsTextIsExist(promotionName)) {
                            if (containsTextIsExist(productName) && isExistByText(promotionName)){
                                swiptToBottom();
                                swipeHorizontallyToZeroWithInElementbyText(productName);
                            break;
                        } else
                            swiptToBottom();

                } else {
                    swiptToBottom();
                    continue;
                }
                if (isExist(checkOutPageObjects.checkout_Delete_btn))
                    break;
            }
        } else {
            while (tries < 15) {
                tries++;
                if (isExist(checkOutPageObjects.item_On_Checkout_lbl_MM)) {
//                    for (int i = checkOutPageObjects.item_On_Checkout_lbl.size() - 1; i >= 0; i--) {
//                        if (checkOutPageObjects.item_On_Checkout_lbl.get(i).getText().contains(productName) && containsTextIsExist(promotionName)) {
                    if (containsTextIsExist(productName) && isExistByText(promotionName)){
                        swiptToBottom();
                        swipeHorizontallyToZeroWithInElementbyText(productName);
                        break;
                    } else
                        swiptToBottom();

                } else {
                    swiptToBottom();
                    continue;
                }
                if (isExist(checkOutPageObjects.checkout_Delete_btn_MM))
                    break;
            }
        }
    }

    public void slideToViewDeleteButton(String productName) {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            while (tries < 20) {
                tries++;
                if (isExist(checkOutPageObjects.item_On_Checkout_lbl)) {
                    for (int i = checkOutPageObjects.item_On_Checkout_lbl.size() - 1; i >= 0; i--) {
                        if (checkOutPageObjects.item_On_Checkout_lbl.get(i).getText().contains(productName)) {
                            swipeHorizontallyToZeroWithInElement(checkOutPageObjects.item_On_Checkout_lbl.get(i));
                            swiptToBottom();
                            break;
                        } else
                            swiptToBottom();
                    }
                } else {
                    swiptToBottom();
                    continue;
                }
                if (isExist(checkOutPageObjects.checkout_Delete_btn))
                    break;
            }
        } else {
            while (tries < 20) {
                tries++;
                if (isExist(checkOutPageObjects.item_On_Checkout_lbl_MM) && checkOutPageObjects.item_On_Checkout_lbl_MM.get(checkOutPageObjects.item_On_Checkout_lbl_MM.size() - 1).getText().contains(productName)) {
                    swiptToBottom();
                    swipeHorizontallyToZeroWithInElement(checkOutPageObjects.item_On_Checkout_lbl_MM.get(0));
                    break;
                } else {
                    swiptToBottom();
                }
            }
        }
    }

    public void clickOnDeleteButton() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(checkOutPageObjects.checkout_Delete_btn_By);
            checkOutPageObjects.checkout_Delete_btn.get(0).click();
        } else {
            waitUntilPresentOfElementBy(checkOutPageObjects.checkout_Delete_btn_By_MM);
            checkOutPageObjects.checkout_Delete_btn_MM.get(0).click();
        }
    }

    public boolean checkForDeletedProduct(String promotionType) {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitWithoutExceptionForElements(checkOutPageObjects.item_On_Checkout_lbl);
        } else {
            waitWithoutExceptionForElements(checkOutPageObjects.item_On_Checkout_lbl_MM);
        }
        return (!containsTextIsExist(promotionType));
    }

    public boolean checkForPromotionOnCheckout(String promotionType) {
        while (tries < 10) {
            if (containsTextIsExist(promotionType))
                return true;
            else
                swiptToBottom();
            tries++;
        }
        return false;
    }

    public boolean verifyTheNumberOfItems(String numberOfItems) {
        tries = 0;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            while (tries < 10) {
                if (isExist(checkOutPageObjects.items_On_check_out) && !(checkOutPageObjects.items_On_check_out.get(0).getText().contains(numberOfItems)))
                    return true;
                else
                    swiptToBottom();
                tries++;
            }
            return false;
        } else {
            while (tries < 10) {
                if (isExist(checkOutPageObjects.items_On_check_out_MM) && !(checkOutPageObjects.items_On_check_out_MM.get(0).getText().contains(numberOfItems)))
                    return true;
                else
                    swiptToBottom();
                tries++;
            }
            return false;
        }
    }

    public void clickOnEditAddressButton() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(checkOutPageObjects.edit_Address_btn_By);
            checkOutPageObjects.edit_Address_btn.get(0).click();
        } else {
            waitUntilPresentOfElementBy(checkOutPageObjects.edit_Address_btn_By_MM);
            checkOutPageObjects.edit_Address_btn_MM.get(0).click();
        }
    }

    public boolean verifyTheDifferentBillingAndShippingAddress(String addressType) {
        if (addressType.equalsIgnoreCase("different")) {
            if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
                return (checkOutPageObjects.address_Checkout_lbl.size() > 1 && !checkOutPageObjects.address_Checkout_lbl.get(1).getText().contains("same"));
            } else {
                return (checkOutPageObjects.address_Checkout_lbl_MM.size() > 1 && !checkOutPageObjects.address_Checkout_lbl_MM.get(1).getText().contains("same"));
            }
        } else {
            if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
                return (checkOutPageObjects.address_Checkout_lbl.size() > 1 && checkOutPageObjects.address_Checkout_lbl.get(1).getText().contains("same"));
            } else {
                return (checkOutPageObjects.address_Checkout_lbl_MM.size() > 1 && checkOutPageObjects.address_Checkout_lbl_MM.get(1).getText().contains("same"));
            }
        }

    }

    public boolean verifyTheBottomLineDivider() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return isExist(checkOutPageObjects.line_Divider_img);
        else
            return isExist(checkOutPageObjects.line_Divider_img_MM);
    }

    public boolean verifyTheSnackbarErrorMessage()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return isExist(checkOutPageObjects.snackbar_txt);
        else
             return isExist(checkOutPageObjects.snackbar_txt_MM);
    }

    public boolean verifyTheEmailAndDeliveryTimeForDigitalGoods()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            waitUntilPresentOfElementBy(checkOutPageObjects.proceed_To_Pay_btn_By);
        else
            waitUntilPresentOfElementBy(checkOutPageObjects.proceed_To_Pay_btn_By_MM);
        return (containsTextIsExist("24 hours") && (containsTextIsExist("**@")));
    }

    public boolean verifyTheAttributesOfItem()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
            while (tries < 15) {
                if (isExist(checkOutPageObjects.order_Summary_lbl)) {
                    return (!checkOutPageObjects.item_On_Checkout_lbl.get(0).getText().equalsIgnoreCase("") &&
                            !checkOutPageObjects.current_Price_lbl.getText().equalsIgnoreCase("") &&
                            (Integer.parseInt(checkOutPageObjects.item_Count_lbl.getText()) >=1) &&
                            isExist(checkOutPageObjects.product_img) || !(checkOutPageObjects.original_Price_lbl.getText().equalsIgnoreCase("")));
                } else {
                    swiptToBottom();
                    tries++;
                }
            }
        }
        else
        {
            while (tries < 15) {
                if (isExist(checkOutPageObjects.order_Summary_lbl_MM)) {
                    return (!checkOutPageObjects.item_On_Checkout_lbl_MM.get(0).getText().equalsIgnoreCase("") &&
                            !checkOutPageObjects.current_Price_lbl_MM.getText().equalsIgnoreCase("") &&
                            (Integer.parseInt(checkOutPageObjects.item_Count_lbl_MM.getText()) >=1) &&
                            isExist(checkOutPageObjects.product_img_MM) || !(checkOutPageObjects.original_Price_lbl_MM.getText().equalsIgnoreCase("")));
                } else {
                    swiptToBottom();
                    tries++;
                }
            }
        }
        return false;
    }

    public boolean verifyTheExistenceOfTotalPriceOnCheckout()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return (!checkOutPageObjects.total_Price_On_Checkout.getText().equalsIgnoreCase(""));
        else
            return (!checkOutPageObjects.total_Price_On_Checkout_MM.getText().equalsIgnoreCase(""));
    }

    public boolean verifyTheLogisticsTypeAndDeliveryDateAndPostage()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("np.live"))) {
            waitUntilPresentOfElementBy(checkOutPageObjects.cancel_btn_By);
//            return (findElementsSizeByString("Package") && findElementsSizeByString("Sold by") && findElementsSizeByString("Get by"));
        } else {
            waitUntilPresentOfElementBy(checkOutPageObjects.cancel_btn_By_NP);
//            return (findElementsSizeByString("Package") && findElementsSizeByString("Sold by") && findElementsSizeByString("Get by"));
        }
        return (findElementsSizeByString("Package") && (findElementsSizeByString("Sold by") || findElementsSizeByString("Get by")));

    }

    private void cartPopupSkip(List<WebElement> ok_got_it_btn) {
        if (isExist(ok_got_it_btn))
            ok_got_it_btn.get(0).click();
    }
}