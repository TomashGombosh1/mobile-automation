package com.mobile.automation.framework.module;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.mobile.automation.framework.service.DeviceServiceImpl;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Tomash Gombosh
 */
public class ServiceModule extends AbstractModule {
    @Inject
    private AppiumDriver<MobileElement> driver;

    @Override
    protected void configure() {
    }

    @Provides
    public DeviceServiceImpl getService() {
        return new DeviceServiceImpl(driver);
    }
}
