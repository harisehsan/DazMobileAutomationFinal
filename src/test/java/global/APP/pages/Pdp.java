package global.APP.pages;

import cucumber.api.java.sl.In;
import global.APP.getProperty.PdpGetProperty;
import global.APP.getProperty.ProductInfoGetProperty;
import global.APP.getProperty.ProductInfoSetProperty;
import global.APP.getProperty.VoucherGetProperty;
import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.CheckOutPageObjects;
import global.APP.pageObjects.PdpPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import member.APP.pageObjects.WishlistPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-November-2019
 */

public class Pdp extends Base {
    PdpPageObject pdpPageObject = new PdpPageObject();
    SearchPageObject searchPageObj = new SearchPageObject();
    PdpGetProperty pdpGetProperty = new PdpGetProperty();
    CartPageObjects cartPageObjects = new CartPageObjects();
    VoucherGetProperty voucherGetProperty = new VoucherGetProperty();
    WishlistPageObjects wishlistPageObjects = new WishlistPageObjects();
    ProductInfoSetProperty productInfoSetProperty = new ProductInfoSetProperty();
    ProductInfoGetProperty productInfoGetProperty = new ProductInfoGetProperty();
    CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();

    private int tries = 25;
    private String productName;

    public Pdp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pdpPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
        PageFactory.initElements(new AppiumFieldDecorator(driver), wishlistPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
    }

