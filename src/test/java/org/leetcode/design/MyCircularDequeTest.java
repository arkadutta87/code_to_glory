package org.leetcode.design;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MyCircularDequeTest {

  @Test
  public void testPositiveTrivialCase(){
    MyCircularDeque deque = new MyCircularDeque(3);
    Assertions.assertEquals(deque.insertLast(1), true);
    Assertions.assertEquals(deque.insertLast(2), true);
    Assertions.assertEquals(deque.insertFront(3), true);
    Assertions.assertEquals(deque.insertFront(4), false);

    Assertions.assertEquals(deque.getRear(), 2);
    Assertions.assertEquals(deque.isFull(), true);
    Assertions.assertEquals(deque.deleteLast(), true);
    Assertions.assertEquals(deque.insertFront(4), true);
    Assertions.assertEquals(deque.getFront(), 4);
  }
}
