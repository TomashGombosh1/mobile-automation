package com.mobile.automation.framework.screens;

import io.appium.java_client.AppiumDriver;

/**
 * @author Tomash Gombosh
 */
public class LoginScreen extends AbstractScreen {
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return allRequiredElementDisplayed();
    }
}
