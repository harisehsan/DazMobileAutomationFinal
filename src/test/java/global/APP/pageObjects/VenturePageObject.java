package global.APP.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 20-August-2019
 */

public class VenturePageObject {

  @AndroidFindBy(id = "com.daraz.android:id/changeCountryHeader") public WebElement change_Country_header;
  @AndroidFindBy (id = "com.daraz.android:id/current_country_checked") public List <WebElement> current_country_rdoBtn;
  @AndroidFindBy (id = "android:id/button1") public List <WebElement>  change_Country_Continue_btn;

  public By change_Country_header_By = By.id("com.daraz.android:id/changeCountryHeader");
}