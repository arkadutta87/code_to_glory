package org.leetcode.generic.binary_search;

public class SquareRoot {

  public int mySqrt(int x) {
    int result = 2;

    if (x <= 1) {
      return x;
    }else if(x <= 3){
      return 1;
    }

    int left = 2;
    int right = x / 2;
    int lastSmallest = result;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int divisor = x / mid;

      if(mid == divisor){
        return mid;
      }else if(mid < divisor){
        lastSmallest = mid;
        left = mid +1;
      }else{
        right = mid -1;
      }
    }

    if (left == right) {
      int divisor = x / left;
      if (left <= divisor) {
        return left;
      }
    }
    return lastSmallest;
  }

  public static void main(String[] args) {
    SquareRoot sqrt = new SquareRoot();
    System.out.println(sqrt.mySqrt(2147395599));
  }
}
