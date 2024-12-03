package junit5;

import core.RestClient;
import core.data.TestDataLoader;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchesTest {

  @ParameterizedTest
  @CsvFileSource(resources = "launchAnalysisTestData.csv", numLinesToSkip = 1)
  public void testStartLaunchAnalysis(String analyzeItemsMode, String analyzerMode, String launchId,
      String analyzerTypeName) {
    String requestBody = String.format(
        "{\"analyzeItemsMode\": [\"%s\"], \"analyzerMode\": \"%s\", \"launchId\": %s, " +
            "\"analyzerTypeName\": \"%s\"}",
        analyzeItemsMode, analyzerMode, launchId, analyzerTypeName);

    String project = TestDataLoader.getConfigValue("rp.project");
    String endpoint = "/api/v1/" + project + "/launch/analyze";

    RestClient client = new RestClient(TestDataLoader.getConfigValue("rp.api.key"));

    Response response = client.post(endpoint, requestBody);

    assertEquals(200, response.getStatusCode(), "Expected status code 201");
  }
}
