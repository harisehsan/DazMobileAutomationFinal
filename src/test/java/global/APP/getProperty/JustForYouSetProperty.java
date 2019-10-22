package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-October-2019
 */

public class JustForYouSetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\justforyou.property"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("src\\test\\java\\global\\APP\\properties\\justforyou.property"),null);
    }

    public void setProductInformation (String productTitle, String displayedPrice) throws IOException {
        fileInputStream();
        prop.setProperty("PRODUCT_TITLE", productTitle);
        prop.setProperty("DISPLAYED_PRICE", displayedPrice);
        fileOutputStream();
    }

    public void setProductDiscountInformation(String discountRate, String originalPrice) throws IOException {
        fileInputStream();
        prop.setProperty("DISCOUNT_RATE", discountRate);
        prop.setProperty("ORIGINAL_PRICE", originalPrice);
        fileOutputStream();
    }
}
