package member.APP.pageObjects;

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
 * Date: 14-June-2019
 */

public class WishlistPageObjects extends BuildIDPicker {
    @AndroidFindBy (id="com.daraz.android"+dev+":id/product_name_text_view") public List<WebElement> searchProduct_lbl;
    @AndroidFindBy (id="com.shop.android:id/product_name_text_view") public List <WebElement> searchProduct_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/wishlist") public WebElement wishlist_icon;
    @AndroidFindBy (id = "com.shop.android:id/wishlist") public WebElement wishlist_icon_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/btn_login_fresh_welcome_login") public List <WebElement> login_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_login_fresh_welcome_login") public List <WebElement> login_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/view_login_social_google") public WebElement google_btn;
    @AndroidFindBy (id = "com.shop.android:id/view_login_social_google") public WebElement google_btn_MM;
    @AndroidFindAll({@AndroidBy(className = "android.widget.EditText"),@AndroidBy(xpath = "//*[@resource-id='identifierId']")}) public WebElement email_txt;
    @AndroidFindBy(xpath = "//*[@resource-id='identifierNext']") public WebElement next_btn;
    @AndroidFindBy(className = "android.widget.EditText") public WebElement password_txt;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@resource-id='passwordNext']"),@AndroidBy(className= "android.widget.Button")}) public WebElement password_Next_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@resource-id='signinconsentNext']"),@AndroidBy(className= "android.widget.Button")}) public WebElement i_Agree_btn;
    @AndroidFindBy (xpath = "//*[@resource-id='android:id/button1']") public WebElement agree_btn;
    @AndroidFindBy (id = "com.google.android.gms:id/add_account_chip_title") public WebElement use_Another_Account_btn;
    @AndroidFindBy (id = "com.google.android.gms:id/account_name") public List <WebElement> accout_ID_lbl;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@text='ACCEPT']"),@AndroidBy(className= "android.widget.Button")}) public WebElement services_Accept_btn;
    @AndroidFindBy (xpath = "//*[@text='MORE']") public WebElement more_btn;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/snackbar_text") public WebElement wishlist_Success_Message_lbl;
    @AndroidFindBy (id = "com.shop.android:id/snackbar_text") public WebElement wishlist_Success_Message_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/snackbar_action") public WebElement go_To_Wishlist_btn;
    @AndroidFindBy (id = "com.shop.android:id/snackbar_action") public WebElement go_To_Wishlist_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/title") public WebElement product_Name_lbl;
    @AndroidFindBy (id = "com.shop.android:id/title") public WebElement product_Name_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/confirm_button") public List <WebElement> overseas_Confirm_btn;
    @AndroidFindBy (id = "com.shop.android:id/confirm_button") public List <WebElement> overseas_Confirm_btn_MM;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tab_layout") public List <WebElement> account_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tab_layout") public List <WebElement> account_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/txt_login_signup") public WebElement login_Signup_btn;
    @AndroidFindBy (id = "com.shop.android:id/txt_login_signup") public WebElement login_Signup_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/uptext") public List  <WebElement> wishlist_lbl;
    @AndroidFindBy (id = "com.shop.android:id/uptext") public List <WebElement> wishlist_lbl_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='\uE723']"),@AndroidBy(className= "//*[@content-desc='\uE723']")}) public List <WebElement> wishlist_Delete_icon;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='REMOVE']"),@AndroidBy(className= "//*[@content-desc='REMOVE']")}) public WebElement remove_btn;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/dots") public List <WebElement> dots_btn;
    @AndroidFindBy(id = "com.shop.android:id/dots") public List <WebElement> dots_btn_MM;
    @AndroidFindBy (xpath = "//*[@text='My Account']") public WebElement my_Account_menuItem;
    @AndroidFindBy(xpath = "//*[@text='My Cart']") public List <WebElement> cart_lbl;
    @AndroidFindBy(id = "com.daraz.android"+dev+":id/tv_laz_trade_item_title") public List <WebElement> items_In_Cart_lbl;
    @AndroidFindBy(id = "com.shop.android:id/tv_laz_trade_item_title") public List <WebElement> items_In_Cart_lbl_MM;
    @AndroidFindBy(id="com.daraz.android"+dev+":id/iv_cart") public WebElement cart_Icon_Wishlist;
    @AndroidFindBy(id="com.shop.android:id/iv_cart") public WebElement cart_Icon_Wishlist_MM;
    @AndroidFindBy(id = "com.daraz.android:id/tv_agree") public List <WebElement> login_Policy_Agree_btn;
    @AndroidFindBy(id = "com.shop.android:id/tv_agree") public List <WebElement> login_Policy_Agree_btn_MM;
    @AndroidFindBy(id = "com.daraz.android:id/iv_google") public List <WebElement> login_Google_btn;
    @AndroidFindBy(id = "com.shop.android:id/iv_google") public List <WebElement> login_Google_btn_MM;

    public By dots_btn_By = By.id("com.daraz.android"+dev+":id/dots");
    public By dots_btn_By_MM = By.id("com.shop.android:id/dots");
    public By my_Account_menuItem_By = By.xpath("//*[@text='My Account']");
    public By searchProduct_lbl_By = By.id("com.daraz.android"+dev+":id/product_name_text_view");
    public By searchProduct_lbl_MM_By = By.id("com.shop.android:id/product_name_text_view");
    public By wishlist_icon_By = By.id("com.daraz.android"+dev+":id/wishlist");
    public By wishlist_icon_By_MM = By.id("com.shop.android:id/wishlist");
    public By login_btn_By = By.id("com.daraz.android"+dev+":id/btn_login_fresh_welcome_login");
    public By login_btn_By_MM = By.id("com.shop.android:id/btn_login_fresh_welcome_login");
    public By google_btn_By = By.id("com.daraz.android"+dev+":id/view_login_social_google");
    public By google_btn_By_MM = By.id("com.shop.android:id/view_login_social_google");
    public By password_txt_By = By.className("android.widget.EditText");
    public By i_Agree_btn_by = By.xpath("//*[@resource-id='signinconsentNext']");
    public By agree_btn_by = By.xpath("//*[@resource-id='android:id/button1']");
    public By email_txt_By = By.xpath("//*[@resource-id='identifierId']");
    public By wishlist_Success_Message_lbl_By = By.id("com.daraz.android"+dev+":id/snackbar_text");
    public By wishlist_Success_Message_lbl_By_MM = By.id("com.shop.android:id/snackbar_text");
    public By go_To_Wishlist_btn_By = By.id("com.daraz.android"+dev+":id/snackbar_action");
    public By go_To_Wishlist_btn_By_MM = By.id("com.shop.android:id/snackbar_action");
    public By ele1_By = By.xpath("//*[@contentDescription='test_item_for_bundle_service_1']");
    public By account_lbl_By = By.id("com.daraz.android"+dev+":id/tab_layout");
    public By account_lbl_By_MM = By.id("com.shop.android:id/tab_layout");
    public By login_Signup_btn_By = By.id("com.daraz.android"+dev+":id/txt_login_signup");
    public By login_Signup_btn_By_MM = By.id("com.shop.android:id/txt_login_signup");
    public By wishlist_lbl_By = By.id("com.daraz.android"+dev+":id/uptext");
    public By wishlist_lbl_By_MM = By.id("com.shop.android:id/uptext");
    public By wishlist_Delete_icon_By = By.xpath("//*[@contentDescription='\uE723'] | //*[@content-desc='\uE723']");
    public By remove_btn_By = By.xpath("//*[@contentDescription='REMOVE'] | //*[@content-desc='REMOVE']");
    public By product_Name_lbl_By = By.id("com.daraz.android"+dev+":id/title");
    public By product_Name_lbl_MM_By = By.id("com.shop.android:id/title");
    public By cart_lbl_By = By.xpath("//*[@text='Cart']");
    public By items_In_Cart_lbl_By = By.id("com.daraz.android"+dev+":id/tv_laz_trade_item_title");
    public By items_In_Cart_lbl_MM_By = By.id("com.shop.android:id/tv_laz_trade_item_title");
    public By cart_Icon_Wishlist_By = By.id("com.daraz.android"+dev+":id/iv_cart");
    public By cart_Icon_Wishlist_MM_By = By.id("com.shop.android:id/iv_cart");
    public By login_Google_btn_By = By.id("com.daraz.android:id/iv_google");
    public By login_Google_btn_By_MM = By.id("com.shop.android:id/iv_google");
}
