package global.APP.pages;

import global.APP.pageObjects.BannerAndChannelPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 03-October-2019
 */

public class BannerAndChannel extends Base {

    BannerAndChannelPageObject bannerAndChannelPageObject = new BannerAndChannelPageObject();

    public BannerAndChannel(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), bannerAndChannelPageObject);
    }

    public boolean checkTheExistenceofBanner()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return (isExist(bannerAndChannelPageObject.banner_slider));
        else
            return (isExist(bannerAndChannelPageObject.banner_slider_MM));
    }

    public void displayTheTotalNumberofBanners()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            System.out.println("The Total Number banner(s) available for this venture is: "+bannerAndChannelPageObject.banner_slider.get(0).findElements(bannerAndChannelPageObject.banner_picker_by).size());
        else
            System.out.println("The Total Number banner(s) available for this venture is: "+bannerAndChannelPageObject.banner_slider_MM.get(0).findElements(bannerAndChannelPageObject.banner_picker_by).size());
    }

    public boolean checkTheExistenceOfChannel() {
        switch (System.getProperty("env")) {
            case "pk.live":
            case "bd.live":
            case "lk.live": {
                System.out.println(">>>>>>> I am in the PK,BD,NP venture!" + System.getProperty("env"));
                return (isExist(bannerAndChannelPageObject.channel_icon));
            }
            case "np.live": {
                System.out.println(">>>>>>>> I am in the Np venture!");
                return (isExist(bannerAndChannelPageObject.channel_icon_NP));
            }
            default:
                return (isExist(bannerAndChannelPageObject.channel_icon_MM));
        }
    }
        public boolean checkTheChannelPageTitle  ()
        {
            String channelName;
            switch (System.getProperty("env")) {
                case "pk.live":
                case "bd.live":
                case "lk.live": {
                    for (int i = 0; i < bannerAndChannelPageObject.channel_icon.size(); i++) {
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by);
                        channelName = bannerAndChannelPageObject.channel_name_lbl.get(i).getText();
                        bannerAndChannelPageObject.channel_icon.get(i).click();
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.page_view_by);
                        if (containsTextIsExist(channelName) || !(isExist(bannerAndChannelPageObject.channel_icon)))
                            driver.navigate().back();
                        else
                            return false;

                    }
                }
                case "np.live": {
                    for (int i = 0; i < bannerAndChannelPageObject.channel_icon_NP.size(); i++) {
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_NP);
                        channelName = bannerAndChannelPageObject.channel_name_lbl_np.get(i).getText();
                        bannerAndChannelPageObject.channel_icon_NP.get(i).click();
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.page_view_by);
                        if (containsTextIsExist(channelName) || !(isExist(bannerAndChannelPageObject.channel_icon_NP)))
                            driver.navigate().back();
                        else
                            return false;
                    }
                }
                default: {
                      for (int i = 0; i < bannerAndChannelPageObject.channel_icon_MM.size(); i++) {
                          waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_MM);
                          channelName = bannerAndChannelPageObject.channel_name_lbl_MM.get(i).getText();
                          bannerAndChannelPageObject.channel_icon_MM.get(i).click();
                          waitUntilPresentOfElementBy(bannerAndChannelPageObject.page_view_by);
                          if (containsTextIsExist(channelName) || !(isExist(bannerAndChannelPageObject.channel_icon_MM)))
                              driver.navigate().back();
                          else
                              return false;
                      }
                  }
            }
            return true;
        }
    }


