package org.leetcode.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

  public List<Integer> getRow(int rowIndex) {

    List<Integer> result = new ArrayList<>();

    if(rowIndex >= 0 ){
      int[][] cache = new int[rowIndex+1][rowIndex+1];
      for(int j = 0 ; j <= rowIndex ; j++ ){
        result.add(computeElement(rowIndex,j, cache));
      }
    }

    return result;
  }

  private int computeElement(int i , int j , int[][] cache){
    int element;

    if(cache[i][j] != 0){
      return cache[i][j];
    }

    if(j == 0 || j == i){
      element = 1;
    }else{
      element = computeElement(i-1, j-1, cache) + computeElement(i-1, j, cache);
    }

    cache[i][j] = element;
    return element;
  }

  public static void main(String[] args) {
    PascalsTriangleII engine = new PascalsTriangleII();

    List<Integer> row = engine.getRow(4);
    System.out.println(row);
  }

}
