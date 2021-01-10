package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VoucherPageObject {
    @AndroidFindBy (id = "com.daraz.android:id/edit_laz_trade_voucher_input") public List <WebElement> voucher_Input_txtBox;
    @AndroidFindBy (id = "com.daraz.android:id/btn_laz_trade_voucher_input_apply") public WebElement voucher_Apply_btn;
    @AndroidFindBy (xpath = "//*[@resource-id='com.daraz.android:id/tv_laz_trade_voucher_applied_tip' and contains(@text,'Voucher codes are not stackable')]") public List <WebElement> voucher_Success_lbl;
    @AndroidFindBy (id = "com.daraz.android:id/tv_laz_trade_order_total_amount") public WebElement total_Price_Checkout_lbl;

    @AndroidFindBy (id = "com.shop.android:id/edit_laz_trade_voucher_input") public List <WebElement> voucher_Input_txtBox_MM;
    @AndroidFindBy (id = "com.shop.android:id/btn_laz_trade_voucher_input_apply") public WebElement voucher_Apply_btn_MM;
    @AndroidFindBy (xpath = "//*[@resource-id='com.shop.android:id/tv_laz_trade_voucher_applied_tip' and contains(@text,'Voucher codes are not stackable')]") public List <WebElement> voucher_Success_lbl_MM;
    @AndroidFindBy (id = "com.shop.android:id/tv_laz_trade_order_total_amount") public WebElement total_Price_Checkout_lbl_MM;


}
