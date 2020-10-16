package member.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.CheckOutPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.getProperty.SearchGetProperty;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-April-2019
 */

public class SearchProduct extends Base {
    SearchPageObject searchPageObj = new SearchPageObject();
    CartPageObjects cartPageObjects = new CartPageObjects();
    CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();
    SearchGetProperty searchGetProperty = new SearchGetProperty();
    private String productName;
    private String searchKeyword;

    public SearchProduct(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
    }

    public void searchProduct(String searchType, List<String> pkProducts, List<String> bdProducts, List<String> lkProducts, List<String> npProducts, List<String> mmProducts) {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By);
            searchPageObj.searchBeforeClick_txtfield.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            switch (System.getProperty("env")) {
                case "pk.live": {
                    for (String pkProduct : pkProducts) {
                        searchPageObj.searchAfterClick_txtfield.sendKeys(pkProduct);
                        searchPageObj.search_btn.click();
                        if (!waitUntilPresentOfElementByWithoutException(searchPageObj.searchResult_lbl_By)) {
                            searchPageObj.searchBar_Third_txtBox.get(0).click();
                            continue;
                        }
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        if ((Integer.parseInt(checkOutPageObjects.product_Price.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) < 150) && (searchType.equalsIgnoreCase("Checkout"))) {
                            driver.navigate().back();
                            continue;
                        }
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (isExist(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.get(0).click();
                        if (isExist(searchPageObj.ok_Got_It_btn))
                            searchPageObj.ok_Got_It_btn.get(0).click();
                        if (searchType.equalsIgnoreCase("Wishlist"))
                            break;
                        else {
                            if (isExist(cartPageObjects.buy_Now_btn))
                                break;
                            else {
                                driver.navigate().back();
                                waitUntilPresentOfElementBy(searchPageObj.searchBox_Final_txtfield_By);
                                searchPageObj.searchBox_Final_txtfield.click();
                            }
                        }
                    }
                }
                break;

                case "bd.live": {
                    for (String bdProduct : bdProducts) {
                        searchPageObj.searchAfterClick_txtfield.sendKeys(bdProduct);
                        searchPageObj.search_btn.click();
                        if (!waitUntilPresentOfElementByWithoutException(searchPageObj.searchResult_lbl_By)) {
                            searchPageObj.searchBar_Third_txtBox.get(0).click();
                            continue;
                        }
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        if ((Integer.parseInt(checkOutPageObjects.product_Price.get(0).getText().replace("৳ ", "").replaceAll(",", "")) < 100) && (searchType.equalsIgnoreCase("Checkout"))) {
                            driver.navigate().back();
                            continue;
                        }
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (isExist(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.get(0).click();
                        if (isExist(searchPageObj.ok_Got_It_btn))
                            searchPageObj.ok_Got_It_btn.get(0).click();
                        if (searchType.equalsIgnoreCase("Wishlist"))
                            break;
                        else {
                            if (isExist(cartPageObjects.buy_Now_btn))
                                break;
                            else {
                                driver.navigate().back();
                                waitUntilPresentOfElementBy(searchPageObj.searchBox_Final_txtfield_By);
                                searchPageObj.searchBox_Final_txtfield.click();
                            }
                        }
                    }
                }
                break;

                case "lk.live": {
                    for (String lkProduct : lkProducts) {
                        searchPageObj.searchAfterClick_txtfield.sendKeys(lkProduct);
                        searchPageObj.search_btn.click();
                        if (!waitUntilPresentOfElementByWithoutException(searchPageObj.searchResult_lbl_By)) {
                            searchPageObj.searchBar_Third_txtBox.get(0).click();
                            continue;
                        }
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        if ((Integer.parseInt(checkOutPageObjects.product_Price.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) < 250) && (searchType.equalsIgnoreCase("Checkout"))) {
                            driver.navigate().back();
                            continue;
                        }
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (isExist(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.get(0).click();
                        if (isExist(searchPageObj.ok_Got_It_btn))
                            searchPageObj.ok_Got_It_btn.get(0).click();
                        if (searchType.equalsIgnoreCase("Wishlist"))
                            break;
                        else {
                            if (isExist(cartPageObjects.buy_Now_btn))
                                break;
                            else {
                                driver.navigate().back();
                                waitUntilPresentOfElementBy(searchPageObj.searchBox_Final_txtfield_By);
                                searchPageObj.searchBox_Final_txtfield.click();
                            }
                        }
                    }
                }
                break;

                case "np.live": {
                    for (String npProduct : npProducts) {
                        searchPageObj.searchAfterClick_txtfield.sendKeys(npProduct);
                        searchPageObj.search_btn.click();
                        if (!waitUntilPresentOfElementByWithoutException(searchPageObj.searchResult_lbl_By)) {
                            searchPageObj.searchBar_Third_txtBox.get(0).click();
                            continue;
                        }
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (isExist(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.get(0).click();
                        if (isExist(searchPageObj.ok_Got_It_btn))
                            searchPageObj.ok_Got_It_btn.get(0).click();
                        System.out.println("This is the Search Type: " + searchType);
                        if (searchType.equalsIgnoreCase("Wishlist"))
                            break;
                        else {
                            if (isExist(cartPageObjects.buy_Now_btn))
                                break;
                            else {
                                driver.navigate().back();
                                waitUntilPresentOfElementBy(searchPageObj.searchBox_Final_txtfield_By);
                                searchPageObj.searchBox_Final_txtfield.click();
                            }
                        }
                    }
                }
                break;
            }

        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            for (String mmProduct : mmProducts) {
                searchPageObj.searchAfterClick_txtfield_MM.sendKeys(mmProduct);
                searchPageObj.search_btn_MM.click();
                if (!waitUntilPresentOfElementByWithoutException(searchPageObj.searchResult_lbl_By_MM)) {
                    searchPageObj.searchBar_Third_txtBox_MM.get(0).click();
                    continue;
                }
                if (searchType.equalsIgnoreCase("Result"))
                    break;
                waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_MM_By);
                cartPageObjects.searchProduct_lbl_MM.get(0).click();
                if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                    cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
                if (isExist(searchPageObj.ok_Got_It_btn_MM))
                    searchPageObj.ok_Got_It_btn_MM.get(0).click();
                if (searchType.equalsIgnoreCase("Wishlist"))
                    break;
                else {
                    if (isExist(cartPageObjects.buy_Now_btn_MM))
                        break;
                    else {
                        driver.navigate().back();
                        waitUntilPresentOfElementBy(searchPageObj.searchBox_Final_txtfield_By_MM);
                        searchPageObj.searchBox_Final_txtfield_MM.click();
                    }
                }
            }
        }
    }

    public boolean verifySearchResult() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            return (searchPageObj.searchResult_lbl.size() >= 1);
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            return (searchPageObj.searchResult_lbl_MM.size() >= 1);
        }
    }

    public String searchProductByName(String searchKeyword) {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By);
            searchPageObj.searchBeforeClick_txtfield.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            searchPageObj.searchAfterClick_txtfield.sendKeys(searchKeyword);
            searchPageObj.search_btn.click();
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            searchPageObj.searchAfterClick_txtfield_MM.sendKeys(searchKeyword);
            searchPageObj.search_btn_MM.click();
        }
        return searchKeyword;
    }

    public boolean verifyTheSearchProduct(String searchKeyword) {

        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            return (searchPageObj.searchResult_lbl.size() >= 1);
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            return (searchPageObj.searchResult_lbl_MM.size() >= 1);
        }
    }

