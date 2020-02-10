package com.mobile.automation.framework.stepDefinition;

import com.mobile.automation.framework.Hooks;
import com.mobile.automation.framework.screens.DashboardScreen;
import cucumber.api.java.en.And;
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
