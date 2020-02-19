package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class LoginScreen extends AbstractScreen {
    private static final AppElement EMAIL_FIELD = new AppElement(
            "Email field",
            MobileBy.AccessibilityId("input_email"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement PASSWORD_FIELD = new AppElement(
            "Password field",
            MobileBy.AccessibilityId("input_password"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement FORGOT_PASSWORD_LINK = new AppElement(
            "Forgot password link",
            By.id("button_forgot_password"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement SHOW_PASSWORD_BUTTON = new AppElement(
            "Show password button",
            By.id("text_input_end_icon"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement CLOSE_BUTTON = new AppElement(
            "Close button",
            By.id("button_close"),
            By.id(""),
            ScrollTo.NO,
            true);

    public LoginScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getElementAttribute(final String element, final String attribute) {
        switch (element) {
            case "email":
                return getAttribute(EMAIL_FIELD, attribute);
            case "password":
                return getAttribute(PASSWORD_FIELD, attribute);
            case "forgotten password":
                return getAttribute(FORGOT_PASSWORD_LINK, attribute);
           case "Show password":
                return getAttribute(SHOW_PASSWORD_BUTTON, attribute);
            default:
                throw new AssertionError("Element: " + element + " is not handled in switch");
        }
    }

    public void tapCloseButton() {
        waitToBeVisible(CLOSE_BUTTON);
        tap(CLOSE_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(EMAIL_FIELD);
        waitToBeVisible(PASSWORD_FIELD);
        return allRequiredElementDisplayed();
    }
}
