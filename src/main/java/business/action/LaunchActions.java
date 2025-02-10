package business.action;

import business.pages.LaunchPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaunchActions {

  private final LaunchPage launchPage;

  public LaunchActions(LaunchPage launchPage) {
    this.launchPage = launchPage;
  }

  public void openLaunchPage() {
    launchPage.openPage();
  }

  public void sortLaunchesByOption(String sortOption) {
    List<WebElement> sortElements = launchPage.getSortElements();
    for (WebElement element : sortElements) {
      if (element.getText().equalsIgnoreCase(sortOption)) {
        launchPage.clickSortElement(element);
        return;
      }
    }
    throw new IllegalArgumentException("Sort option not found: " + sortOption);
  }

  public List<WebElement> getLaunchElements() {
    return launchPage.getLaunchElements();
  }
}
