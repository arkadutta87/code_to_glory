package org.leetcode.design;

public class MaxStack {

  class Record {

    int val;
    int maximum;

    Record next;

    public Record(int val, int maximum) {
      this.val = val;
      this.maximum = maximum;
    }
  }

  private Record head;

  public MaxStack() {

  }

  public void push(int x) {
    if (head == null) {
      Record record = new Record(x, x);
      head = record;
    }
    else {
      Record record = new Record(x, head.maximum < x ? x : head.maximum);
      record.next = head;
      head = record;
    }
  }

  public int pop() {
    int element = Integer.MIN_VALUE;
    if (head != null) {
      element = head.val;
      head = head.next;
    }

    return element;
  }

  public int top() {
    int element = Integer.MIN_VALUE;
    if (head != null) {
      element = head.val;
    }

    return element;
  }

  public int peekMax() {
    int element = Integer.MIN_VALUE;
    if (head != null) {
      element = head.maximum;
    }

    return element;
  }

}
