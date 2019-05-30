package org.dynamic_programming;

public class MaxSumSubArrayV2 {

  public static void main(String[] args) {

    int[] elements = new int[]{904, 40, 523, 12, -335, -385, -124, 481, -31};
    System.out.println(new MaxSumSubArrayV2().findMaxSubArray(elements));
  }

  private int findMaxSubArray(int[] elements) {

    int minSum = 0, sum = 0, maxSum = 0;

    for (int aVal : elements) {
      sum += aVal;
      minSum = Math.min(minSum, sum);
      maxSum = Math.max(maxSum, (sum - minSum));
    }

    return maxSum;

  }
}
