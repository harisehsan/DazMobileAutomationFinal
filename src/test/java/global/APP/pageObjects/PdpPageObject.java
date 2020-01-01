package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-November-2019
 */

public class PdpPageObject {
 @AndroidFindBy(id= "com.daraz.android:id/pdp_gallery_item_video_icon") public List<WebElement> video_icon;
 @AndroidFindBy(id="com.daraz.android:id/video_button_close") public WebElement video_Close_btn;
 @AndroidFindBy(id="com.daraz.android:id/text_page_indicator") public List <WebElement> picture_Number_lbl;
 @AndroidFindBy(id="com.daraz.android:id/pdp_gallery_item_image") public WebElement pdp_image;
 @AndroidFindBy(id="com.daraz.android:id/image") public List <WebElement> product_images;
 @AndroidFindBy(id="com.daraz.android:id/button_close") public WebElement picture_Close_btn;
 @AndroidFindBy(id="com.daraz.android:id/title") public List <WebElement> product_Title_lbl;
 @AndroidFindBy(id="com.daraz.android:id/tv_price") public List <WebElement> displayed_Price_lbl;
 @AndroidFindBy(id="com.daraz.android:id/tv_origin_price") public List <WebElement> original_Price_lbl;
 @AndroidFindBy(id="com.daraz.android:id/tv_discount") public List <WebElement> discount_Rate_lbl;
 @AndroidFindBy(id="com.daraz.android:id/rating_layout") public List <WebElement> rating_bar;
 @AndroidFindBy(id="com.daraz.android:id/wishlist") public List <WebElement> wishlist_icon;
 @AndroidFindBy(id="com.daraz.android:id/share") public List <WebElement> share_icon;
 @AndroidFindBy(id="com.daraz.android:id/share_panel_title") public List <WebElement> share_Title_lbl;
 @AndroidFindBy(xpath = "//*[@text='Specifications' and @top='true']") public List <WebElement> specifications_lbl;
 @AndroidFindBy(id = "com.daraz.android:id/specification_popup_item_title") public List <WebElement> specifications_Contents_lbl;
 @AndroidFindBy(id = "com.daraz.android:id/label_middle_des") public WebElement specification_Information_On_Pdp;
 @AndroidFindBy(xpath = "//*[@text='Delivery']") public List <WebElement> deliver_Options_lbl;
 @AndroidFindBy(id = "com.daraz.android:id/item_icon") public List <WebElement> map_icon;
 @AndroidFindBy(id="com.daraz.android:id/item_content") public List <WebElement> item_content_lbl;
 @AndroidFindBy(id="com.daraz.android:id/popup_header_title") public List <WebElement> popup_header_lbl;
 @AndroidFindBy(xpath="//*[@text='Service']") public List <WebElement> service_lbl;
 @AndroidFindBy(id="com.daraz.android:id/rating_review_title") public List <WebElement> rating_Review_title;
 @AndroidFindBy(id="com.daraz.android:id/rating_review_view_all") public List <WebElement> view_all_rating_and_review_btn;
 @AndroidFindBy(id="com.daraz.android:id/qa_title") public List <WebElement> qa_Title_lbl;
 @AndroidFindBy(id="com.daraz.android:id/qa_view_all") public List <WebElement> qa_View_All_btn;
 @AndroidFindBy(id="com.daraz.android:id/ask_button") public List <WebElement> ask_Question_btn;
 @AndroidFindBy(xpath="//*[@text='Q&A']") public List <WebElement> qa_page_title_lbl;
 @AndroidFindBy(id="com.daraz.android:id/shopIcon") public WebElement store_btn;
 @AndroidFindBy(id="com.daraz.android:id/laz_shop_follow_btn") public WebElement store_Follow_btn;
 @AndroidFindBy (id="com.daraz.android:id/seller_recommend_title") public List <WebElement> recommended_By_Seller_lbl;
 @AndroidFindBy (id="com.daraz.android:id/dots") public WebElement dots_button;
 @AndroidFindBy(id="com.daraz.android:id/menuText") public List <WebElement> menu_List;
 @AndroidFindBy(id="com.daraz.android:id/btn_login_fresh_welcome_login") public List <WebElement> login_btn;
 @AndroidFindBy(id = "com.daraz.android:id/search_input_box") public List <WebElement> searchAfterClick_txtfield;
 @AndroidFindBy(xpath = "//*[@text='Messages']") public List <WebElement> messages_Header_lbl;
 @AndroidFindBy(xpath = "//*[@text='Help']") public List <WebElement> help_Header_lbl;
 @AndroidFindBy(id= "com.daraz.android:id/tabText") public List <WebElement> elevator_tab;
 @AndroidFindBy(xpath="//*[@text='100% Authentic']") public List <WebElement> authentic_lbl;
 @AndroidFindBy(xpath = "//*[@text='14 days easy return']") public List <WebElement> easy_Return_lbl;
 @AndroidFindBy(xpath = "//*[@text='Variations']") public List <WebElement> variation_lbl;
 @AndroidFindBy(id="com.daraz.android:id/text") public List <WebElement> sku_Selector_btn;
 @AndroidFindBy(id="com.daraz.android:id/remove") public WebElement quantity_Decrement_btn;
 @AndroidFindBy(id="com.daraz.android:id/add") public WebElement quantity_Increase_btn;
 @AndroidFindBy(id="com.daraz.android:id/quantity") public WebElement quantity_txtBox;
 @AndroidFindBy(id="com.daraz.android:id/tv_ok") public List <WebElement> chat_ok_btn;
 @AndroidFindBy(id="com.daraz.android:id/msgcenter_panel_input_edit") public List <WebElement> msg_Center_txtBox;
 @AndroidFindBy(id="com.daraz.android:id/chatIcon") public List <WebElement> chat_icon;
 @AndroidFindBy(xpath = "//*[@text='Vouchers']") public List <WebElement> voucher_Title_lbl;
 @AndroidFindBy(id = "com.daraz.android:id/snackbar_text") public List <WebElement> voucher_Success_Message_snackbar;
 @AndroidFindBy(xpath="//*[@text='Collect']") public WebElement voucher_Collect_btn;
 @AndroidFindBy(xpath = "//*[@text='Copy']") public WebElement voucher_Copy_btn;
 @AndroidFindBy(xpath = "//*[@text='Promo Saved:']") public List <WebElement> promo_Saved_lbl;
 @AndroidFindBy(xpath = "(//*[@id='container_laz_order_saved_fee']/*/*/*[@id='tv_laz_trade_total_bar_fee_value'])[2]") public List <WebElement> promo_Saved_Price_lbl;
 @AndroidFindBy(xpath="//*[@text='Promotions']") public List <WebElement> promotion_lbl;
 @AndroidFindBy(id="com.daraz.android:id/laz_trade_item_quantity_count") public List <WebElement> product_Count_In_Chekout_lbl;
 @AndroidFindBy(id="com.daraz.android:id/container_laz_trade_item_content") public List <WebElement> cart_Item_container;
 @AndroidFindBy (xpath = "//*[@text='2']") public WebElement item_Count_lbl;
 @AndroidFindBy(id="com.daraz.android:id/confirm_btn") public WebElement confirm_btn;


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
 @AndroidFindBy(id="com.shop.android:id/laz_shop_follow_btn") public WebElement store_Follow_btn_MM;
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


