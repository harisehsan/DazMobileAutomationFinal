package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopUpObjects extends BuildIDPicker {

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement inputFiledTopUp;

    @AndroidFindAll({
            @AndroidBy(accessibility = "Top Up Now"),
            @AndroidBy(xpath = "//*[contains(@text, 'Top Up Now') or  contains(@content-desc, 'Top Up Now')]")})
    public WebElement topUpBtn;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Place Order') or contains(@text, 'Proceed to Pay')]")
    public WebElement mSiteProceedToPayBtn;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Please enter') or contains(@text, 'Please enter')]")
    public WebElement phoneValidation;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Network error') or contains(@text, 'Network error')]")
    public List<WebElement> netWorkError;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Telenor') or contains(@text, 'Telenor')]")
    public WebElement telenorOperator;

    @AndroidFindBy(xpath = "//*[contains(@text,'TB1GrJo11H2gK0jSZJnwu1T1FXa')]")
    public WebElement reload_ele;

    @AndroidFindBy(xpath = "//*[contains(@text,'OSS_a7B7vTrn_52e75')]")
    public WebElement reloadNP_ele;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Please select operator') or contains(@content-desc, 'Please select operator')]")
    public List<WebElement> selectOpratorlst;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView'][1]")
    public WebElement avatar_ele;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Ks 1,000'])")
    public List<WebElement> mmTelenorBalance_ele;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView'][1]")
    public List<WebElement> imagesOnSearchPage_lst;

    public By phoneValidation_by = By.xpath("//*[contains(@content-desc, 'Please enter') or contains(@text, 'Please enter')]");
    public By checkout_btn_by = By.xpath("//*[@class='android.view.View' and ./*[contains(@text, 'Proceed to Pay')]]");
    public By findBalanceTxt_by = By.xpath("//*[contains(@content-desc, 'Balance') or contains(@content-desc, 'Top Up Now')]");
    public By selectOprator_by = By.xpath("//*[contains(@content-desc, 'Please select operator') or contains(@content-desc, 'Please select operator')]");
    public By campaignPageTitle_by = By.xpath("//*[contains(@text,'Reloads & Pay Bills | Daraz.lk')]");
    public By topUpBanner_by = By.xpath("//*[contains(@text,'How to Top Up?')]");
    public By netWorkError_by = By.xpath("//*[contains(@content-desc, 'Network error') or contains(@text, 'Network error')]");
    public By reloadNP_by = By.xpath("//*[contains(@text,'OSS_a7B7vTrn_52e75')]");
    public By phoneInput_by = By.xpath("//*[@class='android.widget.EditText']");
}