package com.mobile.automation.framework.service;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import com.mobile.automation.framework.common.AppElement;
import com.mobile.automation.framework.common.ScrollTo;
import com.mobile.automation.framework.common.utils.Utils;
import com.mobile.automation.framework.config.ApplicationConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Element implements ElementService {

    private final AppiumDriver<MobileElement> driver;
    private final Scroll scrollService;
    private final TouchAction touchAction;
    private final Waits waitsService;
    private final ApplicationConfig applicationConfig;

    @Inject
    public Element(final AppiumDriver<MobileElement> driver, final Scroll scrollService, final TouchAction touchAction, final Waits waitsService) {
        this.driver = driver;
        this.scrollService = scrollService;
        this.touchAction = touchAction;
        this.waitsService = waitsService;
        applicationConfig = new ApplicationConfig();
    }

    @Override
    public WebElement find(final By element) {
        return this.driver.findElement(element);
    }

    @Override
    public WebElement find(final AppElement element) {
        if (!element.getScrollTo().equals(ScrollTo.NO)) {
            try {
                this.scrollToElement(element);
            } catch (NoSuchElementException e) {
                log.info("*** Could not scroll to element: " + element.getName());
                log.info(e);
            }
        }
        return this.find(element.get(applicationConfig.getPlatformName()));
    }

    @Override
    public List findAll(final By element) {
        return driver.findElements(element);
    }

    @Override
    public List findAll(final AppElement element) {
        return this.findAll(element.get(applicationConfig.getPlatformName()));
    }

    @Override
    public boolean isElementVisible(final By element) {
        try {
            waitsService.waitToBeVisible(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public boolean isElementVisible(final AppElement element) {
        return this.isElementVisible(element.get(applicationConfig.getPlatformName()));
    }

    @Override
    public boolean isElementPresent(final By element) {
        boolean elementFound;
        try {
            this.find(element);
            elementFound = true;
        } catch (NoSuchElementException e) {
            elementFound = false;
        }
        return elementFound;
    }

    @Override
    public boolean isElementPresent(final AppElement element) {
        return this.isElementPresent(element.get(applicationConfig.getPlatformName()));
    }

    @Override
    public List<AppElement> getRequiredElements() {
        final List<AppElement> requiredElements = new ArrayList<>();
        for (final AppElement ele : this.getElements()) {
            if (ele.isRequired()) {
                requiredElements.add(ele);
            }
        }
        return requiredElements;
    }

    @Override
    public List<AppElement> getMissingRequiredElements(final List<AppElement> requiredElements) {
        final List<AppElement> elements = new ArrayList<>(requiredElements);
        for (final AppElement ele : requiredElements) {
            if (this.isElementPresent(ele)) {
                elements.remove(ele);
            }
        }
        return elements;
    }

    @Override
    public List<AppElement> getElements() {
        final List<AppElement> elements = new ArrayList<>();
        for (final Field field : this.getClass().getDeclaredFields()) {
            if (field.getType().getSimpleName().equals("AppElement")) {
                try {
                    field.setAccessible(true);
                    elements.add((AppElement) field.get(AppElement.class));
                    field.setAccessible(false);
                } catch (IllegalAccessException ignored) {
                    log.info(ignored.getMessage());
                }
            }
        }
        return elements;
    }

    @Override
    public void scrollDownUntilVisible(final AppElement element) {
        if (!this.isElementVisible(element)) {
            log.info("Scrolling DOWN until " + element.getName() + " is visible...");
            scrollService.scrollUntilVisible(ScrollTo.DOWN, element.get(applicationConfig.getPlatformName()));
        }
    }

    @Override
    public void scrollUpUntilVisible(final AppElement element) {
        if (!this.isElementVisible(element)) {
            log.info("Scrolling UP until " + element.getName() + " is visible...");
            scrollService.scrollUntilVisible(ScrollTo.UP, element.get(applicationConfig.getPlatformName()));
        }
    }

    @Override
    public void scrollToElement(final AppElement ele) {
        if (ele.getScrollTo().equals(ScrollTo.UP)) {
            this.scrollUpUntilVisible(ele);
        } else if (ele.getScrollTo().equals(ScrollTo.DOWN)) {
            this.scrollDownUntilVisible(ele);
        }
    }

    @Override
    public void scrollFromToElement(final By startElement, final By endElement) {
        Utils.sleep(500);
        log.info("Scrolling from one element to another");
        touchAction.press(ElementOption.element(find(startElement)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(ElementOption.element(find(endElement)))
                .release()
                .perform();
        Utils.sleep(2000);
    }

    @Override
    public void scrollFromToElement(final AppElement startElement, final AppElement endElement) {
        this.scrollFromToElement(startElement.get(applicationConfig.getPlatformName()), endElement.get(applicationConfig.getPlatformName()));
    }
}
