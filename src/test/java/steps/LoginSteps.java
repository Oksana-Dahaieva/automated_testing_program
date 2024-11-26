package steps;

import business.pages.LoginPage;
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

  @Before
  public void setUp() {
    driver = getDriver();
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
    assertEquals(loginPage.getSuccessMessageAfterLogin(), "Signed in successfully");
  }

  @After
  public void tearDown() {
    quitDriver();
  }
}
