package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.LoginPageObject;
import member.APP.pageObjects.WalletPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Wallet extends Base {
    String loginbtn = "Login";
    String loginlbl = "Please login to use your wallet";
    String walletLabel = "Wallet Activation";
    String activateWalletbtn = "Activate My Wallet";
    String availableBalance = "Available Balance";
    String currency = "PKR";
    String topUp = "Top Up";
    String balanceDetails = "Balance Details";
    String mobileReload = "Mobile Reload";
    String quickTopUp = "Quick Top Up";
    String voucher  = "Vouchers";
    String allTransaction = "All Transactions";
    String depositScreen = "Deposit Method";
    String noTransactionRecord = "No transaction Records";
    String purchases = "Purchases";
    String refunds = "Refunds";
    String topUps = "Top ups";
    String coupons = "Coupons";
    String withdrawals = "Withdrawals";
    String payment = "PAYMENT";
    String refund = "REFUND";
    String bonus = "BONUS";


    WalletPageObject walletPageObject = new WalletPageObject();
    LoginPageObject loginPageObject = new LoginPageObject();

    public Wallet(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), walletPageObject);
    }

    public boolean verifyTheWalletPage()
    {
         return (waitWithoutExceptionByString(loginbtn) && waitWithoutExceptionByString(loginlbl));
    }

    public boolean walletActivationPage()
    {
        return containsTextIsExist(walletLabel);
    }

    public boolean verifyTheWalletButton()
    {
       return waitWithoutExceptionByString(activateWalletbtn);
    }

    public void enterCredentailsForActivatedWalletAccount(String email, String password)
    {
        waitUntilPresentOfElementBy(loginPageObject.final_Email_Login_btn_By);
        loginPageObject.login_Email_Final_txt.get(0).sendKeys(email);
        loginPageObject.login_Email_Final_txt.get(1).sendKeys(password);
    }

    public boolean verifyThecomponenetsOfActivatedWallet()
    {
        return (waitWithoutExceptionByString(availableBalance)
        && findElementsSizeByString(currency)
        && findElementsSizeByString(topUp)
        && findElementsSizeByString(balanceDetails)
        && findElementsSizeByString(mobileReload)
        && findElementsSizeByString(voucher)
        && findElementsSizeByString(allTransaction));
    }

    public void selectTopupButtonOnWallet()
    {
        findElementByString(topUp).click();
    }

    public boolean verifyNavigationToDepositeScreen()
    {
        return waitWithoutExceptionByTextContains(depositScreen);
    }

    public void selectBalanceDeatils()
    {
        findElementByString(balanceDetails).click();
    }

    public boolean verifyNavigationTotBalanceDeatils()
    {
        return containsTextIsExist(balanceDetails);
    }

    public void selectMobileReload()
    {
        findElementByString(mobileReload).click();
    }

    public boolean verifyNavigationToMobileReload()
    {
        return containsTextIsExist(quickTopUp);
    }

    public boolean verifyTheAllTransactionSection()
    {
        return  (findElementsSizeByString(payment) || findElementsSizeByString(noTransactionRecord));
    }

    public void goToPurchasesSection()
    {
        findElementByString(allTransaction).click();
        findElementByString(purchases).click();
    }

    public boolean verifyThePaymentSection()
    {
        return  (findElementsSizeByString(payment) || findElementsSizeByString(noTransactionRecord));
    }

    public void goToRefundFromPurchases()
    {
        findElementByString(purchases).click();
        findElementByString(refunds).click();
    }

    public boolean verifyTheRefundSection()
    {
        return  (findElementsSizeByString(refund) || findElementsSizeByString(noTransactionRecord));
    }

    public void gotoTheTopupSectionOfWallet()
    {
        findElementByString(refunds).click();
        findElementByString(topUps).click();
    }

    public boolean verifyTheTopUpsSection()
    {
        return  (findElementsSizeByString(topUp) || findElementsSizeByString(noTransactionRecord));
    }

    public void gotoTheCouponsSection()
    {
        findElementByString(topUps).click();
        findElementByString(coupons).click();
    }

    public boolean verifyTheCouponSection()
    {
        return  (findElementsSizeByString(bonus) || findElementsSizeByString(noTransactionRecord));
    }

    public void gotoTheWithdrwalsSection()
    {
        findElementByString(coupons).click();
        findElementByString(withdrawals).click();
    }

    public boolean verifyTheWithdrawalsSection()
    {
        return  (findElementsSizeByString(noTransactionRecord));
    }

    public void selectSwitchAccount()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(walletPageObject.switch_Account_lnk_By);
            walletPageObject.switch_Account_lnk.click();
        }
        else
        {
            waitUntilPresentOfElementBy(walletPageObject.switch_Account_lnk_By_MM);
            walletPageObject.switch_Account_lnk_MM.click();
        }
    }
}