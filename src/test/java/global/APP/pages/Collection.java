package global.APP.pages;

import global.APP.pageObjects.CollectionPageObject;
import global.APP.pageObjects.FlashSalePageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 24-September-2019
 */

public class Collection extends Base {

    CollectionPageObject collectionPageObject = new CollectionPageObject();
    FlashSalePageObject flashSalePageObject = new FlashSalePageObject();
    SignUpObjects signUpObjects = new SignUpObjects();

    public Collection(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), collectionPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), flashSalePageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
    }

    public boolean verifyTheExistenceOfCollectionOnHomePage() {
        int tries = 10;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
            for (int i = 0; i < tries; i++) {
                if (isExist(collectionPageObject.collection_lbl))

                  return true;
                 else
                    swiptToBottom();
            }
        } else {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
            for (int i = 0; i < tries; i++) {
                if (isExist(collectionPageObject.collection_lbl_MM))
                    return true;
                 else
                    swiptToBottom();
            }
        }
        return false;
    }

    public boolean selectShopMoreForCollections()
    {
        int tries = 25;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
            for (int i = 0; i < tries; i++) {
                if (isExist(collectionPageObject.collection_lbl)) {
                      switch (System.getProperty("env")){
                          case "pk.live":
                          case "bd.live":
                          case "lk.live":
                          case "np.live":
                              {
                              if (collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().contains("Collections"))
                              {
                               collectionPageObject.shop_More_btn.get( collectionPageObject.shop_More_btn.size()-1).click();
                               return true;
                              }
                              else
                                  swiptToBottom();
                          }
                          break;
//                          case "np.live":
//                          {
//                              if (collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().contains("Dashain Specials!")) {
//                                  collectionPageObject.shop_More_btn.get( collectionPageObject.shop_More_btn.size()-1).click();
//                                  return true;
//                              }
//                              else
//                                  swiptToBottom();
//
//                          }
//                          break;
                    }
                }
                else
                    swiptToBottom();
            }
        }
        else
        {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
            for (int i = 0; i < tries; i++) {
                if (isExist(collectionPageObject.collection_lbl_MM)) {
                    if (collectionPageObject.collection_lbl_MM.get(collectionPageObject.collection_lbl_MM.size()-1).getText().contains("Collections")) {
                        collectionPageObject.shop_More_btn_MM.get(collectionPageObject.shop_More_btn_MM.size()-1).click();
                        return true;
                    }
                    else
                    {
                        swiptToBottom();
                    }
                }
                else
                    swiptToBottom();
            }
        }
        return false;
    }

    public boolean verifyTheCollectionPage()
    {
            waitWithoutExceptionForElements(collectionPageObject.collection_header_lbl);
            String title = collectionPageObject.collection_header_lbl.get(0).getText();
            waitWithoutExceptionByText(title);
            return isExistByText(title);
    }

    public boolean checkTheExistenceOfCollectionOnHomePage() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
            return  (isExist(collectionPageObject.collection_lbl));
        else
            return  (isExist(collectionPageObject.collection_lbl_MM));

    }

    public void naviagteToSettings()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live")))
        {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By);
            signUpObjects.account_lbl.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.settings_icon_By);
            signUpObjects.settings_icon.click();
        }
        else
        {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By_MM);
            signUpObjects.account_lbl_MM.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.settings_icon_By_MM);
            signUpObjects.settings_icon_MM.click();
        }
    }

    public void changeLanguage()
    {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
          if (isExist(collectionPageObject.change_Language_lbl))
          {
            collectionPageObject.change_Language_lbl.get(0).click();
            waitUntilPresentOfElementBy(collectionPageObject.language_Options_chkbox_By);
            collectionPageObject.language_Options_chkbox.get(0).click();
            collectionPageObject.apply_btn.click();
          }
          else
              throw new RuntimeException("Language change is not applicable for this venture!");
        }
        else
        {
            collectionPageObject.change_Language_lbl_MM.get(0).click();
            waitUntilPresentOfElementBy(collectionPageObject.language_Options_rdobtn_By_MM);
            collectionPageObject.language_Options_chkbox_MM.get(0).click();
            collectionPageObject.apply_btn.click();
        }
    }

    public boolean checkForCollectionOnHomePageInLocalLanguage() {
        int tries = 25;
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By);
            for (int i = 0; i < tries; i++) {
                if (isExist(collectionPageObject.collection_lbl)) {
                    switch (System.getProperty("env")) {
                        case "bd.live": {
                            if (collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().contains("সংগ্রহগুলি"))
                                return (!collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().matches(".*[a-zA-Z].*"));
                            else
                                swiptToBottom();
                        }
                        break;
                        case "lk.live":
                        {
                            if (collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().contains("කලෙක්ශන්"))
                                return (!collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().matches(".*[a-zA-Z].*"));
                            else
                                swiptToBottom();
                        }
                        break;
                        case "np.live":
                        {
                            if ((collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().contains("Dashain Specials!")) || (collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().contains("संग्रह")))
                                return (!collectionPageObject.collection_lbl.get(collectionPageObject.collection_lbl.size()-1).getText().matches(".*[a-zA-Z].*"));
                            else
                                swiptToBottom();
                        }
                    }
                }
                else
                    swiptToBottom();
            }
        }
        else
        {
            waitUntilPresentOfElementBy(flashSalePageObject.flash_Sale_lbl_By_MM);
            for (int i = 0; i < tries; i++) {
                if (isExist(collectionPageObject.collection_lbl_Local_MM)) {
                    if ((collectionPageObject.collection_lbl_Local_MM.get(collectionPageObject.collection_lbl_Local_MM.size()-1).getText().contains("Thadingyut Collections")) || (collectionPageObject.collection_lbl_Local_MM.get(collectionPageObject.collection_lbl_MM.size()-1).getText().contains("စုစည်းမှုများ"))) {
                        return (!(collectionPageObject.collection_lbl_Local_MM.get(collectionPageObject.collection_lbl_Local_MM.size()-1).getText().matches(".*[a-zA-Z].*")));
                    }
                    else
                        swiptToBottom();
                }
                else
                    swiptToBottom();
            }
        }
      return false;
    }
}