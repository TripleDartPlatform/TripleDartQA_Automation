package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import pageObjects.*;

public class WorkFlowsSteps {

    WorkFlowsPage workFlowsPage = new WorkFlowsPage(DriverFactory.getDriver());
    GoogleSearchConfigPage googleSearchConfigSteps= new GoogleSearchConfigPage(DriverFactory.getDriver());
    InputConfigPage inputConfigPage = new InputConfigPage(DriverFactory.getDriver());
    FindRelatedKeywordConfigPage findRelatedKeywordConfigPage = new FindRelatedKeywordConfigPage(DriverFactory.getDriver());
    DomainOverviewConfigPage domainOverviewConfigPage = new DomainOverviewConfigPage(DriverFactory.getDriver());
    BacklinkOverviewConfigPage backlinkOverviewConfigPage = new BacklinkOverviewConfigPage(DriverFactory.getDriver());
    HumanReviewConfigPage humanReviewConfigPage = new HumanReviewConfigPage(DriverFactory.getDriver());
    TextConfigPage textConfigPage = new TextConfigPage(DriverFactory.getDriver());
    ConvertToJsonConfigPage convertToJsonConfigPage = new ConvertToJsonConfigPage(DriverFactory.getDriver());
    ConvertToHtmlConfigPage convertToHtmlConfigPage = new ConvertToHtmlConfigPage(DriverFactory.getDriver());
    CallToAPIConfigPage callToAPIConfigPage = new CallToAPIConfigPage(DriverFactory.getDriver());
    WebScrapeConfigPage webScrapeConfigPage = new WebScrapeConfigPage(DriverFactory.getDriver());
    GetURLFromSiteMapConfigPage getURLFromSiteMapConfigPage = new GetURLFromSiteMapConfigPage(DriverFactory.getDriver());
    LoopWithLLMConfigPage loopWithLLMConfigPage = new LoopWithLLMConfigPage(DriverFactory.getDriver());
    
    @Then("I navigate to the workflow page")
    public void iNavigateToTheWorkflowPage() {
        workFlowsPage.navigateToWorkflowsPage();
    }

    @And("I click on workflow titled {string}")
    public void iClickOnWorkflowTitled(String workflowTitle) throws InterruptedException {
        workFlowsPage.clickOnWorkflow(workflowTitle);
        Thread.sleep(2000); // Wait for 2 seconds to ensure the page loads completely
    }

    @Then("I drag and drop the {} element to the canvas")
    public void iDragAndDropTheElementToTheCanvas(String componentName) throws InterruptedException {
        workFlowsPage.dragAndDropTheComponentIntoCanvas(componentName);
    }

    @And("I drag and drop the {} element to the canvas located in the {}")
    public void iDragAndDropTheElementToTheCanvasLocatedInThe(String componentName, String position) throws InterruptedException{
        workFlowsPage.dragAndDropTheComponentIntoCanvasBasedOnPosition(componentName, position);
    }

    @And("I click on the {} element located in the {} of the {} element")
    public void iClickOnTheElementLocatedInTheOfTheElement(String configureStep, String position, String dataSource) {
        workFlowsPage.clickOnConfigStepBasedOnPositionInCanvas(configureStep, position, dataSource);
    }

    @Then("I enter the search term as {}")
    public void iEnterTheSearchTermAs(String searchParam) {
        workFlowsPage.enterSearchTerm(searchParam);
    }

    @And("I click on the Test button")
    public void iClickOnTheTestButton() {
        workFlowsPage.clickOnTestButton();
    }

    @And("I wait for the results to load")
    public void iWaitForTheResultsToLoad() {
        workFlowsPage.validateTestResultsAreLoaded();
    }

    @Then("I click on the Create New Workflow button")
    public void iClickOnTheCreateNewWorkflowButton() { workFlowsPage.clickOnTheCreateNewWorkflowButton();  }

    @Then("I click on add field button")
    public void iClickOnAddFieldButton() {
        inputConfigPage.clickOnAddFieldButton();
    }

