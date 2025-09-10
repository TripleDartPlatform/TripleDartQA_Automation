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

public class GetURLFromSiteMapConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public GetURLFromSiteMapConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'sitemap')]")
    private WebElement txtBox_SiteMapURL;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Max number')]")
    private WebElement btn_MaxURLs;


    public void clickOnSiteMapURLInputField() {
        try {
            utils.clickElement(txtBox_SiteMapURL, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickAndEnterMaxURLInputField(String maxURL) {
        try {
            utils.clickAndSendKeyElementUsingActions(btn_MaxURLs, maxURL);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
