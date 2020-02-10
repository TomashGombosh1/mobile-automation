package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import com.qardio.auto.mobile.config.ApplicationProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class DashboardScreen extends AbstractScreen {
    private static final AppElement SIGN_IN_BUTTON = new AppElement(
            "Sign in button",
            By.id(String.format("%s:%s", ApplicationProperties.ANDROID_APP_PACKAGE, "id/right_link")),
            ScrollTo.NO,
            true);
    private static final AppElement SIGN_UP_BUTTON = new AppElement(
            "Sign Up Button",
            By.id(String.format("%s:%s", ApplicationProperties.ANDROID_APP_PACKAGE, "id/sign_button")),
            ScrollTo.NO,
            true);

    public DashboardScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(SIGN_IN_BUTTON);
        return allRequiredElementDisplayed();
    }

    public void tapLogin() {
        tap(SIGN_IN_BUTTON);
    }

    public void tapSignUp() {
        tap(SIGN_UP_BUTTON);
    }
}
