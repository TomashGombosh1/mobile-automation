package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import com.qardio.auto.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Oleksii Borzykin
 */
public class SignUpScreen extends AbstractScreen {

    private static final AppElement NAME_INPUT_FIELD = new AppElement(
            "Name field",
            By.id("com.getqardio.android:id/name_edit"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement EMAIL_INPUT_FIELD = new AppElement(
            "Email field",
            By.id("com.getqardio.android:id/email_edit"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement PASSWORD_INPUT_FIELD = new AppElement(
            "Password field",
            By.id("com.getqardio.android:id/password_edit"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement TERMS_AND_CONDITIONS_CHECKBOX = new AppElement(
            "Terms and conditions checkbox",
            By.id("com.getqardio.android:id/cbReadPrivacyPolicy"),
            By.id(""),
            ScrollTo.NO,
            true);
    private static final AppElement REGISTER_BUTTON = new AppElement(
            "Register button",
            By.id("com.getqardio.android:id/create_account_button"),
            By.id(""),
            ScrollTo.NO,
            true);

    public SignUpScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void fillSignup(final User user) {
        waitToBeVisible(NAME_INPUT_FIELD);
        enterText(NAME_INPUT_FIELD, user.getLastName());
        enterText(EMAIL_INPUT_FIELD, user.getEmail());
        enterText(PASSWORD_INPUT_FIELD, user.getPassword());
    }

    public void fillSignup(final String name, final String email, final String password) {
        fillSignup(new User(data -> {
            data.setLastName(name);
            data.setEmail(email);
            data.setPassword(password);
        }));
    }

    public void setTermsAndConditionsCheckbox() {
        waitToBeVisible(TERMS_AND_CONDITIONS_CHECKBOX);
        if (getAttribute(TERMS_AND_CONDITIONS_CHECKBOX, "Checked").equals("false")) {
            tap(TERMS_AND_CONDITIONS_CHECKBOX);
        }
    }

    public boolean isRegisterActive() {
        return Boolean.parseBoolean(getAttribute(REGISTER_BUTTON, "enabled"));
    }

    public void tapRegister() {
        waitToBeVisible(REGISTER_BUTTON);
        tap(REGISTER_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(NAME_INPUT_FIELD);
        return allRequiredElementDisplayed();
    }
}
