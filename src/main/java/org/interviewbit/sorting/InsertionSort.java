package org.interviewbit.sorting;

import java.util.Collections;

public class InsertionSort {

  public static void main(String[] args) {

    int[] array = {7, 2, 1, 6, 8, 5, 3, 4, 7};

    Integer integer = new Integer(10);
    InsertionSort sortAlgo = new InsertionSort();
    sortAlgo.sort(array);

    System.out.println("The Sorted Array --> ");
    for(int a : array){
      System.out.print(" " + a);
    }

  }

  public void sort(int[] array) {

    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int hole = i - 1;

      while (hole >= 0 && array[hole] > key) {
        array[hole + 1] = array[hole];
        hole--;
      }
      array[hole + 1] = key;
    }

  }
}
