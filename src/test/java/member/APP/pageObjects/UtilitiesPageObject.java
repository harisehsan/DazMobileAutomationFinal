package member.APP.pageObjects;

import global.BuildIDPicker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UtilitiesPageObject extends BuildIDPicker {

    @FindBy(xpath = "//*[@text='Electricity']") public List <WebElement> electricity_lst_element;
    @FindBy(xpath = "//*[@text='Gas']") public List <WebElement> gas_lst_element;
    @FindBy(xpath = "//*[@text='Water']") public List <WebElement> water_lst_element;
    @FindBy(xpath = "//*[@text='Telephone & Internet']") public List <WebElement> internet_lst_element;
    @FindBy(xpath = "//*[@class='android.widget.EditText']") public WebElement account_Number_txtbox;
    @AndroidFindBy(xpath = "//*[@text='Check the bill']") public List <WebElement> checkTheBillBtn;
    @AndroidFindBy(xpath = "//*[@text='TB1GrJo11H2gK0jSZJnwu1T1FXa.png#width=168&height=150_170x170q75.jpg_']") public WebElement reload_lk;
    @AndroidFindBy(xpath = "//*[@text='TB1YDte14z1gK0jSZSgwu1vwpXa.png#width=168&height=150_170x170q75.jpg_']") public WebElement CEB_lk;
    @AndroidFindBy (xpath = "//*[@text='TB1loJq1.Y1gK0jSZFMwu1WcVXa.png#width=168&height=150_170x170q75.jpg_']") public WebElement Leco_lk;
    @AndroidFindBy (xpath = "//*[@text='TB1jlFw14v1gK0jSZFFwu20sXXa.png#width=168&height=150_170x170q75.jpg_']") public WebElement water_board_lk;
    @AndroidFindBy (xpath = "(//*[@id='root_57947']/*[./*[@class='android.widget.EditText']])[1]") public WebElement account_Number_lk;
    @AndroidFindBy (xpath = "(//*[@id='root_57947']/*/*[@class='android.widget.EditText'])[2]") public WebElement amount_lk;
}