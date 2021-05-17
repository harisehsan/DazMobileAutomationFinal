package global.APP.pages;

import global.APP.getProperty.OrderGetProperty;
import global.APP.getProperty.OrderSetProperty;
import global.APP.pageObjects.CheckOutPageObjects;
import global.APP.pageObjects.OrderPageObject;
import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 10-July-2019
 */

public class Order extends Base {

    OrderPageObject orderPageObject = new OrderPageObject();
    OrderSetProperty orderSetProperty = new OrderSetProperty();
    OrderGetProperty orderGetProperty = new OrderGetProperty();
    SearchPageObject searchPageObj = new SearchPageObject();
    CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();

    public Order(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
    }

    public void clickOnCancelOrder() {
        waitForElement(orderPageObject.order_Cancel_btn).isDisplayed();
        orderPageObject.order_Cancel_btn.click();
        if (waitWithoutExceptionByString("Cancel Combo"))
            findElementByContentDescrpitionUsingContainString("Cancel Combo").click();
    }

    public void selectReasonForCancellation(List<String> cancellationReason)  {
        int tries = 0;
        int Index = randomNumberGenerator(cancellationReason.size());
        waitUntilPresentOfElementBy(orderPageObject.select_Reason_btn_by);
        do {
            orderPageObject.select_Reason_btn.click();
            try {
                waitUntilPresentOfElementByString(cancellationReason.get(Index));
                clickElementMultipleTriesUsingString(cancellationReason.get(Index), 3);
            } catch (Exception e) {
                e.printStackTrace();
                Index = randomNumberGenerator(cancellationReason.size());
                waitUntilPresentOfElementByString(cancellationReason.get(Index));
                clickElementMultipleTriesUsingString(cancellationReason.get(Index), 3);
            }
            do {
                clickMultipleTries(orderPageObject.reason_Confirm_btn,6);
                tries++;
            }while (isExist(orderPageObject.reason_Confirm_btn) && tries < 4);
        } while (!(waitWithoutExceptionByString(cancellationReason.get(Index))));
    }

    public void cancellationComment(String cancelComment)
    {
        waitWithoutExceptionForElements(orderPageObject.cancel_Comment_txt);
        orderPageObject.cancel_Comment_txt.get(orderPageObject.cancel_Comment_txt.size()-1).sendKeys(cancelComment);
    }

    public void submitCancellation()
    {
       orderPageObject.cancel_Submit_btn.click();
    }

    public boolean verifyCancellationStatus()
    {
        if (isExist(orderPageObject.cancelled_lbl))
            return true;
       else
       {
           return containsTextIsExist("Cancelled Item");
       }
    }

    public String verifyCancelAmount(String amount)
    {
       return findElementByTextUsingExactString(amount).getAttribute("text");
    }

    public boolean verifyProductNameOnCancellationScreen(String productName)
    {
        int tries = 0;
        waitWithoutExceptionByTextContains("Cancellation");
        while (!isExistByString(productName) && tries < 10 )
        {
            swiptToBottom();
            tries++;
        }
//        return productName.contains(findElementByString(productName).getAttribute("contentDescription"));
        return isExistByString(productName);
    }

