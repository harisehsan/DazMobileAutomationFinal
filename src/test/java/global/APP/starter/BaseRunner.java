package global.APP.starter;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import cucumber.api.testng.TestNGCucumberRunner;
import global.APP.getProperty.ScreenshotGetProperty;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class BaseRunner {

    public TestNGCucumberRunner testNGCucumberRunner;
    public Drivers drv = new Drivers();
    public String driver;
    String Time = LocalDateTime.now().toString().replaceAll("[^A-Za-z0-9]", "-");
    File targetFile = null;
    private ScreenshotGetProperty screenshotGetProperty = new ScreenshotGetProperty();
    private String directoryPath = "";

    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName", "deviceName", "platformVersion", "udid", "port", "systemPort"})
    public void setUpClass(String platformName, String deviceName, String platformVersion, String udid, String port, String systemPort) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        System.out.println(Thread.currentThread().getId());
        drv.darazAndroidLaunchApp(port, platformName, platformVersion, deviceName, udid, systemPort);
        WebDriverRunner.setWebDriver(drv.getDriver());
        screenshotGetProperty.setScreenShotCount("0"); //This will set Screenshot Count to Zero before each New invocation of driver.
        createADirectory("Screenshots");
    }

    @Attachment
    @AfterMethod(alwaysRun = true)
    public void mobileScreenShot(ITestResult result) throws IOException {

        int i= screenshotGetProperty.getScreenshotCount();
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                Toolkit.getDefaultToolkit().beep();
                File srcFile = ((TakesScreenshot) drv.getDriver()).getScreenshotAs(OutputType.FILE);
                String filename = UUID.randomUUID().toString();
                targetFile = new File(directoryPath + "/" + result.getMethod().getMethodName() + i + ".png");
                ++i;
                screenshotGetProperty.setScreenShotCount(Integer.toString(i));
                Files.copy(srcFile,targetFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // This method will create a directory Named "ScreenShots",
    // on each execution inside screenshots will create a directory named "current date and time" and will add new screenshots.
    public String createADirectory(String dirName) throws IOException {
        File theDir = new File("./" + dirName + "/" + System.getProperty("env").replaceFirst("\\.", "-") + "-" + Time);
        if (!theDir.exists()) theDir.mkdirs();
        return directoryPath = theDir.getCanonicalPath();
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

    @AfterTest(alwaysRun = true)
    public void getRerunFile() throws IOException {
        createADirectory("FailedScenarios");
        File source = new File("target/cucumber-reports/rerun-reports/rerun.txt");
        File dest = new File(directoryPath + "/" + "Rerun-" + System.getProperty("env").substring(0, 2) + ".txt");
        try {
            Files.copy(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}