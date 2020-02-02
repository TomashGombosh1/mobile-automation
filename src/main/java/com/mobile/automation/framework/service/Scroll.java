package com.mobile.automation.framework.service;

import java.time.Duration;
import java.util.Arrays;
import javax.inject.Inject;

import com.google.common.base.Function;
import com.mobile.automation.framework.common.ScrollTo;
import com.mobile.automation.framework.config.ProjectConfig;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Scroll implements ScrollService {

    private final Swipe swipeService;
    private final Wait<WebDriver> fluentWait;

    @Inject
    public Scroll(final AppiumDriver driver, final Swipe swipeService, final ProjectConfig projectConfig) {
        this.swipeService = swipeService;
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(projectConfig.getTimeout()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoreAll(Arrays.asList(ElementNotVisibleException.class,
                        NoSuchElementException.class,
                        StaleElementReferenceException.class,
                        WebDriverException.class));
    }

    @Override
    public void scrollUpUntilVisible(final By element) {
        this.scrollUntilVisible(ScrollTo.UP, element);
    }


    @Override
    public void scrollDownUntilVisible(final By element) {
        this.scrollUntilVisible(ScrollTo.DOWN, element);
    }


    @Override
    public void scrollUntilVisible(final ScrollTo scrollDirection, final By element) {
        fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(final WebDriver input) {
                if (scrollDirection.equals(ScrollTo.UP)) {
                    scrollUp();
                } else {
                    scrollDown();
                }
                return input.findElement(element);
            }
        });
    }

    @Override
    public void scrollUp() {
        log.info("Scrolling up");
        swipeService.swipeVerticallyByPercent(30, 20);
    }

    @Override
    public void scrollDown() {
        log.info("Scrolling down");
        swipeService.swipeVerticallyByPercent(30, -20);
    }
}
