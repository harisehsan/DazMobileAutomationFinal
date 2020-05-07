package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Drivers;
import member.APP.pages.FacebookSignUp;
import member.APP.pages.GmailSignUp;
import member.APP.pages.Logout;
import member.APP.pages.NavigateToSignUp;
import org.testng.Assert;

import java.io.IOException;

public class SignUpStep {
    Drivers drivers = new Drivers();
    NavigateToSignUp navigateToSignUp = new NavigateToSignUp(drivers.getDriver());
    GmailSignUp gmailSignUp = new GmailSignUp(drivers.getDriver());
    FacebookSignUp facebookSignUp = new FacebookSignUp(drivers.getDriver());
    Logout logout = new Logout(drivers.getDriver());
    String GMAIL_NAME;
    String FACEBOOK_NAME;

    @And("I navigate to the signup screen")
    public void iNavigateToTheSignupScreen() {
        navigateToSignUp.navigateToSignUpScreen();
    }

    @And("I select signup using google account")
    public void iSignupUsingGmailOption() throws IOException {
          gmailSignUp.signupUsingGmail();
    }

    @And("I should be signed up using google account")
    public void iShouldBeSignedUp() {
      Assert.assertEquals(GMAIL_NAME, gmailSignUp.gmailSignupVerification(),"Accout Holder gmail name is not same!");
    }

    @Then("I log out")
    public void iLogOut() {
        logout.logout();
    }

    @And("I select signup using facebook option")
    public void iSignupUsingFacebookOption() {
       facebookSignUp.signUpUsingFacebook();
    }


    @And("I should be signed up using facebook account")
    public void iShouldBeSignedUpUsingFacebookAccount() {
        Assert.assertEquals(FACEBOOK_NAME, facebookSignUp.facebookSignupVerififcation(),"Accout Holder facebook name is not same!");
    }

    @And("I provide name for google account")
    public void iProvideNameForGoogleAccount() throws IOException {
        GMAIL_NAME = gmailSignUp.gmailName();
    }

    @And("I select date of birth and gender for google account")
    public void iSelectDateOfBirthAndGenderForGoogleAccount() {
        gmailSignUp.gmailDOBAndGender();
    }

    @And("I provide the email address for google account")
    public void iProvideTheRandomEmailAddressForGoogleAccount() throws IOException {
        gmailSignUp.gmailAddress();
    }

    @And("I provide password for google account")
    public void iProvidePasswordForGoogleAccount() throws IOException {
        gmailSignUp.gmailPassword();
    }

    @And("I accept privacy terms and conditions for google account")
    public void iAcceptPrivacyTermsAndConditionsForGoogleAccount() {
        gmailSignUp.gmailPhoneAndPrivacy();
    }

    @And("I agree the policy agreement for facebook account")
    public void iAgreeThePolicyAgreementForFacebookAccount() {
     facebookSignUp.policyAgreement();
    }

    @And("I provide name email and password for facebook account")
    public void iProvideNameEmailAndPasswordForFacebookAccount() throws IOException {
       FACEBOOK_NAME = facebookSignUp.emailAndPassword();
    }

    @And("I select message")
    public void iSelectMessage() {
        
    }

    @When("I select Login")
    public void iSelectLogin() {
    }

    @Then("I should be on the login page")
    public void iShouldBeOnTheLoginPage() {
    }
}