    @And("I click on single line text type button")
    public void iClickOnSingleLineTextTypeButton() {
        inputConfigPage.clickOnSingleLineTextTypeButton();
    }

    @And("I enter the label name as {}")
    public void iEnterTheLabelNameAs(String labelName) {
        inputConfigPage.enterLabelName(labelName);
    }

    @And("I enter the variable name as {}")
    public void iEnterTheVariableNameAs(String variableName) {
        inputConfigPage.enterVariableName(variableName);
    }

    @And("I enter the default value as {}")
    public void iEnterTheDefaultValueAs(String defaultValue) {
        inputConfigPage.enterDefaultValue(defaultValue);
    }

    @And("I enter the placeholder value as {}")
    public void iEnterThePlaceholderValueAs(String placeholderValue) {
        inputConfigPage.enterPlaceholderValue(placeholderValue);
    }

    @And("I enter the helptext value as {}")
    public void iEnterTheHelptextValueAs(String helptextValue) {
        inputConfigPage.enterHelptextValue(helptextValue);
    }

    @And("I click on required field button")
    public void iClickOnRequiredFieldButton() {
        inputConfigPage.clickOnRequiredFieldButton();
    }

    @And("I scroll to Test Input tab and click on it")
    public void iScrollToTestInputTab() {
        inputConfigPage.scrollToTestInputTabAndClick();
    }

    @And("I click on the Save Inputs button")
    public void iClickOnTheSaveInputsButton() {
        inputConfigPage.clickOnSaveInputsButton();
    }

    @And("I click on search query input field")
    public void iClickOnSearchQueryInputField() {
        googleSearchConfigSteps.clickOnSearchQueryInputField();
    }

    @And("I click on curly braces inside input field")
    public void iClickOnCurlyBracesInsideInputField() {
        googleSearchConfigSteps.clickOnCurlyBracesInsideInputField();
    }

    @And("I expand Input in the Insert Variable modal")
    public void iExpandInputInTheInsertVariableModal() {
        googleSearchConfigSteps.expandInputInInsertVariableModal();
    }

    @And("I select the {} variable from the list")
    public void iSelectTheVariableFromTheList(String variableName) {
        googleSearchConfigSteps.selectVariable(variableName);
    }

    @Then("I click on the Publish button with {} and {}")
    public void iClickOnThePublishButtonWithAnd(String workFlowName, String workFlowDescription) {
        workFlowsPage.enterWorkFlowNameAndDescription(workFlowName, workFlowDescription);
    }

    @And("I verify the workflow is published successfully with {} and validate the {}")
    public void iVerifyTheWorkflowIsPublishedSuccessfullyWithAndValidateThe(String workFlowName, String status) {
        workFlowsPage.validateWorkFlowPublished(workFlowName,status);
    }

    @And("I click on keyword query input field")
    public void iClickOnKeywordQueryInputField() {
        findRelatedKeywordConfigPage.clickOnKeywordQueryInputField();
    }

    @And("I click on Domain Overview query input field")
    public void iClickOnDomainOverviewQueryInputField() {
        domainOverviewConfigPage.clickOnDomainOverviewQueryInputField();
    }

    @And("I click on Backlink Overview query input field")
    public void iClickOnBacklinkOverviewQueryInputField() {
        backlinkOverviewConfigPage.clickOnBacklinkOverviewQueryInputField();
    }

    @And("I click on Human Review Title input field")
    public void iClickOnHumanReviewTitleInputField() {
        humanReviewConfigPage.clickOnHumanReviewTitleInputField();
    }

    @And("I click on Human Review Instructions input field")
    public void iClickOnHumanReviewInstructionsInputField() {
        humanReviewConfigPage.clickOnReviewContentInstructionsInputField();
    }

    @And("I click on Human Review Value to Review input field")
    public void iClickOnHumanReviewValueToReviewInputField() {
        humanReviewConfigPage.clickOnReviewContentValueToReviewInputField();
    }

