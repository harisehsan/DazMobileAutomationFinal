package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 03-October-2019
 */

public class BannerAndChannelPageObject extends BuildIDPicker {
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/view_homepage_top_carousel_indicator") public List <WebElement> banner_slider;
    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView']") public List <WebElement> banner_picker;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/iv_homepage_banner") public WebElement banner_img;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/got_it_btn") public List <WebElement> got_It_btn;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_hpc_channel_icon") public List <WebElement> channel_icon;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_hpc_channel_top_text") public List <WebElement> channel_name_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/traffic_hover_text") public List <WebElement> shake_lbl;

    @AndroidFindBy(id = "com.shop.android:id/iv_homepage_banner") public WebElement banner_img_MM;
    @AndroidFindBy(id = "com.shop.android:id/view_homepage_top_carousel_indicator") public List <WebElement> banner_slider_MM;
    @AndroidFindBy(id = "com.shop.android:id/got_it_btn") public List <WebElement> got_It_btn_MM;
    @AndroidFindBy (id = "com.shop.android:id/laz_hpc_channel_icon") public List <WebElement> channel_icon_MM;
    @AndroidFindBy (id = "com.shop.android:id/laz_hpc_channel_top_text") public List <WebElement> channel_name_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/traffic_hover_text") public List <WebElement> shake_lbl_MM;

    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_hpc_channel_icon") public List <WebElement> channel_icon_NP;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/laz_hpc_channel_top_text") public List <WebElement> channel_name_lbl_np;

//    public By banner_picker_by = By.xpath("//*[@class='android.widget.ImageView']");
    public By banner_image_by = By.id("com.daraz.android"+dev+":id/iv_homepage_banner");
    public By banner_image_by_MM = By.id("com.shop.android:id/iv_homepage_banner");
    public By channel_icon_by = By.id("com.daraz.android"+dev+":id/laz_hpc_channel_icon");
    public By channel_icon_by_NP = By.id("com.daraz.android"+dev+":id/laz_hpc_channel_icon");
    public By channel_icon_by_MM = By.id("com.shop.android:id/laz_hpc_channel_icon");
    public By page_view_by = By.xpath("//*[@class='android.view.View']");
}
