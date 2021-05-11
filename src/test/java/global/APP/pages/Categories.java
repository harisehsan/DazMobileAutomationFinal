package global.APP.pages;

import global.APP.getProperty.CategoriesGetProperty;
import global.APP.pageObjects.CategoriesPageObject;
import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 17-October-2019
 */

public class Categories extends Base {

    CategoriesPageObject categoriesPageObject =  new CategoriesPageObject();
    CategoriesGetProperty categoriesGetProperty = new CategoriesGetProperty();

    public Categories(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), categoriesPageObject);
    }

    public void scrollDownToCategoriesSection() {
        int tries = 25;
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            for (int i = 0; i < tries; i++) {
                if (isExist(categoriesPageObject.categories_lbl)) {
                    if (categoriesPageObject.categories_lbl.get(categoriesPageObject.categories_lbl.size()-1).getText().equalsIgnoreCase("Categories")) {
                        swiptToBottom();
                        return;
                       }
                    else
                        swiptToBottom();
                }
                else
                    swiptToBottom();
            }
        }
        else
        {
            for (int i = 0; i < tries; i++) {
                if (isExist(categoriesPageObject.categories_lbl_MM)) {
                    if (categoriesPageObject.categories_lbl_MM.get(categoriesPageObject.categories_lbl_MM.size()-1).getText().equalsIgnoreCase("Categories")) {
                        swiptToBottom();
                        return;
                    }
                    else
                        swiptToBottom();
                }
                else
                    swiptToBottom();
            }
        }
        throw new RuntimeException("Categories Section is not available on Homepage!");
    }

    public void clickOnShopMoreButton()
    {
        categoriesPageObject.shop_More_for_Categories_btn.get(0).click();
    }

    public boolean checkTheExistenceOfJustForYou()
    {
        waitWithoutExceptionForElements(categoriesPageObject.just_For_you_title_lbl);
        return (isExist(categoriesPageObject.just_For_you_title_lbl));
    }

    public boolean switchBetweenCategoryTabs() throws IOException {
        List<String> categoriesTabsList = categoriesGetProperty.categoriesTabs();
        List<String> categoriesTitleList = categoriesGetProperty.categoriesTitle();
        for (int i=0; i<categoriesTabsList.size();i++)
        {
            findElementByString(categoriesTabsList.get(i)).click();
            if (!containsTextIsExist(categoriesTitleList.get(i)))
                return false;
        }
        return true;
    }

    public boolean switchBetweenGoodsTab() throws IOException {
        List<String> goodsTabList = categoriesGetProperty.goodsTab();
        waitWithoutException(findElementByString(goodsTabList.get(0)));
        int tries = 30;
        if (!(ThreadStorage.get("env").equalsIgnoreCase("mm.live"))) {
            for (int i = 0; i < categoriesGetProperty.goodsTab().size(); i++) {
                findElementByString(goodsTabList.get(i)).click();
                waitUntilPresentOfElementBy(categoriesPageObject.product_Name_By);
                for (int j=0; j<tries; j++)
                {
                    if (!categoriesPageObject.search_box.getText().equalsIgnoreCase("Catalogue"))
                     break;
                }
                if (!categoriesPageObject.search_box.getText().contains(goodsTabList.get(i).substring(0,6)))
                    return false;
                else
                    driver.navigate().back();
            }
        }
        else
        {
            for (int i = 0; i < categoriesGetProperty.goodsTab().size(); i++) {
                findElementByString(goodsTabList.get(i)).click();
                waitUntilPresentOfElementBy(categoriesPageObject.product_Name_By_MM);
                for (int j=0; j<tries; j++)
                {
                    if (!categoriesPageObject.search_box_MM.getText().equalsIgnoreCase("Catalogue"))
                        break;
                }
                if (!categoriesPageObject.search_box_MM.getText().contains(goodsTabList.get(i).substring(0,6)))
                    return false;
                else
                    driver.navigate().back();
            }
        }
        return true;
    }
}