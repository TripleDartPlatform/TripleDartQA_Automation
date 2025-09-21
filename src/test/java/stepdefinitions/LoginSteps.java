package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.Dimension;
import pageObjects.General.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginSteps {

//    WebDriver driver;
    LoginPage loginPage;
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

//
//
//    @Given("I setup the environment and launch the site with the following details:")
//    public void iSetupTheEnvironmentWithTheFollowingDetails(DataTable table) {
//        List<List<String>> rows = table.asLists();
//        String browser = rows.get(0).get(0); // Assuming the browser is in the first row, first column
//        String url = rows.get(0).get(1); // Assuming the URL is in the first row, second column
//
//        switch (browser.toLowerCase()) {
//            case "chrome":
//                System.out.println("Browser is set to Chrome.");
//                // Set the path for the ChromeDriver executable
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\drivers/chromedriver.exe");
//                // Create a new instance of the ChromeDriver
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                System.out.println("Browser is set to Firefox.");
//                // Add Firefox setup code here if needed
//                break;
//            default:
//                System.out.println("Unsupported browser: " + browser);
//                Assert.fail("Unsupported browser: " + browser);
//        }
//        // Maximize the browser window
//        driver.manage().window().maximize();
//        // Set an implicit wait of 10 seconds
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        // Navigate to the Slate page
//        driver.get(url);
//        System.out.println("Environment setup completed.");
//    }

    @Given("I login to the slate page with username as {string} and password as {string}")
    public void iLoginToTheTestPageWithUsernameAs(String email, String password) throws InterruptedException {
        DriverFactory.getDriver().get("https://app.slatehq.ai/ws/114/workflows");
        Dimension dm = DriverFactory.getDriver().manage().window().getSize();
        int relativemaxheight = 1920; // put your screen resolution height
        int relativemaxwidth = 1080;   // put your screen resolution width
        if(dm.height < relativemaxheight && dm.width < relativemaxwidth){
            DriverFactory.getDriver().manage().window().maximize();
        }
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.signIn(email, password);
        System.out.println("LoggedIn successfully.");
        Thread.sleep(5000); // Wait for 5 seconds to ensure the page loads completely
        logger.info("LoggedIn successfully.");
    }

//    @And("I close the browser")
//    public void iCloseTheBrowser() {
//        try {
//            // Close the browser
//            DriverFactory.getDriver().quit();
//            System.out.println("Browser closed successfully.");
//            logger.info("Browser closed successfully.");
//        } catch (Exception e) {
//            // Print the exception message to the console
//            System.out.println("An error occurred while closing the browser: " + e.getMessage());
//        }
//    }

    @And("I logout from the application")
    public void iLogoutFromTheApplication() {
        try {
            loginPage.logout();
            System.out.println("Logged out successfully.");
            logger.info("Logged out successfully.");
        } catch (Exception e) {
            // Print the exception message to the console
            System.out.println("An error occurred while logging out: " + e.getMessage());
        }
    }
}