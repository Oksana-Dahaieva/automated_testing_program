package core.utilities;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class WaitUtils {

  public static void waitForElementToBeVisible(WebDriver driver,
      WebElement element,
      int timeoutSeconds) {
    new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(
        ExpectedConditions.visibilityOf(element));
  }

  public static void waitForElementToBeClickable(WebDriver driver,
      WebElement element,
      int timeoutSeconds) {
    new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(
        ExpectedConditions.elementToBeClickable(element));
  }

  public static void fluentWaitForElement(WebDriver driver,
      WebElement element,
      int timeoutSeconds) {
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(timeoutSeconds))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(Exception.class)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitForPageLoadComplete(WebDriver driver, int timeoutSeconds) {
    new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(
        webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState")
            .equals("complete"));
  }

  public static void waitForSelenideElement(SelenideElement element) {
    element.shouldBe(visible);
  }

  public static void scrollToElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
  }

  public static void clickUsingJS(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
  }

  public static boolean isElementInView(WebDriver driver, WebElement element) {
    return (boolean) ((JavascriptExecutor) driver).executeScript(
        "var rect = arguments[0].getBoundingClientRect();" +
            "return (rect.top >= 0 && rect.left >= 0 && rect.bottom <= window.innerHeight && rect" +
            ".right <= window.innerWidth);",
        element);
  }
}
