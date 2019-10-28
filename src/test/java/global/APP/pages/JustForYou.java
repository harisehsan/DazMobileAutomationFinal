package global.APP.pages;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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

    boolean isExistproductRating = false;

    public JustForYou(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), justForYouPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
    }

    public boolean checkTheExistenceofJustForYou() {
        int tries = 20;
        int j = 0;
        scrollDownMultipleTries(4);
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            for (int i = 0; i < tries; i++) {
                if (isExist(justForYouPageObject.just_For_You_title_lbl)) {
                    while ((!isExist(justForYouPageObject.discount_lbl))) {
                        swiptToBottom();
                        j++;
                    }
                    return true;
                } else
                    swiptToBottom();
            }
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(justForYouPageObject.just_For_You_title_lbl_MM)) {
                    while (!isExist(justForYouPageObject.discount_lbl_MM)){
                        swiptToBottom();
                        j++;
                    }
                    return true;
                } else
                    swiptToBottom();
            }
        }
        return false;
    }

    public void collectProductInformation() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            justForYouSetProperty.setProductInformation(justForYouPageObject.product_Title_pdp.getText(), justForYouPageObject.display_Price_On_Pdp_lbl.getText());
            justForYouSetProperty.setProductDiscountInformation(justForYouPageObject.discount_Pdp_lbl.get(0).getText(), justForYouPageObject.original_Price_On_Pdp_lbl.getText());
            if (isExist(justForYouPageObject.rating_Pdp_bar))
                isExistproductRating = true;

        } else {
            justForYouSetProperty.setProductInformation(justForYouPageObject.product_Title_pdp_MM.getText(), justForYouPageObject.display_Price_On_Pdp_lbl_MM.getText());
            justForYouSetProperty.setProductDiscountInformation(justForYouPageObject.discount_Pdp_lbl_MM.get(0).getText(), justForYouPageObject.original_Price_On_Pdp_lbl_MM.getText());
            if (isExist(justForYouPageObject.rating_Pdp_bar_MM))
                isExistproductRating = true;
        }
    }

    public boolean verifyProductInformationInJustForYouSection() throws IOException {
     int tries =5;
     boolean isExistDiscountRate = false;
     boolean isExistProductTitle =false;
     boolean isExistDisplayedPrice = false;
     boolean isExistedOriginalPrice =false;
     boolean isExistedRating = true;

      for (int i=0; i<tries; i++)
      {
          if (containsTextIsExist(justForYouGetProperty.discountRate()))
          {
              isExistDiscountRate =true;
              break;
          }
          else
              swiptToBottom();
      }
        for (int i=0; i<tries; i++)
        {
            if (containsTextIsExist(justForYouGetProperty.productTitle()))
            {
                isExistProductTitle =true;
                break;
            }
            else
            {
                swiptToBottom();
            }
        }

        for (int i=0; i<tries; i++)
        {
            if (containsTextIsExist(justForYouGetProperty.displayedPrice()))
            {
                isExistDisplayedPrice =true;
                break;
            }
            else
            {
                swiptToBottom();
            }
        }

        for (int i=0; i<tries; i++)
        {
            if (containsTextIsExist(justForYouGetProperty.originalPrice()))
            {
                isExistedOriginalPrice =true;
                break;
            }
            else
            {
                swiptToBottom();
            }
        }
        if (isExistproductRating)
        {
            for (int i=0; i<tries; i++)
            {
                if (isExist(justForYouPageObject.rating_bar) || isExist(justForYouPageObject.rating_bar_MM))
                {
                    isExistedRating =true;
                    break;
                }
                else
                {
                    isExistedRating =false;
                    swiptToBottom();
                }
            }
        }

       return (isExistDiscountRate && isExistProductTitle && isExistDisplayedPrice && isExistedOriginalPrice && isExistedRating);
    }

    public void navigateToPDPPage() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
           justForYouPageObject.discount_lbl.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
        } else {
            justForYouPageObject.discount_lbl_MM.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn_MM))
                searchPageObj.ok_Got_It_btn_MM.get(0).click();
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

    public void navigateBackToJustForYou()
    {
        driver.navigate().back();
    }
}