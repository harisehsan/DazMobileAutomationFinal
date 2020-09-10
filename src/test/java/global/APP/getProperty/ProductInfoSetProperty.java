package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ProductInfoSetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\productinfo.property"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("src\\test\\java\\global\\APP\\properties\\productinfo.property"),null);
    }

    public void setProductName (String productName) throws IOException {
        fileInputStream();
        prop.setProperty("PRODUCT_TITLE", productName);
        fileOutputStream();
    }

    public void setProductPrice (String productPrice) throws IOException {
        fileInputStream();
        prop.setProperty("PRODUCT_PRICE", productPrice);
        fileOutputStream();
    }

    public void setProductQuantity (String productQuantity) throws IOException {
        fileInputStream();
        prop.setProperty("PRODUCT_QUANTITY", productQuantity);
        fileOutputStream();
    }

    public void setProductSize (String productSize) throws IOException {
        fileInputStream();
        prop.setProperty("PRODUCT_SIZE", productSize);
        fileOutputStream();
    }
}
