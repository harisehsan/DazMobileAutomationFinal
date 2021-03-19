package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MessageCenterObjects extends BuildIDPicker {
    @AndroidFindBy(xpath = "//*[@resource-id='com.daraz.android:id/shop_name']")
    public List<WebElement> shop_Name_lbl;

    @AndroidFindBy(id = "quantity")
    public List<WebElement> footer_Quantity_list;
    @AndroidFindBy (id= "com.shop.android"+dev+":id/quantity") public List <WebElement> footer_Quantity_list_MM;
    @AndroidFindBy (id= "tv_msg_unread_num") public List <WebElement> msgCenter_count_lst;
    @AndroidFindBy (id= "tv_msg_unread_num") public List <WebElement> msgCenter_count_lst_MM;
    @AndroidFindBy(id = "tv_clear_unread")
    public WebElement markAllRead_btn;
    @AndroidFindBy (id= "com.shop.android"+dev+":id/tv_clear_unread") public WebElement markAllRead_btn_MM;
    @AndroidFindBy (id= "tv_msg_title") public List <WebElement> msgCenterNotificationTitle;
    @AndroidFindBy (id= "tv_msg_time") public List <WebElement> msgCenterNotificationTime;
    @AndroidFindBy (id= "tv_delete") public List <WebElement> msgCenterNotificationT;
    @AndroidFindBy (id= "tv_ok") public List <WebElement> GotIt_IM_btn;
    @AndroidFindBy (id= "tiv_back") public WebElement iM_backBtn;
    @AndroidFindBy (className= "android.widget.ImageButton") public List <WebElement> WeexBack_btn;
    @AndroidFindBy(id="got_it_btn") public List <WebElement> got_It_Store_btn;
    @AndroidFindBy(id="tv_tab_title") public List <WebElement> msgCenter_tabs;
    @AndroidFindBy (id= "tv_msg_content") public List <WebElement> msgCenterListContent;



    public By store_Name_lbl_by = By.xpath("//*[@resource-id='com.daraz.android:id/shop_name']");
    public By footer_Quantity_list_By = By.id ("com.daraz.android"+dev+":id/quantity") ;
    public By msgCenterNotificationTitle_By = By.id ("tv_msg_title") ;
    public By msgCenterNotificationTime_By = By.id("tv_msg_title");


}
