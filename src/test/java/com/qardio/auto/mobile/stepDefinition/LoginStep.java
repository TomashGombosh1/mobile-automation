package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.config.ApplicationConfig;
import com.qardio.auto.mobile.models.User;
import com.qardio.auto.mobile.screens.DashboardScreen;
import com.qardio.auto.mobile.screens.ForgotPasswordScreen;
import com.qardio.auto.mobile.screens.SignInScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class LoginStep {
    private DashboardScreen dashboardScreen;
    private SignInScreen signInScreen;
    private ForgotPasswordScreen forgotPasswordScreen;

    public LoginStep() {
        this.dashboardScreen = new DashboardScreen(Hooks.driver);
        this.signInScreen = new SignInScreen(Hooks.driver);
        this.forgotPasswordScreen = new ForgotPasswordScreen(Hooks.driver);
    }

    @Given("^I am go to the Login Page$")
    public void iAmGoToTheLoginPage() {
        dashboardScreen.tapLogin();
    }

    @Given("I (?:tap|click) sign in button")
    public void iClickSignInButton() {
        signInScreen.tapLogin();
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

    @When("^I fill non existing user data$")
    public void iFillNonExistingUserData() {
        signInScreen.fillLogin(new User(data -> {
            data.setEmail("qashouldnotexist@gmail.com");
            data.setPassword("12345678");
        }));
    }

    @Then("^\"Sign in\" button (is|is not) active$")
    public void buttonIsNotActive(String status) {
        assertThat(signInScreen.isSignInButtonActive()).isEqualTo(false);
    }

    @When("^I fill invalid user data$")
    public void iFillInvalidUserData() {
        signInScreen.fillLogin(new User(data -> {
            data.setEmail("qashouldnotexist@@@gmail.com");
            data.setPassword("12345");
        }));
    }

    @When("^Tap on the 'Forgot password\\?' link$")
    public void tapOnTheForgotPasswordLink() {
        signInScreen.tapForgotPassword();
    }

    @And("^Enter existing email into 'Email' field from 'Reset password' screen$")
    public void enterExistingEmailIntoEmailField() {
        forgotPasswordScreen.fillEmail("qadc@ukr.net");
    }

    @And("^Tap on the 'Reset password' button$")
    public void tapOnTheResetPasswordButton() {
        forgotPasswordScreen.tapResetPassword();
    }

    @Then("^'We have sent you an email to reset your password' text is displayed$")
    public void weHaveSentYouAnEmailToResetYourPasswordTextIsDisplayed() {
        assertThat(forgotPasswordScreen.getPopupText()).isEqualTo("We have sent you an email to reset your password");
    }
}
