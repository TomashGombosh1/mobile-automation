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
public class HomeScreen extends AbstractScreen {
    private static final AppElement SCREEN_TITLE = new AppElement(
            "Screen title",
            By.id(formatAndroidId("toolbar_title")),
            By.xpath("//XCUIElementTypeStaticText[@value='Home']"),
            ScrollTo.NO,
            true);

    private static final AppElement MENU_BUTTON = new AppElement(
            "Menu button",
            By.xpath("//android.widget.ImageButton[contains(@content-desc,'Navigate up')]"),
            By.xpath("//XCUIElementTypeButton[@name='ic menu']"),
            ScrollTo.NO,
            true);

    public HomeScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getScreenTitle() {
        waitToBeVisible(SCREEN_TITLE);
        return getText(SCREEN_TITLE);
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
