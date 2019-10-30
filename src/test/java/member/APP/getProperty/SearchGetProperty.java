package member.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 30-August-2019
 */

public class SearchGetProperty {

    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\member\\APP\\properties\\search.property"));
    }

    public List<String> storeSearchKeyword() throws IOException {
        fileInputStream();
        List<String> storeSearchKeyword = new ArrayList<>();
        for (int i=0;i<3;i++)
            storeSearchKeyword.add(prop.getProperty("STORE_SEARCH_"+(i+1)));
        return storeSearchKeyword;
    }
}