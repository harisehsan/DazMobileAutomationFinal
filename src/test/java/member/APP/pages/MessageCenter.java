package member.APP.pages;

import com.sun.javafx.scene.traversal.Direction;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.MessageCenterObjects;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessageCenter extends Base {
    MessageCenterObjects messageCenterObjects = new MessageCenterObjects();

    public MessageCenter(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), messageCenterObjects);
    }

    //This method will get count of messages in the footer of application
    public boolean getMessageCountInFooter() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            Assert.assertTrue(messageCenterObjects.footer_Quantity_list.size() > 0, "NO Messages in Message Center");
            return Integer.parseInt(messageCenterObjects.footer_Quantity_list.get(0).getText().replaceAll("\\D+", "")) > 0;
        } else {
            Assert.assertTrue(messageCenterObjects.footer_Quantity_list_MM.size() > 0, "NO Messages in Message Center");
            return Integer.parseInt(messageCenterObjects.footer_Quantity_list_MM.get(0).getText().replaceAll("\\D+", "")) > 0;
        }
    }

    //This method will find unRead message count in message center, if msg found in any of the tabs will consider True.
    public boolean getMsgCountInMsgCenter() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return messageCenterObjects.msgCenter_count_lst.size() > 0;
        } else {
            return messageCenterObjects.msgCenter_count_lst_MM.size() > 0;
        }
    }

    public boolean getMsgCountInMsgCenterDisappear() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return messageCenterObjects.msgCenter_count_lst.size()==0;
        } else {
            return messageCenterObjects.msgCenter_count_lst_MM.size() ==  0;
        }
    }

    public void clickMarkAllAsRead() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            Assert.assertTrue(messageCenterObjects.markAllRead_btn.isDisplayed(), "Mark All Read button not Displayed!!");
            messageCenterObjects.markAllRead_btn.click();
        } else {
            Assert.assertTrue(messageCenterObjects.markAllRead_btn_MM.isDisplayed(), "Mark All Read button not Displayed!!");
            messageCenterObjects.markAllRead_btn_MM.click();
        }
    }

    public void readFirstNotification() {
        waitForElementsToAppear(messageCenterObjects.msgCenterNotificationTitle);
        waitForElementsToAppear(messageCenterObjects.msgCenterNotificationTime);
        messageCenterObjects.msgCenterNotificationTitle.get(0).click();
        waitForElementToDisAppear(messageCenterObjects.msgCenterNotificationTitle_By, 5);
    }

    public void deleteNotification() {
        Assert.assertTrue(messageCenterObjects.msgCenterNotificationTitle.size()>0,"Not Reached back in Message Center!");
        String msgtitle = messageCenterObjects.msgCenterNotificationTitle.get(0).getText();
        swipeHorizontallyToZeroWithInElement(messageCenterObjects.msgCenterNotificationTitle.get(0));
        messageCenterObjects.msgCenterNotificationT.get(0).click();
        swipeScreenSmall(Direction.DOWN);
        Assert.assertNotEquals(messageCenterObjects.msgCenterNotificationTitle.get(0).getText(),msgtitle,"Message Center Notification yet!");
    }

    public void iClickOnBackAeroImg(String arg0) {
        if (isExist(messageCenterObjects.got_It_Store_btn)) {
            messageCenterObjects.got_It_Store_btn.get(0).click();
            messageCenterObjects.WeexBack_btn.get(0).click();
        } else if (isExist(messageCenterObjects.WeexBack_btn)) {
            messageCenterObjects.WeexBack_btn.get(0).click();
        } else if (isExist(messageCenterObjects.GotIt_IM_btn)) {
            messageCenterObjects.GotIt_IM_btn.get(0).click();
            messageCenterObjects.iM_backBtn.click();
        }
    }

    public void clickOnTabsMsgCenter(String arg0) {
        waitForElementsToAppear(messageCenterObjects.msgCenterNotificationTitle);
        List<WebElement> ele = messageCenterObjects.msgCenter_tabs.stream().filter(i -> i.getText().contains(arg0)).collect(Collectors.toList());
        ele.get(0).click();
    }
}

