package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-June-2019
 */

public class CartPageObjects extends BuildIDPicker {

    @AndroidFindBy(id = "com.daraz.android"+dev+":id/product_name_text_view") public List<WebElement> searchProduct_lbl;
    @AndroidFindBy(id = "com.shop.android:id/product_name_text_view") public List<WebElement> searchProduct_lbl_MM;
    @AndroidFindBy(xpath = "//*[@text='Add to Cart']") public List <WebElement> add_To_Cart_btn;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/title") public WebElement product_Title_lbl;
    @AndroidFindBy(id = "com.shop.android:id/title") public WebElement product_Title_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/snackbar_text") public WebElement success_Message_lbl;
    @AndroidFindBy(id = "com.shop.android:id/snackbar_text") public WebElement success_Message_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/cart") public WebElement go_To_Cart_btn;
    @AndroidFindBy(id = "com.shop.android:id/cart") public WebElement go_To_Cart_btn_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_laz_trade_item_title") public List <WebElement> product_Title_In_Cart_lbl;
    @AndroidFindBy(id = "com.shop.android"+dev+":id/tv_laz_trade_item_title") public List <WebElement> product_Title_In_Cart_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_laz_cart_slide_gesture_got_it") public List <WebElement> ok_Got_It_btn;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_cart_slide_gesture_got_it") public List <WebElement> ok_Got_It_btn_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tab_layout") public List <WebElement> cart_icon;
    @AndroidFindBy(id = "com.shop.android:id/tab_layout") public List <WebElement> cart_icon_MM;
    @AndroidFindBy (id= "com.daraz.android"+dev+":id/ckb_laz_trade_item_checkbox") public List <WebElement> product_chkbox;
    @AndroidFindBy (id= "com.shop.android:id/ckb_laz_trade_item_checkbox") public List <WebElement> product_chkbox_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_laz_laz_cart_toolbar_management") public WebElement delete_first_btn;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/btn_laz_trade_management_delete") public WebElement delete_second_btn;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_laz_cart_toolbar_management") public WebElement delete_first_btn_MM;
    @AndroidFindBy(id = "com.shop.android:id/btn_laz_trade_management_delete") public WebElement delete_second_btn_MM;
    @AndroidFindBy (id= "com.daraz.android"+dev+":id/btn_trade_confirm_dialog_positive") public WebElement delete_third_btn;
    @AndroidFindBy (id= "com.shop.android:id/btn_trade_confirm_dialog_positive") public WebElement delete_third_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/confirm_button") public List <WebElement> overseas_Confirm_btn;
    @AndroidFindBy (id = "com.shop.android:id/confirm_button") public List <WebElement> overseas_Confirm_btn_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/ckb_laz_trade_total_checkbox") public WebElement select_All_chkbox;
    @AndroidFindBy(id = "com.shop.android"+dev+":id/ckb_laz_trade_total_checkbox") public WebElement select_All_chkbox_MM;
    @AndroidFindBy(id ="com.daraz.android"+dev+":id/iv_laz_trade_item_action_wishlist") public List <WebElement> wishlist_In_Cart_btn;
    @AndroidFindBy(id ="com.shop.android"+dev+":id/iv_laz_trade_item_action_wishlist") public List <WebElement> wishlist_In_Cart_btn_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/other_action") public List <WebElement> buy_Now_btn;
    @AndroidFindBy(id = "com.shop.android:id/other_action") public List <WebElement> buy_Now_btn_MM;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/laz_trade_shop_checkbox") public List <WebElement> shop_check_box;
    @AndroidFindBy(id="com.shop.android:id/laz_trade_shop_checkbox") public List <WebElement> shop_check_box_MM;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/tv_laz_trade_item_sku") public List <WebElement> shopName_For_Product;
    @AndroidFindBy(id="com.shop.android:id/tv_laz_trade_item_sku") public List <WebElement> shopName_For_Product_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_laz_trade_order_total_amount") public WebElement cart_Total_Price_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_order_total_amount")  public WebElement cart_Total_Price_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_laz_trade_total_bar_fee_value") public WebElement cart_Shipping_Price_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_total_bar_fee_value") public WebElement cart_Shipping_Price_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/iv_laz_trade_item_action_delete") public List <WebElement> delete_Slide_Element_btn;
    @AndroidFindBy(id = "com.shop.android:id/iv_laz_trade_item_action_delete") public List <WebElement> delete_Slide_Element_btn_MM;
    @AndroidFindBy(id= "com.daraz.android"+dev+":id/tv_laz_trade_not_available_action_delete") public List <WebElement> delete_unavailable_item_btn;
    @AndroidFindBy(id= "com.shop.android:id/tv_laz_trade_not_available_action_delete") public List <WebElement> delete_unavailable_item_btn_MM;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/btn_trade_confirm_dialog_positive") public List <WebElement> delete_Final_btn;
    @AndroidFindBy(id="com.shop.android:id/btn_trade_confirm_dialog_positive") public List <WebElement> delete_Final_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_recommendation_top_title") public List <WebElement> just_For_You_Title_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_recommendation_top_title") public List <WebElement> just_For_You_Title_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/main_action") public List <WebElement>  add_To_Cart_Second_btn;
    @AndroidFindBy(id = "com.shop.android:id/main_action") public List <WebElement> add_To_Cart_Second_btn_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/label") public List <WebElement> quantity_Pdp_lbl;
    @AndroidFindBy(id = "com.shop.android"+dev+":id/label") public List <WebElement> quantity_Pdp_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/add_to_cart") public List <WebElement> combo_Add_To_Cart_btn;
    @AndroidFindBy(id = "com.shop.android"+dev+":id/add_to_cart") public List <WebElement> combo_Add_To_Cart_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/laz_tv_empty_button") public List <WebElement> continue_Shopping_Cart_btn;
    @AndroidFindBy(id = "com.shop.android:id/laz_tv_empty_button") public List <WebElement> continue_Shopping_Cart_btn_MM;
    @AndroidFindBy(id= "com.daraz.android:id/popup_header_close") public List <WebElement> popup_Close_Button;
    @AndroidFindBy(id= "com.shop.android:id/popup_header_close") public List <WebElement> popup_Close_Button_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_item_current_price") public WebElement cart_Item_Current_Price;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_item_current_price") public WebElement cart_Item_Current_Price_MM;
    @AndroidFindBy(id = "com.daraz.android:id/laz_trade_item_origin_price") public List <WebElement> cart_Item_Orginal_Price;
    @AndroidFindBy(id = "com.shop.android:id/laz_trade_item_origin_price") public List <WebElement> cart_Item_Original_Price_MM;
    @AndroidFindBy(id = "com.daraz.android:id/laz_trade_item_promotion_ratio") public WebElement cart_Item_Promotion_Ratio_Price;
    @AndroidFindBy(id = "com.shop.android:id/laz_trade_item_promotion_ratio") public WebElement cart_Item_Promotion_Ratio_Price_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_total_bar_fee_label") public WebElement cart_Shipping_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_total_bar_fee_label") public WebElement cart_Shipping_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_order_total_label") public WebElement cart_Total_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_order_total_label") public WebElement cart_Total_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/laz_trade_item_quantity_count") public WebElement cart_Item_Quantity_txt;
    @AndroidFindBy(id = "com.shop.android:id/laz_trade_item_quantity_count") public WebElement cart_Item_Quantity_txt_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_shop_voucher_title") public WebElement get_Voucher_Title_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_shop_voucher_title") public WebElement get_Voucher_Title_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_seller_voucher_profit_txt") public WebElement get_Voucher_Profit_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_seller_voucher_profit_txt") public WebElement get_Voucher_Profit_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_seller_voucher_condition") public WebElement get_Voucher_Condition_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_seller_voucher_condition") public WebElement get_Voucher_Condition_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_seller_voucher_validity") public WebElement get_Voucher_Validity_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_seller_voucher_validity") public WebElement get_Voucher_Validity_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/btn_laz_trade_seller_voucher_collect") public WebElement get_Voucher_Collect_btn;
    @AndroidFindBy(id = "com.shop.android:id/btn_laz_trade_seller_voucher_collect") public WebElement get_Voucher_Collect_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_trade_shop_voucher_close") public WebElement get_Voucher_Close_btn;
    @AndroidFindBy(id = "com.shop.android:id/tv_trade_shop_voucher_close") public WebElement get_Voucher_Close_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_common_black_toast") public WebElement get_Voucher_Toast_Message_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_common_black_toast") public WebElement get_Voucher_Toast_Message_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/edit_laz_trade_voucher_input") public List <WebElement> code_Voucher_txtBox;
    @AndroidFindBy(id = "com.shop.android:id/edit_laz_trade_voucher_input") public List <WebElement> code_Voucher_txtBox_MM;
    @AndroidFindBy(id = "com.daraz.android:id/btn_laz_trade_voucher_input_apply") public WebElement code_Voucher_Apply_btn;
    @AndroidFindBy(id = "com.shop.android:id/btn_laz_trade_voucher_input_apply") public WebElement code_Voucher_Apply_btn_MM;
    @AndroidFindBy(id  = "com.daraz.android:id/icf_laz_trade_voucher_input_clear") public WebElement code_Voucher_Clear_btn;
    @AndroidFindBy(id = "com.daraz.android:id/container_laz_trade_item_content") public List <WebElement> cart_Item_Container;
    @AndroidFindBy(id = "com.shop.android:id/container_laz_trade_item_content") public List <WebElement> cart_Item_Container_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_voucher_validate_tip") public List <WebElement> cart_Voucher_Error_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_voucher_validate_tip") public List <WebElement> cart_Voucher_Error_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android:id/icf_laz_trade_voucher_input_clear") public WebElement voucher_Clear_btn;
    @AndroidFindBy(id = "com.shop.android:id/icf_laz_trade_voucher_input_clear") public WebElement voucher_Clear_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_laz_trade_voucher_applied_tip") public List <WebElement> voucher_Success_Message_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_voucher_applied_tip") public List <WebElement> voucher_Success_Message_lbl_MM;



    public By searchProduct_lbl_By = By.id("com.daraz.android"+dev+":id/product_name_text_view");
    public By searchProduct_lbl_MM_By = By.id("com.shop.android:id/product_name_text_view");
    public By product_Title_lbl_By = By.id("com.daraz.android"+dev+":id/title");
    public By product_Title_lbl_By_MM = By.id("com.shop.android:id/title");
    public By product_Title_In_Cart_lbl_By = By.id("com.daraz.android"+dev+":id/tv_laz_trade_item_title");
    public By product_Title_In_Cart_lbl_By_MM = By.id("com.shop.android:id/tv_laz_trade_item_title");
    public By ok_Got_It_btn_By = By.id("com.daraz.android"+dev+":id/tv_laz_cart_slide_gesture_got_it");
    public By ok_Got_It_btn_By_MM = By.id("com.shop.android:id/tv_laz_cart_slide_gesture_got_it");
    public By cart_icon_By = By.id("com.daraz.android"+dev+":id/tab_layout");
    public By cart_icon_By_MM = By.id("com.shop.android:id/tab_layout");
    public By product_rdobtn_By = By.id("com.daraz.android"+dev+":id/ckb_laz_trade_item_checkbox");
    public By product_rdobtn_By_MM = By.id("com.shop.android:id/ckb_laz_trade_item_checkbox");
    public By wishlist_In_Cart_btn_By = By.id("com.daraz.android"+dev+":id/iv_laz_trade_item_action_wishlist");
    public By wishlist_In_Cart_btn_By_MM = By.id("com.shop.android:id/iv_laz_trade_item_action_wishlist");
    public By proceed_To_Pay_btn_by = By.id("com.daraz.android"+dev+":id/btn_laz_trade_order_total_proceed_next");
    public By go_To_Cart_btn_By = By.id("com.daraz.android"+dev+":id/cart");
    public By go_To_Cart_btn_By_MM = By.id("com.shop.android:id/cart");
    public By delete_Slide_Element_btn_By = By.id("com.daraz.android"+dev+":id/iv_laz_trade_item_action_delete");
    public By delete_Slide_Element_btn_By_MM = By.id("com.shop.android:id/iv_laz_trade_item_action_delete");
    public By delete_Final_btn_By = By.id("com.daraz.android"+dev+":id/btn_trade_confirm_dialog_positive");
    public By delete_Final_btn_By_MM = By.id("com.shop.android:id/btn_trade_confirm_dialog_positive");
    public By combo_Add_To_Cart_btn_By = By.id("com.daraz.android"+dev+":id/add_to_cart");
    public By combo_Add_To_Cart_btn_By_MM = By.id("com.shop.android"+dev+":id/add_to_cart");
    public By get_Voucher_Title_lbl_By = By.id("com.daraz.android:id/tv_laz_trade_shop_voucher_title");
    public By get_Voucher_Title_lbl_By_MM = By.id("com.shop.android:id/tv_laz_trade_shop_voucher_title");
    public By cart_Item_Original_Price_By = By.id("com.daraz.android:id/laz_trade_item_origin_price");
    public By cart_Item_Original_Price_By_MM = By.id("com.shop.android:id/laz_trade_item_origin_price");
    public By cart_Item_Current_Price_By = By.id("com.daraz.android:id/tv_laz_trade_item_current_price");
    public By cart_Item_Current_Price_By_MM = By.id("com.shop.android:id/tv_laz_trade_item_current_price");
    public By cart_Item_Promotion_Ratio_Price_By = By.id("com.daraz.android:id/laz_trade_item_promotion_ratio");
    public By cart_Item_Promotion_Ratio_Price_By_MM = By.id("com.shop.android:id/laz_trade_item_promotion_ratio");
    public By cart_Item_Quantity_txt_By = By.id("com.daraz.android:id/laz_trade_item_quantity_count");
    public By cart_Item_Quantity_txt_By_MM = By.id("com.shop.android:id/laz_trade_item_quantity_count");
    public By cart_Voucher_Error_lbl_By = By.id("com.daraz.android:id/tv_laz_trade_voucher_validate_tip");
    public By cart_Voucher_Error_lbl_By_MM = By.id("com.shop.android:id/tv_laz_trade_voucher_validate_tip");
    public By get_Voucher_Validity_lbl_By = By.id("com.daraz.android:id/tv_laz_trade_seller_voucher_validity");
    public By get_Voucher_Validity_lbl_By_MM = By.id("com.shop.android:id/tv_laz_trade_seller_voucher_validity");

}