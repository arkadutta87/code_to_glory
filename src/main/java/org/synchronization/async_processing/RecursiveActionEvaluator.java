package org.synchronization.async_processing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class RecursiveActionEvaluator {

  public static void main(String[] args) throws InterruptedException {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    CustomRecursiveAction recursiveAction = new CustomRecursiveAction("arkadutt");

    forkJoinPool.execute(recursiveAction);

    TimeUnit.SECONDS.sleep(2);

//    System.out.println(calculator.getRawResult());
  }
}
