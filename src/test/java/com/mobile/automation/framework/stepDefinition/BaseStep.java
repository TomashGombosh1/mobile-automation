package com.mobile.automation.framework.stepDefinition;

import javax.inject.Inject;

import com.mobile.automation.framework.service.DeviceServiceImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

/**
 * @author Tomash Gombosh
 */
public class BaseStep {
    @Inject
    private DeviceServiceImpl deviceService;

    @Given("I install application")
    public void iInstallApplication() {
        deviceService.uninstallAndReinstallApp();
    }

    @And("^I enable all network activity$")
    public void iEnableAllNetworkActivity() {

    }
}
