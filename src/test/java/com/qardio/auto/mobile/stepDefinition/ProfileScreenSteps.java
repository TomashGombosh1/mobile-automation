package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.LoginScreen;
import com.qardio.auto.mobile.screens.ProfileScreen;
import com.qardio.auto.mobile.screens.SignUpScreen;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class ProfileScreenSteps {
    private ProfileScreen profileScreen;
    private LoginScreen loginScreen;
    private SignUpScreen signUpScreen;

    public ProfileScreenSteps() {
        this.profileScreen = new ProfileScreen(Hooks.driver);
        this.loginScreen = new LoginScreen(Hooks.driver);
        this.signUpScreen = new SignUpScreen(Hooks.driver);
    }

    @Then("^i see button \"(login|sign-up)\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"([^\"]*)\"$")
    public void iSeeButtonIdentifiedByWithAttributeSetTo(String name, String attribute, String value) {
        assertThat(profileScreen.isDisplayed()).isEqualTo(true);
        assertThat(profileScreen.getButtonAttribute(name, attribute)).isEqualTo(Boolean.parseBoolean(value));
    }

    @When("^i click on button \"login\" identified by \"button_signin\"$")
    public void iClickOnButtonIdentifiedBy()  {
        profileScreen.tapSignInButton();
    }

    @Then("^i see (?:[^\"]*) \"(email|password|forgotten password|Show password)\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"([^\"]*)\"$")
    public void iSeeTextfieldIdentifiedByWithAttributeSetTo(String element, String attribute, String value) {
        assertThat(loginScreen.isDisplayed()).isEqualTo(true);
        assertThat(loginScreen.getElementAttribute(element, attribute)).isEqualTo(Boolean.parseBoolean(value));
    }

    @When("^i click on button \"close\" identified by \"(?:[^\"]*)\"$")
    public void iClickOnCloseButtonIdentifiedBy()  {
        loginScreen.tapCloseButton();
    }

    @When("^i click on button \"signup\" identified by \"button_signup\"$")
    public void iClickOnSignUpButton()  {
        profileScreen.tapSignUpButton();
    }

    @Then("^i see button \"(first name|last name|phone number)\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"([^\"]*)\"$")
    public void iSeeSignUpButtonIdentifiedByWithAttributeSetTo(String element, String attribute, String value) {
        assertThat(signUpScreen.isDisplayed()).isEqualTo(true);
        assertThat(signUpScreen.getElementAttribute(element, attribute)).isEqualTo(Boolean.parseBoolean(value));
    }
}
