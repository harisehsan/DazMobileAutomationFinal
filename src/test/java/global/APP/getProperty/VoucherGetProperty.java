package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VoucherGetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\Voucher.property"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("src\\test\\java\\global\\APP\\properties\\Voucher.property"),null);
    }

    public String getWrongVoucherCode() throws IOException {
        fileInputStream();
        return prop.getProperty("CART_VOUCHER_CODE_WRONG");
    }

    public String getCorrectVoucherCode() throws IOException {
        fileInputStream();
        return prop.getProperty("CART_VOUCHER_CODE_CORRECT");
    }

    public String getCartTotalPrice() throws IOException {
        fileInputStream();
        return prop.getProperty("CART_TOTAL_PRICE");
    }

    public void setCartTotalPrice(String totalPrice) throws IOException {
        fileInputStream();
        prop.setProperty("CART_TOTAL_PRICE", totalPrice);
        fileOutputStream();
    }

    public void setCorrectVoucherCode(String voucherCode) throws IOException {
        fileInputStream();
        prop.setProperty("CART_VOUCHER_CODE_CORRECT", voucherCode);
        fileOutputStream();
    }

    public String getPKVoucher() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_PK");
    }

    public String getBDVoucher() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_BD");
    }

    public String getLKVoucher() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_LK");
    }

    public String getNPVoucher() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_NP");
    }

    public String getMMVoucher() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_MM");
    }

    public void setTotalPriceCheckout(String checkOutTotalPrice) throws IOException
    {
        fileInputStream();
        prop.setProperty("CHECK_OUT_TOTAL_PRICE", checkOutTotalPrice);
        fileOutputStream();
    }

    public String getTotalPriceCheckout() throws IOException
    {
        fileInputStream();
        return prop.getProperty("CHECK_OUT_TOTAL_PRICE");
    }

    public String getExpiredVoucherPK() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_EXPIRED_PK");
    }

    public String getExpiredVoucherBD() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_EXPIRED_BD");
    }

    public String getExpiredVoucherLK() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_EXPIRED_LK");
    }

    public String getExpiredVoucherNP() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_EXPIRED_NP");
    }

    public String getExpiredVoucherMM() throws IOException {
        fileInputStream();
        return prop.getProperty("VOUCHER_EXPIRED_MM");
    }

    public List<String> getStoreCreditVoucherPK() throws IOException {

        fileInputStream();
        List<String> storeCreditPklst = new ArrayList<>();
        for (int i=1; i<=2; i++) {
            storeCreditPklst.add(prop.getProperty("STORE_CREDIT_PK_"+i));
        }
        return storeCreditPklst;
    }

    public List<String> getStoreCreditVoucherBD() throws IOException {

        fileInputStream();
        List<String> storeCreditBDlst = new ArrayList<>();
        for (int i=1; i<=2; i++) {
            storeCreditBDlst.add(prop.getProperty("STORE_CREDIT_BD_"+i));
        }
        return storeCreditBDlst;
    }

    public List<String> getStoreCreditVoucherLK() throws IOException {

        fileInputStream();
        List<String> storeCreditLKlst = new ArrayList<>();
        for (int i=1; i<=2; i++) {
            storeCreditLKlst.add(prop.getProperty("STORE_CREDIT_LK_"+i));
        }
        return storeCreditLKlst;
    }

    public List<String> getStoreCreditVoucherNP() throws IOException {

        fileInputStream();
        List<String> storeCreditNPlst = new ArrayList<>();
        for (int i=1; i<=2; i++) {
            storeCreditNPlst.add(prop.getProperty("STORE_CREDIT_NP_"+i));
        }
        return storeCreditNPlst;
    }

    public List<String> getStoreCreditVoucherMM() throws IOException {

        fileInputStream();
        List<String> storeCreditMMlst = new ArrayList<>();
        for (int i=1; i<=2; i++) {
            storeCreditMMlst.add(prop.getProperty("STORE_CREDIT_MM_"+i));
        }
        return storeCreditMMlst;
    }

    public String getPercentageVoucher() throws IOException {
        fileInputStream();
        return prop.getProperty("PERCENTAGE_VOUCHER");
    }
}