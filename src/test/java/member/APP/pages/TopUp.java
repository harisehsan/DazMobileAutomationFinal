package member.APP.pages;

import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.getProperty.AddressGetProperty;
import member.APP.pageObjects.SearchPageObject;
import member.APP.pageObjects.TopUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class TopUp extends Base {
    TopUpObjects topUpObjects = new TopUpObjects();
    AddressGetProperty addressGetProperty = new AddressGetProperty();

    public TopUp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), topUpObjects);
    }

    public void iShouldBeOnTopUpScreen() {
        waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.topUpBanner_by, 50);
        waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.phoneInput_by, 50);
        waitForElementToClickable(topUpObjects.inputFiledTopUp, 30);
        Assert.assertTrue(topUpObjects.inputFiledTopUp.isDisplayed(), "Top-UP page not loaded");
    }

    public void getValidation() {
        switch (ThreadStorage.get("env")) {
            case "pk.live":
                waitForElementToClickable(topUpObjects.inputFiledTopUp, 5);
                topUpObjects.inputFiledTopUp.sendKeys("00000");
                break;
            case "bd.live":
            case "lk.live":
            case "np.live":
            case "mm.live":
                waitForElementToClickable(topUpObjects.inputFiledTopUp, 20);
                topUpObjects.inputFiledTopUp.click();
                topUpObjects.inputFiledTopUp.sendKeys("00000");
                break;
        }
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.phoneValidation_by, 6);
        Assert.assertTrue(topUpObjects.phoneValidation.isDisplayed(), "Should show the validation message");
        topUpObjects.inputFiledTopUp.clear();
    }

    public void countryCodeShouldBeRemoved() throws IOException {
        switch (ThreadStorage.get("env")) {
            case "pk.live":
                topUpObjects.inputFiledTopUp.click();
                topUpObjects.inputFiledTopUp.sendKeys("+92" + addressGetProperty.buyerPhonePK());
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                topUpObjects.telenorOperator.click();
                Assert.assertFalse(topUpObjects.inputFiledTopUp.getText().contains("+92"), "Country Code Should be removed.");

                break;
            case "bd.live":
                topUpObjects.inputFiledTopUp.click();
                topUpObjects.inputFiledTopUp.sendKeys("+88" + addressGetProperty.buyerPhoneBD());
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                Assert.assertFalse(topUpObjects.inputFiledTopUp.getText().contains("+88"), "Country Code Should be removed.");
                break;
            case "lk.live":
                topUpObjects.inputFiledTopUp.click();
                topUpObjects.inputFiledTopUp.sendKeys("+94" + addressGetProperty.buyerPhoneLK());
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                Assert.assertFalse(topUpObjects.inputFiledTopUp.getText().contains("+94"), "Country Code Should be removed.");
                break;
            case "np.live":
                topUpObjects.inputFiledTopUp.click();
                topUpObjects.inputFiledTopUp.sendKeys("+" + addressGetProperty.buyerPhoneNP());
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                Assert.assertFalse(topUpObjects.inputFiledTopUp.getText().contains("+"), "Country Code Should be removed.");
                break;
            case "mm.live":
                topUpObjects.inputFiledTopUp.click();
                topUpObjects.inputFiledTopUp.sendKeys("+95" + addressGetProperty.buyerPhoneMM());
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                Assert.assertFalse(topUpObjects.inputFiledTopUp.getText().contains("+95"), "Country Code Should be removed.");
                break;
        }
    }

    public void selectOperator() {
        switch (ThreadStorage.get("env")) {
            case "pk.live":
                topUpObjects.topUpBtn.click();
                break;
            case "bd.live":
            case "lk.live":
            case "np.live":
                waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.findBalanceTxt_by, 30);
                if (topUpObjects.netWorkError.size() > 0) {
                    Assert.assertTrue(topUpObjects.netWorkError.contains("Network Error"), "Network Error Occurred! Should restart the test");
                } else if (topUpObjects.topUpBtn.isDisplayed())
                    topUpObjects.topUpBtn.click();
                break;
            case "mm.live":
                waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.selectOprator_by, 30);
                if (topUpObjects.selectOpratorlst.size() > 0) {
                    topUpObjects.avatar_ele.click();
                    if (isExistByText("Telenor")) {
                        topUpObjects.telenorOperator.click();
                        packageValueAssert();
                        topUpObjects.topUpBtn.click();
                    } else {
                        Assert.assertTrue(topUpObjects.netWorkError.contains("Network Error"), "Network Error Occurred! Should restart the test");
                    }
                }
                break;
        }
    }

    public void packageValueAssert() {
        switch (ThreadStorage.get("env")) {
            case "mm.live":
                waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.findBalanceTxt_by, 10);
                Assert.assertEquals(topUpObjects.mmTelenorBalance_ele.size(), 3, "Check ");
                break;
        }
    }

    public void mSiteCheckOutBtn() {
        isElementPresent(topUpObjects.checkout_btn_by);
        topUpObjects.mSiteProceedToPayBtn.click();
    }

    public void clickReloadIconOnLK() {
        waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.campaignPageTitle_by, 10);
        waitForElementToClickable(topUpObjects.reload_ele, 10);
        topUpObjects.reload_ele.click();
    }

    public void clickFirstBannerNp() {
        waitForElementByWithoutExceptionUntillTimeReach(topUpObjects.reloadNP_by, 10);
        waitForElementToClickable(topUpObjects.reloadNP_ele, 10);
        if (topUpObjects.reloadNP_ele.isDisplayed()) {
            topUpObjects.reloadNP_ele.click();
        } else {
            Assert.fail("Not Redirected to Reload Camp page, Check and rerun the test");
        }
    }

    public void topUpBannerOnSearchPage() {
        SearchPageObject searchPageObject = new SearchPageObject();

        waitUntilPresentOfElementBy(searchPageObject.searchResult_lbl_By);
        topUpObjects.imagesOnSearchPage_lst.get(1).click();
    }
}