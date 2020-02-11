package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import com.qardio.auto.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.qardio.auto.mobile.common.utils.Utils.formatAndroidId;

/**
 * @author Oleksii Borzykin
 */
public class ForgotPasswordScreen extends AbstractScreen {
    private static final AppElement EMAIL_FIELD = new AppElement(
            "Email field",
            By.id(formatAndroidId("email_edit")),
            ScrollTo.NO,
            true);
    private static final AppElement RESET_PASSWORD_BUTTON = new AppElement(
            "Reset password button",
            By.id(formatAndroidId("reset_password_button")),
            ScrollTo.NO,
            true);

    public ForgotPasswordScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void fillEmail(final User user) {
        waitToBeVisible(EMAIL_FIELD);
        enterText(EMAIL_FIELD, user.getEmail());
    }

    public void fillEmail(final String email) {
        this.fillEmail(new User(data -> data.setEmail(email)));
    }

    public void tapResetPassword() {
        tap(RESET_PASSWORD_BUTTON);
    }

    //todo pop-up text locator and logic (can't be done without VPN access)

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(RESET_PASSWORD_BUTTON);
        return allRequiredElementDisplayed();
    }
}
