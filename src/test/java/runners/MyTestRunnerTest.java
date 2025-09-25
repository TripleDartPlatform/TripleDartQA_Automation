package runners;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.ConfigurationParameter;

@Suite
@SelectPackages("features")
@ConfigurationParameter(key = "glue", value = "stepdefinitions; hooks")
@ConfigurationParameter(key = "plugin", value = "pretty,html:target/cucumber-reports.html,json:target/cucumber-reports.json,com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class MyTestRunnerTest {
}
