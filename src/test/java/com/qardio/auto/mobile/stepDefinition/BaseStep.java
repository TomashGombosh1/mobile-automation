package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.service.DeviceServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BaseStep {

    private DeviceServiceImpl deviceService;

    public BaseStep() {
        this.deviceService = new DeviceServiceImpl(Hooks.driver);
    }

    @Given("I install application")
    public void iInstallApplication() {
        deviceService.uninstallAndReinstallApp();
    }

    @Given("^I enable all network activity$")
    public void iEnableAllNetworkActivity() {

    }

    @When("^I restart the app$")
    public void iRestartTheApp() {
        deviceService.closeAndLaunchApp();
    }
}
