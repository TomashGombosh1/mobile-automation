package com.mobile.automation.framework.service;

import java.time.Duration;
import java.util.Arrays;
import javax.inject.Inject;

import com.google.common.base.Function;
import com.mobile.automation.framework.common.AppElement;
import com.mobile.automation.framework.config.ApplicationConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.Objects.requireNonNull;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Waits implements WaitService {
    private final ApplicationConfig applicationConfig;
    private final WebDriverWait webDriverWait;
    private final Wait<WebDriver> fluentWait;

    @Inject
    public Waits(final AppiumDriver<MobileElement> driver, final ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
        webDriverWait = new WebDriverWait(driver, applicationConfig.getTimeout());
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(applicationConfig.getTimeout()))
                .pollingEvery(Duration.ofMillis(500))
                .ignoreAll(Arrays.asList(ElementNotVisibleException.class,
                        NoSuchElementException.class,
                        StaleElementReferenceException.class,
                        WebDriverException.class));
    }

    @Override
    public void waitToBeVisible(final By element) {
        fluentWait.until((Function<WebDriver, WebElement>) input -> requireNonNull(input).findElement(element));
    }

    @Override
    public void waitToBeVisible(final AppElement element) {
        this.waitToBeVisible(element.get(applicationConfig.getPlatformName()));
    }

    @Override
    public void waitToBeInvisible(final By element, final int timeout) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    @Override
    public void waitToBeInvisible(final By element) {
        this.waitToBeInvisible(element, applicationConfig.getTimeout());
    }

    @Override
    public void waitToBeInvisible(final AppElement element, final int timeout) {
        log.info("Wait to be invisible " + element.getName() + " ...");
        this.waitToBeInvisible(element.get(applicationConfig.getPlatformName()), timeout);
    }

    @Override
    public void waitToBeInvisible(final AppElement element) {
        this.waitToBeInvisible(element.get(applicationConfig.getPlatformName()), applicationConfig.getTimeout());
    }

    @Override
    public void waitToBeClickable(final By element, final int timeout) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitToBeClickable(final By element) {
        this.waitToBeClickable(element, applicationConfig.getTimeout());
    }

    @Override
    public void waitToBeClickable(final AppElement element, final int timeout) {
        this.waitToBeClickable(element.get(applicationConfig.getPlatformName()), timeout);
    }

    @Override
    public void waitToBeClickable(final AppElement element) {
        this.waitToBeClickable(element.get(applicationConfig.getPlatformName()), applicationConfig.getTimeout());
    }

    @Override
    public void waitToBePresent(final By element, final int timeout) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    @Override
    public void waitToBePresent(final By element) {
        this.waitToBePresent(element, applicationConfig.getTimeout());
    }

    @Override
    public void waitToBePresent(final AppElement element, final int timeout) {
        this.waitToBePresent(element.get(applicationConfig.getPlatformName()), timeout);
    }

    @Override
    public void waitToBePresent(final AppElement element) {
        this.waitToBePresent(element.get(applicationConfig.getPlatformName()), applicationConfig.getTimeout());
    }
}
