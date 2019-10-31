package org.leetcode.facebook.arrays_strings;

public class ProductArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {

    int[] result = new int[nums.length];

    //initialize all elements with value 1
    for (int i = 0; i < result.length; i++) {
      result[i] = 1;
    }

    //set the left part multiplication
    for (int i = 1; i < result.length; i++) {
      result[i] = result[i-1] * nums[i-1];
    }

    //now build the actual one by traversing from right
    int rightPart = 1;
    for(int i = nums.length-2; i >= 0 ; i--){
      rightPart = rightPart * nums[i +1];
      result[i] = result[i] * rightPart;
    }

    return result;

  }

  public static void main(String[] args) {
    ProductArrayExceptSelf executor = new ProductArrayExceptSelf();

    int[] result = executor.productExceptSelf(new int[]{1,2,3,4,5,6});
    executor.printArray(result);
  }

  private void printArray(int[] arr){
    System.out.println("***********************");
    for(int a : arr){
      System.out.print(a + " ");
    }
    System.out.println("\n***********************");
  }
}
