package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.NavbarScreen;
import cucumber.api.java.en.When;

/**
 * @author Tomash Gombosh
 */
public class NavbarSteps {

    private NavbarScreen navbarScreen;

    public NavbarSteps() {
        this.navbarScreen = new NavbarScreen(Hooks.driver);
    }

    @When("^i click on baritem \"(search|reservations|assistance|profile)\" identified by \"(?:[^\"]*)\"$")
    public void iTapNavigationBarButton(String button)  {
        switch (button) {
            case "search":
                navbarScreen.tapSearchButton();
                break;
            case "reservations":
                navbarScreen.tapReservationsButton();
                break;
            case "assistance":
                navbarScreen.tapAssistanceButton();
                break;
            case "profile":
                navbarScreen.tapProfileButton();
                break;
        }
    }
}
