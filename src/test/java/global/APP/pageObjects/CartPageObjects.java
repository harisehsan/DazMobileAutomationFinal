package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-June-2019
 */

public class CartPageObjects {

    @AndroidFindBy(id = "com.daraz.android:id/product_name_text_view") public List<WebElement> searchProduct_lbl;
    @AndroidFindBy(id = "com.shop.android:id/product_name_text_view") public List<WebElement> searchProduct_lbl_MM;
    @AndroidFindBy(xpath = "//*[@text='Add to Cart']") public List <WebElement> add_To_Cart_btn;
    @AndroidFindBy(id = "com.daraz.android:id/title") public WebElement product_Title_lbl;
    @AndroidFindBy(id = "com.shop.android:id/title") public WebElement product_Title_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/snackbar_text") public WebElement success_Message_lbl;
    @AndroidFindBy(id = "com.shop.android:id/snackbar_text") public WebElement success_Message_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/snackbar_action") public WebElement go_To_Cart_btn;
    @AndroidFindBy(id = "com.shop.android:id/snackbar_action") public WebElement go_To_Cart_btn_MM;
    @AndroidFindAll({@AndroidBy(id = "com.daraz.android:id/tv_laz_trade_item_title"),@AndroidBy(id = "com.shop.android:id/tv_laz_trade_item_title")}) public List <WebElement> product_Title_In_Cart_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_cart_slide_gesture_got_it") public List <WebElement> ok_Got_It_btn;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_cart_slide_gesture_got_it") public List <WebElement> ok_Got_It_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tab_layout") public List <WebElement> cart_icon;
    @AndroidFindBy(id = "com.shop.android:id/tab_layout") public List <WebElement> cart_icon_MM;
    @AndroidFindBy (id= "com.daraz.android:id/ckb_laz_trade_item_checkbox") public List <WebElement> product_chkbox;
    @AndroidFindBy (id= "com.shop.android:id/ckb_laz_trade_item_checkbox") public List <WebElement> product_chkbox_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_cart_action_manage_btn") public WebElement delete_first_btn;
    @AndroidFindBy(id = "com.daraz.android:id/btn_laz_trade_management_delete") public WebElement delete_second_btn;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_cart_action_manage_btn") public WebElement delete_first_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/btn_laz_trade_management_delete") public WebElement delete_second_btn_MM;
    @AndroidFindBy (id= "android:id/button1") public WebElement delete_third_btn;
    @AndroidFindBy (id = "com.daraz.android:id/confirm_button") public WebElement overseas_Confirm_btn;
    @AndroidFindBy (id = "com.shop.android:id/confirm_button") public WebElement overseas_Confirm_btn_MM;
    @AndroidFindAll({@AndroidBy(id = "com.daraz.android:id/ckb_laz_trade_total_checkbox"),@AndroidBy(id = "com.shop.android:id/ckb_laz_trade_total_checkbox")}) public WebElement select_All_chkbox;
    @AndroidFindAll({@AndroidBy(id = "com.daraz.android:id/iv_laz_trade_item_action_wishlist"),@AndroidBy(id = "com.shop.android:id/iv_laz_trade_item_action_wishlist")}) public WebElement wishlist_In_Cart_btn;
    @AndroidFindAll({@AndroidBy(id = "com.daraz.android:id/iv_laz_trade_item_action_wishlist"),@AndroidBy(id = "com.shop.android:id/iv_laz_trade_item_action_wishlist")}) public WebElement wishlist_Success_Message;
    @AndroidFindBy(id = "com.daraz.android:id/other_action") public List <WebElement> buy_Now_btn;
    @AndroidFindBy(id = "com.shop.android:id/other_action") public List <WebElement> buy_Now_btn_MM;

    public By searchProduct_lbl_By = By.id("com.daraz.android:id/product_name_text_view");
    public By searchProduct_lbl_MM_By = By.id("com.shop.android:id/product_name_text_view");
    public By product_Title_lbl_By = By.id("com.daraz.android:id/title");
    public By product_Title_lbl_By_MM = By.id("com.shop.android:id/title");
    public By product_Title_In_Cart_lbl_By = By.id("com.daraz.android:id/tv_laz_trade_item_title");
    public By product_Title_In_Cart_lbl_By_MM = By.id("com.shop.android:id/tv_laz_trade_item_title");
    public By ok_Got_It_btn_By = By.id("com.daraz.android:id/tv_laz_cart_slide_gesture_got_it");
    public By ok_Got_It_btn_By_MM = By.id("com.shop.android:id/tv_laz_cart_slide_gesture_got_it");
    public By cart_icon_By = By.id("com.daraz.android:id/tab_layout");
    public By cart_icon_By_MM = By.id("com.shop.android:id/tab_layout");
    public By product_rdobtn_By = By.id("com.daraz.android:id/ckb_laz_trade_item_checkbox");
    public By product_rdobtn_By_MM = By.id("com.shop.android:id/ckb_laz_trade_item_checkbox");
    public By wishlist_In_Cart_btn_By = By.id("com.daraz.android:id/iv_laz_trade_item_action_wishlist");
    public By wishlist_In_Cart_btn_By_MM = By.id("com.shop.android:id/iv_laz_trade_item_action_wishlist");
    public By proceed_To_Pay_btn_by = By.id("com.daraz.android:id/btn_laz_trade_order_total_proceed_next");
}