package api;

import core.api.clients.RestClient;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static core.data.TestDataLoader.getConfigValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchesTest {

  @ParameterizedTest
  @CsvFileSource(resources = "launchAnalysisTestData.csv", numLinesToSkip = 1)
  public void testStartLaunchAnalysis(String analyzeItemsMode,
      String analyzerMode,
      String launchId,
      String analyzerTypeName) {

    String requestBody = String.format(
        "{\"analyzeItemsMode\": [\"%s\"], \"analyzerMode\": \"%s\", \"launchId\": %s, " +
            "\"analyzerTypeName\": \"%s\"}", analyzeItemsMode, analyzerMode, launchId,
        analyzerTypeName);

    String project = getConfigValue("rp.project");
    String endpoint = project + "/launch/analyze";

    RestClient client = new RestClient(getConfigValue("rp.api.key"));

    Response response = client.post(endpoint, requestBody);

    assertEquals(200, response.getStatusCode(), "Expected status code 20");
  }
}
