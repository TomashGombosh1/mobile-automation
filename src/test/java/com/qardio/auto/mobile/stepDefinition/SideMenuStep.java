package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.config.ApplicationProperties;
import com.qardio.auto.mobile.screens.HomeScreen;
import com.qardio.auto.mobile.screens.LogoutScreen;
import com.qardio.auto.mobile.screens.PreDriveChecklistScreen;
import com.qardio.auto.mobile.screens.SideMenuScreen;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Oleksii Borzykin
 */
public class SideMenuStep {
    private HomeScreen homeScreen;
    private SideMenuScreen sideMenuScreen;
    private PreDriveChecklistScreen preDriveChecklistScreen;
    private LogoutScreen logoutScreen;

    public SideMenuStep() {
        this.homeScreen = new HomeScreen(Hooks.driver);
        this.sideMenuScreen = new SideMenuScreen(Hooks.driver);
        this.preDriveChecklistScreen = new PreDriveChecklistScreen(Hooks.driver);
        this.logoutScreen = new LogoutScreen(Hooks.driver);
    }

    @When("^I tap the \"Menu\" button$")
    public void iTapTheMenuButton() {
        homeScreen.tapMenuButton();
    }

    @Then("^The \"Side menu\" is opened$")
    public void theIsOpened() {
        assertThat(sideMenuScreen.isDisplayed()).isEqualTo(true);
    }

    @Then("^Driver name is present in side menu$")
    public void driverNameIsPresentInSideMenu() {
        assertThat(sideMenuScreen.getDriverName()).isNotEmpty();
    }

    @And("^I scroll down and exit$")
    public void iScrollDownAndExit() {
        sideMenuScreen.tapLogOutButton();
    }

    @When("^I tap the \"(Home|Vehicle|HOS)\" menu button$")
    public void iTapTheMenuButton(String button) {
        switch (button) {
            case "Home":
                sideMenuScreen.tapHomeButton();
                break;
            case "Vehicle":
                sideMenuScreen.tapVehicleButton();
                break;
            case "HOS":
                sideMenuScreen.tapHosButton();
                break;
        }
    }

    @Then("^The \"Pre-drive checklist\" screen is opened$")
    public void thePreDriveScreenIsOpened() {
        if (ApplicationProperties.CURRENT_OS.equals("ANDROID")) {
            assertThat(preDriveChecklistScreen.getScreenTitle()).isEqualTo("Pre-drive checklist");
        }
        if (ApplicationProperties.CURRENT_OS.equals("IOS")) {
            assertThat(preDriveChecklistScreen.getScreenTitle()).isEqualTo("Log In");
        }
    }

    @Then("^The \"Logout\" screen is opened$")
    public void theLogoutScreenIsOpened() {
        assertThat(logoutScreen.getScreenTitle()).isEqualTo("Logout");
    }
}