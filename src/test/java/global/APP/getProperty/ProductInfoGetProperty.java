package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProductInfoGetProperty {

    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\productinfo.property"));
    }

    public String getProductTitle() throws IOException
    {
        fileInputStream();
        return prop.getProperty("PRODUCT_TITLE");
    }

    public String getProductPrice() throws IOException
    {
        fileInputStream();
        return prop.getProperty("PRODUCT_PRICE");
    }

    public String getProductQuantity() throws IOException
    {
        fileInputStream();
        return prop.getProperty("PRODUCT_QUANTITY");
    }

    public String getProductSize() throws IOException
    {
        fileInputStream();
        return prop.getProperty("PRODUCT_SIZE");
    }
}
