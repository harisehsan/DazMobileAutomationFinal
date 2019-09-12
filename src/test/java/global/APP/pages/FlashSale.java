package global.APP.pages;

import global.APP.pageObjects.FlashSalePageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 12-September-2019
 */

public class FlashSale extends Base {

    FlashSalePageObject flashSalePageObject = new FlashSalePageObject();

    public FlashSale(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), flashSalePageObject);
    }

    public boolean checkForFlashSaleExistence() {
     if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
         waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
         return (flashSalePageObject.flash_Sale_lbl.size() > 0);
     }
     else {
         waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
         return (flashSalePageObject.flash_Sale_lbl_MM.size() > 0);
     }
    }

    public boolean verifyTheSaleTime() {

        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
           return (flashSalePageObject.flash_Sale_Hour_lbl.size() > 0 && flashSalePageObject.flash_Sale_minutes_lbl.size() > 0 && flashSalePageObject.flash_Sale_seconds_lbl.size() > 0);
        }
        else
        {
            return (flashSalePageObject.flash_Sale_Hour_lbl_MM.size() > 0 && flashSalePageObject.flash_Sale_minutes_lbl_MM.size() > 0 && flashSalePageObject.flash_Sale_seconds_lbl_MM.size() > 0);
        }
    }

    public void gotoFlashsale()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
            flashSalePageObject.flash_Shop_More_link.click();
        }
        else
        {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
            flashSalePageObject.flash_Shop_More_link_MM.click();
        }
    }

    public void goToPdpPage ()
    {

        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
          flashSalePageObject.buy_Now_btn.click();
          if (isExist(flashSalePageObject.chat_Ok_btn))
              flashSalePageObject.chat_Ok_btn.get(0).click();
        }
        else
        {
          flashSalePageObject.buy_Now_btn_MM.click();
          if (isExist(flashSalePageObject.chat_Ok_btn_MM))
             flashSalePageObject.chat_Ok_btn_MM.get(0).click();
        }
    }

    public boolean verifyTheSalesAndPrice()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return ((!flashSalePageObject.items_Sold_lbl.getText().equalsIgnoreCase("") && (!flashSalePageObject.discount_Percentage_lbl.getText().equalsIgnoreCase("") && ((!flashSalePageObject.discount_Price_lbl.getText().equalsIgnoreCase(""))))));
        else
            return ((!flashSalePageObject.items_Sold_lbl_MM.getText().equalsIgnoreCase("") && (!flashSalePageObject.discount_Percentage_lbl_MM.getText().equalsIgnoreCase("") && ((!flashSalePageObject.discount_Price_lbl_MM.getText().equalsIgnoreCase(""))))));
    }
}