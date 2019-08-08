package member.APP.pages;

import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.CheckOutPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 26-April-2019
 */

public class SearchProduct extends Base {
    SearchPageObject searchPageObj = new SearchPageObject();
    CartPageObjects cartPageObjects = new CartPageObjects();
    CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();
    private String productName;

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
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        if ((Integer.parseInt(checkOutPageObjects.product_Price.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) < 150) && (searchType.equalsIgnoreCase("Checkout"))) {
                            driver.navigate().back();
                            continue;
                        }
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (waitWithoutException(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.click();
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
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        if ((Integer.parseInt(checkOutPageObjects.product_Price.get(0).getText().replace("৳ ", "").replaceAll(",", "")) < 100) && (searchType.equalsIgnoreCase("Checkout"))) {
                            driver.navigate().back();
                            continue;
                        }
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (waitWithoutException(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.click();
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
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        if ((Integer.parseInt(checkOutPageObjects.product_Price.get(0).getText().replace("Rs. ", "").replaceAll(",", "")) < 250) && (searchType.equalsIgnoreCase("Checkout"))) {
                            driver.navigate().back();
                            continue;
                        }
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (waitWithoutException(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.click();
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
                        if (searchType.equalsIgnoreCase("Result"))
                            break;
                        waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_By);
                        cartPageObjects.searchProduct_lbl.get(0).click();
                        if (waitWithoutException(cartPageObjects.overseas_Confirm_btn))
                            cartPageObjects.overseas_Confirm_btn.click();
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
                if (searchType.equalsIgnoreCase("Result"))
                    break;
                waitUntilPresentOfElementBy(cartPageObjects.searchProduct_lbl_MM_By);
                cartPageObjects.searchProduct_lbl_MM.get(0).click();
                if (waitWithoutException(cartPageObjects.overseas_Confirm_btn_MM))
                    cartPageObjects.overseas_Confirm_btn_MM.click();
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
        String[] searchWord;
        searchWord = searchKeyword.split(" ", 2);
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            System.out.println("This is the search lbl" + searchPageObj.searchResult_lbl.get(0).getText());
            return searchPageObj.searchResult_lbl.get(0).getText().contains(searchWord[0]);
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            return searchPageObj.searchResult_lbl_MM.get(0).getText().contains(searchWord[0]);
        }
    }

    public void navigateBackToTheHomeScreen() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            do {
                driver.navigate().back();
            }
            while (!isExist(searchPageObj.searchBeforeClick_txtfield));

        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            do {
                driver.navigate().back();
            }
            while (!isExist(searchPageObj.searchBeforeClick_txtfield_MM));
        }
    }

    public void searchUsingHistory(String searchKeyword) {
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
                if (isExist(searchPageObj.search_Suggestion_lstItem)) {
                    if (!(searchPageObj.search_Suggestion_lstItem.get(0).getText().contains(suggestionLetter.toString())))
                        return false;
                }
            }

        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            for (int i = 0; i < suggestionKeywordArray.length; i++) {
                suggestionLetter.append(suggestionKeywordArray[i]);
                searchPageObj.searchAfterClick_txtfield_MM.sendKeys(suggestionLetter);
                if (isExist(searchPageObj.search_Suggestion_lstItem_MM)) {
                    if (!(searchPageObj.search_Suggestion_lstItem_MM.get(0).getText().contains(suggestionLetter.toString())))
                        return false;
                }

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
            return (isExist(searchPageObj.did_You_Mean_lbl));
        else
            return (isExist(searchPageObj.did_You_Mean_lbl_MM));
    }
}