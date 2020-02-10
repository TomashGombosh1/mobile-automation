package com.qardio.auto.mobile.service;

import java.util.List;

import com.qardio.auto.mobile.common.AppElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Tomash Gombosh
 */
public interface ElementService {
    WebElement find(By element);

    WebElement find(AppElement element);

    List<By> findAll(By element);

    List<AppElement> findAll(AppElement element);

    boolean isElementVisible(By element);

    boolean isElementVisible(AppElement element);

    boolean isElementPresent(By element);

    boolean isElementPresent(AppElement element);

    List<AppElement> getRequiredElements();

    List<AppElement> getMissingRequiredElements(List<AppElement> requiredElements);

    List<AppElement> getElements();

    void scrollDownUntilVisible(AppElement element);

    void scrollUpUntilVisible(AppElement element);

    void scrollToElement(AppElement ele);

    void scrollFromToElement(By startElement, By endElement);

    void scrollFromToElement(AppElement startElement, AppElement endElement);
}
