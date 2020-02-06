package com.mobile.automation.framework.config.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import com.mobile.automation.framework.config.ProjectConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class DriverFactory {
    private final ProjectConfig projectConfig = new ProjectConfig();

    public AppiumDriver getDriver() {
        final AppiumDriver driver;
        final DesiredCapabilities capabilities;
        try {
            switch (projectConfig.getPlatformName()) {
                case ANDROID:
                    capabilities = getAndroidCapabilities();
                    driver = new AndroidDriver(new URL(projectConfig.getAppiumUrl()), capabilities);
                    return driver;
                case IOS:
                    capabilities = getIosCapabilities();
                    driver = new IOSDriver(new URL(projectConfig.getAppiumUrl()), capabilities);
                    return driver;
                default:
                    throw new EnumConstantNotPresentException(DeviceOs.class, "No such mobile OS");
            }
        } catch (MalformedURLException e) {
            log.info("Platform name in the config should be Android or iOS");
            return null;
        }
    }

    private DesiredCapabilities getIosCapabilities() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", projectConfig.getPlatformName());
        capabilities.setCapability("deviceName", projectConfig.getTestDeviceName());
        capabilities.setCapability("udid", projectConfig.getTestDeviceName());
        capabilities.setCapability("platformVersion", projectConfig.getPlatformVersion());
        capabilities.setCapability("privateDevicesOnly", "true");
        capabilities.setCapability("testobject_app_id", "1");
        capabilities.setCapability("appiumVersion", "1.6.4");
        capabilities.setCapability("newCommandTimeout", 5000);
        return capabilities;
    }

    private DesiredCapabilities getAndroidCapabilities() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", projectConfig.getPlatformName());
        capabilities.setCapability("deviceName", projectConfig.getTestDeviceName());
        capabilities.setCapability("udid", projectConfig.getTestDeviceName());
        capabilities.setCapability("platformVersion", projectConfig.getPlatformVersion());
        capabilities.setCapability("app", projectConfig.getAppPath());
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage", projectConfig.getPackageName());
        capabilities.setCapability("appActivity", projectConfig.getStartActivity());
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("newCommandTimeout", 5000);
        return capabilities;
    }
}
