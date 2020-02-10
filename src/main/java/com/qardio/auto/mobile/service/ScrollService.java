package com.qardio.auto.mobile.service;

import com.qardio.auto.mobile.common.ScrollTo;
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
