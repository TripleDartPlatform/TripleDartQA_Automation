package pageObjects.WorkFlows;
import java.time.Duration;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;
public class GoogleSearchConfigPage {
    WebDriver driver;
    CommonUtils utils;
    public GoogleSearchConfigPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        this.utils = new CommonUtils(DriverFactory.getDriver());
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//input[@name='query']")
    private WebElement txtBox_SearchQuery;

    @FindBy(how = How.XPATH, using = "//button//*[name()='svg' and contains(@class,'braces')]")
    private WebElement lbl_BracesInsideSearchBox;

    @FindBy(how = How.XPATH, using = "//button//div[contains(text(),'Structured Results')]")
    private WebElement btn_ResultFormatStructuredResults;

    @FindBy(how = How.XPATH, using = "//button[text()='Test']/following-sibling::button")
    private WebElement btn_CloseGoogleSearchConfig;

    //=======================================================================================
    //Insert Variables Section

    @FindBy(how = How.XPATH, using = "//*[name()='svg' and contains(@class,'file-input')]/following-sibling::span[contains(text(),'Input')]")
    private WebElement lbl_InputLabel;


    //=======================================================================================

    public void clickOnSearchQueryInputField() {
        try {
            utils.clickElement(txtBox_SearchQuery, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


    public void clickOnCurlyBracesInsideInputField() {
        try {
            utils.clickElement(lbl_BracesInsideSearchBox, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public void expandInputInInsertVariableModal() {
        try {
            utils.clickElement(lbl_InputLabel, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public void selectVariable(String variableName) {
        try {
            WebElement variableElement = driver.findElement(By.xpath("//span//span[contains(text(),'" + variableName + "')]"));
            utils.waitUntilElementToBeClickable(variableElement, 10);
            utils.clickElement(variableElement, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnCloseButtonInGoogleSearchConfig() {
        try {
            utils.clickElement(btn_CloseGoogleSearchConfig, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


}
