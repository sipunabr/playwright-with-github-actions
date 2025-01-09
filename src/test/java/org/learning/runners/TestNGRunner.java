package org.learning.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.learning.steps", "org.learning.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
