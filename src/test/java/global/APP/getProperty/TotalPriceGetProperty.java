package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TotalPriceGetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\totalPrice.property"));
    }

    public String getCheckoutCommulativePrice() throws IOException
    {
        fileInputStream();
        return prop.getProperty("CHECKOUT_COMMULATIVE_PRICE");
    }

    public String getCartCommulativePrice() throws IOException
    {
        fileInputStream();
        return prop.getProperty("CART_COMMULATIVE_PRICE");
    }

    public String getCartTotalPrice() throws IOException
    {
        fileInputStream();
        return prop.getProperty("CART_TOTAL_PRICE");
    }

    public String getAddressProvince() throws IOException {
        fileInputStream();
        return prop.getProperty("ADDRESS_PROVINCE");
    }

    public String getAddressCity() throws IOException {
        fileInputStream();
        return prop.getProperty("ADDRESS_CITY");
    }

    public String getAddressArea() throws IOException {
        fileInputStream();
        return prop.getProperty("ADDRESS_AREA");
    }
}
