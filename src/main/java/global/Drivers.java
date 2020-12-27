package global;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Drivers extends BuildIDPicker{

    public static AppiumDriver<WebElement> driver;
    public DesiredCapabilities cap;


    public void darazAndroidLaunchApp(String port, String platform, String platformVersion, String deviceName, String udid, String systemPort) throws Exception {
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator");
        if(System.getProperty("env").equalsIgnoreCase("mm.live"))
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.shop.android");
        else
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.daraz.android"+dev);
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.lazada.activities.EnterActivity");
        cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.19.1");
        cap.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES,false);
        cap.setCapability(MobileCapabilityType.NO_RESET,false);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), cap);
        driver.setLogLevel(Level.INFO);
        WebDriverRunner.setWebDriver(driver);
        Assert.assertNotNull(driver);
    //    driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:" + port + "/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setDriver(driver);
//         envPicker.envPicker(System.getProperty("env"));

    }

        public AppiumDriver<WebElement> getDriver ()
        {

            return this.driver;
        }

    public void setDriver ( AppiumDriver<WebElement> driver)
    {

        this.driver = driver;
    }

        public void closeDriver () {
            driver.closeApp();
            driver.quit();
        }
    }


/*
adb -s UEEDU18526003357 uninstall io.appium.uiautomator2.server
adb -s UEEDU18526003357 uninstall io.appium.uiautomator2.server.test
adb -s UEEDU18526003357 uninstall io.appium.unlock
adb -s UEEDU18526003357 uninstall io.appium.settings
 */

/*
os.popen("adb uninstall io.appium.uiautomator2.server.test")
os.popen("adb uninstall io.appium.uiautomator2.server")
os.popen("adb install -r "+PATH("../app/appium-uiautomator2-server-v0.1.9.apk"))
os.popen("adb install -r "+PATH("../app/appium-uiautomator2-server-debug.androidTest.apk"))
 */



/*
adb -s P6LDU17113003345 uninstall io.appium.uiautomator2.server
adb -s P6LDU17113003345 uninstall io.appium.uiautomator2.server.test
adb -s P6LDU17113003345 uninstall io.appium.unlock
adb -s P6LDU17113003345 uninstall io.appium.settings
 */





