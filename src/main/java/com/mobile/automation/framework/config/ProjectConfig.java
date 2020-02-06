package com.mobile.automation.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
public class ProjectConfig {
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

    public ProjectConfig() {
        initProperties();
    }

    public String getAppiumUrl() {
        return "http://" + getAppiumIP() + ":" + getAppiumPort() + "/wd/hub";
    }

    private void initProperties() {
        try {
            final FileInputStream fileInput = (FileInputStream) Files.newInputStream(Paths.get("ConfigProject.properties"));
            final Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            baseUser = properties.getProperty("base.user.username") != null ? properties.getProperty("base_user") : "No user in the project config";
            baseUserPassword = properties.getProperty("base.user.password") != null
                    ? properties.getProperty("base_user_password") : "No user in the project config";
            if (properties.getProperty("device.name") != null) {
                deviceName = properties.getProperty("device.name");
            } else {
                throw new NoValueFromConfigException("device.name is required value in the ConfigProject.properties");
            }
            deviceType = properties.getProperty("device.type") != null
                    ? DeviceType.valueOf(properties.getProperty("device.type")) : DeviceType.SIMULATOR;
            appiumIP = properties.getProperty("appium.ip") != null ? properties.getProperty("appium.ip") : "0.0.0.0";
            appiumPort = properties.getProperty("appium.port") != null ? properties.getProperty("appium.port") : "4723";
            if (properties.getProperty("app.path") != null) {
                appPath = properties.getProperty("app.path");
            } else {
                throw new NoValueFromConfigException("app.path is required value in the ConfigProject.properties");
            }
            if (properties.getProperty("package.name") != null) {
                packageName = properties.getProperty("package.name");
            } else {
                throw new NoValueFromConfigException("package.name is required value in the ConfigProject.properties");
            }
            if (properties.getProperty("platform.name") != null) {
                platformName = DeviceOs.valueOf(properties.getProperty("platform.name"));
            } else {
                throw new NoValueFromConfigException("platform.name is required value in the ConfigProject.properties");
            }
            if (properties.getProperty("platform.version") != null) {
                platformVersion = properties.getProperty("platform.version");
            } else {
                throw new NoValueFromConfigException("platform.version is required value in the ConfigProject.properties");
            }
            startActivity = properties.getProperty("startActivity") != null ? properties.getProperty("startActivity") : "";
            timeout = properties.getProperty("timeout") != null ? Integer.parseInt(properties.getProperty("timeout")) : 30;
        } catch (IOException e) {
            log.info(String.format("Exception %s", e.getMessage()));
        }
    }

}
