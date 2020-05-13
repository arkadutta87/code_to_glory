package org.leetcode.design;

public class MyCircularQueue {

  private int maxSize;
  private int currentNodes;

  private QueueNode front;
  private QueueNode back;


  class QueueNode {

    public int val;
    public QueueNode next;

    public QueueNode(int val) {
      this.val = val;
    }
  }

  public MyCircularQueue(int k) {
    this.maxSize = k;
  }

  public boolean enQueue(int value) {
    if (maxSize < 0 || currentNodes >= maxSize) {
      return false;
    }

    QueueNode node = new QueueNode(value);
    if (currentNodes == 0) {
      front = back = node;
    }
    else {
      back.next = node;
      back = node;
    }
    currentNodes++;
    return true;
  }

  public boolean deQueue() {
    if(currentNodes == 0){
      return false;
    }
    front = front.next;
    currentNodes--;

    return true;
  }

  public int Front() {
    return currentNodes == 0 ? -1 : front.val;
  }

  public int Rear() {
    return currentNodes == 0 ? -1 : back.val;
  }

  public boolean isEmpty() {
    return currentNodes == 0;
  }

  public boolean isFull() {
    return currentNodes == maxSize;
  }
}
