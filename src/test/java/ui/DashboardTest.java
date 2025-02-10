package ui;

import business.action.DashboardActions;
import business.pages.DashboardPage;
import dataproviders.DashboardDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DashboardTest extends BaseTest{

  @Test(dataProvider = "createDashboard", dataProviderClass = DashboardDataProvider.class)
  public void testCreateDashboard(String dashboardName, String dashboardDescription) {
    performLogin();

    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
    dashboardActions.addNewDashBoard(dashboardName, dashboardDescription);
    assertEquals(dashboardActions.getSuccessMessageAfterDeleteDashboard(),
        "Dashboard has been added");
  }

  @Test
  public void testCreateDashboard() {
    performLogin();

    DashboardActions dashboardActions = new DashboardActions(new DashboardPage(driver));
    dashboardActions.addNewDashBoard("New Dashboard", "Description");

    assertEquals(dashboardActions.getDashboardTitle(), "NEW DASHBOARD");
  }
}
