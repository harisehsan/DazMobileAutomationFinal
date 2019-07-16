package member.APP.pages;

import global.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.AddressPageObject;
import member.APP.pageObjects.SignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 02-July-2019
 */

public class Address extends Base {

    AddressPageObject addressPageObject = new AddressPageObject();
    SignUpObjects signUpObjects = new SignUpObjects();

    public Address(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), addressPageObject);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
    }

    public void navigateToAddressMenu() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) { // Code for all Daraz ventures except MM
            waitUntilPresentOfElementBy(signUpObjects.settings_icon_By);
            signUpObjects.settings_icon.click();
            waitUntilPresentOfElementBy(addressPageObject.address_Book_lbl_By);
            addressPageObject.address_Book_lbl.click();
        } else // Code for Shop (MM) app only
        {
            waitUntilPresentOfElementBy(signUpObjects.settings_icon_By_MM);
            signUpObjects.settings_icon_MM.click();
            waitUntilPresentOfElementBy(addressPageObject.address_Book_lbl_By);
            addressPageObject.address_Book_lbl.click();
        }
    }

    public void changeAddress(String name, String address, String phonePK, String phoneBD, String phoneLK, String phoneNP, String phoneMM) {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(addressPageObject.address_Text_Input_layout_By);
            addressPageObject.address_Text_Input_txtbox.get(0).sendKeys(name);
            switch (System.getProperty("env")) {
                case "pk.live":
                    addressPageObject.address_Text_Input_txtbox.get(1).sendKeys(phonePK);
                    break;
                case "bd.live":
                    addressPageObject.address_Text_Input_txtbox.get(1).sendKeys(phoneBD);
                    break;
                case "lk.live":
                    addressPageObject.address_Text_Input_txtbox.get(1).sendKeys(phoneLK);
                    break;
                case "np.live":
                    addressPageObject.address_Text_Input_txtbox.get(1).sendKeys(phoneNP);
                    break;
            }
            addressPageObject.address_Text_Input_txtbox.get(2).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
            addressPageObject.address_Location_Tree_lbl.get(randomNumberGenerator(addressPageObject.address_Location_Tree_lbl.size())).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
            addressPageObject.address_Location_Tree_lbl.get(randomNumberGenerator(addressPageObject.address_Location_Tree_lbl.size())).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
            addressPageObject.address_Location_Tree_lbl.get(randomNumberGenerator(addressPageObject.address_Location_Tree_lbl.size())).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Text_Input_layout_By);
            addressPageObject.address_Text_Input_txtbox.get(5).sendKeys(address);
        } else {
            waitUntilPresentOfElementBy(addressPageObject.address_Text_Input_layout_By_MM);
            addressPageObject.address_Text_Input_txtbox_MM.get(0).sendKeys(name);
            addressPageObject.address_Text_Input_txtbox_MM.get(1).sendKeys(address);
            addressPageObject.address_Text_Input_txtbox_MM.get(2).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By_MM);
            addressPageObject.address_Location_Tree_lbl_MM.get(randomNumberGenerator(addressPageObject.address_Location_Tree_lbl_MM.size())).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By_MM);
            addressPageObject.address_Location_Tree_lbl_MM.get(randomNumberGenerator(addressPageObject.address_Location_Tree_lbl_MM.size())).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By_MM);
            addressPageObject.address_Location_Tree_lbl_MM.get(randomNumberGenerator(addressPageObject.address_Location_Tree_lbl_MM.size())).click();
            waitUntilPresentOfElementBy(addressPageObject.address_Text_Input_layout_By_MM);
            addressPageObject.address_Text_Input_txtbox_MM.get(5).sendKeys(phoneMM);
        }

    }

    public void saveChanges() {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            addressPageObject.save_btn.click();
        else
            addressPageObject.save_btn_MM.click();
    }

    public boolean verifyAddressDetails(String name, String address) {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(addressPageObject.buyer_Name_lbl_By);
            for (int i = 0; i < addressPageObject.buyer_Name_lbl.size(); i++) {
                if (addressPageObject.buyer_Name_lbl.get(i).getText().equalsIgnoreCase(name) && addressPageObject.buyer_address_lbl.get(i).getText().equalsIgnoreCase(address))
                    return true;
            }
            return false;
//            return new boolean[]{addressPageObject.buyer_Name_lbl.getText().equalsIgnoreCase(name), addressPageObject.buyer_address_lbl.getText().equalsIgnoreCase(address)};
        }
     else

    {
        waitUntilPresentOfElementBy(addressPageObject.buyer_Name_lbl_By_MM);
        for (int i = 0; i < addressPageObject.buyer_Name_lbl_MM.size(); i++) {
            if (addressPageObject.buyer_Name_lbl_MM.get(i).getText().equalsIgnoreCase(name) && addressPageObject.buyer_address_lbl_MM.get(i).getText().equalsIgnoreCase(address))
                return true;
        }
        return false;
    }

}
    public void newAddress()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(addressPageObject.new_Address_btn_By);
            addressPageObject.new_Address_btn.click();
        }
        else
        {
            waitUntilPresentOfElementBy(addressPageObject.new_Address_btn_By_MM);
            addressPageObject.new_Address_btn_MM.click();
        }
    }

    public void makeDefault()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            if(addressPageObject.make_Default_chkbox.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                addressPageObject.make_Default_chkbox.get(0).click();
            if(addressPageObject.make_Default_chkbox.get(1).getAttribute("checked").equalsIgnoreCase("false"))
                addressPageObject.make_Default_chkbox.get(1).click();
        }
        else
        {
            if(addressPageObject.make_Default_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                addressPageObject.make_Default_chkbox_MM.get(0).click();
            if(addressPageObject.make_Default_chkbox_MM.get(1).getAttribute("checked").equalsIgnoreCase("false"))
                addressPageObject.make_Default_chkbox_MM.get(1).click();
        }
    }

    public void editAddress()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) { // Code for all Daraz ventures except MM
            waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By);
            addressPageObject.edit_Address_btn.get(0).click();
        } else // Code for Shop (MM) app only
        {
            waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By_MM);
            addressPageObject.edit_Address_btn_MM.get(0).click();
        }
    }

    public void deleteAddress()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live")) {
            while(isExist(addressPageObject.delete_Address_btn))
            {
                addressPageObject.delete_Address_btn.get(0).click();
                waitUntilPresentOfElementBy(addressPageObject.delete_Confirm_btn_By);
                addressPageObject.delete_Confirm_btn.click();
            }

        }
        else
        {
            while(isExist(addressPageObject.delete_Address_btn_MM))
            {
                addressPageObject.delete_Address_btn_MM.get(0).click();
                waitUntilPresentOfElementBy(addressPageObject.delete_Confirm_btn_By);
                addressPageObject.delete_Confirm_btn.click();
            }
        }
     }

    public boolean verifyTheRemovedAddress()
    {
        if (!System.getProperty("env").equalsIgnoreCase("mm.live"))
            return (!(isExist(addressPageObject.delete_Address_btn)));
        else
           return  (!(isExist(addressPageObject.delete_Address_btn_MM)));

    }

}