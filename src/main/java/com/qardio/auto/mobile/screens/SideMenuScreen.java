package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.qardio.auto.mobile.common.utils.Utils.formatAndroidId;

/**
 * @author Oleksii Borzykin
 */
public class SideMenuScreen extends AbstractScreen {
    private static final AppElement DRIVER_NAME = new AppElement(
            "Driver name",
            By.id(formatAndroidId("user_name")),
            By.id(""),
            ScrollTo.NO,
            true);

    private static final AppElement LOG_OUT_BUTTON = new AppElement(
            "Log out button",
            By.xpath("//android.widget.TextView[contains(@text,'Log Out')]"),
            By.id(""),
            ScrollTo.DOWN,
            true);

    public SideMenuScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getDriverName() {
        waitToBeVisible(DRIVER_NAME);
        return getText(DRIVER_NAME);
    }

    public void tapLogOutButton() {
        // todo in progress
        waitToBeVisible(DRIVER_NAME);
        scrollService.scrollDown();
        tap(LOG_OUT_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(DRIVER_NAME);
        return allRequiredElementDisplayed();
    }
}
