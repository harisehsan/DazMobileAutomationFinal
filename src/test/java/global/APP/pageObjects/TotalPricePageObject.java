package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TotalPricePageObject {
   @AndroidFindBy(id = "tv_trade_summary_item_value") public List<WebElement> checkout_Price_data;
   @AndroidFindBy(id = "tv_laz_trade_order_total_amount") public WebElement total_Price_Checkout_lbl;
   @AndroidFindBy(id = "tv_laz_trade_item_current_price") public List<WebElement> product_Price_Cart;
   @AndroidFindBy(id = "tv_laz_trade_total_bar_fee_value") public List<WebElement> shipping_Price_Cart;
   @AndroidFindBy(id = "laz_trade_item_quantity_count") public List<WebElement> product_Quantity_Cart;
   @AndroidFindBy(id = "tv_laz_trade_order_total_amount") public WebElement total_Price_Cart;
   @AndroidFindBy(id  = "text_input_edit_text") public List<WebElement> address_txtBox;
   @AndroidFindBy(id = "item_icon") public List <WebElement> address_pdp_btn;
   @AndroidFindBy(id = "tv_address_location_tree_name") public WebElement address_Location_tree_lbl;

}
