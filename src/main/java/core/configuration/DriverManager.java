package core.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--headless");
      options.addArguments("--remote-debugging-port=9222");

      driver = new ChromeDriver(options);

      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
