package global.APP.pages;

import global.APP.pageObjects.OrderPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 10-July-2019
 */

public class Order extends Base {

    OrderPageObject orderPageObject = new OrderPageObject();

    public Order(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderPageObject);
    }

    public void clickOnCancelOrder() {
        waitUntilPresentOfElementBy(orderPageObject.order_Cancel_btn_by);
        orderPageObject.order_Cancel_btn.click();
    }

    public void selectReasonForCancellation(List<String> cancellationReason)  {
        int tries = 0;
        int Index = randomNumberGenerator(cancellationReason.size());
        waitUntilPresentOfElementBy(orderPageObject.select_Reason_btn_by);
        do {
            orderPageObject.select_Reason_btn.click();
            waitUntilPresentOfElementByString(cancellationReason.get(Index));
            clickElementMultipleTriesUsingString(cancellationReason.get(Index), 3);
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
       waitUntilPresentOfElementBy(orderPageObject.cancelled_lbl_by);
       return isExist(orderPageObject.cancelled_lbl);
    }

    public String verifyCancelAmount(String amount)
    {
       return findElementByTextUsingExactString(amount).getAttribute("text");
    }

    public boolean verifyProductNameOnCancellationScreen(String productName)
    {
        waitUntilPresentOfElementByString(productName);
        return productName.contains(findElementByString(productName).getAttribute("contentDescription"));
    }

}