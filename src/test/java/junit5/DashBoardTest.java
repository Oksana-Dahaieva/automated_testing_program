package junit5;

import core.RestClient;
import core.data.TestDataLoader;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DashBoardTest {

  @ParameterizedTest
  @CsvFileSource(resources = "dashboardTestData.csv", numLinesToSkip = 1)
  public void testCreateDashboard(String name, String description) {

    String requestBody = String.format("{\"name\":\"%s\",\"description\":\"%s\"}", name, description);
    String project = TestDataLoader.getConfigValue("rp.project");
    String endpoint = "/api/v1/" + project + "/dashboard";

    RestClient client = new RestClient(TestDataLoader.getConfigValue("rp.api.key"));

    Response response = client.post(endpoint, requestBody);

    assertEquals(201, response.getStatusCode(), "Expected status code 201");

    String dashboardId = response.jsonPath().getString("id");

    assertNotNull(dashboardId, "Dashboard ID should not be null");

    String deleteEndpoint = "/api/v1/" + project + "/dashboard/" + dashboardId;
    Response deleteResponse = client.delete(deleteEndpoint);

    assertEquals(deleteResponse.getStatusCode(), 200, "Expected status code 200 for delete");
  }
}
