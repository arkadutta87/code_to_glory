package org.synchronization.async_processing;

import java.util.concurrent.ForkJoinPool;

public class CustomRecursiveTaskEvaluator {

  public static void main(String[] args) {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    CustomRecursiveTask task = new CustomRecursiveTask(new int[]{3, 5, 7, 10, 19});

    System.out.println(forkJoinPool.invoke(task));
  }
}
