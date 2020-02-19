package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.HomeScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class HomeScreenSteps {
    private HomeScreen homeScreen;

    public HomeScreenSteps() {
        this.homeScreen = new HomeScreen(Hooks.driver);
    }

    @And("^i am on travelcar home Screen$")
    public void iAmOnTravelcarHomeScreen() {
        homeScreen.isDisplayed();
    }

    @Then("^i see button \"(car|parking|ride)\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"(true|false)\"$")
    public void iSeeButtonWithAttributeSetTo(final String name, final String attribute, final String value) {
        assertThat(homeScreen.getButtonAttribute(name, attribute)).isEqualTo(Boolean.parseBoolean(value));
    }

    @When("^i click on button \"(car|parking|ride)\" identified by \"(?:[^\"]*)\"$")
    public void iTapButtonOnHomeScreen(String button) {
        switch (button) {
            case "car":
                homeScreen.tapRentButton();
                break;
            case "parking":
                homeScreen.tapParkingButton();
                break;
        }
    }
}
