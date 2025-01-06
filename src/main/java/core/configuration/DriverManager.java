package core.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      ChromeOptions options = new ChromeOptions();

      boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

      if (isHeadless) {
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--remote-debugging-port=9222");
      } else {
        options.addArguments("--start-maximized");
      }

      driver.set(new ChromeDriver(options));
    }
    return driver.get();
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
