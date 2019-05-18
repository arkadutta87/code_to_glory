package org.synchronization.fork_join.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.synchronization.fork_join.model.Document;
import org.synchronization.fork_join.model.DocumentTask;

public class WordCounter {

  public static void main(String[] args) {

    Document mock = new Document();
    String[][] document = mock.generateDocument(100, 1000, "the");
    DocumentTask task = new DocumentTask(document, 0, 100, "the");

    ForkJoinPool pool = new ForkJoinPool();
    pool.execute(task);

    do {
      System.out.printf("***************************************** *\n");
      System.out.printf("ProductUpdater: Parallelism: %d\n", pool.getParallelism());
      System.out.printf("ProductUpdater: Active Threads: %d\n", pool.getActiveThreadCount());
      System.out.printf("ProductUpdater: Task Count: %d\n", pool.getQueuedTaskCount());
      System.out.printf("ProductUpdater: Steal Count: %d\n", pool.getStealCount());
      System.out.printf("***************************************** *\n");
      try {
        TimeUnit.SECONDS.sleep(1);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    while (!task.isDone());

    pool.shutdown();

    try {
      pool.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      System.out.printf("ProductUpdater: The word appears %d in the document",task.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
