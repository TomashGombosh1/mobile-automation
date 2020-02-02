package com.mobile.automation.framework.tests;

import com.mobile.automation.framework.config.AppiumServer;
import com.mobile.automation.framework.config.drivers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.junit.Before;


/**
 * @author Tomash Gombosh
 */
public class BaseTest {
    public static AppiumDriver driver;

    @Before
    public void setUpDriver() {
        new AppiumServer().startServer();
        driver = new DriverFactory().getDriver();
    }

    @AfterClass
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
            new AppiumServer().stopServer();
        }
    }
}
