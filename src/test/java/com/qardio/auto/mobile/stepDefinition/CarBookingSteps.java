package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.CarBookingScreen;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class CarBookingSteps {

    private CarBookingScreen carBookingScreen;

    public CarBookingSteps() {
        this.carBookingScreen = new CarBookingScreen(Hooks.driver);
    }

    @Then("^i see (?:[^\"]*) \"(pick-up|modify drop-off location|start date|validate)\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"([^\"]*)\"$")
    public void iSeeTextfieldIdentifiedByWithAttributeSetTo(final String name, final String attribute, final String value) {
        assertThat(carBookingScreen.getElementAttribute(name, attribute)).isEqualTo(Boolean.parseBoolean(value));
    }
}
