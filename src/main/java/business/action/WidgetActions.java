package business.action;

import business.pages.WidgetPage;
import org.openqa.selenium.WebElement;

public class WidgetActions {

  private final WidgetPage widgetPage;

  public WidgetActions(WidgetPage widgetPage) {
    this.widgetPage = widgetPage;
  }

  public WebElement getWidgetElement() {
    return widgetPage.getWidgetElement();
  }

  public WebElement getDropArea() {
    return widgetPage.getDropArea();
  }

  public void addWidget(String widgetName) {
    widgetPage
        .getAddWidgetButton()
        .click();
    widgetPage
        .getWidgetNameInput()
        .sendKeys(widgetName);
    widgetPage
        .getSaveWidgetButton()
        .click();
  }

  public String getWidgetName() {
    return widgetPage
        .getWidgetTitle()
        .getText();
  }
}
