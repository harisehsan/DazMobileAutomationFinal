package member.APP.pages;

import global.APP.pageObjects.CheckOutPageObjects;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.UserGrowthPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserGrowth extends Base {
    UserGrowthPageObject userGrowthPageObject = new UserGrowthPageObject();
    CheckOutPageObjects checkOutPageObjects = new CheckOutPageObjects();

    public UserGrowth(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), userGrowthPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkOutPageObjects);
    }

   public boolean verifyTheExistenceOfUserGrowthOnHP()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")){
           return (waitWithoutExceptionForElementsResult(userGrowthPageObject.first_Order_Popup_Hp));
       } else {
           return (waitWithoutExceptionForElementsResult(userGrowthPageObject.first_Order_Popup_Hp_MM));
       }
   }

   public void closeTheFirstVoucherPopup()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")){
           userGrowthPageObject.first_Order_Popup_Hp.get(0).click();
       } else {
           userGrowthPageObject.first_Order_Popup_Hp_MM.get(0).click();
       }
   }

   public boolean verifyUserGrowthInlocalLanguage()
   {
     int tries = 0;
       switch (System.getProperty("env")) {
           case "bd.live":
           {
               while (!containsTextIsExist("আপনার প্রথম ক্রয়ে") && tries < 5)
               {
                   swiptToBottom();
                   tries++;
               }
               return containsTextIsExist("আপনার প্রথম ক্রয়ে");
           }

           case "lk.live":
           {
               while (!containsTextIsExist("ඔබගේ පළමු මිලදී ගැනීමේදී") && tries < 5)
               {
                   swiptToBottom();
                   tries++;
               }
               return containsTextIsExist("ඔබගේ පළමු මිලදී ගැනීමේදී");
           }

           case "np.live":
           {
               while (!containsTextIsExist("तपाइँको पहिलो खरीद मा") && tries < 5)
               {
                   swiptToBottom();
                   tries++;
               }
               return containsTextIsExist("तपाइँको पहिलो खरीद मा");
           }

           case "mm.live":
           {
               while (!containsTextIsExist("ပထမဆုံးဝယ်ယူမှုအတွက်") && tries <5)
               {
                   swiptToBottom();
                   tries++;
               }
               return containsTextIsExist("ပထမဆုံးဝယ်ယူမှုအတွက်");
           }

           default:
           {
               throw new RuntimeException("Language change is not applicable!");
           }
       }
   }

   public void selectTheAvailNowbutton()
   {
       int tries = 0;
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           while (!isExist(userGrowthPageObject.avail_Now_Hp_btn) && tries <5)
           {
               swiptToBottom();
               tries++;
           }
           userGrowthPageObject.avail_Now_Hp_btn.get(0).click();
       } else {
           while (!isExist(userGrowthPageObject.avail_Now_Hp_btn_MM) && tries <5)
           {
               swiptToBottom();
               tries++;
           }
           userGrowthPageObject.avail_Now_Hp_btn_MM.get(0).click();
       }
   }

   public boolean verifyTheNewUserZoneScreen()
   {
       waitWithoutExceptionByTextContains("First Order Voucher");
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           return (containsTextIsExist("First Order Voucher") && containsTextIsExist("New User Zone"));
       } else {
           return (containsTextIsExist("First Order Voucher") && containsTextIsExist("New User Gifts"));
       }
   }

   public void signInWithNewAccount(List<String> emailPK, List<String> passwordPK, List<String> emailBD, List<String> passwordBD, List<String> emailLK, List<String> passwordLK, List<String> emailNP, List<String> passwordNP, List<String> emailMM, List<String> passwordMM, String accountCount)
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           waitUntilPresentOfElementBy(userGrowthPageObject.login_With_Email_link_By);
           userGrowthPageObject.login_With_Email_link.click();
           waitUntilPresentOfElementBy(userGrowthPageObject.email_txt_By);
           switch(System.getProperty("env"))
           {
               case "pk.live":
               {
                   if (accountCount.equalsIgnoreCase("1st"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailPK.get(0));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordPK.get(0));
                   }
                   else if (accountCount.equalsIgnoreCase("2nd"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailPK.get(1));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordPK.get(1));
                   }
                   else
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys("abc@xyz.com");
                       userGrowthPageObject.email_txt.get(1).sendKeys("123456");
                   }
               }
               break;

               case "bd.live":
               {
                   if (accountCount.equalsIgnoreCase("1st"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailBD.get(0));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordBD.get(0));
                   }
                   else if (accountCount.equalsIgnoreCase("2nd"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailBD.get(1));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordBD.get(1));
                   }
                   else
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys("abc@xyz.com");
                       userGrowthPageObject.email_txt.get(1).sendKeys("123456");
                   }
               }
               break;

               case "lk.live":
               {
                   if (accountCount.equalsIgnoreCase("1st"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailLK.get(0));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordLK.get(0));
                   }
                   else if (accountCount.equalsIgnoreCase("2nd"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailLK.get(1));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordLK.get(1));
                   }
                   else
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys("abc@xyz.com");
                       userGrowthPageObject.email_txt.get(1).sendKeys("123456");
                   }
               }
               break;

               case "np.live":
               {
                   if (accountCount.equalsIgnoreCase("1st"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailNP.get(0));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordNP.get(0));
                   }
                   else if (accountCount.equalsIgnoreCase("2nd"))
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys(emailNP.get(1));
                       userGrowthPageObject.email_txt.get(1).sendKeys(passwordNP.get(1));
                   }
                   else
                   {
                       userGrowthPageObject.email_txt.get(0).sendKeys("abc@xyz.com");
                       userGrowthPageObject.email_txt.get(1).sendKeys("123456");
                   }
               }
               break;
           }

           hideKeyboard();
           userGrowthPageObject.login_btn.click();

       }
       else
       {
           waitUntilPresentOfElementBy(userGrowthPageObject.login_With_Email_link_By_MM);
           userGrowthPageObject.login_With_Email_link_MM.click();
           waitUntilPresentOfElementBy(userGrowthPageObject.email_txt_MM_By);
           if (accountCount.equalsIgnoreCase("1st"))
           {
               userGrowthPageObject.email_txt_MM.get(0).sendKeys(emailMM.get(0));
               userGrowthPageObject.email_txt_MM.get(1).sendKeys(passwordMM.get(0));
           }
           else if (accountCount.equalsIgnoreCase("2nd"))
           {
               userGrowthPageObject.email_txt_MM.get(0).sendKeys(emailMM.get(1));
               userGrowthPageObject.email_txt_MM.get(1).sendKeys(passwordMM.get(1));
           }
           else
           {
               userGrowthPageObject.email_txt.get(0).sendKeys("abc@xyz.com");
               userGrowthPageObject.email_txt.get(1).sendKeys("123456");
           }
           hideKeyboard();
           userGrowthPageObject.login_btn_MM.click();
       }
   }

   public void scrollToUserGrowthPopup()
   {
       int tries = 0;
       while(!isExistByText("COLLECT") && tries < 6)
       {
           swiptToBottom();
           tries++;
       }
   }

   public void iSelectCollectNowButton()
   {
       findElementByTextUsingContainsString("COLLECT").click();
   }

   public boolean iShouldSeeTheCollectSucceassful()
   {
       return waitWithoutExceptionByTextContainsLessTime("Collected successfully!");
   }

   public boolean iShouldNotSeeTheCollectButton()
   {
       if (isExistByText("COLLECTED"))
           return true;
       else if (isExistByText("COLLECT"))
       {
           iSelectCollectNowButton();
           if (isExistByText("Collected successfully!"))
               return false;
           else
               return true;
       }
       else
       {
          return true;
       }

   }

   public void addNewAddressOnCheckout()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           userGrowthPageObject.new_Address_On_Checkout_btn.click();
       }
       else
       {
           userGrowthPageObject.new_Address_On_Checkout_btn_MM.click();
       }
   }

   public boolean verifyTheImpactOfVoucher()
   {

       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           return  Integer.parseInt(checkOutPageObjects.current_Price_lbl.getText().replaceAll("\\D+", "")) >
                   Integer.parseInt(checkOutPageObjects.total_Price_On_Checkout.getText().replaceAll("\\D+", ""));
       } else {
           return  Integer.parseInt(checkOutPageObjects.current_Price_lbl_MM.getText().replaceAll("\\D+", "")) >
                   Integer.parseInt(checkOutPageObjects.total_Price_On_Checkout_MM.getText().replaceAll("\\D+", ""));
       }
   }

   public boolean verifyTheExistencOfUserGrowthPopup()
   {
       return (waitWithoutExceptionByTextContains("Shop Now"));
   }

   public void iSelectTheGoButtonforUserGrowthPopup()
   {
       if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
           userGrowthPageObject.user_Growth_Go_btn.click();
       }
       else
       {
           userGrowthPageObject.user_Growth_Go_btn_MM.click();
       }
   }

   public void selectVoucherInMyAccountSection()
   {
       findElementByTextUsingContainsString("Vouchers").click();
   }

   public boolean veryTheCollectedTheUserGrowthVoucherinMyVoucher()
   {
       while(isExistByCompleteString("OK"))
           findElementByContentDescrpitionUsingContainString("OK").click();
       if (findElementsSizeByString("New User"))
           return true;
       else if (findElementsSizeByString("New user"))
          return true;
       else return findElementsSizeByString("Growth Initiatives");
   }
}
