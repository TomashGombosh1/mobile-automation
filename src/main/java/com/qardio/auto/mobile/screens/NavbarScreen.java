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
public class NavbarScreen extends AbstractScreen {
    private static final AppElement SEARCH_NAV_BUTTON = new AppElement(
            "Search navigation button",
            MobileBy.AccessibilityId("menu_item_search"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement RESERVATIONS_NAV_BUTTON = new AppElement(
            "Reservations navigation button",
            MobileBy.AccessibilityId("menu_item_reservations"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement ASSISTANCE_NAV_BUTTON = new AppElement(
            "Assistance navigation button",
            MobileBy.AccessibilityId("menu_item_help"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement PROFILE_NAV_BUTTON = new AppElement(
            "Profile navigation button",
            MobileBy.AccessibilityId("menu_item_account"),
            By.id(""),
            ScrollTo.NO,
            true);

    public NavbarScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void tapSearchButton() {
        tap(SEARCH_NAV_BUTTON);
    }

    public void tapReservationsButton() {
        tap(RESERVATIONS_NAV_BUTTON);
    }

    public void tapAssistanceButton() {
        tap(ASSISTANCE_NAV_BUTTON);
    }

    public void tapProfileButton() {
        tap(PROFILE_NAV_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(SEARCH_NAV_BUTTON);
        return allRequiredElementDisplayed();
    }
}
