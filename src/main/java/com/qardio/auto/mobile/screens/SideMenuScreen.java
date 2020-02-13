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
public class SideMenuScreen extends AbstractScreen {
    private static final AppElement DRIVER_NAME = new AppElement(
            "Driver name",
            By.id(formatAndroidId("user_name")),
            MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[2]"),
            ScrollTo.NO,
            true);

    private static final AppElement HOME_BUTTON = new AppElement(
            "Home button",
            By.xpath("//*[@resource-id='com.iss.hos.phone:id/nav_view']//android.widget.TextView[@text='Home']"),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Home'"),
            ScrollTo.NO,
            true);

    private static final AppElement VEHICLE_BUTTON = new AppElement(
            "Vehicle button",
            By.xpath("//*[@resource-id='com.iss.hos.phone:id/nav_view']//android.widget.TextView[@text='Vehicle']"),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Vehicle' AND visible == 1"),
            ScrollTo.NO,
            true);

    private static final AppElement HOS_BUTTON = new AppElement(
            "HOS button",
            By.xpath("//*[@resource-id='com.iss.hos.phone:id/nav_view']//android.widget.TextView[@text='HOS']"),
            MobileBy.iOSClassChain("**/XCUIElementTypeCell/XCUIElementTypeStaticText[`name CONTAINS \"HOS\"`]"),
            ScrollTo.NO,
            true);

    private static final AppElement PRE_DRIVE_CHECKLIST_BUTTON = new AppElement(
            "Pre-drive checklist button",
            By.xpath("//*[@resource-id='com.iss.hos.phone:id/nav_view']//android.widget.TextView[@text='Pre-drive checklist']"),
            ScrollTo.NO,
            true);

    private static final AppElement FMCSA_BUTTON = new AppElement(
            "FMCSA Data Transfer button",
            By.xpath("//*[@resource-id='com.iss.hos.phone:id/nav_view']//android.widget.TextView[contains(@text,'FMCSA')]"),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value CONTAINS 'FMCSA Data'"),
            ScrollTo.NO,
            true);

    private static final AppElement ACTIONS_BUTTON = new AppElement(
            "Actions button",
            By.xpath("//*[@resource-id='com.iss.hos.phone:id/nav_view']//android.widget.TextView[@text='Actions']"),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Actions'"),
            ScrollTo.NO,
            true);

    private static final AppElement WORKFORCE_BUTTON = new AppElement(
            "Workforce button",
            By.xpath("//*[@resource-id='com.iss.hos.phone:id/nav_view']//android.widget.TextView[@text='Workforce']"),
            MobileBy.iOSClassChain("**/XCUIElementTypeCell/XCUIElementTypeStaticText[`name BEGINSWITH \"Work\"`]"),
            ScrollTo.NO,
            true);

    private static final AppElement LOG_OUT_BUTTON = new AppElement(
            "Log out button",
            By.xpath("//android.widget.TextView[contains(@text,'Log Out')]"),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Log Out'"),
            ScrollTo.DOWN,
            true);

    public SideMenuScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getDriverName() {
        waitToBeVisible(DRIVER_NAME);
        return getText(DRIVER_NAME);
    }

    public void tapHomeButton() {
        waitToBeVisible(HOME_BUTTON);
        tap(HOME_BUTTON);
    }

    public void tapVehicleButton() {
        waitToBeVisible(VEHICLE_BUTTON);
        tap(VEHICLE_BUTTON);
    }

    public void tapHosButton() {
        waitToBeVisible(HOS_BUTTON);
        tap(HOS_BUTTON);
    }

    public void tapPreDriveChecklistButton() {
        waitToBeVisible(PRE_DRIVE_CHECKLIST_BUTTON);
        tap(PRE_DRIVE_CHECKLIST_BUTTON);
    }

    public void tapFmcsaButton() {
        waitToBeVisible(FMCSA_BUTTON);
        tap(FMCSA_BUTTON);
    }

    public void tapActionsButton() {
        waitToBeVisible(ACTIONS_BUTTON);
        tap(ACTIONS_BUTTON);
    }

    public void tapWorkforceButton() {
        waitToBeVisible(WORKFORCE_BUTTON);
        tap(WORKFORCE_BUTTON);
    }

    public void tapLogOutButton() {
        // todo in progress
        waitToBeVisible(DRIVER_NAME);
        tap(LOG_OUT_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(DRIVER_NAME);
        return allRequiredElementDisplayed();
    }
}
