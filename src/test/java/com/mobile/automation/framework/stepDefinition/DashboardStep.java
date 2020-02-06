package com.mobile.automation.framework.stepDefinition;

import javax.inject.Inject;

import com.mobile.automation.framework.screens.DashboardScreen;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class DashboardStep {
    @Inject
    private DashboardScreen dashboardScreen;

    @Then("^I am on Sign Page$")
    public void iAmOnSignPage() {
        assertThat(dashboardScreen.isDisplayed()).isEqualTo(true);
    }
}
