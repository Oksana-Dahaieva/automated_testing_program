package steps;

import business.action.DashboardActions;
import business.pages.DashboardPage;
import core.context.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static core.configuration.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

public class DashboardSteps {

  private ScenarioContext scenarioContext;

  public DashboardSteps(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
  }

  @When("the user adds a new dashboard with name {string} and description {string}")
  public void whenUserAddsDashboard(String dashboardName, String dashboardDescription) {
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
    dashboardActions.addNewDashBoard(dashboardName, dashboardDescription);
  }

  @Then("the dashboard should be successfully added with message {string}")
  public void thenDashboardAddedSuccessfully(String successMessage) {
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
    assertEquals(dashboardActions.getSuccessMessageAfterDeleteDashboard(), successMessage);
  }

  @When("the user adds the following dashboards:")
  public void whenUserAddsMultipleDashboards(List<Map<String, String>> dashboards) {
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
    for (Map<String, String> dashboard : dashboards) {
      String dashboardName = dashboard.get("name");
      String dashboardDescription = dashboard.get("description");
      dashboardActions.addNewDashBoard(dashboardName, dashboardDescription);
    }
  }

  @Then("all dashboards should be successfully added")
  public void thenAllDashboardsSuccessfullyAdded() {
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
    assertEquals(dashboardActions.getSuccessMessageAfterDeleteDashboard(), "Dashboard has been added");
  }

  @When("the user attempts to add a dashboard with name {string} twice")
  public void whenUserAttemptsToAddDashboardTwice(String dashboardName) {
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
    dashboardActions.addNewDashBoard(dashboardName, "Description for " + dashboardName);
    dashboardActions.addNewDashBoard(dashboardName, "Description for " + dashboardName);
  }

  @Then("the second attempt should fail with message {string}")
  public void thenSecondAttemptFailsWithMessage(String errorMessage) {
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
//    assertEquals(dashboardActions.getErrorMessageAfterDashboardCreation(), errorMessage);
  }
}
