package com.qardio.auto.mobile;

import com.qardio.auto.mobile.config.drivers.DriverFactory;
import com.qardio.auto.mobile.service.AppiumServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Hooks {

    public static AppiumServer appiumServer = new AppiumServer();
    public static AppiumDriver<MobileElement> driver;

    @Before
    public void setUpDriver() {
        appiumServer.startServer();
        driver = new DriverFactory().getDriver();
    }

    @After
    public void tearDownDriver() {
        try {
            if (driver != null) {
                driver.quit();

            }
        } finally {
            appiumServer.stopServer();
        }
    }
}
