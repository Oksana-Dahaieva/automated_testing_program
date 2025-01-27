package core.api.clients;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class DashboardApiClient extends BaseApiClient {

  private static final String BASE_URL = "http://localhost:8080/api/v1";

  public String getAllDashboards() throws IOException {
    HttpGet request = new HttpGet(BASE_URL + "/dashboards");
    return executeRequestAndGetResponse(request);
  }

  public String addDashboard(String dashboardName, String dashboardDescription) throws IOException {
    HttpPost request = new HttpPost(BASE_URL + "/dashboards");
    String jsonPayload = String.format("{\"name\": \"%s\", \"description\": \"%s\"}", dashboardName,
        dashboardDescription);
    request.setEntity(new StringEntity(jsonPayload));
    request.setHeader("Content-Type", "application/json");
    return executeRequestAndGetResponse(request);
  }

}
