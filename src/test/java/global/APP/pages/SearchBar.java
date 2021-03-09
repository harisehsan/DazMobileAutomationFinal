package global.APP.pages;

import global.APP.pageObjects.SearchBarPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 30-September-2019
 */


public class SearchBar extends Base {

    SearchBarPageObject searchBarPageObject = new SearchBarPageObject();

    public SearchBar(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchBarPageObject);
    }

    public boolean verifyTheScanIconAndText() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return (isExist(searchBarPageObject.scan_icon) && (searchBarPageObject.scan_Text_lbl.get(0).getText().equalsIgnoreCase("Scan")));
        else
            return (isExist(searchBarPageObject.scan_icon_MM) && searchBarPageObject.scan_Text_lbl_MM.get(0).getText().equalsIgnoreCase("Scan"));
    }

    public void clickOnScanIcon() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            searchBarPageObject.scan_icon.get(0).click();
        else
            searchBarPageObject.scan_icon_MM.get(0).click();
    }

    public boolean verifyScanPage() {
        if (isExist(searchBarPageObject.permission_message))
            searchBarPageObject.camera_allow_btn.get(0).click();
        waitUntilPresentOfElementBy(searchBarPageObject.scan_Title_lbl_By);
        return (searchBarPageObject.scan_Title_lbl.get(0).getText().equalsIgnoreCase("QR Code Reader"));
    }

    public boolean verifyTheExistenceofSearchBar() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return (isExist(searchBarPageObject.searchbar_txt));
        else
            return (isExist(searchBarPageObject.searchbar_txt_MM));
    }

    public boolean verifyTheExistenceOfDarazWalletIconAndText()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return (isExist(searchBarPageObject.wallet_icon) && searchBarPageObject.wallet_Name_lbl.get(0).getText().equalsIgnoreCase("Wallet"));
        else
            return (isExist(searchBarPageObject.wallet_icon_MM) && searchBarPageObject.wallet_Name_lbl_MM.get(0).getText().equalsIgnoreCase("Wallet"));
    }

    public void clickOnWallet()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
            if (waitForElementsLessTime(searchBarPageObject.wallet_icon))
           searchBarPageObject.wallet_icon.get(0).click();
          else
             throw new RuntimeException("Either a Daraz Wallet is not existed on homepage or not showing properly!");
        }
        else
        {
            if (waitForElementsLessTime(searchBarPageObject.wallet_icon_MM))
              searchBarPageObject.wallet_icon_MM.get(0).click();
            else
                throw new RuntimeException("Either a Daraz Wallet is not existed on homepage or not showing properly!");
        }
    }

    public boolean checkTheDarazWalletPage()
    {
        return isExist(searchBarPageObject.my_wallet_Header_lbl);
    }
}
