package global.APP.starter;

import com.google.common.io.Files;
import cucumber.api.testng.TestNGCucumberRunner;
import global.APP.getProperty.ScreenshotGetProperty;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import junit.framework.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestRunner;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class BaseRunner {

    public TestNGCucumberRunner testNGCucumberRunner;
    public Drivers drv = new Drivers();
    public String driver;
    ScreenshotGetProperty screenshotGetProperty = new ScreenshotGetProperty();


    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName", "deviceName", "platformVersion", "udid", "port", "systemPort"})
    //public void testLoginAndLogout(String platformName, String deviceName, String platformVersion, String udid, String port, String systemPort) throws Exception {
    public void setUpClass(String platformName, String deviceName, String platformVersion, String udid, String port, String systemPort) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        drv.darazAndroidLaunchApp(port, platformName, platformVersion, deviceName, udid, systemPort);
    }


    @Attachment
    @AfterMethod(alwaysRun = true)
    public void mobileScreenShot(ITestResult result) throws IOException {
        int i= screenshotGetProperty.getScreenshotCount();
        System.out.println(result.getMethod().getMethodName());
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                File srcFile = ((TakesScreenshot) drv.getDriver()).getScreenshotAs(OutputType.FILE);
                String filename = UUID.randomUUID().toString();
                File targetFile=new File(result.getMethod().getMethodName()+i+".jpg");
                ++i;
                screenshotGetProperty.setScreenShotCount(Integer.toString(i));
                Files.copy(srcFile,targetFile);
                System.out.println(srcFile.getAbsolutePath());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public byte[] saveFailScreenShot(AppiumDriver adriver){
        return ((TakesScreenshot)adriver).getScreenshotAs(OutputType.BYTES);

    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();

    }

    @AfterTest(alwaysRun = true)
    public void teardownBrowser() throws Exception {
        drv.closeDriver();
    }
}