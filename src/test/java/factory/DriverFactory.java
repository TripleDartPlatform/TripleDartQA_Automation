package factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            //options.addArguments("--headless=new"); // Use new headless mode
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            // ✅ Add a unique user-data-dir to avoid session conflicts
            try {
                Path tempProfile = Files.createTempDirectory("chrome-profile");
                options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath().toString());
            } catch (IOException e) {
                throw new RuntimeException("Failed to create temp user-data-dir", e);
            }

            driver =  new ChromeDriver(options);
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/drivers/chromedriver.exe");
            //driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

//    public static void closeDriver() {
//        if (driver != null) {
//            driver.close();
//            driver = null;
//        }
//    }
}
