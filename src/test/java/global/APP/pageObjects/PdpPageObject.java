package global.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-November-2019
 */

public class PdpPageObject extends BuildIDPicker {
 @AndroidFindBy(id= "com.daraz.android"+dev+":id/pdp_gallery_item_video_icon") public List<WebElement> video_icon;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/video_button_close") public WebElement video_Close_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/text_page_indicator") public List <WebElement> picture_Number_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/pdp_gallery_item_image") public WebElement pdp_image;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/image") public List <WebElement> product_images;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/button_close") public WebElement picture_Close_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/title") public List <WebElement> product_Title_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/tv_price") public List <WebElement> displayed_Price_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/tv_origin_price") public List <WebElement> original_Price_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/tv_discount") public List <WebElement> discount_Rate_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/rating_layout") public List <WebElement> rating_bar;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/wishlist") public List <WebElement> wishlist_icon;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/share") public List <WebElement> share_icon;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/share_panel_title") public List <WebElement> share_Title_lbl;
 @AndroidFindBy(xpath = "//*[contains(@resource-id,'label_left_title') and contains(@text,'Specifications')]")
 public List<WebElement> specifications_lbl;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/specification_popup_item_title") public List <WebElement> specifications_Contents_lbl;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/label_middle_des") public WebElement specification_Information_On_Pdp;
 @AndroidFindBy(xpath = "//*[@text='Delivery']") public List <WebElement> deliver_Options_lbl;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/item_icon") public List <WebElement> map_icon;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/item_content") public List <WebElement> item_content_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/popup_header_title") public List <WebElement> popup_header_lbl;
 @AndroidFindBy(xpath="//*[@text='Service']") public List <WebElement> service_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/rating_review_title") public List <WebElement> rating_Review_title;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/rating_review_view_all") public List <WebElement> view_all_rating_and_review_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/qa_title") public List <WebElement> qa_Title_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/qa_view_all") public List <WebElement> qa_View_All_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/ask_button") public List <WebElement> ask_Question_btn;
 @AndroidFindBy(xpath="//*[@text='Q&A']") public List <WebElement> qa_page_title_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/shopIcon") public WebElement store_btn;
 @AndroidFindBy(id = "com.daraz.android" + dev + ":id/laz_shop_follow_btn")
 public List<WebElement> store_Follow_lst_ele_btn;
 @AndroidFindBy(id = "com.shop.android" + dev + ":id/laz_shop_follow_btn")
 public List<WebElement> store_Follow_lst_ele_btn_MM;
 @AndroidFindBy (id="com.daraz.android"+dev+":id/seller_recommend_title") public List <WebElement> recommended_By_Seller_lbl;
 @AndroidFindBy(id = "dots")
 public WebElement dots_button;
 @AndroidFindBy(id="menuText") public List <WebElement> menu_List;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/btn_login_fresh_welcome_login") public List <WebElement> login_btn;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/search_input_box") public List <WebElement> searchAfterClick_txtfield;
 @AndroidFindBy(xpath = "//*[@text='Messages']") public List <WebElement> messages_Header_lbl;
 @AndroidFindBy(xpath = "//*[@text='Help']") public List <WebElement> help_Header_lbl;
 @AndroidFindBy(id= "com.daraz.android"+dev+":id/tabText") public List <WebElement> elevator_tab;
 @AndroidFindBy(xpath="//*[@text='100% Authentic']") public List <WebElement> authentic_lbl;
 @AndroidFindBy(xpath = "//*[contains(@text,'return') or contains(@text,'returns') or contains(@text,'Return')]")
 public List<WebElement> easy_Return_lbl;
 @AndroidFindBy(xpath = "//*[@text='Variations']") public List <WebElement> variation_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/text") public List <WebElement> sku_Selector_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/remove") public WebElement quantity_Decrement_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/add") public WebElement quantity_Increase_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/quantity") public WebElement quantity_txtBox;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/tv_ok") public List <WebElement> chat_ok_btn;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/msgcenter_panel_input_edit") public List <WebElement> msg_Center_txtBox;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/chatIcon") public List <WebElement> chat_icon;
 @AndroidFindBy(xpath = "//*[@text='Vouchers']") public List <WebElement> voucher_Title_lbl;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/snackbar_text") public List <WebElement> voucher_Success_Message_snackbar;
 @AndroidFindBy(xpath="//*[@text='Collect']") public WebElement voucher_Collect_btn;
 @AndroidFindBy(xpath = "//*[@text='Copy']") public WebElement voucher_Copy_btn;
 @AndroidFindBy(xpath = "//*[@text='Promo Saved:']") public List <WebElement> promo_Saved_lbl;
 @AndroidFindBy(xpath = "(//*[@id='container_laz_order_saved_fee']/*/*/*[@id='tv_laz_trade_total_bar_fee_value'])[2]") public List <WebElement> promo_Saved_Price_lbl;
 @AndroidFindBy(xpath="//*[@text='Promotions']") public List <WebElement> promotion_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/laz_trade_item_quantity_count") public List <WebElement> product_Count_In_Chekout_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/container_laz_trade_item_content") public List <WebElement> cart_Item_container;
 @AndroidFindBy (xpath = "//*[@text='2']") public WebElement item_Count_lbl;
 @AndroidFindBy(id="com.daraz.android"+dev+":id/confirm_btn") public WebElement confirm_btn;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/recommend_image") public List <WebElement> recommended_By_Seller_Products;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_laz_trade_bundle_title") public List <WebElement> product_Cart_Title_lbl;
 @AndroidFindBy(id = "com.daraz.android:id/code") public WebElement voucher_Code_lbl;
 @AndroidFindBy(id = "com.shop.android:id/code") public WebElement voucher_Code_lbl_MM;
 @AndroidFindBy(id = "com.daraz.android:id/text_title") public WebElement product_Size_PDP_lbl;
 @AndroidFindBy(id = "com.daraz.android:id/main_action") public List <WebElement> add_To_Cart_Variation_btn;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'img_condition_popup_status')]")
    public WebElement popup_condition_bar_Ele;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'popup_header_close')]")
    public WebElement popup_close_btn_Ele;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'main_action_container')]")
    public WebElement add_to_Cart_btn_Ele;


 @AndroidFindBy(id= "com.shop.android:id/pdp_gallery_item_video_icon") public List<WebElement> video_icon_MM;
 @AndroidFindBy(id="com.shop.android:id/video_button_close") public WebElement video_Close_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/text_page_indicator") public List <WebElement> picture_Number_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/pdp_gallery_item_image") public WebElement pdp_image_MM;
 @AndroidFindBy(id="com.shop.android:id/image") public List <WebElement> product_images_MM;
 @AndroidFindBy(id="com.shop.android:id/button_close") public WebElement picture_Close_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/title") public List <WebElement> product_Title_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/tv_price") public List <WebElement> displayed_Price_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/tv_origin_price") public List <WebElement> original_Price_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/tv_discount") public List <WebElement> discount_Rate_lbl_MM;
 @AndroidFindBy (id="com.shop.android:id/rating_layout") public List <WebElement> rating_bar_MM;
 @AndroidFindBy(id="com.shop.android:id/share") public List <WebElement> share_icon_MM;
 @AndroidFindBy(id="com.shop.android:id/wishlist") public List <WebElement> wishlist_icon_MM;
 @AndroidFindBy(id="com.shop.android:id/share_panel_title") public List <WebElement> share_Title_MM;
 @AndroidFindBy(id = "com.shop.android:id/specification_popup_item_title") public List <WebElement> specifications_Contents_lbl_MM;
 @AndroidFindBy(id = "com.shop.android:id/label_middle_des") public WebElement specification_Information_On_Pdp_MM;
 @AndroidFindBy (id = "com.shop.android:id/item_icon") public List <WebElement> map_icon_MM;
 @AndroidFindBy(id="com.shop.android:id/item_content") public List <WebElement> item_content_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/popup_header_title") public List <WebElement> popup_header_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/rating_review_title") public List <WebElement> rating_Review_title_MM;
 @AndroidFindBy(id="com.shop.android:id/rating_review_view_all") public List <WebElement> view_all_rating_and_review_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/qa_title") public List <WebElement> qa_Title_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/qa_view_all") public List <WebElement> qa_View_All_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/ask_button") public List <WebElement> ask_Question_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/shopIcon") public WebElement store_btn_MM;
 @AndroidFindBy (id="com.shop.android:id/seller_recommend_title") public List <WebElement> recommended_By_Seller_lbl_MM;
 @AndroidFindBy (id="com.shop.android:id/dots") public WebElement dots_button_MM;
 @AndroidFindBy(id="com.shop.android:id/menuText") public List <WebElement> menu_List_MM;
 @AndroidFindBy(id="com.shop.android:id/btn_login_fresh_welcome_login") public List <WebElement> login_btn_MM;
 @AndroidFindBy (id = "com.shop.android:id/search_input_box") public List <WebElement> searchAfterClick_txtfield_MM;
 @AndroidFindBy(id= "com.shop.android:id/tabText") public List <WebElement> elevator_tab_MM;
 @AndroidFindBy(id="com.shop.android:id/text") public List <WebElement> sku_Selector_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/remove") public WebElement quantity_Decrement_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/add") public WebElement quantity_Increase_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/quantity") public WebElement quantity_txtBox_MM;
 @AndroidFindBy(id="com.shop.android:id/tv_ok") public List <WebElement> chat_ok_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/msgcenter_panel_input_edit") public List <WebElement> msg_Center_txtBox_MM;
 @AndroidFindBy(id="com.shop.android:id/chatIcon") public List <WebElement> chat_icon_MM;
 @AndroidFindBy(id = "com.shop.android:id/snackbar_text") public List <WebElement> voucher_Success_Message_snackbar_MM;
 @AndroidFindBy(id="com.shop.android:id/laz_trade_item_quantity_count") public List <WebElement> product_Count_In_Chekout_lbl_MM;
 @AndroidFindBy(id="com.shop.android:id/container_laz_trade_item_content") public List <WebElement> cart_Item_container_MM;
 @AndroidFindBy(id="com.shop.android:id/confirm_btn") public WebElement confirm_btn_MM;
 @AndroidFindBy(id="com.shop.android:id/share_panel_title") public List <WebElement> share_Title_lbl_MM;
 @AndroidFindBy(id = "com.shop.android:id/recommend_image") public List <WebElement> recommended_By_Seller_Products_MM;
 @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_bundle_title") public List <WebElement> product_Cart_Title_lbl_MM;
 @AndroidFindBy(id = "com.shop.android:id/text_title") public WebElement product_Size_PDP_lbl_MM;
 @AndroidFindBy(id = "com.shop.android:id/main_action") public List <WebElement> add_To_Cart_Variation_btn_MM;
 @AndroidFindBy(id = "com.daraz.android:id/size_chat_container") public WebElement size_Chart_lbl;
 @AndroidFindBy(id = "com.shop.android:id/size_chat_container") public WebElement size_Chart_lbl_MM;
    @AndroidFindBy(id = "com.daraz.android" + dev + ":id/img_condition_status")
    public WebElement condition_Bar_Image_Ele;
    @AndroidFindBy(id = "com.shop.android" + dev + ":id/img_condition_status")
    public WebElement condition_Bar_Image_Ele_MM;
    @AndroidFindBy(id = "com.daraz.android" + dev + ":id/popup_header_title")
    public WebElement condition_Bar_Title_Ele;
    @AndroidFindBy(id = "com.shop.android" + dev + ":id/popup_header_title")
    public WebElement condition_Bar_Title_Ele_MM;
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_condition')]")
    public List<WebElement> condition_popup_Btn_list_Ele;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/pop_list")
    public WebElement pdp_upperRight_corner_List_ele;
    @AndroidFindBy(id = "com.shop.android"+dev+":id/pop_list")
    public WebElement pdp_upperRight_corner_List_MM_ele;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/badge_dots")
 public WebElement msgcount_on_pdp_menu_ele;
 @AndroidFindBy(id = "com.shop.android"+dev+":id/badge_dots")
 public List <WebElement> msgcount_on_pdp_menu_ele_LISTTEST;
 @AndroidFindBy(id = "badge_dots")
 public WebElement msgcount_on_pdp_menu_ele_MM;
 @AndroidFindBy(id = "com.shop.android"+dev+":id/red_number_dot")
 public WebElement msgcount_In_pdp_menu_ele_MM;
 @AndroidFindBy(id = "com.daraz.android"+dev+":id/red_number_dot")
 public WebElement msgcount_In_pdp_menu_ele;
 @AndroidFindBy(id = "red_number_dot")
 public List <WebElement> msgcount_In_pdp_menu_ele_LISTTest;

    public By conditions_Pdp_Label_By = By.xpath("//*[@resource-id='com.daraz.android" + dev + ":id/label_left_title' and @text='Condition']");
    public By conditions_Pdp_Label_MM_By = By.xpath("//*[@resource-id='com.shop.android" + dev + ":id/label_left_title' and @text='Condition']");
    public By condition_bar_image_By = By.id("com.daraz.android" + dev + ":id/img_condition_status");
    public By condition_bar_image_MM_By = By.id("com.shop.android" + dev + ":id/img_condition_status");
    public By condition_bar_text_By = By.id("com.daraz.android" + dev + ":id/txt_condition");
    public By condition_bar_text_MM_By = By.id("com.shop.android" + dev + ":id/txt_condition");
    public By size_Chart_Screen_Label_By = By.xpath("//*[@class='android.widget.TextView' and contains(text(), 'size')]");
 public By size_Chart_lbl_By = By.id("com.daraz.android"+dev+":id/size_chat_container");
 public By size_Chart_lbl_By_MM = By.id("com.shop.android"+dev+":id/size_chat_container");
 public By video_Close_btn_By = By.id("com.daraz.android"+dev+":id/video_button_close");
 public By video_Close_btn_By_MM = By.id("com.shop.android"+dev+":id/video_button_close");
 public By picture_Number_lbl_By = By.id("com.daraz.android"+dev+":id/text_page_indicator");
 public By picture_Number_lbl_By_MM = By.id("com.shop.android:id/text_page_indicator");
 public By product_images_By = By.id("com.daraz.android"+dev+":id/image");
 public By product_images_MM_By = By.id("com.shop.android:id/image");
 public By specifications_Contents_lbl_By = By.id("com.daraz.android"+dev+":id/specification_popup_item_title");
 public By specifications_Contents_lbl_MM_By = By.id("com.shop.android:id/specification_popup_item_title");
 public By popup_header_lbl_By = By.id("com.daraz.android"+dev+":id/popup_header_title");
 public By popup_header_lbl_By_MM = By.id("com.shop.android:id/popup_header_title");
 public By menu_List_By = By.id("com.daraz.android"+dev+":id/menuText");
 public By menu_List_By_MM = By.id("com.shop.android:id/menuText");
 public By dots_button_By = By.id("dots");
 public By dots_button_By_MM = By.id("com.shop.android:id/dots");
 public By product_Title_lbl_By = By.id("com.daraz.android"+dev+":id/title");
 public By product_Title_lbl_By_MM = By.id("com.shop.android:id/title");
 public By sku_Selector_btn_By = By.id("com.daraz.android"+dev+":id/text");
 public By sku_Selector_btn_By_MM = By.id("com.shop.android:id/text");
 public By qa_page_title_lbl_By = By.xpath("//*[@text='Q&A']");
 public By chat_icon_By = By.id("com.daraz.android"+dev+":id/chatIcon");
 public By chat_icon_MM_By = By.id("com.shop.android:id/chatIcon");
 public By voucher_Collect_btn_By = By.xpath("//*[@text='Collect']");
 public By voucher_Copy_btn_By = By.xpath("//*[@text='Copy']");
 public By product_Count_In_Cart_By = By.id("com.daraz.android"+dev+":id/laz_trade_item_quantity_count");
 public By product_Count_In_Cart_By_MM = By.id("com.shop.android:id/laz_trade_item_quantity_count");
 public By item_Count_drpDown_By = By.id("com.daraz.android"+dev+":id/iv_laz_trade_item_action_dropdown");
 public By item_Count_drpDown_By_MM = By.id("com.shop.android:id/iv_laz_trade_item_action_dropdown");
 public By cart_Item_container_By = By.id("com.daraz.android"+dev+":id/container_laz_trade_item_content");
 public By cart_Item_container_By_MM = By.id("com.shop.android:id/container_laz_trade_item_content");
 public By store_Follow_btn_By = By.xpath("//*[contains(@resource-id,'laz_shop_follow_btn') and contains(@text,'Following')]");
 public By store_Follow_btn_By_MM  = By.id("com.shop.android:id/laz_shop_follow_btn");
 public By item_Count_lbl_By = By.xpath("//*[@text='2']");
 public By confirm_btn_By = By.id("com.daraz.android"+dev+":id/confirm_btn");
 public By confirm_btn_By_MM = By.id("com.shop.android:id/confirm_btn");
}
