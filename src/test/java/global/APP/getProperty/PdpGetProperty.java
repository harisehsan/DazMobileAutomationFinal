package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 21-November-2019
 */

public class PdpGetProperty {
    private int listSize = 14;
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\pdp.property"));
    }

    public String getProductSKU(String key) throws IOException {
        fileInputStream();
        switch (System.getProperty("env")) {
            case "pk.live": {
                return  prop.getProperty("PRODUCT_PK_"+key.replaceAll("\\s",""));
            }
            case "bd.live":{
                return prop.getProperty("PRODUCT_BD_"+key.replaceAll("\\s",""));
            }
            case "lk.live":{
                return prop.getProperty("PRODUCT_LK_"+key.replaceAll("\\s",""));
            }
            case "np.live":{
                return prop.getProperty("PRODUCT_NP_"+key.replaceAll("\\s",""));
            }
            case "mm.live":{
                return prop.getProperty("PRODUCT_MM_"+key.replaceAll("\\s",""));
            }
        }
        return null;
    }


    public List<String> productPK() throws IOException {
        fileInputStream();
        List<String> productPK = new ArrayList<>();
       for (int i=0; i<listSize;i++) {
           productPK.add(prop.getProperty("PRODUCT_PK_" + (i + 1)));
       }
       return productPK;
    }

    public List<String> productBD() throws IOException {
        fileInputStream();
        List<String> productBD = new ArrayList<>();
        for (int i=0; i<listSize;i++) {
            productBD.add(prop.getProperty("PRODUCT_BD_" + (i + 1)));
        }return productBD;
    }

    public List<String> productLK() throws IOException {
        fileInputStream();
        List<String> productLK = new ArrayList<>();
        for (int i=0; i<listSize;i++)
            productLK.add(prop.getProperty("PRODUCT_LK_"+(i+1)));
        return productLK;
    }

    public List<String> productNP() throws IOException {
        fileInputStream();
        List<String> productNP = new ArrayList<>();
        for (int i=0; i<listSize;i++)
            productNP.add(prop.getProperty("PRODUCT_NP_"+(i+1)));
        return productNP;
    }

    public List<String> productMM() throws IOException {
        fileInputStream();
        List<String> productMM = new ArrayList<>();
        for (int i=0; i<listSize;i++)
            productMM.add(prop.getProperty(("PRODUCT_MM_"+(i+1))));
        return productMM;
    }
}