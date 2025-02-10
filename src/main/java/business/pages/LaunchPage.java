package business.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.configuration.ConfigManager.getProperty;

public class LaunchPage extends BasePage {

  public LaunchPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//div[contains(@class,'sortable')]//span")
  private List<WebElement> sortElements;

  @FindBy(xpath = "//div[contains(@class,'sortable')]//span")
  private List<WebElement> launchElements;

  public void openPage() {
    driver.get(getProperty("launchUrl"));
  }

  public List<WebElement> getSortElements() {
    return sortElements;
  }

  public void clickSortElement(WebElement element) {
    element.click();
  }

  public List<WebElement> getLaunchElements() {
    return launchElements;
  }
}
