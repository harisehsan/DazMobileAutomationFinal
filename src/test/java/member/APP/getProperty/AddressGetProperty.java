package member.APP.getProperty;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 02-July-2019
 */

public class AddressGetProperty {

    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\address.properties"));
    }

    public String buyerName() throws IOException {
         fileInputStream();
        return prop.getProperty("BUYER_NAME");
    }

    public String buyerAddress() throws IOException {
        fileInputStream();
        return prop.getProperty("BUYER_ADDRESS");
    }

    public String buyerPhonePK() throws IOException {
        fileInputStream();
        return prop.getProperty("BUYER_PHONE_PK");
    }

    public String buyerPhoneBD() throws IOException {
        fileInputStream();
        return prop.getProperty("BUYER_PHONE_BD");
    }

    public String buyerPhoneLK() throws IOException {
        fileInputStream();
        return prop.getProperty("BUYER_PHONE_LK");
    }

    public String buyerPhoneNP() throws IOException {
        fileInputStream();
        return prop.getProperty("BUYER_PHONE_NP");
    }

    public String buyerPhoneMM() throws IOException {
        fileInputStream();
        return prop.getProperty("BUYER_PHONE_MM");
    }
}