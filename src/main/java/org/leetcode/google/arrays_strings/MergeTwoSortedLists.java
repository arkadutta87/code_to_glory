package org.leetcode.google.arrays_strings;

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode head = null;
    ListNode temp = null;

    while(l1 != null && l2 != null){
      if(head == null){
        if(l1.val < l2.val){
          head = l1;
          temp = head;
          l1 = l1.next;
        }else{
          head = l2;
          temp = head;
          l2 = l2.next;
        }
      }else{
        if(l1.val < l2.val){
          temp.next = l1;
          l1 = l1.next;
          temp = temp.next;
        }else{
          temp.next = l2;
          l2 = l2.next;
          temp = temp.next;
        }
      }

    }

    if(l1 != null){
      if(head == null){
        head = l1;
      }else{
        temp.next = l1;
      }
    }

    if(l2 != null){
      if(head == null){
        head = l2;
      }else{
        temp.next = l2;
      }
    }

    return head;
  }
}
