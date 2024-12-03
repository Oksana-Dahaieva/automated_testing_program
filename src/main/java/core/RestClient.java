package core;

import core.data.TestDataLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestClient {

  private final RequestSpecification request;

  public RestClient(String apiKey) {
    RestAssured.baseURI = TestDataLoader.getConfigValue("rp.endpoint");
    this.request = RestAssured.given()
        .header("Authorization", "Bearer " + apiKey)
        .header("Content-Type", "application/json");
  }

  public Response post(String endpoint, String body) {
    return request.body(body).post(endpoint);
  }

  public Response delete(String endpoint) {
    return request.delete(endpoint);
  }
}