    public void navigateBackToTheHomeScreen() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
       //     waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            do {
                driver.navigate().back();
                hideKeyboard();
            }
            while (!isExist(searchPageObj.searchBeforeClick_txtfield));

        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            do {
                driver.navigate().back();
                hideKeyboard();
            }
            while (!isExist(searchPageObj.searchBeforeClick_txtfield_MM));
        }
    }

    public void searchUsingHistory(String searchKeyword) {
       this.searchKeyword = searchKeyword;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            searchPageObj.searchBeforeClick_txtfield.get(0).click();
            findElementByTextUsingExactString(searchKeyword).click();
        } else {
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            findElementByTextUsingExactString(searchKeyword).click();
        }
    }

    public boolean searchForSuggestionKeyword(String suggestionKeyword) {
        String[] suggestionKeywordArray = suggestionKeyword.split("");
        StringBuilder suggestionLetter = new StringBuilder();
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By);
            searchPageObj.searchBeforeClick_txtfield.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            for (int i = 0; i < (suggestionKeywordArray.length); i++) {
                suggestionLetter.append(suggestionKeywordArray[i]);
                searchPageObj.searchAfterClick_txtfield.sendKeys(suggestionLetter);
                if (waitWithoutExceptionForElementsLessTime(searchPageObj.search_Suggestion_lstItem)) {
                    if (!(searchPageObj.search_Suggestion_lstItem.get(0).getText().contains(suggestionLetter.toString())))
                        return false;
                }
                else
                return false;
            }

        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            for (int i = 0; i < suggestionKeywordArray.length; i++) {
                suggestionLetter.append(suggestionKeywordArray[i]);
                searchPageObj.searchAfterClick_txtfield_MM.sendKeys(suggestionLetter);
                if (waitWithoutExceptionForElementsLessTime(searchPageObj.search_Suggestion_lstItem_MM)) {
                    if (!(searchPageObj.search_Suggestion_lstItem_MM.get(0).getText().contains(suggestionLetter.toString())))
                        return false;
                }
                else
                    return false;
            }
        }
        return true;
    }

    public void selectSuggestionResult()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            searchPageObj.search_Suggestion_lstItem.get(0).click();
        else
            searchPageObj.search_Suggestion_lstItem_MM.get(0).click();
    }

    public boolean checkForSuggestionKeywordInProduct(String suggestionKeyword)
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
        {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            return (searchPageObj.searchResult_lbl.get(0).getText().contains(suggestionKeyword));
        }
        else
        {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            return (searchPageObj.searchResult_lbl_MM.get(0).getText().contains(suggestionKeyword));
        }
    }

    public boolean clickOnDidYouMeanOption()  {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            return (waitWithoutExceptionForElements(searchPageObj.did_You_Mean_lbl));
        else
            return (waitWithoutExceptionForElements((searchPageObj.did_You_Mean_lbl_MM)));
    }

    public void searchInCategoriesSection(String searchKeyword)
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
        {
            searchPageObj.search_In_Categories_btn.click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            searchPageObj.searchAfterClick_txtfield.sendKeys(searchKeyword);
            searchPageObj.search_btn.click();
        }
        else
        {
            searchPageObj.search_In_Categories_btn_MM.click();
            searchPageObj.searchAfterClick_txtfield_MM.sendKeys(searchKeyword);
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            searchPageObj.search_btn_MM.click();
        }
    }

    public void gotoStorePage() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
        {
            for (int i=0;i<searchGetProperty.storeSearchKeyword().size();i++) {
                searchPageObj.searchBeforeClick_txtfield.get(0).click();
                waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
                searchPageObj.searchAfterClick_txtfield.sendKeys(searchGetProperty.storeSearchKeyword().get(i));
                searchPageObj.search_btn.click();
               if (waitWithoutExceptionByString("VISIT STORE")) {
                   findElementByString("VISIT STORE").click();
                   break;
               }
               else {
                   do {
                       driver.navigate().back();
                       hideKeyboard();
                   } while (!isExist(searchPageObj.searchBeforeClick_txtfield));
               }
            }
        }
        else
        {
            for (int i=0;i<searchGetProperty.storeSearchKeyword().size();i++) {
                searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
                waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
                searchPageObj.searchAfterClick_txtfield_MM.sendKeys(searchGetProperty.storeSearchKeyword().get(i));
                searchPageObj.search_btn_MM.click();
                if (waitWithoutExceptionByString("VISIT STORE")) {
                    findElementByString("VISIT STORE").click();
                    break;
                }
                else {
                    do {
                        driver.navigate().back();
                        hideKeyboard();
                    } while (!isExist(searchPageObj.searchBeforeClick_txtfield_MM));
                }
            }
        }

    }

    public void searchProductInStore()
    {

        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if(isExist(searchPageObj.got_It_Store_btn))
                searchPageObj.got_It_Store_btn.get(0).click();
            searchPageObj.all_Product_tab.click();
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            productName = searchPageObj.searchResult_lbl.get(0).getText();
            searchPageObj.search_tab.click();
            searchPageObj.searchAfterClick_txtfield.sendKeys(productName);
            searchPageObj.search_btn.click();
        }
        else
        {
            if(isExist(searchPageObj.got_It_Store_btn_MM))
                searchPageObj.got_It_Store_btn_MM.get(0).click();
            searchPageObj.all_Product_tab.click();
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            productName = searchPageObj.searchResult_lbl_MM.get(0).getText();
            searchPageObj.search_tab_MM.click();
            searchPageObj.searchAfterClick_txtfield_MM.sendKeys(productName);
            searchPageObj.search_btn_MM.click();
        }
    }

    public boolean goToPDPFromStorePage()
    {
        if (productName.length() >= 10)
            productName = productName.substring(0,10);
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            searchPageObj.searchResult_lbl.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
            return (cartPageObjects.product_Title_lbl.getText().contains(productName));
        }
        else
        {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            searchPageObj.searchResult_lbl_MM.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn_MM))
                searchPageObj.ok_Got_It_btn_MM.get(0).click();
            return (cartPageObjects.product_Title_lbl_MM.getText().contains(productName));
        }
    }

    public void deleteSearchHistory() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            do {
                driver.navigate().back();
                hideKeyboard();
            } while (!isExist(searchPageObj.searchBeforeClick_txtfield));
            searchPageObj.searchBeforeClick_txtfield.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.delete_Search_History_icon_By);
            searchPageObj.delete_Search_History_icon.click();
        }
        else
        {
            do {
                driver.navigate().back();
                hideKeyboard();
            } while (!isExist(searchPageObj.searchBeforeClick_txtfield_MM));
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.delete_Search_History_icon_By_MM);
            searchPageObj.delete_Search_History_icon_MM.click();
        }
    }

    public boolean verifyForDeletedSearchHistory() {
        return (!isExistByText(searchKeyword));
    }




}