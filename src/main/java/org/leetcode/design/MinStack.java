package org.leetcode.design;

public class MinStack {

  class Record {

    int val;
    int minimum;

    Record next;

    public Record(int val, int minimum) {
      this.val = val;
      this.minimum = minimum;
    }
  }

  private Record head;

  public MinStack() {

  }

  public void push(int x) {
    if (head == null) {
      Record record = new Record(x, x);
      head = record;
    }
    else {
      Record record = new Record(x, head.minimum > x ? x : head.minimum);
      record.next = head;
      head = record;
    }
  }

  public void pop() {
    if(head != null){
      head = head.next;
    }
  }

  public int top() {
    int element = Integer.MIN_VALUE;
    if(head != null){
      element = head.val;
    }

    return element;
  }

  public int getMin() {
    int element = Integer.MIN_VALUE;
    if(head != null){
      element = head.minimum;
    }

    return element;
  }

  public static void main(String[] args) {

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}
