package com.qardio.auto.mobile.service;

import com.qardio.auto.mobile.config.ApplicationConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.log4j.Log4j;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class DeviceServiceImpl implements DeviceService {
    private final AppiumDriver<MobileElement> driver;

    public DeviceServiceImpl(final AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    /**
     * Closes and re-opens the app.
     */
    @Override
    public void closeAndLaunchApp() {
        log.info("Closing application...");
        this.driver.closeApp();
        log.info("Re-opening application...");
        this.driver.launchApp();
    }

    /**
     * reset app the app.
     */
    @Override
    public void resetApp() {
        log.info("Reset  application...");
        this.driver.resetApp();
    }

    /**
     * Uninstalls and reinstalls the app.
     */
    @Override
    public void uninstallAndReinstallApp() {
        log.info("Uninstalling application...");
        if (driver.isAppInstalled(new ApplicationConfig().getPackageName())) {
            driver.removeApp(new ApplicationConfig().getPackageName());
        }
        log.info("Re-installing application...");
        this.driver.installApp(new ApplicationConfig().getAppPath());
        this.driver.launchApp();
    }

}
