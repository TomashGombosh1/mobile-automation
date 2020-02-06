package com.mobile.automation.framework.stepDefinition;

import javax.inject.Inject;

import com.mobile.automation.framework.config.ProjectConfig;
import com.mobile.automation.framework.models.User;
import com.mobile.automation.framework.screens.DashboardScreen;
import com.mobile.automation.framework.screens.SignInScreen;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class LoginStep {
    @Inject
    private SignInScreen signInScreen;
    @Inject
    private DashboardScreen dashboardScreen;

    @Given("^I am go to the Login Page$")
    public void iAmGoToTheLoginPage() {
        dashboardScreen.tapLogin();
    }

    @And("I fill valid user data using {string} {string}")
    public void iFillValidUserDataUsing(String userName, String password) {
        signInScreen.fillLogin(userName, password);
    }

    @And("I fill valid user data using {string}")
    @ParameterType("Config")
    public void iFillValidUserDataUsing() {
        signInScreen.fillLogin(new User(data -> {
            data.setEmail(new ProjectConfig().getBaseUser());
            data.setPassword(new ProjectConfig().getBaseUserPassword());
        }));
    }

    @And("I click sign in button")
    public void iClickSignInButton() {
        signInScreen.clickLogin();
    }

    @Then("I am login in the application")
    public void iAmLoginInTheApplication() {
        assertThat(signInScreen.isDisplayed()).isEqualTo(true);
    }

}
