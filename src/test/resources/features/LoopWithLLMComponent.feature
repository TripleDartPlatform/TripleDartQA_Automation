Feature: Loop With LLM Component WorkFlow Feature

  @CreateNewLoopWithLLMWorkFlowAndPublish @Test
  Scenario Outline: Create a new Loop With LLM Component Workflow and Publish
    Given I login to the slate page with username as <email> and password as <password>
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
    And I click on search query input field
    And I click on curly braces inside input field
    And I expand Input in the Insert Variable modal
    And I select the <variableName> variable from the list
    And I Close the Google Search Configuration modal
    And I drag and drop the <secondDataSource> element to the canvas located in the <secondPosition>
    And I click on Fit To View in minimap
    And I click on the <configureStep> element located in the <position> of the <secondDataSource> element
    And I click and enter the <items> in Item input field
    And I Close the Loop Configuration modal
    And I drag and drop the <thirdDataSource> element to the canvas located in the <thirdPosition>
    And I click on Fit To View in minimap
    And I click on the <configureStep> element located in the <position> of the <thirdDataSource> element
    And I click and enter the <userMessage> in User Message input field
    And I click on curly braces inside input field
    And I expand the <secondDataSource> in the Insert Variable modal
    And I select the <loopVariable> variable from the list
    And I click on the Test button
    And I wait for the results to load
    Then I click on the Publish button with <workflowName> and <workflowDescription>
    And I verify the workflow is published successfully with <workflowName> and validate the <status>
    Examples:
      | email                   | password            | labelName | configureStep  | variableName | placeholderValue | helptextValue | dataSource1   | defaultValue         | dataSource | workflowName | position | workflowDescription | status  | secondDataSource | secondPosition | items                 | thirdDataSource | thirdPosition | userMessage                                          | loopVariable | endDataSource |
      | "kamesh25491@gmail.com" | "HighPerformance@1" | TestLBL   | Configure Step | testlbl      | PlaceHolderName  | HelpTest      | Google Search | what is crm software | Input      | LoopWithLLM  | 1        | LoopWithLLM Test    | Version | Loop             | 2              | step_1.output.organic | LLM             | 3             | Extract only the Title from given Google step result | element      | End           |

