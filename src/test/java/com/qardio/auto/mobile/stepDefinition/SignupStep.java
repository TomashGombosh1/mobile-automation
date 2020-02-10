package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.DashboardScreen;
import com.qardio.auto.mobile.screens.ProfileScreen;
import com.qardio.auto.mobile.screens.SignUpScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
/**
 * @author Oleksii Borzykin
 */
public class SignupStep {
    private DashboardScreen dashboardScreen;
    private SignUpScreen signUpScreen;
    private ProfileScreen profileScreen;

    public SignupStep() {
        this.dashboardScreen = new DashboardScreen(Hooks.driver);
        this.signUpScreen = new SignUpScreen(Hooks.driver);
        this.profileScreen = new ProfileScreen(Hooks.driver);
    }

    @Given("^Tap on 'Create Account' button$")
    public void tapTheButton() {
        dashboardScreen.tapSignUp();
    }

    @When("^Enter valid information in 'First Name', 'Email' and 'Password' fields$")
    public void enterValidInformationInFirstNameEmailAndPasswordFields() {
        signUpScreen.fillSignup("qadecf", "qadecf1@gmail.com", "12345678");
    }

    @And("^Check the box for Terms and Conditions$")
    public void checkTheBoxForTermsAndConditions() {
        signUpScreen.setTermsAndConditionsCheckbox();
    }

    @Then("^'Register' button (is|is not) active$")
    public void registerButtonIsSetToActive(String status) {
        if (status.equals("is")) {
            assertThat(signUpScreen.isRegisterActive()).isEqualTo(true);
        }
        if (status.equals("is not")) {
            assertThat(signUpScreen.isRegisterActive()).isEqualTo(false);
        }
    }

    @When("^Tap 'Register' button$")
    public void tapRegisterButton() {
        signUpScreen.tapRegister();
    }

    @Then("^Profile form is opened$")
    public void profileFormIsOpened() {
        assertThat(profileScreen.isDisplayed()).isEqualTo(true);
    }

    @When("^Enter invalid information in 'First Name', 'Email' and 'Password' fields$")
    public void enterInvalidInformationInFirstNameEmailAndPasswordFields() {
        signUpScreen.fillSignup("a", "qadecf@@@gmail.com", "123456");
    }
}
