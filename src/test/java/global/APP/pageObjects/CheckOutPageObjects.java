package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-June-2019
 */

public class CheckOutPageObjects extends BuildIDPicker {
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/price_text_view") public List <WebElement> product_Price;
    @AndroidFindBy(id = "com.shop.android:id/price_text_view") public List <WebElement> product_Price_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/btn_laz_trade_order_total_proceed_next") public WebElement proceed_To_Pay_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_laz_trade_order_total_proceed_next") public WebElement proceed_To_Pay_btn_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Cash on Delivery']"),@AndroidBy(xpath = "//*[@content-desc='Cash on Delivery']")}) public WebElement cod_lbl;
    @AndroidFindAll({@AndroidBy(xpath = "//android.view.View[@content-desc='Cash On Delivery']"), @AndroidBy(accessibility = "Cash on Delivery")})
    public WebElement cod_lbl_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Confirm Order']"),@AndroidBy(xpath = "//*[@content-desc='Confirm Order']")}) public WebElement confirm_Order_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='TRACK ORDER']"),@AndroidBy(xpath = "//*[@content-desc='TRACK ORDER']")}) public WebElement track_Order_btn;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/btn_laz_trade_order_total_proceed_next") public WebElement checkout_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_laz_trade_order_total_proceed_next") public WebElement checkout_btn_MM;
    @AndroidFindBy (id  = "com.daraz.android"+dev+":id/laz_trade_item_quantity_count") public WebElement quantity_lbl;
    @AndroidFindBy (id  = "com.daraz.android"+dev+":id/iv_laz_trade_item_action_decrement") public List <WebElement> quantity_decrese_btn;
    @AndroidFindBy (id  = "com.daraz.android"+dev+":id/iv_laz_trade_item_action_increment") public List <WebElement> quantity_increase_btn;
    @AndroidFindBy (id  = "com.shop.android:id/laz_trade_item_quantity_count") public WebElement quantity_lbl_MM;
    @AndroidFindBy (id  = "com.shop.android:id/iv_laz_trade_item_action_decrement") public List <WebElement> quantity_decrese_btn_MM;
    @AndroidFindBy (id  = "com.shop.android:id/iv_laz_trade_item_action_increment") public List <WebElement> quantity_increase_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/tv_laz_trade_item_stock_tip") public List <WebElement> available_quantity;
    @AndroidFindBy (id = "com.shop.android:id/tv_laz_trade_item_stock_tip") public List <WebElement> available_quantity_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/container_laz_trade_item_content") public List <WebElement> cart_item_container;
    @AndroidFindBy (id = "com.shop.android:id/container_laz_trade_item_content") public List <WebElement> cart_item_container_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/got_it") public List <WebElement> got_It_btn;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/dialog_btn_cancel") public WebElement rating_Later_btn;
    @AndroidFindBy (id = "com.shop.android:id/dialog_btn_cancel") public WebElement rating_Later_btn_MM;
    @AndroidFindBy (id = "com.daraz.android:id/tv_laz_trade_item_title") public List <WebElement> item_On_Checkout_lbl;
    @AndroidFindBy (id = "com.shop.android:id/tv_laz_trade_item_title") public List <WebElement> item_On_Checkout_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/iv_laz_trade_item_action_delete") public List <WebElement> checkout_Delete_btn;
    @AndroidFindBy(id = "com.shop.android:id/iv_laz_trade_item_action_delete") public List <WebElement> checkout_Delete_btn_MM;
    @AndroidFindBy (xpath = "(//*[@class='android.widget.FrameLayout' and ./parent::*[@id='content']]/*[@class='android.widget.ImageView'])[2]") public WebElement daraz_Loading_icon;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_pkg_footer_summary_label") public List <WebElement> items_On_check_out;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_pkg_footer_summary_label") public List <WebElement> items_On_check_out_MM;
    @AndroidFindBy(id = "com.daraz.android:id/btn_laz_trade_address_edit") public List <WebElement> edit_Address_btn;
    @AndroidFindBy(id = "com.shop.android:id/btn_laz_trade_address_edit") public List <WebElement> edit_Address_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_address_consignee") public List <WebElement> address_Checkout_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_address_consignee") public List <WebElement> address_Checkout_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/v_laz_trade_divider") public List <WebElement> line_Divider_img;
    @AndroidFindBy(id = "com.shop.android:id/v_laz_trade_divider") public List <WebElement> line_Divider_img_MM;
    @AndroidFindBy (id = "com.daraz.android:id/snackbar_text") public List <WebElement> snackbar_txt;
    @AndroidFindBy (id = "com.shop.android:id/snackbar_text") public List <WebElement> snackbar_txt_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_item_current_price") public WebElement current_Price_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_item_current_price") public WebElement current_Price_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/laz_trade_item_origin_price") public WebElement original_Price_lbl;
    @AndroidFindBy(id = "com.shop.android:id/laz_trade_item_origin_price") public WebElement original_Price_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android:id/laz_trade_item_quantity_count") public WebElement item_Count_lbl;
    @AndroidFindBy (id = "com.shop.android:id/laz_trade_item_quantity_count") public WebElement item_Count_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android:id/iv_laz_trade_item_image") public List <WebElement> product_img;
    @AndroidFindBy (id = "com.shop.android:id/iv_laz_trade_item_image") public List <WebElement> product_img_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_order_total_amount") public WebElement total_Price_On_Checkout;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_order_total_amount") public WebElement total_Price_On_Checkout_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_pkg_footer_summary_label") public List <WebElement> order_Summary_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_pkg_footer_summary_label") public List <WebElement> order_Summary_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/iv_laz_trade_item_action_dropdown") public WebElement quantity_drpDown;
    @AndroidFindBy(id = "com.shop.android:id/iv_laz_trade_item_action_dropdown") public WebElement quantity_drpDown_MM;
    @AndroidFindBy(id = "com.daraz.android:id/confirm_btn") public WebElement quantity_Confirm_btn;
    @AndroidFindBy(id = "com.shop.android:id/confirm_btn") public WebElement quantity_Confirm_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_item_sku") public WebElement product_Description_Checkout_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_item_sku") public WebElement product_Description_Checkout_lbl_MM;
    @AndroidFindAll( {  @AndroidBy(xpath = "//*[@resource-id='com.daraz.android:id/edit_laz_trade_text_editor_box' and @text='Enter your CNIC Number']"),
    @AndroidBy(xpath = "//*[@resource-id='com.daraz.android:id/edit_laz_trade_text_editor_box' and @text='42101-2146723-9']")} ) public List <WebElement> cnictxtbox;
    @AndroidFindBy (xpath = "//*[@text='42101-2146723-9']") public List <WebElement> cnictxtboxMM;
    @AndroidFindBy(id = "com.daraz.android:id/edit_laz_trade_text_editor_box") public List <WebElement> cnictxtboxID;
    @AndroidFindBy(id = "com.shop.android:id/edit_laz_trade_text_editor_box") public List <WebElement> cnictxtboxIDMM;
    @AndroidFindBy(id= "com.daraz.android:id/btn_laz_trade_text_editor_save") public WebElement save_CNIC_btn;
    @AndroidFindBy(id= "com.daraz.android:id/btn_laz_trade_text_editor_save") public WebElement save_CNIC_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/icf_laz_trade_text_editor_clear") public WebElement  cnic_Clear_btn;
    @AndroidFindBy(id = "com.shop.android:id/icf_laz_trade_text_editor_clear") public WebElement cnic_Clear_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/edit_laz_trade_voucher_input") public List <WebElement> checkout_Voucher_Field;
    @AndroidFindBy(id = "com.shop.android:id/edit_laz_trade_voucher_input") public List <WebElement> checkout_Voucher_Field_MM;
    @AndroidFindBy(id = "com.daraz.android:id/btn_laz_trade_voucher_input_apply") public WebElement voucher_Apply_btn;
    @AndroidFindBy(id = "com.shop.android:id/btn_laz_trade_voucher_input_apply") public WebElement voucher_Apply_btn_MM;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Please enter a valid CNIC Number.']") public WebElement CNIC_validate;
    //android.widget.Toast[@text='toast text']

    public By proceed_To_Pay_btn_By = By.id("com.daraz.android"+dev+":id/btn_laz_trade_order_total_proceed_next");
    public By proceed_To_Pay_btn_By_MM = By.id("com.shop.android:id/btn_laz_trade_order_total_proceed_next");
