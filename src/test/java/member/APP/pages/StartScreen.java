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
        driver.resetApp();
        if (!(env.equalsIgnoreCase("mm.live")) && waitWithoutException(startScreenPageObjects.bd_Env_lbl)) {
            switch (env) {
                case "bd.live": {
                    waitForElementToClickable(startScreenPageObjects.bd_Env_lbl, 20);
                    startScreenPageObjects.bd_Env_lbl.click();
                    waitUntilPresentOfElementBy(startScreenPageObjects.eng_Language_btn_By);
                    startScreenPageObjects.eng_Language_btn.get(0).click();
                }
                break;
                case "lk.live": {
                    waitForElementToClickable(startScreenPageObjects.lk_Env_lbl, 20);
                    startScreenPageObjects.lk_Env_lbl.click();
                    waitUntilPresentOfElementBy(startScreenPageObjects.eng_Language_btn_By);
                    startScreenPageObjects.eng_Language_btn.get(0).click();
                }
                break;
                case "np.live": {
                    waitForElementToClickable(startScreenPageObjects.np_Env_lbl, 20);
                    startScreenPageObjects.np_Env_lbl.click();
                    waitUntilPresentOfElementBy(startScreenPageObjects.eng_Language_btn_By);
                    startScreenPageObjects.eng_Language_btn.get(0).click();
                }
                break;
                case "pk.live": {
                    waitForElementToClickable(startScreenPageObjects.pk_Env_lbl, 20);
                    startScreenPageObjects.pk_Env_lbl.click();
                }
                break;
                default:
                    throw new RuntimeException("Venture not found!");
            }
        }
        if (!(env.equalsIgnoreCase("mm.live"))) {
            if (waitWithoutException(startScreenPageObjects.skip_Intro_btn))
                startScreenPageObjects.skip_Intro_btn.click();
        } else {
            if (waitWithoutException(startScreenPageObjects.skip_Intro_btn_MM))
                startScreenPageObjects.skip_Intro_btn_MM.click();
        }
    }

    public void skipShakeShake(String env) {
        try {
            if (!(env.equalsIgnoreCase("mm.live"))) {
                if (waitWithoutExceptionForElements(startScreenPageObjects.shake_lbl)) {
                    if (isExist(startScreenPageObjects.shake_Shake_Close_btn))
                        startScreenPageObjects.shake_Shake_Close_btn.get(0).click();
                    else if (isExist(startScreenPageObjects.shake_lbl))
                        startScreenPageObjects.shake_lbl.get(0).click();
                }
            } else {
                if (waitWithoutExceptionForElements(startScreenPageObjects.shake_lbl_MM)) {
                    if (isExist(startScreenPageObjects.shake_Shake_Close_btn_MM))
                        startScreenPageObjects.shake_Shake_Close_btn_MM.get(0).click();
                    else if (isExist(startScreenPageObjects.shake_lbl_MM))
                        startScreenPageObjects.shake_lbl_MM.get(0).click();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
