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
public class SignUpScreen extends AbstractScreen {

    private static final AppElement FIRST_NAME_FIELD = new AppElement(
            "First name field",
            MobileBy.AccessibilityId("input_firstname"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement LAST_NAME_FIELD = new AppElement(
            "Last name field",
            MobileBy.AccessibilityId("input_lastname"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement PHONE_NUMBER_FIELD = new AppElement(
            "Phone number field",
            MobileBy.AccessibilityId("input_phone_number"),
            By.id(""),
            ScrollTo.NO,
            true);

    public SignUpScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean getElementAttribute(final String element, final String attribute) {
        switch (element) {
            case "first name":
                return getAttribute(FIRST_NAME_FIELD, attribute);
            case "last name":
                return getAttribute(LAST_NAME_FIELD, attribute);
            case "phone number":
                return getAttribute(PHONE_NUMBER_FIELD, attribute);
            default:
                throw new IllegalArgumentException("Element: " + element + " is not handled in switch");
        }
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(FIRST_NAME_FIELD);
        return allRequiredElementDisplayed();
    }
}
