package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 10-July-2019
 */

public class OrderPageObject {
    @AndroidFindBy (xpath = "//*[@content-desc='CANCEL ']") public WebElement order_Cancel_btn;
    @AndroidFindBy (xpath = "//*[@contentDescription='Select']") public WebElement select_Reason_btn;
    @AndroidFindBy (xpath = "//*[@contentDescription='Confirm']") public WebElement reason_Confirm_btn;
    @AndroidFindBy (xpath = "//*[@class='android.widget.EditText']") public List <WebElement> cancel_Comment_txt;
    @AndroidFindBy (xpath = "//*[@contentDescription='Submit']") public WebElement cancel_Submit_btn;
    @AndroidFindBy (xpath = "//*[@contentDescription='Cancelled >']") public List<WebElement> cancelled_lbl;

    public By order_Cancel_btn_by = By.xpath("//*[@content-desc='CANCEL ']");
    public By select_Reason_btn_by = By.xpath("//*[@contentDescription='Select']");
    public By cancelled_lbl_by = By.xpath("//*[@contentDescription='Cancelled >']");
}