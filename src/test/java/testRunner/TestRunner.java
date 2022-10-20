package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features/SearchServices.feature",
        glue="StepDefinition",
        dryRun = false,
        stepNotifications = true,
        plugin ={"pretty","json:target/cucumber.json","html:target/cucumber.html"})
public class TestRunner {
}