package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MostPopularPageObject {

    @AndroidFindBy (xpath = "//*[@text='Most Popular']") public List <WebElement> most_Popular_lbl;
    @AndroidFindBy(id = "com.daraz.android:id/laz_homepage_most_popular_v2_time_textview") public List <WebElement> most_Popular_Month_lbl;

    @AndroidFindBy(id = "com.shop.android:id/laz_homepage_most_popular_v2_time_textview") public List <WebElement> most_Popular_Month_lbl_MM;

    @AndroidFindBy (xpath = "//*[@text='সর্বাধিক জনপ্রিয়']") public List <WebElement> most_Popular_Local_lbl_BD;

    @AndroidFindBy (xpath = "//*[@text='වඩාත් ප්\u200Dරසිද්ධ']") public List <WebElement> most_Popular_Local_lbl_LK;

    @AndroidFindBy (xpath = "//*[@text='सर्वाधिक लोकप्रिय']") public List <WebElement> most_Popular_Local_lbl_NP;

    @AndroidFindBy (xpath = "//*[@text='ေပၚျပဴလာအျဖစ္ဆံုး']") public List <WebElement> most_Popular_Local_lbl_MM;

    @AndroidFindBy(id = "com.daraz.android:id/laz_homepage_item_most_popular_v2_hot_title") public List <WebElement> most_popluar_classification;

    @AndroidFindBy(id = "com.shop.android:id/laz_homepage_item_most_popular_v2_hot_title") public List <WebElement> most_popluar_classification_MM;

    @AndroidFindBy(id = "com.daraz.android:id/iv_search") public List <WebElement> search_Most_Popular_icon;

    @AndroidFindBy (id = "com.shop.android:id/iv_search") public List <WebElement> search_Most_Popular_icon_MM;

}
