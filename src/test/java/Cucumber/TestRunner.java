package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",   // Path to feature files
    glue = "Cucumber",                          // Package for step definitions
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
