package core.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

  public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
    new Actions(driver).dragAndDrop(source, target).perform();
  }

  public static void resizeElement(WebDriver driver, WebElement element, int xOffset, int yOffset) {
    new Actions(driver).clickAndHold(element).moveByOffset(xOffset, yOffset).release().perform();
  }
}
