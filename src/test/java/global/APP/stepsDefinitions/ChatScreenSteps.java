package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import member.APP.pages.ChatScreen;

import java.io.IOException;

public class ChatScreenSteps {
    Drivers drivers = new Drivers();
    ChatScreen chatScreen = new ChatScreen(drivers.getDriver());

    @And("I verify product title and price on chat screen")
    public void iVerifyProductTitleAndPriceOnChatScreen() throws IOException {
        chatScreen.iVerifyProductPriceAndTitle();
    }

    @And("I click on Send Product button")
    public void iClickOnSendProductButton() {
        chatScreen.clickSendBtnOnChatScreen();
    }

    @And("I must see unread message on screen")
    public void iMustSeeUnreadMessageOnScreen() {
        chatScreen.mustSeeUnreadMsgOnScreen();
    }

    @And("I verify store name existence in header")
    public void iVerifyStoreNameExistenceInHeader() {
    chatScreen.verifyExistenceOfStoreName();
    }

    @And("I verify store icon existence in header")
    public void iVerifyStoreIconExistenceInHeader() {
    chatScreen.verifyExistenceOfStoreIcon();
    }

    @And("I click on store icon in header should be redirected to store page")
    public void iClickOnStoreIconInHeaderShouldBeRedirectedToStorePage() {
        chatScreen.clickStoreIconOnChatScreen();
    }

    @And("I should see text input box")
    public void iShouldSeeTextInputBox() {
        chatScreen.verifyExistenceOfInputBox();
    }

    @Then("I verify the existence of emoticon")
    public void iVerifyTheExistenceOfEmoticon() {
        chatScreen.verifyExistenceOfEmoticon();
    }

    @And("I verify the existence of quick reply button on chat screen")
    public void iVerifyTheExistenceOfQuickReplyButtonOnChatScreen() {
        chatScreen.verifyExistenceOfQuickReply();
    }

    @And("I verify the existence and click More Options on chat screen")
    public void iVerifyTheExistenceAndClickMoreOptionsOnChatScreen() {
        chatScreen.verifyExistenceOfMoreOptions();
    }

    @Then("I verify the existence Camera,Photos,Products,Orders channel icon under more option screen")
    public void iVerifyTheExistenceCameraPhotosProductsOrdersChannelIconUnderMoreOptionScreen() {
        chatScreen.verifyChannelIcon();
    }

    @And("I click on {string} icon under more option screen")
    public void iClickOnIconUnderMoreOptionScreen(String arg0) {
        chatScreen.iClickOnChannelIcon(arg0);
    }

    @And("I should be redirected to select products page")
    public void iShouldBeRedirectedToSelectProductsPage() {
        chatScreen.selectProductScreen();
    }

    @And("I should see {string} tabs on select products screen")
    public void iShouldSeeTabsOnSelectProductsScreen(String arg0) {
        chatScreen.selectProductScreenTabs(arg0);
    }

    @And("I select a {string} from wishlist and sent it to chat screen")
    public void iSelectAProductFromWishlistAndSentItToChatScreen(String arg0) {
        chatScreen.selectAProductOrOrderToSendToSeller(arg0);
    }

    @And("I verify Draft function using text Box")
    public void iVerifyDraftFunctionUsingTextBox() {
        MessageCenterSteps messageCenterSteps = new MessageCenterSteps();
        AccountSteps accountSteps = new AccountSteps();
        chatScreen.inputRandomTextinInputField();
        drivers.getDriver().navigate().back();
        drivers.getDriver().navigate().back();
        accountSteps.iShouldBeOnTheMessagePage();
        messageCenterSteps.iClickOnTabInMessageCenter("Chats");
        chatScreen.verifyDraftMsg();
    }

    @And("I click on {string} icon on Store Page")
    public void iClickOnIconOnStorePage(String arg0) {
        chatScreen.clickChatBtnOnStore(arg0);
    }
}