    public void skipFirstOrderVoucherPopup()
    {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            if (isExist(orderPageObject.first_Voucher_Close_btn))
                orderPageObject.first_Voucher_Close_btn.get(0).click();
        }
        else
        {
            if (isExist(orderPageObject.first_Voucher_Close_btn_MM))
                orderPageObject.first_Voucher_Close_btn_MM.get(0).click();
        }
    }

    public void clickOnSellerName()
    {
        if (findElementsSizeByString("Sold by"))
            findElementByContentDescrpitionUsingContainString("Sold by").click();
        else
            throw new RuntimeException("Seller name is not displayed on order details page!");
    }

    public boolean iShouldBeOnTheSellerShop()
    {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            if (isExist(searchPageObj.got_It_Store_btn))
                searchPageObj.got_It_Store_btn.get(0).click();
        }
        else
        {
            if (isExist(searchPageObj.got_It_Store_btn_MM))
                searchPageObj.got_It_Store_btn_MM.get(0).click();
        }
        waitUntilPresentOfElementByText("Search in Store");
        return isExistByText("Search in Store");
    }

    public boolean verifyTheTitleOfAddresses()
    {
            waitWithoutExceptionByTextContains("Order Details");
            if (findElementsSizeByString("Shipping Address") && findElementsSizeByString("Billing Address"))
                return true;
            else return findElementsSizeByString("Ship & bill to");
    }

    public void clickOnPayNowButton()
    {
        findElementsSizeByString("PAY NOW");
        findElementByContentDescrpitionUsingContainString("PAY NOW").click();
    }

    public boolean verifyTheOrderTotalPrice(String totalPrice)
    {
       int tries = 0;
       while (!findElementsSizeByString("Total:") && tries < 10)
       {
           swiptToBottom();
           tries++;
       }
       return (findElementsSizeByString("Total:") && findElementsSizeByString(totalPrice));
    }

    public boolean verifyTheOrderPaymentMethod()
    {
        int tries = 0;
        while (!findElementsSizeByString("Paid by") && tries < 10)
        {
            swiptToBottom();
            tries++;
        }
        return (findElementsSizeByString("Paid by") && findElementByContentDescrpitionUsingContainString("Cash").getAttribute("content-desc").toLowerCase().equalsIgnoreCase("cash on delivery"));
    }

    public void waitForThePaymentScreen()
    {
        waitUntilPresentOfElementByText("Select Payment Method");
    }

    public void iSaveTheShippingAddress() throws IOException {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(orderPageObject.shipping_Address_Checkout_lbl_By);
          orderSetProperty.shippingAddress(orderPageObject.shipping_Address_Checkout_lbl.getText());
        }
        else
        {
            waitUntilPresentOfElementBy(orderPageObject.shipping_Address_Checkout_lbl_By_MM);
            orderSetProperty.shippingAddress(orderPageObject.shipping_Address_Checkout_lbl_MM.getText());
        }
    }

    public boolean verifyTheShippingAddressOnOrderDetailsPage(String shippingAddress) throws IOException {
       return waitWithoutExceptionByString(shippingAddress);
    }

    public void saveTheTotalPriceOnCheckout() throws IOException {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            orderSetProperty.totalPrice(checkOutPageObjects.total_Price_On_Checkout.getText());
        }
        else
        {
            orderSetProperty.totalPrice(checkOutPageObjects.total_Price_On_Checkout_MM.getText());
        }
    }

    public boolean verifyTheOrderStatusOrderNumberAndOrderDate()
    {
        int count = 0;
        waitWithoutExceptionByString("Payment Pending");
        while (!findElementsSizeByString("Order #") && count < 10)
        {
            swiptToBottom();
            count++;
        }
        String [] date = currentDateSplit();
        return (findElementsSizeByString("Payment Pending")
                && (!findElementByContentDescrpitionUsingContainString("Order #").getAttribute("contentDescription").replaceAll("[^\\d]","").equalsIgnoreCase(""))
                &&(findElementByContentDescrpitionUsingContainString("Placed on").getAttribute("content-desc")).contains(date[0])
                && (findElementByContentDescrpitionUsingContainString("Placed on").getAttribute("content-desc")).contains(date[2]));
    }

    public void pressOrderNumber()
    {
        int tries = 0;
        while (!findElementsSizeByString("Subtotal") && tries < 5 ) {
            swiptToBottom();
            tries++;
        }
        findElementByContentDescrpitionUsingContainString("Order #").click();
    }

    public boolean verifyTheCopiedText()
    {
       int tries = 0;
       do {
           if (isExistByText("Copied"))
               return true;
           swiptToBottom();
           findElementByContentDescrpitionUsingContainString("Order #").click();
           tries++;
       }while (tries < 5);
       return false;
    }

    public boolean verifyTheOrderRecievedPage()
    {
        waitWithoutExceptionByText("Order Received");
        return isExistByText("Order Received");
    }

    public boolean verifyThePromotionlabel(String promotionName){

        return findElementsSizeByString(promotionName);
    }
}