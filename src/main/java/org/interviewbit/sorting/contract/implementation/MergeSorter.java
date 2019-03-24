package org.interviewbit.sorting.contract.implementation;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import org.interviewbit.sorting.contract.Sorter;

public class MergeSorter implements Sorter {

  public <T extends Comparable<? super T>> void sort(List<T> list) {
    Object[] objects = list.toArray();

    mergeSort(objects, 0, objects.length - 1);

    ListIterator<T> iterator = list.listIterator();
    for (Object a : objects) {
      iterator.next();
      iterator.set((T) a);
    }
  }

  private void mergeSort(Object[] array, int start, int end) {

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

  private void merge(Object[] array, int start, int mid, int end) {

    int left = start;
    int right = mid + 1;

    Object[] tempArray = new Object[end - start + 1];
    int count = 0;
    while (left <= mid
        && right <= end) {

      Object rightEle = array[left];
      int comparisonValue = ((Comparable) rightEle).compareTo(array[right]);

      if (comparisonValue < 0) {
        tempArray[count++] = array[left++];
      }
      else {
        tempArray[count++] = array[right++];
      }
    }

    //remaining of left array
    while(left <= mid){
      tempArray[count++] = array[left++];
    }

    //remaining of right array
    while(right <= end){
      tempArray[count++] = array[right++];
    }

    for(int i = 0 ; i < tempArray.length; ){
      array[start++] = tempArray[i++];
    }

  }
}
