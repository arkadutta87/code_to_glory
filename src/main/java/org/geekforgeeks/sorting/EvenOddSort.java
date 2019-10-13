package org.geekforgeeks.sorting;

public class EvenOddSort {

  public static void main(String[] args) {
//    int[] array = {12, 34, 45, 9, 8, 90, 3};
    int[] array = {0, 1, 2, 3, 4};
    EvenOddSort sorter = new EvenOddSort();
    sorter.sort(array);

    for(int a : array){
      System.out.print(a + " " );
    }
  }

  public void sort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  private void mergeSort(int[] array, int start, int end) {

    if (end <= start) {
      return;
    }
    else {
      int mid = (start + end) / 2;
      mergeSort(array, start, mid);
      mergeSort(array, mid + 1, end);

      merge(array, start, mid, end);
    }

  }

  private void merge(int[] array, int start, int mid, int end) {
    int[] tempArray = new int[(end - start) + 1];

    int i = 0;
    int ptr1 = start;
    int ptr2 = mid + 1;
    while ((ptr1 <= mid) && (ptr2 <= end)) {
      int element1 = array[ptr1];
      int element2 = array[ptr2];

      boolean isEvenFirst = isEven(element1);
      boolean isEvenSecond = isEven(element2);

      if (isEvenFirst == isEvenSecond) {
        if (element1 < element2) {
          tempArray[i++] = array[ptr1++];
        }
        else {
          tempArray[i++] = array[ptr2++];
        }
      }
      else {
        if (isEvenFirst) {
          tempArray[i++] = array[ptr1++];
        }
        else {
          tempArray[i++] = array[ptr2++];
        }
      }
    }

    while (ptr1 <= mid) {
      tempArray[i++] = array[ptr1++];
    }

    while (ptr2 <= end) {
      tempArray[i++] = array[ptr2++];
    }

    for (int ele : tempArray) {
      array[start++] = ele;
    }
  }

  private boolean isEven(int ele) {
    return (ele % 2 == 0) ? true : false;
  }
}
