package com.mobile.automation.framework.service;

import javax.inject.Inject;

import org.openqa.selenium.NoSuchElementException;

import static com.mobile.automation.framework.common.GlobalElements.ANDROID_LOCATION_PERMISSIONS_ALLOW_BUTTON;
import static com.mobile.automation.framework.common.GlobalElements.ANDROID_LOCATION_PERMISSIONS_DIALOG;

/**
 * @author Tomash Gombosh
 */
public class LocationAlert implements LocationAlertService {
    private final Actions actionsService;
    private final Element elementService;
    private final Waits waitsService;

    @Inject
    public LocationAlert(final Actions actionsService, final Element elementService, final Waits waitsService) {
        this.actionsService = actionsService;
        this.elementService = elementService;
        this.waitsService = waitsService;
    }

    /**
     * Accepts the Locations Permissions dialog on Android devices, if it appears.
     */
    @Override
    public void handleLocationsPermissionsDialog() {
        if (elementService.isElementPresent(ANDROID_LOCATION_PERMISSIONS_ALLOW_BUTTON)) {
            waitsService.waitToBeVisible(ANDROID_LOCATION_PERMISSIONS_DIALOG);
            actionsService.tap(ANDROID_LOCATION_PERMISSIONS_ALLOW_BUTTON);
        } else {
            throw new NoSuchElementException(String.format("No such element name %s and locator %s %s",
                    ANDROID_LOCATION_PERMISSIONS_ALLOW_BUTTON.getName(),
                    ANDROID_LOCATION_PERMISSIONS_DIALOG.getAndroidLoc(),
                    ANDROID_LOCATION_PERMISSIONS_DIALOG.getIosLoc()));
        }
    }
}
