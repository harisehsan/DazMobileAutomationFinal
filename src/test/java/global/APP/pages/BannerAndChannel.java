package global.APP.pages;

import global.APP.pageObjects.BannerAndChannelPageObject;
import global.APP.pageObjects.FlashSalePageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.StartScreenPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 03-October-2019
 */

public class BannerAndChannel extends Base {

    BannerAndChannelPageObject bannerAndChannelPageObject = new BannerAndChannelPageObject();
    FlashSalePageObject flashSalePageObject = new FlashSalePageObject();

    public BannerAndChannel(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), bannerAndChannelPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), flashSalePageObject);
    }

    public boolean checkTheExistenceofBanner()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
            waitWithoutExceptionForElements(bannerAndChannelPageObject.banner_slider);
            return (isExist(bannerAndChannelPageObject.banner_slider));
        }
        else {
            waitWithoutExceptionForElements(bannerAndChannelPageObject.banner_slider_MM);
            return (isExist(bannerAndChannelPageObject.banner_slider_MM));
        }
    }

//    public void displayTheTotalNumberofBanners() This functions displays the total number of banner available on Homepage
//    {
//        int totalBanners;
//        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
//          totalBanners =  bannerAndChannelPageObject.banner_slider.get(0).findElements(bannerAndChannelPageObject.banner_picker_by).size();
//        else
//            totalBanners =  bannerAndChannelPageObject.banner_slider_MM.get(0).findElements(bannerAndChannelPageObject.banner_picker_by).size();
//    }

    public boolean checkTheExistenceOfChannel() {
        switch (System.getProperty("env")) {
            case "pk.live":
            case "bd.live":
            case "lk.live": {
                waitWithoutExceptionForElements(bannerAndChannelPageObject.channel_icon);
                return (isExist(bannerAndChannelPageObject.channel_icon));
            }
            case "np.live": {
                waitWithoutExceptionForElements(bannerAndChannelPageObject.channel_icon_NP);
                return (isExist(bannerAndChannelPageObject.channel_icon_NP));
            }
            default: {
                waitWithoutExceptionForElements(bannerAndChannelPageObject.channel_icon_MM);
                return (isExist(bannerAndChannelPageObject.channel_icon_MM));
            }
        }
    }
        public boolean checkTheChannelPageTitle  ()
        {
            String channelName;
            switch (System.getProperty("env")) {
                case "pk.live":
                case "bd.live":
                case "lk.live": {
                    waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by);
                    for (int i = 0; i < bannerAndChannelPageObject.channel_icon.size(); i++) {
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by);
                        channelName = bannerAndChannelPageObject.channel_name_lbl.get(i).getText();
                        bannerAndChannelPageObject.channel_icon.get(i).click();
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.page_view_by);
                        if (containsTextIsExist(channelName) || !(isExist(bannerAndChannelPageObject.channel_icon))) {
                            driver.navigate().back();
                            if(isExist(bannerAndChannelPageObject.shake_lbl))
                                bannerAndChannelPageObject.shake_lbl.get(0).click();
                        }
                        else
                            return false;

                    }
                }
                break;
                case "np.live": {
                    waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_NP);
                    for (int i = 0; i < bannerAndChannelPageObject.channel_icon_NP.size(); i++) {
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_NP);
                        channelName = bannerAndChannelPageObject.channel_name_lbl_np.get(i).getText();
                        bannerAndChannelPageObject.channel_icon_NP.get(i).click();
                        waitUntilPresentOfElementBy(bannerAndChannelPageObject.page_view_by);
                        if (containsTextIsExist(channelName) || !(isExist(bannerAndChannelPageObject.channel_icon_NP)))
                        {
                            driver.navigate().back();
                            if(isExist(bannerAndChannelPageObject.shake_lbl))
                                bannerAndChannelPageObject.shake_lbl.get(0).click();
                        }
                        else
                            return false;
                    }
                }
                break;
                default: {
                    waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_MM);
                      for (int i = 0; i < bannerAndChannelPageObject.channel_icon_MM.size(); i++) {
                          waitUntilPresentOfElementBy(bannerAndChannelPageObject.channel_icon_by_MM);
                          channelName = bannerAndChannelPageObject.channel_name_lbl_MM.get(i).getText();
                          bannerAndChannelPageObject.channel_icon_MM.get(i).click();
                          waitUntilPresentOfElementBy(bannerAndChannelPageObject.page_view_by);
                          if (containsTextIsExist(channelName) || !(isExist(bannerAndChannelPageObject.channel_icon_MM)))
                          {
                              driver.navigate().back();
                              if(isExist(bannerAndChannelPageObject.shake_lbl_MM))
                                  bannerAndChannelPageObject.shake_lbl_MM.get(0).click();
                          }
                          else
                              return false;
                      }
                  }
            }
            return true;
        }
    }