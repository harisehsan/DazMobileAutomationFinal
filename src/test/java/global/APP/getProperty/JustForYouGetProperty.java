package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-October-2019
 */

public class JustForYouGetProperty {

    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\justforyou.property"));
    }

    public String discountRate() throws IOException {
        fileInputStream();
        return (prop.getProperty("DISCOUNT_RATE").replaceAll("\\D+",""));
    }

    public String originalPrice() throws IOException {
        fileInputStream();
        return (prop.getProperty("ORIGINAL_PRICE").replaceAll("\\D+",""));
    }

    public String displayedPrice() throws IOException {
        fileInputStream();
        return (prop.getProperty("DISPLAYED_PRICE").replaceAll("\\D+",""));
    }

    public String productTitle() throws IOException {
        fileInputStream();
        if(prop.getProperty("PRODUCT_TITLE").length() >= 9)
            return (prop.getProperty("PRODUCT_TITLE").substring(0,9));
        else
            return (prop.getProperty("PRODUCT_TITLE"));
    }
}