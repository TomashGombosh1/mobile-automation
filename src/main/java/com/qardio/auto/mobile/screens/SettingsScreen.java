package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import com.qardio.auto.mobile.config.ApplicationProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.qardio.auto.mobile.common.utils.Utils.formatAndroidId;

/**
 * @author Oleksii Borzykin
 */
public class SettingsScreen extends AbstractScreen {
    private static final AppElement SCREEN_TITLE = new AppElement(
            "Screen title",
            By.id(formatAndroidId("toolbar_title")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Settings'"),
            ScrollTo.DOWN,
            true);

    private static final AppElement CONTACT_PHONE_FIELD = new AppElement(
            "Contact phone input",
            By.id(formatAndroidId("driver_number")),
            MobileBy.iOSClassChain("**/XCUIElementTypeOther/XCUIElementTypeTextField[5]"),
            ScrollTo.NO,
            true
    );

    private static final AppElement CONTACT_EMAIL_FIELD = new AppElement(
            "Email input",
            By.id(formatAndroidId("driver_email")),
            MobileBy.iOSClassChain("**/XCUIElementTypeOther/XCUIElementTypeTextField[6]"),
            ScrollTo.NO,
            true
    );

    private static final AppElement SAVE_BUTTON = new AppElement(
            "Save button",
            By.id(formatAndroidId("btn_right")),
            MobileBy.AccessibilityId("SAVE"),
            ScrollTo.NO,
            true);

    private static final AppElement ALERT_OK = new AppElement(
            "confirmation Alert Ok button",
            By.id(formatAndroidId("btn1")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name == 'OK'"),
            ScrollTo.NO,
            false);

    public SettingsScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getScreenTitle() {
        waitToBeVisible(SCREEN_TITLE);
        return getText(SCREEN_TITLE);
    }

    public void fillContactPhone(final String input) {
        waitToBeVisible(CONTACT_PHONE_FIELD);
        enterText(CONTACT_PHONE_FIELD, input, true);
    }

    public void fillContactEmail(final String input) {
        waitToBeVisible(CONTACT_EMAIL_FIELD);
        enterText(CONTACT_EMAIL_FIELD, input, true);
    }

    public void tapSaveButton() {
        waitToBeClickable(SAVE_BUTTON);
        tap(SAVE_BUTTON);
        confirmChanges();
    }

    public void confirmChanges() {
        if ("IOS".equals(ApplicationProperties.CURRENT_OS)) {
            waitToBeClickable(ALERT_OK);
            tap(ALERT_OK);
        }
    }

    public String getSavedPhoneNumber() {
        waitToBeVisible(CONTACT_PHONE_FIELD);
        return getInputValue(CONTACT_PHONE_FIELD);
    }

    public String getSavedEmailAddress() {
        waitToBeVisible(CONTACT_EMAIL_FIELD);
        return getInputValue(CONTACT_EMAIL_FIELD);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(SCREEN_TITLE);
        return allRequiredElementDisplayed();
    }
}
