package org.interviewbit.sorting.contract.implementation;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import org.interviewbit.sorting.contract.Sorter;

public class QuickSorter implements Sorter {

  @Override
  public <T extends Comparable<? super T>> void sort(List<T> list) {
    Object[] objects = list.toArray();

    //shuffle the array
    shuffle(objects);

    //quick sort the array
    quickSort(objects, 0, objects.length - 1);

    ListIterator<T> listIterator = list.listIterator();
    for(Object aObj : objects){
      listIterator.next();
      listIterator.set((T)aObj);
    }
  }

  private void quickSort(Object[] array, int leftIndex, int rightIndex) {
    if (rightIndex <= leftIndex) {
      return;
    }

    int pivotIndex = findPivot(array, leftIndex, rightIndex);
    quickSort(array, leftIndex, pivotIndex - 1);
    quickSort(array, pivotIndex + 1, rightIndex);
  }

  private int findPivot(Object[] array, int leftIndex, int rightIndex) {

    Object pivot = array[leftIndex];
    int leftPtr = leftIndex;
    int rightPtr = rightIndex + 1;

    while (true) {
      while (isLess((Comparable) array[++leftPtr], (Comparable) pivot)) {
        if (leftPtr == rightIndex) {
          break;
        }
      }

      while (isLess((Comparable) pivot, (Comparable) array[--rightPtr])) {
        if (rightPtr == leftIndex) {
          break;
        }
      }

      if (rightPtr <= leftPtr) {
        break;
      }
      swap(array, leftPtr, rightPtr);
    }
    swap(array, leftIndex, rightPtr);
    return rightPtr;
  }

  private boolean isLess(Comparable first, Comparable second) {

    if (first.compareTo(second) < 0) {
      return true;
    }
    else {
      return false;
    }
  }

  private void shuffle(Object[] objects) {

    Random random = new Random();

    for (int i = objects.length - 1; i > 0; i--) {
      int randomIndex = random.nextInt(i + 1);
      swap(objects, randomIndex, i);
    }
  }

  private void swap(Object[] objects, int source, int destination) {

    Object temp = objects[source];
    objects[source] = objects[destination];
    objects[destination] = temp;
  }
}
