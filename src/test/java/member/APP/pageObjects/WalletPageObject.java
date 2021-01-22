package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WalletPageObject extends BuildIDPicker {
    @AndroidFindBy(id = "com.daraz.android:id/tv_switch_account") public WebElement switch_Account_lnk;
    @AndroidFindBy(id = "com.shop.android:id/tv_switch_account") public WebElement switch_Account_lnk_MM;

    public By switch_Account_lnk_By = By.id("com.daraz.android:id/tv_switch_account");
    public By switch_Account_lnk_By_MM = By.id("com.shop.android:id/tv_switch_account");
}