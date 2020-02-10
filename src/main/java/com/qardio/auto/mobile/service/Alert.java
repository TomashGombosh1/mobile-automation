package com.qardio.auto.mobile.service;

import javax.inject.Inject;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.TimeoutException;

import static com.qardio.auto.mobile.common.GlobalElements.ALERT_DIALOG;
import static com.qardio.auto.mobile.common.GlobalElements.ALERT_DIALOG_LEFT_BTN;
import static com.qardio.auto.mobile.common.GlobalElements.ALERT_DIALOG_RIGHT_BTN;
import static com.qardio.auto.mobile.common.GlobalElements.ALERT_TEXT;
import static com.qardio.auto.mobile.common.GlobalElements.ALERT_TITLE;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Alert implements AlertService {
    private final Actions actionsServices;
    private final Waits waitsService;
    private final Element elementService;

    @Inject
    public Alert(final Actions actionsServices, final Waits waitsService, final Element elementService) {
        this.actionsServices = actionsServices;
        this.waitsService = waitsService;
        this.elementService = elementService;
    }


    /**
     * Checks to see if an alert is present.
     *
     * @return true if an alert is present; false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        boolean presence;
        try {
            waitsService.waitToBeVisible(ALERT_DIALOG);
            presence = true;
        } catch (TimeoutException e) {
            presence = false;
        }
        return presence;
    }

    /**
     * Gets the title of the alert.
     *
     * @return the title of the alert.
     */
    @Override
    public String getAlertTitle() {
        waitsService.waitToBeVisible(ALERT_TITLE);
        return elementService.find(ALERT_TITLE).getText();
    }


    /**
     * Gets the text from the alert.
     *
     * @return the text that was present in the alert dialog.
     */
    @Override
    public String getAlertText() {
        waitsService.waitToBeVisible(ALERT_TEXT);
        final String text = elementService.find(ALERT_TEXT).getText();
        log.info(String.format("Found Alert with text: %s", text));
        return text;
    }

    /**
     * Gets the text of the alert's left button.
     *
     * @return the text displayed in the left button of the alert.
     */
    @Override
    public String getAlertLeftButtonText() {
        waitsService.waitToBeVisible(ALERT_DIALOG_LEFT_BTN);
        return elementService.find(ALERT_DIALOG_LEFT_BTN).getText();
    }

    /**
     * Gets the text of the alert's right button.
     *
     * @return the text displayed in the right button of the alert.
     */
    @Override
    public String getAlertRightButtonText() {
        waitsService.waitToBeVisible(ALERT_DIALOG_RIGHT_BTN);
        return elementService.find(ALERT_DIALOG_RIGHT_BTN).getText();
    }

    /**
     * Gets the text from the alert and accepts it.
     *
     * @return the text that was present in the alert dialog.
     */
    @Override
    public String getAlertTextAndAccept() {
        final String text = this.getAlertText();
        actionsServices.tap(ALERT_DIALOG_RIGHT_BTN);
        return text;
    }

    /**
     * Gets the text from the alert and cancels it.
     *
     * @return the text that was present in the alert dialog.
     */
    @Override
    public String getAlertTextAndCancel() {
        final String text = this.getAlertText();
        actionsServices.tap(ALERT_DIALOG_RIGHT_BTN);
        return text;
    }
}
