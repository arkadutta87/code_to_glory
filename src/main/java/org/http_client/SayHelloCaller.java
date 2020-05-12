package org.http_client;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SayHelloCaller {

  public static void main(String[] args) throws Exception{
    SayHelloService service = new SayHelloServiceConnectionPooled();

    //hit the service 10 times

    ExecutorService executorService = new ThreadPoolExecutor(300, 600, 5L, TimeUnit.MILLISECONDS,
                                                             new LinkedBlockingQueue<Runnable>(5000000));

    for(int i = 0 ; i < 1000000; i ++){
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          try {
            service.hitTheService();
          }
          catch (IOException e) {
          }
        }
      });

    }

    executorService.awaitTermination(120, TimeUnit.SECONDS);
//    executorService.shutdown();

//    service.hitTheService();
  }
}
