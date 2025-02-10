package core.utilities;

import core.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtils {

  private static final String SCREENSHOT_PATH = "target/screenshots/";

  public static void captureScreenshot(WebDriver driver, String testName) {
    try {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      Path destination = Paths.get(SCREENSHOT_PATH + testName + ".png");
      Files.createDirectories(destination.getParent());
      Files.copy(screenshot.toPath(), destination);
      Log.info("Screenshot saved: " + destination.toAbsolutePath());
    } catch (Exception e) {
      Log.error("Failed to capture screenshot", e);
    }
  }
}
