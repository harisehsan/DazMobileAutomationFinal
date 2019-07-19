package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AccountGetProperty {


    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\account.properties"));
    }

    public String userName() throws IOException {
        fileInputStream();
        return prop.getProperty("USER_NAME");
    }


}
