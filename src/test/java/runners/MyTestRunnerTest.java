package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue={"stepdefinitions", "hooks"}
        ,tags = "@Logout"
        ,plugin = { "pretty",
                    "html:target/cucumber-reports.html"
                    ,"json:target/cucumber-reports.json"
                    ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class MyTestRunnerTest  {
    @Test
    public void test() {
        System.out.println("Testng test method executed");
    }
}
