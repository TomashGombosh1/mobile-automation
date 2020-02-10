package com.mobile.automation.framework.service;

/**
 * @author Tomash Gombosh
 */
public interface DeviceService {
    void closeAndLaunchApp();

    void resetApp();

    void uninstallAndReinstallApp();
}
