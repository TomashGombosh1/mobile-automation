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
public class PreDriveChecklistScreen extends AbstractScreen {
    private static final AppElement SCREEN_TITLE = new AppElement(
            "Screen title",
            By.id(formatAndroidId("toolbar_title")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Log In'"),
            ScrollTo.NO,
            true);

    private static final AppElement HOS_BUTTON = new AppElement(
            "HOS button",
            By.id(formatAndroidId("hos_btn")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name == 'HOS'"),
            ScrollTo.DOWN,
            true);

    public PreDriveChecklistScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getScreenTitle() {
        waitToBeVisible(SCREEN_TITLE);
        return getText(SCREEN_TITLE);
    }

    public void tapHosButton() {
        waitToBeVisible(HOS_BUTTON);
        tap(HOS_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        return allRequiredElementDisplayed();
    }
}
