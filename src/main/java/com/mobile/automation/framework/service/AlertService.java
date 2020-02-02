package com.mobile.automation.framework.service;

/**
 * @author Tomash Gombosh
 */

public interface AlertService {
    boolean isDisplayed();

    String getAlertTitle();

    String getAlertText();

    String getAlertLeftButtonText();

    String getAlertRightButtonText();

    String getAlertTextAndAccept();

    String getAlertTextAndCancel();
}
