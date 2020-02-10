package com.qardio.auto.mobile.common;

/**
 * @author Tomash Gombosh
 */
public enum DeviceOs {
    ANDROID("Android"), IOS("iOS");

    private final String deviceOs;

    DeviceOs(final String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getDeviceOs() {
        return deviceOs;
    }
}
