package ui;

import business.action.WidgetActions;
import business.pages.WidgetPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static core.utilities.ActionsUtils.dragAndDrop;
import static core.utilities.ActionsUtils.resizeElement;
import static org.testng.AssertJUnit.assertEquals;

public class WidgetTest extends BaseTest {

  @Test
  public void testAddWidget() {
    performLogin();

    WidgetActions widgetActions = new WidgetActions(new WidgetPage(driver));
    widgetActions.addWidget("New Widget");

    assertEquals(widgetActions.getWidgetName(), "New Widget");
  }

  @Test
  public void testMoveWidget() {
    performLogin();

    WidgetActions widgetActions = new WidgetActions(new WidgetPage(driver));
    WebElement widget = widgetActions.getWidgetElement();
    WebElement newLocation = widgetActions.getDropArea();

    dragAndDrop(driver, widget, newLocation);
  }

  @Test
  public void testResizeWidget() {
    performLogin();

    WidgetActions widgetActions = new WidgetActions(new WidgetPage(driver));
    WebElement widget = widgetActions.getWidgetElement();

    resizeElement(driver, widget, 50, 20);
  }
}
