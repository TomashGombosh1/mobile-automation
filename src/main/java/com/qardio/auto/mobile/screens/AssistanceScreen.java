package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class AssistanceScreen extends AbstractScreen {
    private static final AppElement FAQ_BUTTON = new AppElement(
            "FAQ/AIDE button",
            By.id("button_faq"),
            By.id(""),
            ScrollTo.NO,
            true);

    public AssistanceScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getFaqButtonAttribute(final String attribute) {
        waitToBeVisible(FAQ_BUTTON);
        return getAttribute(FAQ_BUTTON, attribute);
    }

    public void tapFaqButton() {
        waitToBeVisible(FAQ_BUTTON);
        tap(FAQ_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(FAQ_BUTTON);
        return allRequiredElementDisplayed();
    }
}
