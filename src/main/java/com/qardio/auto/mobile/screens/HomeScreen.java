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
public class HomeScreen extends AbstractScreen {
    private static final AppElement SCREEN_TITLE = new AppElement(
            "Screen title",
            By.id(formatAndroidId("toolbar_title")),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Home'"),
            ScrollTo.NO,
            true);

    private static final AppElement MENU_BUTTON = new AppElement(
            "Menu button",
            By.xpath("//android.widget.ImageButton[contains(@content-desc,'Navigate up')]"),
            MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name == 'ic menu'"),
            ScrollTo.NO,
            true);

    private static final AppElement QR_LABEL = new AppElement(
            "QR Label",
            By.id(formatAndroidId("tvScan")),
            MobileBy.AccessibilityId("Scan Vehicle"),
            ScrollTo.NO,
            true);

    public HomeScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getScreenTitle() {
        waitToBeVisible(SCREEN_TITLE);
        return getText(SCREEN_TITLE);
    }

    public String getQrLabel() {
        waitToBeVisible(QR_LABEL);
        return getText(QR_LABEL);
    }

    public void tapMenuButton() {
        waitToBeVisible(MENU_BUTTON);
        tap(MENU_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(SCREEN_TITLE);
        return allRequiredElementDisplayed();
    }
}
