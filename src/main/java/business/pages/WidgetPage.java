package business.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WidgetPage extends BasePage {

  public WidgetPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//div[contains(@class,'widget')]")
  private WebElement widgetElement;

  @FindBy(xpath = "//div[contains(@class,'drop-area')]")
  private WebElement dropArea;

  @FindBy(xpath = "//button[text()='Add Widget']")
  private WebElement addWidgetButton;

  @FindBy(xpath = "//input[@placeholder='Enter widget name']")
  private WebElement widgetNameInput;

  @FindBy(xpath = "//button[text()='Save']")
  private WebElement saveWidgetButton;

  @FindBy(xpath = "//div[contains(@class,'widget-title')]")
  private WebElement widgetTitle;

  public WebElement getWidgetElement() {
    return widgetElement;
  }

  public WebElement getDropArea() {
    return dropArea;
  }

  public WebElement getAddWidgetButton() {
    return addWidgetButton;
  }

  public WebElement getWidgetNameInput() {
    return widgetNameInput;
  }

  public WebElement getSaveWidgetButton() {
    return saveWidgetButton;
  }

  public WebElement getWidgetTitle() {
    return widgetTitle;
  }
}
