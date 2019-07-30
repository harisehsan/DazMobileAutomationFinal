package member.APP.setProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GmailSignupSetProperty {
    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\gmailSignUp.properties"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("src\\test\\java\\member\\APP\\properties\\gmailSignUp.properties"),null);
    }

    public void setEmail_PK(String index,String email) throws IOException {
        fileInputStream();
        prop.setProperty("EMAIL_PK_"+index, email+"@gmail.com");
        prop.setProperty("INDEX_PK", index);
        fileOutputStream();
    }

    public void setEmail_BD(String index,String email) throws IOException {
        fileInputStream();
        prop.setProperty("EMAIL_BD_"+index, email+"@gmail.com");
        prop.setProperty("INDEX_BD", index);
        fileOutputStream();
    }

    public void setEmail_LK(String index,String email) throws IOException {
        fileInputStream();
        prop.setProperty("EMAIL_LK_"+index, email+"@gmail.com");
        prop.setProperty("INDEX_LK", index);
        fileOutputStream();
    }

    public void setEmail_NP(String index,String email) throws IOException {
        fileInputStream();
        prop.setProperty("EMAIL_NP_"+index, email+"@gmail.com");
        prop.setProperty("INDEX_NP", index);
        fileOutputStream();
    }

    public void setEmail_MM(String index,String email) throws IOException {
        fileInputStream();
        prop.setProperty("EMAIL_MM_"+index, email+"@gmail.com");
        prop.setProperty("INDEX_MM", index);
        fileOutputStream();
    }
}