package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.HomeScreen;
import com.qardio.auto.mobile.screens.LoginScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Oleksii Borzykin
 */
public class LoginStep {
    private LoginScreen loginScreen;
    private HomeScreen homeScreen;

    public LoginStep() {
        this.loginScreen = new LoginScreen(Hooks.driver);
        this.homeScreen = new HomeScreen(Hooks.driver);
    }

    @Given("^I am on the \"Login\" screen$")
    public void iAmOnTheScreen() {
        loginScreen.isDisplayed();
    }

    @When("^I fill the form with (valid|invalid) data$")
    public void iFillTheFormWithData(String creds) {
        if (creds.equals("valid")) {
            loginScreen.fillLogin("april17d", "qwer");
        } else {
            loginScreen.fillLogin("test010101", "0101010test");
        }
    }

    @And("^I tap the \"Log in\" button$")
    public void iTapTheButton() {
        loginScreen.tapLogInButton();
    }

    @Then("^The \"Home\" screen (is|is not) opened$")
    public void theScreenIsOpened(String status) {
        if (status.equals("is")) {
            assertThat(homeScreen.getScreenTitle()).isEqualTo("Home");
            assertThat(homeScreen.getQrLabel()).isEqualTo("Scan Vehicle");
        } else {
            assertThat(loginScreen.isDisplayed()).isEqualTo(true);
        }
    }

    @Given("^I logged in as valid user$")
    public void iLoggedInAsValidUser() {
        iAmOnTheScreen();
        iFillTheFormWithData("valid");
        iTapTheButton();
        homeScreen.getScreenTitle();
    }
}
