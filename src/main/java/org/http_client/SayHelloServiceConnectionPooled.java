package org.http_client;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class SayHelloServiceConnectionPooled implements SayHelloService{

  private CloseableHttpClient client;
  private final String sayHelloEndpoint = "http://localhost:8080/helloWorld";
  PoolingHttpClientConnectionManager poolingConnManager;

  public SayHelloServiceConnectionPooled(){
    poolingConnManager = new PoolingHttpClientConnectionManager();
    poolingConnManager.setDefaultMaxPerRoute(100);
    poolingConnManager.setMaxTotal(200);
    client = HttpClients.custom().setConnectionManager(poolingConnManager).build();
  }

  @Override
  public void hitTheService() throws IOException {
    CloseableHttpResponse response1 = client.execute(new HttpGet(sayHelloEndpoint));
    response1.close();
  }
}
