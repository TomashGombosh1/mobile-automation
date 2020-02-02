package com.mobile.automation.framework.service;

import com.mobile.automation.framework.common.ScrollTo;
import org.openqa.selenium.By;

/**
 * @author Tomash Gombosh
 */
public interface ScrollService {

    void scrollUpUntilVisible(By element);

    void scrollDownUntilVisible(By element);

    void scrollUntilVisible(ScrollTo scrollDirection, By element);

    void scrollUp();

    void scrollDown();
}
