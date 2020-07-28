package org.synchronization.async_processing;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SquareCalculator {

  private ExecutorService executor = Executors.newFixedThreadPool(2);

  public Future<Integer> calculate(Integer input) {

    return executor.submit(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        try {
          TimeUnit.SECONDS.sleep(1);
          return Math.multiplyExact(input, input);
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }

        return null;
      }
    });
  }

  public void shutDown(){
    executor.shutdown();
  }
}
