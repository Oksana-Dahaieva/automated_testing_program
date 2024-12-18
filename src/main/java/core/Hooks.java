package core;

import business.action.LoginActions;
import business.pages.LoginPage;
import core.configuration.DriverManager;
import core.context.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import static core.configuration.DriverManager.getDriver;

public class Hooks {

  private ScenarioContext scenarioContext;

  public Hooks(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;
  }

  @Before
  public void beforeScenario(Scenario scenario) {
    System.out.println("Starting Scenario: " + scenario.getName());
    WebDriver driver = getDriver();
    scenarioContext.setContext("driver", driver);  // Store driver in context
  }

  @After
  public void afterScenario(Scenario scenario) {
    System.out.println("Cleaning up after Scenario: " + scenario.getName());
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    DriverManager.quitDriver();
  }

  @Given("the user is logged in")
  public void givenUserIsLoggedIn() {
    WebDriver driver = (WebDriver) scenarioContext.getContext("driver");
    LoginActions loginActions = new LoginActions((LoginPage) driver);
    loginActions.openLoginPage();
    loginActions.login();
  }

}
