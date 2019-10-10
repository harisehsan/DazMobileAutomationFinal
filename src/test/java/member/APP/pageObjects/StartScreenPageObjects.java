package member.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StartScreenPageObjects {
    @AndroidFindBy(xpath = "//*[@text='Bangladesh']") public WebElement bd_Env_lbl;
    @AndroidFindBy (xpath = "//*[@text='Pakistan']") public WebElement pk_Env_lbl;
    @AndroidFindBy (xpath = "//*[@text='Nepal']") public WebElement np_Env_lbl;
    @AndroidFindBy (xpath = "//*[@text='Sri Lanka']") public WebElement lk_Env_lbl;
    @AndroidFindBy (id = "android:id/button1") public List<WebElement> eng_Language_btn;
    @AndroidFindBy (id = "com.daraz.android:id/intro_skip_btn") public WebElement skip_Intro_btn;
    @AndroidFindBy (id = "com.daraz.android:id/traffic_hover_text") public WebElement shake_lbl;

    @AndroidFindBy (id = "com.shop.android:id/intro_skip_btn") public WebElement skip_Intro_btn_MM;
    @AndroidFindBy (id = "com.shop.android:id/traffic_hover_text") public WebElement shake_lbl_MM;

    public By envName_lbl_By = By.id("com.daraz.android:id/country_name");
    public By eng_Language_btn_By = By.id("android:id/button1");

}
