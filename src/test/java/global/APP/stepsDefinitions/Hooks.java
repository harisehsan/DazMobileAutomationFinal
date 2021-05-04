package global.APP.stepsDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import global.APP.starter.BaseRunner;
import global.Drivers;
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
            ((CanRecordScreen) drivers.getDriver()).startRecordingScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Allure.addAttachment("Executed on: ","Device Name: "+deviceName() +
                "\n"+"Device version: "+deviceVersion()+
                "\n"+"Device UDID: "+getUdid_Device()+
                "\n"+"Venture: "+System.getProperty("env"));
    }

    @After
    public void TearDownTest(Scenario scenario) throws IOException {
        String base64String = null;
        try {
            base64String = ((CanRecordScreen) drivers.getDriver()).stopRecordingScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (scenario.isFailed()) {
            try {
                byte[] screenshotByte = ((TakesScreenshot) drivers.getDriver()).getScreenshotAs(OutputType.BYTES);
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

    private String deviceName() throws IOException, InterruptedException {
        try {
            String commandString1;
            commandString1 = String.format("%s", "adb.exe -s " + getUdid_Device() + " shell getprop ro.product.model");
            Process process = Runtime.getRuntime().exec(commandString1);
            process.waitFor(3, TimeUnit.SECONDS);
            return getOutputFromCommand(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }

    private String deviceVersion() throws IOException, InterruptedException {
        try {
            String commandString1;
            commandString1 = String.format("%s", "adb.exe -s " + getUdid_Device() + " shell getprop ro.build.version.release");
            Process process = Runtime.getRuntime().exec(commandString1);
            process.waitFor(3, TimeUnit.SECONDS);
            return getOutputFromCommand(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }

