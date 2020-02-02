package com.mobile.automation.framework.tests.stepDefinitions;

import javax.inject.Inject;

import com.mobile.automation.framework.screens.LoginScreen;
import io.cucumber.java.en.Given;

/**
 * @author Tomash Gombosh
 */
public class LoginSteps extends BaseStep {
    @Inject
    private LoginScreen loginScreen;

    @Given("^ I am on the login screen")
    public void iAmOnTheLoginScreen() throws Throwable {
        loginScreen.isDisplayed();
    }
}
