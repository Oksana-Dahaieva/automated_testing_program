package business.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void waitVisibilityOfElement(long timeToWait, WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitElementToBeClickable(long timeToWait, WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void waitForPageLoadComplete(long timeToWait) {
    new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
        webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState")
            .equals("complete"));
  }
}
