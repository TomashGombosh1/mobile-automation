package com.mobile.automation.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mobile.automation.framework.common.DeviceOs;
import com.mobile.automation.framework.common.DeviceType;
import com.mobile.automation.framework.exception.NoValueFromConfigException;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 * @author Tomash Gombosh
 */
@Getter
@Log4j
public class ApplicationConfig {
    private String baseUser;
    private String baseUserPassword;
    private String appiumIP;
    private String appiumPort;
    private String deviceName;
    private DeviceType deviceType;
    private String appPath;
    private String packageName;
    private DeviceOs platformName;
    private String platformVersion;
    private String startActivity;
    private int timeout;

    public ApplicationConfig() {
        initProperties();
    }

    public String getAppiumUrl() {
        return "http://" + getAppiumIP() + ":" + getAppiumPort() + "/wd/hub";
    }

    private void initProperties() {
        try {
            final InputStream fileInput = getClass().getClassLoader().getResourceAsStream("application.properties");
            final Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            this.baseUser = !properties.getProperty("base.user.username").equals("") ? properties.getProperty("base_user") : "No user in the project config";
            this.baseUserPassword = !properties.getProperty("base.user.password").equals("")
                    ? properties.getProperty("base_user_password") : "No user in the project config";
            if (!properties.getProperty("device.name").equals("")) {
                this.deviceName = properties.getProperty("device.name");
            } else {
                throw new NoValueFromConfigException("device.name is required value in the application.properties");
            }
            this.deviceType = !properties.getProperty("device.type").equals("")
                    ? DeviceType.valueOf(properties.getProperty("device.type").toUpperCase()) : DeviceType.SIMULATOR;
            this.appiumIP = !properties.getProperty("appium.ip").equals("") ? properties.getProperty("appium.ip") : "0.0.0.0";
            this.appiumPort = !properties.getProperty("appium.port").equals("") ? properties.getProperty("appium.port") : "4723";
            if (!properties.getProperty("app.path").equals("")) {
                this.appPath = properties.getProperty("app.path");
            } else {
                throw new NoValueFromConfigException("app.path is required value in the application.properties");
            }
            if (!properties.getProperty("app.package").equals("")) {
                this.packageName = properties.getProperty("app.package");
            } else {
                throw new NoValueFromConfigException("app.package is required value in the application.properties");
            }
            if (!properties.getProperty("platform.name").equals("")) {
                this.platformName = DeviceOs.valueOf(properties.getProperty("platform.name").toUpperCase());
            } else {
                throw new NoValueFromConfigException("platform.name is required value in the application.properties");
            }
            if (!properties.getProperty("platform.version").equals("")) {
                this.platformVersion = properties.getProperty("platform.version");
            } else {
                throw new NoValueFromConfigException("platform.version is required value in the application.properties");
            }
            this.startActivity = !properties.getProperty("start.activity").equals("") ? properties.getProperty("start.activity") : "";
            this.timeout = !properties.getProperty("timeout").equals("") ? Integer.parseInt(properties.getProperty("timeout")) : 30;
        } catch (IOException e) {
            log.info(String.format("Exception %s", e.getMessage()));
        }
    }

}
