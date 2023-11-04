package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature",
		glue = {"stepDefinition"},
		monochrome = true,
		plugin = {"pretty", "html:target/test-output/cucumber.html"},
		tags = "@task"
		)

public class TestRunner {

}
