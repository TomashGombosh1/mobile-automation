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
public class ChatScreen extends AbstractScreen {
    private static final AppElement NEW_CHAT_BUTTON = new AppElement(
            "New chat button",
            By.id(formatAndroidId("fab_dialogs_new_chat")),
            MobileBy.AccessibilityId("New Chat"),
            ScrollTo.NO,
            true
    );

    public ChatScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(NEW_CHAT_BUTTON);
        return allRequiredElementDisplayed();
    }
}
