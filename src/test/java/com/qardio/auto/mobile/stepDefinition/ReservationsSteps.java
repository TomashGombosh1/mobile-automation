package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.ReservationsScreen;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class ReservationsSteps {
    private ReservationsScreen reservationsScreen;

    public ReservationsSteps() {
        this.reservationsScreen = new ReservationsScreen(Hooks.driver);
    }

    @Then("^i see button \"(sign-in|qrcode)\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"([^\"]*)\"$")
    public void iSeeButtonOnReservationsScreenWithAttributeSetTo(final String button, final String attribute, final String value) {
        assertThat(reservationsScreen.isDisplayed()).isEqualTo(true);
        assertThat(reservationsScreen.getButtonAttribute(button, attribute)).isEqualTo(Boolean.parseBoolean(value));
    }
}
