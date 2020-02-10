package com.qardio.auto.mobile.service;

import com.qardio.auto.mobile.common.AppElement;
import org.openqa.selenium.WebElement;

/**
 * @author Tomash Gombosh
 */
public interface ActionService {

    String getText(AppElement appElement);

    String getInputValue(AppElement appElement);

    String getInputValue(WebElement webElement);

    void tap(AppElement appElement, boolean isLog);

    void tap(AppElement appElement);

    void tapPercent(int widthPercent, int heightPercent);

    void tapAt(int widthX, int heightY);

    void longTap(AppElement element);

    void enterText(AppElement appElement, String text);

    void enterText(AppElement appElement, String text, boolean clear);
}