    public void serchProductForPDP(String searchType) throws IOException {
       int searchProduct=0;
       if (searchType.contains("Panel"))
           searchProduct=1;
       else if(searchType.contains("Voucher Collect"))
           searchProduct=2;
       else if(searchType.contains("Free Gift"))
           searchProduct=3;
       else if (searchType.contains("Combo"))
           searchProduct=4;
       else if (searchType.contains("Voucher Code"))
           searchProduct=5;
       else if(searchType.contains("Save more"))
           searchProduct=6;
       else if (searchType.contains("B1G1"))
           searchProduct=7;
       else if (searchType.contains("Digital"))
           searchProduct=8;
       else if (searchType.contains("CNIC1"))
           searchProduct=9;
       else if (searchType.contains("CNIC2"))
           searchProduct=10;
       else if (searchType.contains("CNIC3"))
           searchProduct=11;
       else if (searchType.contains("CNIC4"))
           searchProduct=12;
        else if (searchType.contains("Size Chart"))
           searchProduct=13;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By);
            searchPageObj.searchBeforeClick_txtfield.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            switch (System.getProperty("env")) {
                case "pk.live": {
                    searchPageObj.searchAfterClick_txtfield.sendKeys(pdpGetProperty.productPK().get(searchProduct));
                }
                break;
                case "bd.live": {
                    searchPageObj.searchAfterClick_txtfield.sendKeys(pdpGetProperty.productBD().get(searchProduct));
                }
                break;
                case "lk.live": {
                    searchPageObj.searchAfterClick_txtfield.sendKeys(pdpGetProperty.productLK().get(searchProduct));
                }
                break;
                case "np.live": {
                    searchPageObj.searchAfterClick_txtfield.sendKeys(pdpGetProperty.productNP().get(searchProduct));
                }
                break;
            }
            searchPageObj.search_btn.click();
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            searchPageObj.searchAfterClick_txtfield_MM.sendKeys(pdpGetProperty.productMM().get(searchProduct));
            searchPageObj.search_btn_MM.click();
        }
    }

    public void getProductFromPropertyFile(String searchType) throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By);
            searchPageObj.searchBeforeClick_txtfield.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            searchPageObj.searchAfterClick_txtfield.sendKeys(pdpGetProperty.getProductSKU(searchType));
            searchPageObj.search_btn.click();
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchBeforeClick_txtfield_By_MM);
            searchPageObj.searchBeforeClick_txtfield_MM.get(0).click();
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            searchPageObj.searchAfterClick_txtfield_MM.sendKeys(pdpGetProperty.getProductSKU(searchType));
            searchPageObj.search_btn_MM.click();
        }

    }

    public void gotoPdpPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            searchPageObj.searchResult_lbl.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
            try {
                productName = pdpPageObject.product_Title_lbl.get(0).getText();
            } catch (Exception e) {
                e.printStackTrace();
                if (isExist(pdpPageObject.product_Title_lbl)) {
                    productName = pdpPageObject.product_Title_lbl.get(0).getText();
                }
            }
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            searchPageObj.searchResult_lbl_MM.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn_MM))
                searchPageObj.ok_Got_It_btn_MM.get(0).click();
            try {
                productName = pdpPageObject.product_Title_lbl_MM.get(0).getText();
            } catch (Exception e) {
                e.printStackTrace();
                if (isExist(pdpPageObject.product_Title_lbl_MM)) {
                    productName = pdpPageObject.product_Title_lbl_MM.get(0).getText();
                }
            }
        }
    }

    public void pdpVideo() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (isExist(pdpPageObject.video_icon)) {
                pdpPageObject.video_icon.get(0).click();
                waitUntilPresentOfElementBy(pdpPageObject.video_Close_btn_By);
                driver.navigate().back();
            }
        } else {
            if (isExist(pdpPageObject.video_icon_MM)) {
                pdpPageObject.video_icon_MM.get(0).click();
                waitUntilPresentOfElementBy(pdpPageObject.video_Close_btn_By_MM);
                driver.navigate().back();
            }
        }

    }

    public boolean viewImagesOnPDP() {
        int[] imageQuantity = new int[2];
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (isExist(pdpPageObject.picture_Number_lbl)) {
                String Quantity[] = pdpPageObject.picture_Number_lbl.get(0).getText().split("/");
                for (int j = 0; j < (Integer.parseInt(Quantity[1])); j++) {
                    for (int i = 0; i < Quantity.length; i++) {
                        imageQuantity[i] = Integer.parseInt(Quantity[i]);
                    }
                    if (imageQuantity[0] < imageQuantity[1])
                        swipeHorizontallyWithInElement(pdpPageObject.pdp_image);
                    else {
                        swipeHorizontallyWithInElement(pdpPageObject.pdp_image);
                        break;
                    }
                    Quantity = pdpPageObject.picture_Number_lbl.get(0).getText().split("/");
                }
                return isExist(pdpPageObject.picture_Number_lbl);
            }

        } else {
            if (isExist(pdpPageObject.picture_Number_lbl_MM)) {
                String Quantity[] = pdpPageObject.picture_Number_lbl_MM.get(0).getText().split("/");
                for (int j = 0; j < (Integer.parseInt(Quantity[1])); j++) {
                    for (int i = 0; i < Quantity.length; i++) {
                        imageQuantity[i] = Integer.parseInt(Quantity[i]);
                    }
                    if (imageQuantity[0] < imageQuantity[1])
                        swipeHorizontallyWithInElement(pdpPageObject.pdp_image_MM);
                    else {
                        swipeHorizontallyWithInElement(pdpPageObject.pdp_image_MM);
                        break;
                    }
                    Quantity = pdpPageObject.picture_Number_lbl_MM.get(0).getText().split("/");
                }
                return isExist(pdpPageObject.picture_Number_lbl_MM);
            }
        }
        return true;
    }

    public void bigPictureMode() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            pdpPageObject.pdp_image.click();
        } else {
            pdpPageObject.pdp_image_MM.click();
        }
    }

    public boolean checkforAllImages() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.product_images_By);
            for (int i = (pdpPageObject.product_images.size() - 1); i >= 0; i--) {
                pdpPageObject.product_images.get(i).click();
            }
            return (isExist(pdpPageObject.product_images));
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.product_images_MM_By);
            for (int i = (pdpPageObject.product_images_MM.size() - 1); i >= 0; i--) {
                pdpPageObject.product_images_MM.get(i).click();
            }
            return (isExist(pdpPageObject.product_images_MM));
        }
    }

    public boolean backToPDPFromBigPicture() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            pdpPageObject.picture_Close_btn.click();
            return (isExist(pdpPageObject.product_Title_lbl));
        } else {
            pdpPageObject.picture_Close_btn_MM.click();
            return (isExist(pdpPageObject.product_Title_lbl_MM));
        }
    }

    public boolean verifyTitleAndPrice() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return (!pdpPageObject.product_Title_lbl.get(0).getText().equalsIgnoreCase("")
                    && !pdpPageObject.displayed_Price_lbl.get(0).getText().equalsIgnoreCase("")
                    || !pdpPageObject.original_Price_lbl.get(0).getText().equalsIgnoreCase("")
                    || !pdpPageObject.discount_Rate_lbl.get(0).getText().equalsIgnoreCase(""));

        } else {
            return (!pdpPageObject.product_Title_lbl_MM.get(0).getText().equalsIgnoreCase("")
                    && !pdpPageObject.displayed_Price_lbl_MM.get(0).getText().equalsIgnoreCase("")
                    || !pdpPageObject.original_Price_lbl_MM.get(0).getText().equalsIgnoreCase("")
                    || !pdpPageObject.discount_Rate_lbl_MM.get(0).getText().equalsIgnoreCase(""));
        }
    }

    public boolean verifyRatingWishlistAndShareIcon() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return (isExist(pdpPageObject.rating_bar)
                    && isExist(pdpPageObject.wishlist_icon)
                    && isExist(pdpPageObject.share_icon));
        } else {
            return (isExist(pdpPageObject.rating_bar_MM)
                    && isExist(pdpPageObject.wishlist_icon_MM)
                    && isExist(pdpPageObject.share_icon_MM));
        }
    }

    public boolean verifyTheShareDetails() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           swiptToBottom();
            pdpPageObject.share_icon.get(0).click();
            return (isExist(pdpPageObject.share_Title_lbl));
        } else {
            swiptToBottom();
            pdpPageObject.share_icon_MM.get(0).click();
            return (isExist(pdpPageObject.share_Title_lbl_MM));
        }
    }

    public boolean verifyTheExistenceOfSpecification() {
        for (int i = 0; i < tries; i++) {
            if (isExist(pdpPageObject.specifications_lbl)) {
                return true;
            } else
                swiptToBottom();
        }
        return false;
    }

    public boolean verifyTheContentsOfSpecifications() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.specifications_Contents_lbl_By);
            return (pdpPageObject.specifications_Contents_lbl.size() >= 1);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.specifications_Contents_lbl_MM_By);
            return (pdpPageObject.specifications_Contents_lbl_MM.size() >= 1);
        }
    }

    public boolean verifyTheSpecificationInformationOnPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return (!pdpPageObject.specification_Information_On_Pdp.getText().equalsIgnoreCase(""));
        } else {
            return (!pdpPageObject.specification_Information_On_Pdp_MM.getText().equalsIgnoreCase(""));
        }
    }

    public void clickToEnterSpecificationPopPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            pdpPageObject.specifications_lbl.get(0).click();
        } else {
            pdpPageObject.specifications_lbl.get(0).click();
        }
    }

    public boolean verifyTheExistenceOfDeliveryOptions() {

        for (int i = 0; i < tries; i++) {
            if (isExist(pdpPageObject.deliver_Options_lbl)) {
                swiptToBottom();
                return true;
            } else
                swiptToBottom();
        }
        return false;
    }

    public boolean verifyTheExistenceOfDeliveryOptionsContentOnPdp() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return (!pdpPageObject.item_content_lbl.get(0).getText().equalsIgnoreCase("") && isExist(pdpPageObject.map_icon));
        } else {
            return (!pdpPageObject.item_content_lbl_MM.get(0).getText().equalsIgnoreCase("") && isExist(pdpPageObject.map_icon_MM));
        }
    }

    public void clickOnDeliveryOptionToOpenPopPage() {
        pdpPageObject.deliver_Options_lbl.get(0).click();
    }

    public boolean verifyTheContentOfDeliverOptionsOnPopPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.popup_header_lbl_By);
            return (isExist(pdpPageObject.popup_header_lbl) && isExist(pdpPageObject.product_Title_lbl));
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.popup_header_lbl_By_MM);
            return (isExist(pdpPageObject.popup_header_lbl_MM) && isExist(pdpPageObject.product_Title_lbl_MM));
        }
    }

    public boolean verifyTheExistenceOfServices() {
        for (int i = 0; i < tries; i++) {
            if (isExist(pdpPageObject.service_lbl)) {
                return true;
            } else
                swiptToBottom();
        }
        return false;
    }

    public void clickOnServices() {
        pdpPageObject.service_lbl.get(0).click();
    }

    public boolean verifyTheExistenceOfRatingAndReview() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.rating_Review_title)) {
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.rating_Review_title_MM)) {
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        }
    }

    public boolean verifyTheExistenceAndClickOnViewAll() {
      boolean result =false;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if(isExist(pdpPageObject.view_all_rating_and_review_btn)) {
                result = true;
                pdpPageObject.view_all_rating_and_review_btn.get(0).click();
            }
            else
                result = true;

        } else {
            if(isExist(pdpPageObject.view_all_rating_and_review_btn_MM)) {
                result = true;
                pdpPageObject.view_all_rating_and_review_btn_MM.get(0).click();
            }
            else
                result = true;

        }
        return result;
    }

    public boolean checkTheExistanceOfQASection(){
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            while (!isExist(pdpPageObject.qa_Title_lbl)){
            swiptToBottom();
            if(isExist(pdpPageObject.qa_Title_lbl)){
                return true;
                }
            }
            return false;
        } else {
            while (!isExist(pdpPageObject.qa_Title_lbl_MM)){
                swiptToBottom();
                if(isExist(pdpPageObject.qa_Title_lbl_MM)){
                    return true;
                }
            }
            return false;
        }

    }

    public boolean checkTheExistenceofQaSection() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.qa_Title_lbl)) {
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.qa_Title_lbl_MM)) {
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        }
    }

    public void clickOnViewAllButton() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (isExist(pdpPageObject.qa_View_All_btn)) {
                pdpPageObject.qa_View_All_btn.get(0).click();
                waitUntilPresentOfElementBy(pdpPageObject.qa_page_title_lbl_By);
                navigateBackToPDP();
            }

        } else {
            if (isExist(pdpPageObject.qa_View_All_btn_MM)) {
                pdpPageObject.qa_View_All_btn_MM.get(0).click();
                waitUntilPresentOfElementBy(pdpPageObject.qa_page_title_lbl_By);
                navigateBackToPDP();
            }
        }
    }

    public boolean verifyTheExistenceAndClickOnAskQuestion() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.ask_Question_btn)) {
                    pdpPageObject.ask_Question_btn.get(0).click();
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.ask_Question_btn_MM)) {
                    pdpPageObject.ask_Question_btn_MM.get(0).click();
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        }
    }

    public boolean iShouldBeOnAskQuestionPage() {
        waitWithoutExceptionForElements(pdpPageObject.qa_page_title_lbl);
        return isExist(pdpPageObject.qa_page_title_lbl);
    }

    public void iclickOnStore() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            pdpPageObject.store_btn.click();
        } else {
            pdpPageObject.store_btn_MM.click();
        }
    }

    public void clickOnFollowStoreButton() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (isExist(searchPageObj.got_It_Store_btn))
                searchPageObj.got_It_Store_btn.get(0).click();
            pdpPageObject.store_Follow_lst_ele_btn.get(0).click();
        } else {
            if (isExist(searchPageObj.got_It_Store_btn_MM))
                searchPageObj.got_It_Store_btn_MM.get(0).click();
            pdpPageObject.store_Follow_lst_ele_btn_MM.get(0).click();
        }
    }

    public boolean iShouldFollowedThatStore() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (!isExist(pdpPageObject.store_Follow_lst_ele_btn)) {
                driver.navigate().back();
                iclickOnStore();
            }
            return pdpPageObject.store_Follow_lst_ele_btn.get(0).getText().contains("Following");
        }
        else {
            if (!isExist(pdpPageObject.store_Follow_lst_ele_btn_MM)) {
                driver.navigate().back();
                iclickOnStore();
            }
            return pdpPageObject.store_Follow_lst_ele_btn_MM.get(0).getText().contains("Following");
        }
    }

    public boolean iShouldBeOnThePDPPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            return (isExist(pdpPageObject.product_Title_lbl));
        else
            return (isExist(pdpPageObject.product_Title_lbl_MM));
    }

    public boolean verifyTheExistanceOFRecomendedBySellerSection(){
            if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
              int tries = 0;
                while (!isExist(pdpPageObject.recommended_By_Seller_lbl) && tries < 30 ){
                    swiptToBottom();
                    tries++;
                    if(isExist(pdpPageObject.recommended_By_Seller_lbl)){
                        return true;
                    }
                }
                return false;
            } else {
               int tries = 0;
                while (!isExist(pdpPageObject.recommended_By_Seller_lbl_MM) && tries < 30){
                    swiptToBottom();
                    tries++;
                    if(isExist(pdpPageObject.recommended_By_Seller_lbl_MM)){
                        return true;
                    }
                }
                return false;
            }

        }

    public boolean verifyTheExistenceOfRecommendedBySellerSection() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.recommended_By_Seller_lbl)) {
                    swiptToBottom();
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.recommended_By_Seller_lbl_MM)) {
                    swiptToBottom();
                    return true;
                } else
                    swiptToBottom();
            }
            return false;
        }
    }

    public boolean iClickOnTheRecommendedProduct() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < 6; i++) {
                if (isExist(pdpPageObject.recommended_By_Seller_Products)) {
                    pdpPageObject.recommended_By_Seller_Products.get(0).click();
                    if (isExist(cartPageObjects.overseas_Confirm_btn))
                        cartPageObjects.overseas_Confirm_btn.get(0).click();
                    if (isExist(searchPageObj.ok_Got_It_btn))
                        searchPageObj.ok_Got_It_btn.get(0).click();
                    return true;
                } else
                    swiptToBottom();
            }

        }
        else {
            for (int i = 0; i < 6; i++) {
                if (isExist(pdpPageObject.recommended_By_Seller_Products_MM)) {
                    pdpPageObject.recommended_By_Seller_Products_MM.get(0).click();
                    if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                        cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
                    if (isExist(searchPageObj.ok_Got_It_btn_MM))
                        searchPageObj.ok_Got_It_btn_MM.get(0).click();
                    return true;
                } else
                    swiptToBottom();
            }
        }
        return false;
    }

    public boolean navigateToHomePageFromPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By);
