package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-June-2019
 */

public class CheckOutPageObjects {
    @AndroidFindBy(id = "com.daraz.android:id/price_text_view") public List <WebElement> product_Price;
    @AndroidFindBy(id = "com.shop.android:id/price_text_view") public List <WebElement> product_Price_MM;
    @AndroidFindBy (id = "com.daraz.android:id/btn_laz_trade_order_total_proceed_next") public WebElement proceed_To_Pay_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_laz_trade_order_total_proceed_next") public WebElement proceed_To_Pay_btn_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Cash on Delivery']"),@AndroidBy(xpath = "//*[@content-desc='Cash on Delivery']")}) public WebElement cod_lbl;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Cash On Delivery']"),@AndroidBy(xpath = "//*[@content-desc='Cash On Delivery']")}) public WebElement cod_lbl_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Confirm Order']"),@AndroidBy(xpath = "//*[@content-desc='Confirm Order']")}) public WebElement confirm_Order_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='TRACK ORDER']"),@AndroidBy(xpath = "//*[@content-desc='TRACK ORDER']")}) public WebElement track_Order_btn;
    @AndroidFindBy (id = "com.daraz.android:id/btn_laz_trade_order_total_proceed_next") public WebElement checkout_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_laz_trade_order_total_proceed_next") public WebElement checkout_btn_MM;
    @AndroidFindBy (id  = "com.daraz.android:id/laz_trade_item_quantity_count") public WebElement quantity_lbl;
    @AndroidFindBy (id  = "com.daraz.android:id/iv_laz_trade_item_action_decrement") public WebElement quantity_decrese_btn;
    @AndroidFindBy (id  = "com.daraz.android:id/iv_laz_trade_item_action_increment") public WebElement quantity_increase_btn;
    @AndroidFindBy (id  = "com.shop.android:id/laz_trade_item_quantity_count") public WebElement quantity_lbl_MM;
    @AndroidFindBy (id  = "com.shop.android:id/iv_laz_trade_item_action_decrement") public WebElement quantity_decrese_btn_MM;
    @AndroidFindBy (id  = "com.shop.android:id/iv_laz_trade_item_action_increment") public WebElement quantity_increase_btn_MM;
    @AndroidFindBy (id = "com.daraz.android:id/tv_laz_trade_item_stock_tip") public List <WebElement> available_quantity;
    @AndroidFindBy (id = "com.shop.android:id/tv_laz_trade_item_stock_tip") public List <WebElement> available_quantity_MM;
    @AndroidFindBy (id = "com.daraz.android:id/container_laz_trade_item_content") public List <WebElement> cart_item_container;
    @AndroidFindBy (id = "com.shop.android:id/container_laz_trade_item_content") public List <WebElement> cart_item_container_MM;
    @AndroidFindBy (id = "com.daraz.android:id/got_it") public List <WebElement> got_It_btn;

    public By proceed_To_Pay_btn_By = By.id("com.daraz.android:id/btn_laz_trade_order_total_proceed_next");
    public By proceed_To_Pay_btn_By_MM = By.id("com.shop.android:id/btn_laz_trade_order_total_proceed_next");
//    public By cod_lbl_By = By.id("//*[@contentDescription='Cash on Delivery']");
    public By confirm_Order_btn_By = By.xpath("//*[@contentDescription='Confirm Order'] | //*[@content-desc='Confirm Order']");
    public By track_Order_btn_By = By.xpath("//*[@contentDescription='TRACK ORDER'] | //*[@content-desc='TRACK ORDER']");
    public By available_quantity_By = By.id("com.daraz.android:id/tv_laz_trade_item_stock_tip");
    public By available_quantity_MM_By = By.id("com.shop.android:id/tv_laz_trade_item_stock_tip");
}