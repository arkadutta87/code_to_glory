package org.synchronization.async_processing;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompleteableFutureBasic {

  public Future<String> calculateAsync() throws InterruptedException{
    CompletableFuture<String> completableFuture = new CompletableFuture<>();

    Executors.newCachedThreadPool().submit(() -> {
      try {
        TimeUnit.MILLISECONDS.sleep(500);
        completableFuture.complete("Hello");
        return null;
      }
      catch (InterruptedException e) {
        e.printStackTrace();
        return null;
      }
    });

    return completableFuture;
  }
}
