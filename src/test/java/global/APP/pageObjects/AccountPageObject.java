package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPageObject {

    @AndroidFindBy(id = "com.daraz.android:id/img_up") public List <WebElement> my_Account_widget;
    @AndroidFindBy(id = "com.shop.android:id/img_up") public List <WebElement> my_Account_widget_MM;
    @AndroidFindAll({@AndroidBy(xpath = "//*[@contentDescription='More options']"),@AndroidBy(xpath = "//*[@content-desc='More options']")}) public WebElement more_Options_click;

    public By my_Account_widget_By = By.id("com.daraz.android:id/img_up");
    public By my_Account_widget_By_MM = By.id("com.shop.android:id/img_up");



}
