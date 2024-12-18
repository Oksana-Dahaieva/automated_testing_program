package api;

import core.api.RestClient;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static core.data.TestDataLoader.getConfigValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DashboardTest {

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
}
