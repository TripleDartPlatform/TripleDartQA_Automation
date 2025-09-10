package hooks;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.*;
import org.testng.annotations.AfterTest;
import utils.ExtentManager;
import factory.DriverFactory;


public class Hooks {

    //private static ExtentReports extent = ExtentManager.getExtentReports();
    //private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();
    @Before
    public void beforeScenario(Scenario scenario) {
        //ExtentTest test = extent.createTest(scenario.getName());
        //scenarioTest.set(test);
        DriverFactory.getDriver();
    }

    @AfterTest
    public void afterTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //scenarioTest.get().log(Status.FAIL, "Scenario Failed");
        } else {
            //scenarioTest.get().log(Status.PASS, "Scenario Passed");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            //scenarioTest.get().log(Status.FAIL, "Scenario Failed");
        } else {
            //scenarioTest.get().log(Status.PASS, "Scenario Passed");
        }
    }

    @AfterAll
    public static void afterAll() {
        //extent.flush();
        DriverFactory.closeDriver();
    }

//    @AfterStep
//    public void afterStep(Scenario scenario) {
//        if (scenario.isFailed()) {
//            ExtentCucumberAdapter.addTestStepLog(scenario.getName()+" Step Failed");
//            //scenarioTest.get().log(Status.FAIL, "Step Failed");
//        } else {
//            //scenarioTest.get().log(Status.PASS, "Step Passed");
//            ExtentCucumberAdapter.addTestStepLog(scenario.getName()+" Step Passed");
//        }
//    }
}