 public By video_Close_btn_By = By.id("com.daraz.android:id/video_button_close");
 public By video_Close_btn_By_MM = By.id("com.shop.android:id/video_button_close");
 public By picture_Number_lbl_By = By.id("com.daraz.android:id/text_page_indicator");
 public By picture_Number_lbl_By_MM = By.id("com.shop.android:id/text_page_indicator");
 public By product_images_By = By.id("com.daraz.android:id/image");
 public By product_images_MM_By = By.id("com.shop.android:id/image");
 public By specifications_Contents_lbl_By = By.id("com.daraz.android:id/specification_popup_item_title");
 public By specifications_Contents_lbl_MM_By = By.id("com.shop.android:id/specification_popup_item_title");
 public By popup_header_lbl_By = By.id("com.daraz.android:id/popup_header_title");
 public By popup_header_lbl_By_MM = By.id("com.shop.android:id/popup_header_title");
 public By menu_List_By = By.id("com.daraz.android:id/menuText");
 public By menu_List_By_MM = By.id("com.shop.android:id/menuText");
 public By dots_button_By = By.id("com.daraz.android:id/dots");
 public By dots_button_By_MM = By.id("com.shop.android:id/dots");
 public By product_Title_lbl_By = By.id("com.daraz.android:id/title");
 public By product_Title_lbl_By_MM = By.id("com.shop.android:id/title");
 public By sku_Selector_btn_By = By.id("com.daraz.android:id/text");
 public By sku_Selector_btn_By_MM = By.id("com.shop.android:id/text");
 public By qa_page_title_lbl_By = By.xpath("//*[@text='Q&A']");
 public By chat_icon_By = By.id("com.daraz.android:id/chatIcon");
 public By chat_icon_MM_By = By.id("com.shop.android:id/chatIcon");
 public By voucher_Collect_btn_By = By.xpath("//*[@text='Collect']");
 public By voucher_Copy_btn_By = By.xpath("//*[@text='Copy']");
 public By product_Count_In_Cart_By = By.id("com.daraz.android:id/laz_trade_item_quantity_count");
 public By product_Count_In_Cart_By_MM = By.id("com.shop.android:id/laz_trade_item_quantity_count");
 public By item_Count_drpDown_By = By.id("com.daraz.android:id/iv_laz_trade_item_action_dropdown");
 public By item_Count_drpDown_By_MM = By.id("com.shop.android:id/iv_laz_trade_item_action_dropdown");
}