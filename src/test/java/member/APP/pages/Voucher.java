package member.APP.pages;


import global.APP.getProperty.VoucherGetProperty;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.VoucherPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Voucher extends Base {

    VoucherPageObject voucherPageObject = new VoucherPageObject();
    VoucherGetProperty voucherGetProperty = new VoucherGetProperty();
    String voucher = "Vouchers";
    String myVoucher = "My Voucher";
    String details = "Detail";
    String copy = "Copy";
    String voucherDetails = "Voucher Detail";
    String minSpend = "Min. spend";
    String walletActivation = "Wallet Activation";
    String okbtn = "OK";
    String voucherBDbtn = "ভাউচারগুলো";
    String voucherLKbtn = "වවුචර්";
    String voucherNPbtn = "भौचरहरू";
    String voucherMMbtn = "ဘောက်ချာများ";
    String nonUsableVoucher = "Non-usable voucher";
    String deactivated = "Deactived";
    String spend = "Spend";
    String expired = "Expired";
    String collectMoreVoucherbtn = "Collect more voucher";
    String termsAndConditions = "Terms and Conditions";
    String StoreWide = "Terms and Conditions";
    String StoreTab = "Store";
    String daraz = "Daraz";
    String storeCredit = "Store credit";
    String collectiableVoucher = "Voucher";
    String getMoreVoucherbtn = "Get more vouchers";
    String voucherExpireMessage = "Sorry, this voucher is not valid";
    String save = "save";
    String spend2 = "spend";
    String shop = "Shop";


    public Voucher(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), voucherPageObject);
    }

    public void gotoVoucherfromWallet() {
        if (containsTextIsExist(walletActivation))
            driver.navigate().back();
        waitWithoutExceptionByString(voucher);
        findElementByString(voucher).click();
    }

    public boolean shouldBeOnTheMyVoucherPage() {

        return waitWithoutExceptionByTextContainsLessTime(myVoucher);
    }

    public void selectDetailsOfVoucher() {
        voucherOkSkip();
        if (waitWithoutExceptionByStringLessTime(details))
            findElementByString(details).click();
        else
            throw new RuntimeException("Voucher Details are not available!");
    }

    private void voucherOkSkip() {
        int tries = 0;
        while (findElementsSizeByString(okbtn) && tries < 10) {
            findElementByString(okbtn).click();
            tries++;
        }
    }

    public boolean verifyTheVoucherDetailsPage() {
        if (waitWithoutExceptionByTextContains(voucherDetails))
            return (isExistByString(minSpend) || isExistByString(save) || isExistByString(spend2));
        else
            return false;
    }

    public void scrollToVoucherCode() {
        int tires = 0;

        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            do {
                swiptToBottom();
                tires++;
            } while (!isExist(voucherPageObject.voucher_Input_txtBox) && tires <= 10);
            swiptToBottom();
        } else {
            do {
                swiptToBottom();
                tires++;
            } while (!isExist(voucherPageObject.voucher_Input_txtBox_MM) && tires <= 10);
            swiptToBottom();
        }
    }

    public void storeTheTotalPrice() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            voucherGetProperty.setTotalPriceCheckout(voucherPageObject.total_Price_Checkout_lbl.getText().replaceAll("\\D+", ""));
        } else {
            voucherGetProperty.setTotalPriceCheckout(voucherPageObject.total_Price_Checkout_lbl_MM.getText().replaceAll("\\D+", ""));
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
        } else {
            voucherPageObject.voucher_Apply_btn_MM.click();
        }
    }

    public boolean iShouldSeeTheVoucherSuccessMessage() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            return isExist(voucherPageObject.voucher_Success_lbl);
        } else {
            return isExist(voucherPageObject.voucher_Success_lbl_MM);
        }

    }

    public boolean iShouldSeeTheImapctOfVoucherOnTotalPrice() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            return ((convertToIntFromString(voucherPageObject.total_Price_Checkout_lbl.getText())) < convertToIntFromString(voucherGetProperty.getTotalPriceCheckout()));
        } else {
            return ((convertToIntFromString(voucherPageObject.total_Price_Checkout_lbl_MM.getText())) < convertToIntFromString(voucherGetProperty.getTotalPriceCheckout()));
        }
    }

    public void gotToVoucherInLocalLanguage() {
        switch (System.getProperty("env")) {
            case "pk.live":
                throw new RuntimeException("Not applicable on PK!");
            case "bd.live":
                waitWithoutExceptionByTextContains(voucherBDbtn);
                findElementByTextUsingContainsString(voucherBDbtn).click();
                break;
            case "lk.live":
                waitWithoutExceptionByTextContains(voucherLKbtn);
                findElementByTextUsingContainsString(voucherLKbtn).click();
                break;
            case "np.live":
                waitWithoutExceptionByTextContains(voucherNPbtn);
                findElementByTextUsingContainsString(voucherNPbtn).click();
                break;
            case "mm.live":
                waitWithoutExceptionByTextContains(voucherMMbtn);
                findElementByTextUsingContainsString(voucherMMbtn).click();
                break;
            default:
                throw new RuntimeException("Invalid Choice");
        }
    }

    public boolean verifyTheLanguageChangeforVoucher() {
        switch (System.getProperty("env")) {
            case "pk.live":
                throw new RuntimeException("Not applicable on PK!");
            case "bd.live":
                return (containsTextIsExist(voucherBDbtn));
            case "lk.live":
                return (containsTextIsExist(voucherLKbtn));
            case "np.live":
                return (containsTextIsExist(voucherNPbtn));
            case "mm.live":
                return (containsTextIsExist(voucherMMbtn));
            default:
                throw new RuntimeException("Invalid Choice");
        }
    }

    public void gotoNonUsableVoucher() {
        voucherOkSkip();
        waitWithoutExceptionByString(nonUsableVoucher);
        findElementByContentDescrpitionUsingContainString(nonUsableVoucher).click();
    }

    public void waitforTheNonUsableVoucherUsed() {
        waitUntilPresentOfElementByString(deactivated);
    }

    public boolean iShouldbeOnTheUsedPageOfMyVoucher() {
        return (findElementsSizeByString(spend) || findElementsSizeByString(collectMoreVoucherbtn) || findElementsSizeByString(save) || findElementsSizeByString(spend2));
    }

    public void selectExpiredVoucher() {
        findElementByContentDescrpitionUsingContainString(expired).click();
    }

    public boolean iShouldbeOnTheExpiredPageOfMyVoucher() {
        return (findElementsSizeByString(spend) || findElementsSizeByString(collectMoreVoucherbtn) || findElementsSizeByString(save) || findElementsSizeByString(spend2));
    }

    public void selectDeactivatedVoucher() {
        findElementByContentDescrpitionUsingContainString(deactivated).click();
    }

    public boolean iShouldBeOnTheDeactivatedPage() {
        return (findElementsSizeByString(spend) || findElementsSizeByString(collectMoreVoucherbtn) || findElementsSizeByString(save) || findElementsSizeByString(spend2));
    }

    public void selectTermsAndConditions() {
        findElementByContentDescrpitionUsingContainString(termsAndConditions).click();
    }

    public boolean verifyTheTermsAndCondition() {
        return findElementsSizeByString(StoreWide);
    }

    public void selectStoreTab() {
        findElementByContentDescrpitionUsingContainString(StoreTab).click();
    }


    public boolean shouldBeOnStorePage() {
        return (findElementsSizeByString(details) || findElementsSizeByString(collectMoreVoucherbtn) || findElementsSizeByString(copy));
    }

    public void selectDaraztab() {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            findElementByContentDescrpitionUsingContainString(daraz).click();
        } else {
            findElementByContentDescrpitionUsingContainString(shop).click();
        }
    }

    public void selectStoreCreditTab() {
        findElementByContentDescrpitionUsingContainString(storeCredit).click();
    }

    public void clickOnTheCollectMoreButton() {
        findElementByContentDescrpitionUsingContainString(collectMoreVoucherbtn).click();
    }

    public boolean iShouldBeOnTheCollectibleVoucherPage() {
        return (waitWithoutExceptionByTextContainsLessTime(collectiableVoucher));
    }

    public void getMoreVouchers() {
        findElementByContentDescrpitionUsingContainString(getMoreVoucherbtn).click();
    }

    public void enterExpiredVoucherCode() throws IOException {
        switch (System.getProperty("env")) {
            case "pk.live":
                voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getExpiredVoucherPK());
                break;
            case "bd.live":
                voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getExpiredVoucherBD());
                break;
            case "lk.live":
                voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getExpiredVoucherLK());
                break;
            case "np.live":
                voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getExpiredVoucherNP());
                break;
            case "mm.live":
                voucherPageObject.voucher_Input_txtBox_MM.get(0).sendKeys(voucherGetProperty.getExpiredVoucherMM());
                break;
            default:
                throw new RuntimeException("Invalid Choice");
        }
    }

    public boolean verifyTheVoucherErrorMessage()
    {
        return (containsTextIsExist(voucherExpireMessage));
    }

    public boolean verifyTheContentOfTheStoreCredit() throws IOException {
        switch (System.getProperty("env"))
        {
            case "pk.live":
            {
                for (int i=0; i<2;i++)
                {
                    if (!findElementsSizeByString(voucherGetProperty.getStoreCreditVoucherPK().get(i)))
                        return false;
                }
                return true;
            }
            case "bd.live":
            {

                for (int i=0; i<2;i++)
                {
                    if (!findElementsSizeByString(voucherGetProperty.getStoreCreditVoucherBD().get(i)))
                        return false;
                }
                return true;
            }
            case "lk.live":
            {
                for (int i=0; i<2;i++)
                {
                    if (!findElementsSizeByString(voucherGetProperty.getStoreCreditVoucherLK().get(i)))
                        return false;
                }
                return true;
            }

            case "np.live":
            {
                for (int i=0; i<2;i++)
                {
                    if (!findElementsSizeByString(voucherGetProperty.getStoreCreditVoucherNP().get(i)))
                        return false;
                }
                return true;
            }
            case "mm.live":
            {
                for (int i=0; i<2;i++)
                {
                    if (!findElementsSizeByString(voucherGetProperty.getStoreCreditVoucherMM().get(i)))
                        return false;
                }
                return true;
            }
            default:
            {
                throw new RuntimeException("Not a valid option!");
            }
        }

    }

    public void enterTheCodeForPercentageVoucher() throws IOException {
        if (!(System.getProperty("env").equalsIgnoreCase("mm.live"))) {
            voucherPageObject.voucher_Input_txtBox.get(0).sendKeys(voucherGetProperty.getPercentageVoucher());
        } else {
            voucherPageObject.voucher_Input_txtBox_MM.get(0).sendKeys(voucherGetProperty.getPercentageVoucher());
        }

    }

}