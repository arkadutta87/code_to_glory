package org.interviewbit.sorting.contract.implementation;

import java.util.List;
import java.util.ListIterator;

import org.interviewbit.sorting.contract.Sorter;

public class InsertionSorter implements Sorter {

  public <T extends Comparable<? super T>> void sort(List<T> list) {
    int size = list.size();
    Object[] objects = list.toArray();

    for (int i = 1; i < size; i++) {
      int hole = i - 1;
      Object key = objects[i];

      while (hole >= 0) {
        Object ele = objects[hole];
        int comparisonValue = ((Comparable) ele).compareTo(key);

        if (comparisonValue <= 0) {
          break;
        }
        else {
          objects[hole + 1] = objects[hole];
          hole--;
        }
      }

      objects[hole + 1] = key;
    }

    ListIterator<T> iterator = list.listIterator();
    for (Object a : objects) {
      iterator.next();
      iterator.set((T) a);
    }

  }
}
