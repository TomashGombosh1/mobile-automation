package com.qardio.auto.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Oleksii Borzykin
 */
public class ProfileScreen extends AbstractScreen {
    public ProfileScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
