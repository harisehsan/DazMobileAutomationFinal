package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Drivers;
import member.APP.getProperty.AddressGetProperty;
import member.APP.pages.Address;
import member.APP.pages.NavigateToSignUp;
import org.testng.Assert;

import java.io.IOException;


public class AddressSteps {

    Drivers drivers = new Drivers();
    NavigateToSignUp navigateToSignUp = new NavigateToSignUp(drivers.getDriver());
    Address address = new Address(drivers.getDriver());
    AddressGetProperty addressGetProperty = new AddressGetProperty();

    @And("I navigate to the signin screen")
    public void iNavigateToTheSigninScreen() {
        navigateToSignUp.navigateToSigninScreen();
    }

    @And("I navigate to address menu")
    public void iNavigateToAddressMenu() {
        address.navigateToAddressMenu();
    }

    @And("I edit the address details")
    public void editTheAddress() throws IOException {
        address.changeAddress(addressGetProperty.buyerName(),addressGetProperty.buyerAddress(),addressGetProperty.buyerPhonePK(),addressGetProperty.buyerPhoneBD(),addressGetProperty.buyerPhoneLK(),addressGetProperty.buyerPhoneNP(),addressGetProperty.buyerPhoneMM());
    }

    @And("I save the changes")
    public void iSaveTheChanges() {
        address.saveChanges();
    }

    @Then("I verify the address details")
    public void iVerifyTheChangeInAddress() throws IOException {
        Assert.assertTrue(address.verifyAddressDetails(addressGetProperty.buyerName(),addressGetProperty.buyerAddress()),"Buyer Name/Address not matched!");
    }

    @And("I click on new address button")
    public void iClickOnNewAddressButton() {
       address.newAddress();
    }

    @And("I add the address details")
    public void iAddTheAddressDetails() throws IOException {
        editTheAddress();
    }

    @And("I click on edit address button")
    public void iClickOnEditAddressButton() {
     address.editAddress();
    }

    @And("I delete all the deletable addresses")
    public void iDeleteAllTheDeletableAddresses() {
       address.deleteAddress();
    }

    @Then("I verify that all deletable address removed successfully")
    public void iVerifyThatAllDeletableAddressRemovedSuccessfully() {
      Assert.assertTrue(address.verifyTheRemovedAddress(),"Deletable addresses are not removed successfully!");
    }

    @And("I make the address default billing and shipping address")
    public void iMakeTheAddressDefaultBillingAndShippingAddress() {
        address.makeDefault();
    }

    @And("I make the address default {string} address only")
    public void iMakeTheAddressDefaultShippingAddressOnly(String addressType) {
        address.makeDefaultShippingAddressOnly(addressType);
    }

    @And("I verify default address delete restriction message")
    public void iVerifyDefaultAddressDeleteRestrictionMessage() {
    }

    @And("I select the edit button of the {string} address")
    public void iSelectTheEditButtonOfTheAddress(String order) {
        address.selectEditAddressByOrder(order);
    }

    @When("I select the delete button")
    public void iSelectTheDeleteButton() { 
        address.selectDeletebutton();
    }

    @Then("I should see the delete restriction message")
    public void iShouldSeeTheDeleteRestrictionMessage() {
        Assert.assertTrue(address.verifyTheDeleteRestrictionMessage(),"The Delete restriction message for default address is not shown!");
    }

    @And("I navigate back to the address menu")
    public void iNavigateBackToTheAddressMenu() {

    }

    @When("I scroll to the {string} button")
    public void iScrollToTheButton(String addressType) {
      address.scrollTotheAddressbuttonLocation(addressType);
    }

    @And("I select the {string} button")
    public void iSelectTheButton(String addressType) {
     address.selectTheAddressLocation(addressType);
    }

    @Then("I should see the address set as {string}")
    public void iShouldSeeTheAddressSetAs(String addressType) {
        address.verifyTheExistenceOfAddressLocation(addressType);
    }
}