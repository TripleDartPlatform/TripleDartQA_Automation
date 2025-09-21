package pageObjects.WorkFlows;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.time.Duration;

public class WebScrapeConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public WebScrapeConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'search')]")
    private WebElement txtBox_WebsiteURL;

    @FindBy(how = How.XPATH, using = "//button//div[contains(text(),'Markdown Format')]")
    private WebElement btn_MarkdownFormat;


    public void clickOnWebsiteURLInputField() {
        try {
            utils.clickElement(txtBox_WebsiteURL, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnMarkdownFormatButton() {
        try {
            utils.clickElement(btn_MarkdownFormat, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
