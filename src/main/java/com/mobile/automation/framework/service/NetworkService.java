package com.mobile.automation.framework.service;

import com.mobile.automation.framework.config.ProjectConfig;

/**
 * @author Tomash Gombosh
 */
public interface NetworkService {
    ProjectConfig PROJECT_CONFIG = new ProjectConfig();
    boolean ANDROID = false;

    void turnOffAllNetworkConnections();

    void turnOnAllNetworkConnections();

    void turnOnWifiOnly();

    void turnOnBluetoothOnly();

    void turnOffBluetooth();

    void turnOnCellularOnly();

    void turnOnAirplaneMode();
}
