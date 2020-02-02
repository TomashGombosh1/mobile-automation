package com.mobile.automation.framework.config;

import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class DeviceHelper {

    private final AppiumDriver driver;

    public DeviceHelper(final AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Closes and re-opens the app.
     */
    public void closeAndLaunchApp() {
        log.info("Closing application...");
        this.driver.closeApp();
        log.info("Re-opening application...");
        this.driver.launchApp();
    }

    /**
     * reset app the app.
     */
    public void resetApp() {
        log.info("Reset  application...");
        this.driver.resetApp();
    }

    /**
     * Uninstalls and reinstalls the app.
     */
    public void uninstallAndReinstallApp() {
        log.info("Uninstalling application...");
        if (driver.isAppInstalled(new ProjectConfig().getPackageName())) {
            driver.removeApp(new ProjectConfig().getPackageName());
        }
        log.info("Re-installing application...");
        this.driver.installApp(new ProjectConfig().getAppPath());
        this.driver.launchApp();
    }

}
