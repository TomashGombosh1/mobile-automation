package com.mobile.automation.framework.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mobile.automation.framework.config.drivers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    public AppiumDriver<MobileElement> getDriver(DriverFactory driverFactory) {
        return driverFactory.getDriver();
    }

}
