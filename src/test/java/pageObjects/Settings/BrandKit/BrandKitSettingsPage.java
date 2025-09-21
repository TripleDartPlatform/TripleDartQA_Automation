package pageObjects.Settings.BrandKit;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.time.Duration;

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
}
