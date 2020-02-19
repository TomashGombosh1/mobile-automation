package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.DashboardScreen;
import com.qardio.auto.mobile.service.DeviceServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BaseStep {

    private DeviceServiceImpl deviceService;
    private DashboardScreen dashboardScreen;
    public BaseStep() {
        this.deviceService = new DeviceServiceImpl(Hooks.driver);
        this.dashboardScreen = new DashboardScreen(Hooks.driver);
    }

    @Then("^I install application$")
    public void iInstallApplication() {
        dashboardScreen.scroll();
    }

    @Given("^I enable all network activity$")
    public void iEnableAllNetworkActivity() {

    }
}
