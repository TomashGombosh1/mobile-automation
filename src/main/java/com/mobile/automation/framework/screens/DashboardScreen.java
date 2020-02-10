package com.mobile.automation.framework.screens;

import com.mobile.automation.framework.common.AppElement;
import com.mobile.automation.framework.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.mobile.automation.framework.config.ApplicationProperties.ANDROID_APP_PACKAGE;

/**
 * @author Tomash Gombosh
 */
public class DashboardScreen extends AbstractScreen {
    private static final AppElement SIGN_IN_BUTTON = new AppElement(
            "Sign in button",
            By.id(String.format("%s:%s", ANDROID_APP_PACKAGE, "id/right_link")),
            ScrollTo.NO,
            true);
    private static final AppElement SIGN_UP_BUTTON = new AppElement(
            "Sign Up Button",
            By.id(String.format("%s:%s", ANDROID_APP_PACKAGE, "id/sign_button")),
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

    public void tapSignIn() {
        tap(SIGN_UP_BUTTON);
    }
}
