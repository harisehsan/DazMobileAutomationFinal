package global.APP.pages;

import global.APP.getProperty.DeliveredOrderGetProperty;
import global.APP.pageObjects.OrderPageObject;
import global.APP.stepsDefinitions.OrderSteps;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ReturnRefund extends Base {
    OrderPageObject orderPageObject = new OrderPageObject();

    public ReturnRefund(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderPageObject);
    }

    DeliveredOrderGetProperty deliveredOrderGetProperty = new DeliveredOrderGetProperty();

    public void selectAllInMyOrders()
    {
        waitUntilPresentOfElementByString("All");
        findElementByString("All").click();
    }

    public void skipDeliveredGotItButton()
    {
       if (waitWithoutExceptionByStringLessTime("Got it"))
        findElementByString("Got it").click();
    }

    public boolean lookForTheOrderID(String productType) throws IOException {
        switch (System.getProperty("env")) {
            case "pk.live": {
             if (productType.equalsIgnoreCase("Normal")) {
                 scrollToOrderID(deliveredOrderGetProperty.pkNormal());
                 findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.pkNormal()).click();
             }
             else if (productType.equalsIgnoreCase("B1G1")) {
                 scrollToOrderID(deliveredOrderGetProperty.pkB1G1());
                 findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.pkB1G1()).click();
             }
             else if (productType.equalsIgnoreCase("Free Gift")) {
                 scrollToOrderID(deliveredOrderGetProperty.pkFG());
                 findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.pkFG()).click();
             }
             else if (productType.equalsIgnoreCase("Save more")) {
                 scrollToOrderID(deliveredOrderGetProperty.pkBMSM());
                 findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.pkBMSM()).click();
             }
             else
             {
                 scrollToOrderID(deliveredOrderGetProperty.pkCombo());
                 findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.pkCombo()).click();
             }
            }
            break;
            case "bd.live": {
                if (productType.equalsIgnoreCase("Normal")) {
                    scrollToOrderID(deliveredOrderGetProperty.bdNormal());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.bdNormal()).click();
                }
                else if (productType.equalsIgnoreCase("B1G1")) {
                    scrollToOrderID(deliveredOrderGetProperty.bdB1G1());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.bdB1G1()).click();
                }
                else if (productType.equalsIgnoreCase("Free Gift")) {
                    scrollToOrderID(deliveredOrderGetProperty.bdFG());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.bdFG()).click();
                }
                else if (productType.equalsIgnoreCase("Save more")) {
                    scrollToOrderID(deliveredOrderGetProperty.bdBMSM());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.bdBMSM()).click();
                }
                else
                {
                    scrollToOrderID(deliveredOrderGetProperty.bdCombo());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.bdCombo()).click();
                }
            }
            break;
            case "lk.live": {
                if (productType.equalsIgnoreCase("Normal")) {
                    scrollToOrderID(deliveredOrderGetProperty.lkNormal());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.lkNormal()).click();
                }
                else if (productType.equalsIgnoreCase("B1G1")) {
                    scrollToOrderID(deliveredOrderGetProperty.lkB1G1());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.lkB1G1()).click();
                }
                else if (productType.equalsIgnoreCase("Free Gift")) {
                    scrollToOrderID(deliveredOrderGetProperty.lkFG());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.lkFG()).click();
                }
                else if (productType.equalsIgnoreCase("Save more")) {
                    scrollToOrderID(deliveredOrderGetProperty.lkBMSM());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.lkBMSM()).click();
                }
                else
                {
                    scrollToOrderID(deliveredOrderGetProperty.lkCombo());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.lkCombo()).click();
                }
            }
            break;
            case "np.live": {
                if (productType.equalsIgnoreCase("Normal")) {
                    scrollToOrderID(deliveredOrderGetProperty.npNormal());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.npNormal()).click();
                }
                else if (productType.equalsIgnoreCase("B1G1")) {
                    scrollToOrderID(deliveredOrderGetProperty.npB1G1());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.npB1G1()).click();
                }
                else if (productType.equalsIgnoreCase("Free Gift")) {
                    scrollToOrderID(deliveredOrderGetProperty.npFG());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.npFG()).click();
                }
                else if (productType.equalsIgnoreCase("Save more")) {
                    scrollToOrderID(deliveredOrderGetProperty.npBMSM());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.npBMSM()).click();
                }
                else
                {
                    scrollToOrderID(deliveredOrderGetProperty.npCombo());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.npCombo()).click();
                }
            }
            break;
            default:
            {
                if (productType.equalsIgnoreCase("Normal")) {
                    scrollToOrderID(deliveredOrderGetProperty.mmNormal());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.mmNormal()).click();
                }
                else if (productType.equalsIgnoreCase("B1G1")) {
                    scrollToOrderID(deliveredOrderGetProperty.mmB1G1());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.mmB1G1()).click();
                }
                else if (productType.equalsIgnoreCase("Free Gift")) {
                    scrollToOrderID(deliveredOrderGetProperty.mmFG());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.mmFG()).click();
                }
                else if (productType.equalsIgnoreCase("Save more")) {
                    scrollToOrderID(deliveredOrderGetProperty.mmBMSM());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.mmBMSM()).click();
                }
                else
                {
                    scrollToOrderID(deliveredOrderGetProperty.mmCombo());
                    findElementByContentDescrpitionUsingContainString(deliveredOrderGetProperty.mmCombo()).click();
                }
            }

        }
        return true;
    }

    public void selectReturn()
    {
       int tries = 0;
        waitWithoutExceptionByTextContains("Order Details");
        while (!isExistByString("RETURN") && tries < 5) {
            swiptToBottom();
            tries++;
        }
        findElementByString("RETURN").click();
    }

    public void selectReturnReason()
    {
        waitUntilPresentOfElementByString("Select");
        findElementByString("Select").click();
     if (isExistByString("Item is defective"))
        findElementByString("Item is defective").click();
     else
         findElementByString("Defective").click();
        clickMultipleTries(orderPageObject.reason_Confirm_btn,4);
    }

    private void scrollToOrderID(String orderID)
    {
        int tries = 0;
//        while ((!isExistByString(orderID) || !isExistByString("Delivered")) && tries < 25) {
        while ((!isExistByString(orderID)) && tries < 35) {
           swiptToBottom();
           tries++;
        }
    }

    public void selectReturnShipmentMethod()
    {
//        scrollToSelectCourier();
        scrollDownMultipleTries(6);
        findElementByString("Select Courier").click();
        clickMultipleTries(orderPageObject.reason_Confirm_btn,6);
    }

    private void scrollToSelectCourier()
    {
        int tries = 0;
        while (!isExistByString("Select Courier") && tries < 5)
        {
            swiptToBottom();
            tries++;
        }
        findElementByString("Select Courier").click();
    }

    public void selectContinueButton()
    {
        waitUntilPresentOfElementByString("Continue");
        findElementByString("Continue").click();
    }

    public boolean verifyTheInformationOnReturnDeatilsScreen()
    {
        waitWithoutExceptionByTextContains("Return Details");
        if (isExistByString("Return Requested") || isExistByString("Return initiated") || isExistByString("Refunded"))
            return (isExistByString("Defective") || isExistByString("Item is defective"));
        else
            return false;
    }

    public void selectReturnCombo()
    {
       while (findElementsSizeByString("Return Combo"))
           findElementByString("Return Combo").click();
    }

    public void provideCommentsForReturn(String cancelComment)
    {
        waitWithoutExceptionForElements(orderPageObject.cancel_Comment_txt);
        try {
            orderPageObject.cancel_Comment_txt.get(orderPageObject.cancel_Comment_txt.size()-1).click();
        } catch (Exception e) {
            e.printStackTrace();
            orderPageObject.cancel_Comment_txt.get(orderPageObject.cancel_Comment_txt.size()-1).click();
        }
        try {
            orderPageObject.cancel_Comment_txt.get(orderPageObject.cancel_Comment_txt.size()-1).sendKeys(cancelComment);
        } catch (Exception e) {
            e.printStackTrace();
            orderPageObject.cancel_Comment_txt.get(orderPageObject.cancel_Comment_txt.size()-1).sendKeys(cancelComment);
        }
        hideKeyboard();
    }



}
