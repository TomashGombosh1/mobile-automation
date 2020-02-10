package com.mobile.automation.framework.common;

/**
 * @author Tomash Gombosh
 */
public enum DeviceType {
    SIMULATOR("Simulator"), NOT("not");

    private final String deviceType;

    DeviceType(final String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }
}
