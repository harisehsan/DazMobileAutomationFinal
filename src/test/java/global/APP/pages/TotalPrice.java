package global.APP.pages;

import global.APP.getProperty.TotalPriceGetProperty;
import global.APP.getProperty.TotalPriceSetProperty;
import global.APP.pageObjects.TotalPricePageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalPrice extends Base {

    TotalPricePageObject totalPricePageObject = new TotalPricePageObject();
    TotalPriceSetProperty totalPriceSetProperty = new TotalPriceSetProperty();
    TotalPriceGetProperty totalPriceGetProperty = new TotalPriceGetProperty();

    public TotalPrice(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), totalPricePageObject);
    }

    public void priceCalculationOnCheckout() throws IOException {
        List<Integer> priceDataCheckoutlst = new ArrayList<>();
        int totalprice= 0;
        for (int i=0;i<totalPricePageObject.checkout_Price_data.size();i++) {
            if (!totalPricePageObject.checkout_Price_data.get(i).getText().contains("-"))
                priceDataCheckoutlst.add(convertToIntFromString(totalPricePageObject.checkout_Price_data.get(i).getText()));
            else
                priceDataCheckoutlst.add(convertToIntFromString(totalPricePageObject.checkout_Price_data.get(i).getText())*(-1));
        }
        for (Integer value : priceDataCheckoutlst) totalprice = totalprice + value;
        totalPriceSetProperty.setCheckoutCommulativePrice(String.valueOf(totalprice));
    }

    public boolean verifyTheCalculatedPriceWithTotalPriceCart() throws IOException {
       return (convertToIntFromString(totalPriceGetProperty.getCheckoutCommulativePrice()) == convertToIntFromString(totalPricePageObject.total_Price_Checkout_lbl.getText()));
    }

    public void priceCalculationOnCart() throws IOException {
        List<String> shippingfeelst = new ArrayList<>();
        shippingfeelst.addAll(Arrays.asList(totalPricePageObject.shipping_Price_Cart.get(0).getText().split(" ")));

        List<Integer> priceDataCartlst = new ArrayList<>();
        int totalPriceCart =0;
        for (int i=0; i<totalPricePageObject.product_Price_Cart.size(); i++)
        {
            if (!totalPricePageObject.product_Price_Cart.get(i).getText().contains("FREE")) {
                priceDataCartlst.add(convertToIntFromString(totalPricePageObject.product_Price_Cart.get(i).getText()) * convertToIntFromString(totalPricePageObject.product_Quantity_Cart.get(i).getText()));
            }
        }

        for (int j=0; j<totalPricePageObject.shipping_Price_Cart.size(); j++)
        {
            if (j==0) {
                if (!totalPricePageObject.shipping_Price_Cart.get(j).getText().contains("Free"))
                    priceDataCartlst.add(convertToIntFromString(shippingfeelst.get(shippingfeelst.size()-1)));
            }
            if (j==1) {
                priceDataCartlst.add(convertToIntFromString(totalPricePageObject.shipping_Price_Cart.get(j).getText())* (-1));
            }
        }
        for (Integer value : priceDataCartlst) {
            totalPriceCart = totalPriceCart + value;
        }
        totalPriceSetProperty.setCartCommulativePrice(String.valueOf(totalPriceCart));
        totalPriceSetProperty.setCartTotalPrice(String.valueOf(convertToIntFromString(totalPricePageObject.total_Price_Cart.getText())));
    }

    public boolean compareTheCartCalculatedPriceWithTotalPrice() throws IOException {
        return (convertToIntFromString(totalPriceGetProperty.getCartCommulativePrice()) == convertToIntFromString(totalPriceGetProperty.getCartTotalPrice()));
    }

    public boolean compareTheTotalPriceofCartAndCheckout() throws IOException {
        return (convertToIntFromString(totalPricePageObject.total_Price_Checkout_lbl.getText()) == convertToIntFromString(totalPriceGetProperty.getCartTotalPrice()));
    }

    public void saveTheAddressDetails() throws IOException {
        waitForElementToClickable(totalPricePageObject.address_txtBox.get(2),30);
        totalPriceSetProperty.setAddressProvince(totalPricePageObject.address_txtBox.get(2).getText());
        totalPriceSetProperty.setAddressCity(totalPricePageObject.address_txtBox.get(3).getText());
        totalPriceSetProperty.setAddressArea(totalPricePageObject.address_txtBox.get(4).getText());
    }

    public void selectDefaultAddressOnPDP() throws IOException {
       int tries = 0;
        while (!isExist(totalPricePageObject.address_pdp_btn) && tries <15){
            swiptToBottom();
            tries++;
        }
        totalPricePageObject.address_pdp_btn.get(0).click();
        waitForElementToClickable(totalPricePageObject.address_Location_tree_lbl,15);
        while (!textIsExist(totalPriceGetProperty.getAddressProvince()) && tries < 30) {
            swiptToBottom();
            tries++;
        }
        findElementByTextUsingExactString(totalPriceGetProperty.getAddressProvince()).click();
        waitForElementToClickable(totalPricePageObject.address_Location_tree_lbl,15);
        while (!textIsExist(totalPriceGetProperty.getAddressCity()) && tries < 30) {
            swiptToBottom();
            tries++;
        }
        findElementByTextUsingExactString(totalPriceGetProperty.getAddressCity()).click();
        waitForElementToClickable(totalPricePageObject.address_Location_tree_lbl,15);
        while (!textIsExist(totalPriceGetProperty.getAddressArea()) && tries < 30) {
            swiptToBottom();
            tries++;
        }
        findElementByTextUsingExactString(totalPriceGetProperty.getAddressArea()).click();
    }
}