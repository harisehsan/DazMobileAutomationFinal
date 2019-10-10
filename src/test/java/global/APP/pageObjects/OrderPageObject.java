package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 10-July-2019
 */

public class OrderPageObject {
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='CANCEL ']"),@AndroidBy(xpath = "//*[@content-desc='CANCEL ']")}) public WebElement order_Cancel_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Select']"),@AndroidBy(xpath = "//*[@content-desc='Select']")}) public WebElement select_Reason_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Confirm']"),@AndroidBy(xpath = "//*[@content-desc='Confirm']")}) public List <WebElement> reason_Confirm_btn;
    @AndroidFindBy (xpath = "//*[@class='android.widget.EditText']") public List <WebElement> cancel_Comment_txt;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Submit']"),@AndroidBy(xpath = "//*[@content-desc='Submit']")}) public WebElement cancel_Submit_btn;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='Cancelled >']"),@AndroidBy(xpath = "//*[@content-desc='Cancelled >']")}) public List <WebElement> cancelled_lbl;

    public By order_Cancel_btn_by = By.xpath("//*[@content-desc='CANCEL '] | //*[@contentDescription='CANCEL ']");
    public By select_Reason_btn_by = By.xpath("//*[@contentDescription='Select'] | //*[@content-desc='Select']");
    public By cancelled_lbl_by = By.xpath("//*[@contentDescription='Cancelled >'] | //*[@content-desc='Cancelled >']");
}