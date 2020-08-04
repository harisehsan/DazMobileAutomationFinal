package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-July-2019
 */

public class AccountPageObject extends BuildIDPicker {

    @AndroidFindBy(id = "com.daraz.android"+dev+":id/img_up") public List <WebElement> my_Account_widget;
    @AndroidFindBy(id = "com.shop.android:id/img_up") public List <WebElement> my_Account_widget_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='More options']"),@AndroidBy(xpath = "//*[@content-desc='More options']")}) public WebElement more_Options_click;
    @AndroidFindBy(id ="com.daraz.android:id/tv_wallet_topup") public WebElement wallet_Activate_Now_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_wallet_topup") public WebElement wallet_Activate_Now_lbl_MM;
    @AndroidFindBy(id ="com.daraz.android:id/tv_wallet_action") public WebElement wallet_New_Activate_Now_lbl;
    @AndroidFindBy(id = "ccom.shop.android:id/tv_wallet_action") public WebElement wallet_New_Activate_Now_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/quantity") public List <WebElement> red_Dot_lbl;
    @AndroidFindBy(id = "com.shop.android:id/quantity") public List <WebElement> red_Dot_lbl_MM;

    public By my_Account_widget_By = By.id("com.daraz.android"+dev+":id/img_up");
    public By my_Account_widget_By_MM = By.id("com.shop.android:id/img_up");
    public By down_lbl = By.id("com.daraz.android:id/txt_down");
    public By down_lbl_MM = By.id("com.shop.android:id/txt_down");



}
