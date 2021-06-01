package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import global.APP.starter.BaseRunner;
import global.Drivers;
import global.ThreadStorage;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.qameta.allure.Allure;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.util.concurrent.TimeUnit;


public class Hooks extends BaseRunner {

    public Drivers drivers = new Drivers();

    @Before
    public void InitializeTest() throws Exception {
        try {
            ((CanRecordScreen) WebDriverRunner.getWebDriver()).startRecordingScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Allure.addAttachment("Executed on: ","Device Name: "+deviceName() +
                "\n"+"Device version: "+deviceVersion()+
                "\n"+"Device UDID: "+deviceUdid()+
                "\n"+"Venture: "+ ThreadStorage.get("env"));
    }

    @After
    public void TearDownTest(Scenario scenario) throws IOException {
        System.out.println("Current Thread for teardown :" + Thread.currentThread().getId() + "\n\n\n");
        String base64String = null;
        try {
            base64String = ((CanRecordScreen) WebDriverRunner.getWebDriver()).stopRecordingScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (scenario.isFailed()) {
            try {
                byte[] screenshotByte = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failure screenshot",new ByteArrayInputStream(screenshotByte));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                byte[] videoData = Base64.decodeBase64(base64String);
                Allure.addAttachment("Failure video",new ByteArrayInputStream(videoData));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

    }

