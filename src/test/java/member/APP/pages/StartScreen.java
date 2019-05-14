package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.StartScreenPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StartScreen extends Base {

    StartScreenPageObjects envPickerPageObjects = new StartScreenPageObjects();

    public StartScreen(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), envPickerPageObjects);
    }

    public void envPicker(String env) throws InterruptedException {
        System.out.println("This is the passing venture: " + env);

        if (env.isEmpty()) env = "pk.live";
        switch (env) {
            case "bd.live": {
                waitForElementToClickable(envPickerPageObjects.bd_Env_lbl);
                envPickerPageObjects.bd_Env_lbl.click();
                waitForElementToClickable(envPickerPageObjects.eng_Language_btn);
                envPickerPageObjects.eng_Language_btn.click();
            }
            break;
            case "lk.live": {
                waitForElementToClickable(envPickerPageObjects.lk_Env_lbl);
                envPickerPageObjects.lk_Env_lbl.click();
            }
                break;
             case "np.live": {
                 waitForElementToClickable(envPickerPageObjects.np_Env_lbl);
                 envPickerPageObjects.np_Env_lbl.click();
             }
                 break;
             case "pk.live": {
                 waitForElementToClickable(envPickerPageObjects.pk_Env_lbl);
                 envPickerPageObjects.pk_Env_lbl.click();
             }
             break;
            default:
                throw new RuntimeException("Venture not found!");
//            }
        }
    }
}
