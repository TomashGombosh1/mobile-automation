package com.mobile.automation.framework.screens;

import io.appium.java_client.AppiumDriver;

/**
 * @author Tomash Gombosh
 */
public class DashboardScreeen extends AbstractScreen {
    public DashboardScreeen(final AppiumDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return allRequiredElementDisplayed();
    }
}
