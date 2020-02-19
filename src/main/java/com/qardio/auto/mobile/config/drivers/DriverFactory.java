package com.qardio.auto.mobile.config.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import com.qardio.auto.mobile.common.DeviceOs;
import com.qardio.auto.mobile.config.ApplicationConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class DriverFactory {
    private final ApplicationConfig applicationConfig = new ApplicationConfig();


    public AppiumDriver<MobileElement> getDriver() {
        final DesiredCapabilities capabilities;
        final AppiumDriver<MobileElement> driver;
        try {
            switch (applicationConfig.getPlatformName()) {
                case ANDROID:
                    capabilities = getAndroidCapabilities();
                    driver = new AndroidDriver<>(new URL(applicationConfig.getAppiumUrl()), capabilities);
                    return driver;
                case IOS:
                    capabilities = getIosCapabilities();
                    driver = new IOSDriver<>(new URL(applicationConfig.getAppiumUrl()), capabilities);
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
        capabilities.setCapability("platformName", applicationConfig.getPlatformName().getDeviceOs());
        capabilities.setCapability("deviceName", applicationConfig.getDeviceName());
        capabilities.setCapability("udid", applicationConfig.getDeviceName());
        capabilities.setCapability("platformVersion", applicationConfig.getPlatformVersion());
        capabilities.setCapability("privateDevicesOnly", "true");
        capabilities.setCapability("testobject_app_id", "1");
        capabilities.setCapability("appiumVersion", "1.6.4");
        capabilities.setCapability("newCommandTimeout", 5000);
        log.info(String.format("Desired Capabilities for device %s", capabilities.toString()));
        return capabilities;
    }

    private DesiredCapabilities getAndroidCapabilities() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", applicationConfig.getPlatformName());
        capabilities.setCapability("deviceName", applicationConfig.getDeviceName());
        capabilities.setCapability("platformVersion", applicationConfig.getPlatformVersion());
        capabilities.setCapability("app", applicationConfig.getAppPath());
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage", applicationConfig.getPackageName());
        capabilities.setCapability("appActivity", applicationConfig.getStartActivity());
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("newCommandTimeout", 5000);
        log.info(String.format("Desired Capabilities for device %s", capabilities.toString()));
        return capabilities;
    }
}
