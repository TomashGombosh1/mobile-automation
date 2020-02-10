package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import com.qardio.auto.mobile.config.ApplicationProperties;
import com.qardio.auto.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class SignInScreen extends AbstractScreen {
    private static final AppElement EMAIL_FIELD = new AppElement(
            "Email field",
            By.id(String.format("%s:id/%s", ApplicationProperties.ANDROID_APP_PACKAGE, "email_edit")),
            ScrollTo.NO,
            true);
    private static final AppElement PASSWORD_FIELD = new AppElement(
            "Email field",
            By.id(String.format("%s:id/%s", ApplicationProperties.ANDROID_APP_PACKAGE, "password_edit")),
            ScrollTo.NO,
            true);
    private static final AppElement LOGIN_BUTTON = new AppElement(
            "Email field",
            By.id(String.format("%s:id/%s", ApplicationProperties.ANDROID_APP_PACKAGE, "login_button")),
            ScrollTo.NO,
            true);
    private static final AppElement FORGOT_PASSWORD_LINK = new AppElement(
            "Forgot password link",
            By.id(String.format("%s:id/%s", ApplicationProperties.ANDROID_APP_PACKAGE, "forgot_password_textview")),
            ScrollTo.NO,
            true);

    public SignInScreen(final AppiumDriver<MobileElement> driver) {
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
        this.fillLogin(new User(data -> {
            data.setEmail(email);
            data.setPassword(password);
        }));
    }

    public void fillPassword(final String password) {
        this.fillLogin(new User(data -> {
            data.setEmail("");
            data.setPassword(password);
        }));
    }

    public void tapLogin() {
        tap(LOGIN_BUTTON);
    }

    public void tapForgotPassword() {
        tap(FORGOT_PASSWORD_LINK);
    }

    public boolean isSignInButtonActive() {
        return Boolean.parseBoolean(getAttribute(LOGIN_BUTTON, "enabled"));
    }
}
