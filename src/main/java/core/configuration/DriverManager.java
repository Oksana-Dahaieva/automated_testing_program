package core.configuration;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");
      if (ConfigManager.getProperty("useSelenide").equals("true")) {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 5000;
      } else {
        driver.set(new ChromeDriver(options));
      }
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
