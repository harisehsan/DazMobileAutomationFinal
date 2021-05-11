package global.APP.stepsDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.APP.pages.BannerAndChannel;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BannerAndChannelSteps {

    BannerAndChannel bannerAndChannel = new BannerAndChannel((AppiumDriver<WebElement>) WebDriverRunner.getWebDriver());

    @Then("I check the existence of banner on homepage")
    public void iCheckTheExistenceOfTheBannerOnHomepage() {
        Assert.assertTrue(bannerAndChannel.checkTheExistenceofBanner(),"Banner slider is not existed on Homepage or not shown properly!");
    }



    @Then("I check the existence of channel on homepage")
    public void iCheckTheExistenceOfChannelOnHomepage() {
        Assert.assertTrue(bannerAndChannel.checkTheExistenceOfChannel(),"Either Channel is not existed on Homepage or not showing properly!");
    }

    @And("I navigate to channel and I check for the title of channel")
    public void iNavigateToChannelAndICheckForTheTitleOfChannel() {
       Assert.assertTrue(bannerAndChannel.checkTheChannelPageTitle(),"Chanel Page(s) are not working properly!");
    }

    @And("I select {string} channel on Home screen")
    public void iSelectChannelOnHomeScreen(String arg0) {
        bannerAndChannel.iClickChannelIconOnHome(arg0);
    }
}
