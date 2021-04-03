package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
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

    @And("I skip the shake shake popup")
    public void iSkipTheShakeShakePopup() {
        envPicker.skipShakeShake(System.getProperty("env"));
    }

    @Given("I select the {string} venture")
    public void iSelectTheVenture(String arg0) {
        System.setProperty("env", arg0);
        envPicker.envPicker(System.getProperty("env"));
    }

    @Given("^I select the \"([^\"]*)\"$")
    public void iSelectTheVentures(String arg0) {
        System.setProperty("env", arg0);
        envPicker.envPicker(System.getProperty("env"));
    }
}


