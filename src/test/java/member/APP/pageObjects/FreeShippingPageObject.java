package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FreeShippingPageObject {
    @AndroidFindBy(id = "tv_laz_trade_shop_addon_text") public List <WebElement> free_Shipping_Message;
    @AndroidFindBy(id = "tv_laz_trade_shop_addon_buy_more") public List <WebElement> buy_More_btn;
    @AndroidFindBy(id = "tv_laz_trade_total_bar_fee_value") public WebElement shipping_Fee_lbl;
    @AndroidFindBy(id = "tv_laz_trade_item_current_price") public WebElement product_Price_lbl;
    @AndroidFindBy(id = "tv_laz_trade_order_total_amount") public WebElement total_Price_Cart;
    @AndroidFindBy(xpath = "//*[@text='Shipping Fee Discount']") public List<WebElement> shipping_Fee_Discount_Checkout;
    @AndroidFindBy(id = "tv_laz_trade_shop_addon_buy_more") public WebElement cart_buy_More_btn;
    @AndroidFindBy(id = "add_to_cart_btn") public List <WebElement> add_To_Cart_Free_Shipping_btn;
    @AndroidFindBy(id = "mini_promotion_title") public WebElement mini_Promotion_title;
    @AndroidFindBy(id = "popup_header_close") public WebElement shipping_Product_Popup_close_btn;

}