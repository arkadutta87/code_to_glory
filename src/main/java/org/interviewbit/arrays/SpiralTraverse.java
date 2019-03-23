package org.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
  /*
  solution to the problem : https://www.interviewbit.com/problems/spiral-order-matrix-i/
   */

  public static void main(String[] args) {

    List<ArrayList<Integer>> matrix = new ArrayList<>();

    int[][] matrixArray = {{252, 60, 110, 389}, {311, 84, 264, 305}, {203, 118, 376, 90}, {37, 55, 223, 153},
                           {234, 335, 52, 263},
                           {207, 350, 272, 233},
                           {140, 327, 125, 168}};

    for (int[] arr : matrixArray) {
      ArrayList<Integer> aRow = new ArrayList<>();
      for (int aElement : arr) {
        aRow.add(aElement);
      }

      matrix.add(aRow);
    }

    ArrayList<Integer> integers = theSpiralTraverse(matrix);
    for (Integer aVal : integers) {
      System.out.println(" " + aVal);
    }

  }

  private static ArrayList<Integer> theSpiralTraverse(List<ArrayList<Integer>> A) {

    int row = A.size();
    int column = A.get(0).size();

    int[][] array = new int[row][column];
    int i = 0, j = 0;
    for (ArrayList<Integer> list : A) {
      j = 0;
      for (Integer no : list) {
        array[i][j++] = no;
      }
      ++i;
    }

    //Traversing spirally
    int round = 0;
    int totalElements = row * column;

    ArrayList<Integer> result = new ArrayList<>();
    int rowIndex = 0, columnIndex = -1;
    boolean flag = true;
    int direction = 0;
    while (result.size() < totalElements) {
      int element;
      if ((rowIndex == round)
          && (direction == 0)) {
        direction = 0;
        columnIndex++;
        if (columnIndex == (column - round - 1)) {
          direction = 1;
        }
        flag = false;
      }
      else if ((columnIndex == (column - round - 1)) && (direction == 1)) {
        rowIndex++;
        direction = 1;
        if ((rowIndex == (row - round - 1))) {
          direction = 2;
        }
      }
      else if ((rowIndex == (row - round - 1))
          && (direction == 2)) {
        columnIndex--;
        direction = 2;
        if ((columnIndex == round)) {
          direction = 3;
        }
      }
      else {
        direction = 0;
        if (!flag) {
          round++;
          flag = true;
        }
        rowIndex--;
      }

      element = array[rowIndex][columnIndex];
      result.add(element);

    }

    return result;
  }
}
