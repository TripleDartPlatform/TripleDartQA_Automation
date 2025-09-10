package pageObjects;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.CommonUtils;

import java.time.Duration;
import java.util.List;

public class HumanReviewConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public HumanReviewConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Review Content Title')]")
    private WebElement txtBox_Review_Content_Title;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Enter instructions for review')]")
    private WebElement txtBox_Review_Content_Instructions;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Select value to review')]")
    private WebElement txtBox_Review_Content_ValueToReview;

    @FindBy(how = How.XPATH, using = "//button//*[name()='svg' and contains(@class,'braces')]")
    private List<WebElement> lbl_BracesInsideSearchBox;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Search variables')]")
    private WebElement txtBox_SearchVariables;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'space')]//p")
    private WebElement txtArea_SearchResults;

    public void validateTestResultsAreLoaded() {
        try {
            // Wait for the results to load by checking for the presence of a specific element
            utils.waitForElementToBeVisible(txtArea_SearchResults,10);
            Assert.assertTrue(txtArea_SearchResults.isDisplayed(), "Test results are not loaded successfully.");
            System.out.println("Results loaded successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }




    public void clickOnHumanReviewTitleInputField() {
        try {
            utils.clickElement(txtBox_Review_Content_Title, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnReviewContentInstructionsInputField() {
        try {
            utils.clickElement(txtBox_Review_Content_Instructions, 10);
            utils.clickElement(lbl_BracesInsideSearchBox.get(1), 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public void clickOnReviewContentValueToReviewInputField() {
        try {
            utils.scrollToElement(txtBox_Review_Content_ValueToReview);
            utils.clickElement(txtBox_Review_Content_ValueToReview, 10);
            utils.clickElement(lbl_BracesInsideSearchBox.get(2), 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnSearchVariablesInputField(String variableName) {
        try {
            utils.clickElement(txtBox_SearchVariables, 10);
            utils.enterText(txtBox_SearchVariables, variableName, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
