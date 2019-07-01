package org.interviewbit.sorting;

/*
This is the basic quick sort where the elements provided
have been passed through a function to randomize the order

As quick sort - This is not balanced
 */

import java.util.Random;

public class QuickSortV1 {

  public static void main(String[] args) {
    QuickSortV1 sorter = new QuickSortV1();
//    int[] array = {1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11};
//    int[] array = {16, 15, 1, 13, 4, 3, 2, 12, 6, 11, 14, 5};
//    int[] array = {2, 2, 3, 5, 2, 3, 2, 3};
    int[] array = {2};

    sorter.sort(array);
    System.out.println("The Sorted Array : ->");

    for (int a : array) {
      System.out.print(a + " ");
    }
  }

  private void sort(int[] array) {
    //randomize the array
    shuffleTheArray(array);

    //call the recursive quick sort method
    quickSort(array, 0, array.length - 1);
  }

  private void quickSort(int[] array, int leftIndex, int rightIndex) {
    if (rightIndex <= leftIndex) {
      return;
    }

    int pivotPosition = findPivot(array, leftIndex, rightIndex);
    quickSort(array, leftIndex, pivotPosition - 1);
    quickSort(array, pivotPosition + 1, rightIndex);

  }

  private int findPivot(int[] array, int leftIndex, int rightIndex) {
    //select the leftIndex to be the pivotElement starter
    int pivot = array[leftIndex];

    int leftPtr = leftIndex;
    int rightPtr = rightIndex + 1;

    while (true) {
      while (isLess(array[++leftPtr], pivot)) {
        if (leftPtr == rightIndex) {
          break;
        }
      }
      while (isLess(pivot, array[--rightPtr])) {
        if (rightPtr == leftIndex) {
          break;
        }
      }

      if (leftPtr >= rightPtr) {
        break;
      }
      //swap right and left pointer elements
      int temp = array[leftPtr];
      array[leftPtr] = array[rightPtr];
      array[rightPtr] = temp;

    }

    //swap the rigth pointer with the left pivot element
    array[leftIndex] = array[rightPtr];
    array[rightPtr] = pivot;

    return rightPtr;
  }

  private boolean isLess(int a, int b) {
    return a < b;
  }

  private void shuffleTheArray(int[] array) {

    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      int randomIndex = random.nextInt(i + 1);

      int temp = array[randomIndex];
      array[randomIndex] = array[i];
      array[i] = temp;
    }
  }
}
