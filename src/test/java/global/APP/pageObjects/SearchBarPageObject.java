package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 30-September-2019
 */

public class SearchBarPageObject extends BuildIDPicker {
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/laz_homepage_scan_icon") public List<WebElement> scan_icon;
    @AndroidFindBy(id = "com.shop.android:id/laz_homepage_scan_icon") public List<WebElement> scan_icon_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/laz_homepage_scan_text") public List <WebElement> scan_Text_lbl;
    @AndroidFindBy(id = "com.shop.android:id/laz_homepage_scan_text") public List <WebElement> scan_Text_lbl_MM;
    @AndroidFindBy (id = "com.android.packageinstaller:id/permission_allow_button") public List <WebElement> camera_allow_btn;
    @AndroidFindBy (id = "com.android.packageinstaller:id/permission_message") public List <WebElement> permission_message;
    @AndroidFindBy (xpath = "//*[@text='QR Code Reader']") public List <WebElement> scan_Title_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_homepage_search_view") public List <WebElement> searchbar_txt;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_search_view") public List <WebElement> searchbar_txt_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_homepage_right_wallet_icon") public List <WebElement> wallet_icon;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_right_wallet_icon") public List <WebElement> wallet_icon_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_homepage_right_wallet_text") public List <WebElement> wallet_Name_lbl;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_right_wallet_text") public List <WebElement> wallet_Name_lbl_MM;
    @AndroidFindBy (xpath = "//*[@text='My Wallet']") public List <WebElement> my_wallet_Header_lbl;


    public By wallet_icon_By = By.id("com.daraz.android"+dev+":id/laz_homepage_right_wallet_icon");
    public By wallet_icon_By_MM = By.id("com.shop.android:id/laz_homepage_right_wallet_icon");
    public By scan_Title_lbl_By = By.xpath("//*[@text='QR Code Reader']");
    public By search_btn_By = By.xpath("//*[@text='SEARCH']");





}
