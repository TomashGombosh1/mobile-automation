package com.mobile.automation.framework.common;

import com.mobile.automation.framework.config.ApplicationProperties;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public final class GlobalElements {
    public static final AppElement BACK_BUTTON = new AppElement(
            "Back button",
            By.id(ApplicationProperties.ANDROID_APP_PACKAGE + ":id/btnBack"),
            By.name(""),
            ScrollTo.NO,
            true);
    public static final AppElement ALERT_DIALOG = new AppElement(
            "Alert Dialog",
            By.id("com.android.packageinstaller:id/dialog_container"),
            By.xpath("//UIAAlert"),
            ScrollTo.NO,
            false);
    public static final AppElement ALERT_TITLE = new AppElement(
            "Alert Title",
            By.id("android:id/alertTitle"),
            By.xpath("//UIAAlert"),
            ScrollTo.NO,
            false);
    public static final AppElement ALERT_TEXT = new AppElement(
            "Alert Text",
            By.id("android:id/message"),
            By.xpath("//UIAAlert//UIAButton"),
            ScrollTo.NO,
            false);
    public static final AppElement ALERT_DIALOG_LEFT_BTN = new AppElement(
            "Alert Dialog, Left Button",
            By.name("DENY"),
            By.xpath("//UIAAlert//UIAButton"),
            ScrollTo.NO,
            false);
    public static final AppElement ALERT_DIALOG_RIGHT_BTN = new AppElement(
            "Alert Dialog, OK Button",
            By.id("com.android.packageinstaller:id/permission_allow_button"),
            By.xpath("(//UIAAlert//UIAButton)[last()]"),
            ScrollTo.NO,
            false);
    public static final AppElement PROCESSING_SPINNER = new AppElement(
            "Processing spinner",
            By.id("android:id/progress"),
            By.name("In progress"),
            ScrollTo.NO,
            false);
    public static final AppElement ANDROID_LOCATION_PERMISSIONS_DIALOG = new AppElement(
            "Android Location Permissions Dialog",
            By.xpath("//android.widget.LinearLayout[contains(@resource-id, \"dialog_container\")]"),
            null);
    public static final AppElement ANDROID_LOCATION_PERMISSIONS_ALLOW_BUTTON = new AppElement(
            "Android Location Permissions Allow Button",
            By.xpath("//android.widget.Button[contains(@resource-id, \"permission_allow_button\")]"),
            null);
    public static final AppElement ENABLE_LOCATION_SERVICES_ALERT_TITLE = new AppElement(
            "Enable Location Services Alert Title",
            By.xpath("//android.widget.TextView[@text='Enable Location Services']"),
            By.name(""),
            ScrollTo.NO,
            false);
    public static final AppElement CANCEL_BUTTON_ALERT = new AppElement(
            "Cancel Button Alert",
            By.xpath("//android.widget.Button[@text='Cancel']"),
            By.name(""),
            ScrollTo.NO,
            false);


    private GlobalElements() {
        throw new UnsupportedOperationException("Suppress default constructor for noninstantiability");
    }

}
