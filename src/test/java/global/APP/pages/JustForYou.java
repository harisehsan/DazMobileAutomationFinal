package global.APP.pages;

import global.APP.getProperty.JustForYouGetProperty;
import global.APP.getProperty.JustForYouSetProperty;
import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.JustForYouPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-October-2019
 */

public class JustForYou extends Base {

    JustForYouPageObject justForYouPageObject = new JustForYouPageObject();
    JustForYouSetProperty justForYouSetProperty = new JustForYouSetProperty();
    CartPageObjects cartPageObjects = new CartPageObjects();
    SearchPageObject searchPageObj = new SearchPageObject();
    JustForYouGetProperty justForYouGetProperty = new JustForYouGetProperty();

    public JustForYou(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), justForYouPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
    }

    int productID;

    public boolean checkTheExistenceofJustForYou() {
        int tries = 20;
        int j=0;
        scrollDownMultipleTries(4);
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            for (int i = 0; i < tries; i++) {
                if (isExist(justForYouPageObject.just_For_You_title_lbl))
                {
                    while ((!isExist(justForYouPageObject.rating_bar) || !isExist(justForYouPageObject.discount_lbl)) && j < 15) {
                        swiptToBottom();
                        j++;
                    }
                    return true;
                }
                else
                    swiptToBottom();
            }
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(justForYouPageObject.just_For_You_title_lbl_MM))
                {
                    while ((!isExist(justForYouPageObject.rating_bar_MM) || !isExist(justForYouPageObject.discount_lbl_MM)) && j < 15) {
                        swiptToBottom();
                        j++;
                    }
                    return true;
                }
                else
                    swiptToBottom();
            }
        }
        return false;
    }

    public boolean verifyProductTitleAndPrice() throws IOException {
        productID = selectTheDiscountableProducts();
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
           justForYouSetProperty.setProductInformation(justForYouPageObject.product_Title_lbl.get(productID).getText(),justForYouPageObject.display_Price_lbl.get(productID).getText());
           return (isExist(justForYouPageObject.product_Title_lbl) && isExist(justForYouPageObject.display_Price_lbl) && isExist(justForYouPageObject.rating_bar));

        }
        else
        {
            justForYouSetProperty.setProductInformation(justForYouPageObject.product_Title_lbl_MM.get(productID).getText(),justForYouPageObject.display_Price_lbl_MM.get(productID).getText());
            return (isExist(justForYouPageObject.product_Title_lbl_MM) && isExist(justForYouPageObject.display_Price_lbl_MM) && isExist(justForYouPageObject.rating_bar_MM));
        }
    }

    public boolean verifyTheOriginalAndDiscountRate() throws IOException {
        int discountProductID;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (justForYouPageObject.discount_lbl.size()==1 || justForYouPageObject.original_Price_lbl.size()==1)
                discountProductID = (justForYouPageObject.original_Price_lbl.size()-1);
            else
                discountProductID = productID;
              justForYouSetProperty.setProductDiscountInformation(justForYouPageObject.discount_lbl.get(discountProductID).getText(), justForYouPageObject.original_Price_lbl.get(discountProductID).getText());
              return (isExist(justForYouPageObject.discount_lbl) && isExist(justForYouPageObject.original_Price_lbl));
        }
        else
        {
            if (justForYouPageObject.discount_lbl_MM.size()==1 || justForYouPageObject.original_Price_lbl_MM.size()==1)
                discountProductID = (justForYouPageObject.original_Price_lbl_MM.size()-1);
            else
                discountProductID = productID;
            justForYouSetProperty.setProductDiscountInformation(justForYouPageObject.discount_lbl_MM.get(discountProductID).getText(),justForYouPageObject.original_Price_lbl_MM.get(discountProductID).getText());
            return (isExist(justForYouPageObject.discount_lbl_MM) && isExist(justForYouPageObject.original_Price_lbl_MM));
        }
    }

    public int selectTheDiscountableProducts()
    {
        int k=0;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
        for (int j=0;j<3;j++) {
            for (int i = 0; i < justForYouPageObject.product_Title_lbl.size(); i++) {
                justForYouPageObject.product_Title_lbl.get(i).click();
                if (isExist(cartPageObjects.overseas_Confirm_btn))
                    cartPageObjects.overseas_Confirm_btn.get(0).click();
                if (isExist(searchPageObj.ok_Got_It_btn))
                    searchPageObj.ok_Got_It_btn.get(0).click();
                if (isExist(justForYouPageObject.discount_Pdp_lbl) && isExist(justForYouPageObject.rating_Pdp_bar)) {
                    driver.navigate().back();
                    return i;
                } else
                    driver.navigate().back();
            }
            scrollDownMultipleTries(2);
            while ((!isExist(justForYouPageObject.rating_bar) || !isExist(justForYouPageObject.discount_lbl)) && k < 10) {
                swiptToBottom();
                k++;
            }
        }
           throw new RuntimeException("There is no discountable product is available!");
        }
        else
        {
            for (int j=0;j<2;j++) {
                for (int i = 0; i < justForYouPageObject.product_Title_lbl_MM.size(); i++) {
                    justForYouPageObject.product_Title_lbl_MM.get(i).click();
                    if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                        cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
                    if (isExist(searchPageObj.ok_Got_It_btn_MM))
                        searchPageObj.ok_Got_It_btn_MM.get(0).click();
                    if (isExist(justForYouPageObject.discount_Pdp_lbl_MM) && isExist(justForYouPageObject.rating_Pdp_bar_MM)) {
                        driver.navigate().back();
                        return i;
                    } else
                        driver.navigate().back();
                }
                scrollDownMultipleTries(2);
                while ((!isExist(justForYouPageObject.rating_bar_MM) || !isExist(justForYouPageObject.discount_lbl_MM)) && k < 10) {
                    swiptToBottom();
                    k++;
                }
            }
            throw new RuntimeException("There is no discountable product is available!");
        }
    }

    public void navigateToPDPPage()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            justForYouPageObject.product_Title_lbl.get(productID).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
        }
        else
        {
         justForYouPageObject.product_Title_lbl_MM.get(productID).click();
         if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
             cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
         if (isExist(searchPageObj.ok_Got_It_btn_MM))
             searchPageObj.ok_Got_It_btn_MM.get(0).click();
        }
    }

    public boolean verifyPDPPageItems() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            return (justForYouPageObject.product_Title_pdp.getText().contains(justForYouGetProperty.productTitle())
                    &&  justForYouPageObject.display_Price_On_Pdp_lbl.getText().replaceAll("\\D+","").contains(justForYouGetProperty.displayedPrice())
                    && (justForYouPageObject.original_Price_On_Pdp_lbl.getText().replaceAll("\\D+","").contains(justForYouGetProperty.originalPrice()))
                    && (justForYouPageObject.discount_Pdp_lbl.get(0).getText().contains(justForYouGetProperty.discountRate())));
        }
        else
        {
            return (justForYouPageObject.product_Title_pdp_MM.getText().contains(justForYouGetProperty.productTitle())
                    &&  justForYouPageObject.display_Price_On_Pdp_lbl_MM.getText().replaceAll("\\D+","").contains(justForYouGetProperty.displayedPrice())
                    && (justForYouPageObject.original_Price_On_Pdp_lbl_MM.getText().replaceAll("\\D+","").contains(justForYouGetProperty.originalPrice()))
                    && (justForYouPageObject.discount_Pdp_lbl_MM.get(0).getText().contains(justForYouGetProperty.discountRate())));
        }
    }

    public boolean verifyJustForYouInLocalLanguage() throws IOException {
        int tries = 20;
        scrollDownMultipleTries(4);
        for (int i = 0; i < tries; i++) {
            switch (System.getProperty("env")) {
                case "bd.live": {
                    if (isExistByText("শুধু আপনার জন্য"))
                        return true;
                    else
                        swiptToBottom();
                }
                break;
                case "lk.live": {
                    if (isExistByText("ඔබ වෙනුවෙන්ම"))
                        return true;
                    else
                        swiptToBottom();
                }
                break;
                case "np.live": {
                    if (isExistByText("तपाईंको लागि मात्र"))
                        return true;
                    else
                        swiptToBottom();
                }
                break;
                case "mm.live": {
                    if (isExistByText("သင့္အတြက္"))
                        return true;
                    else
                        swiptToBottom();
                }
                break;
                default:
                    return false;
            }
        }
        return false;
    }
}
