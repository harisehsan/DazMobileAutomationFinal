package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.bytebuddy.implementation.bind.annotation.Origin;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 13-September-2019
 */

public class DarazMallPageObject extends BuildIDPicker {
    @AndroidFindBy (xpath = "//*[@text='DarazMall']") public List<WebElement> daraz_Mall_lbl;
    @AndroidFindBy (xpath = "//*[@text='SHOP MORE >' and ./parent::*[@class='android.widget.FrameLayout']]") public List <WebElement> shop_More_btn_PK;
    @AndroidFindBy (xpath = "((//*[@contentDescription='OfficialStore']/*[@class='android.widget.FrameLayout'])[1]/*[@text])[2]") public List <WebElement> shop_More_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='DarazMall']"),@AndroidBy(xpath = "//*[@content-desc='DarazMall']")}) public List <WebElement> daraz_Mall_Title_lbl;
    @AndroidFindBy (xpath = "//*[@text='Official Store']") public List <WebElement> daraz_Mall_Title_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_hpc_channel_icon") public List <WebElement> darazMall_icon;
    @AndroidFindBy (id = "com.shop.android:id/laz_hpc_channel_icon") public List <WebElement> officialStore_icon;
    @AndroidFindBy (xpath = "//*[@text='DarazMall' and ./parent::*[@class='android.widget.FrameLayout']]") public List <WebElement> daraz_Mall_container_lbl;
    @AndroidFindBy (xpath = "//*[@text='Official Stores ( 14 Days Return )' and ./parent::*[@class='android.widget.FrameLayout']]") public List <WebElement> official_Store_container_lbl_MM;
    @AndroidFindBy (xpath = "((//*[@contentDescription='OfficialStore']/*[@class='android.widget.FrameLayout'])[1]/*[@text])[2]") public List <WebElement> official_Store_Shop_More_btn;
    @AndroidFindBy (id = "com.shop.android:id/laz_hpc_channel_top_text") public List <WebElement> official_Store_lbl_MM;
    @AndroidFindBy (xpath = "//*[@text='DarazMall']") public List <WebElement> daraz_Mall_Title_lbl_NP;
}