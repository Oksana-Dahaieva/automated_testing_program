package api;

import core.api.clients.RestClient;
import core.api.clients.DashboardApiClient;
import core.dto.Dashboard;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testng.Assert;

import static core.data.TestDataLoader.getConfigValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardTest extends BaseApiTest {

  private final DashboardApiClient dashboardApiClient = new DashboardApiClient();

  @ParameterizedTest
  @CsvFileSource(resources = "dashboardTestData.csv", numLinesToSkip = 1)
  public void testCreateDashboard(String name, String description) {

    String requestBody =
        String.format("{\"name\":\"%s\",\"description\":\"%s\"}", name, description);
    String project = getConfigValue("rp.project");
    String endpoint = project + "/dashboard";

    RestClient client = new RestClient(getConfigValue("rp.api.key"));

    Response response = client.post(endpoint, requestBody);

    assertEquals(201, response.getStatusCode(), "Expected status code 201");

    String dashboardId = response
        .jsonPath()
        .getString("id");

    assertNotNull(dashboardId, "Dashboard ID should not be null");

    String deleteEndpoint = project + "/dashboard/" + dashboardId;
    Response deleteResponse = client.delete(deleteEndpoint);

    assertEquals(deleteResponse.getStatusCode(), 200, "Expected status code 200 for delete");
  }

  @Test
  public void testAddDashboard() throws Exception {
    String response = dashboardApiClient.addDashboard("TestDashboard", "Test Description");
    assertTrue(response.contains("Dashboard has been added"));
  }

  @Test
  public void testGetAllDashboards() throws Exception {
    String response = dashboardApiClient.getAllDashboards();
    assertTrue(response.contains("TestDashboard"));
  }

  @Test
  public void shouldCreateDashboard() {
    Dashboard dashboard = new Dashboard();
    dashboard.setName("Test Dashboard");
    dashboard.setDescription("Description for test dashboard");

    Response response = sendPostRequest("/v1/projectName/dashboard", dashboard);
    Assert.assertEquals(response.getStatusCode(), 201);

    Dashboard createdDashboard = response.as(Dashboard.class);
    assertEquals(createdDashboard.getName(), dashboard.getName());
    assertEquals(createdDashboard.getDescription(), dashboard.getDescription());
  }

  @Test
  public void shouldNotCreateDashboardWithoutName() {
    Dashboard dashboard = new Dashboard();
    dashboard.setDescription("Description for test dashboard");

    Response response = sendPostRequest("/v1/projectName/dashboard", dashboard);
    assertEquals(response.getStatusCode(), 400);
  }

  @Test
  public void shouldGetDashboardById() {
    String dashboardId = "123";

    Response response = sendGetRequest("/v1/projectName/dashboard/" + dashboardId);
    assertEquals(response.getStatusCode(), 200);

    Dashboard dashboard = response.as(Dashboard.class);
    assertNotNull(dashboard.getId());
    assertEquals(dashboard.getId(), dashboardId);
  }
}
