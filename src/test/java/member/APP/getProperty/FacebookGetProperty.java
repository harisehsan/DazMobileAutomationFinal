package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FacebookGetProperty {

    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\facebookSignup.properties"));
    }

    public String emailGetProperty() throws IOException {
        fileInputStream();
        return prop.getProperty("EMAIL");
    }

    public String passwordGetProperty() throws IOException {
        fileInputStream();
        return prop.getProperty("PASSWORD_FB");
    }

    public String nameGetProperty() throws IOException {
        fileInputStream();
        return prop.getProperty("NAME_FB");
    }

    public String nameMMGetProperty() throws IOException {
        fileInputStream();
        return prop.getProperty("NAME_MM");
    }
}