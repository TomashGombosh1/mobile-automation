package com.mobile.automation.framework;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "src/test/resources/feature",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber-report/cucumber.xml"})
public class RunCucumber {

}
