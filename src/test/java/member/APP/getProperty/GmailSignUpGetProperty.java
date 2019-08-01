package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GmailSignUpGetProperty {

    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\gmailSignUp.properties"));
    }

    public String getIndexPK() throws IOException {
        fileInputStream();
        return prop.getProperty("INDEX_PK"); }

    public String getIndexBD() throws IOException {
        fileInputStream();
        return prop.getProperty("INDEX_BD");
    }

    public String getIndexLK() throws IOException {
        fileInputStream();
        return prop.getProperty("INDEX_LK");
    }

    public String getIndexNP() throws IOException {
        fileInputStream();
        return prop.getProperty("INDEX_NP");
    }

    public String getIndexMM() throws IOException {
        fileInputStream();
        return prop.getProperty("INDEX_MM");
    }

    public String getFirstName() throws IOException {
        fileInputStream();
        return prop.getProperty("FIRST_NAME");
    }

    public String getFirstNameMM() throws IOException {
        fileInputStream();
        return prop.getProperty("FIRST_NAME_MM");
    }

    public String getLastName() throws IOException {
        fileInputStream();
        return prop.getProperty("LAST_NAME");
    }

    public String getPassword() throws IOException {
        fileInputStream();
        return prop.getProperty("PASSWORD");
    }

    public String getPasswordMM() throws IOException {
        fileInputStream();
        return prop.getProperty("PASSWORD_MM");}

    public String getDeviceCode() throws IOException {
        fileInputStream();
        return prop.getProperty("DEVICE_CODE");
    }
}