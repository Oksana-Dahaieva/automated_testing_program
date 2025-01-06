package business.pages;

import core.configuration.ConfigManager;
import core.utilities.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.configuration.ConfigManager.getProperty;

public class LoginPage extends BasePage {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//input[@name='login']")
  private WebElement usernameField;

  @FindBy(xpath = "//input[@name='password']")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement loginButton;

  @FindBy(xpath = "//p[text()='Signed in successfully']")
  private WebElement successMessage;

  public void login() {
    driver.get(getProperty("url"));
    usernameField.sendKeys(getProperty("username"));
    passwordField.sendKeys(getProperty("password"));
    loginButton.click();
  }

  public String getSuccessMessageAfterLogin(){
    WaitUtils.waitForElementToBeVisible(driver, successMessage);
    return successMessage.getText();
  }
}
