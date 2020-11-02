package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserGrowthPageObject extends BuildIDPicker {
    @AndroidFindBy (id="com.daraz.android:id/iv_close_btn") public List<WebElement> first_Order_Popup_Hp;
    @AndroidFindBy (id="com.shop.android:id/iv_close_btn") public List<WebElement> first_Order_Popup_Hp_MM;
    @AndroidFindBy (id = "com.daraz.android:id/laz_homepage_new_user_voucher_button_label") public List <WebElement> avail_Now_Hp_btn;
    @AndroidFindBy (id = "com.shop.android:id/laz_homepage_new_user_voucher_button_label") public List <WebElement> avail_Now_Hp_btn_MM;
    @AndroidFindBy (id = "com.daraz.android:id/tv_signin") public WebElement login_With_Email_link;
    @AndroidFindBy (id = "com.shop.android:id/tv_signin") public WebElement login_With_Email_link_MM;
    @AndroidFindBy (id ="com.daraz.android:id/et_input_text") public List <WebElement> email_txt;
    @AndroidFindBy (id = "com.shop.android:id/et_input_text") public List <WebElement> email_txt_MM;
    @AndroidFindBy (id = "com.daraz.android:id/btn_next") public WebElement login_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_next") public WebElement login_btn_MM;
    @AndroidFindBy (id = "com.daraz.android:id/tv_laz_trade_address_add") public WebElement new_Address_On_Checkout_btn;
    @AndroidFindBy (id = "com.shop.android:id/tv_laz_trade_address_add") public WebElement new_Address_On_Checkout_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/iv_houyi_right") public WebElement user_Growth_Go_btn;
    @AndroidFindBy(id = "com.shop.android:id/iv_houyi_right") public WebElement user_Growth_Go_btn_MM;

    public By login_With_Email_link_By = By.id("com.daraz.android:id/tv_signin");
    public By login_With_Email_link_By_MM = By.id("com.shop.android:id/tv_signin");
    public By email_txt_By = By.id("com.daraz.android:id/et_input_text");
    public By email_txt_MM_By = By.id("com.shop.android:id/et_input_text");
}
