package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserGrowthGetProperty {

    Properties prop = new Properties();


    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\userGrowth.properties"));
    }

    public List<String> pkEmail() throws IOException {
        fileInputStream();
        List<String> emailData= new ArrayList<>();
        for (int i=0;i<2;i++)
            emailData.add(prop.getProperty("NEW_EMAIL_PK_"+(i+1)));
        return emailData;
    }

    public List<String> pkPassword() throws IOException {
        fileInputStream();
        List<String> passwordlst = new ArrayList<>();
        for (int i=0;i<2;i++)
            passwordlst.add(prop.getProperty("NEW_PASSWORD_PK_"+(i+1)));
        return passwordlst;
    }

    public List<String> bdEmail() throws IOException {
        fileInputStream();
        List<String> emaillst = new ArrayList<>();
        for (int i=0;i<2;i++)
            emaillst.add(prop.getProperty("NEW_EMAIL_BD_"+(i+1)));
        return emaillst;
    }

    public List<String> bdPassword() throws IOException {
        fileInputStream();
        List<String> passwordlst = new ArrayList<>();
        for (int i=0;i<2;i++)
            passwordlst.add(prop.getProperty("NEW_PASSWORD_BD_"+(i+1)));
        return passwordlst;
    }

    public List<String> lkEmail() throws IOException {
        fileInputStream();
        List<String> emaillst = new ArrayList<>();
        for (int i=0;i<2;i++)
            emaillst.add(prop.getProperty("NEW_EMAIL_LK_"+(i+1)));
        return emaillst;
    }

    public List<String> lkPassword() throws IOException {
        fileInputStream();
        List<String> passwordlst = new ArrayList<>();
        for (int i=0;i<2;i++)
            passwordlst.add(prop.getProperty("NEW_PASSWORD_LK_"+(i+1)));
        return passwordlst;
    }

    public List<String> npEmail() throws IOException {
        fileInputStream();
        List<String> emaillst = new ArrayList<>();
        for (int i=0;i<2;i++)
            emaillst.add(prop.getProperty("NEW_EMAIL_NP_"+(i+1)));
        return emaillst;
    }

    public List<String> npPassword() throws IOException {
        fileInputStream();
        List<String> passwordlst = new ArrayList<>();
        for (int i=0;i<2;i++)
            passwordlst.add(prop.getProperty("NEW_PASSWORD_NP_"+(i+1)));
        return passwordlst;
    }


    public List<String> mmEmail() throws IOException {
        fileInputStream();
        List<String> emaillst = new ArrayList<>();
        for (int i=0;i<2;i++)
            emaillst.add(prop.getProperty("NEW_EMAIL_MM_"+(i+1)));
        return emaillst;
    }

    public List<String> mmPassword() throws IOException {
        fileInputStream();
        List<String> passwordlst = new ArrayList<>();
        for (int i=0;i<2;i++)
            passwordlst.add(prop.getProperty("NEW_PASSWORD_MM_"+(i+1)));
        return passwordlst;
    }


}
