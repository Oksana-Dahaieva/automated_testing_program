package ui;

import business.action.LoginActions;
import business.pages.LoginPage;
import core.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static core.configuration.DriverManager.getDriver;
import static core.configuration.DriverManager.quitDriver;
import static org.testng.AssertJUnit.assertEquals;

public class BaseTest {

  protected WebDriver driver;
  protected LoginActions loginActions;

  @BeforeMethod
  public void setUp() {
    Log.info("Initializing WebDriver in @Before hook");
    driver = getDriver();
    loginActions = new LoginActions(new LoginPage(driver));
  }

  public void performLogin() {
    Log.info("Performing login");
    loginActions.openLoginPage();
    loginActions.login();
    assertEquals(loginActions.getSuccessMessageAfterLogin(), "Signed in successfully");
  }

  @AfterMethod
  public void tearDown() {
    Log.info("Quitting WebDriver in @After hook");
    quitDriver();
  }

}
