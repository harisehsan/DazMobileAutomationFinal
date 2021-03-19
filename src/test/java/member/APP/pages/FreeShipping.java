package member.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.FreeShippingPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FreeShipping extends Base {

    FreeShippingPageObject freeShippingPageObject = new FreeShippingPageObject();
    CartPageObjects cartPageObjects = new CartPageObjects();

    String enjoyFreeShipping = "Yay!Enjoyed free shipping";
    String freeText = "Free";

    public FreeShipping(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freeShippingPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
    }

    public boolean verifyTheFreeShippingText()
    {
       waitForElementToClickable(freeShippingPageObject.free_Shipping_Message.get(0));
       return (freeShippingPageObject.free_Shipping_Message.get(0).getText().contains(enjoyFreeShipping));
    }

    public boolean verifyTheContentOfTheFreeShippingOnCart()
    {
        return (isExist(freeShippingPageObject.buy_More_btn) &&
                freeShippingPageObject.shipping_Fee_lbl.getText().contains(freeText));
    }

    public boolean compareTheProductPriceWithTotalPrice()
    {
        return (freeShippingPageObject.total_Price_Cart.getText().contains(freeShippingPageObject.product_Price_lbl.getText()));
    }

    public boolean verifyTheShippingFeeDiscount()
    {
        int tries =0;
        while (!isExist(freeShippingPageObject.shipping_Fee_Discount_Checkout))
        {
           swiptToBottom();
           tries++;
        }

        return (freeShippingPageObject.shipping_Fee_Discount_Checkout.get(0).getText().contains("Shipping Fee Discount"));
    }

    public void addTheProductsTillFreeShippingIsDisplayed()
    {
       int index = 0;
        waitForElementToClickable(freeShippingPageObject.buy_More_btn.get(0));
        while(!freeShippingPageObject.free_Shipping_Message.get(0).getText().contains(enjoyFreeShipping))
        {
            freeShippingPageObject.buy_More_btn.get(0).click();
            waitForElementToClickable(freeShippingPageObject.mini_Promotion_title);
            freeShippingPageObject.add_To_Cart_Free_Shipping_btn.get(index).click();
            freeShippingPageObject.shipping_Product_Popup_close_btn.click();
            cartPageObjects.select_All_chkbox.click();
            index++;
            waitForElementToClickable(freeShippingPageObject.free_Shipping_Message.get(0));
        }
    }
}
