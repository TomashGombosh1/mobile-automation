package com.qardio.auto.mobile.stepDefinition;

import com.qardio.auto.mobile.Hooks;
import com.qardio.auto.mobile.screens.AssistanceScreen;
import com.qardio.auto.mobile.screens.FaqScreen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tomash Gombosh
 */
public class AssistanceSteps {
    private AssistanceScreen assistanceScreen;
    private FaqScreen faqScreen;

    public AssistanceSteps() {
        this.assistanceScreen = new AssistanceScreen(Hooks.driver);
        this.faqScreen = new FaqScreen(Hooks.driver);
    }

    @When("^i click on menuitem \"faq/aide\" identified by \"(?:[^\"]*)\"$")
    public void iClickOnMenuitemIdentifiedBy()  {
        assistanceScreen.tapFaqButton();
    }

    @Then("^i see menuitem \"(faq/aide|faq)\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"([^\"]*)\"$")
    public void iSeeMenuitemIdentifiedByWithAttributeSetTo(String name, String attribute, String value) {
        assertThat(assistanceScreen.isDisplayed()).isEqualTo(true);
        assertThat(assistanceScreen.getFaqButtonAttribute(attribute)).isEqualTo(Boolean.parseBoolean(value));
    }

    @Then("^i see button \"back\" identified by \"(?:[^\"]*)\" with attribute \"([^\"]*)\" set to \"([^\"]*)\"$")
    public void iSeeButtonIdentifiedByWithAttributeSetTo(String attribute, String value) {
        assertThat(faqScreen.isDisplayed()).isEqualTo(true);
        assertThat(faqScreen.getBackButtonAttribute(attribute)).isEqualTo(Boolean.parseBoolean(value));
    }

    @When("^i click on button \"Back\" identified by \"(?:[^\"]*)\"$")
    public void iClickOnButtonIdentifiedBy()  {
        faqScreen.tapBackButton();
    }
}
