package global.APP.stepsDefinitions;

import cucumber.api.java.en.Given;
import global.Drivers;
import member.APP.pages.StartScreen;

public class StartScreenSteps {
    Drivers driver = new Drivers();
    StartScreen envPicker = new StartScreen(driver.getDriver());
    @Given("I select the venture")
    public void iSelectTheVenture() throws InterruptedException {
        envPicker.envPicker(System.getProperty("env"));
    }
    }

