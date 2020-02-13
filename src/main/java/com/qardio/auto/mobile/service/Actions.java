package com.qardio.auto.mobile.service;

import javax.inject.Inject;

import com.qardio.auto.mobile.common.AppElement;
import com.qardio.auto.mobile.common.DeviceOs;
import com.qardio.auto.mobile.config.ApplicationConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Actions implements ActionService {

    private final AppiumDriver<MobileElement> driver;
    private final Element elementService;
    private final Dimension winSize;
    private final TouchAction touchAction;
    private final ApplicationConfig applicationConfig;

    @Inject
    public Actions(final AppiumDriver<MobileElement> driver,
                   final Element element,
                   final Dimension winSize,
                   final TouchAction touchAction,
                   final ApplicationConfig applicationConfig) {
        this.driver = driver;
        this.elementService = element;
        this.winSize = winSize;
        this.touchAction = touchAction;
        this.applicationConfig = applicationConfig;
    }

    @Override
    public String getText(final AppElement appElement) {
       return elementService.find(appElement).getText();
    }


    public String getAttribute(final AppElement appElement, final String attribute) {
        return elementService.find(appElement).getAttribute(attribute);
    }

    @Override
    public String getInputValue(final AppElement appElement) {
        try {
            return getInputValue(elementService.find(appElement));
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    @Override
    public String getInputValue(final WebElement webElement) {
        String value;

        if (applicationConfig.getPlatformName().equals(DeviceOs.ANDROID)) {
            value = webElement.getText();
        } else {
            value = webElement.getAttribute("value");
        }
        return value;
    }

    @Override
    public void tap(final AppElement appElement, final boolean isLog) {
        if (isLog) {
            log.info("Tapping element '" + appElement.getName());
        }
        elementService.find(appElement).click();
    }

    @Override
    public void tap(final AppElement appElement) {
        this.tap(appElement, true);
    }

    @Override
    public void tapPercent(final int widthPercent, final int heightPercent) {
        final int widthX = (winSize.width * widthPercent) / 100;
        final int heightY = (winSize.height * heightPercent) / 100;
        this.tapAt(widthX, heightY);
    }

    @Override
    public void tapAt(final int widthX, final int heightY) {
        touchAction.tap(PointOption.point(widthX, heightY));
        this.driver.performTouchAction(touchAction);
    }

    @Override
    public void longTap(final AppElement element) {
        touchAction.longPress(ElementOption.element(elementService.find(element))).release().perform();
    }

    @Override
    public void enterText(final AppElement appElement, final String text) {
        this.enterText(appElement, text, false);
    }

    @Override
    public void enterText(final AppElement appElement, final String text, final boolean clear) {
        log.info("Entering appElement '" + text + "' to element '" + appElement.getName());
        if (clear) {
            this.tap(appElement, false);
            elementService.find(appElement).clear();

        }
        elementService.find(appElement).sendKeys(text);
    }
}
