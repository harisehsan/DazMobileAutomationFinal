package global.APP.pages;

import global.APP.pageObjects.VenturePageObject;
import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.SignUpObjects;
import member.APP.pageObjects.StartScreenPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 20-July-2019
 */

public class Venture extends Base {

    SignUpObjects signUpObjects = new SignUpObjects();
    VenturePageObject venturePageObject = new VenturePageObject();
    StartScreenPageObjects startScreenPageObjects = new StartScreenPageObjects();

    public Venture(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), venturePageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), startScreenPageObjects);
    }

    public void navigateToVenture() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(signUpObjects.account_lbl_By);
            signUpObjects.account_lbl.get(3).click();
            waitUntilPresentOfElementBy(signUpObjects.settings_icon_By);
            signUpObjects.settings_icon.click();
            waitUntilPresentOfElementBy(venturePageObject.change_Country_header_By);
            venturePageObject.change_Country_header.click();

        } else {
            throw new RuntimeException("This test is Not Applicable for Shop MM!");
        }
    }

    public boolean verifyTheSelectedCountry() {
        switch (System.getProperty("env")) {
            case "pk.live": {
                return venturePageObject.current_country_rdoBtn.get(3).getAttribute("checked").equalsIgnoreCase("true");
            }

            case "bd.live": {
                return venturePageObject.current_country_rdoBtn.get(0).getAttribute("checked").equalsIgnoreCase("true");
            }

            case "lk.live": {
                return venturePageObject.current_country_rdoBtn.get(1).getAttribute("checked").equalsIgnoreCase("true");
            }

            case "np.live": {
                return venturePageObject.current_country_rdoBtn.get(2).getAttribute("checked").equalsIgnoreCase("true");
            }

            default: {
                return false;
            }
        }
    }

    public int changeVenture() {
       int country_Index;
        do {
            country_Index = randomNumberGenerator(venturePageObject.current_country_rdoBtn.size());
            venturePageObject.current_country_rdoBtn.get(country_Index).click();
        } while (!isExist(venturePageObject.change_Country_Continue_btn));
            venturePageObject.change_Country_Continue_btn.get(0).click();
            if (isExist(startScreenPageObjects.eng_Language_btn))
             startScreenPageObjects.eng_Language_btn.get(0).click();
             return country_Index;
    }

    public boolean verifyForTheChangedCountry(int country_Index)
    {
     return (venturePageObject.current_country_rdoBtn.get(country_Index).getAttribute("checked").equalsIgnoreCase("true"));
    }
}