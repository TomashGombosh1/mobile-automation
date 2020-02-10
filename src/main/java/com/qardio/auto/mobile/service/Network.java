package com.qardio.auto.mobile.service;

import com.qardio.auto.mobile.common.DeviceOs;
import com.qardio.auto.mobile.common.DeviceType;
import com.qardio.auto.mobile.common.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.ios.IOSDriver;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.Objects.requireNonNull;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Network implements NetworkService {
    private AndroidDriver<MobileElement> driverAndroid;
    private IOSDriver<MobileElement> driverIos;
    private boolean android;

    public Network(final AppiumDriver<MobileElement> driver) {
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
        final ConnectionState none = new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK);
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
        final ConnectionState wifi = new ConnectionState(ConnectionState.WIFI_MASK);
        final ConnectionState data = new ConnectionState(ConnectionState.DATA_MASK);
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
        final ConnectionState wifi = new ConnectionState(ConnectionState.WIFI_MASK);
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
        final ConnectionState data = new ConnectionState(ConnectionState.DATA_MASK);
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
        final ConnectionState airPlane = new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK);
        if (android) {
            driverAndroid.setConnection(airPlane);
        } else if (PROJECT_CONFIG.getDeviceType().equals(DeviceType.SIMULATOR)
                && PROJECT_CONFIG.getPlatformName().equals(DeviceOs.IOS)) {
            log.info("Tests are running on iOS simulator, network not available");
        } else {
            this.iosConnection(true, false, false);
        }
    }

    private void iosConnection(final boolean airplane, final boolean wifi, final boolean bluetooth) {
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
            } catch (NoSuchElementException e) {
                log.info(String.format("Alert not found %s", e.getMessage()));
            }
            final int counter = i + 1;
            log.info("Trying to open control center: " + counter + " try.");
            swipe.swipeByInt(20, height - 5, width / 2, -step);
            try {
                driverIos.findElement(By.name(airplaneButtonName));
                break;
            } catch (NoSuchElementException e) {
                log.info(String.format("Alert not found %s", e.getMessage()));
            }
        }

        try {
            final MobileElement continueButton = driverIos.findElement(By.name("Continue"));
            new WebDriverWait(driverIos, 5).until(ExpectedConditions.elementToBeClickable(continueButton));
            continueButton.click();
        } catch (NoSuchElementException e) {
            log.info(String.format("Alert not found %s", e.getMessage()));
        }

        try {
            final MobileElement airplaneIcon = driverIos.findElement(By.name(airplaneButtonName));

            final String value = airplaneIcon.getAttribute("value");
            log.info("Airplane icon state value " + value);

            final boolean airplaneIconState = parseBooleanValue(value);
            log.info("Airplane icon state " + airplaneIconState);

            if (airplaneIconState != airplane) {
                airplaneIcon.click();
                log.info("Clicked on Airplane icon");
            }
        } catch (NoSuchElementException e) {
            log.info(String.format("Alert not found %s", e.getMessage()));
        }

        try {
            Utils.sleep(2000);
            final MobileElement wifiIcon = driverIos.findElement(By.name(wifiButtonName));

            final String value = wifiIcon.getAttribute("value");
            log.info("Wifi icon state value " + value);

            final boolean wifiIconState = parseBooleanValue(value);
            log.info("Wifi icon state " + wifiIconState);

            if (wifiIconState != wifi) {
                wifiIcon.click();
                log.info("Clicked on WiFi icon");
            }

        } catch (NoSuchElementException e) {
            log.info(String.format("Alert not found %s", e.getMessage()));
        }
        try {
            Utils.sleep(2000);
            final MobileElement bluetoothIcon = driverIos.findElement(By.name(bluetoothButtonName));

            final String value = bluetoothIcon.getAttribute("value");
            log.info("Bluetooth icon state value " + value);

            final boolean bluetoothIconState = parseBooleanValue(value);
            log.info("Bluetooth icon state" + bluetoothIconState);

            if (bluetoothIconState != bluetooth) {
                bluetoothIcon.click();
                log.info("Clicked on Bluetooth icon");
            }
        } catch (NoSuchElementException e) {
            log.info(String.format("Alert not found %s", e.getMessage()));
        }

        swipe.swipeVerticallyByInt(width / 2, 0);
        Utils.sleep(2000);
    }

    private boolean parseBooleanValue(final String value) {
        requireNonNull(value, "Value can not be null");
        return "1".equals(value);
    }

}
