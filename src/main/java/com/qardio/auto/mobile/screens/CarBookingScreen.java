package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class CarBookingScreen extends AbstractScreen {
    private static final AppElement PICK_UP_FIELD = new AppElement(
            "Pick-up field",
            By.id("edit"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement DROP_OFF_LOCATION_SWITCH = new AppElement(
            "Modify drop-off location switch",
            By.id("arrival_switch"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement START_DATE_FIELD = new AppElement(
            "Start day field",
            By.id("start_day"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement VALIDATE_BUTTON = new AppElement(
            "Validate button",
            By.id("button_search"),
            By.id(""),
            ScrollTo.NO,
            true);

    public CarBookingScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getElementAttribute(final String element, final String attribute) {
        switch (element) {
            case "pick-up":
                return getAttribute(PICK_UP_FIELD, attribute);
            case "start date":
                return getAttribute(START_DATE_FIELD, attribute);
            case "modify drop-off location":
                return getAttribute(DROP_OFF_LOCATION_SWITCH, attribute);
            case "validate":
                return getAttribute(VALIDATE_BUTTON, attribute);
            default:
                throw new IllegalArgumentException("Element: " + element + " is not handled in switch");
        }
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(PICK_UP_FIELD);
        return allRequiredElementDisplayed();
    }
}
