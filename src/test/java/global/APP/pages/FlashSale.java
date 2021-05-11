package global.APP.pages;

import global.APP.pageObjects.BannerAndChannelPageObject;
import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.FlashSalePageObject;
import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 12-September-2019
 */

public class FlashSale extends Base {

    FlashSalePageObject flashSalePageObject = new FlashSalePageObject();
    BannerAndChannelPageObject bannerAndChannelPageObject = new BannerAndChannelPageObject();
    CartPageObjects cartPageObjects = new CartPageObjects();
    SearchPageObject searchPageObj = new SearchPageObject();

    public FlashSale(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), flashSalePageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), bannerAndChannelPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
    }

    public boolean checkForFlashSaleExistence() {
     if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
         waitWithoutExceptionForElements(flashSalePageObject.flash_Sale_lbl);
         return (flashSalePageObject.flash_Sale_lbl.size() > 0);
     }
     else {
         waitWithoutExceptionForElements(flashSalePageObject.flash_Sale_lbl);
         return (flashSalePageObject.flash_Sale_lbl_MM.size() > 0);
     }
    }

    public boolean verifyTheSaleTime() {

        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
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
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
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

        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
        {
          if (ThreadStorage.get("env").equalsIgnoreCase("lk.live"))
        {
            waitWithoutExceptionByText("BUY NOW");
            flashSalePageObject.buy_Now_btn_MM.click();
        }

        else
        {
            waitUntilPresentOfElementByString("BUY NOW");
            flashSalePageObject.buy_Now_btn.click();
        }
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
        }
        else
        {
          waitWithoutExceptionByText("BUY NOW");
          flashSalePageObject.buy_Now_btn_MM.click();
            if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn_MM))
                searchPageObj.ok_Got_It_btn_MM.get(0).click();
        }
    }

    public boolean verifyTheSalesAndPrice()
    {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            return ((!flashSalePageObject.items_Sold_lbl.getText().equalsIgnoreCase("") && (!flashSalePageObject.discount_Percentage_lbl.getText().equalsIgnoreCase("") && ((!flashSalePageObject.discount_Price_lbl.getText().equalsIgnoreCase(""))))));
        }
        else
            return ((!flashSalePageObject.items_Sold_lbl_MM.getText().equalsIgnoreCase("") && (!flashSalePageObject.discount_Percentage_lbl_MM.getText().equalsIgnoreCase("") && ((!flashSalePageObject.discount_Price_lbl_MM.getText().equalsIgnoreCase(""))))));
    }
}