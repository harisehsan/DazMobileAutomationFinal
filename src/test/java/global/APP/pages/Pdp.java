package global.APP.pages;

import global.APP.getProperty.PdpGetProperty;
import global.APP.pageObjects.CartPageObjects;
import global.APP.pageObjects.PdpPageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SearchPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-November-2019
 */

public class Pdp extends Base {
    PdpPageObject pdpPageObject = new PdpPageObject();
    SearchPageObject searchPageObj = new SearchPageObject();
    PdpGetProperty pdpGetProperty = new PdpGetProperty();
    CartPageObjects cartPageObjects = new CartPageObjects();
    private int tries = 25;
    private String productName;

    public Pdp(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pdpPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObj);
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

    public void gotoPdpPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By);
            searchPageObj.searchResult_lbl.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn))
                cartPageObjects.overseas_Confirm_btn.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn))
                searchPageObj.ok_Got_It_btn.get(0).click();
            productName = pdpPageObject.product_Title_lbl.get(0).getText();
        } else {
            waitUntilPresentOfElementBy(searchPageObj.searchResult_lbl_By_MM);
            searchPageObj.searchResult_lbl_MM.get(0).click();
            if (isExist(cartPageObjects.overseas_Confirm_btn_MM))
                cartPageObjects.overseas_Confirm_btn_MM.get(0).click();
            if (isExist(searchPageObj.ok_Got_It_btn_MM))
                searchPageObj.ok_Got_It_btn_MM.get(0).click();
            productName = pdpPageObject.product_Title_lbl_MM.get(0).getText();
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
            pdpPageObject.share_icon.get(0).click();
            return (isExist(pdpPageObject.share_Title_lbl));
        } else {
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
            pdpPageObject.store_Follow_btn.click();
        } else {
            if (isExist(searchPageObj.got_It_Store_btn_MM))
                searchPageObj.got_It_Store_btn_MM.get(0).click();
            pdpPageObject.store_Follow_btn_MM.click();
        }
    }

    public boolean iShouldFollowedThatStore() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.store_Follow_btn_By);
            return pdpPageObject.store_Follow_btn.getText().contains("Following");
        }
        else {
            waitUntilPresentOfElementBy(pdpPageObject.store_Follow_btn_By_MM);
            return pdpPageObject.store_Follow_btn_MM.getText().contains("Following");
        }
    }

    public boolean iShouldBeOnThePDPPage() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            return (isExist(pdpPageObject.product_Title_lbl));
        else
            return (isExist(pdpPageObject.product_Title_lbl_MM));
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
            pdpPageObject.menu_List.get(1).click();
            return isExist(searchPageObj.searchBeforeClick_txtfield);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
            pdpPageObject.menu_List_MM.get(1).click();
            return isExist(searchPageObj.searchBeforeClick_txtfield_MM);
        }
    }

    public boolean navigateToLoginFromPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By);
            pdpPageObject.menu_List.get(0).click();
            return isExist(pdpPageObject.login_btn);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
            pdpPageObject.menu_List_MM.get(0).click();
            return isExist(pdpPageObject.login_btn_MM);
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
            pdpPageObject.menu_List.get(3).click();
            return (isExist(pdpPageObject.searchAfterClick_txtfield));
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
            pdpPageObject.menu_List_MM.get(3).click();
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
            pdpPageObject.menu_List.get(4).click();
            return isExist(pdpPageObject.messages_Header_lbl);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
            pdpPageObject.menu_List_MM.get(4).click();
            return isExist(pdpPageObject.messages_Header_lbl);
        }
    }

    public boolean navigateToNeedHelpFromPDP() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By);
            pdpPageObject.dots_button.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By);
            pdpPageObject.menu_List.get(6).click();
            return isExist(pdpPageObject.help_Header_lbl);
        } else {
            waitUntilPresentOfElementBy(pdpPageObject.dots_button_By_MM);
            pdpPageObject.dots_button_MM.click();
            waitUntilPresentOfElementBy(pdpPageObject.menu_List_By_MM);
            pdpPageObject.menu_List_MM.get(6).click();
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

    public void switchBetweenDifferentSKUs() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(pdpPageObject.sku_Selector_btn_By);
            for (int i = 0; i < pdpPageObject.sku_Selector_btn.size(); i++)
                pdpPageObject.sku_Selector_btn.get(i).click();

        } else {
            waitUntilPresentOfElementBy(pdpPageObject.sku_Selector_btn_By_MM);
            for (int i = 0; i < pdpPageObject.sku_Selector_btn_MM.size(); i++)
                pdpPageObject.sku_Selector_btn_MM.get(i).click();
        }
    }

    public boolean changeQuantity() {
        int j=0;
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            while (Integer.parseInt(pdpPageObject.quantity_txtBox.getText()) < 5 && j<5 ) {
                pdpPageObject.quantity_Increase_btn.click();
                j++;
            }
               return (Integer.parseInt(pdpPageObject.quantity_txtBox.getText()) >= 1);
        }
        else
            {
            while (Integer.parseInt(pdpPageObject.quantity_txtBox_MM.getText()) < 5 && j<5) {
                pdpPageObject.quantity_Increase_btn_MM.click();
                j++;
            }
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
            return isExist(pdpPageObject.voucher_Success_Message_snackbar);
        else
            return isExist(pdpPageObject.voucher_Success_Message_snackbar_MM);
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

    public void clickOnVoucherCodeCopyButton()
    {
        waitUntilPresentOfElementBy(pdpPageObject.voucher_Copy_btn_By);
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
            for (int i = 0; i < cartPageObjects.product_Title_In_Cart_lbl.size(); ++i) {
                if (cartPageObjects.product_Title_In_Cart_lbl.get(i).getText().contains(productName)) {
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
}