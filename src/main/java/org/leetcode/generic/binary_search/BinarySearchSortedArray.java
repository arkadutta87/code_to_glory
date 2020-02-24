package org.leetcode.generic.binary_search;

import java.util.Objects;

public class BinarySearchSortedArray {

  public int search(int[] nums, int target){
    int index = -1;
    if(Objects.nonNull(nums) && nums.length > 0 ){
      index =  binarySearch(nums, target, 0, nums.length-1);
    }
    return index;
  }

  private int binarySearch(int[] nums, int target, int left , int right){
    int mid = left + ((right - left) / 2);
    if(nums[mid] == target){
      return mid;
    }else if(target < nums[mid]){
      if(mid == left){
        return -1;
      }
      return binarySearch(nums, target, left, mid-1);
    }else{
      if(mid == right){
        return -1;
      }
      return binarySearch(nums, target, mid+1 , right);
    }
  }

}
