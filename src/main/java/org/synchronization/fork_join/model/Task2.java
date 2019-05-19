package org.synchronization.fork_join.model;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Task2 extends RecursiveTask<Integer> {

  private int array[];
  private int start, end;

  public Task2(int[] array, int start, int end) {
    this.array = array;
    this.start = start;
    this.end = end;
  }


  @Override
  protected Integer compute() {
    System.out.printf("Task: Start from %d to %d\n", start, end);

    if (end - start < 10) {
      if ((3 > start) && (3 < end)) {
        throw new RuntimeException("This task throws an" + "Exception: Task from  " + start + " to " + end);
      }
      try {
        TimeUnit.SECONDS.sleep(1);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
    else {
      int mid = (end + start) / 2;
      Task2 task1 = new Task2(array, start, mid);
      Task2 task2 = new Task2(array, mid, end);
      invokeAll(task1, task2);
    }

    System.out.printf("Task: End form %d to %d\n", start, end);
    return 0;
  }
}
