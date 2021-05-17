package global.APP.pages;

import global.APP.pageObjects.MostPopularPageObject;
import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 15-October-2019
 */


public class MostPopular extends Base {

    MostPopularPageObject mostPopularPageObject = new MostPopularPageObject();

    public MostPopular(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), mostPopularPageObject);
    }

    public boolean verifyTheExistenceOfMostPopular()
    {
        int tries = 15;
        for (int i=0; i < tries; i++)
         {
            if (isExist(mostPopularPageObject.most_Popular_lbl)) {
                swiptToBottom();
                return true;
            }else
                swiptToBottom();
         }
         return false;
    }

    public boolean verifyTheExistenceOfMonth()
    {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
             return (!(mostPopularPageObject.most_Popular_Month_lbl.get(0).getText().equalsIgnoreCase("")));
        else
            return (!(mostPopularPageObject.most_Popular_Month_lbl_MM.get(0).getText().equalsIgnoreCase("")));
    }

    public boolean verifyTheExistenceOfMostPopularInLocalLanguage()
    {
        int tries = 15;
        for (int i=0; i < tries; i++)
        {
           switch (ThreadStorage.get("env"))
           {
               case "bd.live":
               {
                   if (isExist(mostPopularPageObject.most_Popular_Local_lbl_BD))
                       return true;
                   else
                      swiptToBottom();
               }
               break;

               case "lk.live":
               {
                   if (isExist(mostPopularPageObject.most_Popular_Local_lbl_LK))
                       return true;
                   else
                       swiptToBottom();
               }
               break;

               case "np.live":
               {
                   if (isExist(mostPopularPageObject.most_Popular_Local_lbl_NP))
                       return true;
                   else
                       swiptToBottom();
               }
               break;

               case "mm.live":
               {
                   if (isExist(mostPopularPageObject.most_Popular_Local_lbl_MM))
                       return true;
                   else
                       swiptToBottom();
               }
               break;
           }
        }
        return false;
    }

    public void selectMostPopularClassification()
    {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
            mostPopularPageObject.most_popluar_classification.get(0).click();
        else
            mostPopularPageObject.most_popluar_classification_MM.get(0).click();
    }

    public boolean verifyTheMostPopularPage()
    {
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live")))
        {
            waitWithoutExceptionForElements(mostPopularPageObject.search_Most_Popular_icon);
            return isExist(mostPopularPageObject.search_Most_Popular_icon);
        }
        else
        {
            waitWithoutExceptionForElements(mostPopularPageObject.search_Most_Popular_icon_MM);
            return isExist(mostPopularPageObject.search_Most_Popular_icon_MM);
        }

    }

}
