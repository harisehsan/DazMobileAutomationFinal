package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.getProperty.UtilitiesGetProperty;
import member.APP.pageObjects.UtilitiesPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Utilities extends Base {

    String dBills = "Pay Bills";
    String utilityCheckOut = "Utility Checkout";
    String Water = "Water";
    String Electricity = "Electricity";
    String Gas = "Gas";
    String telephone_And_Internet = "Telephone & Internet";
    String pay_Bills = "Pay Bill";
    String bill_Banner = "O1CN01NzTfsB1jrIxIuxpYh_!!6000000004601-2-tps-750-350";
    String payable_Amount = "Payable amount";
    String due_Date = "Due Date";
    String account_Number = "Account Number";
    String utility_Company = "Utility Company";
    String consumer_Name = "Consumer Name";
    String subtotal = "Subtotal";
    String recipt_Email = "Email to get the receipt";
    String total_Amount = "Total Amount";
    String proceed_To_Pay = "Proceed to Pay";
    String select_payment_Method = "Select Payment Method";
    String banner_page = "Pay Utility Bills";
    String add_New_Account = "Add New Account";
    String close_btn = "Close";
    String select_Company = "Select Company";
    String viewSampleBill = "View Sample Bill";
    String enterTheAccountNumber = "Enter Account Number";
    String checkThebillbtn = "Check the bill";
    String reloads_Paybills_Lk = "Reload &\\nPay Bills";


    UtilitiesPageObject utilitiesPageObject = new UtilitiesPageObject();
    UtilitiesGetProperty utilitiesGetProperty = new UtilitiesGetProperty();

    public Utilities(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), utilitiesPageObject);
    }

    public void selectDBills()
    {
        waitWithoutExceptionByTextContains(dBills);
        findElementByTextUsingContainsString(dBills).click();
    }

    public boolean iShouldBeOnTheUtilityCheckoutPage()
    {
       return waitWithoutExceptionByTextContains(utilityCheckOut);
    }

    public boolean iLookForTheSavedConsumerBills()
    {
       return (containsTextIsExist(Electricity) || containsTextIsExist(Water) || containsTextIsExist(Gas) || containsTextIsExist(telephone_And_Internet));
    }

    public void selectPayNowButton()
    {
        findElementByTextUsingContainsString(pay_Bills).click();
    }

    public boolean verifyTheBannerScreen()
    {
        return containsTextIsExist(bill_Banner);
    }

    public boolean verifyTheComponentsOfTheExistingBill()
    {
        return (waitWithoutExceptionByTextContains(payable_Amount)
                && containsTextIsExist(due_Date)
                && containsTextIsExist(account_Number)
                && containsTextIsExist(utility_Company)
                && containsTextIsExist(consumer_Name)
                && containsTextIsExist(subtotal)
                && containsTextIsExist(recipt_Email)
                && containsTextIsExist(total_Amount));
    }

    public void scrollToBanner()
    {
        scrollDownMultipleTries(6);
    }

    public void selectProceedToPayButton()
    {
        findElementByTextUsingContainsString(proceed_To_Pay).click();
    }

    public boolean iShouldBeOnTheSelectPaymentMethodScreen()
    {
        return waitWithoutExceptionByTextContains(select_payment_Method);
    }

    public void selectBanner()
    {
        findElementByTextUsingContainsString(bill_Banner).click();
    }

    public boolean iShouldBeOnThePayUtilityPage()
    {
        return waitWithoutExceptionByTextContains(banner_page);
    }

    public void selectAddNewAccount()
    {
        waitWithoutExceptionByTextContains(add_New_Account);
        findElementByTextUsingContainsString(add_New_Account).click();
    }

    public void selectTheBillType(String type)
    {
        waitWithoutExceptionByTextContains(close_btn);
        if (type.contains("Electricity"))
            utilitiesPageObject.electricity_lst_element.get(utilitiesPageObject.electricity_lst_element.size()-1).click();
        else if (type.contains("Water"))
            utilitiesPageObject.water_lst_element.get(utilitiesPageObject.water_lst_element.size()-1).click();
        else if(type.contains("Gas"))
            utilitiesPageObject.gas_lst_element.get(utilitiesPageObject.gas_lst_element.size()-1).click();
        else
            utilitiesPageObject.internet_lst_element.get(utilitiesPageObject.internet_lst_element.size()-1).click();
    }

    public boolean verifyTheComponentsOfTheNewBillForm(String type)
    {
        if(waitWithoutExceptionByTextContains(type)) {
            return  (containsTextIsExist(select_Company)
                    && containsTextIsExist(account_Number)
                    && containsTextIsExist(viewSampleBill));
        }
        return false;
    }

    public void iEnterTheAccountNumber(String type) throws IOException {
//        utilitiesPageObject.account_Number_txtbox.click();
        if (type.contains("Electricity"))
            utilitiesPageObject.account_Number_txtbox.sendKeys(utilitiesGetProperty.eletricityBill().get(0));
        else if (type.contains("Water")) {
            utilitiesPageObject.account_Number_txtbox.sendKeys(utilitiesGetProperty.waterBill().get(0));
        }
        else if(type.contains("Gas"))
            utilitiesPageObject.account_Number_txtbox.sendKeys(utilitiesGetProperty.gasBill().get(0));
        else
            utilitiesPageObject.account_Number_txtbox.sendKeys(utilitiesGetProperty.internetBill().get(0));
         hideKeyboard();
            utilitiesPageObject.account_Number_txtbox.click();
    }

    public void checkTheBill(String type)
    {
        waitWithoutExceptionByTextContains(type);
      hideKeyboard();
      scrollDownMultipleTries(12);
        clickMultipleTries(utilitiesPageObject.checkTheBillBtn,5);
    }

    public boolean verifyTheDataOfBill(String type) throws IOException {
        waitWithoutExceptionByTextContains(proceed_To_Pay);
        if (type.contains("Electricity"))
        {
            return  (containsTextIsExist(utilitiesGetProperty.eletricityBill().get(0))
                    && containsTextIsExist(utilitiesGetProperty.eletricityBill().get(1))
                    && containsTextIsExist(utilitiesGetProperty.eletricityBill().get(2)));
        }
        else if (type.contains("Water"))
        {
            return  (containsTextIsExist(utilitiesGetProperty.waterBill().get(0))
                    && containsTextIsExist(utilitiesGetProperty.waterBill().get(1))
                    && containsTextIsExist(utilitiesGetProperty.waterBill().get(2)));
        }

        else if(type.contains("Gas"))
        {
            return  (containsTextIsExist(utilitiesGetProperty.gasBill().get(0))
                    && containsTextIsExist(utilitiesGetProperty.gasBill().get(1))
                    && containsTextIsExist(utilitiesGetProperty.gasBill().get(2)));
        }

        else
        {
            return  (containsTextIsExist(utilitiesGetProperty.internetBill().get(0))
                    && containsTextIsExist(utilitiesGetProperty.internetBill().get(1))
                    && containsTextIsExist(utilitiesGetProperty.internetBill().get(2)));
        }

    }

    public void returnToTheUtilityCheckoutScreen()
    {
       int tries =0;
        do {
            driver.navigate().back();
            tries++;
        }while(!containsTextIsExist(add_New_Account) && tries < 5);
    }




}
