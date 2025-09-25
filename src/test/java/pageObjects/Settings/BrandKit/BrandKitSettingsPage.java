package pageObjects.Settings.BrandKit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BrandKitSettingsPage {
    WebDriver driver;

    public BrandKitSettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToSettingsPage() { }

    public void clickOnBrandKitTab() { }

    public void clickOnEditBrandKitButton() { }

    public void enterBrandKitName(String brandKitName) { }

    public void enterBrandURL(String brandURL) { }

    public void enterBrandKitDescription(String brandKitDescription) { }

    public void enterIdealCustomerProfile(String customerProfile) { }

    public void expandWritingStyleSection() { }

    public void enterAuthorPersonal(String authorPersonal) { }

    public void enterCTAText(String CTAText) { }

    public void enterCTADestinationURL(String CTADestinationURL) { }

    public void expandWritingSampleSection() { }

    public void enterSampleOutline(String sampleOutline) { }

    public void enterSampleURL(String sampleURL) { }

    public void expandCompetitorsSection() { }

    public void clickOnSaveBrandKitButton() { }

    public void verifyBrandKitIsCreated(String brandKitName) { }

    public void enterCompetitorNamesAndURLs(String competitorNames, String competitorURLs) { }
}
