Feature: Get URL From Sitemap Component WorkFlow Feature

  @CreateNewGetURLFromSitemapWorkFlowAndPublish
  Scenario Outline: Create a new Web Scrape Component Workflow and Publish
#    Given I login to the slate page with username as <email> and password as <password>
    Then I navigate to the workflow page
    Then I click on the Create New Workflow button
    And I click on the <configureStep> element located in the <position> of the <dataSource> element
    Then I click on add field button
    And I click on single line text type button
    And I enter the label name as <labelName>
    And I enter the variable name as <variableName>
    And I enter the default value as <defaultValue>
    And I enter the placeholder value as <placeholderValue>
    And I enter the helptext value as <helptextValue>
    And I click on required field button
    And I scroll to Test Input tab and click on it
    And I click on the Save Inputs button
    And I drag and drop the <dataSource1> element to the canvas
    And I click on the <configureStep> element located in the <position> of the <dataSource1> element
    And I click on Sitemap URL input field
    And I click on curly braces inside input field
    And I expand Input in the Insert Variable modal
    And I select the <variableName> variable from the list
    And I click and enter <maxLinks> in the Max Links input field
    And I click on the Test button
    And I click on the Test button
    And I wait for the results to load
    Then I click on the Publish button with <workflowName> and <workflowDescription>
    And I verify the workflow is published successfully with <workflowName> and validate the <status>
#    And I logout from the application
    Examples:
      | email                   | password            | labelName | configureStep  | variableName | placeholderValue | helptextValue | dataSource1           | defaultValue                      | dataSource | workflowName         | position | workflowDescription       | status  | maxLinks |  |  |  |
      | "kamesh25491@gmail.com" | "HighPerformance@1" | KeyLBL    | Configure Step | testlbl      | KeyName          | HelpKeyTest   | Get URLs from Sitemap | https://www.bing.com/search?q=GIT | Input      | Get URL From Sitemap | 1        | Get URL From Sitemap Test | Version | 5        |  |  |  |
