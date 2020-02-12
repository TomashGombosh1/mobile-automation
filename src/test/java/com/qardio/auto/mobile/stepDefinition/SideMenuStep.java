package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.config.ApplicationProperties;
import com.qardio.auto.mobile.screens.*;
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
    private ActionsScreen actionsScreen;
    private WorkforceScreen workforceScreen;

    public SideMenuStep() {
        this.homeScreen = new HomeScreen(Hooks.driver);
        this.sideMenuScreen = new SideMenuScreen(Hooks.driver);
        this.preDriveChecklistScreen = new PreDriveChecklistScreen(Hooks.driver);
        this.logoutScreen = new LogoutScreen(Hooks.driver);
        this.actionsScreen = new ActionsScreen(Hooks.driver);
        this.workforceScreen = new WorkforceScreen(Hooks.driver);
    }

    @When("^I tap the \"Menu\" button$")
    public void iTapTheMenuButton() {
        homeScreen.tapMenuButton();
    }

    @Then("^The \"Side menu\" is opened$")
    public void theSideMenuIsOpened() {
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

    @When("^I tap the \"(Home|Vehicle|HOS|Actions|Workforce)\" menu button$")
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
            case "Actions":
                sideMenuScreen.tapActionsButton();
                break;
            case "Workforce":
                sideMenuScreen.tapWorkforceButton();
                break;
        }
    }

    @Then("^The \"Pre-drive checklist\" screen is opened$")
    public void thePreDriveScreenIsOpened() {
        if (ApplicationProperties.CURRENT_OS.equals("ANDROID")) {
            assertThat(preDriveChecklistScreen.getScreenTitle()).isEqualTo("Pre-drive checklist");
        } else {
            assertThat(preDriveChecklistScreen.getScreenTitle()).isEqualTo("Log In");
        }
    }

    @Then("^The \"Logout\" screen is opened$")
    public void theLogoutScreenIsOpened() {
        assertThat(logoutScreen.getScreenTitle()).isEqualTo("Logout");
    }

    @Then("^The \"Actions\" screen is opened$")
    public void theActionsScreenIsOpened() {
        assertThat(actionsScreen.getScreenTitle()).isEqualTo("Actions");
    }

    @Then("^The \"Workforce\" screen is opened$")
    public void theWorkforcesScreenIsOpened() {
        if (ApplicationProperties.CURRENT_OS.equals("ANDROID")) {
            assertThat(workforceScreen.getScreenTitle()).contains("Work");
        } else {
            assertThat(workforceScreen.getScreenTitle()).isEqualTo("Jobs");
        }
    }
}