package org.leetcode.google.arrays_strings;

public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int indexLeft = 0;
    int indexRight = height.length - 1;

    int maxArea = Math.min(height[indexLeft] , height[indexRight] ) * (indexRight - indexLeft);

    while(indexLeft < indexRight){
      if(height[indexLeft] < height[indexRight]){
        indexLeft++;
      }else{
        indexRight--;
      }
      maxArea = Math.max(maxArea, Math.min(height[indexLeft] , height[indexRight] ) * (indexRight - indexLeft));
    }

    return maxArea;
  }
}
