package business.pages;

import core.utilities.WaitUtils;
import org.openqa.selenium.Keys;
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
  @FindBy(xpath = "//a[@href='#default_personal/launches']")
  private WebElement launchesButton;
  @FindBy(xpath = "//p[text()='Signed in successfully']")
  private WebElement successMessage;

  public void openLoginPage() {
    driver.get(getProperty("url"));
  }

  public WebElement geUserNameInput() {
    return usernameField;
  }

  public WebElement getPasswordInput() {
    return passwordField;
  }

  public WebElement getSuccessMessage() {
    return successMessage;
  }

  public void enterUsername() {
    usernameField.sendKeys(Keys.CONTROL + "a");
    usernameField.sendKeys(Keys.DELETE);
    usernameField.sendKeys(getProperty("username"));
  }

  public void enterPassword() {
    passwordField.sendKeys(Keys.CONTROL + "a");
    passwordField.sendKeys(Keys.DELETE);
    passwordField.sendKeys(getProperty("password"));
  }

  public void clickLoginButton() {
    loginButton.click();
  }

  public String successMessageIsDisplayed() {
    return successMessage.getText();
  }
}