//            pdpPageObject.menu_List.get(1).click();
            pdpPageObject.menu_List.get(0).click();
            return isExist(searchPageObj.searchBeforeClick_txtfield);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
//            pdpPageObject.menu_List_MM.get(1).click();
            pdpPageObject.menu_List_MM.get(0).click();
            return isExist(searchPageObj.searchBeforeClick_txtfield_MM);
        }
    }

    public void clickEleInPdpHeaderDropdown(String arg) {
    List<WebElement> ele = pdpPageObject.menu_List.stream().filter(i -> i.getText().contains(arg)).collect(Collectors.toList());
        ele.get(0).click();
    }


    public boolean navigateToLoginFromPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By);
            pdpPageObject.menu_List.get(0).click();
            return isExist(wishlistPageObjects.email_Login_btn);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
            pdpPageObject.menu_List_MM.get(0).click();
            return isExist(wishlistPageObjects.email_Login_btn_MM);
        }
    }

    public void navigateBackToPDP() {
        driver.navigate().back();
    }

    public boolean navigateToSearchFromPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By);
//            pdpPageObject.menu_List.get(3).click();
            pdpPageObject.menu_List.get(2).click();
            return (isExist(pdpPageObject.searchAfterClick_txtfield));
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
//            pdpPageObject.menu_List_MM.get(3).click();
            pdpPageObject.menu_List_MM.get(2).click();
            return (isExist(pdpPageObject.searchAfterClick_txtfield_MM));
        }
    }

    public void searchTheAvailableProduct() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By);
            searchPageObj.search_btn.click();
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchAfterClick_txtfield_By_MM);
            searchPageObj.search_btn_MM.click();
        }
    }

    public boolean navigateToMessagesFromPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By);
