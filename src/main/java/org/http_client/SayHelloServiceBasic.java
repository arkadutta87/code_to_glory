package org.http_client;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SayHelloServiceBasic implements SayHelloService {

  private final String sayHelloEndpoint = "http://localhost:8080/helloWorld";
  private final Set<String> namesToSayHello = new HashSet<>(Arrays.asList("Arka Dutta", "Shalmoli Das", "Ritwik Mitra",
                                                                          "Rutvi Shah", "Sameer Saurav", "Ashok Pradhan",
                                                                          "Praguna Manvi"));

  private CloseableHttpClient httpclient = HttpClients.createDefault();

//  public SayHelloServiceBasic(){
    //initialize the http client
//    HttpClient.Builder builder = HttpClient.newBuilder();
//    builder.connectTimeout(Duration.ofMillis(50));//50ms timeout
//    client = builder.build();
//  }

  @Override
  public void hitTheService() throws IOException {
    HttpGet httpGet = new HttpGet(sayHelloEndpoint);
    CloseableHttpResponse response1 = httpclient.execute(httpGet);

    response1.close();
  }
}
