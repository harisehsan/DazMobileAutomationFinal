package globalPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class EnvPickerObject {

    @AndroidFindBy (id = "com.daraz.android:id/country_name") public List <WebElement> envName_lbl;
    public By envName_lbl_By = By.id("com.daraz.android:id/country_name");

}
