package org.synchronization.intrinsic_locks.guarded_blocks;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

  private Drop drop;

  public Consumer(Drop drop) {
    this.drop = drop;
  }

  @Override
  public void run() {

    Random random = new Random();

    for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
      System.out.printf("Message received : %s\n", message);
      try {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
      }
      catch (InterruptedException e) {

      }
    }
  }
}
