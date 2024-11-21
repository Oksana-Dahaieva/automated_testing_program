Feature: Login to Report Portal

  @smoke
  Scenario: Valid login to the dashboard
    Given I open the Report Portal login page
    When I log in with valid credentials
    Then I should see the dashboard
