package global.APP.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Drivers;
import member.APP.pages.FacebookSignUp;
import member.APP.pages.GmailSignUp;
import member.APP.pages.Logout;
import member.APP.pages.NavigateToSignUp;
import org.testng.Assert;

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

    @And("I signup using gmail option")
    public void iSignupUsingGmailOption()  {
          gmailSignUp.signupUsingGmail();
          GMAIL_NAME = gmailSignUp.gmailName();
          gmailSignUp.gmailDOBAndGender();
          gmailSignUp.gmailAddress();
          gmailSignUp.gmailPassword();
          gmailSignUp.gmailPhoneAndPrivacy();
    }

    @And("I should be signed up using gmail account")
    public void iShouldBeSignedUp() {
      Assert.assertEquals(GMAIL_NAME, gmailSignUp.gmailSignupVerification(),"Accout Holder gmail name is not same!");
    }

    @Then("I log out")
    public void iLogOut() {
        logout.logout();
    }

    @And("I signup using facebook option")
    public void iSignupUsingFacebookOption() {
       FACEBOOK_NAME = facebookSignUp.signUpUsingFacebook();
    }


    @And("I should be signed up using facebook account")
    public void iShouldBeSignedUpUsingFacebookAccount() {
        Assert.assertEquals(FACEBOOK_NAME, facebookSignUp.facebookSignupVerififcation(),"Accout Holder facebook name is not same!");
    }
}
