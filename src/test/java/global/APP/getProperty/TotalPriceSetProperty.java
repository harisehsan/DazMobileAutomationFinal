package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TotalPriceSetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\totalPrice.property"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("src\\test\\java\\global\\APP\\properties\\totalPrice.property"),null);
    }

    public void setCheckoutCommulativePrice (String checkoutPrice) throws IOException {
        fileInputStream();
        prop.setProperty("CHECKOUT_COMMULATIVE_PRICE", checkoutPrice);
        fileOutputStream();
    }

    public void setCartCommulativePrice (String cartPrice) throws IOException {
        fileInputStream();
        prop.setProperty("CART_COMMULATIVE_PRICE", cartPrice);
        fileOutputStream();
    }

    public void setCartTotalPrice (String cartPrice) throws IOException {
        fileInputStream();
        prop.setProperty("CART_TOTAL_PRICE", cartPrice);
        fileOutputStream();
    }

    public void setAddressProvince(String data) throws IOException {
        fileInputStream();
        prop.setProperty("ADDRESS_PROVINCE", data);
        fileOutputStream();
    }

    public void setAddressCity(String data) throws IOException {
        fileInputStream();
        prop.setProperty("ADDRESS_CITY", data);
        fileOutputStream();
    }

    public void setAddressArea(String data) throws IOException {
        fileInputStream();
        prop.setProperty("ADDRESS_AREA", data);
        fileOutputStream();
    }


}
