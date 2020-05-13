package org.leetcode.design;

public class MyCircularDeque {

  class QueueNode{

    public int data;
    public QueueNode next;
    public QueueNode prev;

    public QueueNode(int data){
      this.data = data;
    }

  }

  private int maxSize;
  private int currentSize;
  private QueueNode front;
  private QueueNode rear;


  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque(int k) {
    this.maxSize = k;
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if(maxSize < 0 || currentSize >= maxSize){
      return false;
    }

    QueueNode node = new QueueNode(value);
    if(currentSize == 0){
      front = rear = node;
    }else{
      node.next = front;
      front.prev = node;
      front = node;
    }

    currentSize++;
    return true;
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if(maxSize < 0 || currentSize >= maxSize){
      return false;
    }

    QueueNode node = new QueueNode(value);
    if(currentSize == 0 ){
      front = rear = node;
    }else{
      rear.next = node;
      node.prev = rear;
      rear = node;
    }

    currentSize ++;
    return true;
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
    if(currentSize == 0){
      return false;
    }

    front = front.next;
    currentSize--;

    return true;
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if(currentSize == 0){
      return false;
    }

    rear = rear.prev;
    currentSize --;
    return true;
  }

  /** Get the front item from the deque. */
  public int getFront() {
    return currentSize == 0 ? -1 : front.data;
  }

  /** Get the last item from the deque. */
  public int getRear() {
    return currentSize == 0 ? -1 : rear.data;
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return currentSize == 0;
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return currentSize == maxSize;
  }
}
