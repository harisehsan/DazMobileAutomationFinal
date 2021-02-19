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
}