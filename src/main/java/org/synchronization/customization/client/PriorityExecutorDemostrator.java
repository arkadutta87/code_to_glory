package org.synchronization.customization.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.synchronization.customization.model.MyPriorityTask;

public class PriorityExecutorDemostrator {

  public static void main(String[] args) {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());

    for (int i = 0; i < 4; i++) {
      MyPriorityTask task = new MyPriorityTask("Task " + i, i);
      executor.execute(task);
    }

    try {
      TimeUnit.SECONDS.sleep(1);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }

    List<String> digDeep = new ArrayList<>();
    digDeep.size();
    Map<String,Integer> mapDigging = new HashMap<>();

    ExecutorService executorService = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
//    executorService.execute();
    ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    concurrentHashMap.get("Arka");
    concurrentHashMap.put("Arka", 1);
    for (int i = 4; i < 8; i++) {
      MyPriorityTask task = new MyPriorityTask("Task " + i, i);
      executor.execute(task);
    }

    executor.shutdown();

    try {
      executor.awaitTermination(1, TimeUnit.DAYS);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.printf("Main: End of the program.\n");
  }
}
