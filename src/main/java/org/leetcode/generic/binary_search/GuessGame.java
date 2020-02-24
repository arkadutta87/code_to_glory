package org.leetcode.generic.binary_search;

public class GuessGame {

  public int guessNumber(int n) {
    int left = 1;
    int right = n;

    while(left < right){
      int mid = left + (right - left) /2;
      int guess = guess(mid);
      if( guess== 0){
        return mid;
      }else if(guess < 0){
        right = mid-1;
      }else{
        left = mid +1;
      }
    }

    return guess(left) == 0 ? left : guess(left);
  }

  private int guess(int n){
    return -1;
  }
}
