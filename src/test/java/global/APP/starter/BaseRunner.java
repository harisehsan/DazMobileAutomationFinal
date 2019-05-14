package global.APP.starter;

import cucumber.api.testng.TestNGCucumberRunner;
import global.Drivers;
import org.testng.annotations.*;

public class BaseRunner{

    public TestNGCucumberRunner testNGCucumberRunner;
    public Drivers drv = new Drivers();
    public String driver;


    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName","deviceName","platformVersion","udid","port","systemPort"})
    //public void testLoginAndLogout(String platformName, String deviceName, String platformVersion, String udid, String port, String systemPort) throws Exception {
    public void setUpClass(String platformName, String deviceName, String platformVersion, String udid, String port, String systemPort) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
         drv.androidLaunchApp(port, platformName, platformVersion, deviceName, udid, systemPort);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();

    }

    @AfterTest(alwaysRun = true)
    public void teardownBrowser() throws Exception {
        //driver.quit();
    }
}
