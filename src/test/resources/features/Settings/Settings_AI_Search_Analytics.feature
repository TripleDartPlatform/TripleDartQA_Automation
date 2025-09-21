Feature: Setting Brand Kit Feature

  @CreateNewBrandKitWorkFlowAndVerify @RegressionTest
  Scenario Outline: Create a new Brand Kit and Verify
    When I navigate to the Settings page
    Then I click on the BrandKit tab
    And I click on the Edit Brand Kit button
    And I enter the Brand kit name as <BrandKitName>
    And I enter Brand URL as <BrandURL>
    And I enter the Brand kit description as <BrandKitDescription>
    And I enter Ideal customer profile as <CustomerProfile>
    And I expand Writing Style section
    And I enter the Author personal as <Authorpersonal>
    And I enter CTA text as <CTAtext>
    And I enter the CTA destination URL as <CTAdestinationURL>
    And I expand Writing Sample section
    And I enter Sample outline as <Sampleoutline>
    And I enter the Sample URL as <SampleURL>
    And I expand Competitiors section
    And I enter Competitor name as <Competitor1> and Competitor URL as <Competitor1URL>
    And I click on Add Competitor button
    And I enter Competitor name as <Competitor2> and Competitor URL as <Competitor2URL>
    And I click on Add Competitor button
    And I enter Competitor name as <Competitor3> and Competitor URL as <Competitor3URL>
    And I click on the Save Brand Kit button
    And I verify the Brand Kit is created successfully with <BrandKitName>

    Examples:
      | BrandKitName | BrandURL                 | BrandKitDescription      | CustomerProfile | Authorpersonal | CTAtext               | CTAdestinationURL        | Sampleoutline  | SampleURL                | Competitor1 | Competitor2 | Competitor3 | Competitor1URL          | Competitor2URL           | Competitor3URL         |
      | Allbirds     | https://www.allbirds.com | Super comfy casual shoes | Footwear        | AllBirdsAuthor | Buy Now Wear Anywhere | https://www.allbirds.com | Sample Outline | https://www.allbirds.com | Nike        | Adidas      | PUMA        | https://www.nike.com/in | https://www.adidas.co.in | https://in.puma.com/in |
