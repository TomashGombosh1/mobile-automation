package com.mobile.automation.framework.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

/**
 * @author Tomash Gombosh
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        tags = "@Candidate",
        features = "src/test/java/resources/com/mobile/automation/framework/feature",
        glue = {"src/test/java/com/mobile/automation/framework/tests/stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
        })
public class RunCucumberTest {
    private JUnitCore jUnitCore;
}
