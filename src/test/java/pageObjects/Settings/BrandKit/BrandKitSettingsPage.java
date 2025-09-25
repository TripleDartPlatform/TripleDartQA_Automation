package pageObjects.Settings.BrandKit;

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
import java.util.List;

public class BrandKitSettingsPage {
    WebDriver driver;
    CommonUtils utils;

    public BrandKitSettingsPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(120));

    @FindBy(how = How.XPATH, using = "//a//span[text()='Settings']")
    private WebElement menu_Settings;

    @FindBy(how = How.XPATH, using = "//a[text()='Brand Kit']")
    private WebElement submenu_BrandKit;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='Edit brand kit']")
    private WebElement btn_EditBrandKit;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'brand kit name')]")
    private WebElement txtBox_BrandKitName;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'example.com')]")
    private WebElement txtBox_BrandKitURL;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'Description')]")
    private WebElement txtArea_BrandKitDescription;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'customer profile')]")
    private WebElement txtArea_CustomerProfile;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Writing Style')]")
    private WebElement dropdown_WritingStyle;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'Author ')]")
    private WebElement txtArea_Author;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Call to action')]")
    private WebElement txtBox_CallToActionText;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'call-to-action-url')]")
    private WebElement txtBox_CallToActionURL;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Writing Sample')]")
    private WebElement dropdown_WritingSample;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'writing sample')]")
    private WebElement txtArea_SampleOutline;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Add a link')]")
    private WebElement txtBox_SampleURL;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Competitors')]")
    private WebElement dropdown_Competitors;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'name of your competitor')]")
    private List<WebElement> txtBox_CompetitorNames;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'URL here')]")
    private List<WebElement> txtBox_CompetitorURLs;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Competitor')]")
    private WebElement btn_AddCompetitor;



    //Add a new competitor input box for each competitor

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Save Brand Kit')]")
    private WebElement btn_SaveBrandKit;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel')]")
    private WebElement btn_CancelBrandKit;

    //=======================================================================================



    public void navigateToSettingsPage() {
        try {
            utils.clickElement(menu_Settings, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnBrandKitTab() {
        try {
            utils.clickElement(submenu_BrandKit, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnEditBrandKitButton() {
        try {
            utils.clickElement(btn_EditBrandKit, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterBrandKitName(String brandKitName) {
        try {
            utils.enterText(txtBox_BrandKitName, brandKitName, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterBrandURL(String brandURL) {
        try {
            utils.enterText(txtBox_BrandKitURL, brandURL, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterBrandKitDescription(String brandKitDescription) {
        try {
            utils.enterText(txtArea_BrandKitDescription, brandKitDescription, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterIdealCustomerProfile(String customerProfile) {
        try {
            utils.enterText(txtArea_CustomerProfile, customerProfile, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void expandWritingStyleSection() {
        try {
            utils.clickElement(dropdown_WritingStyle, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterAuthorPersonal(String authorPersonal) {
        try {
            utils.enterText(txtArea_Author, authorPersonal, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterCTAText(String CTAText) {
        try {
            utils.enterText(txtBox_CallToActionText, CTAText, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterCTADestinationURL(String CTADestinationURL) {
        try {
            utils.enterText(txtBox_CallToActionURL, CTADestinationURL, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void expandWritingSampleSection() {
        try {
            utils.clickElement(dropdown_WritingSample, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterSampleOutline(String sampleOutline) {
        try {
            utils.enterText(txtArea_SampleOutline, sampleOutline, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterSampleURL(String sampleURL) {
        try {
            utils.enterText(txtBox_SampleURL, sampleURL, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void expandCompetitorsSection() {
        try {
            utils.clickElement(dropdown_Competitors, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterCompetitorNamesAndURLs(String competitorNames, String competitorURLs) {
        try {
            String[] names = competitorNames.split(";");
            String[] urls = competitorURLs.split(";");
            for (int i = 0; i < names.length; i++) {
                utils.scrollToElement(txtBox_CompetitorNames.get(i));
                utils.enterText(txtBox_CompetitorNames.get(i), names[i], 10);
                utils.enterText(txtBox_CompetitorURLs.get(i), urls[i], 10);
                if (i < names.length - 1) { // Avoid clicking "Add Competitor" after the last entry
                    utils.clickElement(btn_AddCompetitor, 10);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            //utils.takeSnapShot(hooks.Hooks.scenarioName);
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickOnSaveBrandKitButton() {
        try {
            utils.clickElement(btn_SaveBrandKit, 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void verifyBrandKitIsCreated(String brandKitName) {
        try {
            utils.isElementDisplayed(driver.findElement(By.xpath("//div[contains(text(),'" + brandKitName + "')]")), 10);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
