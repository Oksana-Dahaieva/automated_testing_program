package core.api.clients;

import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.routing.DefaultProxyRoutePlanner;
import org.apache.hc.core5.http.HttpHost;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class BaseApiClient {

  private final CloseableHttpClient httpClient;

  public BaseApiClient() {
    HttpHost proxy = new HttpHost("localhost", 8888);
    DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
    this.httpClient = HttpClients
        .custom()
        .setRoutePlanner(routePlanner)
        .build();
  }

  protected CloseableHttpClient getHttpClient() {
    return httpClient;
  }

  protected String executeRequestAndGetResponse(HttpUriRequestBase request) throws IOException {
    try (CloseableHttpResponse response = httpClient.execute(request)) {
      return EntityUtils.toString((HttpEntity) response.getEntity());
    }
  }

  public void close() {
    try {
      httpClient.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
