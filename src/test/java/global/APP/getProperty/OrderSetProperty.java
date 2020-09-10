package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 12-July-2019
 */

public class OrderSetProperty {

    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\order.property"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("src\\test\\java\\global\\APP\\properties\\order.property"),null);
    }

    public void orderAmount (String amount) throws IOException {
        fileInputStream();
        prop.setProperty("ORDER_AMOUNT", amount);
        fileOutputStream();
    }

    public void productName(String productName) throws IOException {
        fileInputStream();
        prop.setProperty("PRODUCT_NAME", productName);
        fileOutputStream();
    }

    public void shippingAddress(String shippingAddress) throws IOException {
        fileInputStream();
        prop.setProperty("SHIPPING_ADDRESS", shippingAddress);
        fileOutputStream();
    }

    public void totalPrice(String totalPrice) throws IOException {
        fileInputStream();
        prop.setProperty("TOTAL_PRICE", totalPrice);
        fileOutputStream();
    }
}