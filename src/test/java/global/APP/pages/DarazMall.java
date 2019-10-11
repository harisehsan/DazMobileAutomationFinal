package global.APP.pages;

import global.APP.pageObjects.BannerAndChannelPageObject;
import global.APP.pageObjects.DarazMallPageObject;
import global.APP.pageObjects.FlashSalePageObject;
import global.APP.pageObjects.SearchBarPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
    BannerAndChannelPageObject bannerAndChannelPageObject = new BannerAndChannelPageObject();

    public DarazMall(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), darazMallPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), flashSalePageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchBarPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), bannerAndChannelPageObject);
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

    public void clickOnDarazMallChannel() {
        switch (System.getProperty("env")) {
            case "pk.live":
            case "bd.live":
            case "lk.live": {
                waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by);
                for (int i = 0; i < bannerAndChannelPageObject.channel_name_lbl.size(); i++) {
                    if(bannerAndChannelPageObject.channel_name_lbl.get(i).getText().equalsIgnoreCase("DarazMall"))
                    {
                        bannerAndChannelPageObject.channel_name_lbl.get(i).click();
                        return;
                    }
                }
            }
            break;
            case "np.live": {
                waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_NP);
                for (int i = 0; i < bannerAndChannelPageObject.channel_name_lbl_np.size(); i++ ) {
                    if(bannerAndChannelPageObject.channel_name_lbl_np.get(i).getText().equalsIgnoreCase("DarazMall"))
                    {
                        bannerAndChannelPageObject.channel_name_lbl_np.get(i).click();
                        return;
                    }
                }
            }
            break;
            default: {
                waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_MM);
                for (int i = 0; i < bannerAndChannelPageObject.channel_name_lbl_MM.size() ; i++) {
                    if(bannerAndChannelPageObject.channel_name_lbl_MM.get(i).getText().equalsIgnoreCase("Official\nStores"))
                    {
                        bannerAndChannelPageObject.channel_name_lbl_MM.get(i).click();
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("Daraz Mall/Official Store Channel is not existed on Homepage!");
    }

    public boolean verifyTheDarazMall() {
        if ((!(System.getProperty("env").equalsIgnoreCase("mm.live"))) && (!(System.getProperty("env").equalsIgnoreCase("np.live")))) {
            waitWithoutExceptionForElements(darazMallPageObject.daraz_Mall_Title_lbl);
            return (isExist(darazMallPageObject.daraz_Mall_Title_lbl));
        }
        if ((System.getProperty("env").equalsIgnoreCase("np.live")))
        {
            waitWithoutExceptionForElements(darazMallPageObject.daraz_Mall_Title_lbl_NP);
            return (isExist(darazMallPageObject.daraz_Mall_Title_lbl_NP) || isExist(darazMallPageObject.daraz_Mall_Title_lbl));
        }
        else {
            waitWithoutExceptionForElements(darazMallPageObject.daraz_Mall_Title_lbl_MM);
            return (isExist(darazMallPageObject.daraz_Mall_Title_lbl_MM));
        }
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

    public boolean clickOnShopMoreButtonForDarazMall() {
        int tries = 15;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
            for (int i = 0; i < tries; i++) {
                if (isExist(darazMallPageObject.daraz_Mall_container_lbl)) {
                       darazMallPageObject.shop_More_btn.get(0).click();
                    return true;
                } else
                    swiptToBottom();
            }
        }
        else
        {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
            for (int i = 0; i < tries; i++) {
                if (isExist(darazMallPageObject.official_Store_container_lbl_MM)) {
                    darazMallPageObject.official_Store_Shop_More_btn.get(0).click();
                    return true;
                } else
                    swiptToBottom();
            }
        }
        return false;
    }
}