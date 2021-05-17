package member.APP.pages;

import com.sun.javafx.scene.traversal.Direction;
import global.Base;
import global.ThreadStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import member.APP.pageObjects.AddressPageObject;
import member.APP.pageObjects.SignUpObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) { // Code for all Daraz ventures except MM
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
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(addressPageObject.address_Text_Input_layout_By);
            addressPageObject.address_Text_Input_txtbox.get(0).sendKeys(name);
            switch (ThreadStorage.get("env")) {
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
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live"))
            addressPageObject.save_btn.click();
        else
            addressPageObject.save_btn_MM.click();
    }

    public boolean verifyAddressDetails(String name, String address) {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(addressPageObject.buyer_Name_lbl_By);
            for (int i = 0; i < addressPageObject.buyer_Name_lbl.size(); i++) {
                if (addressPageObject.buyer_Name_lbl.get(i).getText().equalsIgnoreCase(name) && addressPageObject.buyer_address_lbl.get(i).getText().equalsIgnoreCase(address))
                    return true;
            }
            return false;
//            return new boolean[]{addressPageObject.buyer_Name_lbl.getText().equalsIgnoreCase(name), addressPageObject.buyer_address_lbl.getText().equalsIgnoreCase(address)};
        } else {
            waitUntilPresentOfElementBy(addressPageObject.buyer_Name_lbl_By_MM);
            for (int i = 0; i < addressPageObject.buyer_Name_lbl_MM.size(); i++) {
                if (addressPageObject.buyer_Name_lbl_MM.get(i).getText().equalsIgnoreCase(name) && addressPageObject.buyer_address_lbl_MM.get(i).getText().equalsIgnoreCase(address))
                    return true;
            }
            return false;
        }

    }

    public void newAddress() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
           waitWithoutExceptionForElementsLessTime(addressPageObject.edit_Address_btn);
            waitUntilPresentOfElementBy(addressPageObject.new_Address_btn_By);
            addressPageObject.new_Address_btn.click();
        } else {
            waitWithoutExceptionForElementsLessTime(addressPageObject.edit_Address_btn_MM);
            waitUntilPresentOfElementBy(addressPageObject.new_Address_btn_By_MM);
            addressPageObject.new_Address_btn_MM.click();
        }
    }

    public void makeDefault() {
        int tries = 5;
        scrollDownMultipleTries(4);
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < tries; i++) {
                if (isExist(addressPageObject.make_Default_chkbox)) {
                    if (isExist(addressPageObject.make_Default_chkbox) && addressPageObject.make_Default_chkbox.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                        addressPageObject.make_Default_chkbox.get(0).click();
                    if (addressPageObject.make_Default_chkbox.size() > 1 && addressPageObject.make_Default_chkbox.get(1).getAttribute("checked").equalsIgnoreCase("false"))
                        addressPageObject.make_Default_chkbox.get(1).click();
                    break;
                } else
                    scrollDownMultipleTries(4);
            }
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(addressPageObject.make_Default_chkbox_MM)) {
                    if (addressPageObject.make_Default_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false"))
                        addressPageObject.make_Default_chkbox_MM.get(0).click();
                    if (addressPageObject.make_Default_chkbox_MM.get(1).getAttribute("checked").equalsIgnoreCase("false"))
                        addressPageObject.make_Default_chkbox_MM.get(1).click();
                    break;
                } else
                    scrollDownMultipleTries(4);
            }
        }
    }

    public void editAddress() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) { // Code for all Daraz ventures except MM
            waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By);
            addressPageObject.edit_Address_btn.get(0).click();
        } else // Code for Shop (MM) app only
        {
            waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By_MM);
            addressPageObject.edit_Address_btn_MM.get(0).click();
        }
    }

    public void deleteAddress() {
        int tries = 0;
        int deleteTries = 0;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            while (isExist(addressPageObject.edit_Address_btn) && deleteTries < 15) {
                waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By);
                scrollDownMultipleTries(10);
                addressPageObject.edit_Address_btn.get(addressPageObject.edit_Address_btn.size() - 1).click();
                waitUntilPresentOfElementBy(addressPageObject.address_Text_Input_layout_By);
                do {
                    scrollDownMultipleTries(4);
                    tries++;
                } while (!isExist(addressPageObject.delete_Address_btn) && tries < 5);
                addressPageObject.delete_Address_btn.get(0).click();
                if (isExist(addressPageObject.delete_Confirm_btn)) {
                    addressPageObject.delete_Confirm_btn.get(0).click();
                    deleteTries++;
                } else {
                    driver.navigate().back();
                    return;
                }
            }

        } else {
            while (isExist(addressPageObject.edit_Address_btn_MM) && deleteTries < 15) {
                waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By_MM);
                scrollDownMultipleTries(10);
                addressPageObject.edit_Address_btn_MM.get(addressPageObject.edit_Address_btn_MM.size() - 1).click();
                waitUntilPresentOfElementBy(addressPageObject.address_Text_Input_layout_By_MM);
                do {
                    scrollDownMultipleTries(4);
                    tries++;
                } while (!isExist(addressPageObject.delete_Address_btn_MM) && tries < 5);
                addressPageObject.delete_Address_btn_MM.get(0).click();
                if (isExist(addressPageObject.delete_Confirm_btn)) {
                    addressPageObject.delete_Confirm_btn.get(0).click();
                    deleteTries++;
                } else {
                    driver.navigate().back();
                    return;
                }
            }
        }
    }

    public boolean verifyTheRemovedAddress() {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live"))
            return (addressPageObject.edit_Address_btn.size() > 0 && addressPageObject.edit_Address_btn.size() < 3);
        else
            return (addressPageObject.edit_Address_btn_MM.size() > 0 && addressPageObject.edit_Address_btn_MM.size() < 3);

    }

    public void makeDefaultShippingAddressOnly(String addressType) {
        int tries = 5;
        scrollDownMultipleTries(4);
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            for (int i = 0; i < tries; i++) {
                if (isExist(addressPageObject.make_Default_chkbox)) {
                    if (addressType.equalsIgnoreCase("shipping")) {
                        if (isExist(addressPageObject.make_Default_chkbox) && addressPageObject.make_Default_chkbox.get(0).getAttribute("checked").equalsIgnoreCase("false")) {
                            addressPageObject.make_Default_chkbox.get(0).click();
                            break;
                        }
                    } else if (addressType.equalsIgnoreCase("billing")) {
                        if (isExist(addressPageObject.make_Default_chkbox) && addressPageObject.make_Default_chkbox.get(1).getAttribute("checked").equalsIgnoreCase("false"))
                            addressPageObject.make_Default_chkbox.get(1).click();
                        break;
                    }
                } else
                    scrollDownMultipleTries(4);
            }
        } else {
            for (int i = 0; i < tries; i++) {
                if (isExist(addressPageObject.make_Default_chkbox_MM)) {
                    if (addressType.equalsIgnoreCase("shipping")) {
                        if (isExist(addressPageObject.make_Default_chkbox_MM) && addressPageObject.make_Default_chkbox_MM.get(0).getAttribute("checked").equalsIgnoreCase("false")) {
                            addressPageObject.make_Default_chkbox_MM.get(0).click();
                            break;
                        }
                    } else if (addressType.equalsIgnoreCase("billing")) {
                        if (isExist(addressPageObject.make_Default_chkbox_MM) && addressPageObject.make_Default_chkbox_MM.get(1).getAttribute("checked").equalsIgnoreCase("false"))
                            addressPageObject.make_Default_chkbox_MM.get(1).click();
                        break;
                    }
                } else
                    scrollDownMultipleTries(4);
            }
        }
    }

    public void selectEditAddressByOrder(String order) throws InterruptedException {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By);
            if (order.equalsIgnoreCase("first")) {
                Thread.sleep(5000);
                swipeScreenSmall(Direction.DOWN);
                addressPageObject.edit_Address_btn.get(0).click();
            } else {
                Thread.sleep(5000);
                swipeScreenSmall(Direction.DOWN);
                addressPageObject.edit_Address_btn.get(1).click();
            }
        } else {
            waitUntilPresentOfElementBy(addressPageObject.edit_Address_btn_By_MM);
            if (order.equalsIgnoreCase("first"))
                addressPageObject.edit_Address_btn_MM.get(0).click();
            else
                addressPageObject.edit_Address_btn_MM.get(1).click();
        }

    }

    public void selectDeletebutton() {
        scrollDownMultipleTries(6);
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            while (!isExist(addressPageObject.delete_Address_btn))
                swiptToBottom();
            addressPageObject.delete_Address_btn.get(0).click();
        } else {
            while (!isExist(addressPageObject.delete_Address_btn_MM))
                swiptToBottom();
            addressPageObject.delete_Address_btn_MM.get(0).click();
        }
    }

    public boolean verifyTheDeleteRestrictionMessage()
    {
         return (isExist(addressPageObject.delete_Confirm_Message_lbl));
    }

    public void scrollTotheAddressbuttonLocation(String addressType) {
        int tries = 10;
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            if (addressType.contains("HOME")) {
                while (!isExist(addressPageObject.address_Home_btn) && tries < 15) {
                    swiptToBottom();
                    tries++;
                }
            }
            else
            {
                while (!isExist(addressPageObject.address_Office_btn) && tries < 15) {
                    swiptToBottom();
                    tries++;
                }
            }
        } else {
            if (addressType.contains("HOME")) {
                while (!isExist(addressPageObject.address_Home_btn_MM) && tries < 15) {
                    swiptToBottom();
                    tries++;
                }
            }
            else
            {
                while (!isExist(addressPageObject.address_Office_btn_MM) && tries < 15) {
                    swiptToBottom();
                    tries++;
                }
            }
        }
    }

    public void selectTheAddressLocation(String addressType) {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            if (addressType.contains("HOME")) {
                addressPageObject.address_Home_btn.get(0).click();
            } else {
                addressPageObject.address_Office_btn.get(0).click();
            }
        } else {
            if (addressType.contains("HOME")) {
                addressPageObject.address_Home_btn_MM.get(0).click();
            } else {
                addressPageObject.address_Office_btn_MM.get(0).click();
            }
        }
    }
    public boolean verifyTheExistenceOfAddressLocation(String addressType)
    {
        if (!ThreadStorage.get("env").equalsIgnoreCase("mm.live")) {
            return addressPageObject.addressLocationlbl.getText().contains(addressType);
        }
        else
        {
            return addressPageObject.addressLocationlblMM.getText().contains(addressType);
        }
    }

    public void selectPickUpPointsFromCollectionPoints()
    {
       waitForElementToClickable(addressPageObject.pickupPoint_lbl,60);
        addressPageObject.pickupPoint_lbl.click();
        waitForElementToClickable(addressPageObject.pickUp_Point_chkbox,60);
        addressPageObject.pickUp_Point_chkbox.click();
        addressPageObject.pickup_Confirm_btn.click();

    }

    public boolean verifyTheCollectionPoint()
    {
        return addressPageObject.checkout_Address_lbl.getText().contains("COLLECTION POINT");
    }

    public void addCollectionPointAddresses(List<String> pklst, List<String> bdlst, List<String> nplst, List<String> lklst)
    {
        int tries = 0;
        addressPageObject.address_Text_Input_txtbox.get(2).click();
        switch (ThreadStorage.get("env"))
        {
            case "pk.live":
            {
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(pklst.get(0)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(pklst.get(0)).click();
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(pklst.get(1)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(pklst.get(1)).click();

                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(pklst.get(2)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(pklst.get(2)).click();
            }
            break;
            case "bd.live":
            {
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(bdlst.get(0)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(bdlst.get(0)).click();
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(bdlst.get(1)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(bdlst.get(1)).click();
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(bdlst.get(2)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(bdlst.get(2)).click();
            }
            break;
            case "np.live":
            {
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(nplst.get(0)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(nplst.get(0)).click();
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(nplst.get(1)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(nplst.get(1)).click();

                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(nplst.get(2)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(nplst.get(2)).click();
            }
            break;
            case "lk.live":
            {
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(lklst.get(0)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(lklst.get(0)).click();
                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(lklst.get(1)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(lklst.get(1)).click();

                waitUntilPresentOfElementBy(addressPageObject.address_Location_Tree_lbl_By);
                while(!containsTextIsExist(lklst.get(2)) && tries <30)
                {
                    swiptToBottom();
                    tries++;
                }
                findElementByTextUsingExactString(lklst.get(2)).click();
            }
            break;

            default:
                throw new RuntimeException("Collection point is not applicable on this venture");
        }
    }

}