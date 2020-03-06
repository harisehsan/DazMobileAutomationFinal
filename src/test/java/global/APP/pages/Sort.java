package global.APP.pages;

import global.APP.pageObjects.SortPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 30-August-2019
 */


public class Sort extends Base {

    SortPageObject sortPageObject = new SortPageObject();
    SearchPageObject searchPageObject = new SearchPageObject();

    public Sort(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), sortPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObject);
    }

    public void sortCatalog(String sortType) {
        if (sortType.equalsIgnoreCase("Price low to high")) {
            priceLowToHighSort();
        }
        if (sortType.equalsIgnoreCase("Price high to low")) {
            priceHighToLowSort();
        }
    }

    public boolean verifyTheSortedCatalog(String sortType) {
        if (sortType.equalsIgnoreCase("Price low to high")) {
            switch (System.getProperty("env")) {
                case "pk.live":
                case "lk.live":
                case "np.live":
                    return rupeesLowToHigh();
                case "bd.live":
                    return takaLowToHigh();

                case "mm.live":
                    return kyatLowToHigh();
            }
        }
        if (sortType.equalsIgnoreCase("Price high to low")) {
            switch (System.getProperty("env")) {
                case "pk.live":
                case "lk.live":
                case "np.live":
                    return rupeesHighToLow();
                case "bd.live":
                    return takaHighToLow();
                case "mm.live":
                    return kyatHighToLow();
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
       if (!(isExistByText(filterKeyword)))
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

    private void priceLowToHighSort() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By);
            sortPageObject.sort_drpDown.click();
            sortPageObject.filter_lstItem.get(1).click();
        }
        else {
            waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By_MM);
            sortPageObject.sort_drpDown_MM.click();
            sortPageObject.filter_lstItem_MM.get(1).click();
        }
    }

    private void priceHighToLowSort() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By);
            sortPageObject.sort_drpDown.click();
            sortPageObject.filter_lstItem.get(2).click();
        }
        else {
            waitUntilPresentOfElementBy(sortPageObject.sort_drpDown_By_MM);
            sortPageObject.sort_drpDown_MM.click();
            sortPageObject.filter_lstItem_MM.get(2).click();
        }
    }

    private boolean rupeesLowToHigh(){
        waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
        if(sortPageObject.product_Price_lbl.size() == 1) return true;
        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("Rs. ", "").replaceAll(",", ""))) {
            if ((sortPageObject.product_Price_lbl.size() > 2)) {
                do {
                    if (!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)))
                        swipeBetweenTwoItems(sortPageObject.product_img.get(2), sortPageObject.product_img.get(0));
                    else
                        swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                } while ((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)));
                return Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("Rs. ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("Rs. ", "").replaceAll(",", ""));
            }
            else
                return true;
        }
        else
            return false;
    }

    private boolean takaLowToHigh() {
        waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
        if(sortPageObject.product_Price_lbl.size() == 1) return true;
        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("৳ ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("৳ ", "").replaceAll(",", ""))) {
            if ((sortPageObject.product_Price_lbl_MM.size() > 2)) {
                do {
                    if (!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3))) {
                        swipeBetweenTwoItems(sortPageObject.product_img.get(3), sortPageObject.product_img.get(0));
                    } else
                        swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                } while ((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)));
                return Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("৳ ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("৳ ", "").replaceAll(",", ""));
            }
            else
                return true;
        }
        else
            return false;
    }

    private boolean kyatLowToHigh()
    {
        if(sortPageObject.product_Price_lbl_MM.size() == 1) return true;
        if (Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(0).getText().replace("Ks ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(1).getText().replace("Ks ", "").replaceAll(",", ""))) {
            if ((sortPageObject.product_Price_lbl_MM.size() > 2)) {
                do {
                    if (!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM, 3)))
                        swipeBetweenTwoItems(sortPageObject.product_img_MM.get(3), sortPageObject.product_img_MM.get(0));
                    else
                        swipeBetweenTwoItems(sortPageObject.product_Price_lbl_MM.get(3), sortPageObject.product_Price_lbl_MM.get(0));
                } while ((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM, 2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM, 3)));
                return Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(2).getText().replace("Ks ", "").replaceAll(",", "")) <= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(3).getText().replace("Ks ", "").replaceAll(",", ""));
            }
            else
                return true;
        }
         else
            return false;
    }

    private boolean rupeesHighToLow() {
        waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
        if(sortPageObject.product_Price_lbl.size() == 1) return true;
        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("Rs. ", "").replaceAll(",", ""))) {
            if ((sortPageObject.product_Price_lbl.size() > 2)) {
                do {
                    if (!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)))
                        swipeBetweenTwoItems(sortPageObject.product_img.get(2), sortPageObject.product_img.get(0));
                    else
                        swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                } while ((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)));
                return Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("Rs. ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("Rs. ", "").replaceAll(",", ""));
            }
            else
                return true;
        }
        else
            return false;
    }

    private boolean takaHighToLow()
    {
        waitUntilPresentOfElementBy(sortPageObject.product_Name_lbl_By);
        if(sortPageObject.product_Price_lbl.size() == 1) return true;
        if (Integer.parseInt(sortPageObject.product_Price_lbl.get(0).getText().replace("৳ ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(1).getText().replace("৳ ", "").replaceAll(",", ""))) {
            if ((sortPageObject.product_Price_lbl.size() > 2)) {
                do {
                    if (!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3))) {
                        swipeBetweenTwoItems(sortPageObject.product_img.get(3), sortPageObject.product_img.get(0));
                    } else
                        swipeBetweenTwoItems(sortPageObject.product_Price_lbl.get(3), sortPageObject.product_Price_lbl.get(0));
                } while ((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl, 3)));
                return Integer.parseInt(sortPageObject.product_Price_lbl.get(2).getText().replace("৳ ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl.get(3).getText().replace("৳ ", "").replaceAll(",", ""));
            }
            else return true;
        }
        else
            return false;
    }

    private boolean kyatHighToLow()
    {
        if(sortPageObject.product_Price_lbl_MM.size() == 1) return true;
        if (Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(0).getText().replace("Ks ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(1).getText().replace("Ks ", "").replaceAll(",", ""))) {
           if((sortPageObject.product_Price_lbl_MM.size() > 2)) {
            do{
                if(!(waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,3)))
                    swipeBetweenTwoItems(sortPageObject.product_img_MM.get(3), sortPageObject.product_img_MM.get(0));
                else
                    swipeBetweenTwoItems(sortPageObject.product_Price_lbl_MM.get(3), sortPageObject.product_Price_lbl_MM.get(0));
            } while((!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,2)) || (!waitWithoutExceptionWithIndex(sortPageObject.product_Price_lbl_MM,3)));
            return Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(2).getText().replace("Ks ", "").replaceAll(",", "")) >= Integer.parseInt(sortPageObject.product_Price_lbl_MM.get(3).getText().replace("Ks ", "").replaceAll(",", ""));
        }
        else
            return true;
        }
        else
            return false;
    }

    public void selectAllProductInSearchHint()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            if (isExist(searchPageObject.got_It_Store_btn))
                searchPageObject.got_It_Store_btn.get(0).click();
            searchPageObject.search_tab.click();
            waitUntilPresentOfElementBy(sortPageObject.all_Products_btn_By);
            sortPageObject.all_Products_btn.click();
        }
        else
        {
            if (isExist(searchPageObject.got_It_Store_btn_MM))
                searchPageObject.got_It_Store_btn_MM.get(0).click();
            searchPageObject.search_tab_MM.click();
            waitUntilPresentOfElementBy(sortPageObject.all_Products_btn_By);
            sortPageObject.all_Products_btn.click();
        }
    }

    public void applyListViewOnCatalog(String sortMode)
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
         waitUntilPresentOfElementBy(searchPageObject.searchResult_lbl_By);
          sortPageObject.catalog_View_icon.click();
        }
        else
        {
            waitUntilPresentOfElementBy(searchPageObject.searchResult_lbl_By_MM);
            sortPageObject.catalog_View_icon_MM.click();
        }
    }
}