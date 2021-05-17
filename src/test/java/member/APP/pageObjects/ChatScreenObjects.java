package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChatScreenObjects extends BuildIDPicker {
    @AndroidFindBy(id= "tv_title") public List <WebElement> productTitle_ele;
    @AndroidFindBy(id= "tv_price") public List <WebElement> productPrice_ele;
    @AndroidFindBy(id= "tv_send") public WebElement sendBtn_ele;
    @AndroidFindBy(id= "tv_chatdesc") public WebElement unread_ele;
    @AndroidFindBy(id= "message_title") public WebElement storeName_ele;
    @AndroidFindBy(id= "btn_gotoshop") public WebElement storeIcon_ele;
    @AndroidFindBy(id= "msgcenter_panel_input_edit") public WebElement chatInputBox_ele;
    @AndroidFindBy(id= "msgcenter_panel_express_icon") public WebElement emoticons_ele;
    @AndroidFindBy(id= "msgcenter_panel_more_icon") public WebElement moreIcon_ele;
    @AndroidFindBy(id= "txt_quick_reply") public List <WebElement> quickReply_lst;
    @AndroidFindBy(id= "title_textview") public List <WebElement> channelIcons_lst;
    @AndroidFindBy(className= "androidx.appcompat.app.ActionBar$Tab")public List<WebElement> productScreenTab_lst;
    @AndroidFindBy(className= "android.widget.TextView")public List<WebElement> productScreenTabs_lst;
    @AndroidFindBy(className= "msg_products_item_selectable") public List<WebElement> msgProductsItemSelectable_lst;
    @AndroidFindBy(id= "msg_products_select") public List<WebElement> checkBox_lst;
    @AndroidFindBy(id= "btn_msg_commit_to_send") public WebElement msgCommitToSend_btn;
    @AndroidFindBy(id= "msg_products_item_description") public List<WebElement> getMsgItemTitle_lst;
    @AndroidFindBy(id= "tv_msg_content") public List<WebElement> tv_msg_content_lst;
    @AndroidFindBy(id= "text") public List<WebElement> storePage_Footer;
    @AndroidFindBy(xpath = "//*[contains(@id,'text') and contains(@text,'Chat Now')]") public WebElement chat_now_ele;


    public By productTitle_by = By.id("tv_title");
    public By sendBtn_by = By.id("tv_send");
    public By unread_by = By.id("tv_chatdesc");

    public By storeName_by = By.id("message_title");
    public By storeIcon_by = By.id("btn_gotoshop");
    public By chatInputBox_by = By.id("msgcenter_panel_input_edit");
    public By emoticons_by = By.id("msgcenter_panel_express_icon");
}
