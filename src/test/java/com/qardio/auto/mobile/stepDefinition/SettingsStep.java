package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.HomeScreen;
import com.qardio.auto.mobile.screens.SettingsScreen;
import com.qardio.auto.mobile.screens.SideMenuScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Oleksii Borzykin
 */
public class SettingsStep {
    private SettingsScreen settingsScreen;

    public SettingsStep() {
        this.settingsScreen = new SettingsScreen(Hooks.driver);
    }


    @And("^Save the settings changes$")
    public void saveTheSettingsChanges() {
        settingsScreen.tapSaveButton();
    }

    @And("^Enter valid \"([^\"]*)\" number and \"([^\"]*)\" address$")
    public void enterValidNumberAndAddress(String phone, String email) {
        settingsScreen.fillContactPhone(phone);
        settingsScreen.fillContactEmail(email);
    }

    @Then("^Entered \"([^\"]*)\" number and \"([^\"]*)\" address are saved in the settings$")
    public void enteredNumberAndAddressAreSavedInTheSettings(String phone, String email) {
        String savedPhone = settingsScreen.getSavedPhoneNumber();
        String savedEmail = settingsScreen.getSavedEmailAddress();
        assertThat(savedPhone).isEqualTo(phone);
        assertThat(savedEmail).isEqualTo(email);
    }
}
