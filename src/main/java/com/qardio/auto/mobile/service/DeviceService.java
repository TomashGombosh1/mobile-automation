package com.qardio.auto.mobile.service;

/**
 * @author Tomash Gombosh
 */
public interface DeviceService {
    void closeAndLaunchApp();

    void resetApp();

    void uninstallAndReinstallApp();
}
