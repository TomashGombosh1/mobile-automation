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

    @When("^I fill the form with valid data$")
    public void iFillTheFormWithValidData() {
        loginScreen.fillLogin("april17d","qwer");
    }

    @And("^I tap the \"Log in\" button$")
    public void iTapTheButton()  {
        loginScreen.tapLogInButton();
    }

    @Then("^The \"Home\" screen is opened$")
    public void theScreenIsOpened() {
        assertThat(homeScreen.getScreenTitle()).isEqualTo("Home");
    }
}
