package com.mobile.automation.framework.module;

import com.google.inject.AbstractModule;
import com.mobile.automation.framework.screens.DashboardScreen;
import com.mobile.automation.framework.screens.SignInScreen;
import io.appium.java_client.AppiumDriver;

/**
 * @author Tomash Gombosh
 */
public class ScreensModule extends AbstractModule {
    private final AppiumDriver driver;

    public ScreensModule(final AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void configure() {
        bind(DashboardScreen.class).toInstance(new DashboardScreen(driver));
        bind(SignInScreen.class).toInstance(new SignInScreen(driver));
    }
}
