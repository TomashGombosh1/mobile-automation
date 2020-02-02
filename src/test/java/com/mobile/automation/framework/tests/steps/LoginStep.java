package com.mobile.automation.framework.tests.steps;

import javax.inject.Inject;

import com.mobile.automation.framework.screens.LoginScreen;

/**
 * @author Tomash Gombosh
 */
public class LoginStep extends BaseStep {
    @Inject
    private LoginScreen loginScreen;


    public void iAmOnTheLoginScreen() throws Throwable {
        loginScreen.isDisplayed();
    }
}
