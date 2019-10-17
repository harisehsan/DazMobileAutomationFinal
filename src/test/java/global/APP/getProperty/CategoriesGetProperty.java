package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 17-October-2019
 */

public class CategoriesGetProperty {

    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\global\\APP\\properties\\categories.property"));
    }

    private int size = 5;

    public List<String> categoriesTabs() throws IOException {
        fileInputStream();
        List<String> categoriesTabsList = new ArrayList<>();
        for (int i=0; i<size ;i++)
            categoriesTabsList.add(prop.getProperty("CATEGORIES_TAB_"+(i+1)));
        return categoriesTabsList;
    }

    public List<String> categoriesTitle() throws IOException {
        fileInputStream();
        List<String> categoriesTitleList = new ArrayList<>();
        for (int i=0; i<size ;i++)
            categoriesTitleList.add(prop.getProperty("CATEGORIES_TITLE_"+(i+1)));
        return categoriesTitleList;
    }

    public List<String> goodsTab() throws IOException {
        fileInputStream();
        List<String> goodsTabList = new ArrayList<>();
        for (int i=0; i<(size-2) ;i++)
            goodsTabList.add(prop.getProperty("GOODS_TABS_"+(i+1)));
        return goodsTabList;
    }

}