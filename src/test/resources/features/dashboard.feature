Feature: Dashboard Management

  Background:
    Given the user is logged in

  Rule: Dashboard operations must work correctly

    Scenario Outline: Adding a new dashboard
      When the user adds a new dashboard with name "<dashboardName>" and description "<dashboardDescription>"
      Then the dashboard should be successfully added with message "Dashboard has been added"

      Examples:
        | dashboardName | dashboardDescription       |
        | Dashboard1    | Description for Dashboard1 |
        | Dashboard2    | Description for Dashboard2 |
        | Dashboard3    | Description for Dashboard3 |

    Scenario: Adding multiple dashboards using a list
      When the user adds the following dashboards:
        | name       | description                |
        | DashboardA | Description for DashboardA |
        | DashboardB | Description for DashboardB |
        | DashboardC | Description for DashboardC |
      Then all dashboards should be successfully added

    Scenario: Adding dashboards with specific rules
  Rule: Dashboard names must be unique
    When the user attempts to add a dashboard with name "DuplicateDashboard" twice
      Then the second attempt should fail with message "Dashboard name must be unique"
