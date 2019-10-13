package org.leetcode.algorithm.recursion;

public class LinkedListReversal {

  public ListNode reverseList(ListNode head) {

    if (head == null ||
        head.next == null) {
      return head;
    }

    ListNode recHead = reverseList(head.next);

    head.next.next = head;
    head.next = null;

    return recHead;

  }
}
