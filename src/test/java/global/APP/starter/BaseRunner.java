package global.APP.starter;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import cucumber.api.java.an.E;
import cucumber.api.testng.TestNGCucumberRunner;
import global.APP.getProperty.ScreenshotGetProperty;
import global.Drivers;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.*;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
public class BaseRunner {

    private int dynamicPortID =3;

    public TestNGCucumberRunner testNGCucumberRunner;
    public Drivers drv = new Drivers();
    public String driver;
    String Time = LocalDateTime.now().toString().replaceAll("[^A-Za-z0-9]", "-");
    File targetFile = null;
    private ScreenshotGetProperty screenshotGetProperty = new ScreenshotGetProperty();
    private String directoryPath = "";

    public String getUdid_Device() throws IOException {
        udid_Device = screenshotGetProperty.getUdid();
        return udid_Device;
    }

    public String udid_Device;
    @BeforeSuite
    public void generateDynamicTestNGFile() throws IOException, InterruptedException {
        Element root=new Element("suite");
        Document doc=new Document();
        root.setAttribute("name","BDD Test Suite "+ dynamicPortID).setAttribute("verbose","1").setAttribute("parallel","tests").setAttribute("thread-count","1");
        Element child1 = new Element("test").setAttribute("name","Device"+ dynamicPortID);
        child1.addContent(new Element("parameter").setAttribute("name","platformName").setAttribute("value","Android"));
        child1.addContent(new Element("parameter").setAttribute("name","deviceName").setAttribute("value",deviceName()));
        child1.addContent(new Element("parameter").setAttribute("name","platformVersion").setAttribute("value",deviceVersion()));
        child1.addContent(new Element("parameter").setAttribute("name","udid").setAttribute("value",deviceUdid().replaceAll("&#x9;","")));
        child1.addContent(new Element("parameter").setAttribute("name","port").setAttribute("value","472"+ dynamicPortID));
        child1.addContent(new Element("parameter").setAttribute("name","systemPort").setAttribute("value","822"+dynamicPortID));
        try {
            child1.addContent(new Element("parameter").setAttribute("name","env").setAttribute("value",System.getProperty("env")));
        } catch (Exception e) {
            System.out.println(e);
        }
        child1.addContent(new Element("classes").addContent(new Element("class").setAttribute("name","global.APP.starter.Runner")));
        dynamicPortID++;
        root.addContent(child1);
        doc.setRootElement(root);
        XMLOutputter outter=new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        outter.output(doc, new FileWriter(new File("dynamicTestNG.xml")));
    }
    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName", "deviceName", "platformVersion", "udid", "port", "systemPort", "env"})
    public void setUpClass(String platformName, String deviceName, String platformVersion, String udid, String port, String systemPort, String env) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

        System.out.println(env + "\n\n\n");
        System.out.println(Thread.currentThread().getId());
//        try {
//            if (!System.getProperty("udid").equalsIgnoreCase(""))
//                udid = System.getProperty("udid");
//            if (!System.getProperty("os").equalsIgnoreCase(""))
//                platformVersion = System.getProperty("os");
//            if (!System.getProperty("port").equalsIgnoreCase(""))
//                port = System.getProperty("port");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("One or more system parameter is missing!");
//        }
        //screenshotGetProperty.setUdid(udid);
        drv.darazAndroidLaunchApp(port, platformName, platformVersion, deviceName, udid, systemPort, env);
        ThreadStorage.put("env", env);
        WebDriverRunner.setWebDriver(drv.getDriver());
        screenshotGetProperty.setScreenShotCount("0"); //This will set Screenshot Count to Zero before each New invocation of driver.
        createADirectory("Screenshots");
        System.out.println(ThreadStorage.get("env") + "\n\n\n\n");
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
        File theDir = new File("./" + dirName + "/" + ThreadStorage.get("env").replaceFirst("\\.", "-") + "-" + Time);
        if (!theDir.exists()) theDir.mkdirs();
        return directoryPath = theDir.getCanonicalPath();
    }

    private String createADirectoryJenkins(String dirName) throws IOException {
        File theDir = new File("./" + dirName + "/" + ThreadStorage.get("env").replaceFirst("\\.", "-"));
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
        File dest = new File(directoryPath + "/" + "Rerun-" + ThreadStorage.get("env").substring(0, 2) + ".txt");
        try {
            Files.copy(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest(alwaysRun = true)
    public void getRerunFileJenkins() throws IOException {
        directoryPath = "/JenkinsFailedScenarios";
        createADirectoryJenkins("JenkinsFailedScenarios");
        File source = new File("target/cucumber-reports/rerun-reports/rerun.txt");
        File dest = new File( directoryPath + "/" + "Rerun.txt");
        try {
            Files.copy(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String getOutputFromCommand(Process process) throws IOException {
        String output2 = "";
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            output2 = output2.concat(line);
        }
        return output2;
    }

    public String deviceName() throws IOException, InterruptedException {
        try {
            String commandString1;
            commandString1 = String.format("%s", "adb.exe -s " + deviceUdid() + " shell getprop ro.product.model");
            Process process = Runtime.getRuntime().exec(commandString1);
            process.waitFor(3, TimeUnit.SECONDS);
            return getOutputFromCommand(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public String deviceVersion() throws IOException, InterruptedException {
        try {
            String commandString1;
            commandString1 = String.format("%s", "adb.exe -s " + deviceUdid() + " shell getprop ro.build.version.release");
            Process process = Runtime.getRuntime().exec(commandString1);
            process.waitFor(3, TimeUnit.SECONDS);
            return getOutputFromCommand(process);
        } catch (Exception e) {
                        e.printStackTrace();
        }
                return null;
            }

      public String deviceUdid() throws IOException, InterruptedException {
        try {
            String commandString1;
            commandString1 = String.format("%s", "adb devices");
            Process process = Runtime.getRuntime().exec(commandString1);
            process.waitFor(3, TimeUnit.SECONDS);
            String udid = getOutputFromCommand(process);
            udid = udid.replace("List of devices attached","").replace("device","").replaceAll("&#x9;","");
            return udid;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}