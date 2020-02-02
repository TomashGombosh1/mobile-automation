package com.mobile.automation.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import com.mobile.automation.framework.config.drivers.DeviceOs;
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
    private String testDeviceName;
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

            baseUser = properties.getProperty("base_user");
            baseUserPassword = properties.getProperty("base_user_password");
            testDeviceName = properties.getProperty("device_name");
            appiumIP = properties.getProperty("appium_IP");
            appiumPort = properties.getProperty("appium_port");
            appPath = properties.getProperty("app_path");
            packageName = properties.getProperty("appPackage");
            platformName = DeviceOs.valueOf(properties.getProperty("platform_name"));
            platformVersion = properties.getProperty("platform_version");
            testDeviceName = properties.getProperty("device_name");
            startActivity = properties.getProperty("startActivity");
            timeout = Integer.parseInt(properties.getProperty("timeout"));
        } catch (IOException e) {
            log.info(String.format("Exception %s", e.getMessage()));
        }
    }


}
