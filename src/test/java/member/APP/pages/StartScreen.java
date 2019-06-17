package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.StartScreenPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StartScreen extends Base {

    StartScreenPageObjects startScreenPageObjects = new StartScreenPageObjects();

    public StartScreen(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), startScreenPageObjects);
    }

    public void envPicker(String env) {
       if(!(env.equalsIgnoreCase("mm.live")) && waitWithoutException(startScreenPageObjects.bd_Env_lbl)){
            switch (env) {
                case "bd.live": {
                    waitForElementToClickable(startScreenPageObjects.bd_Env_lbl);
                    startScreenPageObjects.bd_Env_lbl.click();
                    waitUntilPresentOfElementBy(startScreenPageObjects.eng_Language_btn_By);
                    startScreenPageObjects.eng_Language_btn.click();
                }
                break;
                case "lk.live": {
                    waitForElementToClickable(startScreenPageObjects.lk_Env_lbl);
                    startScreenPageObjects.lk_Env_lbl.click();
                    waitUntilPresentOfElementBy(startScreenPageObjects.eng_Language_btn_By);
                    startScreenPageObjects.eng_Language_btn.click();
                }
                break;
                case "np.live": {
                    waitForElementToClickable(startScreenPageObjects.np_Env_lbl);
                    startScreenPageObjects.np_Env_lbl.click();
                    waitUntilPresentOfElementBy(startScreenPageObjects.eng_Language_btn_By);
                    startScreenPageObjects.eng_Language_btn.click();
                }
                break;
                case "pk.live": {
                    waitForElementToClickable(startScreenPageObjects.pk_Env_lbl);
                    startScreenPageObjects.pk_Env_lbl.click();
                }
                break;
                default:
                    throw new RuntimeException("Venture not found!");
            }
        }
        if(!(env.equalsIgnoreCase("mm.live"))) {
           if (waitWithoutException(startScreenPageObjects.skip_Intro_btn))
           startScreenPageObjects.skip_Intro_btn.click();
        }
      else
        {
            if (waitWithoutException(startScreenPageObjects.skip_Intro_btn_MM))
                startScreenPageObjects.skip_Intro_btn_MM.click();
        }
       }

    }

