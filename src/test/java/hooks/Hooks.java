package hooks;

import io.cucumber.java.*;
//import org.junit.Test;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pageObjects.General.LoginPage;
import factory.DriverFactory;


public class Hooks {
    static LoginPage loginPage;
    private WebDriver driver;
    public static String scenarioName;
    @Before
    public void setUpScenario() {
        driver = DriverFactory.getDriver();
        driver.get("https://app.slatehq.ai/ws/114/workflows");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.signIn("kamesh25491@gmail.com", "HighPerformance@1");
        System.out.println("Scenario login complete.");
    }

    @After
    public void tearDownScenario() throws InterruptedException  {
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.logout();
        System.out.println("Scenario logout complete.");
    }

    @AfterAll
    public static void tearDownSuite() {
        //extent.flush();
        DriverFactory.quitDriver();
        System.out.println("Driver Quit successfully.");
    }
}
//    @BeforeTest
//    public void before(Scenario scenario) {
//        scenarioName = scenario.getName();
//        System.out.println("Before successfully.");
//        driver = DriverFactory.getDriver();
//        driver.get("https://app.slatehq.ai/ws/114/workflows");
//        driver.manage().window().maximize();
//        loginPage = new LoginPage(DriverFactory.getDriver());
//        loginPage.signIn("kamesh25491@gmail.com", "HighPerformance@1");
//        //DriverFactory.getDriver();
//    }
//
//    @Test
//    public void testing() {
//        System.out.println("Test successfully.");
//    }
//
//    @AfterSuite
//    public static void after() throws InterruptedException {
//        //loginPage.logout();
//        DriverFactory.quitDriver();
//        System.out.println("after successfully.");
//    }

//    @AfterAll
//    public static void afterAll() {
//        //extent.flush();
//        System.out.println("AfterAll successfully.");
//        DriverFactory.getDriver().quit();
//    }

