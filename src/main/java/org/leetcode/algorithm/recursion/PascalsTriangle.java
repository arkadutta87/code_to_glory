package org.leetcode.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    if (numRows > 0) {
      int[][] cache = new int[numRows][numRows];
      for(int i = 1 ; i <= numRows ; i++ ) {
        List<Integer> innerList = new ArrayList<>();
        for(int j = 1 ; j <= i ; j++ ){
          innerList.add(findElement(i,j, cache));
        }
        result.add(innerList);
      }
    }

    return result;
  }

  private int findElement(int i , int j, int[][] cache){

    if(cache[i-1][j-1] != 0 ){
      return cache[i-1][j-1];
    }

    int element ;
    if(j == 1 ||
        j == i ){

      element = 1;
    }else{
      element = findElement(i-1 , j-1, cache) + findElement(i-1,j, cache);
    }

    cache[i-1][j-1] = element;
    return element;
  }

  public static void main(String[] args) {
    PascalsTriangle pascalsTriangle = new PascalsTriangle();
    List<List<Integer>> generate = pascalsTriangle.generate(6);
  }
}
