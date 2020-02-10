package com.qardio.auto.mobile.service;

import com.qardio.auto.mobile.config.ApplicationConfig;

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
