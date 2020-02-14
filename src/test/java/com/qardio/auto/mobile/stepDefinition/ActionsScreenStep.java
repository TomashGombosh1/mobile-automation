package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.config.ApplicationProperties;
import com.qardio.auto.mobile.screens.ActionsScreen;
import com.qardio.auto.mobile.screens.DmalfunctionScreen;
import com.qardio.auto.mobile.screens.EditSuggestionsScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Oleksii Borzykin
 */
public class ActionsScreenStep {
    private ActionsScreen actionsScreen;
    private EditSuggestionsScreen editSuggestionsScreen;
    private DmalfunctionScreen dmalfunctionScreen;

    public ActionsScreenStep() {
        this.actionsScreen = new ActionsScreen(Hooks.driver);
        this.editSuggestionsScreen = new EditSuggestionsScreen(Hooks.driver);
        this.dmalfunctionScreen = new DmalfunctionScreen(Hooks.driver);
    }

    @When("^I tap the \"D/Malfunction\" button$")
    public void iTapTheDmalfunctionButton() {
        actionsScreen.tapDmalfunctionButton();
    }

    @And("^I tap the \"Edit suggestions\" button$")
    public void iTapTheEditSuggestionsButton()  {
        actionsScreen.tapEditSuggestionsButton();
    }

    @Then("^The \"Edit suggestions\" screen is opened$")
    public void theEditSuggestionsScreenIsOpened() {
        editSuggestionsScreen.dismissAlert();
        assertThat(editSuggestionsScreen.getScreenTitle()).isEqualTo("Edit Suggestions");
    }

    @Then("^The \"D/Malfunction\" screen is opened$")
    public void theDmalfunctionScreenIsOpened()  {
        if (ApplicationProperties.CURRENT_OS.equals("ANDROID") && actionsScreen.isAlertPresent()) {
            actionsScreen.dismissNoRecordsAlert();
        } else {
            assertThat(dmalfunctionScreen.getScreenTitle()).isEqualTo("D/Malfunction");
        }
    }
}
