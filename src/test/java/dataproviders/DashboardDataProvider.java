package dataproviders;

import org.testng.annotations.DataProvider;

public class DashboardDataProvider {

  @DataProvider(name = "createDashboard")
  public Object[][] createDashboard() {
    return new Object[][] {{"Dashboard1", "Description for Dashboard1"},
        {"Dashboard2", "Description for Dashboard2"}, {"Dashboard3", "Description for Dashboard3"}};
  }
}
