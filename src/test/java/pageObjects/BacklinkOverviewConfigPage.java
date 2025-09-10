package pageObjects;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.time.Duration;

public class BacklinkOverviewConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public BacklinkOverviewConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Domain')]")
    private WebElement txtBox_BacklinkOverviewQuery;

    public void clickOnBacklinkOverviewQueryInputField() {
        try {
            utils.clickElement(txtBox_BacklinkOverviewQuery, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
