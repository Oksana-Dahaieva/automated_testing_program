package business.action;

import business.pages.DashboardPage;

public class DashboardActions {

  private static final long DEFAULT_TIMEOUT = 60;
  private final DashboardPage dashboardPage;

  public DashboardActions(DashboardPage dashboardPage) {
    this.dashboardPage = dashboardPage;
  }

  public void addNewDashBoard(String dashboardName, String dashboardDescription) {
    dashboardPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    dashboardPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dashboardPage.getAddNewDashboardButton());
    dashboardPage.clickAddNewDashboard();
    dashboardPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dashboardPage.getNameField());
    dashboardPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dashboardPage.getDescriptionField());
    dashboardPage.enterDashboardName(dashboardName);
    dashboardPage.enterDashboardDescription(dashboardDescription);
    dashboardPage.clickAddButton();
  }

  public String getDashboardTitle() {
    dashboardPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dashboardPage.getDashboardTitle());
    return dashboardPage.getTextFromDashboardTitle();
  }

  public void deleteDashboard() {
    dashboardPage.waitElementToBeClickable(DEFAULT_TIMEOUT, dashboardPage.getDeleteButton());
    dashboardPage.clickDeleteButton();
    dashboardPage.confirmDelete();
  }


  public String getSuccessMessageAfterDeleteDashboard() {
    dashboardPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dashboardPage.getSuccessMessage());
    return dashboardPage.successMessageIsDisplayed();
  }
}
