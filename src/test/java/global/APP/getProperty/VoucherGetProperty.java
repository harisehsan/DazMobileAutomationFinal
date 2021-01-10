package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

}
