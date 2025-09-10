package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue={"stepdefinitions", "hooks"}
        ,tags = "@CreateNewLoopWithLLMWorkFlowAndPublish"
        ,plugin = { "pretty",
                    "html:target/cucumber-reports.html"
                    ,"json:target/cucumber-reports.json"
                    ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner {
}
