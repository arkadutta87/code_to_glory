package org.leetcode.google.arrays_strings;

import java.util.Objects;

public class MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {

    if(Objects.isNull(lists) ||
        lists.length == 0){
      return null;
    }

    ListNode newHeader = null;
    ListNode currentNode = null;

    int index  = findMinimumValIndex(lists);
    while(index != -1){
      ListNode newNode = new ListNode(lists[index].val);
      if(newHeader == null){
        newHeader = newNode;
        currentNode = newHeader;
      }else{
        currentNode.next = newNode;
        currentNode = currentNode.next;
      }

      //increment the pointer of the list whose value was added
      lists[index] = lists[index].next;

      //next iteration
      index  = findMinimumValIndex(lists);
    }

    return newHeader;

  }

  private int findMinimumValIndex(ListNode[] lists){
    int[] val = new int[lists.length];
    //intialise this array Integer.MIN_VALUE
    for(int i = 0 ; i < val.length ; i ++){
      val[i] = Integer.MAX_VALUE;
    }

    //can remove this part of the code - This is unnecessary
    for(int i = 0 ;i < lists.length ; i++){
      if(lists[i] != null){
        val[i] = lists[i].val;
      }
    }

    int min = val[0];

    int index = 0;

    for(int i = 1; i < val.length ; i++){
      if(min > val[i]){
        index  = i;
        min = val[i];
      }
    }

    if(min == Integer.MAX_VALUE){
      return -1;
    }

    return index;
  }
}
