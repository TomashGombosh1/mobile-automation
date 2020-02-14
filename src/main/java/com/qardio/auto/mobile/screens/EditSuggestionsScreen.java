package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.qardio.auto.mobile.common.utils.Utils.formatAndroidId;

/**
 * @author Oleksii Borzykin
 */
public class EditSuggestionsScreen extends AbstractScreen {
    private static final AppElement SCREEN_TITLE = new AppElement(
            "Screen title",
            By.id(formatAndroidId("toolbar_title")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Edit Suggestions'"),
            ScrollTo.NO,
            true);

    private static final AppElement NO_SUGGESTIONS_ALERT_TITLE = new AppElement(
            "No Suggestions Alert title",
            By.id(formatAndroidId("alertTitle")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value CONTAINS 'There are no Edit'"),
            ScrollTo.NO,
            false);

    private static final AppElement NO_SUGGESTIONS_ALERT_OK_BUTTON = new AppElement(
            "No Suggestions Alert OK button",
            By.id(formatAndroidId("btn1")),
            MobileBy.AccessibilityId("OK"),
            ScrollTo.NO,
            false);

    public EditSuggestionsScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getScreenTitle() {
        waitToBeVisible(SCREEN_TITLE);
        return getText(SCREEN_TITLE);
    }

    public String getAlertTitle() {
        waitToBeVisible(NO_SUGGESTIONS_ALERT_TITLE);
        return getText(NO_SUGGESTIONS_ALERT_TITLE);
    }

    public void dismissAlert() {
        if (isElementPresent(NO_SUGGESTIONS_ALERT_TITLE)) {
            tap(NO_SUGGESTIONS_ALERT_OK_BUTTON);
        }
    }

    @Override
    public boolean isDisplayed() {
        return allRequiredElementDisplayed();
    }
}
