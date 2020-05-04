Feature: HomePage
  Scenario: HomePage verification
    Given Open the Home Page
    When The landing page is verified
    Then Search for Links: Browse by Make, Browse by Style, Advanced Search

  Scenario: Verifying count of Results
      Given Open the Home Page
      When Fill the Advanced Search form
      Then verify the count of Results
