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
import java.util.List;

public class ConvertToJsonConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public ConvertToJsonConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'key')]")
    private WebElement txtBox_AddKey;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'value')]")
    private WebElement txtBox_AddValue;

    @FindBy(how = How.XPATH, using = "//button//*[name()='svg' and contains(@class,'braces')]")
    private List<WebElement> lbl_BracesInsideSearchBox;

    public void clickOnKeyInputField() {
        try {
            utils.clickElement(txtBox_AddKey, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnValueInputField() {
        try {
            utils.clickElement(txtBox_AddValue, 10);
            utils.clickElement(lbl_BracesInsideSearchBox.get(1), 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
