package org.synchronization.async_processing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolEvaluator {

  public static void main(String[] args) throws InterruptedException {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    FactorialSquareCalculator calculator = new FactorialSquareCalculator(4);

    forkJoinPool.execute(calculator);

    TimeUnit.SECONDS.sleep(2);

    System.out.println(calculator.getRawResult());
  }
}
