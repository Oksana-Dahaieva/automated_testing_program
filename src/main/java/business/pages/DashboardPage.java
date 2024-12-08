package business.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

  public DashboardPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "(//span[text()='Add New Dashboard']/parent::button)[1]")
  private WebElement addNewDashboardButton;

  @FindBy(xpath = "//input[@placeholder='Enter dashboard name']")
  private WebElement fieldForInputName;

  @FindBy(xpath = "//textarea[@placeholder='Enter dashboard description']")
  private WebElement fieldForInputDescription;

  @FindBy(xpath = "//button[text()='Add']")
  private WebElement addButton;

  @FindBy(xpath = "//p[text()='Dashboard has been deleted']")
  private WebElement createSuccessMessage;

  @FindBy(xpath = "//a[@href='#default_personal/dashboard']")
  private WebElement dashboardButton;

  @FindBy(xpath = "//input[@placeholder='Enter dashboard name']")
  private WebElement nameField;

  @FindBy(xpath = "//textarea[@placeholder='Enter dashboard description']")
  private WebElement descriptionField;

  @FindBy(xpath = "//ul[contains(@class,'pageBreadcrumbs')]//span")
  private WebElement dashboardTitle;

  @FindBy(xpath = "//span[text()='Delete']/parent::button")
  private WebElement deleteButton;

  @FindBy(xpath = "//button[text()='Delete']")
  private WebElement confirmDelete;

  @FindBy(xpath = "//p[text()='Dashboard has been deleted']")
  private WebElement successMessage;

  public WebElement getDashboardButton() {
    return dashboardButton;
  }

  public WebElement getAddNewDashboardButton() {
    return addNewDashboardButton;
  }

  public WebElement getNameField() {
    return nameField;
  }

  public WebElement getDescriptionField() {
    return descriptionField;
  }

  public WebElement getDashboardTitle() {
    return dashboardTitle;
  }

  public WebElement getDeleteButton() {
    return deleteButton;
  }

  public WebElement getSuccessMessage() {
    return successMessage;
  }

  public void clickDashboardButton() {
    dashboardButton.click();
  }

  public void clickAddNewDashboard() {
    addNewDashboardButton.click();
  }

  public void enterDashboardName(String dashboardName) {
    nameField.sendKeys(dashboardName);
  }

  public void enterDashboardDescription(String dashboardDescription) {
    descriptionField.sendKeys(dashboardDescription);
  }

  public void clickAddButton() {
    addButton.click();
  }

  public String getTextFromDashboardTitle() {
    return dashboardTitle.getText();
  }

  public void clickDeleteButton() {
    deleteButton.click();
  }

  public void confirmDelete() {
    confirmDelete.click();
  }

  public String successMessageIsDisplayed() {
    return successMessage.getText();
  }
}
