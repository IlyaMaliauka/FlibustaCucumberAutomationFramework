package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue="com.automation.stepDefs",
        monochrome=true,
        plugin= {"pretty","html:test-output"}
)
public class RunCucumberTest {

}
