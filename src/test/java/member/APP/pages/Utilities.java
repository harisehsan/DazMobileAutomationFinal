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
    String bill_Banner = "O1CN01wuSgHr1zH9YMpKHNO_!!6000000006688-2-tps-750-350";
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
    String reloads_Paybills_Title_Lk = "Reloads & Pay Bills | Daraz.lk";
    String quick_Top_Up = "Quick Top Up";
    String limited_Time_offer = "Limited Time Offers";
    String how_To_bill = "HOW TO PAY YOUR BILL";
    String bill_LK_Price="50";
    String checkout_button = "Check Out";
    String spinner = "Spinner";
    String decimal_popup = "Do not enter decimal values";
    String savedConsumerNumbers = "Saved Consumer Numbers";


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

   public void waitforBillPageToLoad()
   {
       waitWithoutExceptionByText(savedConsumerNumbers);
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
        if(waitWithoutExceptionByTextContains(select_Company)) {
            return  (containsTextIsExist(account_Number)
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
        scrollDownMultipleTries(6);
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

    public void selectReloadAndPayBills()
    {
        waitWithoutExceptionByTextContains(reloads_Paybills_Lk);
        findElementByTextUsingContainsString(reloads_Paybills_Lk).click();
    }

    public boolean iShouldBeOnTheReloadAndPayBills()
    {
        return (waitWithoutExceptionByTextContains(reloads_Paybills_Title_Lk));
    }

    public void selectTheReload()
    {
        utilitiesPageObject.reload_lk.click();
    }

    public boolean quickTopUp()
    {
        return containsTextIsExist(quick_Top_Up);
    }


    public boolean verifyTheExtraDeatilsOfTheBillPage()
    {
        return (containsTextIsExist(limited_Time_offer)
                && containsTextIsExist(how_To_bill));
    }

    public void selectDBill()
    {
        waitWithoutExceptionByTextContains(reloads_Paybills_Lk);
        findElementByTextUsingContainsString(reloads_Paybills_Lk).click();
    }

    public void gotoTheCEB()
    {
        waitForElementToClickable(utilitiesPageObject.CEB_lk, 20);
        utilitiesPageObject.CEB_lk.click();
    }

    public void enterTheBillData(String billType) throws InterruptedException, IOException {
        waitForElementToClickable(utilitiesPageObject.account_Number_lk, 20);
        if (billType.equalsIgnoreCase("CEB"))
        {
            utilitiesPageObject.account_Number_txtbox.sendKeys(utilitiesGetProperty.lkBills().get(0));
            utilitiesPageObject.account_Number_txtbox.click();
            hideKeyboard();
        }
        else if(billType.equalsIgnoreCase("LECO"))
        {
            utilitiesPageObject.account_Number_txtbox.sendKeys(utilitiesGetProperty.lkBills().get(1));
        }
        else
        {
            utilitiesPageObject.account_Number_txtbox.sendKeys(utilitiesGetProperty.lkBills().get(2));
        }
        utilitiesPageObject.amount_lk.sendKeys(bill_LK_Price);
    }

    public void selectTheCheckoutButton()
    {
        int tries = 0;
        do {

            if (utilitiesPageObject.amount_lk.getText().equalsIgnoreCase(""))
                utilitiesPageObject.amount_lk.sendKeys(bill_LK_Price);
            if (containsTextIsExist(checkout_button))
                findElementByTextUsingContainsString(checkout_button).click();
            tries++;
            waitWithoutExceptionUntilAbsenceOfTheElement(spinner);
            waitWithoutExceptionUntilAbsenceOfTheElement(decimal_popup);
        }while(tries < 5 && containsTextIsExist(checkout_button));
    }
}