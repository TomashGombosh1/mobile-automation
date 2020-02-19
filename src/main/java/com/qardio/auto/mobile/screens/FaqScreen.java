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
public class FaqScreen extends AbstractScreen {
    private static final AppElement BACK_BUTTON = new AppElement(
            "Back button",
            MobileBy.AccessibilityId("back_button"),
            By.id(""),
            ScrollTo.NO,
            true);

    public FaqScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getBackButtonAttribute(final String attribute) {
        waitToBeVisible(BACK_BUTTON);
        return getAttribute(BACK_BUTTON, attribute);
    }

    public void tapBackButton() {
        tap(BACK_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBePresent(BACK_BUTTON);
        return allRequiredElementDisplayed();
    }
}
