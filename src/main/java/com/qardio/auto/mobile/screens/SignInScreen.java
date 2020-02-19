package com.qardio.auto.mobile.screens;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.ScrollTo;
import com.qardio.auto.mobile.config.ApplicationProperties;
import com.qardio.auto.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public class SignInScreen extends AbstractScreen {
    private static final AppElement EMAIL_FIELD = new AppElement(
            "Email field",
            By.id(String.format("%s:id/%s", ApplicationProperties.ANDROID_APP_PACKAGE, "edt_name")),
            ScrollTo.NO,
            true);
    private static final AppElement PASSWORD_FIELD = new AppElement(
            "Email field",
            By.id(String.format("%s:id/%s", ApplicationProperties.ANDROID_APP_PACKAGE, "edt_pwd")),
            ScrollTo.NO,
            true);
    private static final AppElement LOGIN_BUTTON = new AppElement(
            "Email field",
            By.id(String.format("%s:id/%s", ApplicationProperties.ANDROID_APP_PACKAGE, "bth_login")),
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

    public void clickLogin() {
        scrollService.scrollDown();
        tap(LOGIN_BUTTON);
    }

    public boolean checkLoginButtonId(final String id) {
        return isElementPresent(new AppElement(data-> {
            data.setAndroidLocator(MobileBy.id(id));
            data.setIosLocator(By.id(id));
        }));
    }
}
