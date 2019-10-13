package org.leetcode.google.linked_list;

public class RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode p1 = head;
    ListNode p2 = head;

    int lengthOfLinkedList = 0;

    while(p2 != null){
      lengthOfLinkedList +=1;
      p2 = p2.next;
    }

    if(n  == lengthOfLinkedList){
      return head.next;
    }


    int moves = lengthOfLinkedList - (n+1);
    for(int i = 0 ; i < moves ; i++){
      p1 = p1.next;
    }

    p1.next = p1.next.next;

    return head;

  }
}
