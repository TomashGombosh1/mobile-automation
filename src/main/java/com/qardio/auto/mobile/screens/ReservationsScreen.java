package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class ReservationsScreen extends AbstractScreen {
    private static final AppElement SIGN_IN_BUTTON = new AppElement(
            "Sign in button",
            By.id("button_signin"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement QRCODE_BUTTON = new AppElement(
            "QR code button",
            By.id("button_signin"),
            By.id(""),
            ScrollTo.NO,
            true);

    public ReservationsScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getButtonAttribute(final String button, final String attribute) {
        if ("sign-in".equals(button)) {
            return getAttribute(SIGN_IN_BUTTON, attribute);
        } else if ("qrcode".equals(button)) {
            return getAttribute(QRCODE_BUTTON, attribute);
        } else {
            throw new IllegalArgumentException("Element: " + button + " is not handled in switch");
        }
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(QRCODE_BUTTON);
        return allRequiredElementDisplayed();
    }
}
