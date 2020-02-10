package com.mobile.automation.framework.stepDefinition;

import com.mobile.automation.framework.Hooks;
import com.mobile.automation.framework.config.ApplicationConfig;
import com.mobile.automation.framework.models.User;
import com.mobile.automation.framework.screens.DashboardScreen;
import com.mobile.automation.framework.screens.SignInScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class LoginStep {
    private DashboardScreen dashboardScreen;
    private SignInScreen signInScreen;

    public LoginStep() {
        this.dashboardScreen = new DashboardScreen(Hooks.driver);
        this.signInScreen = new SignInScreen(Hooks.driver);
    }

    @Given("^I am go to the Login Page$")
    public void iAmGoToTheLoginPage() {
        dashboardScreen.tapLogin();
    }

    @Given("I click sign in button")
    public void iClickSignInButton() {
        signInScreen.clickLogin();
    }

    @Then("I am login in the application")
    public void iAmLoginInTheApplication() {
        assertThat(signInScreen.isDisplayed()).isEqualTo(true);
    }

    @And("^I fill valid user data using properties file$")
    public void iFillValidUserDataUsingPropertiesFile() {
        signInScreen.fillLogin(new User(data -> {
            data.setEmail(new ApplicationConfig().getBaseUser());
            data.setPassword(new ApplicationConfig().getBaseUserPassword());
        }));
    }
}
