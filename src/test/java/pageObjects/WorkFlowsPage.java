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

public class WorkFlowsPage {
    WebDriver driver;
    CommonUtils utils;

    public WorkFlowsPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        this.utils = new CommonUtils(DriverFactory.getDriver());
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'workflows')]")
    private WebElement menu_Workflows;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Workflows')]")
    private WebElement title_Workflows;

    @FindBy(how = How.XPATH, using = "//input[@name='query']")
    private WebElement txtBox_SearchQuery;

    @FindBy(how = How.XPATH, using = "//button[text()='Test']")
    private WebElement btn_TestButton;

    @FindBy(how = How.XPATH, using = "//div[@class='tiptap ProseMirror']//p")
    private WebElement txtArea_SearchResults;

    @FindBy(how = How.XPATH, using = "//*[name()='g']//*[name()='rect']")
    private List<WebElement> element_PlaceHolders;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Create workflow')]")
    private WebElement btn_CreateWorkFlow;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Workflow')]")
    private WebElement header_Workflows;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Settings')]")
    private WebElement btn_Settings;

    @FindBy(how = How.XPATH, using = " //input[contains(@placeholder,'workflow name')]")
    private WebElement txtbox_WorkflowName;


    @FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'Describe')]")
    private WebElement textarea_WorkflowDescription;


    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Done')]")
    private WebElement btn_WorkflowNameDone;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Publish')]")
    private WebElement btn_WorkflowNamePublish;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Back')]")
    private WebElement btn_Back;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'absolute bottom')]//button[1]")
    private List<WebElement> btn_MinimapElements;




    public void navigateToWorkflowsPage() {
        try {
            utils.clickElement(menu_Workflows, 10);
            // Wait for the title to be visible
            wait.until(ExpectedConditions.visibilityOf(title_Workflows));
            utils.takeSnapShot(utils.getMethodByName());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnWorkflow(String workFlowName) {
        try {
            wait.until(driver -> driver.findElement(By.xpath("//span[contains(text(),'" + workFlowName + "')]"))).isDisplayed();
            WebElement workFlowNameElement = driver.findElement(By.xpath("//span[contains(text(),'" + workFlowName + "')]"));
            utils.waitUntilElementToBeClickable(workFlowNameElement,10);
            // Click on the workflow title
            utils.clickElement(workFlowNameElement,10);
            // Wait for the workflow title to be present and clickable
            wait.until(driver -> driver.findElement(By.xpath("//h1[contains(text(),'" + workFlowName + "')]"))).isDisplayed();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void dragAndDropTheComponentIntoCanvas(String componentName) {
        try {
            WebElement dragElement = driver.findElement(By.xpath("//div[contains(text(),'" + componentName + "')]"));
            WebElement dropElement = driver.findElement(By.xpath("//*[name()='g']//*[name()='rect']"));
            utils.waitUntilElementToBeClickable(dragElement,10);
            // Wait for the Google Search element to be present and clickable
            wait.until(ExpectedConditions.elementToBeClickable(dragElement));
            // Drag and drop the Google Search element to the canvas
            utils.dragAndDrop(dragElement,dropElement);
            System.out.println("Drag and drop action performed for: " + componentName);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void dragAndDropTheComponentIntoCanvasBasedOnPosition(String componentName, String position) {
        try {
            WebElement dragElement = driver.findElement(By.xpath("//div[contains(text(),'" + componentName + "')]"));
            List<WebElement> dropElement = driver.findElements(By.xpath("//*[name()='g']//*[name()='rect']"));
            utils.waitUntilElementToBeClickable(dragElement,10);
            // Wait for the Google Search element to be present and clickable
            wait.until(ExpectedConditions.elementToBeClickable(dragElement));
            // Drag and drop the Google Search element to the canvas
            utils.dragAndDropWithPosition(dragElement,dropElement,position);

            System.out.println("Drag and drop action performed for: " + componentName);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }




    public void clickOnConfigStepBasedOnPositionInCanvas(String configureStep, String position, String dataSource) {
        try {
            utils.waitUntilElementToBeClickable(driver.findElement(By.xpath("//input[@value='" + dataSource + "']/parent::*/parent::*/parent::*//*[contains(text(),'" + configureStep + "')]")),10);
            List<WebElement> elements = driver.findElements(By.xpath("//input[@value='" + dataSource + "']/parent::*/parent::*/parent::*//*[contains(text(),'" + configureStep + "')]"));
            utils.clickConfigStepElementWithPosition(elements,configureStep,position,dataSource);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void dragAndDropTheComponentBasedOnPositionInCanvas(String componentName,String position) {
        try {
            WebElement dragElement = driver.findElement(By.xpath("//div[contains(text(),'" + componentName + "')]"));
            List<WebElement> dropElement = driver.findElements(By.xpath("//*[name()='g']//*[name()='rect']"));
            utils.waitUntilElementToBeClickable(dragElement,10);
            // Wait for the Google Search element to be present and clickable
            wait.until(ExpectedConditions.elementToBeClickable(dragElement));
            // Drag and drop the Google Search element to the canvas
            utils.dragAndDropWithPosition(dragElement,dropElement,position);
            System.out.println("Drag and drop action performed for: " + componentName);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterSearchTerm(String searchParam) {
        try {
            // Wait for the search input field to be present and clickable
            utils.enterText(txtBox_SearchQuery, searchParam, 10);
            System.out.println("Entered the search term: " + searchParam);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnTestButton() {
        try {
            // Wait for the button to be present and clickable
            utils.waitUntilElementToBeClickable(btn_TestButton,10);
            // Click on the button
            utils.clickElement(btn_TestButton,10);
            System.out.println("Clicked on the Test button: ");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

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

    public void clickOnTheCreateNewWorkflowButton() {
        try {
            utils.clickElement(btn_CreateWorkFlow, 10);
            // Wait for the title to be visible
            wait.until(ExpectedConditions.visibilityOf(header_Workflows));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterWorkFlowNameAndDescription(String workFlowName, String workFlowDescription) {
        try {
            utils.clickElement(btn_Settings,10);
            utils.enterText(txtbox_WorkflowName, workFlowName,10);
            utils.enterText(textarea_WorkflowDescription, workFlowDescription,10);
            utils.clickElement(btn_WorkflowNameDone,10);
            utils.clickElement(btn_WorkflowNamePublish,10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void validateWorkFlowPublished(String workFlowName, String status) {
        try {
            utils.clickElement(btn_Back,10);
            utils.refreshThePage();
            utils.waitForElementToBeVisible(title_Workflows,120);
            Thread.sleep(5000);
            //WebElement workflowElement = driver.findElement(By.xpath("//td//*[contains(text(),'"+workFlowName+"')]/../../../following-sibling::td//span"));
            WebElement workflowElement = driver.findElement(By.xpath("//td//*[contains(text(),'"+status+"')]/../../../../../td//*[contains(text(),'"+workFlowName+"')]"));
            utils.waitForElementToBeVisible(workflowElement,20);
            //utils.verifyTextPresentInTheElement(workflowElement,status,120);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void scrollToTheNoOutputElementInThe(String componentName) {
        try {
            WebElement workflowElement = driver.findElement(By.xpath("//input[@value='"+componentName+"']/parent::*/parent::*/parent::*//*[contains(text(),'No output')]"));
            utils.scrollToElement(workflowElement);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void scrollToTheComponent(String componentName) {
        try {
            WebElement workflowElement = driver.findElement(By.xpath("//input[@value='"+componentName+"']"));
            utils.scrollToElement(workflowElement);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void fitToViewMiniMap() {
        try {
            utils.clickElementUsingActions(btn_MinimapElements.get(1));
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
