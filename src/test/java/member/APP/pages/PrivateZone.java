package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.PrivateZoneObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PrivateZone extends Base {

    String optionsButton = "More options";
    String profile = "Profile";

    PrivateZoneObject privateZoneObject = new PrivateZoneObject();
    public PrivateZone(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), privateZoneObject);
    }

   public boolean waitforTheStorePageToLoad()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           if (isExist(privateZoneObject.got_It_btn))
               privateZoneObject.got_It_btn.get(0).click();
           return waitForElementByWithoutExceptionUntillTimeReach(privateZoneObject.store_Name_lbl_by,20);
       } else {
           if (isExist(privateZoneObject.got_It_btn_MM))
               privateZoneObject.got_It_btn_MM.get(0).click();
           return waitForElementByWithoutExceptionUntillTimeReach(privateZoneObject.store_Name_lbl_by_MM,20);
       }
   }

   public boolean verifyTheExistenceOftheBasicComponents()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           return (isExist(privateZoneObject.shop_Name_lbl) && isExist(privateZoneObject.shop_Logo_img));
       } else {
           return (isExist(privateZoneObject.shop_Name_lbl_MM) && isExist(privateZoneObject.shop_Logo_img_MM));
       }
   }

   public void selectOptionsButton()
   {
       findElementByString(optionsButton).click();
   }

   public boolean verifyFortheShareThisStoreButton()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           return isExist(privateZoneObject.share_This_Store_btn);
       } else {
           return isExist(privateZoneObject.share_This_Store_btn_MM);
       }
   }

   public void navigateToCategoriesFromStore()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           privateZoneObject.categories_tab.click();
       } else {
           privateZoneObject.categories_tab_MM.click();
       }
   }

    public void navigateToProfileFromStore()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            privateZoneObject.profile_tab.click();
        } else {
            privateZoneObject.profile_tab_MM.click();
        }
    }

    public boolean iShouldBeOnTheCategoriesPage(String argu)
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return (isExist(privateZoneObject.all_Products_lbl));
        } else {
            return (isExist(privateZoneObject.all_Products_lbl_MM));
        }
    }

    public boolean iShouldBeOnTheProfile()
    {
      return containsTextIsExist(profile);
    }

    public void skipTheGotItPopup()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            clickMultipleTries(privateZoneObject.got_It_Success_btn,10);
        }
        else
        {
            clickMultipleTries(privateZoneObject.got_It_Success_btn_MM,10);
        }
    }

    public void selectTheFollowingStore()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           privateZoneObject.following_btn.click();
            privateZoneObject.unfollow_btn.click();
        }
        else
        {
            privateZoneObject.following_btn_MM.click();
            privateZoneObject.unfollow_btn_MM.click();
        }
    }

    public boolean iShouldSeeTheFollowbutton()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return isExist(privateZoneObject.follow_btn);
        }
        else
        {
            return isExist(privateZoneObject.follow_btn_MM);
        }
    }
}
