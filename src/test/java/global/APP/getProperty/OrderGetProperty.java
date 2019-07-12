package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 10-July-2019
 */

public class OrderGetProperty {

    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\order.property"));
    }

    public List<String> cancellationReason() throws IOException {
        fileInputStream();
        List<String> cancellationReason = new ArrayList<>();
        cancellationReason.add(prop.getProperty("CANCEL_REASON_1"));
        cancellationReason.add(prop.getProperty("CANCEL_REASON_2"));
        cancellationReason.add(prop.getProperty("CANCEL_REASON_3"));
        cancellationReason.add(prop.getProperty("CANCEL_REASON_4"));
        cancellationReason.add(prop.getProperty("CANCEL_REASON_5"));
        cancellationReason.add(prop.getProperty("CANCEL_REASON_6"));
        return cancellationReason;
    }

    public String cancellationComment() throws IOException {
        fileInputStream();
        return prop.getProperty("CANCEL_COMMENT");
    }

    public String cancellationOrderAmount() throws IOException {
        fileInputStream();
        return prop.getProperty("ORDER_AMOUNT");
    }

    public String productName() throws IOException {
        fileInputStream();
        return prop.getProperty("PRODUCT_NAME");
    }
}
