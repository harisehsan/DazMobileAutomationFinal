package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DeliveredOrderGetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\delivered.property"));
    }

    //PK

    public String pkNormal() throws IOException {
        fileInputStream();
        return prop.getProperty("NORMAL_PK");
    }

    public String pkB1G1() throws IOException {
        fileInputStream();
        return prop.getProperty("B1G1_PK");
    }

    public String pkFG() throws IOException {
        fileInputStream();
        return prop.getProperty("FG_PK");
    }

    public String pkBMSM() throws IOException {
        fileInputStream();
        return prop.getProperty("BMSM_PK");
    }

    public String pkCombo() throws IOException {
        fileInputStream();
        return prop.getProperty("COMBO_PK");
    }

    //BD

    public String bdNormal() throws IOException {
        fileInputStream();
        return prop.getProperty("NORMAL_BD");
    }

    public String bdB1G1() throws IOException {
        fileInputStream();
        return prop.getProperty("B1G1_BD");
    }

    public String bdFG() throws IOException {
        fileInputStream();
        return prop.getProperty("FG_BD");
    }

    public String bdBMSM() throws IOException {
        fileInputStream();
        return prop.getProperty("BMSM_BD");
    }

    public String bdCombo() throws IOException {
        fileInputStream();
        return prop.getProperty("COMBO_BD");
    }

    //LK

    public String lkNormal() throws IOException {
        fileInputStream();
        return prop.getProperty("NORMAL_LK");
    }

    public String lkB1G1() throws IOException {
        fileInputStream();
        return prop.getProperty("B1G1_LK");
    }

    public String lkFG() throws IOException {
        fileInputStream();
        return prop.getProperty("FG_LK");
    }

    public String lkBMSM() throws IOException {
        fileInputStream();
        return prop.getProperty("BMSM_LK");
    }

    public String lkCombo() throws IOException {
        fileInputStream();
        return prop.getProperty("COMBO_LK");
    }

    //NP

    public String npNormal() throws IOException {
        fileInputStream();
        return prop.getProperty("NORMAL_NP");
    }

    public String npB1G1() throws IOException {
        fileInputStream();
        return prop.getProperty("B1G1_NP");
    }

    public String npFG() throws IOException {
        fileInputStream();
        return prop.getProperty("FG_NP");
    }

    public String npBMSM() throws IOException {
        fileInputStream();
        return prop.getProperty("BMSM_NP");
    }

    public String npCombo() throws IOException {
        fileInputStream();
        return prop.getProperty("COMBO_NP");
    }

    //MM

    public String mmNormal() throws IOException {
        fileInputStream();
        return prop.getProperty("NORMAL_MM");
    }

    public String mmB1G1() throws IOException {
        fileInputStream();
        return prop.getProperty("B1G1_MM");
    }

    public String mmFG() throws IOException {
        fileInputStream();
        return prop.getProperty("FG_MM");
    }

    public String mmBMSM() throws IOException {
        fileInputStream();
        return prop.getProperty("BMSM_MM");
    }

    public String mmCombo() throws IOException {
        fileInputStream();
        return prop.getProperty("COMBO_MM");
    }

}
