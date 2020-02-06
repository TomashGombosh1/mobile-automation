package com.mobile.automation.framework.service;

import com.mobile.automation.framework.config.ProjectConfig;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Tomash Gombosh
 */
public interface AppiumService {
    AppiumDriverLocalService SERVICE = buildService();

    private static AppiumDriverLocalService buildService() {
        final AppiumServiceBuilder builder = new AppiumServiceBuilder();
        final DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");
        builder.withIPAddress(new ProjectConfig().getAppiumIP());
        builder.usingPort(Integer.parseInt(new ProjectConfig().getAppiumPort()));
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        return AppiumDriverLocalService.buildService(builder);
    }

    void startServer();

    void stopServer();

    boolean checkIfServerIsRunning(int port);
}
