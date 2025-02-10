package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static core.data.TestDataLoader.getConfigValue;

public class BaseApiTest {

  protected RequestSpecification requestSpec;

  @BeforeEach
  public void setup() {
    RestAssured.baseURI = getConfigValue("rp.project");
    ;
    requestSpec = RestAssured
        .given()
        .contentType("application/json")
        .accept("application/json")
        .header("Authorization", "Bearer " + getConfigValue("rp.api.key"));
  }

  protected Response sendGetRequest(String endpoint) {
    return requestSpec.get(endpoint);
  }

  protected Response sendPostRequest(String endpoint, Object body) {
    return requestSpec
        .body(body)
        .post(endpoint);
  }

  protected Response sendPutRequest(String endpoint, Object body) {
    return requestSpec
        .body(body)
        .put(endpoint);
  }

  protected Response sendDeleteRequest(String endpoint) {
    return requestSpec.delete(endpoint);
  }
}
