package org.leetcode.google.linked_list;

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode temp = null;

    int carryOver = 0;
    while(l1 != null && l2 != null){
      int sum = l1.val + l2.val + carryOver;
      if(sum > 9){
        carryOver = sum /10;
        sum = sum % 10;
      }else{
        carryOver = 0;
      }

      ListNode node = new ListNode(sum);
      if(head == null){
        head = node;
        temp = head;
      }else{
        temp.next = node;
        temp = temp.next;
      }

      l1 = l1.next;
      l2 = l2.next;
    }

    while(l1 != null){
      int sum = l1.val + carryOver;
      if(sum > 9){
        carryOver = sum /10;
        sum = sum % 10;
      }else{
        carryOver = 0;
      }

      ListNode node = new ListNode(sum);
      temp.next = node;
      temp = temp.next;

      l1 = l1.next;
    }

    while(l2 != null){
      int sum = l2.val + carryOver;
      if(sum > 9){
        carryOver = sum /10;
        sum = sum % 10;
      }else{
        carryOver = 0;
      }

      ListNode node = new ListNode(sum);
      temp.next = node;
      temp = temp.next;

      l2 = l2.next;
    }

    if(carryOver > 0){
      temp.next = new ListNode(carryOver);
    }


    return head;


  }
}
