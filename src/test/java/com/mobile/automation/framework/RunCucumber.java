package com.mobile.automation.framework;

import com.google.inject.Guice;
import com.mobile.automation.framework.module.ServiceModules;
import com.mobile.automation.framework.service.AppiumServer;
import com.mobile.automation.framework.config.drivers.DriverFactory;
import com.mobile.automation.framework.module.ScreensModule;
import io.appium.java_client.AppiumDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        monochrome = true,
        glue = "src.test.java.com.mobile.automation.framework.stepDefinition",
        features = "src/test/resources/feature",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber-report/cucumber.xml"})
public class RunCucumber {
    public static AppiumDriver driver;

    @Before
    public void setUpDriver() {
        init();
        new AppiumServer().startServer();
        driver = new DriverFactory().getDriver();
    }

    @After
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
            new AppiumServer().stopServer();
        }
    }

    private void init() {
        Guice.createInjector(
                new ScreensModule(driver),
                new ServiceModules(driver)
        ).injectMembers(this);
    }
}
