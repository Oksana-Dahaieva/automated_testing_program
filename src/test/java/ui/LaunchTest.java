package ui;

import business.action.LaunchActions;
import business.pages.LaunchPage;
import dataproviders.LaunchDataProvider;
import org.testng.annotations.Test;

public class LaunchTest extends BaseTest {

  @Test(dataProvider = "sortingCriteria", dataProviderClass = LaunchDataProvider.class)
  public void testLaunchSorting(String sortOption) {
    performLogin();

    LaunchPage launchPage = new LaunchPage(driver);
    LaunchActions launchActions = new LaunchActions(launchPage);

    launchActions.openLaunchPage();
    launchActions.sortLaunchesByOption(sortOption);

  }
}
