package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 02-July-2019
 */

public class AddressPageObject extends BuildIDPicker {

    @AndroidFindBy (xpath = "//*[@text='Address Book']") public WebElement address_Book_lbl;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/btn_edit") public List<WebElement> edit_Address_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_edit") public List <WebElement> edit_Address_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/text_input_layout") public List <WebElement> address_Text_Input_layout;
    @AndroidFindBy (id = "com.shop.android:id/text_input_layout") public List <WebElement> address_Text_Input_layout_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/text_input_edit_text") public List <WebElement> address_Text_Input_txtbox;
    @AndroidFindBy (id = "com.shop.android:id/text_input_edit_text") public List <WebElement> address_Text_Input_txtbox_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/tv_address_location_tree_name") public List <WebElement> address_Location_Tree_lbl;
    @AndroidFindBy (id = "com.shop.android:id/tv_address_location_tree_name") public List <WebElement> address_Location_Tree_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/btn_action") public WebElement save_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_action") public WebElement save_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/tv_recipient") public List <WebElement> buyer_Name_lbl;
    @AndroidFindBy (id = "com.shop.android:id/tv_recipient") public List <WebElement> buyer_Name_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/tv_address_detail") public List <WebElement> buyer_address_lbl;
    @AndroidFindBy (id = "com.shop.android:id/tv_address_detail") public List <WebElement> buyer_address_lbl_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/btn_action") public WebElement new_Address_btn;
    @AndroidFindBy (id = "com.shop.android:id/btn_action") public WebElement new_Address_btn_MM;
    @AndroidFindBy (id = "com.daraz.android"+dev+":id/checkbox_makedef") public List <WebElement> make_Default_chkbox;
    @AndroidFindBy (id = "com.shop.android:id/checkbox_makedef") public List <WebElement> make_Default_chkbox_MM;
    @AndroidFindBy (xpath = "//*[@text='Delete address']") public List <WebElement> delete_Address_btn;
    @AndroidFindBy (xpath = "//*[@text='Delete address']") public List <WebElement> delete_Address_btn_MM;
    @AndroidFindBy (id = "android:id/button1") public List <WebElement> delete_Confirm_btn;
    @AndroidFindBy (id = "android:id/message") public List <WebElement> delete_Confirm_Message_lbl;

    public By address_Book_lbl_By = By.xpath("//*[@text='Address Book']");
    public By edit_Address_btn_By = By.id("com.daraz.android"+dev+":id/btn_edit");
    public By edit_Address_btn_By_MM = By.id("com.shop.android:id/btn_edit");
    public By address_Text_Input_layout_By = By.id("com.daraz.android"+dev+":id/text_input_layout");
    public By address_Text_Input_layout_By_MM = By.id("com.shop.android:id/text_input_layout");
    public By address_Location_Tree_lbl_By = By.id("com.daraz.android"+dev+":id/tv_address_location_tree_name");
    public By address_Location_Tree_lbl_By_MM = By.id("com.shop.android:id/tv_address_location_tree_name");
    public By buyer_Name_lbl_By = By.id("com.daraz.android"+dev+":id/tv_recipient");
    public By buyer_Name_lbl_By_MM = By.id("com.shop.android:id/tv_recipient");
    public By new_Address_btn_By = By.id("com.daraz.android"+dev+":id/btn_action");
    public By new_Address_btn_By_MM = By.id("com.shop.android:id/btn_action");
    public By delete_Confirm_btn_By = By.id("android:id/button1");
}