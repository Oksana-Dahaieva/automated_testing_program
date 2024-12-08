package business.action;

import business.pages.LoginPage;

public class LoginActions {

  private static final long DEFAULT_TIMEOUT = 30;

  private final LoginPage loginPage;

  public LoginActions(LoginPage loginPage) {
    this.loginPage = loginPage;
  }

  public void openLoginPage() {
    loginPage.openLoginPage();
  }

  public void login() {
    loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.geUserNameInput());
    loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordInput());
    loginPage.enterUsername();
    loginPage.enterPassword();
    loginPage.clickLoginButton();
  }

  public String getSuccessMessageAfterLogin() {
    loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getSuccessMessage());
    return loginPage.successMessageIsDisplayed();
  }
}
