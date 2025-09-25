package stepdefinitions;


import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import pageObjects.Settings.BrandKit.BrandKitSettingsPage;
import pageObjects.WorkFlows.WorkFlowsPage;

public class BrandKitSettingsSteps {
    BrandKitSettingsPage brandKitSettingsPage = new BrandKitSettingsPage(DriverFactory.getDriver());

    @When("I navigate to the Settings page")
    public void iNavigateToTheSettingsPage() {
        brandKitSettingsPage.navigateToSettingsPage();
    }

    @Then("I click on the BrandKit tab")
    public void iClickOnTheBrandKitTab() {
        brandKitSettingsPage.clickOnBrandKitTab();
    }

    @And("I click on the Edit Brand Kit button")
    public void iClickOnTheEditBrandKitButton() {
        brandKitSettingsPage.clickOnEditBrandKitButton();
    }

    @And("I enter the Brand kit name as {}")
    public void iEnterTheBrandKitNameAs(String brandKitName) {
        brandKitSettingsPage.enterBrandKitName(brandKitName);
    }

    @And("I enter Brand URL as {}")
    public void iEnterBrandURLAs(String brandURL) {
        brandKitSettingsPage.enterBrandURL(brandURL);
    }

    @And("I enter the Brand kit description as {}")
    public void iEnterTheBrandKitDescriptionAs(String brandKitDescription) {
        brandKitSettingsPage.enterBrandKitDescription(brandKitDescription);
    }

    @And("I enter Ideal customer profile as {}")
    public void iEnterIdealCustomerProfileAs(String customerProfile) {
        brandKitSettingsPage.enterIdealCustomerProfile(customerProfile);
    }

    @And("I expand Writing Style section")
    public void iExpandWritingStyleSection() {
        brandKitSettingsPage.expandWritingStyleSection();
    }

    @And("I enter the Author personal as {}")
    public void iEnterTheAuthorPersonalAs(String authorPersonal) {
        brandKitSettingsPage.enterAuthorPersonal(authorPersonal);
    }

    @And("I enter CTA text as {}")
    public void iEnterCTATextAs(String CTAText) {
        brandKitSettingsPage.enterCTAText(CTAText);
    }

    @And("I enter the CTA destination URL as {}")
    public void iEnterTheCTADestinationURLAs(String CTADestinationURL) {
        brandKitSettingsPage.enterCTADestinationURL(CTADestinationURL);
    }

    @And("I expand Writing Sample section")
    public void iExpandWritingSampleSection() {
        brandKitSettingsPage.expandWritingSampleSection();
    }

    @And("I enter Sample outline as {}")
    public void iEnterSampleOutlineAs(String sampleOutline) {
        brandKitSettingsPage.enterSampleOutline(sampleOutline);
    }

    @And("I enter the Sample URL as {}")
    public void iEnterTheSampleURLAs(String sampleURL) {
        brandKitSettingsPage.enterSampleURL(sampleURL);
    }

    @And("I expand Competitors section")
    public void iExpandCompetitorsSection() {
        brandKitSettingsPage.expandCompetitorsSection();
    }

    @And("I click on the Save Brand Kit button")
    public void iClickOnTheSaveBrandKitButton() {
        brandKitSettingsPage.clickOnSaveBrandKitButton();
    }

    @And("I verify the Brand Kit is created successfully with {}")
    public void iVerifyTheBrandKitIsCreatedSuccessfullyWith(String brandKitName) {
        brandKitSettingsPage.verifyBrandKitIsCreated(brandKitName);
    }

    @And("I enter Competitor names {} and Competitor URLs as {}")
    public void iEnterCompetitorNamesAndCompetitorURLsAs(String competitorNames, String competitorURLs) {
        brandKitSettingsPage.enterCompetitorNamesAndURLs(competitorNames, competitorURLs);
    }
}
