package utils;

import factory.DriverFactory;
import org.apache.maven.surefire.shade.org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.time.Duration;

public class CommonUtils {
    WebDriver driver;
    Actions actions = new Actions(DriverFactory.getDriver());
    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        // Implementation for waiting for an element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(driver -> element.isDisplayed());
    }

    public void waitUntilElementToBeClickable(WebElement element, int timeoutInSeconds) {
        // Implementation for waiting for an element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement element,int timeoutInSeconds) {
        waitUntilElementToBeClickable(element,timeoutInSeconds);
        element.click();
    }

    public void enterText(WebElement element, String text, int timeoutInSeconds) {
        waitForElementToBeVisible(element,timeoutInSeconds);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        // Scroll to the element using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void mouseOverElement(WebElement element) {
        //Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickAndSendKeyElementUsingActions(WebElement element,String requestBody) {
        actions.moveToElement(element).click().sendKeys(requestBody).perform();
     }

    public void clickElementUsingActions(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    public void dragAndDrop(WebElement dragElement, WebElement dropElement) {
        //Actions builder = new Actions(driver);
        actions.clickAndHold(dragElement)
                .moveToElement(dropElement)
                .release()
                .build()
                .perform();
    }

    public void clickConfigStepElementWithPosition(List<WebElement> elements, String configureStep, String position, String dataSource) {
        for (int i = 1; i <= elements.size(); i++) {
            //System.out.println(elements.size());
            if (i == Integer.parseInt(position)) {
                scrollToElement(elements.get(i - 1));
                try {
                    Thread.sleep(3000);//to be removed
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                waitUntilElementToBeClickable(elements.get(i - 1), 10);
                clickElement(elements.get(i - 1),10);
                System.out.println("Clicked on the " + dataSource + " element at position " + position + " in the " + configureStep + " element.");
                break;
            }
        }
    }


    public void dragAndDropWithPosition(WebElement sourceElement, List<WebElement> targetElements, String targetPosition) {

        for (int i = 1; i <= targetElements.size(); i++) {
            System.out.println(targetElements.size());
            if (i == Integer.parseInt(targetPosition)) {
                scrollToElement(targetElements.get(i - 1));
                waitUntilElementToBeClickable(targetElements.get(i - 1), 10);
                Actions builder = new Actions(driver);
                builder.clickAndHold(sourceElement)
                        .moveToElement(targetElements.get(i - 1))
                        .release()
                        .build()
                        .perform();
                break;
            }
        }
    }

    public String getMethodByName() {
        return new Throwable().getStackTrace()[1].getMethodName();
    }

    public void takeSnapShot(String name) throws Exception{
        String fileWithPath ="target/Screenshots/"+name+"_"+System.currentTimeMillis()+".png";
        TakesScreenshot scrShot =((TakesScreenshot)DriverFactory.getDriver());
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void verifyTextPresentInTheElement(WebElement element,String text, int timeoutInSeconds) {
        // Implementation for waiting for an element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(driver -> element.isDisplayed());
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed as expected.");
        Assert.assertTrue(element.getText().contains(text), text+" is not displayed as expected.");
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }


}

