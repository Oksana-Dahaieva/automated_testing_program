package steps;

import business.pages.LoginPage;
import core.configuration.ConfigManager;
import core.configuration.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

  private WebDriver driver;
  private LoginPage loginPage;

  @Before
  public void setUp() {
    driver = DriverManager.getDriver();
  }

  @Given("I open the Report Portal login page")
  public void openLoginPage() {
    loginPage = new LoginPage(driver);
  }

  @When("I log in with valid credentials")
  public void login() {
    loginPage.login();
  }

  @Then("I should see the dashboard")
  public void verifyLogin() {
    String expectedUrl = "http://localhost:8080/ui/#automated_testing_global_mentoring_program/dashboard";
    assertTrue(driver
        .getCurrentUrl()
        .contains(expectedUrl), "Dashboard is not visible. Login failed!");
  }

  @After
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
