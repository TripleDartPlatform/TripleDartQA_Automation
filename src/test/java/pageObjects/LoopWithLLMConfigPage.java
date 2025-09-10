package pageObjects;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.time.Duration;

public class LoopWithLLMConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public LoopWithLLMConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));

    //==================================== Loop WebElements =============================================
    @FindBy(how = How.XPATH, using = "//div[@class='ace_scroller ']")
    private WebElement txtArea_Items;


    @FindBy(how = How.XPATH, using = "//button[text()='Test']/following-sibling::button")
    private WebElement btn_CloseLoopConfig;

//==================================== Loop Methods =============================================

    public void clickAndEnterItemsOnInputField(String items) {
        try {
            utils.clickAndSendKeyElementUsingActions(txtArea_Items,items);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnCloseButtonInLoopConfigButton() {
        try {
            utils.clickElement(btn_CloseLoopConfig, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    //==================================== LLM WebElements =============================================
    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Enter user message...']")
    private WebElement txtArea_UserMessage;


//==================================== LLM Methods =============================================

    public void clickAndEnterUserMessageOnInputField(String items) {
        try {
            utils.clickAndSendKeyElementUsingActions(txtArea_UserMessage,items+" ");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void expandTheInTheInsertVariableModal(String insertVariableName) {
        try {
            utils.clickElement(DriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'"+insertVariableName+"')]/ancestor::button/preceding-sibling::button")),10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


}
