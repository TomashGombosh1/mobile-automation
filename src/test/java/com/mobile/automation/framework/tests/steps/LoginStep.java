package com.mobile.automation.framework.tests.steps;

import javax.inject.Inject;

import com.mobile.automation.framework.screens.DashboardScreeen;
import com.mobile.automation.framework.screens.LoginScreen;
import io.cucumber.java.en.Given;

/**
 * @author Tomash Gombosh
 */
public class LoginStep {
    @Inject
    private LoginScreen loginScreen;
    @Inject
    private DashboardScreeen dashboardScreeen;

    @Given("I am on Login Page")
    public void iAmOnLoginPage() {

    }
}
