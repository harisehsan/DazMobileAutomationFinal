package global.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.CheckOutPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-June-2019
 */

public class CheckOut extends Base {

    CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();
    CartPageObjects cartPageObjects = new CartPageObjects();

    int price;

    public CheckOut(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
    }

    public String selectProductForCheckout() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
            if (cartPageObjects.searchProduct_lbl_MM.size() < 4)
                productNameVisibleScroll();
            for (int i = 0; i <= 1; ++i) {
                for (int j = 0; j < cartPageObjects.searchProduct_lbl.size(); j++) {
                    waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                    if ((System.getProperty("env").equalsIgnoreCase("pk.live"))) {
                        price = Integer.parseInt(checkOutPageObjects.product_Price.get(j).getText().replace("Rs. ", ""));
                        if (price < 150)
                            continue;
                    }
                    cartPageObjects.searchProduct_lbl.get(j).click();
                    if (waitWithoutException(cartPageObjects.overseas_Confirm_btn))
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
            for (int i = 0; i <= 1; ++i) {
                for (int j = 0; j < cartPageObjects.searchProduct_lbl_MM.size(); j++) {
                    waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_MM_By);
                    cartPageObjects.searchProduct_lbl_MM.get(j).click();
                    if (waitWithoutException(cartPageObjects.overseas_Confirm_btn_MM))
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

    public void selectbuyNow() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            cartPageObjects.buy_Now_btn.get(0).click();
        else
            cartPageObjects.buy_Now_btn_MM.get(0).click();
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
        if ((System.getProperty("env").equalsIgnoreCase("np.live")) || (System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitWithoutException(checkOutPageObjects.cod_lbl_MM);
            checkOutPageObjects.cod_lbl_MM.click();
        } else {
            waitWithoutException(checkOutPageObjects.cod_lbl);
            checkOutPageObjects.cod_lbl.click();
        }
        waitUntilPresentOfElementBy(checkOutPageObjects.confirm_Order_btn_By);
        checkOutPageObjects.confirm_Order_btn.click();
        waitUntilPresentOfElementBy(checkOutPageObjects.track_Order_btn_By);
        checkOutPageObjects.track_Order_btn.click();
    }

    public boolean verifyCheckOutItem(String productName) {
        waitUntilPresentOfElementByString(productName);
        String Name = (findElementByString(productName).getAttribute("contentDescription"));
        if (Name.length() > 40)
              Name = Name.substring(0,40);
         return (productName.contains(Name));
    }

    public int selectProductFromCart(String productName) {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            cartPageObjects.ok_Got_It_btn.get(0).click();
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); ++i) {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productName)) {
                    if (cartPageObjects.product_chkbox.get(i).getAttribute("checked").equalsIgnoreCase("false"))
                        cartPageObjects.product_chkbox.get(i).click();
                    return i;
                }
            }
            throw new RuntimeException("Required Product is not added to cart!");
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); ++i) {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productName)) {
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
            if(isExist(checkOutPageObjects.cart_item_container.get(index).findElements(checkOutPageObjects.available_quantity_By))) {
                availableQuantity = Integer.parseInt(checkOutPageObjects.cart_item_container.get(index).findElements(checkOutPageObjects.available_quantity_By).get(0).getText().replaceAll("\\D+",""));
                if (availableQuantity < quantity){
                    System.out.println("The available quantity for this item is not enough as the specified quantity. So that the specified quantity is changed to "+availableQuantity);
                    quantity = availableQuantity;
                }
            }
             currentItemQuantity = Integer.parseInt(checkOutPageObjects.quantity_lbl.getText());
            if (currentItemQuantity < quantity) {
                for (int i = currentItemQuantity; i < quantity; i++) {
                    waitForElementToClickable(checkOutPageObjects.quantity_increase_btn);
                    checkOutPageObjects.quantity_increase_btn.click();
                }
            } else if (currentItemQuantity > quantity) {
                for (int i = currentItemQuantity; i > quantity; i--) {
                    waitForElementToClickable(checkOutPageObjects.quantity_decrese_btn);
                    checkOutPageObjects.quantity_decrese_btn.click();
                }
            } else {
                System.out.println("Specified quantity is already applied or not applicable yet!");
            }

        } else {
            if(isExist(checkOutPageObjects.cart_item_container_MM.get(index).findElements(checkOutPageObjects.available_quantity_MM_By))) {
                availableQuantity = Integer.parseInt(checkOutPageObjects.cart_item_container_MM.get(index).findElements(checkOutPageObjects.available_quantity_MM_By).get(0).getText().replaceAll("\\D+",""));
                if (availableQuantity < quantity){
                    System.out.println("The available quantity for this item is not enough as the specified quantity. So that the specified quantity is changed to "+availableQuantity);
                    quantity = availableQuantity;
                }
            }
             currentItemQuantity = Integer.parseInt(checkOutPageObjects.quantity_lbl_MM.getText());
            if (currentItemQuantity < quantity) {
                for (int i = currentItemQuantity; i < quantity; i++) {
                    waitForElementToClickable(checkOutPageObjects.quantity_increase_btn_MM);
                    checkOutPageObjects.quantity_increase_btn_MM.click();
                }
            } else if (currentItemQuantity > quantity) {
                for (int i = currentItemQuantity; i > quantity; i--) {
                    waitForElementToClickable(checkOutPageObjects.quantity_decrese_btn_MM);
                    checkOutPageObjects.quantity_decrese_btn_MM.click();
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

    public String verifyTheQuantity(int quantity)
    {
       return findElementByExactString(Integer.toString(quantity)).getAttribute("contentDescription");
    }
}