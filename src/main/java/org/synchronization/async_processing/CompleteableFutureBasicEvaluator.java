package org.synchronization.async_processing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompleteableFutureBasicEvaluator {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    CompleteableFutureBasic basic = new CompleteableFutureBasic();
    Future<String> stringFuture = basic.calculateAsync();

    String result = stringFuture.get();
    System.out.println(result);
  }
}
