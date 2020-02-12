package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.HomeScreen;
import com.qardio.auto.mobile.screens.SideMenuScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Oleksii Borzykin
 */
public class SideMenuStep {
    private HomeScreen homeScreen;
    private SideMenuScreen sideMenuScreen;

    public SideMenuStep() {
        this.homeScreen = new HomeScreen(Hooks.driver);
        this.sideMenuScreen = new SideMenuScreen(Hooks.driver);
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

    @When("^I tap the \"([^\"]*)\" menu button$")
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
            default:
                throw new NoSuchElementException(button + " button");
        }
    }
}