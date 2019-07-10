package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 10-July-2019
 */

public class ProductsGetProperty {
    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\products.properties"));
    }

    public List<String> pkProducts() throws IOException {
        fileInputStream();
        return Arrays.asList(prop.getProperty("TEST_PRODUCT1_PK"), prop.getProperty("TEST_PRODUCT2_PK"), prop.getProperty("TEST_PRODUCT3_PK"), prop.getProperty("TEST_PRODUCT4_PK"), prop.getProperty("TEST_PRODUCT5_PK"));
    }

    public List<String> bdProducts() throws IOException {
        fileInputStream();
        return Arrays.asList(prop.getProperty("TEST_PRODUCT1_BD"), prop.getProperty("TEST_PRODUCT2_BD"), prop.getProperty("TEST_PRODUCT3_BD"), prop.getProperty("TEST_PRODUCT4_BD"), prop.getProperty("TEST_PRODUCT5_BD"));
    }

    public List<String> lkProducts() throws IOException {
        fileInputStream();
        return Arrays.asList(prop.getProperty("TEST_PRODUCT1_LK"), prop.getProperty("TEST_PRODUCT2_LK"), prop.getProperty("TEST_PRODUCT3_LK"), prop.getProperty("TEST_PRODUCT4_LK"), prop.getProperty("TEST_PRODUCT5_LK"));
    }

    public List<String> npProducts() throws IOException {
        fileInputStream();
        return Arrays.asList(prop.getProperty("TEST_PRODUCT1_NP"), prop.getProperty("TEST_PRODUCT2_NP"), prop.getProperty("TEST_PRODUCT3_NP"), prop.getProperty("TEST_PRODUCT4_NP"), prop.getProperty("TEST_PRODUCT5_NP"));
    }

    public List<String> mmProducts() throws IOException {
        fileInputStream();
        return Arrays.asList(prop.getProperty("TEST_PRODUCT1_MM"), prop.getProperty("TEST_PRODUCT2_MM"), prop.getProperty("TEST_PRODUCT3_MM"), prop.getProperty("TEST_PRODUCT4_MM"), prop.getProperty("TEST_PRODUCT5_MM"));
    }
}