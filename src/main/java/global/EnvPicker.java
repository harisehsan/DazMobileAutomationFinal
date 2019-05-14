package global;

import globalPageObject.EnvPickerObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;


public class EnvPicker extends Base {

    EnvPickerObject envPickerObject = new EnvPickerObject();


    public EnvPicker(AppiumDriver<WebElement> driver) {
        super(driver);
    }



    public void envPicker(String env)
    { if(waitWithoutException(envPickerObject.envName_lbl_By))
        {
          if (env.isEmpty()) env = "pk.live";
          switch(env) {
             case "bd.live":
                envPickerObject.envName_lbl.get(0).click();
                 System.out.println("Selected Venture: "+ envPickerObject.envName_lbl.get(0).getText());
                 break;
             case "lk.live":
                envPickerObject.envName_lbl.get(1).click();
                 System.out.println("Selected Venture: "+ envPickerObject.envName_lbl.get(1).getText());
                 break;
             case "np.live":
                envPickerObject.envName_lbl.get(2).click();
                 System.out.println("Selected Venture: "+ envPickerObject.envName_lbl.get(2).getText());
                 break;
             case "pk.live":
                envPickerObject.envName_lbl.get(3).click();
                 System.out.println("Selected Venture: "+ envPickerObject.envName_lbl.get(3).getText());
                  break;
             default : throw new RuntimeException("Venture not found!");
            }
        }
    }

}
