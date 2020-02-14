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
public class WorkforceScreen extends AbstractScreen {
    private static final AppElement SCREEN_TITLE = new AppElement(
            "Screen title",
            By.id(formatAndroidId("toolbar_title")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Jobs'"),
            ScrollTo.NO,
            true);

    public WorkforceScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getScreenTitle() {
        waitToBeVisible(SCREEN_TITLE);
        return getText(SCREEN_TITLE);
    }

    @Override
    public boolean isDisplayed() {
        return allRequiredElementDisplayed();
    }
}
