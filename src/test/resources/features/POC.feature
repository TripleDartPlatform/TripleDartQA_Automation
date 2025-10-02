Feature: POC Feature

#  Background: I setup the environment
#    Given I setup the environment and launch the site with the following details:
#      | chrome | https://app.slatehq.ai/ws/114/workflows |

  @SmokeTest
  Scenario Outline: Create new Datasource Validation
    Given I login to the slate page with username as <email> and password as <password>
    Then I navigate to the workflow page
    And I click on workflow titled <workflowTitle>
    And I drag and drop the <dataSource> element to the canvas
    And I click on the <configureStep> element located in the <position> of the <dataSource> element
    Then I enter the search term as <searchTerm>
    And I click on the Test button
    And I wait for the results to load
    Examples:
      | email                   | password            | workflowTitle     | configureStep  | dataSource    |  | searchTerm      | position |
      | "kamesh25491@gmail.com" | "HighPerformance@1" | "DragAndDropTest" | Configure Step | Google Search |  | Test Automation | 1        |

  @SmokeTests
  Scenario Outline: Multiple Datasource Validation
    Given I login to the slate page with username as <email> and password as <password>
    Then I navigate to the workflow page
    And I click on workflow titled <workflowTitle>
    And I click on the <configureStep> element located in the <position> of the <dataSource> element
    Then I enter the search term as <searchTerm>
    And I click on the Test button
    And I wait for the results to load
    Examples:
      | email                   | password            | workflowTitle         | configureStep  | dataSource    | position | searchTerm |  |
      | "kamesh25491@gmail.com" | "HighPerformance@1" | "Multiple Components" | Configure Step | Google Search | 2        | Test Slate |  |

    @LoggerTest
      Scenario Outline: Logger Validation
      Given I login to the slate page with username as <email> and password as <password>
      Then I navigate to the workflow page

      Examples:
        | email                   | password            |  |  |  |  |  |  |
        | "kamesh25491@gmail.com" | "HighPerformance@1" |  |  |  |  |  |  |

      @Logout
      Scenario Outline: Logout Validation
        Given I login to the slate page with username as <email> and password as <password>
        Then I navigate to the workflow page
        And I logout from the application
  #        And I login to the slate page with username as <email> and password as <password>

        Examples:
          | email                   | password            |  |  |  |  |  |  |
          | "kamesh25491@gmail.com" | "HighPerformance@1" |  |  |  |  |  |  |

