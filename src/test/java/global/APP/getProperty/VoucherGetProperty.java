package global.APP.getProperty;

import org.apache.velocity.runtime.directive.Parse;

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
}
