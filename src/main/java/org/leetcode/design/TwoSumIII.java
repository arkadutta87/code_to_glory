package org.leetcode.design;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIII {

  private List<Integer> dataStore;

  public TwoSumIII() {
    dataStore = new ArrayList<>();
  }

  /**
   * Add the number to an internal data structure..
   */
  //Time Complexity - O(1)
  public void add(int number) {
    if (dataStore.size() == 0) {
      dataStore.add(number);
    }
    else {
      int index = findIndex(0, dataStore.size() - 1, number);
      dataStore.add(index, number);
    }
  }

  private int findIndex(int left, int right, int value) {
    if (value < dataStore.get(left)) {
      return left;
    }
    else if (value > dataStore.get(right)) {
      return right + 1;
    }
    else {
      int mid = (left + right) / 2;
      int midVal = dataStore.get(mid);
      if (value == midVal) {
        return mid;
      }
      else if (value < midVal) {
        return findIndex(left, mid - 1, value);
      }
      else {
        return findIndex(mid + 1, right, value);
      }
    }
  }

  public static void main(String[] args) {
    TwoSumIII engine = new TwoSumIII();
    engine.add(10);
    engine.add(5);
    engine.add(15);

    engine.add(12);
    engine.add(1);
    engine.add(1);

    System.out.println(engine.find(13));
    System.out.println(engine.find(16));
    System.out.println(engine.find(22));
    System.out.println(engine.find(23));
    System.out.println(engine.find(2));


  }

  /**
   * Find if there exists any pair of numbers which sum is equal to the value.
   */
  //Time Complexity - O(n)
  public boolean find(int value) {

    if (dataStore.size() <= 1) {
      return false;
    }

    int left = 0;
    int right = dataStore.size() - 1;

    while (left < right) {
      int lVal = dataStore.get(left);
      int rVal = dataStore.get(right);

      if (lVal + rVal > value) {
        right--;
      }
      else if (lVal + rVal < value) {
        left++;
      }else{
        return true;
      }
    }

    return false;
  }
}
