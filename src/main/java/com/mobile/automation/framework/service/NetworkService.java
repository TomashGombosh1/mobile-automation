package com.mobile.automation.framework.service;

import com.mobile.automation.framework.config.ApplicationConfig;

/**
 * @author Tomash Gombosh
 */
public interface NetworkService {
    ApplicationConfig PROJECT_CONFIG = new ApplicationConfig();
    boolean ANDROID = false;

    void turnOffAllNetworkConnections();

    void turnOnAllNetworkConnections();

    void turnOnWifiOnly();

    void turnOnBluetoothOnly();

    void turnOffBluetooth();

    void turnOnCellularOnly();

    void turnOnAirplaneMode();
}
