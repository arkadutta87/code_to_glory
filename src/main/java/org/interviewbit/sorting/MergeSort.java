package org.interviewbit.sorting;

public class MergeSort {

  public static void main(String[] args) {

    int[] array = {7, 2, 1, 6, 8, 5, 3, 4, 7 , 11, 9, 55, 99, 89};

    MergeSort sorter = new MergeSort();
    sorter.sort(array);

    System.out.println("Sorted Array --> ");
    for (int a : array) {
      System.out.print(" " + a);
    }

  }

  public void sort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  private void merge(int[] array, int start, int mid, int end) {

    int left = start;
    int right = mid + 1;

    int[] tempArray = new int[end - start + 1];

    int count = 0;
    while ((left <= mid)
        && (right <= end)) {

      if (array[left] < array[right]) {
        tempArray[count++] = array[left++];
      }
      else {
        tempArray[count++] = array[right++];
      }

    }

    //remaining of the left array
    while (left <= mid) {
      tempArray[count++] = array[left++];
    }

    //remaining of the right array
    while (right <= end) {
      tempArray[count++] = array[right++];
    }

    for (int i = 0; i < tempArray.length; i++) {
      array[start++] = tempArray[i];
    }

  }

  private void mergeSort(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    else {
      int mid = (start + end) / 2;
      mergeSort(array, start, mid);
      mergeSort(array, mid + 1, end);
      merge(array, start, mid, end);
    }

  }

}