//    public By cod_lbl_By = By.id("//*[@contentDescription='Cash on Delivery']");
    public By confirm_Order_btn_By = By.xpath("//*[@contentDescription='Confirm Order'] | //*[@content-desc='Confirm Order']");
    public By track_Order_btn_By = By.xpath("//*[@contentDescription='TRACK ORDER'] | //*[@content-desc='TRACK ORDER']");
    public By available_quantity_By = By.id("com.daraz.android"+dev+":id/tv_laz_trade_item_stock_tip");
    public By available_quantity_MM_By = By.id("com.shop.android:id/tv_laz_trade_item_stock_tip");
    public By cod_lbl_MM_By = By.xpath("//*[@contentDescription='Cash On Delivery'] | //*[@content-desc='Cash On Delivery'] | //*[@contentDescription='Cash on Delivery'] | //*[@content-desc='Cash on Delivery']");
    public By cod_lbl_By = By.xpath("//*[@contentDescription='Cash on Delivery'] | //*[@content-desc='Cash on Delivery']");
    public By rating_Later_btn_By = By.id("com.daraz.android"+dev+":id/dialog_btn_cancel");
    public By rating_Later_btn_By_MM = By.id("com.shop.android:id/dialog_btn_cancel");
    public By checkout_Delete_btn_By = By.id("com.daraz.android:id/iv_laz_trade_item_action_delete");
    public By checkout_Delete_btn_By_MM = By.id("com.shop.android:id/iv_laz_trade_item_action_delete");
    public By edit_Address_btn_By = By.id("com.daraz.android:id/btn_laz_trade_address_edit");
    public By edit_Address_btn_By_MM = By.id("com.shop.android:id/btn_laz_trade_address_edit");
    public By credit_Card_lbl_By = By.xpath("//*[@contentDescription='Credit/Debit Card'] | //*[@content-desc='Credit/Debit Card']");
    public By order_Details_By = By.xpath("//*[@text='Order Details']");
    public By cancel_btn_By = By.xpath("//*[@contentDescription='CANCEL '] | //*[@content-desc='CANCEL ']");
    public By cancel_btn_By_NP = By.xpath("//*[@contentDescription='CANCEL'] | //*[@content-desc='CANCEL']");
    public By quantity_Option_By = By.id("com.daraz.android:id/laz_wheelview_item_content");
    public By quantity_Option_By_MM = By.id("com.shop.android:id/laz_wheelview_item_content");
    public By cnictxtbox_By = By.xpath("//*[@text='Enter your CNIC Number']");
}