    @And("I enter the search variable {} in the input field")
    public void iEnterTheSearchVariableInTheInputField(String searchVariable) {
        humanReviewConfigPage.clickOnSearchVariablesInputField(searchVariable);
    }

    @And("I wait for the results to load in Human Review Test Result")
    public void iWaitForTheResultsToLoadInHumanReviewTestResult() {
        humanReviewConfigPage.validateTestResultsAreLoaded();
    }

    @And("I click on Liquid Text Area input field")
    public void iClickOnLiquidTextAreaInputField() {
        textConfigPage.clickOnLiquidTextAreaInputField();
    }

    @And("I click on Key input field")
    public void iClickOnKeyInputField() {
        convertToJsonConfigPage.clickOnKeyInputField();
    }

    @And("I click on Value input field")
    public void iClickOnValueInputField() {
        convertToJsonConfigPage.clickOnValueInputField();
    }

    @And("I click on Content Text Area input field")
    public void iClickOnContentTextAreaInputField() {
        convertToHtmlConfigPage.clickOnContentTextAreaInputField();
    }

    @And("I click on API endpoint URL input field")
    public void iClickOnAPIEndpointURLInputField() {
        callToAPIConfigPage.clickOnAPIEndpointURLInputField();
    }

    @And("I click on {} request method")
    public void iClickOnRequestMethod(String requestType) {
        callToAPIConfigPage.clickOnRequestMethod(requestType);
    }

    @And("I enter the request body")
    public void iEnterTheRequestBodyAsBelow() {
        callToAPIConfigPage.enterRequestBody();
    }

    @And("I click on Website URL input field")
    public void iClickOnWebsiteURLInputField() {
        webScrapeConfigPage.clickOnWebsiteURLInputField();
    }

    @And("I click on Mark down format button")
    public void iClickOnMarkDownFormatButton() {
        webScrapeConfigPage.clickOnMarkdownFormatButton();
    }

    @And("I click on Sitemap URL input field")
    public void iClickOnSitemapURLInputField() {
        getURLFromSiteMapConfigPage.clickOnSiteMapURLInputField();
    }

    @And("I click and enter {} in the Max Links input field")
    public void iClickAndEnterInTheMaxLinksInputField(String maxLimit){
        getURLFromSiteMapConfigPage.clickAndEnterMaxURLInputField(maxLimit);
    }


    @And("I Close the Google Search Configuration modal")
    public void iCloseTheGoogleSearchConfigurationModal() {
        googleSearchConfigSteps.clickOnCloseButtonInGoogleSearchConfig();
    }

    @And("I click and enter the {} in Item input field")
    public void iClickAndEnterTheInItemInputField(String items) {
        loopWithLLMConfigPage.clickAndEnterItemsOnInputField(items);
    }

    @And("I Close the Loop Configuration modal")
    public void iCloseTheLoopConfigurationModal() {
        loopWithLLMConfigPage.clickOnCloseButtonInLoopConfigButton();
    }

    @And("I expand the {} in the Insert Variable modal")
    public void iExpandTheInTheInsertVariableModal(String insertVariableName) {
        loopWithLLMConfigPage.expandTheInTheInsertVariableModal(insertVariableName);
    }

    @And("I click and enter the {} in User Message input field")
    public void iClickAndEnterTheInUserMessageInputField(String userMessage) {
        loopWithLLMConfigPage.clickAndEnterUserMessageOnInputField(userMessage);
    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @And("I scroll to the No output element in the {}")
    public void iScrollToTheNoOutputElementInThe(String component) {
        workFlowsPage.scrollToTheNoOutputElementInThe(component);
    }

    @And("I scroll to the component {}")
    public void iScrollToTheComponent(String component) {
        workFlowsPage.scrollToTheComponent(component);
    }

    @And("I click on Fit To View in minimap")
    public void ifitToViewMiniMapOnMinimap() {
        workFlowsPage.fitToViewMiniMap();
    }
}