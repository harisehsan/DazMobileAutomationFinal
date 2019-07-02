package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import member.APP.getProperty.AddressGetProperty;
import member.APP.pages.Address;
import member.APP.pages.NavigateToSignUp;
import org.testng.Assert;

import java.io.IOException;


public class AddressSteps {

    Drivers drivers = new Drivers();
    NavigateToSignUp navigateToSignUp = new NavigateToSignUp(drivers.getDriver());
    Address editaddress = new Address(drivers.getDriver());
    AddressGetProperty addressGetProperty = new AddressGetProperty();

    @And("I navigate to the signin screen")
    public void iNavigateToTheSigninScreen() {
        navigateToSignUp.navigateToSigninScreen();
    }

    @And("I navigate to edit address screen")
    public void iNavigateToEditAddressScreen() {
        editaddress.navigateToEditAddress();
    }

    @And("I edit the address details")
    public void iEditTheAddress() throws IOException {
        editaddress.changeAddress(addressGetProperty.buyerName(),addressGetProperty.buyerAddress(),addressGetProperty.buyerPhonePK(),addressGetProperty.buyerPhoneBD(),addressGetProperty.buyerPhoneLK(),addressGetProperty.buyerPhoneNP(),addressGetProperty.buyerPhoneMM());
    }

    @And("I save the changes")
    public void iSaveTheChanges() {
        editaddress.saveChanges();
    }

    @Then("I verify the address details")
    public void iVerifyTheChangeInAddress() throws IOException {
        String [] addressDetails = editaddress.verifyChangeAddress();
        Assert.assertEquals(addressGetProperty.buyerName(),addressDetails[0],"Buyer Name is not matched!");
        Assert.assertEquals(addressGetProperty.buyerAddress(),addressDetails[1],"Buyer Address is not matched!");
    }
}