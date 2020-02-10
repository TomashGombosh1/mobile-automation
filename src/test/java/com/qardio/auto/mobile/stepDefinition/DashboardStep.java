package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.DashboardScreen;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class DashboardStep {
    private DashboardScreen dashboardScreen;

    public DashboardStep() {
        this.dashboardScreen = new DashboardScreen(Hooks.driver);
    }

    @Then("^I am on Sign Page$")
    public void iAmOnSignPage() {
        assertThat(dashboardScreen.isDisplayed()).isEqualTo(true);
    }

}
