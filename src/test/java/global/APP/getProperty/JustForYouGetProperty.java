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
        String originalPrice= prop.getProperty("ORIGINAL_PRICE");
        if (originalPrice.contains("Rs. "))
           originalPrice = originalPrice.replace("Rs. ","");
        else if (originalPrice.contains("Rs."))
            originalPrice = originalPrice.replace("Rs.","");
        else if (originalPrice.contains("৳ "))
            originalPrice = originalPrice.replace("৳ ","");
        else if (originalPrice.contains("Ks "))
            originalPrice = originalPrice.replace("Ks ","");
        return originalPrice;
    }

    public String displayedPrice() throws IOException {
        fileInputStream();
        String displayedPrice= prop.getProperty("DISPLAYED_PRICE");
        if (displayedPrice.contains("Rs. "))
            displayedPrice = displayedPrice.replace("Rs. ","");
        else if (displayedPrice.contains("Rs."))
            displayedPrice = displayedPrice.replace("Rs.","");
        else if (displayedPrice.contains("৳ "))
            displayedPrice = displayedPrice.replace("৳ ","");
        else if (displayedPrice.contains("Ks "))
            displayedPrice = displayedPrice.replace("Ks ","");
        return displayedPrice;
    }

    public String productTitle() throws IOException {
        fileInputStream();
        String productTitle = prop.getProperty("PRODUCT_TITLE");
        if (productTitle.contains("'"))
          productTitle =  productTitle.replaceAll("'.*","");
        if (productTitle.contains("0 "))
            productTitle = productTitle.replace("0 ","");
        if(productTitle.length() >= 9)
            return (productTitle.substring(0,9));
        else
            return (productTitle);
    }
}