package com.mobile.automation.framework.screens;

import com.mobile.automation.framework.common.AppElement;
import com.mobile.automation.framework.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class LoginScreen extends AbstractScreen {
    private static final AppElement LOGIN_BUTTON = new AppElement(
            "Login button ",
            By.id("login_button"),
            By.id("login_button"),
            ScrollTo.DOWN,
            true);

    public LoginScreen(final AppiumDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void tapLogin() {
        waitToBeVisible(LOGIN_BUTTON);
        tap(LOGIN_BUTTON);
    }
}
