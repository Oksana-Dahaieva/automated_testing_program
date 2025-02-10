package ui;

import business.action.LaunchActions;
import business.pages.LaunchPage;
import dataproviders.LaunchDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static core.utilities.ScreenshotUtils.captureScreenshot;
import static core.utilities.WaitUtils.clickUsingJS;
import static core.utilities.WaitUtils.scrollToElement;
import static org.testng.Assert.assertFalse;

public class LaunchTest extends BaseTest {

  @Test(dataProvider = "sortingCriteria", dataProviderClass = LaunchDataProvider.class)
  public void testLaunchSorting(String sortOption) {
    performLogin();

    LaunchPage launchPage = new LaunchPage(driver);
    LaunchActions launchActions = new LaunchActions(launchPage);

    launchActions.openLaunchPage();
    launchActions.sortLaunchesByOption(sortOption);

  }

  @Test
  public void testLaunchSorting() {
    performLogin();

    LaunchPage launchPage = new LaunchPage(driver);
    LaunchActions launchActions = new LaunchActions(launchPage);

    List<WebElement> sortOptions = launchActions.getLaunchElements();
    assertFalse(sortOptions.isEmpty(), "Sorting options not found!");

    scrollToElement(driver, sortOptions.get(0));
    clickUsingJS(driver, sortOptions.get(0));

    captureScreenshot(driver, "LaunchSortingTest");
  }
}
