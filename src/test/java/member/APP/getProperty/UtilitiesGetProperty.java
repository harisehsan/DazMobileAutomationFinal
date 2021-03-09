package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UtilitiesGetProperty {

    Properties prop = new Properties();


    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\utilities.properties"));
    }

    public List<String> eletricityBill() throws IOException {
        fileInputStream();
        List<String> electricityBill= new ArrayList<>();
        for (int i=0;i<3;i++)
            electricityBill.add(prop.getProperty("ELECTRICITY_BILL_PK_"+(i+1)));
        return electricityBill;
    }

    public List<String> waterBill() throws IOException {
        fileInputStream();
        List<String> waterBill= new ArrayList<>();
        for (int i=0;i<3;i++)
            waterBill.add(prop.getProperty("WATER_BILL_PK_"+(i+1)));
        return waterBill;
    }

    public List<String> gasBill() throws IOException {
        fileInputStream();
        List<String> gasBill= new ArrayList<>();
        for (int i=0;i<3;i++)
            gasBill.add(prop.getProperty("GAS_BILL_PK_"+(i+1)));
        return gasBill;
    }

    public List<String> internetBill() throws IOException {
        fileInputStream();
        List<String> waterBill= new ArrayList<>();
        for (int i=0;i<3;i++)
            waterBill.add(prop.getProperty("INTERNET_BILL_PK_"+(i+1)));
        return waterBill;
    }

    public List<String> lkBills() throws IOException {
        fileInputStream();
        List<String> lkBill= new ArrayList<>();
        for (int i=0;i<3;i++)
            lkBill.add(prop.getProperty("BILL_LK_"+(i+1)));
        return lkBill;
    }



}