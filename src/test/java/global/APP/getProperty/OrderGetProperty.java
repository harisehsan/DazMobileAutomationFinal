package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
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
        return Arrays.asList(prop.getProperty("CANCEL_REASON_1"), prop.getProperty("CANCEL_REASON_2"), prop.getProperty("CANCEL_REASON_3"), prop.getProperty("CANCEL_REASON_4"), prop.getProperty("CANCEL_REASON_5"), prop.getProperty("CANCEL_REASON_6"));
    }

    public String cancellationComment() throws IOException {
        fileInputStream();
        return prop.getProperty("CANCEL_COMMENT");
    }
}
