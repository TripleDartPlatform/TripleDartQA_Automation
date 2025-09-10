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

public class CallToAPIConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public CallToAPIConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'api')]")
    private WebElement txtBox_APIEndPointQuery;

    @FindBy(how = How.XPATH, using = "//button//div[contains(text(),'GET')]")
    private WebElement btn_GetRequestMethod;

    @FindBy(how = How.XPATH, using = "//button//div[contains(text(),'POST')]")
    private WebElement btn_PostRequestMethod;

    @FindBy(how = How.XPATH, using = "//div[@class='ace_scroller ']")
    private WebElement txtArea_APIRequestBody;




    public void clickOnAPIEndpointURLInputField() {
        try {
            utils.clickElement(txtBox_APIEndPointQuery, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnRequestMethod(String requestMethod) {
        try {
            if(requestMethod.equals("GET")) {
                utils.clickElement(btn_GetRequestMethod, 10);
            }
            else if(requestMethod.equals("POST")) {
                utils.clickElement(btn_PostRequestMethod, 10);
            }

    } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterRequestBody() {
        try {
            String requestBody = "{\n" +
                    "   \"name\": \"Apple MacBook Pro 16\",\n" +
                    "   \"data\": {\n" +
                    "      \"year\": 2019,\n" +
                    "      \"price\": 1849.99,\n" +
                    "      \"CPU model\": \"Intel Core i9\",\n" +
                    "      \"Hard disk size\": \"1 TB\"\n" +
                    "   }\n" +
                    "}";
            utils.scrollToElement(txtArea_APIRequestBody);
            utils.clickAndSendKeyElementUsingActions(txtArea_APIRequestBody,requestBody);
//
//            txtArea_APIRequestBody.sendKeys(requestBody);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
