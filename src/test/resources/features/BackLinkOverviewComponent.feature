Feature: Backlink Overview Component WorkFlow Feature

  @CreateNewBacklinkOverviewWorkFlowAndPublish @RegressionTest
  Scenario Outline: Create a new Backlink Overview Component Workflow and Publish
    When I navigate to the workflow page
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
    And I click on Backlink Overview query input field
    And I click on curly braces inside input field
    And I expand Input in the Insert Variable modal
    And I select the <variableName> variable from the list
    And I click on the Test button
    #And I click on the Test button
    And I wait for the results to load
    Then I click on the Publish button with <workflowName> and <workflowDescription>
    And I verify the workflow is published successfully with <workflowName> and validate the <status>
    Examples:
      |  |  | labelName | configureStep  | variableName | placeholderValue | helptextValue | dataSource1       | defaultValue    | dataSource | workflowName      | position | workflowDescription    | status  |  |
      |  |  | TestLBL   | Configure Step | testlbl      | PlaceHolderName  | HelpTest      | Backlink Overview | Test Automation | Input      | Backlink Overview | 1        | Backlink Overview Test | Version |  |

