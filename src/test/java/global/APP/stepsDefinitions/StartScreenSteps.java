package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Drivers;
import io.appium.java_client.AppiumDriver;
import member.APP.pages.StartScreen;
import org.openqa.selenium.WebElement;

public class StartScreenSteps {
    StartScreen envPicker = new StartScreen((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    public StartScreenSteps() {

        System.out.println("Step: " + Thread.currentThread().getId());
        System.out.println("driver: " + (AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());
    }

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


