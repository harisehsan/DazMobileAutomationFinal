package global.APP.pages;

import global.APP.pageObjects.DarazMallPageObject;
import global.APP.pageObjects.FlashSalePageObject;
import global.APP.pageObjects.SearchBarPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import member.APP.pageObjects.SignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 13-September-2019
 */

public class DarazMall extends Base {

    DarazMallPageObject darazMallPageObject = new DarazMallPageObject();
    FlashSalePageObject flashSalePageObject = new FlashSalePageObject();
    SearchBarPageObject searchBarPageObject = new SearchBarPageObject();
    SignUpObjects signUpObjects = new SignUpObjects();

    public DarazMall(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), darazMallPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), flashSalePageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchBarPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
    }

    public boolean checkExistenceofDarazMall() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
            return (darazMallPageObject.daraz_Mall_lbl.size() > 0);
        } else {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
            return (darazMallPageObject.official_Store_lbl_MM.size() > 0);
        }
    }

    public void selectShopMoreForDarazMall() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            darazMallPageObject.darazMall_icon.get(0).click();
        else
            darazMallPageObject.officialStore_icon.get(0).click();
    }

    public boolean verifyTheDarazMall() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return (isExist(darazMallPageObject.daraz_Mall_Title_lbl));
        else
            return (isExist(darazMallPageObject.daraz_Mall_Title_lbl_MM));
    }

    public void navigatebackToHomePage(String page) {
        if (page.equalsIgnoreCase("Catalog Page")){
            driver.navigate().back();
            waitUntilPresentOfElementBy(searchBarPageObject.search_btn_By);
            hideKeyboard();
            driver.navigate().back();
            }
        else if (page.equalsIgnoreCase("My Account"))
        {
            if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            {
               waitUntilPresentOfElementBy(signUpObjects.settings_icon_By);
               driver.navigate().back();
            }
            else
            {
                waitUntilPresentOfElementBy(signUpObjects.settings_icon_By_MM);
                driver.navigate().back();
            }
        }
        else
            driver.navigate().back();
        }

    public void clickOnShopMoreButtonForDarazMall() {
        int tries = 5;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
            for (int i = 0; i < tries; tries++) {
                if (isExist(darazMallPageObject.daraz_Mall_container_lbl)) {
                    darazMallPageObject.shop_More_btn.get(0).click();
                    break;
                } else
                    swiptToBottom();
            }
        }
        else
        {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
            for (int i = 0; i < tries; tries++) {
                if (isExist(darazMallPageObject.official_Store_container_lbl_MM)) {
                    darazMallPageObject.shop_More_btn.get(0).click();
                    break;
                } else
                    swiptToBottom();
            }
        }
    }
}