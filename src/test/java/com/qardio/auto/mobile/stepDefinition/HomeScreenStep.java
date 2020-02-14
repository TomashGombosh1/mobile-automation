package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.HomeScreen;
import com.qardio.auto.mobile.screens.SideMenuScreen;
import cucumber.api.java.en.When;


/**
 * @author Oleksii Borzykin
 */
public class HomeScreenStep {
    private HomeScreen homeScreen;
    private SideMenuScreen sideMenuScreen;

    public HomeScreenStep() {
        this.homeScreen = new HomeScreen(Hooks.driver);
        this.sideMenuScreen = new SideMenuScreen(Hooks.driver);
    }

    @When("^I tap the \"Workforce\" button$")
    public void iTapTheWorkforceButton() {
        homeScreen.tapWorkforceButton();
    }

    @When("^I tap the \"Chat\" button$")
    public void iTapTheChatButton() {
        homeScreen.tapChatButton();
    }
}
