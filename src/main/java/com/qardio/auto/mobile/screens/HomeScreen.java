package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class HomeScreen extends AbstractScreen {

    private static final AppElement PARKING_BUTTON = new AppElement(
            "Parking button",
            By.id("button_park"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement RENT_BUTTON = new AppElement(
            "Rent button",
            By.id("button_rent"),
            By.id(""),
            ScrollTo.NO,
            true);

    public HomeScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getButtonAttribute(final String button, final String attribute) {
        if ("car".equals(button)) {
            return getAttribute(RENT_BUTTON, attribute);
        } else if ("parking".equals(button)) {
            return getAttribute(PARKING_BUTTON, attribute);
        }
        return false;
    }

    public void tapParkingButton() {
        waitToBeClickable(PARKING_BUTTON);
        tap(PARKING_BUTTON);
    }

    public void tapRentButton() {
        waitToBeClickable(RENT_BUTTON);
        tap(RENT_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(PARKING_BUTTON);
        return allRequiredElementDisplayed();
    }
}
