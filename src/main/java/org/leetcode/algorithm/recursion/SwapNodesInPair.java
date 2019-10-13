package org.leetcode.algorithm.recursion;

public class SwapNodesInPair {

  public ListNode swapPairs(ListNode head) {

    //recursive solution
    if(head == null){
      return head;
    }

    //reverse the pair
    ListNode pointerToNextIteration  = null ;
    ListNode temp = null;
    if(head.next != null){
      pointerToNextIteration = head.next.next;
      temp = head.next;
      head.next.next = head;
    }

    ListNode recNodePointer = swapPairs(pointerToNextIteration);
    head.next = recNodePointer;

    return temp == null ? head : temp;

  }
}
