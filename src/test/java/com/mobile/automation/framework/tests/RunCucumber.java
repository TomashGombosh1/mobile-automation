package com.mobile.automation.framework.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        glue = {"src.test.java.com.mobile.automation.framework.tests.steps"},
        features = {"src/test/resources/com/mobile/automation/framework/feature"},
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber-report/cucumber.xml"} )
public class RunCucumber {
}
