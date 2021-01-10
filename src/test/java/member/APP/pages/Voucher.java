package member.APP.pages;


import global.APP.getProperty.VoucherGetProperty;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.VoucherPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Voucher extends Base {

   VoucherPageObject voucherPageObject = new VoucherPageObject();
   VoucherGetProperty voucherGetProperty = new VoucherGetProperty();
   String voucher = "Vouchers";
   String myVoucher = "My Voucher";
   String details = "Detail";
   String voucherDetails = "Voucher Detail";
   String minSpend = "Min. spend";
   String walletActivation = "Wallet Activation";
   String okbtn = "OK";


    public Voucher(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), voucherPageObject);
    }

      public void gotoVoucherfromWallet()
      {
         if (containsTextIsExist(walletActivation))
             driver.navigate().back();
          waitWithoutExceptionByString(voucher);
          findElementByString(voucher).click();
      }

      public boolean shouldBeOnTheMyVoucherPage()
      {

          return waitWithoutExceptionByTextContainsLessTime(myVoucher);
      }

      public void selectDetailsOfVoucher()
      {
         int tries = 0;
        while(findElementsSizeByString(okbtn) && tries < 10)
        {
            findElementByString(okbtn).click();
            tries++;
        }

         if (waitWithoutExceptionByStringLessTime(details))
                findElementByString(details).click();
         else
             throw new RuntimeException("Voucher Details are not available!");
      }

      public boolean verifyTheVoucherDetailsPage()
      {
           if (waitWithoutExceptionByTextContains(voucherDetails))
               return (isExistByString(minSpend));
           else
               return false;
      }

      public void scrollToVoucherCode()
      {
        int tires = 0;

          if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
              do {
                  swiptToBottom();
                  tires++;
              }while(!isExist(voucherPageObject.voucher_Input_txtBox) && tires <= 10);
              swiptToBottom();
          } else {
              do {
                  swiptToBottom();
                  tires++;
              }while(!isExist(voucherPageObject.voucher_Input_txtBox_MM) && tires <= 10);
              swiptToBottom();
          }
      }

      public void storeTheTotalPrice() throws IOException {
          if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
              voucherGetProperty.setTotalPriceCheckout(voucherPageObject.total_Price_Checkout_lbl.getText().replaceAll("\\D+",""));
          } else {
              voucherGetProperty.setTotalPriceCheckout(voucherPageObject.total_Price_Checkout_lbl_MM.getText().replaceAll("\\D+",""));
          }
      }

      public void enterVoucherCode() throws IOException {
          switch (System.getProperty("env")) {
              case "pk.live":
                  voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getPKVoucher());
                  break;
              case "bd.live":
                  voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getBDVoucher());
                  break;
              case "lk.live":
                  voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getLKVoucher());
                  break;
              case "np.live":
                  voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getNPVoucher());
                  break;
              case "mm.live":
                  voucherPageObject.voucher_Input_txtBox_MM.get(0).sendKeys(voucherGetProperty.getMMVoucher());
                  break;
              default:
                  throw new RuntimeException("Invalid Choice");

          }
      }

      public void voucherApplybtn() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            voucherPageObject.voucher_Apply_btn.click();
           }
        else
            {
                voucherPageObject.voucher_Apply_btn_MM.click();
            }
        }

      public boolean iShouldSeeTheVoucherSuccessMessage() {
          if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
           return isExist(voucherPageObject.voucher_Success_lbl);
          }
          else
          {
              return isExist(voucherPageObject.voucher_Success_lbl_MM);
          }

       }

    public boolean iShouldSeeTheImapctOfVoucherOnTotalPrice() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            return ((convertToIntFromString(voucherPageObject.total_Price_Checkout_lbl.getText())) < convertToIntFromString(voucherGetProperty.getTotalPriceCheckout()));
        }
        else
        {
            return ((convertToIntFromString(voucherPageObject.total_Price_Checkout_lbl_MM.getText())) < convertToIntFromString(voucherGetProperty.getTotalPriceCheckout()));
        }

    }
}
