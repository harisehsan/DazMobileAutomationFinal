package global.APP.pages;

import global.APP.pageObjects.SortPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 30-August-2019
 */


public class Sort extends Base {

    SortPageObject sortPageObject = new SortPageObject();

    public Sort(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), sortPageObject);
    }

    public void sortCatalog(String sortType) {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (sortType.equalsIgnoreCase("Price low to high")) {
                waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By);
                sortPageObject.sort_drpDown.click();
                sortPageObject.filter_lstItem.get(1).click();
            }
            if (sortType.equalsIgnoreCase("Price high to low")) {
                waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By);
                sortPageObject.sort_drpDown.click();
                sortPageObject.filter_lstItem.get(2).click();
            }
        } else {
            if (sortType.equalsIgnoreCase("Price low to high")) {
                waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By_MM);
                sortPageObject.sort_drpDown_MM.click();
                sortPageObject.filter_lstItem_MM.get(1).click();
            }
            if (sortType.equalsIgnoreCase("Price high to low")) {
                waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By_MM);
                sortPageObject.sort_drpDown_MM.click();
                sortPageObject.filter_lstItem_MM.get(2).click();
            }
        }
    }

    public boolean verifyTheSortedCatalog(String sortType) {

        if (sortType.equalsIgnoreCase("Price low to high")) {
            switch (System.getProperty("env")) {
                case "pk.live":
                case "lk.live":
                case "np.live": {
                    waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
                    if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("Rs. ", "").replaceAll(",", ""))) {
                       do{
                        if (!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)))
                            swipeBetweenTwoItems(sortPageObject.product_img.get(3), sortPageObject.product_img.get(0));
                        else
                            swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                    } while((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,3)));
                        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("Rs. ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("Rs. ", "").replaceAll(",", "")))
                            return true;
                    }
                }
                break;

                case "bd.live": {
                    waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
                    if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("৳ ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("৳ ", "").replaceAll(",", ""))) {
                       do{
                        if(!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,3)))
                        {
                          swipeBetweenTwoItems(sortPageObject.product_img.get(3), sortPageObject.product_img.get(0));}
                        else
                           swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                       } while((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,3)));
                        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("৳ ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("৳ ", "").replaceAll(",", "")))
                        {
                            return true; }
                    }
                }
                break;

                case "mm.live": {
                    if (Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(0).getText().replace("Ks ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(1).getText().replace("Ks ", "").replaceAll(",", ""))) {
                       do{
                        if(!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,3)))
                            swipeBetweenTwoItems(sortPageObject.product_img_MM.get(3), sortPageObject.product_img_MM.get(0));
                        else
                            swipeBetweenTwoItems(sortPageObject.product_Price_lbl_MM.get(3), sortPageObject.product_Price_lbl_MM.get(0));
                       } while((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,3)));
                        if (Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(2).getText().replace("Ks ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(3).getText().replace("Ks ", "").replaceAll(",", "")))
                            return true;
                    }
                }
                break;
            }
        }
        if (sortType.equalsIgnoreCase("Price high to low")) {
            switch (System.getProperty("env")) {
                case "pk.live":
                case "lk.live":
                case "np.live": {
                    waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
                    if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("Rs. ", "").replaceAll(",", ""))) {
                       do {
                           if (!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)))
                               swipeBetweenTwoItems(sortPageObject.product_img.get(3), sortPageObject.product_img.get(0));
                           else
                               swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                       } while((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,3)));
                        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("Rs. ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("Rs. ", "").replaceAll(",", "")))
                            return true;
                    }
                }
                break;

                case "bd.live": {
                    waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
                    if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("৳ ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("৳ ", "").replaceAll(",", ""))) {
                        do {
                        if(!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,3)))
                        {
                            swipeBetweenTwoItems(sortPageObject.product_img.get(3), sortPageObject.product_img.get(0));}
                        else
                        swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                    } while((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl,3)));
                        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("৳ ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("৳ ", "").replaceAll(",", "")))
                            return true;
                    }
                }
                break;

                case "mm.live": {
                    if (Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(0).getText().replace("Ks ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(1).getText().replace("Ks ", "").replaceAll(",", ""))) {
                       do{
                        if(!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,3)))
                            swipeBetweenTwoItems(sortPageObject.product_img_MM.get(3), sortPageObject.product_img_MM.get(0));
                        else
                            swipeBetweenTwoItems(sortPageObject.product_Price_lbl_MM.get(3), sortPageObject.product_Price_lbl_MM.get(0));
                       } while((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,3)));
                        if (Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(2).getText().replace("Ks ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(3).getText().replace("Ks ", "").replaceAll(",", "")))
                            return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    public void goToDarazMall()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
           waitUntilPresentOfElementBy(sortPageObject.search_tab_By);
            sortPageObject.search_tab.get(1).click();
        }
        else
        {
            waitUntilPresentOfElementBy(sortPageObject.search_tab_By_MM);
            sortPageObject.search_tab_MM.get(1).click();
        }
    }

    public void selectFilter()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(sortPageObject.filter_btn_By);
            sortPageObject.filter_btn.click();
        }
        else
        {
            waitUntilPresentOfElementBy(sortPageObject.filter_btn_By_MM);
            sortPageObject.filter_btn_MM.click();
        }
    }

    public String applyBrandFilter(String filterKeyword)
    {
        findElementByTextUsingExactString("Brand").click();
        findElementByTextUsingExactString(filterKeyword).click();
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(sortPageObject.done_btn_By);
            sortPageObject.done_btn.click();
        }
        else
        {
            waitUntilPresentOfElementBy(sortPageObject.done_btn_By_MM);
            sortPageObject.done_btn_MM.click();
        }
        return filterKeyword;
    }
}