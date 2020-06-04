package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Drivers;
import member.APP.pages.*;
import org.testng.Assert;

import java.io.IOException;

public class SignUpStep {
    Drivers drivers = new Drivers();
    NavigateToSignUp navigateToSignUp = new NavigateToSignUp(drivers.getDriver());
    GmailSignUp gmailSignUp = new GmailSignUp(drivers.getDriver());
    FacebookSignUp facebookSignUp = new FacebookSignUp(drivers.getDriver());
    Logout logout = new Logout(drivers.getDriver());
    Login login = new Login(drivers.getDriver());
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
        login.selectMessage();
    }

    @When("I select Login button on {string} screen")
    public void iSelectLogin(String screen) {
        login.selectLogin(screen);
    }

    @Then("I should be on the login page")
    public void iShouldBeOnTheLoginPage() {
       Assert.assertTrue(login.verifyTheLoginPage(),"Not successfully navigated to the login page!");
    }

    @Then("I should be login successfully")
    public void iShouldBeLoginSuccessfully() {
        Assert.assertTrue(login.verifyTheLogin(),"Login is not successful!");
    }

    @When("I select forget password link")
    public void iSelectForgetPasswordLink() {
     login.selectForgetPasswordLink();
    }

    @Then("I should be on the reset password page")
    public void iShouldBeOnTheResetPasswordPage() {
        Assert.assertTrue(login.verifyTheResetPassword(),"Not successfully navigated to forget/reset password page!");
    }

    @When("I enter email")
    public void iEnterEmail() throws IOException {
        login.enterLoginEmail();
    }

    @And("I enter password")
    public void iEnterPassword() throws IOException {
        login.enterLoginPassword();
    }

    @And("I select login button")
    public void iSelectLoginButton() {
        login.clickLoginButton();
    }

    @When("I select create an account")
    public void iSelectCreateAnAccount() {
        login.selectCreateAccountPage();
    }

    @Then("I should be on the create account page")
    public void iShouldBeOnTheCreateAccountPage() {
      Assert.assertTrue(login.verifyTheCreateAccountPage(),"Not successfully to navigated to register page");
    }

    @And("I select agree button")
    public void iSelectAgreeButton() {
       login.selectFacebookAgreeButton();
    }

    @And("I select first login button")
    public void iSelectFirstLoginButton() {
      login.selectFirstLoginButton();
    }
}