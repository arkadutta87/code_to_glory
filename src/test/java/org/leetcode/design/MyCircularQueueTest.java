package org.leetcode.design;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MyCircularQueueTest {

  @Test
  public void testCircularQueuePositiveCase() {
    MyCircularQueue circularQueue = new MyCircularQueue(2);
    Assertions.assertEquals(circularQueue.isEmpty(), true);
    Assertions.assertEquals(circularQueue.isFull(), false);
    Assertions.assertEquals(circularQueue.deQueue(), false);

    Assertions.assertEquals(circularQueue.enQueue(1), true);
    Assertions.assertEquals(circularQueue.isFull(), false);
    Assertions.assertEquals(circularQueue.isEmpty(), false);

    Assertions.assertEquals(circularQueue.enQueue(2), true);
    Assertions.assertEquals(circularQueue.enQueue(3), false);

    Assertions.assertEquals(circularQueue.deQueue(), true);
    Assertions.assertEquals(circularQueue.enQueue(3), true);

    Assertions.assertEquals(circularQueue.isFull(), true);

    Assertions.assertEquals(circularQueue.deQueue(), true);
    Assertions.assertEquals(circularQueue.deQueue(), true);

    Assertions.assertEquals(circularQueue.isFull(), false);
    Assertions.assertEquals(circularQueue.isEmpty(), true);

  }

  @Test
  public void testNegativeMaxSizeQueue() {
    MyCircularQueue circularQueue = new MyCircularQueue(-2);

    Assertions.assertEquals(circularQueue.enQueue(1), false);
    Assertions.assertEquals(circularQueue.deQueue(), false);

    Assertions.assertEquals(circularQueue.isEmpty(), true);
    Assertions.assertEquals(circularQueue.isFull(), false);
  }

  @Test
  public void testLeetCodeFailCase() {
    MyCircularQueue circularQueue = new MyCircularQueue(3);

    Assertions.assertEquals(circularQueue.enQueue(7), true);
    Assertions.assertEquals(circularQueue.deQueue(), true);
    Assertions.assertEquals(circularQueue.Front(), -1);
    Assertions.assertEquals(circularQueue.deQueue(), false);
    Assertions.assertEquals(circularQueue.Front(), -1);
    Assertions.assertEquals(circularQueue.Rear(), -1);
    Assertions.assertEquals(circularQueue.enQueue(0), true);
    Assertions.assertEquals(circularQueue.isFull(), false);
    Assertions.assertEquals(circularQueue.deQueue(), true);
    Assertions.assertEquals(circularQueue.Rear(), -1);
    Assertions.assertEquals(circularQueue.enQueue(3), true);

  }
}
