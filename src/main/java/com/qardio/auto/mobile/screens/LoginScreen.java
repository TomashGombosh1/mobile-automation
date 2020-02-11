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
public class LoginScreen extends AbstractScreen {
    private static final AppElement ID_FIELD = new AppElement(
            "ID field",
            By.id(formatAndroidId("edt_name")),
            By.xpath("//XCUIElementTypeTextField[@value='ID']"),
            ScrollTo.NO,
            true);

    private static final AppElement PASSWORD_FIELD = new AppElement(
            "Password field",
            By.id(formatAndroidId("edt_pwd")),
            By.xpath("//XCUIElementSecureTypeTextField[@value='Password']"),
            ScrollTo.NO,
            true);

    private static final AppElement LOG_IN_BUTTON = new AppElement(
            "Login button",
            By.id(formatAndroidId("btn_login")),
            By.xpath("//XCUIElementTypeButton[@name='Log In']"),
            ScrollTo.NO,
            true);


    public LoginScreen(final AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void fillLogin(final User user) {
        waitToBeVisible(ID_FIELD);
        enterText(ID_FIELD, user.getId());
        enterText(PASSWORD_FIELD, user.getPassword());
    }

    public void fillLogin(final String id, final String password) {
        this.fillLogin(new User(data -> {
            data.setId(id);
            data.setPassword(password);
        }));
    }

    public void tapLogInButton() {
        tap(LOG_IN_BUTTON);
    }

    @Override
    public boolean isDisplayed() {
        waitToBeVisible(ID_FIELD);
        return allRequiredElementDisplayed();
    }
}
