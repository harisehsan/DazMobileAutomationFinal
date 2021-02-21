package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Drivers;
import member.APP.pages.MessageCenter;
import org.testng.Assert;


public class MessageCenterSteps {
    Drivers drivers = new Drivers();
    MessageCenter messageCenter = new MessageCenter(drivers.getDriver());

    @And("I find unread message count in footer")
    public void iFindUnreadMessageCountInFooter() {
           Assert.assertTrue(messageCenter.getMessageCountInFooter(),"No Message count in the footer!");
    }

    @And("I find unread message count in message center")
    public void iFindUnreadMessageCountInMessageCenter() {
        Assert.assertTrue(messageCenter.getMsgCountInMsgCenter(),"No Message count in the Message Center!");
    }

    @When("I click on Mark all as read button")
    public void iClickOnMarkAllAsReadButton() {
        messageCenter.clickMarkAllAsRead();
    }

    @And("I assert all unread message count should disappear from message center")
    public void iAssertAllUnreadMessageCountShouldDisappearFromMessageCenter() {
        Assert.assertTrue( messageCenter.getMsgCountInMsgCenterDisappear(), "Message Count still visible in message Center");
    }

    @And("I Read first notification in message center")
    public void iReadFirstNotificationInMessageCenter() {
        messageCenter.readFirstNotification();
    }

    @Then("I delete the first notification")
    public void iDeleteTheFirstNotification() {
        messageCenter.deleteNotification();
    }

    @And("I navigate back by clicking {string} button")
    public void iNavigateBackByClickingBackButton(String arg0) {
        messageCenter.iClickOnBackAeroImg(arg0);
    }

    @And("I click on {string} tab in message center")
    public void iClickOnTabInMessageCenter(String arg0) {
        messageCenter.clickOnTabsMsgCenter(arg0);
    }

    @And("I click on top first {string} in the list")
    public void iClickOnTopFirstOrderInTheList(String arg0) {
        messageCenter.readFirstNotification();
    }
}
