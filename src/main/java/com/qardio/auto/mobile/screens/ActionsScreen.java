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
public class ActionsScreen extends AbstractScreen {
    private static final AppElement SCREEN_TITLE = new AppElement(
            "Screen title",
            By.id(formatAndroidId("toolbar_title")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Actions'"),
            ScrollTo.NO,
            true);
    private static final AppElement EDIT_SUGGESTIONS_BUTTON = new AppElement(
            "Edit suggestions button",
            By.id(formatAndroidId("llES")),
            MobileBy.iOSNsPredicateString("type = 'XCUIElementTypeButton' AND label CONTAINS 'Edit Suggestions'"),
            ScrollTo.NO,
            true);
    private static final AppElement DMALFUNCTION_BUTTON = new AppElement(
            "D/Malfunction button",
            By.id(formatAndroidId("llDiag")),
            MobileBy.iOSNsPredicateString("type = 'XCUIElementTypeButton' AND label CONTAINS 'D/Malfunction'"),
            ScrollTo.NO,
            true);
    private static final AppElement NO_RECORD_ALERT = new AppElement(
            "No records alert",
            By.id("android:id/message"),
            ScrollTo.NO,
            false);
    private static final AppElement NO_RECORD_ALERT_BUTTON = new AppElement(
            "No records alert dismiss button",
            By.id("android:id/button1"),
            ScrollTo.NO,
            false);

    public ActionsScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getScreenTitle() {
        waitToBeVisible(SCREEN_TITLE);
        return getText(SCREEN_TITLE);
    }

    public boolean isAlertPresent() {
        return isElementVisible(NO_RECORD_ALERT);
    }

    public void dismissNoRecordsAlert() {
        if (isAlertPresent()) {
            tap(NO_RECORD_ALERT_BUTTON);
        }
    }

    public void tapEditSuggestionsButton() {
        waitToBeVisible(EDIT_SUGGESTIONS_BUTTON);
        tap(EDIT_SUGGESTIONS_BUTTON);
    }

    public void tapDmalfunctionButton() {
        waitToBeVisible(DMALFUNCTION_BUTTON);
        tap(DMALFUNCTION_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        return allRequiredElementDisplayed();
    }
}