//            pdpPageObject.menu_List.get(4).click();
            pdpPageObject.menu_List.get(3).click();
            return isExist(pdpPageObject.messages_Header_lbl);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
//            pdpPageObject.menu_List_MM.get(4).click();
            pdpPageObject.menu_List_MM.get(3).click();
            return isExist(pdpPageObject.messages_Header_lbl);
        }
    }

    public boolean navigateToNeedHelpFromPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By);
//            pdpPageObject.menu_List.get(6).click();
            pdpPageObject.menu_List.get(5).click();
            return isExist(pdpPageObject.help_Header_lbl);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
//            pdpPageObject.menu_List_MM.get(6).click();
            pdpPageObject.menu_List_MM.get(5).click();
            return isExist(pdpPageObject.help_Header_lbl);
        }
    }

    public boolean scrollToElevatorMenu() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.elevator_tab))
                    return true;
                else
                    swiptToBottom();
            }
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(pdpPageObject.elevator_tab_MM))
                    return true;
                else
                    swiptToBottom();
            }
        }
        return false;
    }

    public void navigateToEachElevatorMenu() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i = pdpPageObject.elevator_tab.size() - 1; i >= 0; i--)
                pdpPageObject.elevator_tab.get(i).click();
        } else {
            for (int i = pdpPageObject.elevator_tab_MM.size() - 1; i >= 0; i--)
                pdpPageObject.elevator_tab_MM.get(i).click();
        }
    }

    public boolean verifyTheExistenceOfDarazMall() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.product_Title_lbl_By);
            return (pdpPageObject.product_Title_lbl.get(0).getText().startsWith("0"));
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.product_Title_lbl_By_MM);
            return (pdpPageObject.product_Title_lbl_MM.get(0).getText().startsWith("0"));
        }
    }

    public boolean verifyTheDarazMallServices()
    {
       waitWithoutExceptionForElements(pdpPageObject.authentic_lbl);
       return (isExist(pdpPageObject.authentic_lbl) && isExist(pdpPageObject.easy_Return_lbl));
    }

    public boolean verifyTheExistenceOfVariationAndClickOnIt()
    {
        for(int i=0; i<tries; i++)
        {
            if (isExist(pdpPageObject.variation_lbl))
            {
                pdpPageObject.variation_lbl.get(0).click();
                return true;
            }
            else
                swiptToBottom();
        }
        return false;
    }

    public void switchBetweenDifferentSKUs() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.sku_Selector_btn_By);
            for (int i = 0; i < pdpPageObject.sku_Selector_btn.size(); i++) {
                {
                    pdpPageObject.sku_Selector_btn.get(i).click();
                    productInfoSetProperty.setProductSize(pdpPageObject.sku_Selector_btn.get(i).getText());
                }

            }

        } else {
            waitUntilPresentOfElementBy(pdpPageObject.sku_Selector_btn_By_MM);
            for (int i = 0; i < pdpPageObject.sku_Selector_btn_MM.size(); i++) {
                pdpPageObject.sku_Selector_btn_MM.get(i).click();
                productInfoSetProperty.setProductSize(pdpPageObject.sku_Selector_btn_MM.get(i).getText());
            }
        }
    }

    public boolean changeQuantity() throws IOException {
        int j=0;
       do
        {
            scrollDownMultipleTries(2);
        } while(!isExistByText("Quantity"));
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            while (Integer.parseInt(pdpPageObject.quantity_txtBox.getText()) < 2 && j<2 ) {
                pdpPageObject.quantity_Increase_btn.click();
                j++;
            }
               productInfoSetProperty.setProductQuantity(pdpPageObject.quantity_txtBox.getText());
               return (Integer.parseInt(pdpPageObject.quantity_txtBox.getText()) >= 1);
        }
        else
            {
            while (Integer.parseInt(pdpPageObject.quantity_txtBox_MM.getText()) < 2 && j<2) {
                pdpPageObject.quantity_Increase_btn_MM.click();
                j++;
            }
            productInfoSetProperty.setProductQuantity(pdpPageObject.quantity_txtBox_MM.getText());
            return (Integer.parseInt(pdpPageObject.quantity_txtBox_MM.getText()) >= 1);
        }
    }

    public boolean verifyTheChatPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if (isExist(pdpPageObject.chat_ok_btn))
                pdpPageObject.chat_ok_btn.get(0).click();
            return (isExist(pdpPageObject.msg_Center_txtBox));
        } else {
            if (isExist(pdpPageObject.chat_ok_btn_MM))
                pdpPageObject.chat_ok_btn_MM.get(0).click();
            return (isExist(pdpPageObject.msg_Center_txtBox_MM));
        }
    }

    public boolean clickOnChat()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           if (isExist(pdpPageObject.chat_icon)) {
               pdpPageObject.chat_icon.get(0).click();
               return true;
           }
           else
               return false;
        }
        else
        {
          if (isExist(pdpPageObject.chat_icon_MM)) {
              pdpPageObject.chat_icon_MM.get(0).click();
              return true;
          }
          else
              return false;
        }
    }

    public boolean verifyTheExistenceOfVoucher()
    {
        for (int i=0; i<tries;i++)
        {
           if(isExist(pdpPageObject.voucher_Title_lbl))
               return true;
           else
              swiptToBottom();
        }
        return false;
    }

    public void clickOnVoucher()
    {
        pdpPageObject.voucher_Title_lbl.get(0).click();
    }

    public boolean checkForVoucherSuccessMessage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            if (isExist(pdpPageObject.voucher_Success_Message_snackbar))
                return true;
            else
            {
                try {
                    searchPageObj.ok_Got_It_btn.get(0).click();
                    return (pdpPageObject.voucher_Success_Message_snackbar.get(0).getText().contains("Copied successfully!"));
                } catch (Exception e) {
                    e.printStackTrace();
                    return (pdpPageObject.voucher_Success_Message_snackbar.get(0).getText().contains("Copied successfully!"));
                }
            }

        else {
            if (isExist(pdpPageObject.voucher_Success_Message_snackbar_MM))
                return true;
            else
            {
                try {
                    searchPageObj.ok_Got_It_btn.get(0).click();
                    return (pdpPageObject.voucher_Success_Message_snackbar_MM.get(0).getText().contains("Copied successfully!"));
                } catch (Exception e) {
                    e.printStackTrace();
                    return (pdpPageObject.voucher_Success_Message_snackbar_MM.get(0).getText().contains("Copied successfully!"));
                }
            }
        }
    }

    public void clickOnCollectButton()
    {
        waitUntilPresentOfElementBy(pdpPageObject.voucher_Collect_btn_By);
        pdpPageObject.voucher_Collect_btn.click();
    }

    public boolean verifyTheExistenceOFPromotion(String productType)
    {
        for (int i=0; i<tries;i++)
        {
            if (containsTextIsExist(productType))
                return true;
            else
                swiptToBottom();
        }
        return false;
    }

    public boolean OpenThePromotionPopupAndVerifyThePromotion(String productType)
    {
        findElementByTextUsingContainsString(productType).click();
        return containsTextIsExist(productType);
    }

    public void clickOnVoucherCodeCopyButton() throws IOException {
        waitUntilPresentOfElementBy(pdpPageObject.voucher_Copy_btn_By);
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            voucherGetProperty.setCorrectVoucherCode(pdpPageObject.voucher_Code_lbl.getText());
        else
            voucherGetProperty.setCorrectVoucherCode(pdpPageObject.voucher_Code_lbl_MM.getText());
        pdpPageObject.voucher_Copy_btn.click();
    }

    public boolean verifyTheExistenceOfBuyMoreSaveMoreOnPDP(String promotionType)
    {
        for (int i=0; i<tries;i++)
        {
            if (isExist(pdpPageObject.promotion_lbl)) {
                pdpPageObject.promotion_lbl.get(0).click();
                return (containsTextIsExist(promotionType));
            }
            else
                swiptToBottom();
        }
        return false;
    }

    public boolean verifyThePromoSavedAmount(int cartIndex)
    {
       waitWithoutExceptionForElements(pdpPageObject.promo_Saved_lbl);
       if (isExist(pdpPageObject.promo_Saved_lbl) && Integer.parseInt(pdpPageObject.promo_Saved_Price_lbl.get(0).getText().replaceAll("\\D+","").replaceAll(",",""))>0)
           return true;
       else
       {
           if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
               waitUntilPresentOfElementBy(pdpPageObject.cart_Item_container_By);
               pdpPageObject.cart_Item_container.get(cartIndex).findElement(pdpPageObject.item_Count_drpDown_By).click();
               waitUntilPresentOfElementBy(pdpPageObject.item_Count_lbl_By);
               pdpPageObject.item_Count_lbl.click();
               waitUntilPresentOfElementBy(pdpPageObject.confirm_btn_By);
               pdpPageObject.confirm_btn.click();
           }
           else
           {
               waitUntilPresentOfElementBy(pdpPageObject.cart_Item_container_By_MM);
               pdpPageObject.cart_Item_container_MM.get(cartIndex).findElement(pdpPageObject.item_Count_drpDown_By_MM).click();
               waitUntilPresentOfElementBy(pdpPageObject.item_Count_lbl_By);
               pdpPageObject.item_Count_lbl.click();
               waitUntilPresentOfElementBy(pdpPageObject.confirm_btn_By_MM);
               pdpPageObject.confirm_btn_MM.click();
           }
           return (isExist(pdpPageObject.promo_Saved_lbl) && Integer.parseInt(pdpPageObject.promo_Saved_Price_lbl.get(0).getText().replaceAll("\\D+","").replaceAll(",",""))>0);
       }
    }

    public int selectProductInCart() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By);
            cartPageObjects.ok_Got_It_btn.get(0).click();
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); ++i) {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().contains(productName)) {
                    if (cartPageObjects.product_chkbox.get(i).getAttribute("checked").equalsIgnoreCase("false"))
                        cartPageObjects.product_chkbox.get(i).click();
                    return i;
                }
            }
            throw new RuntimeException("Required Product is not added to cart!");
        } else {
            waitUntilPresentOfElementBy(cartPageObjects.ok_Got_It_btn_By_MM);
            cartPageObjects.ok_Got_It_btn_MM.get(0).click();
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl_MM.size(); ++i) {
                if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().contains(productName)) {
                    if (cartPageObjects.product_chkbox_MM.get(i).getAttribute("checked").equalsIgnoreCase("false"))
                        cartPageObjects.product_chkbox_MM.get(i).click();
                    return i;
                }
            }
            throw new RuntimeException("Required Product is not added to cart!");
        }
    }
    public boolean verifyB1G1QuantityInCart(String quantity, int cartIndex) {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(pdpPageObject.product_Count_In_Cart_By);
           return (Integer.parseInt(pdpPageObject.cart_Item_container.get(cartIndex).findElement(pdpPageObject.product_Count_In_Cart_By).getText()) >= Integer.parseInt(quantity));
        }
        else
        {
            waitUntilPresentOfElementBy(pdpPageObject.product_Count_In_Cart_By_MM);
            return (Integer.parseInt(pdpPageObject.cart_Item_container_MM.get(cartIndex).findElement(pdpPageObject.product_Count_In_Cart_By_MM).getText()) >= Integer.parseInt(quantity));
        }
    }

    public boolean verifyB1G1QuantityOnCheckOut()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            for (int i=0;i<tries;i++) {
                if (isExist(pdpPageObject.product_Count_In_Chekout_lbl))
                    return (Integer.parseInt(pdpPageObject.product_Count_In_Chekout_lbl.get(0).getText()) == 2);
                else
                    swiptToBottom();
            }
        }
        else
        {
            for (int i=0;i<tries;i++) {
                if (isExist(pdpPageObject.product_Count_In_Chekout_lbl_MM))
                    return (Integer.parseInt(pdpPageObject.product_Count_In_Chekout_lbl_MM.get(0).getText()) == 2);
                else
                    swiptToBottom();
            }
        }
        return false;
    }

    public boolean verifyBuyMoreAndSaveMoreInCart()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitWithoutExceptionForElements(pdpPageObject.product_Cart_Title_lbl);
            return (isExist(pdpPageObject.product_Cart_Title_lbl));
        }
        else
        {
            waitWithoutExceptionForElements(pdpPageObject.product_Cart_Title_lbl_MM);
            return (isExist(pdpPageObject.product_Cart_Title_lbl_MM));
        }
    }

    public void saveProductTitleAndPrice() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            productInfoSetProperty.setProductName(pdpPageObject.product_Title_lbl.get(0).getText());
            productInfoSetProperty.setProductPrice(pdpPageObject.displayed_Price_lbl.get(0).getText());
        }
        else {
            productInfoSetProperty.setProductName(pdpPageObject.product_Title_lbl_MM.get(0).getText());
            productInfoSetProperty.setProductPrice(pdpPageObject.displayed_Price_lbl_MM.get(0).getText());
        }
    }

    public boolean verifyTheProductNameAndPriceInCart() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i=0; i<cartPageObjects.product_Title_In_Cart_lbl.size(); i++)
            {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productInfoGetProperty.getProductTitle())) {
                    return  (cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.product_Title_In_Cart_lbl_By).getText().contains(productInfoGetProperty.getProductTitle())
                            && cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.cart_Item_Current_Price_By).getText().contains(productInfoGetProperty.getProductPrice())
                            && Integer.parseInt(cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.cart_Item_Quantity_txt_By).getText()) > 0);
                }
            }
        }
        else
        {
            for (int i=0; i<cartPageObjects.product_Title_In_Cart_lbl_MM.size(); i++)
            {
                if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().equalsIgnoreCase(productInfoGetProperty.getProductTitle())) {
                    return  (cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.product_Title_In_Cart_lbl_By_MM).getText().contains(productInfoGetProperty.getProductTitle())
                            && cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.cart_Item_Current_Price_By_MM).getText().contains(productInfoGetProperty.getProductPrice())
                            && Integer.parseInt(cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.cart_Item_Quantity_txt_By_MM).getText()) > 0);
                }
            }
        }
        return false;
    }

    public boolean verifyProductNameAndPriceInWishlist() throws IOException {

       int tries = 0;
        waitUntilPresentOfElementByString("\uE723");
       while ((!isExistByString(productInfoGetProperty.getProductTitle()) || !isExistByString(productInfoGetProperty.getProductPrice())) && tries < 10)
        {
            swiptToBottom();
            tries++;
        }
       return (isExistByString(productInfoGetProperty.getProductTitle()) && isExistByString(productInfoGetProperty.getProductPrice()));
    }

    public boolean verifyTheProductNameAndPriceAndQuantityAndSizeInCart() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            for (int i=0; i<cartPageObjects.product_Title_In_Cart_lbl.size(); i++)
            {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().equalsIgnoreCase(productInfoGetProperty.getProductTitle())) {
                    return  (cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.product_Title_In_Cart_lbl_By).getText().contains(productInfoGetProperty.getProductTitle())
                            && cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.cart_Item_Current_Price_By).getText().contains(productInfoGetProperty.getProductPrice())
                            && cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.cart_Item_Quantity_txt_By).getText().contains(productInfoGetProperty.getProductQuantity())
                            && cartPageObjects.cart_Item_Container.get(i).findElement(cartPageObjects.cart_product_descripition_By).getText().contains(productInfoGetProperty.getProductSize())
                    );
                }
            }
        }
        else
        {
            for (int i=0; i<cartPageObjects.product_Title_In_Cart_lbl_MM.size(); i++)
            {
                if (cartPageObjects.product_Title_In_Cart_lbl_MM.get(i).getText().equalsIgnoreCase(productInfoGetProperty.getProductTitle())) {
                    return  (cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.product_Title_In_Cart_lbl_By_MM).getText().contains(productInfoGetProperty.getProductTitle())
                            && cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.cart_Item_Current_Price_By_MM).getText().contains(productInfoGetProperty.getProductPrice())
                            && cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.cart_Item_Quantity_txt_By_MM).getText().contains(productInfoGetProperty.getProductQuantity())
                            && cartPageObjects.cart_Item_Container_MM.get(i).findElement(cartPageObjects.cart_product_descripition_By_MM).getText().contains(productInfoGetProperty.getProductSize())
                    );
                }
            }
        }
        return false;
    }

    public boolean verifyTheImpactOfChangedSKU() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
          return (pdpPageObject.product_Size_PDP_lbl.getText().contains(productInfoGetProperty.getProductSize()));
        }
        else
        {
            return (pdpPageObject.product_Size_PDP_lbl_MM.getText().contains(productInfoGetProperty.getProductSize()));
        }
    }

    public void scrollToProductOnCheckout()
    {
        do {
         swiptToBottom();
        }while(!containsTextIsExist("Qty:"));
    }

    public boolean verifyTheProductNameAndPriceAndQuantityAndSizeOnCheckout() throws IOException {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            return  (checkOutPageObjects.item_On_Checkout_lbl.get(0).getText().contains(productInfoGetProperty.getProductTitle())
                    && checkOutPageObjects.current_Price_lbl.getText().contains(productInfoGetProperty.getProductPrice())
                    && checkOutPageObjects.item_Count_lbl.getText().contains(productInfoGetProperty.getProductQuantity())
                    && checkOutPageObjects.product_Description_Checkout_lbl.getText().contains(productInfoGetProperty.getProductSize())

            );
        }
        else
        {
            return  (checkOutPageObjects.item_On_Checkout_lbl_MM.get(0).getText().contains(productInfoGetProperty.getProductTitle())
                    && checkOutPageObjects.current_Price_lbl_MM.getText().contains(productInfoGetProperty.getProductPrice())
                    && checkOutPageObjects.item_Count_lbl_MM.getText().contains(productInfoGetProperty.getProductQuantity())
                    && checkOutPageObjects.product_Description_Checkout_lbl_MM.getText().contains(productInfoGetProperty.getProductSize())

            );
        }
    }

    public void goToCartFromPDPVariationScreen()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
          if (isExist(pdpPageObject.add_To_Cart_Variation_btn))
           pdpPageObject.add_To_Cart_Variation_btn.get(0).click();
        }
        else
        {
            if (isExist( pdpPageObject.add_To_Cart_Variation_btn_MM))
            pdpPageObject.add_To_Cart_Variation_btn_MM.get(0).click();
        }
    }

    public void clickOnSizeChart() {
        if(!System.getProperty("env").equalsIgnoreCase("mm.live")){
            waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.size_Chart_lbl_By,3);
            pdpPageObject.size_Chart_lbl.click();
        }
        else {
            waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.size_Chart_lbl_By_MM,3);
            pdpPageObject.size_Chart_lbl_MM.click();
        }
    }

    public boolean iShouldBeOnSizeChart(){
        return waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.size_Chart_Screen_Label_By, 6);
    }

    public boolean verifyConditionAttributeOnPDP() {
        return (!System.getProperty("env").equalsIgnoreCase("mm.live")) ?
                waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.conditions_Pdp_Label_By, 6) :
                waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.conditions_Pdp_Label_MM_By, 6);
    }

    public boolean verifyConditionBar() {
        return (!System.getProperty("env").equalsIgnoreCase("mm.live")) ?
                waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.condition_bar_image_By, 6) :
                waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.condition_bar_image_MM_By, 6);
    }

    public boolean verifyConditionText() {
        return (!System.getProperty("env").equalsIgnoreCase("mm.live")) ?
                waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.condition_bar_text_By, 6) :
                waitForElementByWithoutExceptionUntillTimeReach(pdpPageObject.condition_bar_text_MM_By, 6);
    }

    public void clickOnConditionBar() {
        if ((!System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            pdpPageObject.condition_Bar_Image_Ele.click();
        } else {
            pdpPageObject.condition_Bar_Image_Ele_MM.click();
        }
    }

    public boolean conditionPopupVerification() {
        return ((!System.getProperty("env").equalsIgnoreCase("mm.live"))) ?
                pdpPageObject.condition_Bar_Title_Ele.isDisplayed() :
                pdpPageObject.condition_Bar_Title_Ele_MM.isDisplayed();
    }

    public boolean conditionPopupTextVerification() {
        return ((!System.getProperty("env").equalsIgnoreCase("mm.live"))) ?
                pdpPageObject.condition_Bar_Title_Ele.isDisplayed() :
                pdpPageObject.condition_Bar_Title_Ele_MM.isDisplayed();
    }

    public void shouldDisplayTabs(int arg0) {
        Assert.assertEquals(arg0, pdpPageObject.condition_popup_Btn_list_Ele.size(), "Condition popup Buttons are not displayed.");
    }

    public void verifyConditionBarOnPopup() {
        Assert.assertTrue(pdpPageObject.popup_condition_bar_Ele.isDisplayed());
    }

    public void closePopup() {
        pdpPageObject.popup_close_btn_Ele.click();
        Assert.assertTrue(pdpPageObject.add_to_Cart_btn_Ele.isDisplayed(), "Condition PopUp is not closed Yet!!!");
    }

    public void openUpperRightCornerDropdownMenu() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            Assert.assertTrue(pdpPageObject.pdp_upperRight_corner_List_ele.isDisplayed(),"PDP page Right Corner List Not Opened!");
    }else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
            Assert.assertTrue(pdpPageObject.pdp_upperRight_corner_List_MM_ele.isDisplayed(),"PDP page Right Corner List Not Opened!");
        }

    }

    public boolean shouldDisplayMsgCountOnPdpHeader() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitWithoutExceptionForElementsResult(cartPageObjects.buy_Now_btn);
            return pdpPageObject.msgcount_on_pdp_menu_ele.isDisplayed();
        }else {
            waitWithoutExceptionForElementsResult(cartPageObjects.buy_Now_btn_MM);
            return pdpPageObject.msgcount_on_pdp_menu_ele_MM.isDisplayed();
        }
    }

    public boolean shouldDisplayMsgCountOnPdpHeaderDisappear() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitWithoutExceptionForElementsResult(cartPageObjects.buy_Now_btn);
            return pdpPageObject.msgcount_on_pdp_menu_ele_LISTTEST.size() == 0;
        }else {
            waitWithoutExceptionForElementsResult(cartPageObjects.buy_Now_btn_MM);
            return pdpPageObject.msgcount_on_pdp_menu_ele_MM.isDisplayed();
        }
    }

    public boolean shouldDisplayMsgCountInHeaderMenu() {
        return !System.getProperty("env").equalsIgnoreCase("mm.live") ? pdpPageObject.msgcount_In_pdp_menu_ele.isDisplayed() : pdpPageObject.msgcount_In_pdp_menu_ele_MM.isDisplayed();
    }

    public boolean shouldNotDisplayMsgCountInHeaderMenu() {
        if(!System.getProperty("env").equalsIgnoreCase("mm.live")){
           return pdpPageObject.msgcount_In_pdp_menu_ele_LISTTest.size() == 0;
        } else{
           return !pdpPageObject.msgcount_In_pdp_menu_ele_MM.isDisplayed();
        }
    }
}