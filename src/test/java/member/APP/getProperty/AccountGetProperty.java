package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 22-July-2019
 */

public class AccountGetProperty {


    Properties prop = new Properties();
     int orderStatusSize = 6;

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\account.properties"));
    }

    public String userName() throws IOException {
        fileInputStream();
        return prop.getProperty("USER_NAME");
    }

    public List<String> getOrderStatus1() throws IOException {
        fileInputStream();
        List <String> orderStatuslst = new ArrayList<>();
       for (int i=1; i<=3; i++)
       {
          orderStatuslst.add(prop.getProperty("ACCOUNT_STATUS_"+i));
       }
       return orderStatuslst;
    }

    public List<String> getOrderStatus2() throws IOException {
        fileInputStream();
        List<String> orderStatuslst2 = new ArrayList<>();
        for (int i = 4; i <= 6; i++) {
            orderStatuslst2.add(prop.getProperty("ACCOUNT_STATUS_"+i));
        }
        return orderStatuslst2;
    }

    public List<String> getOrderID() throws IOException {
        fileInputStream();
        List<String> orderIdlst = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            orderIdlst.add(prop.getProperty("ACCOUNT_STATUS_ID_" +i));
        }
        return orderIdlst;
    }
}
