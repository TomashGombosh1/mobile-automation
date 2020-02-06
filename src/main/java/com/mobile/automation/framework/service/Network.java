package com.mobile.automation.framework.service;

import com.mobile.automation.framework.common.DeviceOs;
import com.mobile.automation.framework.common.DeviceType;
import com.mobile.automation.framework.common.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.ios.IOSDriver;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Network implements NetworkService {
    private AndroidDriver<MobileElement> driverAndroid;
    private IOSDriver<MobileElement> driverIos;
    private boolean android = false;

    public Network(AppiumDriver<MobileElement> driver) {
        if (driver.getPlatformName().equals(DeviceOs.IOS.getDeviceOs())) {
            this.driverIos = (IOSDriver<MobileElement>) driver;
        } else {
            this.driverAndroid = (AndroidDriver<MobileElement>) driver;
            android = true;
        }
    }

    @Override
    public void turnOffAllNetworkConnections() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        ConnectionState none = new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK);
        if (android) {
            driverAndroid.setConnection(none);
        } else if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(true, false, false);
        }
    }

    @Override
    public void turnOnAllNetworkConnections() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        ConnectionState wifi = new ConnectionState(ConnectionState.WIFI_MASK);
        ConnectionState data = new ConnectionState(ConnectionState.DATA_MASK);
        if (android) {
            turnOffAllNetworkConnections();
            driverAndroid.setConnection(wifi);
            driverAndroid.setConnection(data);
        } else if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(false, true, true);

        }
    }

    @Override
    public void turnOnWifiOnly() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        ConnectionState wifi = new ConnectionState(ConnectionState.WIFI_MASK);
        if (android) {
            turnOffAllNetworkConnections();
            driverAndroid.setConnection(wifi);
        } else if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(true, true, false);
        }
    }

    @Override
    public void turnOnBluetoothOnly() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(true, false, true);
        }
    }

    @Override
    public void turnOffBluetooth() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(false, true, false);
        }
    }

    @Override
    public void turnOnCellularOnly() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        ConnectionState data = new ConnectionState(ConnectionState.DATA_MASK);
        if (android) {
            turnOffAllNetworkConnections();
            driverAndroid.setConnection(data);
        } else if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(false, false, false);
        }
    }

    @Override
    public void turnOnAirplaneMode() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        ConnectionState airPlane = new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK);
        if (android) {
            driverAndroid.setConnection(airPlane);
        } else if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(true, false, false);
        }
    }

    private void iosConnection(Boolean airplane, boolean wifi, boolean bluetooth) {
        log.info("airplane: " + airplane + " wifi: " + wifi + " bluetooth: " + bluetooth);
        final TouchAction touchAction = new TouchAction(driverIos);
        final Swipe swipe = new Swipe(driverIos, driverIos.manage().window().getSize(), touchAction);
        final int width = driverIos.manage().window().getSize().width;
        final int height = driverIos.manage().window().getSize().height;
        final int step = (int) (height * 0.6);

        final String airplaneButtonName;
        final String wifiButtonName;
        final String bluetoothButtonName;

        if (PROJECT_CONFIG.getPlatformVersion().contains("11")) {
            airplaneButtonName = "airplane-mode-button";
            wifiButtonName = "wifi-button";
            bluetoothButtonName = "bluetooth-button";
        } else {
            airplaneButtonName = "Airplane Mode";
            wifiButtonName = "Wi-Fi";
            bluetoothButtonName = "bluetooth-button";
        }

        for (int i = 0; i < 5; i++) {
            try {
                driverIos.findElement(By.xpath("(//XCUIElementTypeAlert//XCUIElementTypeButton)[last()]")).click();
                log.info("Clicked on alert button");
            } catch (Exception e) {
                log.info("Alert not found");
            }
            int n = i + 1;
            log.info("Trying to open control center: " + n + " try.");
            swipe.swipeByInt(20, height - 5, width / 2, -step);
            try {
                driverIos.findElement(By.name(airplaneButtonName));
                break;
            } catch (Exception e) {
                log.info("Airplane button not found");
            }
        }

        try {
            MobileElement continueButton = driverIos.findElement(By.name("Continue"));
            new WebDriverWait(driverIos, 5).until(ExpectedConditions.elementToBeClickable(continueButton));
            continueButton.click();
        } catch (Exception e) {
            log.info("Continue button not found");
        }

        try {
            MobileElement airplaneIcon = driverIos.findElement(By.name(airplaneButtonName));

            String value = airplaneIcon.getAttribute("value");
            log.info("Airplane icon state value " + value);

            boolean airplaneIconState = parseBooleanValue(value);
            log.info("Airplane icon state " + airplaneIconState);

            if (airplaneIconState != airplane) {
                airplaneIcon.click();
                log.info("Clicked on Airplane icon");
            }

        } catch (Exception e) {
            log.info("Can't switch network state: " + e.getMessage());
        }

        try {
            Utils.sleep(2000);
            MobileElement wifiIcon = driverIos.findElement(By.name(wifiButtonName));

            String value = wifiIcon.getAttribute("value");
            log.info("Wifi icon state value " + value);

            boolean wifiIconState = parseBooleanValue(value);
            log.info("Wifi icon state " + wifiIconState);

            if (wifiIconState != wifi) {
                wifiIcon.click();
                log.info("Clicked on WiFi icon");
            }

        } catch (Exception e) {
            log.info("Can't switch network state: " + e.getMessage());
        }
        try {
            Utils.sleep(2000);
            MobileElement bluetoothIcon = driverIos.findElement(By.name(bluetoothButtonName));

            String value = bluetoothIcon.getAttribute("value");
            log.info("Bluetooth icon state value " + value);

            boolean bluetoothIconState = parseBooleanValue(value);
            log.info("Bluetooth icon state" + bluetoothIconState);

            if (bluetoothIconState != bluetooth) {
                bluetoothIcon.click();
                log.info("Clicked on Bluetooth icon");
            }
        } catch (Exception e) {
            log.info("Can't switch network state: " + e.getMessage());
        }

        swipe.swipeVerticallyByInt(width / 2, 0);
        Utils.sleep(2000);
    }

    private boolean parseBooleanValue(String value) {
        return value.equals("1");
    }

}
