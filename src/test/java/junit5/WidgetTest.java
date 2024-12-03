package junit5;

import core.RestClient;
import core.data.TestDataLoader;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WidgetTest {

  @ParameterizedTest
  @CsvFileSource(resources = "widgetTestData.csv", numLinesToSkip = 1)
  public void testCreateWidget(String widgetType,
      String contentParameters,
      String itemsCount,
      String viewMode,
      String latest,
      String value,
      String name,
      String description,
      String filterIds) {
    String requestBody = String.format("{\"widgetType\": \"%s\", " +
            "\"contentParameters\": {\"contentFields\": [\"%s\"], \"itemsCount\": \"%s\", " +
            "\"widgetOptions\": {\"viewMode\": \"%s\", \"latest\": %s}}, " +
            "\"filters\": [{\"value\": \"%s\", \"name\": \"DEMO_FILTER\"}], " +
            "\"name\": \"%s\", \"description\": \"%s\", \"filterIds\": [\"%s\"]}", widgetType,
        contentParameters, itemsCount, viewMode, latest, value, name, description, filterIds);

    String project = TestDataLoader.getConfigValue("rp.project");
    String endpoint = "/api/v1/" + project + "/widget/";

    RestClient client = new RestClient(TestDataLoader.getConfigValue("rp.api.key"));

    Response response = client.post(endpoint, requestBody);

    assertEquals(201, response.getStatusCode(), "Expected status code 201");
  }
}
