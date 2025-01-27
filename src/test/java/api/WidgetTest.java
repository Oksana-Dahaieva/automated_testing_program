package api;

import core.api.clients.RestClient;
import core.dto.Widget;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static core.data.TestDataLoader.getConfigValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WidgetTest extends BaseApiTest {

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

    String project = getConfigValue("rp.project");
    String endpoint = project + "/widget/";

    RestClient client = new RestClient(getConfigValue("rp.api.key"));

    Response response = client.post(endpoint, requestBody);

    assertEquals(201, response.getStatusCode(), "Expected status code 201");
  }

  @Test
  public void shouldCreateWidget() {
    Widget widget = new Widget();
    widget.setName("Test Widget");
    widget.setType("Chart");

    Response response = sendPostRequest("/v1/projectName/widget", widget);
    assertEquals(response.getStatusCode(), 201);

    Widget createdWidget = response.as(Widget.class);
    assertEquals(createdWidget.getName(), widget.getName());
    assertEquals(createdWidget.getType(), widget.getType());
  }

  @Test
  public void shouldNotCreateWidgetWithoutType() {
    Widget widget = new Widget();
    widget.setName("Test Widget");

    Response response = sendPostRequest("/v1/projectName/widget", widget);
    assertEquals(response.getStatusCode(), 400);
  }

  @Test
  public void shouldGetWidgetById() {
    String widgetId = "456";

    Response response = sendGetRequest("/v1/projectName/widget/" + widgetId);
    assertEquals(response.getStatusCode(), 200);

    Widget widget = response.as(Widget.class);
    assertNotNull(widget.getId());
    assertEquals(widget.getId(), widgetId);
  }
}
