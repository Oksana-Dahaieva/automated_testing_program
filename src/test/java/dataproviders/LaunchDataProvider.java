package dataproviders;

import org.testng.annotations.DataProvider;

public class LaunchDataProvider {

  @DataProvider(name = "sortingCriteria")
  public Object[][] provideSortingCriteria() {
    return new Object[][] {{"START TIME"}, {"TOTAL"}, {"PASSED"}, {"FAILED"}};
  }
}
