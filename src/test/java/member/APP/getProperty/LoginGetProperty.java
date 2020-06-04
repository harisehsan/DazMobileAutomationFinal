package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoginGetProperty {
    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\login.properties"));
    }

    public List<String> loginEmail() throws IOException {
        fileInputStream();
        List<String> loginemail = new ArrayList<>();
        loginemail.add(prop.getProperty("LOGIN_PK"));
        loginemail.add(prop.getProperty("LOGIN_BD"));
        loginemail.add(prop.getProperty("LOGIN_LK"));
        loginemail.add(prop.getProperty("LOGIN_NP"));
        loginemail.add(prop.getProperty("LOGIN_MM"));
        return loginemail;
    }

    public String loginPassword() throws IOException
    {
        fileInputStream();
        return prop.getProperty("LOGIN_PASSWORD");
    }
}
