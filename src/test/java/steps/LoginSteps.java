package steps;

import business.pages.LoginPage;
import core.logging.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static core.configuration.DriverManager.getDriver;
import static core.configuration.DriverManager.quitDriver;
import static org.testng.Assert.assertEquals;

public class LoginSteps {

  private WebDriver driver;

  private LoginPage loginPage;

  private static final String EXPECTED_MESSAGE = "Signed in successfully";

  @Before
  public void setUp() {
    Log.info("Initializing WebDriver in @Before hook");
    driver = getDriver();
  }

  @Given("I open the Report Portal login page")
  public void openLoginPage() {
    Log.info("Opening the Report Portal login page");
    loginPage = new LoginPage(driver);
  }

  @When("I log in with valid credentials")
  public void login() {
    Log.info("Attempting to log in with valid credentials");
    loginPage.login();
  }

  @Then("I should see the dashboard")
  public void verifyLogin() {
    String actualMessage = loginPage.getSuccessMessageAfterLogin();
    Log.info("Verifying login: Expected message: " + EXPECTED_MESSAGE + ", Actual message: " +
        actualMessage);
    assertEquals(actualMessage, EXPECTED_MESSAGE);
  }

  @After
  public void tearDown() {
    Log.info("Quitting WebDriver in @After hook");
    quitDriver();
  }
}
