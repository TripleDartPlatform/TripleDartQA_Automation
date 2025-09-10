package pageObjects;

import java.time.Duration;
import java.util.List;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.CommonUtils;

public class InputConfigPage {
    WebDriver driver;
    CommonUtils utils;
    public InputConfigPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        this.utils = new CommonUtils(DriverFactory.getDriver());
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Input')]")
    private WebElement header_Input;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add field')]")
    private WebElement btn_AddField;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Single Line Text')]")
    private WebElement btn_SingleLineText;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'label')]")
    private WebElement txtBox_Label;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'variableName')]")
    private WebElement txtBox_VariableName;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'defaultValue')]")
    private WebElement txtBox_DefaultValue;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'placeholder')]")
    private WebElement txtBox_Placeholder;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@name,'hint')]")
    private WebElement txtArea_HelpText;

    @FindBy(how = How.XPATH, using = "//button[contains(@value,'on')]")
    private WebElement toggle_IsMandatory;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Test Input')]")
    private WebElement tab_TestInput;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Input Configuration')]")
    private WebElement lbl_InputConfiguration;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Save Inputs')]")
    private WebElement btn_SaveInputs;


    public void clickOnAddFieldButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(header_Input));
            utils.clickElement(btn_AddField, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnSingleLineTextTypeButton() {
        try {
            utils.clickElement(btn_SingleLineText, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public void enterLabelName(String labelName) {
        try {
            utils.enterText(txtBox_Label, labelName, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
    public void enterVariableName(String variableName) {
        try {
            utils.enterText(txtBox_VariableName, variableName, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
    public void enterDefaultValue(String defaultValue) {
        try {
            utils.enterText(txtBox_DefaultValue, defaultValue, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
    public void enterPlaceholderValue(String placeholderValue) {
        try {
            utils.enterText(txtBox_Placeholder, placeholderValue, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
    public void enterHelptextValue(String helptextValue) {
        try {
            utils.enterText(txtArea_HelpText, helptextValue, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
    public void clickOnRequiredFieldButton() {
        try {
            utils.clickElement(toggle_IsMandatory, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }

    public void scrollToTestInputTabAndClick() {
        try {
            utils.mouseOverElement(tab_TestInput);
            utils.clickElement(tab_TestInput, 10);
            utils.waitForElementToBeVisible(lbl_InputConfiguration,10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
    public void clickOnSaveInputsButton() {
        try {
            utils.clickElement(btn_SaveInputs, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
