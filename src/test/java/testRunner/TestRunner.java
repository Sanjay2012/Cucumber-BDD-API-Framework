package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
        glue = "stepDefinitions",
        monochrome = true,
        dryRun = false,
        tags= "@login or @End2End",
        plugin = "json:target/jsonReports/cucumber-report.json")

public class TestRunner {

}
