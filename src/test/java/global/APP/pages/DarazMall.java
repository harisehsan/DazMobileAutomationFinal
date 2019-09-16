package global.APP.pages;

import global.APP.pageObjects.DarazMallPageObject;
import global.APP.pageObjects.FlashSalePageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 13-September-2019
 */

public class DarazMall extends Base {

    DarazMallPageObject darazMallPageObject = new DarazMallPageObject();
    FlashSalePageObject flashSalePageObject = new FlashSalePageObject();

    public DarazMall(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), darazMallPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), flashSalePageObject);
    }

    public boolean checkExistenceofDarazMall() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            return (darazMallPageObject.daraz_Mall_lbl.size() > 0);
        } else {
            return (darazMallPageObject.official_Store_lbl_MM.size() > 0);
        }
    }

    public void selectShopMoreForDarazMall() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            darazMallPageObject.darazMall_icon.get(0).click();
         else
            darazMallPageObject.officialStore_icon.get(0).click();
    }

    public boolean verifyTheDarazMall()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return (isExist(darazMallPageObject.daraz_Mall_Title_lbl));
        else
            return (isExist(darazMallPageObject.daraz_Mall_Title_lbl_MM));
    }

    public void navigatebackToHomePage()
    {
        driver.navigate().back();
    }
}