package member.APP.pages;

import com.sun.javafx.scene.traversal.Direction;
import global.APP.getProperty.ProductInfoGetProperty;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.ChatScreenObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class ChatScreen extends Base {
    ChatScreenObjects chatScreenObjects = new ChatScreenObjects();
    ProductInfoGetProperty productInfoGetProperty = new ProductInfoGetProperty();
    public static String uuid = UUID.randomUUID().toString();
    public ChatScreen(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), chatScreenObjects);
    }

    public void iVerifyProductPriceAndTitle() throws IOException {
        waitForElementByWithoutExceptionUntillTimeReach(chatScreenObjects.productTitle_by, 5);
        waitForElementsToAppear(chatScreenObjects.productTitle_ele);
        Assert.assertTrue(chatScreenObjects.productTitle_ele.get(0).getText().contains(productInfoGetProperty.getProductTitle()), "Product Title Is not displayed on Chat Screen");
        Assert.assertTrue(chatScreenObjects.productPrice_ele.get(0).getText().contains(productInfoGetProperty.getProductPrice()), "Product Price Is not displayed on Chat Screen");
    }

    public void clickSendBtnOnChatScreen() {
        waitForElementByWithoutExceptionUntillTimeReach(chatScreenObjects.sendBtn_by, 3);
        chatScreenObjects.sendBtn_ele.click();
    }

    public void mustSeeUnreadMsgOnScreen() {
        waitForElementByWithoutExceptionUntillTimeReach(chatScreenObjects.unread_by, 3);
        Assert.assertTrue(chatScreenObjects.unread_ele.getText().equalsIgnoreCase("Unread"), "Msg should be sent to seller and must show on the chat screen");
    }

    public void verifyExistenceOfStoreName() {
        waitForElementByWithoutExceptionUntillTimeReach(chatScreenObjects.storeName_by, 3);
        Assert.assertNotEquals(chatScreenObjects.storeName_ele.getText(), "", "StoreName Should be displayed !!!");
    }

    public void verifyExistenceOfStoreIcon() {
        waitForElementByWithoutExceptionUntillTimeReach(chatScreenObjects.storeIcon_by, 3);
        Assert.assertTrue(chatScreenObjects.storeIcon_ele.isDisplayed());
    }

    public void clickStoreIconOnChatScreen() {
        chatScreenObjects.storeIcon_ele.click();
    }

    public void verifyExistenceOfInputBox() {
        waitForElementByWithoutExceptionUntillTimeReach(chatScreenObjects.chatInputBox_by, 3);
        Assert.assertTrue(chatScreenObjects.chatInputBox_ele.isDisplayed(), "Chat Input Box is not displayed !!!!");
    }

    public void verifyExistenceOfEmoticon() {
        waitForElementByWithoutExceptionUntillTimeReach(chatScreenObjects.emoticons_by, 3);
        Assert.assertTrue(chatScreenObjects.emoticons_ele.isDisplayed(), "Chat Input Box is not displayed !!!!");
    }

    public void verifyExistenceOfQuickReply() {
        Assert.assertTrue(chatScreenObjects.quickReply_lst.size() >= 3, "Not All Quick Reply buttons are displayed!");
    }

    public void verifyExistenceOfMoreOptions() {
        waitForElementToClickable(chatScreenObjects.moreIcon_ele, 20);
        chatScreenObjects.moreIcon_ele.click();
    }

    public void verifyChannelIcon() {
        waitWithoutExceptionForElements(chatScreenObjects.channelIcons_lst);
    Assert.assertTrue(chatScreenObjects.channelIcons_lst.size()==4,"Not All channel icon are displayed under More Options on Chat Screen");
    }

    public void iClickOnChannelIcon(String arg0) {
        waitWithoutExceptionForElements(chatScreenObjects.channelIcons_lst);
        List<WebElement> ele = chatScreenObjects.channelIcons_lst.stream().filter(i -> i.getText().contains(arg0)).collect(Collectors.toList());
        ele.get(0).click();
    }

    public void selectProductScreen() {
        waitWithoutExceptionForElements(chatScreenObjects.productScreenTab_lst);
        Assert.assertTrue(chatScreenObjects.productScreenTab_lst.size()>0,"Select Product Page is Not Loaded or Redirected Properly");
    }

    public void selectProductScreenTabs(String arg0) {
        waitWithoutExceptionForElements(chatScreenObjects.productScreenTab_lst);
        List<WebElement> ele = chatScreenObjects.productScreenTabs_lst.stream().filter(i -> i.getText().contains(arg0)).collect(Collectors.toList());
        ele.get(0).click();
    }

    public void selectAProductOrOrderToSendToSeller(String arg0) {
        waitWithoutExceptionForElements(chatScreenObjects.msgProductsItemSelectable_lst);
        Random random = new Random();
        String productName, textOnImScreen ="";
        int indexvalue,itemnumber ;
        itemnumber = random.nextInt(chatScreenObjects.getMsgItemTitle_lst.size());
        productName = chatScreenObjects.getMsgItemTitle_lst.get(itemnumber).getText().replaceAll("[^0-9a-zA-Z:,]","");
        chatScreenObjects.checkBox_lst.get(itemnumber).click();
        waitForElementToClickable(chatScreenObjects.msgCommitToSend_btn, 20);
        chatScreenObjects.msgCommitToSend_btn.click();
        indexvalue = chatScreenObjects.productTitle_ele.size();
        swipeScreenSmall(Direction.UP);
        textOnImScreen = chatScreenObjects.productTitle_ele.get(indexvalue-1).getText().replaceAll("[^0-9a-zA-Z:,]","");
        Assert.assertTrue(textOnImScreen.equalsIgnoreCase(productName),"Product is not visible on CHAT screen!!!!");
    }

    public void inputRandomTextinInputField() {
        uuid = uuid.substring(0, Math.min(uuid.length(), 10)).replaceAll("[^0-9a-zA-Z:,]", "");
        chatScreenObjects.chatInputBox_ele.sendKeys(uuid);
        clickBackButton();
        clickBackButton();
    }

    public void verifyDraftMsg() {
        waitForElementsToAppear(chatScreenObjects.tv_msg_content_lst);
        String Ab = chatScreenObjects.tv_msg_content_lst.get(0).getText().replaceAll("[^0-9a-zA-Z:,]", " ");
        Assert.assertTrue(Ab.contains(uuid),"Message Not visible in DRAFT!!!!");
    }

    public void clickChatBtnOnStore(String arg0) {
        waitForElementsToAppear(chatScreenObjects.storePage_Footer);
        List<WebElement> ele = chatScreenObjects.storePage_Footer.stream().filter(i -> i.getText().contains(arg0)).collect(Collectors.toList());
        ele.get(0).click();
    }
}