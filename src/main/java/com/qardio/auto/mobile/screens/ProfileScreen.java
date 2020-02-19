package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class ProfileScreen extends AbstractScreen {
    private static final AppElement SIGN_IN_BUTTON = new AppElement(
            "Sign in button",
            By.id("button_signin"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement SIGN_UP_BUTTON = new AppElement(
            "Sign up button",
            By.id("button_signup"),
            By.id(""),
            ScrollTo.NO,
            true);

    public ProfileScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getButtonAttribute(final String name, final String attribute) {
        if ("login".equals(name)) {
            return getAttribute(SIGN_IN_BUTTON, attribute);
        } else if ("sign-up".equals(name)) {
            return getAttribute(SIGN_UP_BUTTON, attribute);
        }
        return false;
    }

    public void tapSignInButton() {
        waitToBeVisible(SIGN_IN_BUTTON);
        tap(SIGN_IN_BUTTON);
    }

    public void tapSignUpButton() {
        waitToBeVisible(SIGN_UP_BUTTON);
        tap(SIGN_UP_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(SIGN_IN_BUTTON);
        waitToBeVisible(SIGN_UP_BUTTON);
        return allRequiredElementDisplayed();
    }
}
