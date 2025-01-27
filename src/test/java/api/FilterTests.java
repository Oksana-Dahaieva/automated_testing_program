package api;

import core.api.clients.RestClient;
import core.dto.Filter;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static core.data.TestDataLoader.getConfigValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FilterTests extends BaseApiTest {

  @ParameterizedTest
  @CsvFileSource(resources = "filterTestData.csv", numLinesToSkip = 1)
  public void testCreateFilter(String filteringField,
      String value,
      String condition,
      String type,
      String isAsc,
      String sortingColumn,
      String name,
      String owner,
      String description) {

    String requestBody = String.format(
        "{\"conditions\": [{\"filteringField\": \"%s\", \"value\": \"%s\", \"condition\": " +
            "\"%s\"}], " +
            "\"type\": \"%s\", \"orders\": [{\"isAsc\": %s, \"sortingColumn\": \"%s\"}], " +
            "\"name\": \"%s\", \"owner\": \"%s\", \"description\": \"%s\"}", filteringField, value,
        condition, type, isAsc, sortingColumn, name, owner, description);

    String project = getConfigValue("rp.project");
    String endpoint = project + "/filter";

    RestClient client = new RestClient(getConfigValue("rp.api.key"));

    Response response = client.post(endpoint, requestBody);

    assertEquals(response.getStatusCode(), 201, "Expected status code 201");

    String filterId = response
        .jsonPath()
        .getString("id");

    assertNotNull(filterId, "Filter ID should not be null");

    String deleteEndpoint = project + "/filter/" + filterId;
    Response deleteResponse = client.delete(deleteEndpoint);

    assertEquals(deleteResponse.getStatusCode(), 200, "Expected status code 200 for delete");
  }

  @Test
  public void shouldCreateFilter() {
    Filter filter = new Filter();
    filter.setName("Test Filter");
    filter.setCriteria("status:passed");

    Response response = sendPostRequest("/v1/projectName/filter", filter);
    assertEquals(response.getStatusCode(), 201);

    Filter createdFilter = response.as(Filter.class);
    assertEquals(createdFilter.getName(), filter.getName());
    assertEquals(createdFilter.getCriteria(), filter.getCriteria());
  }

  @Test
  public void shouldNotCreateFilterWithoutCriteria() {
    Filter filter = new Filter();
    filter.setName("Test Filter");

    Response response = sendPostRequest("/v1/projectName/filter", filter);
    assertEquals(response.getStatusCode(), 400);
  }

  @Test
  public void shouldDeleteFilterById() {
    String filterId = "789";

    Response response = sendDeleteRequest("/v1/projectName/filter/" + filterId);
    assertEquals(response.getStatusCode(), 204);
  }
}
