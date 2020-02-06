package com.mobile.automation.framework.screens;

import com.mobile.automation.framework.common.AppElement;
import com.mobile.automation.framework.common.ScrollTo;
import com.mobile.automation.framework.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.mobile.automation.framework.config.ApplicationProperties.ANDROID_APP_PACKAGE;

/**
 * @author Tomash Gombosh
 */
public class SignInScreen extends AbstractScreen {
    private static final AppElement EMAIL_FIELD = new AppElement(
            "Email field",
            By.id(String.format("%s:%s", ANDROID_APP_PACKAGE, "id/email_edit")),
            ScrollTo.NO,
            true);
    private static final AppElement PASSWORD_FIELD = new AppElement(
            "Email field",
            By.id(String.format("%s:%s", ANDROID_APP_PACKAGE, "id/password_edit")),
            ScrollTo.NO,
            true);
    private static final AppElement LOGIN_BUTTON = new AppElement(
            "Email field",
            By.id(String.format("%s:%s", ANDROID_APP_PACKAGE, "id/login_button")),
            ScrollTo.NO,
            true);

    public SignInScreen(final AppiumDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(EMAIL_FIELD);
        return allRequiredElementDisplayed();
    }

    public void fillLogin(final User user) {
        enterText(EMAIL_FIELD, user.getEmail());
        enterText(PASSWORD_FIELD, user.getPassword());
    }

    public void fillLogin(final String email, final String password) {
        enterText(EMAIL_FIELD, email);
        enterText(PASSWORD_FIELD, password);
    }

    public void clickLogin() {
        tap(LOGIN_BUTTON);
    }
}
